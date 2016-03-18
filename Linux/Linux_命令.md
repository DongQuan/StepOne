###Linux常用

1. chmod


    a表示对所有用户
    u表示系主用户
    g表示同组用户
    o表示其他用户 


2. date
~$ 2016年 03月 15日 星期二 15:39:49 CST
3. cal
~$ 
      三月 2016         
日 一 二 三 四 五 六  
       1  2  3  4  5  
 6  7  8  9 10 11 12  
13 14 [15]() 16 17 18 19  
20 21 22 23 24 25 26  
27 28 29 30 31 

4. df 查看磁盘剩余空间的数量
文件系统       1K-blocks     已用     可用 已用% 挂载点
/dev/sda9       53181964 18634556 31822800   37% /
none                   4        0        4    0% /sys/fs/cgroup
udev             1836160        4  1836156    1% /dev
tmpfs             369156     1180   367976    1% /run
none                5120        0     5120    0% /run/lock
none             1845772    85500  1760272    5% /run/shm
none              102400     1276   101124    2% /run/user
/dev/sda8       41819132  8213384 33605748   20% /media/kong90/新加卷

5. free 显示空闲内存数量
6. exit 结束终端
7. ls —列出目录内容
8. file —确定文件类型
9. less —浏览文件内容
• cp —复制文件和目录
• mv —移动/重命名文件和目录
• mkdir —创建目录
• rm —删除文件和目录
• ln —创建硬链接和符号链接
• clear - Clear the screen
• history - Display the contents of the history list
• clear -清空屏幕
• history -显示历史列表内容
ps –报告当前进程快照
• top –显示任务
• jobs –列出活跃的任务
• bg –把一个任务放到后台执行
• fg –把一个任务放到前台执行
• kill –给一个进程发送信号
• killall –杀死指定名字的进程
• shutdown –关机或重启系统
• ping - Send an ICMP ECHO REQUEST to network hosts
• ping - 发送 ICMP ECHO REQUEST 软件包到网络主机
• traceroute - Print the route packets trace to a network host
• traceroute - 打印到一台网络主机的路由数据包
• netstat - Print network connections, routing tables, interface statistics, masquerade con-
nections, and multicast memberships
• netstat - 打印网络连接,路由表,接口统计数据,伪装连接,和多路广播成员
• ftp - Internet file transfer program
• ftp - 因特网文件传输程序
• wget - Non-interactive network downloader
• wget - 非交互式网络下载器
• ssh - OpenSSH SSH client (remote login program)
• ssh - OpenSSH SSH 客户端(远程登录程序)

1.find
find . -name "*.rb" 查找当前目录及当前子目录下的.rb文件
find . -name "*.rb" -size +10k 加上一个大于10k
find . -name "*.rb" -size +10k -mtime 0 加上一个24小时内修改了的文件.
man find 更多关于find 的查询条件

2.curl
支持部分http协议
curl http://www.baidu.com 获得html文档
curl http://www.baidu.com -I 获得返回的http头信息
curl http://www.baidu.com -I -v 加上详细信息, 说明: > 是发往服务器的信息 < 是服务器返回的信息 * 是一些日志消息.
curl 常用于测试基于http的RESTFul的API. 比如通过POST方法, 向服务器发送一段Json数据.
curl -X POST http://app/res -d "{\"name\": \"ok\"}"  -d说明有数据需要发送
more.. man curl
 
3.grep 用于搜索文件内容的命令行工具
grep "konglx" kl.py 查看文件内是否包含改字符串
grep -n "konglx" kl.py 加上打印行号
grep -n "konglx" -R 搜索当前目录下的所有文件
grep -n "konglx" -R . --exclude-dir="spec" 除去不想搜索的目录
grep -n "konglx|konglx90" -R 支持字符串内的正则表达式
more.. man help


4.jq JSON查询利器

5. du -h 查看当前文件夹的大小

nohup命令：如果你正在运行一个进程，而且你觉得在退出帐户时该进程还不会结束，那么可以使用nohup命令。该命令可以在你退出帐户/关闭终端之后继续运行相应的进程。nohup就是不挂起的意思


tar zcvf /home/wang.tar.gz /home/stud1/wang