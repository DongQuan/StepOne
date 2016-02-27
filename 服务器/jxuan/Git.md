####Git

1. 每次 Push 的时候如何不用输入密码？

        可以有2个办法：
        
        针对 SSH 协议的方式， 配置SSH 公钥，使用 SSH 协议操作，具体见 SSH 公钥配置
        对于 Https 协议
        首先在全局配置保存你的密码， ~/.git-credentials （没有就创建）内添加 https://{username}:{passwd}@git.coding.net
        然后配置 Git 命令存储认证，
        $git config --global credential.helper store
        ~/.gitconfig 文件多出下面配置项: credential.helper = store