####怎么解决Maven在使用过程中JVM溢出问题？

        sudo vim /etc/profile
        加入
        export MAVEN_OPTS=-Xms128m -Xmx512m