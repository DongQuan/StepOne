###Python高级编程
system: ubuntu 14.04 

#### 安装ipython 
    sudo apt-get install ipython


#### 开发环境
    Pycharm + Vim

#### 低于类级的语法
    - 列表推导(List comprehensions)
    - 迭代器(Iterators)和生成器(generators)
    - 描述符(Descriptors)和属性(properties)
    - 装饰(Decorators)
    
#####1. 列表推导(List comprehensions)
列表推导式（list comprehension）是利用其他列表创建新列表（类似于数学术语中的集合推导式）的一种方法。它的工作方式类似于for循环：
    
    ```[x*x for x in xrange(10) if x % 3 == 0]```
#####2. 迭代器(Iterators)和生成器(generators)
迭代器： 实现迭代器协议的容器对象， 基于以下两个方法：
    
- next() 返回容器的下一个项目
- \__iter\__ 返回迭代器本身

斐波那契数列的迭代器实现


    class Fabs(object):
        def __init__(self,max):
            self.max = max
            # 特别指出：第0项是0，第1项是第一个1.整个数列从1开始
            self.n, self.a, self.b = 0, 0, 1 
        def __iter__(self):
            return self
        def next(self):
            if self.n < self.max:
                r = self.b
                self.a, self.b = self.b, self.a + self.b
                self.n = self.n + 1
                return r
            # 当数据遍历完会抛出异常
            raise StopIteration()
  
    print Fabs(5)
    for key in Fabs(5):
        print key
    Fabs(5).next().next()

带有 yield 的函数在 Python 中被称之为 generator（生成器）
yield指令，可以暂停一个函数并返回中间结果。使用该指令的函数将保存执行环境，并且在必要时恢复。
斐波那契数列的迭代器实现


    def fab(max):
        n, a, b = 0, 0, 1
        while n < max:
            yield b
            a, b = b, a + b
        n = n + 1
    
yield 的语法糖， 相对于列表推导式来说把方括号变为了圆括号
```iter = (i for i in range(10) if i % 2 == 0)```

[协同程序](http://blog.csdn.net/yueguanghaidao/article/details/10201327)


#####3. [装饰器](http://www.cnblogs.com/rhcad/archive/2011/12/21/2295507.html)


####[Python风格指南](http://zh-google-styleguide.readthedocs.org/en/latest/google-python-styleguide/contents/)

    
   
#### small tips: 
     1. 退出命令行 Ctrl + D
     2. 