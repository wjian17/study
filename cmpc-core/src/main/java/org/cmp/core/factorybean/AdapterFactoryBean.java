package org.cmp.core.factorybean;

import cn.hutool.core.map.MapUtil;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;
import org.cmp.core.adapter.base.BasicAdapter;
import org.cmp.core.adapter.dto.DispatcherContext;
import org.cmp.core.annotation.AdapterMgr;
import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Objects;

/**
 * @author: wangjian
 * @date: 2021/12/29 9:26
 */
@Data
public class AdapterFactoryBean implements FactoryBean<Object>, ApplicationContextAware {
    /***********************************
     * WARNING! Nothing in this class should be @Autowired. It causes NPEs because of some
     * lifecycle race condition.
     ***********************************/

    private Class<?> interfaceClass;

    private ApplicationContext applicationContext;

    private Map<DispatcherContext, BasicAdapter> dispatcherContextBasicAdapterCache = MapUtil.newHashMap();

    @Override
    public Object getObject() throws Exception {
        return getTarget();
    }


    Object getTarget() {


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(interfaceClass);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // early exit if the invoked method is from java.lang.Object
                // code is the same as ReflectiveFeign.FeignInvocationHandler
                String methodName = method.getName();
                if ("equals".equals(methodName) || "hashCode".equals(methodName) || "toString".equals(methodName)) {
                    return method.invoke(methodProxy, objects);
                }
                DispatcherContext dispatcherContext = (DispatcherContext) objects[0];
                DispatcherContext keyDispatcher = new DispatcherContext();
                BeanUtils.copyProperties(dispatcherContext, keyDispatcher);
                if (!dispatcherContextBasicAdapterCache.containsKey(keyDispatcher)) {
                    Map<String, BasicAdapter> beans = applicationContext.getBeansOfType(BasicAdapter.class);
                    beans.values().stream().forEach(basicAdapter -> {
                        if (!Enhancer.isEnhanced(basicAdapter.getClass()) && basicAdapter.getDispatcherContext().equals(keyDispatcher)) {
                            dispatcherContextBasicAdapterCache.put(basicAdapter.getDispatcherContext(), basicAdapter);
                        }
                    });
                }
                BasicAdapter basicAdapter = dispatcherContextBasicAdapterCache.get(keyDispatcher);
                return method.invoke(basicAdapter, objects);
            }
        });
        return enhancer.create();
    }


    @Override
    public Class<?> getObjectType() {
        return this.interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
