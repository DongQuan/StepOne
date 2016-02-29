####Tomcat持续集成

1. ubuntu 12.04中安装Jenkins

        安装：
            wget -q -O - http://pkg.jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -  
            sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian binary/ > /etc/apt/sources.list.d/jenkins.list'  
            sudo apt-get update  
            sudo apt-get install jenkins  
            
        启动/关闭：
            sudo /etc/init.d/jenkins start  
            sudo /etc/init.d/jenkins stop  
            
        访问：
            http://192.168.1.6:8080/  
            
2.jenkins配置构建触发器:
        
        构建触发器
        Poll SCM：定时检查源码变更（根据SCM软件的版本号），如果有更新就checkout最新code下来，然后执行构建动作。我的配置如下：
        
        */5 * * * *  （每5分钟检查一次源码变化）
        
3. 搭建jenkins实现自动化部署:[原文链接][1]

4. 构建脚本示例：

        cd /var/lib/jenkins/jobs/graduate_websit/workspace
        mvn clean package
        cd /var/lib/jenkins/jobs/graduate_websit/workspace/target
        mv graduate_website-1.0-SNAPSHOT.war graduate_websit.war
        cd /opt/tomcat7/webapps
        service tomcat7 stop
        if [  -d "/opt/tomcat7/webapps/graduate_websit/WEB-INF" ]; then  
        sudo rm -r /opt/tomcat7/webapps/graduate_websit/WEB-INF
        fi
        if [  -d "/opt/tomcat7/webapps/graduate_websit/js" ]; then  
        sudo rm -r /opt/tomcat7/webapps/graduate_websit/js
        fi
        if [  -d "/opt/tomcat7/webapps/graduate_websit/pages" ]; then  
        sudo rm -r /opt/tomcat7/webapps/graduate_websit/pages
        fi
        if [  -d "/opt/tomcat7/webapps/graduate_websit/css" ]; then  
        sudo rm -r /opt/tomcat7/webapps/graduate_websit/css
        fi
        if [  -d "/opt/tomcat7/webapps/graduate_websit/image" ]; then  
        sudo rm -r /opt/tomcat7/webapps/graduate_websit/image
        fi
        sudo mv -f  /var/lib/jenkins/jobs/graduate_websit/workspace/target/graduate_websit.war /opt/tomcat7/webapps
        sudo unzip -n graduate_websit.war -d graduate_websit
        service tomcat7 start

[1]: http://huaoguo.com/work/2014/09/04/%E6%90%AD%E5%BB%BAjenkins%E5%AE%9E%E7%8E%B0%E8%87%AA%E5%8A%A8%E5%8C%96%E9%83%A8%E7%BD%B2.html