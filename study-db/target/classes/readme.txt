DynamicDataSource：动态数据源切换；
DynamicDataSourceAspect：利用AOP切面实现数据源的动态切换；
DynamicDataSourceContextHolder：动态切换数据源；
DynamicDataSourceRegister：动态数据源注册；
TargetDataSource：在方法上使用，用于指定使用哪个数据源。


配置

spring:
  jpa:
    show-sql: true
  datasource:
    hikari:
      maxLifetime: 1765000 #一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒以上
      maximumPoolSize: 15
      #连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
      idleTimeout: 600000
        #connectionTimeout: 30000 #等待来自池的连接的最大毫秒数。如果在没有可用连接的情况下超过此时间，则会抛出SQLException。最低可接受的连接超时时间为250 ms。 默认值：30000（30秒）
        #允许连接在池中闲置的最长时间。 此设置仅适用于minimumIdle定义为小于maximumPoolSize。一旦池达到连接，空闲连接将不会退出minimumIdle。连接是否因闲置而退出，最大变化量为+30秒
        #平均变化量为+15秒。在超时之前，连接永远不会退出。值为0意味着空闲连接永远不会从池中删除。允许的最小值是10000ms（10秒）。 默认值：600000（10分钟）
        #自动提交行为。它是一个布尔值。 默认值：true
        #autoCommit: true
      master:
        url: jdbc:mysql://localhost:3306/zxyh?characterEncoding=utf8&useSSL=true&serverTimezone=UTC
        username: root
        password: root
        driverClassName: com.mysql.cj.jdbc.Driver
      salver:
        url: jdbc:mysql://localhost:3306/zxyh?characterEncoding=utf8&useSSL=true&serverTimezone=UTC
        username: root
        password: root
        driverClassName: com.mysql.cj.jdbc.Driver