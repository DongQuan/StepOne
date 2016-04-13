##1.  JavaScript常用测试框架:
> - QUnit
> - YUI Test
> - JsUnit
> - Jasmine

##2.  断言：
> 单元测试框架的核心是断言方法，通常叫做assert()。该方法通常接受一个值——需要断言的值，以及一个表示该断言目的的描述。如果该值执行结果为true，断言就会通过；否则断言就会被认为是失败的。

##3. 函数是第一型对象：

> 对象在JavaScript中有如下功能：
> - 它们可以通过字面量进行创建；
> - 它们可以赋值给变量、数组或其他对象的属性；
> - 它们可以作为参数传递给函数；
> - 它们可以作为函数的返回值进行返回；
> - 它们可以拥有动态创建并赋值的属性；

在JavaScript中，函数拥有全部这些功能，也就是说可以像这门语言中的其他对象一样使用。因此，我们说函数是第一型对象。函数还有一个特殊的功能，它们可以被调用。

##4. 浏览器的事件轮询：

> 浏览器的事件轮询是单线程的，每个事件都是按照在队列中所放置的顺序来处理的。

##5. 回调概念：

> 当我们定义一个函数稍后执行时，无论何时定义，在浏览器执行还是在其他地方执行，我们定义的就是所谓的回调。

##6. 函数声明：

> JavaScript函数是使用函数字面量进行声明从而创建函数值的，就像使用数字字面量创建数字值一样。
> 函数字面量由四个部分组成：
> - function关键字；
> - 可选名称；
> - 括号内部的参数；
> - 函数体，包含在大括号内的一系列JavaScript语句；

##7. 作用域和函数：

> 在Javascript中，作用域是由function进行声明的，而不是代码块。声明的作用域创建于代码块，但不是终结于代码块。
> 例如：
> ```
> if(window){
>	var x= 213;	
> }
> alert(x);//213
> ```

##8. 使用apply()和call()方法：

> 在函数调用的时候，JavaScript为我们提供了一种方式，可以显示指定任何一个对象作为其函数的上下文。JavaScript的每个函数都有apply()和call()方法。
> 通过函数的apply()方法来调用函数，我们要给apply()传入两个参数：一个是作为函数上下文的对象，另外一个是作为函数参数所组成的数组。call()方法的使用方式类似，唯一不同的是，给函数传入的参数是一个参数列表，而不是单个数组。
> 代码示例：
> ```
> <script type = "text/javascript">
> function juggle() {
>     var result = 0;
>     for (var n = 0; n < arguments.length; n++) {
>         result += arguments[n];
>     }
>     this.result = result;
> }
> var ninja1 = {};
> var ninja2 = {};
> juggle.apply(ninja1,[1,2,3,4]);
> juggle.call(ninja2,5,6,7,8);
> console.log(ninja1.result == 10);//true
> console.log(ninja2.result == 26);//true
> </script>
> ```

##9. arguments.callee属性：

> 代码示例：
> ```
> var ninja = {
>     chirp: function(n) {
>         return n > 1 ? arguments.callee(n - 1) + "-chirp" : "chirp";
>     }
> }
> ```
> callee属性引用的是当前所执行的函数。该属性可以作为一个可靠的方法引用函数自身。

##10. 自记忆函数：

```
记忆之前计算出的值：
function isPrime(value) {
    if (!isPrime.answers) {
        isPrime.answers = {};
    }
    if (isPrime.answers[value] != null) {
        return isPrime.answers[value];
    }
    var prime = value != 1;
    for (var i = 2; i < value; i++) {
        if (value % i == 0) {
            prime = false;
            break;
        }
    }
    return isPrime.answers[value] = prime;
}
```

```
缓存记忆DOM元素
function getElements(name) {
    if (!getElements.cache) {
        getElements.cache = {};
    }
    return getElements.cache[name] = getElements.cache[name] || document.getElementsByTagName(name);
}
```

##11. 模拟类似数组的方法

```
var elems = {
    length: 0,
    add: function (elem) {
        Array.prototype.push.call(this, elem);
    },
    gather: function (id) {
        this.add(document.getElementById(id));
    }
};
```

##12. 使用apply()支持可变参数

```
在这里指定Math为上下文是没有必要的
function smallest(array) {
    return Math.min.apply(Math, array);
}
function largest(array) {
    return Math.max.apply(Math, array);
}
```
重载函数的方法：

```
function addMethod(object, name, fn) {
    var old = object[name];//保存原有的函数，因为调用的时候可能不匹配传入的参数个数
    object[name] = function () {
        if (fn.length == arguments.length) {
        //如果该匿名函数的形参个数和实数个数匹配，就调用该函数
            return fn.apply(this, arguments);
        } else if (typeof old == 'function') {
        //如果传入的参数个数不匹配，则调用原有的参数
            return old.apply(this, arguments);
        }
    }
}
```
addMethod方法共接受三个参数：
- 要绑定方法的对象
- 绑定方法所用的属性名称
- 要绑定的方法

##13. 什么是闭包：

> 闭包是一个函数在创建时允许该自身函数访问并操作该自身函数之外的变量时所创建的作用域。换句话说，闭包可以让函数访问所有的变量和函数，只要这些变量和函数声明时的作用域内就行。

##14. 在封闭的作用域内，强制使用一个名称：

```
(function ($) {
    $("img").on("click", function (e) {
        $(e.target).addClass("clickOn");
    })
})(jQuery);//jQuery作为参数绑定到$上
```

##15. 利用即时函数妥善处理迭代问题：

```
for (var i = 0; i < length; i++) {
    (function (n) {
        alert(n);
    })(i);
}
```

##16. 使用hasOwnProperty()方法辨别Object原型扩展：

```
Object.prototype.keys = function () {
    var keys = [];
    for (var i in this) {
	    //使用hasOwnProperty()忽略原型对象上的属性
        if (this.hasOwnProperty(i)) {
            keys.push(i);
        }
    }
    return keys;
};

var obj = {a: 1};
console.log(obj.keys());
```

##17. 在Number原型上添加一个方法
```
    Number.prototype.add = function (num) {
        return this + num;
    };
    var n = 5;

    console.log(n.add(3));
```

##18. 子类化Array对象：

```
function MyArray() {}

MyArray.prototype = new Array();
var mine = new MyArray();
mine.push(1, 2, 3);
console.log(mine.length == 3);//true
```

##19. 模拟Array功能，而不是扩展出子类：

```
	function MyArray() {}
    MyArray.prototype.length = 0;
    (function () {
        var methods = ['push', 'pop', 'shift', 'unshift', 'slice', 'splice', 'join'];
        for (var i = 0; i < methods.length; i++) {
            (function (name) {
                MyArray.prototype[name] = function () {
                    return Array.prototype[name].apply(this, arguments);
                }
            })(methods[i])
        }
    })();
    var mine = new MyArray();
    mine.push(1, 2, 3);
    console.log(mine);//[1, 2, 3]
```

##20. 判断函数是否是作为构造器进行调用的

```
	function Test(){
        return this instanceof arguments.callee;
    }
```

- 通过arguments.callee可以得到当前执行函数的引用；
- “普通”函数的上下文是全局作用域（除非有人做了强制修改）；
- 利用instanceof操作符测试已构建对象是否构建于指定的构造器；

基于这些事实，函数在作为构造器进行执行的时候，表达式：`this instanceof arguments.callee;`的结果是true，如果作为普通函数执行，则返回false。

##21. 用eval()方法进行求值：

基本功能：
- 该方法将执行传入代码的字符串；
- 在调用eval()方法的作用域内进行代码求值；
```
console.log(eval("5+5") == 10);//true
```

求值结果：
eval()方法将返回传入字符串中最后一个表达式的执行结果。
```
console.log(eval("3+4;5+6"));//11
```

*在使用eval()方法求值的时候，求值执行的作用域就是调用eval()时的作用域，而不是全局作用域。*

##22. 用函数构造器进行求值：

JavaScript中的所有函数都是Function的实例，可以直接使用Function构造器来实例化函数。
```
var add = new Function("a", "b", "return a + b;");
console.log(add(3, 4));//7
```

Function构造器可变参数列表的最后一个参数，始终是要创建函数的函数体内容。前面的参数则表示函数的形参名称。

所以，上面的示例代码等价于如下代码：
```
var add = function(a, b) { return a + b;}
```

虽然这些代码在功能上是等同的，但采用Function构造器方式有一个明显的区别，函数体由运行时的字符串所提供。

另外一个极其重要的实现区别是，使用Function构造器创建函数的时候，**不会创建闭包**。在不想承担任何不相关闭包的开销时，这可能是一件好事。

##23. 将JSON字符串转化成JavaScript对象

```
	var json = '{"name":"Ninja"}';
    var object = eval("(" + json + ")");
    console.log(object);//Object {name: "Ninja"}
```
使用eval()做JSON解析时需要注意的是：通常，JSON数据来自于远程服务器，而且，盲目执行远程服务器上的不可信代码，基本是不可取的。

最受欢迎的JSON转换器脚本是由JSON标记的创造者Douglas Crockford所编写。在该转换器中，他做了一些初步的JSON字符串解析，以防止任何恶意信息通过。Github:JSON-js

##24. with语句

> with语句是一个强大的、但经常被误解的、有争议的Javascript特性。with语句允许我们将一个对象的所有属性引用到当前作用域，允许我们无需使用拥有者对象的前缀，就可以对这些属性进行引用和赋值操作。

```
	var use = "other";//定义一个全局变量
	var katana = {//创建一个对象
        isSharp: true,
        use: function () {
            this.isSharp != this.isSharp;
        }
    };
    with (katana) {//建立一个with作用域，在该作用域内，可以直接引用属性名称，而不必使用katana前缀，好像它们就是全局变量和全局方法一样
        console.log(use !== "other" && typeof use == "function");//作用域内进行测试,true
        console.log(this !== katana);//true
    }

	console.log(use === "other");//作用域外进行测试，true
	console.log(typeof isSharp === "undefined");//true
```

> 注意：在with语句的作用域内，对象属性的优先级绝对高于在更高层作用域内定义的同名变量。函数上下文(this)是不受with语句影响的。

##25. 判断一个浏览器是否支持opacity：
```
    var div = document.createElement("div");
    div.setAttribute("style", "opacity:0.5");
    var OPACITY_SUPPORTED = div.style.opacity === "0.5";
    console.log(OPACITY_SUPPORTED);
```

##26. 获取计算样式的值：
```
function fetchComputedStyle(element, property) {//定义新函数
        if (window.getComputedStyle) {
            var computedStyles = window.getComputedStyle(element);//获取接口
            if (computedStyles) {
                property = property.replace(/[A-z]/g, '-$1').toLowerCase();//获取样式值
                return computedStyles.getPropertyValue(property);
            }
        } else if (element.currentStyle) {//使用专有方式，IE浏览器
            property = property.replace(/-([a-z])/ig, function (all, letter) {
                return letter.toUpperCase();
            });
            return element.currentStyle[property];
        }
    }
    window.onload = function () {
        var div = document.getElementsByTagName("div")[0];
        console.log(fetchComputedStyle(div, "display"));
    };
```

##27. 绑定和解绑事件处理程序：

> 
在DOM2下，对于兼容于DOM的现代浏览器，我们绑定和解绑事件处理程序使用的是addEventListener()和removeEventListener()方法；而对IE老版本使用的则是attachEvent()和detachEvent()方法。
<br/>
> 
注意：IE没有提供事件捕获阶段的监听方式，只支持时间处理过程中的冒泡阶段。此外，IE的实现给绑定处理程序设置了错误的上下文，使得处理程序内的this引用的是全局上下文，而不是事件目标元素。另外，IE没有将事件信息传递给处理程序，而是将事件信息定死在全局上下文了——window对象。

这意味着，在处理如下类型的事件时，我们需要根据不同的浏览器来指定不同的方式。
- 绑定一个处理程序时；
- 解绑一个处理程序时；
- 获取事件信息时；
- 获取事件目标时；

> 如何解决多API的问题，以及IE不能正确设置上下文问题：
> 代码：绑定事件处理程序时，设置正确的上下文
> 
```
	if (document.addEventListener) {
        this.addEvent = function (elem, type, fn) {
            elem.addEventListener(type, fn, false);//false表示使用冒泡处理
            return fn;
        };
        this.removeEvent = function (elem, type, fn) {//DOM解绑函数
            elem.removeEventListener(type, fn, false);
        }
    } else if (document.attachEvent) {//检测是否支持IE
        this.addEvent = function (elem, type, fn) {
            var bound = function () {
                return fn.apply(elem, arguments);//改变上下文
            };
            elem.attachEvent("on" + type, bound);
            return bound;
        };
        this.removeEvent = function (elem, type, fn) {
            elem.detachEvent("on" + type, fn);
        }
    }
```

##28. 将事件委托给祖先元素：

假设一个表格在初始化加载的时候，所有的单元格都是白色背景，我们很想直观地表明，表格中的哪个单元格在与用户交互的时候被单机了。
```
丑陋的代码：
	var cells = document.getElementsByTagName("td");
    for (var n = 0; n < cells.length; n++) {
        addEvent(cells[n], "click", function () {
            this.style.backgroundColor = "yellow";
        });
    }

优雅的写法：
	var table = document.getElementById("#someTable");
    addEvent(table, "click", function (event) {
        if (event.target.tagName.toLowerCase() == "td") {
            event.target.style.backgroundColor = "yellow";//一个元素被单击的时候可以通过event.target获取该元素的引用
        }
    });
```
存在一个问题：在老版本IE浏览器中，submit和change事件根本没有冒泡，那么如何进行事件委托？

##29. 事件冒泡检测代码：

```
console.log(isEventSupported("click"));//true
function isEventSupported(eventName) {
    //创建一个div用于测试，通常各个事件都可以冒泡到div上来，包括change和submit
    var element = document.createElement("div"), isSupported;
    eventName = "on" + eventName;
    isSupported = (eventName in element);//检测元素是否有一个属性表示该事件
    //如果检测到没有这个属性，那就创建一个ontype并插入一点代码，然后判断该元素是否可以将其转换为一个函数
    //如果转换为一个函数，说明该元素知道如何解释冒泡事件
    if (!isSupported) {
        element.setAttribute(eventName, "return;");
        isSupported = typeof element[eventName] == 'function';
    }
    element = null;//删除临时元素
    return isSupported;
}
```