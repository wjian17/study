package org.company.forward.study.other.util.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.company.forward.domain.annotation.EnableCuratorZkLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
@Aspect
@Component
public class ZookeeperLockAspect {

	Logger logger = LoggerFactory.getLogger(ZookeeperLockAspect.class);

	private static final String REG_PARAM_PATTERN = "#p[0-9]+";

	private static final String LOCK_ROOT_PATH = "/lock";


	@Autowired
	private CuratorFramework curatorFramework;

	@Pointcut(value = "(execution(* org.company.forward.study..*(..)) && "//截获标有@ZookeeperLock的方法
			+ "@annotation(org.company.forward.domain.annotation.EnableCuratorZkLock))")
	private void pointcut() {
	}

	@Around(value = "pointcut()")//切面在方法返回值之后
	private Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Object[] args = joinPoint.getArgs();//切面方法的参数
		Method method = signature.getMethod();//切面方法
		EnableCuratorZkLock enableCuratorZkLock = method.getAnnotation(EnableCuratorZkLock.class);//获得注解
		String value = enableCuratorZkLock.value();
		String lockKey = parseKey(value, method, args);
		InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework,LOCK_ROOT_PATH+lockKey);
		boolean bool = interProcessMutex.acquire(enableCuratorZkLock.time(), enableCuratorZkLock.timeUnit());
		Object proceed = joinPoint.proceed();
		interProcessMutex.release();
		return proceed;
	}

	/**
	 * key 定义在注解上，支持SPEL表达式
	 * @param key
	 * @param method
	 * @param args
	 * @return
	 */
	private String parseKey(String key, Method method, Object[] args) {
		//获取被拦截方法参数名列表(使用Spring支持类库)
		LocalVariableTableParameterNameDiscoverer u =
				new LocalVariableTableParameterNameDiscoverer();
		String[] paraNameArr = u.getParameterNames(method);
		//使用SPEL进行key的解析
		ExpressionParser parser = new SpelExpressionParser();
		//SPEL上下文
		StandardEvaluationContext context = new StandardEvaluationContext();
		//把方法参数放入SPEL上下文中
		for (int i = 0; i < paraNameArr.length; i++) {
			context.setVariable(paraNameArr[i], args[i]);
		}
		List<String> pList = descFormat(key);//获取#p0这样的表达式
		//将p0作为参数放入SPEL上下文中
		for (String p : pList) {
			context.setVariable(p.substring(1), args[Integer.valueOf(p.substring(2))]);
		}
		return parser.parseExpression(key).getValue(context, String.class);
	}

	/**
	 * 提取出#p[数字]这样的表达式
	 *
	 * @param desc
	 * @return
	 */
	private static List<String> descFormat(String desc) {
		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile(REG_PARAM_PATTERN);
		Matcher matcher = pattern.matcher(desc);
		while (matcher.find()) {
			String t = matcher.group(0);
			list.add(t);
		}
		return list;
	}
}