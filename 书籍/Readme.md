#目录
[kl](#klx)

1.当捕获异常时, 使用 as 而不要用逗号. 例如

    try:
        raise Error
    except Error as error:
        pass


2.

永远不要使用 except: 语句来捕获所有异常, 也不要捕获 Exception 或者 StandardError , 除非你打算重新触发该异常, 或者你已经在当前线程的最外层(记得还是要打印一条错误消息). 在异常这方面, Python非常宽容, except: 真的会捕获包括Python语法错误在内的任何错误. 使用 except: 很容易隐藏真正的bug.


3.生成器

Tip

按需使用生成器.

定义:
    所谓生成器函数, 就是每当它执行一次生成(yield)语句, 它就返回一个迭代器, 这个迭代器生成一个值. 生成值后, 生成器函数的运行状态将被挂起, 直到下一次生成.
优点:
    简化代码, 因为每次调用时, 局部变量和控制流的状态都会被保存. 比起一次创建一系列值的函数, 生成器使用的内存更少.
缺点:
    没有.
结论:

    鼓励使用. 注意在生成器函数的文档字符串中使用”Yields:”而不是”Returns:”.


4.词法作用域(Lexical Scoping)

Tip

推荐使用

定义:

    嵌套的Python函数可以引用外层函数中定义的变量, 但是不能够对它们赋值. 变量绑定的解析是使用词法作用域, 也就是基于静态的程序文本. 对一个块中的某个名称的任何赋值都会导致Python将对该名称的全部引用当做局部变量, 甚至是赋值前的处理. 如果碰到global声明, 该名称就会被视作全局变量.

    一个使用这个特性的例子:

    def get_adder(summand1):
        """Returns a function that adds numbers to a given number."""
        def adder(summand2):
            return summand1 + summand2

        return adder

    (译者注: 这个例子有点诡异, 你应该这样使用这个函数: sum = get_adder(summand1)(summand2) )
优点:
    通常可以带来更加清晰, 优雅的代码. 尤其会让有经验的Lisp和Scheme(还有Haskell, ML等)程序员感到欣慰.
缺点:

    可能导致让人迷惑的bug. 例如下面这个依据 PEP-0227 的例子:

    i = 4
    def foo(x):
        def bar():
            print i,
        # ...
        # A bunch of code here
        # ...
        for i in x:  # Ah, i *is* local to Foo, so this is what Bar sees
            print i,
        bar()

    因此 foo([1, 2, 3]) 会打印 1 2 3 3 , 不是 1 2 3 4 .

    (译者注: x是一个列表, for循环其实是将x中的值依次赋给i.这样对i的赋值就隐式的发生了, 整个foo函数体中的i都会被当做局部变量, 包括bar()中的那个. 这一点与C++之类的静态语言还是有很大差别的.)
结论:
    鼓励使用.


5.函数与方法装饰器

Tip

如果好处很显然, 就明智而谨慎的使用装饰器

定义:

    用于函数及方法的装饰器 (也就是@标记). 最常见的装饰器是@classmethod 和@staticmethod, 用于将常规函数转换成类方法或静态方法. 不过, 装饰器语法也允许用户自定义装饰器. 特别地, 对于某个函数 my_decorator , 下面的两段代码是等效的:

    class C(object):
       @my_decorator
       def method(self):
           # method body ...

    class C(object):
        def method(self):
            # method body ...
        method = my_decorator(method)

优点:
    优雅的在函数上指定一些转换. 该转换可能减少一些重复代码, 保持已有函数不变(enforce invariants), 等.
缺点:
    装饰器可以在函数的参数或返回值上执行任何操作, 这可能导致让人惊异的隐藏行为. 而且, 装饰器在导入时执行. 从装饰器代码的失败中恢复更加不可能.
结论:

    如果好处很显然, 就明智而谨慎的使用装饰器. 装饰器应该遵守和函数一样的导入和命名规则. 装饰器的python文档应该清晰的说明该函数是一个装饰器. 请为装饰器编写单元测试.

    避免装饰器自身对外界的依赖(即不要依赖于文件, socket, 数据库连接等), 因为装饰器运行时这些资源可能不可用(由 pydoc 或其它工具导入). 应该保证一个用有效参数调用的装饰器在所有情况下都是成功的.

    装饰器是一种特殊形式的”顶级代码”. 参考后面关于 Main 的话题.


6.缩进

Tip

用4个空格来缩进代码

绝对不要用tab, 也不要tab和空格混用. 对于行连接的情况, 你应该要么垂直对齐换行的元素(见 行长度 部分的示例), 或者使用4空格的悬挂式缩进(这时第一行不应该有参数):

Yes:   # Aligned with opening delimiter
       foo = long_function_name(var_one, var_two,
                                var_three, var_four)

       # Aligned with opening delimiter in a dictionary
       foo = {
           long_dictionary_key: value1 +
                                value2,
           ...
       }

       # 4-space hanging indent; nothing on first line
       foo = long_function_name(
           var_one, var_two, var_three,
           var_four)

       # 4-space hanging indent in a dictionary
       foo = {
           long_dictionary_key:
               long_dictionary_value,
           ...
       }

No:    # Stuff on first line forbidden
      foo = long_function_name(var_one, var_two,
          var_three, var_four)

      # 2-space hanging indent forbidden
      foo = long_function_name(
        var_one, var_two, var_three,
        var_four)

      # No hanging indent in a dictionary
      foo = {
          long_dictionary_key:
              long_dictionary_value,
              ...
      }

7.注释

Tip

确保对模块, 函数, 方法和行内注释使用正确的风格

文档字符串

    Python有一种独一无二的的注释方式: 使用文档字符串. 文档字符串是包, 模块, 类或函数里的第一个语句. 这些字符串可以通过对象的__doc__成员被自动提取, 并且被pydoc所用. (你可以在你的模块上运行pydoc试一把, 看看它长什么样). 我们对文档字符串的惯例是使用三重双引号”“”( PEP-257 ). 一个文档字符串应该这样组织: 首先是一行以句号, 问号或惊叹号结尾的概述(或者该文档字符串单纯只有一行). 接着是一个空行. 接着是文档字符串剩下的部分, 它应该与文档字符串的第一行的第一个引号对齐. 下面有更多文档字符串的格式化规范.

模块

    每个文件应该包含一个许可样板. 根据项目使用的许可(例如, Apache 2.0, BSD, LGPL, GPL), 选择合适的样板.

函数和方法

    下文所指的函数,包括函数, 方法, 以及生成器.

    一个函数必须要有文档字符串, 除非它满足以下条件:

        外部不可见
        非常短小
        简单明了

    文档字符串应该包含函数做什么, 以及输入和输出的详细描述. 通常, 不应该描述”怎么做”, 除非是一些复杂的算法. 文档字符串应该提供足够的信息, 当别人编写代码调用该函数时, 他不需要看一行代码, 只要看文档字符串就可以了. 对于复杂的代码, 在代码旁边加注释会比使用文档字符串更有意义.

    关于函数的几个方面应该在特定的小节中进行描述记录， 这几个方面如下文所述. 每节应该以一个标题行开始. 标题行以冒号结尾. 除标题行外, 节的其他内容应被缩进2个空格.

    Args:
        列出每个参数的名字, 并在名字后使用一个冒号和一个空格, 分隔对该参数的描述.如果描述太长超过了单行80字符,使用2或者4个空格的悬挂缩进(与文件其他部分保持一致). 描述应该包括所需的类型和含义. 如果一个函数接受*foo(可变长度参数列表)或者**bar (任意关键字参数), 应该详细列出*foo和**bar.
    Returns: (或者 Yields: 用于生成器)
        描述返回值的类型和语义. 如果函数返回None, 这一部分可以省略.
    Raises:
        列出与接口有关的所有异常.

    def fetch_bigtable_rows(big_table, keys, other_silly_variable=None):
        """Fetches rows from a Bigtable.

        Retrieves rows pertaining to the given keys from the Table instance
        represented by big_table.  Silly things may happen if
        other_silly_variable is not None.

        Args:
            big_table: An open Bigtable Table instance.
            keys: A sequence of strings representing the key of each table row
                to fetch.
            other_silly_variable: Another optional variable, that has a much
                longer name than the other args, and which does nothing.

        Returns:
            A dict mapping keys to the corresponding table row data
            fetched. Each row is represented as a tuple of strings. For
            example:

            {'Serak': ('Rigel VII', 'Preparer'),
             'Zim': ('Irk', 'Invader'),
             'Lrrr': ('Omicron Persei 8', 'Emperor')}

            If a key from the keys argument is missing from the dictionary,
            then that row was not found in the table.

        Raises:
            IOError: An error occurred accessing the bigtable.Table object.
        """
        pass

类

    类应该在其定义下有一个用于描述该类的文档字符串. 如果你的类有公共属性(Attributes), 那么文档中应该有一个属性(Attributes)段. 并且应该遵守和函数参数相同的格式.

    class SampleClass(object):
        """Summary of class here.

        Longer class information....
        Longer class information....

        Attributes:
            likes_spam: A boolean indicating if we like SPAM or not.
            eggs: An integer count of the eggs we have laid.
        """

        def __init__(self, likes_spam=False):
            """Inits SampleClass with blah."""
            self.likes_spam = likes_spam
            self.eggs = 0

        def public_method(self):
            """Performs operation blah."""

块注释和行注释

    最需要写注释的是代码中那些技巧性的部分. 如果你在下次 代码审查 的时候必须解释一下, 那么你应该现在就给它写注释. 对于复杂的操作, 应该在其操作开始前写上若干行注释. 对于不是一目了然的代码, 应在其行尾添加注释.

    # We use a weighted dictionary search to find out where i is in
    # the array.  We extrapolate position based on the largest num
    # in the array and the array size and then do binary search to
    # get the exact number.

    if i & (i-1) == 0:        # true iff i is a power of 2

    为了提高可读性, 注释应该至少离开代码2个空格.

    另一方面, 绝不要描述代码. 假设阅读代码的人比你更懂Python, 他只是不知道你的代码要做什么.

    # BAD COMMENT: Now go through the b array and make sure whenever i occurs
    # the next element is i+1


8.
TODO注释

Tip

为临时代码使用TODO注释, 它是一种短期解决方案. 不算完美, 但够好了.

TODO注释应该在所有开头处包含”TODO”字符串, 紧跟着是用括号括起来的你的名字, email地址或其它标识符. 然后是一个可选的冒号. 接着必须有一行注释, 解释要做什么. 主要目的是为了有一个统一的TODO格式, 这样添加注释的人就可以搜索到(并可以按需提供更多细节). 写了TODO注释并不保证写的人会亲自解决问题. 当你写了一个TODO, 请注上你的名字.

# TODO(kl@gmail.com): Use a "*" here for string repetition.
# TODO(Zeke) Change this to use relations.

如果你的TODO是”将来做某事”的形式, 那么请确保你包含了一个指定的日期(“2009年11月解决”)或者一个特定的事件(“等到所有的客户都可以处理XML请求就移除这些代码”).




临别赠言

请务必保持代码的一致性

如果你正在编辑代码, 花几分钟看一下周边代码, 然后决定风格. 如果它们在所有的算术操作符两边都使用空格, 那么你也应该这样做. 如果它们的注释都用标记包围起来, 那么你的注释也要这样.

制定风格指南的目的在于让代码有规可循, 这样人们就可以专注于”你在说什么”, 而不是”你在怎么说”. 我们在这里给出的是全局的规范, 但是本地的规范同样重要. 如果你加到一个文件里的代码和原有代码大相径庭, 它会让读者不知所措. 避免这种情况.


    foo = 'foo'
    bar = 'bar'

    foobar = '%s%s' % (foo, bar) # It is OK
    foobar = '{0}{1}'.format(foo, bar) # It is better
    foobar = '{foo}{bar}'.format(foo=foo, bar=bar) # It is best
    

创建一个含N个列表的列表
因为列表是可变的，所以 * 操作符（如上）将会创建一个包含N个且指向 同一个 列表的列表，这可能不是你想用的。取而代之，请使用列表解析：

    
    four_lists = [[] for __ in xrange(4)]
    

没有三元操作符的Python

    def k(x):
        return 1 if x == 0 else x * k(x-1)

通过切片来复制list
 
    l = [1,2,3]
    x = l[:]
    x.append(0)
    
深度复制

    import copy
    l = [1,2, [12,23], 15]
    x = copy.deepcopy(l)
    
常见的字符串操作

    count
    find 
    rfind


<a id="klx">test</a>
