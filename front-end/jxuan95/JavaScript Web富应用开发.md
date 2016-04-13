###《JavaScript Web富应用开发》读书笔记

###1.创建类

JavaScript中并没有真正的类，但JavaScript中有构造函数和new运算符。构造函数用来给实例对象初始化属性和值。任何JavaScript函数都可以用作构造函数，构造函数必须使用new运算符作为前缀来创建新的实例。

new运算符改变了函数的执行上下文，同时改变了return语句的行为。实际上，使用new和构造函数很类似于传统的实现了类的语言：

    var Person = function (name) {
        this.name = name;
    };

    //实例化一个Person
    var alice = new Person("alice");

    //检查这个实例
    assert(alice instanceof Person);
如果不使用new运算符而是：`Person('bob';)`这个函数只会返回undefined，并且执行上下文是window(全局)对象，无意间创建了一个全局变量name。调用构造函数时不要丢掉new关键字。

###2.给类添加函数

在JavaScript中，在构造函数中给类添加函数和给对象添加属性是一样的：

    Person.find - function (id) {};
    var person = Person.find(1);
要想给构造函数添加实例函数，则需要用到构造函数的prototype：

    Person.prototype.breath = function(){};
    var person = new Person;
    person.breath();

###3.取消事件

当事件冒泡时，可以通过stopPropagation()函数来终止冒泡，这个函数是event对象中的方法。比如这段代码，任何父节点事件回调都不会触发：

    button.addEventListener("click", function (e) {
        e.stopPropagation();
    }, false);

###4.事件对象

和上面提到的函数stopPropagation()和preventDefault()一样，event对象还包含很多有用的属性。

|事件类型|含义|
|---|---|
|bubbles|表示事件是否通过DOM以冒泡形式触发|
|button|表示鼠标所按下的按钮|
|ctrlKey|表示Ctrl键是否按下|
|altKey|表示alt键是否按下|
|shiftKey|表示Shift键是否按下|
|metaKey|表示Meta键是否按下|
|isChar|表示当前按下的键是否表示一个字符|
|charCode|表示当前按键的unicode值|
|keyCode|表示非字符按键的unicode值|
|which|表示当前案件的unicode值，不管当前按键是否表示一个字符|
|pageX,pageY|事件发生时相对于页面的坐标|
|screenX,screenY|事件发生时相对于屏幕的坐标|
|currentTarget|事件冒泡阶段所在的当前DOM元素|
|target,originalTarget|原始的DOM元素|
|relatedTarget|其他和事件相关的DOM元素|

###5.委托事件

从事件冒泡开始就发生了事件委托，我们可以直接给父元素绑定事件监听，用来检测在其子元素内发生的事件。

    //在ul列表上做了事件委托
    list.addEventListener("click", function (e) {
        if (e.currentTarget.tagName == "li") {
            return false;
        }
    }, false);

###6.原型继承

这里使用Object.create()来构造我们的ORM。这里使用基于原型的继承，而没有用到构造函数和new关键字。

Object.create()只有一个参数即原型对象，它返回一个新对象，这个新对象的原型就是传入的参数。换句话说，传入一个对象，返回一个继承了这个对象的新对象。

有些浏览器没有Object.create()方法，比如IE，可以模拟出该函数：

    if (typeof Object.create !== "function") {
        Object.create = function (o) {
            function F() {
            }

            F.prototype = o;
            return new F();
        }
    }

###7.JSONP
JSONP(JSON with padding)，这是另一种从远程服务器抓取数据的方式。原理是通过创建一个script标签，所辖的外部文件包含一段JSON数据，数据是由服务器所返回的，作为参数包装在一个函数调用中。script标签获取脚本文件并不受跨域限制，所有浏览器都支持这种技术。

###8.localstorage用法

    //设置一个值
    localStorage["someData"] = "wem";
    //存储数据的个数
    var itemsStored = localStorage.length;
    //设置一个项(是一种hash写法)
    localStorage.setItem("someData", "wem");
    //得到一个已经存储的值，如果不存在就返回Null
    localStorage.getItem("someData");//"wem";
    //删除一个项，如果不存在就返回null
    localStorage.removeItem("someData");
    //清空本地存储
    localStorage.clear();
数据均存储为字符串，所以如果你想保存的数据是对象或数字，则必须自己做类型转换，如果使用JSON的话，则需要将对象先做序列化处理再保存它们，从本地存储中读取JSON时也需要将它转换为对象：

    var object = {some: "boject"};
    //序列化并保存一个对象
    localStorage.setItem("seriData", JSON.stringify(object));
    //读取并将JSON转换为对象
    var result = JSON.parse(localStorage.getItem("seriData"));

###9.动态渲染视图

    var views = document.getElementById("views");
    views.innerHTML = "";//将元素内容清空
    var container = document.createElement("div");
    container.id = "user";
    var name = document.createElement("span");
    name.innerHTML = data.name;
    container.appendChild(name);
    views.appendChild(container);

###10.无交互行为内容的闪烁(FUBC)

有时候用户可能会看到页面闪了一下，出现一部分没有交互行为的内容快速闪过(FUBC)，比如在JavaScript执行之前会有一部分无样式的页面原始内容闪烁一下。如果你不依赖JavaScript来修改初始页面的样式，问题其实并不严重。但是如果依赖JavaScript来操作样式，则需要将样式提取出来放入初始化CSS之中，比如隐藏一些元素或展示一个加载指示器，指示页面正在加载中。

###11.获取文件信息

HTML5的文件操作有一定的安全限制，主要的限制是只有被用户选中的文件才能被访问。将文件拖曳至浏览器中、选择要输入的文件或将文件粘贴至Web应用中，这些操作当然可以满足这一安全限制。尽管已经有人实现了“基于JavaScript的文件系统”，但这里的访问都是基于沙箱的。显然，允许JavaScript无限制的操作文件会带来很严重的安全风险。

在HTML5中使用File对象来表示文件，它有三个属性：
- name：文件名，这是一个只读字符串；
- size：文件大小，这是一个只读的整数；
- type：文件的MIME类型，是一个只读字符串，如果类型没有指定就是空字符串；
- 出于安全的原因，文件的路径是无法得到的。

###12.拖曳

拖曳的实现非常简单。可以将元素的draggable属性设置为true来启用元素的拖曳。
`<div id="dragme" draggable="true">Drag me!</div>`

###13.WebSocket

WebSocket是HTML5规范的一部分，提供了基于TCP的双向的、全双工的socket连接。这意味着服务器可以直接将数据推送给客户端，而不需要开发者求助于长轮询或插件来实现。和之前的服务器推的技术相比，WebSocket有着巨大的优势，因为WebSocket是全双工的，而不是基于HTTP的，一旦建立链接就不会断掉。

###14.性能
- 提高性能：减少HTTP请求的数量。每一个HTTP请求除了有TCP开销以外，还包含了大量的头信息。保持最小的独立连接数可以保证用户的页面家在速度更快。
- 将多个脚本文件合并成为一个脚本文件，或将多个CSS合并成为一个样式表，能减少页面渲染所需的HTTP连接的数量。可以在部署或运行时这样做。
- 使用CSS Sprites技术合并多张小图成为一张大图，然后使用CSS的background-image和background-position属性在页面中显示对应的图片。只需要设定图片要显示的尺寸和背景位置的偏移坐标。
- 避免重定向也是减少HTTP请求的数量的方法。
- 理解浏览器如何下载资源也很重要。为了加快页面渲染，现代浏览器并行下载所需的资源。但是，在所有的样式表和脚本下载完成之前，页面是不会开始渲染的。
- script标签的defer属性：设置defer的脚本将和其他资源一起并行下载，它们是不会阻塞页面的渲染。HTML5还引入了一个新的脚本下载和执行的模式，称作async。通过设置async属性，脚本将在完成下载后等待合适的时机执行代码。这意味着有可能异步不会按照它们在页面中出现的顺序执行代码，这又可能导致脚本执行如有依赖顺序时出错。如果脚本没有依赖关系，async则是很有用的。

###15.缓存

- 缓存就是将最近请求的资源存储到本地，以便接下来的请求能从磁盘中使用这些资源，而不用再次去下载。
- 针对静态资源，可以通过添加一个表示“在很远的将来才过期”的Expires头，让缓存“永不”失效。这将保证浏览器只会下载一次该资源。所有的静态资源文件都应该这样设置，包括脚本、样式表和图片。`Expires: Thu, 20 March 2015 00:00:00 GMT`建议相对于当前日期设置一个表示“很远的将来”的失效日期。
- 但是如果想在那个时间之前让资源过期怎么办？在引用资源文件的URL查询参数中添加文件的修改时间。这样一来，任何时候文件被修改，资源文件的URL都会改变，也即清除了缓存。`<link rel="stylesheet" href="master.css?1231311516" type="text/css">`
- HTTP1.1引入了一类新的头，Cache-Control。它带给开发者更高级的缓存，同时还弥补了Expires的不足。Cache-Control的控制头信息有很多选项，可用逗号隔开：Cache-Control:max-age=3600, must-revalidate

> Cache-Control参数：

|参数|含义|
|---|---|
|max-age|指定资源的最大有效时间。和Expires不一样的是，该指令是相对于该请求的时间。|
|public|标记资源是可被缓存的，默认情况下，通过SSL或使用HTTP认证后访问的资源，缓存是关闭的|
|no-store|完全关闭缓存，动态内容才会更多的使用这个选项|
|must-revalidate|告诉缓存它们必须遵循任何你给定的信息，并基于这些信息来判断资源的新旧程度|

###16.源码压缩

JavaScript源码压缩是从脚本文件中删除不必要的字符，它不改变功能。样式表和HTML文件也可以被压缩。

###17.Gzip压缩

在Web上Gzip是最流行并且支持最广泛的压缩方式。

###18.使用CDN

内容分发网络(或叫CDN)为你的站点提供静态资源内容服务，以减少它们的加载时间。用户和Web服务器之间的距离对加载时间有直接的影响。CDN将你的内容部署在跨越多个地理位置的服务器上，故当用户发起一个请求时，可从就近的服务器得到响应资源。