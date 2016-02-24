####Tomcat配置

1. 命令：
        
        service tomcat7 start
        service tomcat7 stop
        service tomcat7 restart
        
2. Tomcat部署去掉工程名：
        
        tomcat的server.xml中的一个<Host>标签中加一句<Context>，docBase写你的项目名称就行了。端口用80端口就可以隐藏端口了
        
         <Host name="localhost"  appBase="webapps"
        
                    unpackWARs="true" autoDeploy="true"
        
                    xmlValidation="false" xmlNamespaceAware="false">
        
        <Context path="" docBase="prjName" debug="0" reloadable="true"/>
        
        </Host>
        
