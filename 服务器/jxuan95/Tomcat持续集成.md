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