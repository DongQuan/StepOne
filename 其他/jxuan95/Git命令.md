####Git常用命令

1. 查看当前的远程库:
    要查看当前配置有哪些远程仓库，可以用 git remote 命令，它会列出每个远程库的简短名字。在克隆完某个项目后，至少可以看到一个名为 origin 的远程库，Git 默认使用这个名字来标识你所克隆的原始仓库：
        
        $ git clone git://github.com/test/ticgit.git
        Cloning into 'ticgit'...
        remote: Reusing existing pack: 1857, done.
        remote: Total 1857 (delta 0), reused 0 (delta 0)
        Receiving objects: 100% (1857/1857), 374.35 KiB | 193.00 KiB/s, done.
        Resolving deltas: 100% (772/772), done.
        Checking connectivity... done.
        $ cd ticgit
        $ git remote
        origin
        
    也可以加上 -v 选项（译注：此为 --verbose 的简写，取首字母），显示对应的克隆地址：
    
        $ git remote -v
        origin  git://github.com/test/ticgit.git (fetch)
        origin  git://github.com/test/ticgit.git (push)
        
2. 添加远程仓库:
    要添加一个新的远程仓库，可以指定一个简单的名字，以便将来引用，运行 git remote add shortname url：
        
        $ git remote
        origin
        $ git remote add pb git://github.com/paulboone/ticgit.git
        $ git remote -v
        origin  git://github.com/schacon/ticgit.git
        pb  git://github.com/paulboone/ticgit.git
        
    现在可以用字符串 pb 指代对应的仓库地址了。比如说，要抓取所有 Paul 有的，但本地仓库没有的信息，可以运行 git fetch pb：
    
        $ git fetch pb
        remote: Counting objects: 58, done.
        remote: Compressing objects: 100% (41/41), done.
        remote: Total 44 (delta 24), reused 1 (delta 0)
        Unpacking objects: 100% (44/44), done.
        From git://github.com/paulboone/ticgit
         * [new branch]      master     -> pb/master
         * [new branch]      ticgit     -> pb/ticgit
         
3. 从远程仓库抓取数据:

        $ git fetch [remote-name]
        
    此命令会到远程仓库中拉取所有你本地仓库中还没有的数据。运行完成后，你就可以在本地访问该远程仓库中的所有分支，将其中某个分支合并到本地，或者只是取出某个分支，一探究竟。（我们会在第三章详细讨论关于分支的概念和操作。）

    如果是克隆了一个仓库，此命令会自动将远程仓库归于 origin 名下。所以，git fetch origin 会抓取从你上次克隆以来别人上传到此远程仓库中的所有更新（或是上次 fetch 以来别人提交的更新）。有一点很重要，需要记住，fetch 命令只是将远端的数据拉到本地仓库，并不自动合并到当前工作分支，只有当你确实准备好了，才能手工合并。

    如果设置了某个分支用于跟踪某个远端仓库的分支（参见下节及第三章的内容），可以使用 git pull 命令自动抓取数据下来，然后将远端分支自动合并到本地仓库中当前分支。在日常工作中我们经常这么用，既快且好。实际上，默认情况下 git clone 命令本质上就是自动创建了本地的 master 分支用于跟踪远程仓库中的 master 分支（假设远程仓库确实有 master 分支）。所以一般我们运行 git pull，目的都是要从原始克隆的远端仓库中抓取数据后，合并到工作目录中的当前分支。
    
4. 推送数据到远程仓库:
    项目进行到一个阶段，要同别人分享目前的成果，可以将本地仓库中的数据推送到远程仓库。实现这个任务的命令很简单： git push remote-name branch-name。如果要把本地的 master 分支推送到 origin 服务器上（再次说明下，克隆操作会自动使用默认的 master 和 origin 名字），可以运行下面的命令：
    
        $ git push origin master

5. 远程仓库的删除和重命名:

        $ git remote rename pb paul
        $ git remote
        origin
        paul
