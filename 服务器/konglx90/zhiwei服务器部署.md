### 知味服务器代码更新
#### Ubuntu14.04
1. 先用ssh连接服务器: ssh root@139.129.129.14
2. cd 到项目的目录下: cd /home/wwwroot/zhiwei
3. 查看服务器git仓库连接的远程仓库: git remote -v (请确定与您最新的远程代码库相连, 如果确定, 请到第4步, 否则请自行修改)
 - 3.1 git remote remove origin
 - 3.2 git remote add origin [New Git Rep]
4. 用git更新代码   : git pull origin master
5. 结束当前的uwsgi进程: ps aux | grep 'uwsgi.ini$'| awk '{print $2}' | xargs kill -9
6. 重新拉起代码: uwsgi --ini uwsgi.ini