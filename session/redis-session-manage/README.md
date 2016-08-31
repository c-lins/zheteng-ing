###[ Session共享 -- 基于Redis缓存 ](#)
第一种：tomcat配置
包放Tomcat的lib子目录下，并在修改每一个Tomcat的context.xml配置文件：

    <Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />
    <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"
    host="10.6.82.206"
    port="6379"
    maxInactiveInterval="1800"/>

nginx 配置

    location /项目名/ {
    proxy_cookie_path  /项目名/        /;
    proxy_set_header Host                     $host;   
    proxy_set_header X-Real-IP             $remote_addr;
    proxy_set_header X-Forwarded-For        $proxy_add_x_forwarded_for;
    }
