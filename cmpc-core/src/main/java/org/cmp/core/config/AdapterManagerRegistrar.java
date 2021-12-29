package org.cmp.core.config;

import org.cmp.core.annotation.AdapterMgr;
import org.cmp.core.annotation.EnableAdapterMgr;
import org.cmp.core.factorybean.AdapterFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangjian
 * @date: 2021/12/29 9:18
 */
public class AdapterManagerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {


    private ResourceLoader resourceLoader;

    private Environment environment;

    public AdapterManagerRegistrar() {
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata,
                                        BeanDefinitionRegistry registry) {
        registerAdapter(metadata, registry);
    }


    public void registerAdapter(AnnotationMetadata metadata,
                                BeanDefinitionRegistry registry) {
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);

        Set<String> basePackages;

        AnnotationTypeFilter filter = new AnnotationTypeFilter(AdapterMgr.class);
        scanner.addIncludeFilter(filter);
        basePackages = getBasePackages(metadata);

        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner
                    .findCandidateComponents(basePackage);
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    // verify annotated class is an interface
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    registerAdapterMgr(registry, annotationMetadata);
                }
            }
        }
    }

    private void registerAdapterMgr(BeanDefinitionRegistry registry,
                                    AnnotationMetadata annotationMetadata) {
        String className = annotationMetadata.getClassName();
        BeanDefinitionBuilder definition = BeanDefinitionBuilder
                .genericBeanDefinition(AdapterFactoryBean.class);
//        Map<String, BasicAdapter> beans = this.applicationContext.getBeansOfType(BasicAdapter.class);

//        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        definition.addPropertyValue("interfaceClass",className);
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();

        beanDefinition.setPrimary(true);

        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className+"Manager");
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
    }


    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(
                    AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata
                .getAnnotationAttributes(EnableAdapterMgr.class.getCanonicalName());

        Set<String> basePackages = new HashSet<>();

        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        if (basePackages.isEmpty()) {
            basePackages.add(
                    ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
