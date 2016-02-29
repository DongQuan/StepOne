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