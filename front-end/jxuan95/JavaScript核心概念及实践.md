###1.JavaScript中的数据类型

> 在Javascript中，包含6种数据类型：字符串(string)、数值(number)、布尔值(boolean)、undefined、null以及对象(object)。PS：第6种应该是object还是symbo(ES6)？

###2.JavaScript中的对象

> 此处的对象包括：对象（属性的集合，即键值的散列表）、数组（有序的列表）、函数（包含可执行的代码）

###3.相等与等同运算符

> 相等运算符：如果操作数具有相同的类型，则判断其等同性，如果两个操作数的值相等，则返回true，否则返回false。
> 如果操作数的类型不同，则按照这样的情况来判断：
> - null和undefined相等；
> - 其中一个是数字，另一个是字符串，则将字符串转换为数字，再做比较；
> - 其中一个是true，先转换为1（false转为0）再做比较；
> - 如果一个值是对象，另一个是数字/字符串，则将对象转换为原始值（通过toString()或者valueOf()）；
> - 其他情况，直接返回false。

<br/>
> 等同运算符（===）：如果操作数的类型不同，则不进行值的判断，直接返回false。
> 如果操作数的类型相同，分下列情况来判断：
> - 都是数字的情况，如果值相同，则两者等同（有一个例外，就是NaN，NaN与其本身也不相等），否则不等同；
> - 都是字符串的情况，与其他程序设计语言一样，如果串的值不相等，则不等同；
> - 都是布尔值，且值均为true/false，则等同；
> - 如果两个操作数引用同一个对象（数组，函数），则两者完全等同；
> 如果两个操作数均为null/undefined，则等同。

###4.原型对象及原型链
> javascript本身是基于原型的，每个对象都有一个prototype的属性，这个prototype本身也是一个对象，因此它本身也可以有自己的原型，这样就构成了一个链结构。
> <br>
> 访问一个属性的时候，解析器需要从下向上的遍历这个链结构，直到遇到该属性，则返回属性对应的值，或者遇到原型为null的对象（javascript的基对象Object的构造器的默认prototype有一个null原型），如果此对象仍没有该属性，则返回undefined。 

###5.数组对象的方法

|方法|描述|
|---|---|
|concat()|连接两个或更多的数组，并返回结果数组|
|join()|把数组的所有元素放入一个字符串。元素通过指定的分隔符进行分隔|
|pop()|删除并返回数组的最后一个元素|
|push()|向数组的末尾添加一个或更多元素，并返回新的长度|
|reverse()|颠倒数组中元素的顺序|
|shift()|删除并返回数组的第一个元素|
|slice()|从某个已有的数组返回选定的元素|
|sort()|对数组的元素进行排序|
|splice()|删除元素，并向数组添加新元素|
|unshift()|向数组的开头添加一个或更多的元素，并返回新的长度|
|valueOf()|返回数组对象的原始值|

###6.借助数组对象自身的slice方法删除数组某个数据
> jQuery的设计者John Resig提供的方法

    Array.prototype.remove = function (from, to) {
        var rest = this.slice((to || from) + 1 || this.length);
        this.length = from < 0 ? this.length + from : from;
        return this.push.apply(this.rest);
    };

    array.remove(0);//删除第一个元素
    array.remove(-1);//删除倒数第一个元素
    array.remove(0,2);//删除数组下标为0-2的元素（3个）

###7.正则表达式

|元字符|含义|
|---|---|
|^|串的开始|
|$|串的结束|
|*|零到多次匹配|
|+|一到多次匹配|
|?|零或一次匹配|
|\b|单词边界|

|字符|含义|
|---|---|
|字符本身|匹配字符本身|
|\r|匹配回车|
|\n|匹配换行|
|\t|制表符|
|\f|换页|
|\x#|匹配十六进制数|
|\cX|匹配控制字符|

|标志符|含义|
|---|---|
|[...]|在集合中的任一个字符|
|[^...]|不在集合中的任一个字符|
|.|除\n之外的任一个字符|
|\w|所有的单字，包括字母数字及下划线|
|\W|不包括所有的单字，\w的补集|
|\s|所有的空白字符，包括空格，制表符|
|\S|所有的非空白字符|
|\d|所有的数字|
|\D|所有的非数字|
|\b|退格字符|

|标记|含义|
|---|---|
|{n}|重复n次|
|{n,}|重复n或更多次|
|{n,m}|重复至少n次，至多m次|

```
var pid = /^(\d{15}|\d{18})&/;//身份证
var mphone = /\d{11}/;//手机号码
var phone = /\d{3,4}-\d{7,8};//电话号码
```

###8.使用正则表达式

> 创建正则表达式：
> - 使用字面量：`var regex = /pattern/;`
> - 使用RegExp对象：`var regex = new RegExp("pattern", switchs);`

> 而正则表达式的一般形式描述为：`var regex = /pattern/[switchs];`

**这里的开关(switchs)有以下三种：**

|修饰符|描述|
|---|---|
|i|忽略大小写开关|
|g|全局搜索开关|
|m|多行搜索开关(重定义^与$的意义)|

**正则表达式对象的方法：**

|方法名|描述|
|---|---|
|test()|测试串中是否有合乎模式的匹配|
|exec()|对串进行匹配|
|compile()|编译正则表达式|

###9.String中的正则表达式
> 除了正则表达式对象及字面量外，String对象中也有多个方法支持正则表达式操作。

|方法|作用|
|---|---|
|match|匹配正则表达式，返回匹配数组|
|replace|替换|
|split|分割|
|search|查找，返回首次发现的位置|

```
var str = "life is very much like a mirror.";
var result = str.match(/is|a/g);//返回["is", "a"]

var str = "<span>Welcome, John</span>";
var result = str.replace(/span/g, "div");//<div>Welcome, John</div>

如果想把Welcome和John两个单词调换顺序：
var result = str.replace(/(\w+),\s(\w+)/g, "$2, $1");
//<span>John,Welcome</span>
```

###10.正则表达式中括号的作用
1. 括号用来将子表达式标记起来，以区别于其他表达式，比如很多的命令行程序都提供帮助命令，键入h和键入help的意义是一样的，那么就会有这样的表达式：`h(elp)?//字符h之后的elp可有可无`

1. 括号用来分组，当正则表达式执行完成之后，与之匹配的文本会按规则填入各个分组。
	例如：
	```
	var pattern = /\w{4}(\d{4})(\w{2})/;
	var result = pattern.exec("yunn0871cg");
	console.log("city code = " + result[1] + ", county code = " + result[2]);
	//city code = 0871, county code = cg
	
	```
	正则表达式的exec方法会返回一个数组，数组的第一个元素(下标为0)表示整个串，第一个元素为第一个分组，第二个元素为第二个分组；

1. 第三种情况，括号用来对引用起辅助作用，即在同一个表达式中，后边的式子可以引用前边匹配的文本。

###11.匿名自执行函数

> 有的函数只需要执行一次，其内部变量无需维护，比如UI的初始化，那么我们可以使用闭包。例如：

    var datamodel = {
        table: [],
        tree: {}
    };

    (function (dm) {
        for (var i = 0; i < dm.table.rows; i++) {
            var row = dm.table.rows[i];
            for (var j = 0; j < row.cells; i++) {
                drawCell(i, j);
            }
        }
    })(datamodel);
我们创建了一个匿名的函数，并立即执行它，由于外部无法引用它内部的变量，因此在执行完后很快就会被释放，最主要的是这种机制不会污染全局对象。

###12.缓存

> 设想我们有一个处理过程很耗时的函数对象，每次调用都会花费很长时间，那么我们就需要将计算出来的值存储起来，当调用这个函数的时候，首先在缓存中查找，如果找不到，则进行计算，然后更新缓存并返回值，如果找到了，直接返回查找到的值即可。闭包可以做到这一点，因为它不会释放外部的引用，函数内部的值可以得以保留。

    var CachedSearchBox = (function () {
        var cache = {}, count = [];
        return {
            attachSearchBox: function (disd) {
                if (disd in cache) {//如果在缓存中
                    return cache[disd];//直接返回
                }
                var fsb = new uikit.webctrl.SearchBox(disd);//创建
                cache[disd] = fsb;//更新缓存
                if (count.length > 100) {//保证缓存的大小小于100个
                    delete cache[count.shift()];//删除最前面那个缓存
                }
                return fsb;
            },
            clearSearchBox: function (disd) {
                if (disd in cache) {
                    cache[disd].clearSelection();
                }
            }
        }
    })();

    CachedSearchBox.attachSearchBox("input1");

###13.闭包实现封装

    var person = function () {
        //变量作用域为函数内部，外部无法访问
        var name = "default";
        return {
            getName: function () {
                return name;
            },
            setName: function (newName) {
                name = newName;
            }
        }
    }();
    
    person.name;//undefined
    person.getName();//default
    person.setName("aaa");
    person.getName();//aaa

###14.闭包中的this
> 关于this我们之前已经做过讨论，它表示对调用对象的引用，而在闭包中，最容易出现错误的地方是误用了this。在js的开发中，一个常见的错误就是将this类比为其他的外部局部变量。

    $(function () {
        var con = $("#div#panel");
        this.id = "content";
        con.click(function () {
            alert(this.id);//panel
        })
    });
> 此处的this.id到底引用着什么呢？很多开发者可能根据闭包的概念，做出错误的判断：content，理由是，this.id显示的被赋值为content。然而事实上，这个alert会弹出panel，究其原因，就是此处的this，因为调用对象的存在，使得当闭包被调用时（当这个panel的click发生时），this引用的是con这个jQuery对象。而匿名函数中的this.id="content"是对匿名函数本身做的操作。两个this引用的不是同一个对象。如果想要在事件处理函数中访问这个值，我们必须做一些改变：

    $(function () {
        var con = $("#div#panel");
        this.id = "content";
        var self = this;
        con.click(function () {
            alert(self.id);//content
        })
    });

###15.new操作符

> 在JavaScript中，通过new操作符来作用于一个函数，实质上会发生这样的动作。
> 首先，创建一个空对象，然后用函数apply方法，将这个空对象传入作为apply的第一个参数以及上下文参数。这样函数内部的this将会被这个空的对象所替代。

    var triangle = new Shape("triangle");
    //上一句相当于下面的代码
    var triangle = {};
    Shape.apply(triangle, ["triangle"]);

###16.用JavaScript函数实现封装

    function Person(name) {
        //私有变量
        var address = "1";

        //公共方法
        this.getAddress = function () {
            return address;
        };

        //公共变量
        this.name = name;
    }

    //公共方法
    Person.prototype.getName = function () {
        return this.name;
    };

    //公共方法
    Person.prototype.setName = function (name) {
        this.name = name;
    };

首先声明一个函数，作为模板，用面向对象的术语来说，就是一个类。用var方式声明的变量仅在类内部可见，所以address为一个私有成员，访问address的唯一方法就是通过我们向外暴露的getAddress方法，而get/setName，均为原型链上的方法，因此为公开的。我们可以做个测试：

    var jack = new Person("jack");
    console.log(jack.name);//jack
    console.log(jack.getName());//jack
    console.log(jack.address);//undefined
    console.log(jack.getAddress());//1

添加静态变量：

    function Person(name) {
        //私有变量
        var address = "1";

        //公共方法
        this.getAddress = function () {
            return address;
        };

        //公共变量
        this.name = name;
    }

    Person.TAG = "javascript-core";//在访问该变量的时候，不需要实例化Person类

###17.函数式的JavaScript

> 函数可以保持自己内部的数据，函数的运算对外部无副作用（修改了外部的全局变量的状态等）。关于函数可以保持自己内部的数据这一特性，成为闭包。示例：

    var outter = function () {
        var x = 0;
        return function () {
            return x++;
        }
    };

    var a = outter();
    console.log(a());//0
    console.log(a());//1
    console.log(a());//2

    var b = outter();
    console.log(b());//0
    console.log(b());//1

变量a通过闭包引用outter的一个内部变量，每次调用a()就会改变此内部变量，应该注意的是，当调用a时，函数outter已经返回了，但是内部变量x的值仍然被保持。而变量b也引用了outter，但是这是一个不同的闭包，所以b开始引用的x值不会随着a()被调用而改变，两者有不同的实例，这就相当于面向对象中的不同实例拥有不同的私有属性，互不干涉。

###18.柯里化的概念
> 柯里化就是预先将函数的某些参数传入，得到一个简单的函数，但是预先传入的参数被保存在闭包中，因此会有一些奇特的特性。比如：

    var adder = function (num) {
        return function (y) {
            return num + y;
        }
    };

    var inc = adder(1);
    var dec = adder(-1);

    console.log(inc(99));//100
    console.log(dec(101));//100

###19.函数式编程风格

> 通常来讲，函数式编程的谓词（关系运算符，如大于、小于、等于的判断等），以及运算（加减乘除等）都会以函数的形式出现，比如：
> `a > b`
> 通常表示为：
> `gt(a, b)`
> 因此，可以首先对这些常见的操作进行一些包装，以便我们的代码更具有“函数式”风格。
> 如果我们之前的编码风格是这样：
> 
	```
	//阶乘
	    function factorial(n) {
	        if (n == 1) {
	            return 1;
	        } else {
	            return n * factorial(n - 1);
	        }
	    }
	```
> 在函数式风格下，就应该是这样了：
>    
	```
		function factorial(n) {
		    if (equal(n, 1)) {
		        return 1;
		     } else {
		         return mul(n, factorial(dec(n)));
		     }`
		}
	```

###20.活动对象

> 在JavaScript中，当一个函数被调用的时候，就会产生一个特殊的对象：活动对象。这个对象中包含了参数列表和arguments对象等属性。由于活动对象是变量对象的特例，因此，它包含变量对象所有的属性，如变量定义，函数定义等。
> 实例：

    function func(handle, message) {
        var id = 0;

        function doNothing(x) {
            return x;
        }

        handle(message);
    }

    func(print, "hello");//执行到这里的时候，活动对象被创建

###21.作用域链

> 作用域链与原型链类似，也是一个对象组成的链，用以在上下文中查找标识符（变量、函数等）。查找时也与原型链类似，如果激活对象本身具有该变量，则直接使用该变量的值，否则向上层搜索，依次类推，直到查找到或者返回undefined。作用域链的主要作用是用以查找自由变量。所谓自由变量是指，在函数中使用的，非函数内部局部变量，也非函数内部定义的函数名，也非形式参数变量。这些变量通常来自于函数的“外层”或者全局作用域，比如，我们在函数内部使用的window对象及其属性。

    var topone = "top-level";
    (function outter() {
        var middle = "mid-level";
        (function inner() {
            var bottom = "bot-level";
            console.log(topone + ">" + middle + ">" + bottom);
        })();
    })();
    //在函数Inner中，console.log语句出现的topone、middle变量就是自由变量

###22.词法作用域

> 在javascript中，函数对象的创建和函数本身的执行是完全不同的两个过程。
   
    function func() {
        var x = 0;
        console.log("func");
    }//这是函数的创建
    func();//函数的执行

> 所谓词法作用域(静态作用域)是指，在函数对象的创建时，作用域就已经建立，而并非到执行时，因为函数创建后可能永远不会被执行，但是作用域是始终存在的。比如在上例中，如果在程序中没有调用func()，那么，func对象仍旧是存在的，在内存的结构可能是这样的：
> `func.["[[scope]]"] = global.["variable object"];`
> 而当函数执行时，进入函数执行期上下文，函数的活动对象被创建，此时的作用域链是活动对象和"[[scope]]"属性的合成。

###23.this的上下文

> this值是执行期上下文对象的一个属性(执行期上下文对象包括变量对象、作用域链以及this)。执行期上下文对象有三类，当进入不同的上下文时，this的值会确定下来，并且this的值不能更改。在执行全局代码时，控制流会进入全局执行期上下文，而在执行函数时，又会有函数执行期上下文。例如：

    var global = this;
    var tom = {
        name: "Tom",
        home: "desine",
        getInfo: function () {
            console.log(this.name + ", from " + this.home);
        }
    };
    tom.getInfo();
    var jerry = {
        name: "Jerry",
        getInfo: tom.getInfo
    };
    jerry.getInfo();

    global.getInfo = tom.getInfo;
    global.getInfo();
    输出结果：
	    Tom, from desine
		Jerry, from undefined
		, from undefined
tom对象本身具有name和home属性，因此在执行tom.getInfo时，会打印tom对象上的这两个属性值。当将global.getInfo属性设置为tom.getInfo时，getInfo中的this值，getInfo中的this值，在运行时，事实上是global对象，所以name和home均未定义。

###24.window对象
> window对象是对浏览器当前窗口的引用，因为浏览器会将window与自身绘制出来的窗口绑定起来，我们对window的操作事实上会映射到浏览器窗口上。正是浏览器本身提供了这种脚本化的能力，我们才有机会通过JavaScript代码来完成很多操作。

###25.文档对象模型(DOM)

> DOM即文档对象模型，它是一个平台，提供语言无关的API，允许程序访问并更改文档的内容、结构以及样式。HTML文档是一个树形的结构，与浏览器中的页面中的结构一一对应。

###26.事件驱动模型

> 由于客户端JavaScript的开发属于用户界面开发的范畴，因此使用事件驱动模型就显得非常自然了。事件驱动的特点在于：代码块的运行与否与程序流程无关。而传统的流式代码的特点是，从函数的入口进入，依次调用各个子模块的处理函数，最后退出。这种编程模式主要适用于与UI关系不大的场合，很少有异步的过程，这些特点可能要追溯到计算机程序的最初模型——批处理。
> 而事件驱动模型主要是面向用户的，你无法知道用户会如何使用你的程序，因此就只能通过回调、事件监听等方式，当用户做出某个动作时才会触发之前已经注册好的监听器，从而执行相关代码，而不是顺序地执行。甚至在一次运行中，部分代码始终没有被触发，也就根本不会被执行到。

###27.与服务器端交互(Ajax)
> Ajax表示异步JavaScript与XML。事实上，Ajax与XML几乎没有任何关系，因为是异步交互，所以用户的页面不用刷新，在同一个页面中，客户端请求服务数据，当服务数据返回时，通过JavaScript将数据片段填充到页面的某个部分，即实现了局部刷新。