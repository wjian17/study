package org.company.forward.study.feignserver.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ClassForJarInstallImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                "org.company.forward.study.other.util.redis.RedisCacheConfig",
                "org.company.forward.study.other.util.redis.RedisConfig",
                "org.company.forward.study.other.util.zookeeper.CuratorZkConfig",
                "org.company.forward.study.other.util.zookeeper.ZookeeperLockAspect"
        };
    }
}