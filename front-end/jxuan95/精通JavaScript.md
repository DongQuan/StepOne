![图片发自简书App](http://upload-images.jianshu.io/upload_images/1388624-78b2491f0d0325a5.jpg)
##1.使用构造函数属性来判断对象的类型
```
//检查数字实际上是否为字符串
if (num.constructor == String) {
    //如果是，则把字符串解析为整数
    num = parseInt(num);
}
//检查字符串实际上是否为数组
if (str.constructor == Array) {
    //如果是，则根据数组用逗号归并出字符串来
    str = str.join(',');
}
```

##2.变量的类型检查

| 变量      |    typeof变量 | 变量.构造函数  |
| :-------- | --------:| :--: |
| {an:"object"}  | object |  Object  |
|["an","array"]|object|Array|
|function(){}|function|Function|
|"a string"|string|String|
|55|number|Number|
|true|boolean|Boolean|
|new User()|object|User|

##3. 用闭包实现的函数Curry化
```
//数字求和函数的函数生成器
function addGenerator(num) {
    //返回一个简单的函数，求两个数字的和，其中第一个数字来自生成器
    return function (toAdd) {
        return num + toAdd
    }
}
//addFive现在包含一个接受单一参数的函数，这个函数能求得5加上该参数的和
var addFive = addGenerator(5);
console.log(addFive(4));//输出9
```

##4.使用匿名函数来隐藏全局作用域变量

```
(function(){
    //变量原本应该是全局的
    var msg = "test";
    //将一个新函数绑定到全局对象
    window.onunload = function(){
        //这个函数使用了隐藏的msg
        alert(msg);
    };
    //关闭匿名函数并执行
})();
```

##5.使用匿名函数来激发出创建多个使用闭包的函数所需的作用域
```
//一个ID为main的元素
var obj = document.getElementById("main");
//用于绑定一个数组
var items = ["click", "keypress"];
//遍历数组的每个成员
for (var i = 0; i < items.length; i++) {
    //使用一个自执行的匿名函数来激发出作用域
    (function () {
        //记住在这个作用域内的值
        var item = items[i];
        obj["on" + item] = function () {
            /item引用本for循环上下文所属作用域中的一个父变量
            alert("alert" + item);
        }
    })();
}
```

##6.在上下文对象内使用函数并将其上下文对象切换为另一个变量

    var obj = {
        yes: function () {
            //this==obj
            this.val = true;
        },
        no: function () {
            this.val = false;
        }
    };

    //我们发现'obj'对象没有val属性
    alert(obj.val == null);
    
    //执行yes函数后，将val属性与'obj'对象关联起来
    obj.yes();
    alert(obj.val == true);
    
    //不过现在把window.no指向obj.no并执行之
    window.no = obj.no;
    window.no();
    
    //结果是obj对象的val不变（因为no的上下文已经变为window对象了）
    alert(obj.val == true);
    
    //而window的val属性被更新了
    alert(window.val == false);


把obj.no变量的上下文对象切换为window变量时，代码变得不好理解了。幸运的是，JavaScript提供了一套方法来让这一过程变得更好理解和实现。即call和apply两个方法。

##7.修改函数上下文对象的例子

    //一个设置上下文对象颜色样式的简单函数
    function changeColor(color) {
        this.style.color = color;
    }
    
    //在window对象中调用此函数会失败，因为window对象没有style属性
    changeColor("white");

    //找出ID为main的文档
    var main = document.getElementById("main");

    //使用call方法将它的颜色置为黑色
    changeColor.call(main, "black");

    //设置body元素颜色的函数
    function setBodyColor() {
        //apply方法将上下文对象设置为第一个参数指定的body元素，第二个参数是传给函数的所有参数的数组
        changeColor.apply(document.body, arguments);
    }

    //将body的背景色置为黑色
    setBodyColor("black");


##8.使用constructor属性的例子

    //创建一个新的简单的User对象
    function User() {
    }

    //创建一个User对象
    var me = new User();

    //还是创建一个新的User对象（用前一个对象的constructor引用来创建）
    var you = new me.constructor();

    //你可以发现这两个对象的constructor实质上是一致的
    alert(me.constructor == you.constructor);


##9.对象的方法通过prototype对象添加的例子

    //创建一个新的User构造函数
    function User(name, age) {
        this.name = name;
        this.age = age;
    }

    //将一个新的函数添加到此对象的prototype对象中
    User.prototype.getName = function () {
        return this.name;
    };

    //并再给此prototype对象添加一个函数，注意其上下文是实例化后的对象
    User.prototype.getAge = function () {
        return this.age;
    };

    //实例化一个新的User对象
    var user = new User("Bob", 44);

    //可以看到我们添加的这两个属性都在刚才创建的对象中，并且有合适的上下文
    alert(user.getName == "Bob");
    alert(user.getAge == 44);

##10.私有方法
> 私有方法和私有变量只允许其他的私有方法、私有变量和特权方法访问。这种方法可以定义一些只让对象内部访问，而外部访问不到的代码。

    //表示教室的一个对象构造函数
    function Classroom(students, teacher) {
        //用于显示所有班上学生的私有方法
        function disp() {
            alert(this.names.join(","));
        }

        //将班级数据存入公共对象属性中
        this.students = students;
        this.teacher = teacher;

        //调用私有方法来显示错误
        disp();
    }

    //创建一个新的classroom对象
    var c = new Classroom(["John", "Bob"], "Mr. Smith");

    //调用disp方法会失败，因为它不是该对象的公共属性
    c.disp();

##11.特权方法

> 特权方法用来指代哪些在查看并处理私有变量的同时允许用户以公共方法的方式访问的方法。

    //创建一个新的User对象构造函数
    function User(name, age) {
        //尝试算出用户出生的年份
        var year = (new Date()).getFullYear() - age;

        //创建一个新的特权方法，能够访问year变量，同时自身属于公共可访问的
        this.getYearBorn = function () {
            return year;
        }
    }

    //创建User对象的一个新示例
    var user = new User("Bob", 44);

    //验证返回的年份正确
    alert(user.getYearBorn() == 1962);

    //注意我们无法访问该对象私有的年份属性
    alert(user.year == null);

##12.静态方法

> 静态方法的实质与任何其他一般函数没有什么不同，最主要的区别在于，其他函数是以对象的静态属性形式存在的。作为一个属性，它们不能在该对象的实例的上下文中访问，而只属于主对象本身的那个上下文中。

    //添加到一个User对象的静态方法
    User.clnoeUser = function (user) {
        //创建并返回一个新的用户
        return new User(user.getName(), user.getAge());
    };

##13.原型式继承的例子
    //为Person对象创建一个构造函数
    function Person(name) {
        this.name = name;
    }

    //给Person对象添加一个新方法
    Person.prototype.getName = function () {
        return this.name;
    };

    //创建一个新的User对象的构造函数
    function User(name, password) {
        //注意，这里并没有支持方法的重载/集成，也就是说，不能调用父类的构造函数
        this.name = name;
        this.password = password;
    }

    //User对象继承所有Person对象的方法
    User.prototype = new Person();

    //我们添加一个新方法到User对象中
    User.prototype.getPassword = function () {
        return this.password;
    };

##14.JavaScript中的命名空间化及其实现

    //创建一个默认的、全局的命名空间
    var YAHOO = {};

    //使用对象设置一些子命名空间
    YAHOO.util = {};

    //创建最终命名空间，它包含一个值为函数的属性
    YAHOO.util.Event = {
        addEventListener: function () {

        }
    };

    //调用某个具体命名空间中的函数
    YAHOO.util.Event.addEventListener();