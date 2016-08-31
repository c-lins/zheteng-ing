###[ Session共享 -- 提供了一套创建和管理Servlet HttpSession的方案 ](https://github.com/spring-projects/spring-session)
    编写可水平扩展的原生云应用。
    将session所保存的状态卸载到特定的外部session存储中，如Redis或Apache Geode中，它们能够以独立于应用服务器的方式提供高质量的集群。
    当用户使用WebSocket发送请求的时候，能够保持HttpSession处于活跃状态。
    在非Web请求的处理代码中，能够访问session数据，比如在JMS消息的处理代码中。
    支持每个浏览器上使用多个session，从而能够很容易地构建更加丰富的终端用户体验。
    控制session id如何在客户端和服务器之间进行交换，这样的话就能很容易地编写Restful API，因为它可以从HTTP 头信息中获取session id，而不必再依赖于cookie。

注意：1.依赖Spring的版本为4.1.6以上
      2.javax.servlet-api需要3.0.1版本以上
      
application.xml需添加的配置内容

    <context:annotation-config/>
    <bean class="org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration"/>  
    <bean id="redispoolConfig" class="redis.clients.jedis.JedisPoolConfig" />
    <bean id="redisconnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
		<property name="hostName" value="172.17.2.69" />
		<property name="port" value="6379" />
		<property name="poolConfig" ref="redispoolConfig"></property>
    </bean>


web.xml需添加的内容
    
    <filter> 
        <filter-name>springSessionRepositoryFilter</filter-name> 
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping> 
        <filter-name>springSessionRepositoryFilter</filter-name> 
        <url-pattern>/*</url-pattern> 
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>ERROR</dispatcher>
        <dispatcher>ASYNC</dispatcher>
    </filter-mapping>
    
具体参见：https://github.com/c-lins/training-spring-session