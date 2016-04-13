###1.HTML5功能

- Canvas(2D和3D)
- Channel消息传送
- Cross-document消息传送
- Geolocation
- MathML
- Microdata
- Server-Sent Events
- Scalable Vector Graphics(SVG)
- WebSocket API及协议
- Web Origin Concept
- Web Storage
- Web SQL database
- Web Workers
- XMLHttpRequest Level 2

###2.HTML5新的DOCTYPE和字符集
- `<!DOCTYPE html>`
- `<meta charset='utf-8'>`
使用HTML5的DOCTYPE会触发浏览器以标准兼容模式显示页面。众所周知，Web页面有多种显示模式，比如怪异模式、近标准模式以及标准模式。其中标准模式也被称为非怪异模式。浏览器会根据DOCTYPE来识别应该使用哪种模式，以及使用什么规则来验证页面。在怪异模式下，浏览器会尽量不中断页面显示，即使没有完全通过验证也会将其显示出来。

###3.新元素和旧元素

|内容类型|描述|
|---|---|
|内嵌|向文档中添加其他类型的内容，例如audio、video、canvas和iframe等|
|流|在文档和应用的body中使用的元素，form、h1和small等|
|标题|h1、h2和hgroup等|
|交互|与用户交互的内容，例如音频和视频的控件、button和textarea等|
|元数据|通常出现在页面的head中，设置页面其他部分的表现和行为，例如script、style和title等|
|短语|文本和文本标记元素，mark、kbd、sub和sup等|
|片段|用于定义页面片段的元素，article、aside和title等|

###4.语义化标记
|元素名|描述|
|-|-|
|header|标记头|
|footer|标记脚部区域|
|section|Web页面中的一块区域|
|article|独立的文章内容|
|aside|相关内容或者引文|
|nav|导航类辅助内容|

###5.使用Selecors API简化选取操作
|函数|描述|示例|结果|
|-|-|-|-|
|querySelector()|根据指定的选择规则，返回在页面中找到的第一个匹配元素|querySelector("input.error")|返回第一个CSS类名为"error"的文本输入框|
|querySelectorAll()|根据指定规则返回页面中所有相匹配的元素|querySelectorAll("#results td")|返回id值为results的元素下所有的单元格|

可以为Selectors API函数同时指定多个选择规则，例如：
`//选择文档中类名为highClass或lowClass的第一个元素`
`var x = document.querySelector(".highClass", ".lowClass");`

**提示：**Selectors API不仅仅只是方便，在遍历DOM的时候，Selectors API通常会比以前的子节点搜索API更快。为了实现快速样式表，浏览器对选择器匹配进行了高度优化。

###6.判断浏览器是否支持canvas

    document.createElement("canvas").getContext("2d");
检查浏览器canvas是否有getContext属性

###7.canvas使用

    function drawDiagonal() {
        //取得canvas元素及其绘图上下文
        var canvas = document.getElementById("diagonal");
        var context = canvas.getContext("2d");

        //用绝对坐标来创建一条路径
        context.beginPath();
        context.moveTo(70, 140);
        context.lineTo(140, 70);

        //将这条线绘制到canvas上
        context.stroke();
    }

    window.addEventListener("load", drawDiagonal, true);
- 首先通过引用特定的canvasID值来获取对canvas对象的访问权。接着定义一个context变量，调用canvas对象的getContext方法，并传入希望使用的canvas类型。代码中通过传入“2d”来获取一个二维上下文。
- 接下来，基于这个上下文执行画线的操作。在代码中，调用了三个方法——beginPath、moveTo和lineTo，传入了这条线的起点和终点的坐标。
- 方法moveTo和lineTo实际上并不画线，而是在结束canvas操作的时候，通过调用context.stroke()方法完成线条的绘制。

###8.使用HTML Geolocation API

检查浏览器支持性

    function loadDemo() {
        if (navigator.geolocation) {
            alert("支持定位！")
        }
    }

###9.跨文档消息通信

跨文档消息通信可以确保iframe、标签页、窗口间安全地进行跨源通信。它把postMessage API定义为发送消息的标准方式。利用postMessage发送消息非常简单，代码如下所示：`chatFrame.contentWindow.postMessage('Hello, world', 'http://www.example.com/');`

接收消息时仅需在页面中增加一个事件处理函数。当某个消息到达时，通过检查消息的来源来决定是否对这条消息进行处理。

	//消息事件监听器
    window.addEventListener("message", messageHandler, true);
    function messageHandler(e) {
        switch (e.origin) {
            case "friend.example.com":
                //处理消息
                processMessage(e.data);
                break;
            default:
            //消息来源无法识别
            //消息被忽略
        }
    }

####在调用postMessage前，应该首先检测浏览器是否支持它：

    if (typeof window.postMessage == undefined) {
        alert("该浏览器不支持postMessage");
    }

```
window.postMessage('Hello, world', 'http://www.example.com/');
```
第一个参数包含要发送的数据，第二个参数是消息传送的目的地。要发送消息给iframe，可以在相应iframe的contentWindow中调用postMessage，代码如下：

```
document.getElementsByTagName('iframe')[0].contentWindow.postMessage("Hello, World", "chat.example.net");
```
####监听消息事件并通过白名单鉴定源：

    var originWhiteList = ["XXX.com", "WWW.com"];
    function checkWhiteList(origin) {
        for (var i = 0; i < originWhiteList.length; i++) {
            if (origin === originWhiteList[i]) {
                return true;
            }
        }
        return false;
    }

    function messageHandler(e) {
        if (checkWhiteList(e.origin)) {

        } else {
            
        }
    }

###10.XMLHttpRequest Level 2
作为XMLHttpRequest的改进版，XMLHttpRequest Level2在功能上有了很大的改进。主要集中在一下两个方面：
- 跨源XMLHttpRequest;
- 进度事件

####跨源XMLHttpRequest
过去，XMLHttpRequest仅限于同源通信。XMLHttpRequest Level2通过CORS(Cross Origin Resource Sharing，跨源资源共享)实现了跨源XMLHttpRequest。

跨源HTTP请求包括了一个Origin头部，它为服务器提供HTTP请求的源信息。头部由浏览器保护，不能被应用程序代码更改。

####进度事件

XMLHttpRequest Level2用了一个有意义的名字Progess进度来命名进度事件。
- loadstart
- progress
- abort
- error
- load
- loadend

###11.WebSockets API

> HTML5 WebSockets是HTML5中最强大的通信功能，它定义了一个全双工通信信道，仅通过Web上的一个Socket即可进行实时通信。WebSocketss不仅仅是对常规HTTP通信的另一种增量加强，它更代表着一次巨大的进步，对实时的、事件驱动的Web应用程序而言更是如此。

- 目前实时Web应用的实现方式，大部分是围绕轮询和其他服务器端推送技术展开的，其中最著名的是**Comet**。Comet技术可以让服务器端主动以异步方式向客户端推送数据，它会使针对传输消息到客户端的相应延迟完成。

- **使用轮询时**，浏览器会定期发送HTTP请求，并随即接收响应。

- **使用长轮询时**，浏览器向服务器发送一个请求，服务器会在一段时间内将其保持在打开状态。如果服务器在此期间收到一个通知，就会向客户端发送一个包含消息的响应。如果时间已到却还没接收到通知，服务器会发送一个响应消息来终止打开的请求。

- **使用流解决方案时**，浏览器会发送一个完整的HTTP请求，但服务器会发送并保持一个处于打开状态的响应，该响应持续更新并无限期处于打开状态。每当有消息可发送时该响应就会被更新，但服务器永远不会发出响应完成的信号，这样连接就会一致保持在打开状态以便后续消息的发送。但是，由于流仍然是封装在HTTP中，其间的防火墙和代理服务器可能会对响应消息进行缓冲，造成消息传递的时延。因此，当检测到缓冲代理服务器时，许多流解决方案就回退到长轮询方式。

###12.Web Workers API

> HTML5 Web Workers可以让Web应用程序具备后台处理能力。它对多线程的支持性非常好，因此，使用了HTML5的JavaScript应用程序可以充分利用多核CPU带来的优势。

> 如果Web开发人员创建的Web应用程序需要执行一些后台数据处理，但又不希望这些数据处理任务影响Web页面本身的交互性，那么可以通过Web Workers生成一个Web Worker去执行数据处理任务，同时添加一个事件监听器区监听它发出的信息。

###13.使用HTML5离线Web应用API

####检查浏览器支持情况
```
if(window.applicationCache){
	//浏览器支持离线应用
}
```

####搭建简单的离线应用程序

假设开发人员希望搭建一个包含HTML文档、样式表和JS文件的单页应用程序，同时要为这个HTML5应用程序添加离线支持，那么可以在html元素中加入manifest特性：
```
<!DOCTYPE html>
<html manifest="application.manifest">
...
</html>
```

####缓存清单文件内容示例
```
CACHE MANIFEST
example.html
example.js
example.css
example.gif
```

####检查在线状态
```
//页面加载的时候，设置状态为online或offline
function loadDemo(){
	if(navigator.online){

	}
}

//添加事件监听器，在线状态发生变化时，触发相应动作
window.addEventListener("online", function(e){
	
},true);

window.addEventListener("offline", function(e){

},true);
```