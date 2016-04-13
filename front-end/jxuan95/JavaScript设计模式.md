###1.弱类型语言

> - 在JavaScript中，定义变量时不必声明其类型。但这并不意味着变量没有类型。一个变量可以属于几种类型之一，这取决于其包含的数据。JavaScript中有**三种原始类型**：布尔型、数值型和字符串类型(不区分整数和浮点数是JavaScript与大多数其他主流语言的一个不同之处)。此外，还有**对象类型**和包含可执行代码的**函数类型**，前者是一种复合数据类型(数组是一种特殊的对象，它包含着一批值的有序集合)。最后，还有**空类型(null)**和**未定义类型(undefined)**这两种数据类型。原始数据类型按值传送，而其他数据类型则按引用传送。
> - 与其他弱类型语言一样，JavaScript中的变量可以根据所赋的值改变类型。原始类型之间也可以进行类型转换。toString可以把数值或布尔值转为字符串。parseFloat和parseInt函数可以把字符串转变为数值。双重“非”可以把字符串或数值转变为布尔值：`var bool = !!num;`

###2.初谈闭包

> 匿名函数最有趣的用途是用来创建闭包。闭包是一个受到保护的变量空间，由内嵌函数生成。JavaScript具有函数级的作用域。这意味着定义在函数内部的变量在函数外部不能被访问。JavaScript的作用域又是词法性质的。这意味着函数运行在定义它的作用域中，而不是在调用它的作用域中。把这两个因素结合起来，就能通过把变量包裹在匿名函数中而对其加以保护。

###3.依赖于接口的设计模式
> 下面列出的设计模式，尤其依赖接口：
> - **工厂模式**。对象工厂所创建的具体对象会因具体情况而异。使用接口可以确保所创建出来的这些对象可以互换使用。也就是说，对象工厂可以保证其生产出来的对象都实现了必需的方法。
> - **组合模式**。如果不用接口你就不可能用这个模式。组合模式的中心思想在于可以将对象群体与其组成对象同等对待。这是通过让它们实现同样的接口来做到的。如果不进行某种形式的鸭式辨型或类型检查，组合模式就会失去大部分作用。
> - **装饰者模式**。装饰者通过透明地为另一对象提供包装而发挥作用。这是通过实现与另外那个对象完全相同的接口而做到的。对于外界而言，一个装饰者和它所包装的对象看不出有什么区别。
> - **命令模式**。代码中所有的命令对象都要实现同一批方法。通过使用接口，你为执行这些命令对象而创建的类可以不必知道这些对象具体是什么，只要知道它们都实现了正确的接口即可。

###4.用命名规范区别私用成员

> 在一些方法和属性的名称前面加下划线以示其私用性。下划线的这种用法是一个众所周知的命名规范，它表明一个属性(或方法)仅供对象内部使用，直接访问它或设置它可能会导致意想不到的后果。这有助于防止程序员对它的无意使用，却不能防止对它的有意使用。后一个目标的实现需要有真正私用性的方法。

###5.作用域
下面这个示例说明了JavaScript中作用域的特点：

    function foo() {
        var a = 10;

        function bar() {
            a *= 2;
        }

        bar();
        return a;
    }

在这个示例中，a定义在函数foo中，但函数bar可以访问它，因为bar也定义在foo中。bar在执行过程中将a设置为a乘以2。当bar在foo中被调用时它能够访问a，这可以理解。但是如果bar是在foo外部被调用呢？

    function foo() {
        var a = 10;

        function bar() {
            a *= 2;
            return a;
        }

        return bar;
    }

    var baz = foo();
    console.log(baz());//20
    console.log(baz());//40
    console.log(baz());//80

    var blat = foo();
    console.log(blat());//20

在上述代码中，所返回的对bar函数的引用被赋给变量baz。这个函数现在是在foo外部被调用，但它依然能够访问a。这是因为JavaScript的作用域是词法性的。**函数是运行在定义它们的作用域中(本例中是foo内部的作用域)，而不是运行在调用它们的作用域中。**只要bar被定义在foo中，它就能访问在foo中定义的所有变量，即使foo的执行已经结束。
这就是闭包的一个例子。在foo返回后，它的作用域被保存下来，但只有它返回的那个函数能够访问这个作用域。在前面的示例中，baz和blat各有这个作用域及a的一个副本，而且只有它们自己能对其进行修改。返回一个内嵌函数是创建闭包最常用的手段。

###6.用闭包实现私用成员的弊端

> 在门户打开型对象创建模式中，所有方法都创建在原型对象中，因此不管派生多少对象实例，这些方法在内存中只存在一份。而包含特权方法、私用成员的创建模式中，每生成一个新的对象示例都将为每一个私用方法和特权方法生成一个新的副本。这会比其他做法耗费更多内存，所以只宜用在需要真正的私用成员的场合。这种对象创建模式也不利于派生子类，因为所派生出的子类不能访问超类的任何私用属性或方法。相比之下，在大多数语言中，子类都能访问超类的所有私有属性和方法。故在JavaScript中用闭包实现私用成员导致的派生问题称为“继承破坏封装”。

###7.静态方法和属性
> 前面所讲的作用域和闭包的概念可用于创建静态成员，包括公用和私用的。大多数方法和属性所关联的是类的实例，而静态成员所关联的则是类本身。换句话说，静态成员是在累的层次上操作，而不是在实例的层次上操作。每个静态成员都只有一份。稍后将会看到，静态成员是直接通过类对象访问的。
> 下面是添加了静态属性和方法的Book类：

    var Book = (function () {

        //私有静态变量
        var numOfBooks = 0;

        //私有静态方法
        function checkIsbn(isbn) {

        }

        //返回一个构造器
        return function (newIsbn, newTitle, newAuthor) {
            //私有属性
            var isbn, title, author;

            //特权方法
            this.getIsbn = function () {
                return isbn;
            };
            this.setIsbn = function (newIsbn) {
                if (!checkIsbn(newIsbn)) {
                    throw new Error('Book: Invalid ISBN.');
                }
                isbn = newIsbn;
            };
            this.getTitle = function () {
                return title;
            };
            this.setTitle = function (newTitle) {
                title = newTitle || "No title specified";
            };
            this.getAuthor = function () {
                return author;
            };
            this.setAuthor = function (newAuthor) {
                author = newAuthor || "No author specified";
            };

            //Constructed code.
            numOfBooks++;
            if (numOfBooks > 50) {
                throw new Error(".");
            }
            this.setIsbn(newIsbn);
            this.setTitle(newTitle);
            this.setAuthor(newAuthor);
        }
    })();

    //公共静态方法
    Book.convertToTitleCase = function (inputString) {

    };

    //公共非特权方法
    Book.prototype = {
        display: function () {

        }
    };
这里的私用成员和特权成员仍然被声明在构造器中(分别使用var和this关键字)。但哪个构造器却从原来的普通函数变成了一个内嵌函数，并且被作为包含它的函数的返回值赋给变量Book。这就创建了一个闭包，你可以把静态的私用成员声明在里面。位于外层函数声明之后的一对空括号很重要，其作用是一段代码载入就立即执行这个函数(而不是在调用Book构造函数时)。这个函数的返回值是另一个函数，它被赋给Book变量，Book因此成了一个构造函数。在实例化Book时，所调用的是这个内层函数。外层那个函数只是用于创建一个可以用来存放静态私用成员的闭包。
> - 在本例中，checkIsbn被设计为静态方法 ，原因是为Book的每个实例都生成这个方法的一个新副本毫无道理。此外还有一个静态属性numOfBooks，其作用在于跟踪Book构造器的总调用次数。本例利用这个属性将Book实例的个数限制为不超过50个。
> - 这些私用的静态成员可以从构造器内部访问，这意味着所有私用函数和特权函数都能访问它们。与其他方法相比，它们有一个明显的优点，那就是内存中只会存放一份。因为其中那些静态方法被声明在构造器之外，所以它们不是特权方法，不能访问任何定义在构造器中的私用属性。定义在构造器中的私用方法能够调用那些私用静态方法，反之则不然。要判断一个私用方法是否应该被设计为静态方法，一条经验法则是看它是否需要访问任何实例数据。如果它不需要，那么将其设计为静态方法会更有效率(从内存占用的意义上来讲)，因为它只会被创建一份。
> - 创建公用的静态成员则容易得多，只需直接将其作为构造函数这个对象的属性创建即可，前述代码中的方法converToTitleCase就是一例。这实际上相当于把构造器作为命名空间来使用。
> - 所有公用静态方法如果作为独立的函数来声明其实也同样简单，但最好还是像这样把相关行为集中在一起。这些方法用于与类这个整体相关的任务，而不是与类的任一特定实例相关的任务。它们并不直接依赖于对象实例中包含的任何数据。

###8.私用变量模仿常量
> 通过创建只有取值器而没有赋值器的私用变量可以模仿常量。

    var Class = (function () {
        var UPPER_BOUND = 100;

        //构造器
        var ctor = function (constructorArgument) {

        };
        //静态特权方法
        ctor.getUPPER_BOUND = function () {
            return UPPER_BOUND;
        };
        return ctor;

    })();

###9.封装之弊
> - 私用方法很难进行单元测试。因为它们及其内部变量都是私用的，所以在对象外部无法访问到它们。这个问题没有什么很好的应对之策。你要么通过使用公用方法来提供访问途径(这样一来就葬送了使用私有方法所带来的大多数好处)，要么设法在对象内部定义并执行所有单元测试。最好的解决办法是只对公用方法进行单元测试。这应该能覆盖到所有私用方法，尽管对它们的测试只是间接的。这种问题不是JavaScript所独有的，只对公用方法进行单元测试是一种广为接收的处理方式。
> - 使用封装意味着不得不与复杂的作用域链打交道。
> - 封装可能会损害类的灵活性，致使其无法被用于某些你未曾想到过的目的。

###10.单体模式

> 单体模式是JavaScript中最基本但又最有用的模式之一，它可能比其他任何模式都更常用。这种模式提供了一种将代码组织为一个逻辑单元的手段，这个逻辑单元中的代码可以通过单一的变量进行访问。通过确保单体对象只存在一份实例，你就可以确信自己的所有代码使用的都是同样的全局资源。
> 单体类在JavaScript中有许多用处。它们可以用来划分命名空间，以减少网页中全局变量的数目。更重要的是，借助于单体模式，你可以把代码组织得更为一致，从而使其更容易阅读和维护。

###11.单体的基本结构

    var Singleton = {
        attribute1: true,
        attribute2: 10,
        method1: function () {

        },
        method2: function (args) {

        }
    };
- 这个单体对象可以被修改。你可以为其添加新成员，这一点与别的对象字面量没有什么不同。你也可以用delete运算符删除其现有成员。这实际上违背了面向对象设计的一条原则：类可以被扩展，但不应该被修改。
- 按传统的定义，单体是一个只能被实例化一次并且可以通过一个众所周知的访问点访问的类。要是严格按照这个定义来说，前面的例子所示的并不是一个单体，因为它不是一个可实例化的类。我们打算把单体模式定义的更广义一些：单体是一个用来划分命名空间并将一批相关方法和属性组织在一起的对象，如果可以被实例化，那么它只能被实例化一次。

###12.划分命名空间
为了避免无意中改写变量，最好的解决办法之一是用单体对象将代码组织在命名空间之中。下面是前面的例子用单体模式改良后的结果：

    var MyNamespace = {
        findProduct: function (id) {

        }
    };
现在findProduct函数是MyNamespace中的一个方法，它不会被全局命名空间中声明的任何新变量改写。要注意，该方法仍然可以从各个地方访问。不同之处在于现在其调用方式不是findProduct(id)，而是MyNamespace.findProduct(id)。还有一个好处就是，这可以让其他程序员大体知道这个方法的声明地点及其作用。用命名空间把类似的方法组织到一起，也有助于增强代码的文档性。

###13.模块模式
> 有一种单体模式被称为模块模式，因为它可以把一批相关方法和属性组织为模块并起到划分命名空间的作用。例如：

    MyNamespace.Singleton = (function () {
        //私有成员
        var privateAttribute1 = false;
        var privateAttribute2 = [1, 2, 3];

        function privateMethod1() {

        }

        function privateMethod2() {

        }

        return {
            //public members
            publicAttribute1: true,
            publicAttribute2: 10,
            publicMethod1: function () {

            },
            publicMethod2: function (args) {

            }
        }
    })();

###14.简单工厂模式

> 最好用一个例子来说明简单工厂模式的概念。假设你想开几个自行车商店，每个店都有几种型号的自行车出售。这可以用一个类来表示：

	/*BicycleShop class.*/
    var BicycleShop = function () {

    };

    BicycleShop.prototype = {
        sellBicycle: function (model) {
            var bicycle;
            switch (model) {
                case "The Speedster":
                    bicycle = new SpeedSter();
                    break;
                case "The Lowrider":
                    bicycle = new Lowrider();
                    break;
                case "The Comfort Cruiser":
                default:
                    bicycle = new ComfortCruiser();
            }
            Interface.ensureImplements(bicycle, Bicycle);
            bicycle.assemble();
            bicycle.wash();
            return bicycle;
        }
    };
> sellBicycle方法根据所要求的自行车型号用switch语句创建一个自行车的实例。各种型号的自行车实例可以互换使用，因为它们都实现了Bicycle接口：

    /* The Bicycle interface. */
    var Bicycle = new Interface('Bicycle', ['assemble', 'wash', 'ride', 'repair']);

    /* Speedster class. */
    var Speedster = function () {

    };
    Speedster.prototype = {
        assemble: function () {
        },
        wash: function () {
        },
        ride: function () {
        },
        repair: function () {
        }
    };

> 要出售某种型号的自行车，只要调用sellBicycle方法即可：

    var californiaCruisers = new BicycleShop();
    var yourNewBike = californiaCruisers.sellBicycle("The Speedster");

> 在情况发生变化之前，这倒也挺管用。但要是你想在供货目录中加入一款新车型又会怎么样呢？你得为此修改BicycleShop的代码，哪怕这个类的实际功能实际上并没有发生改变——依旧是创建一个自行车的新实例，组装它，清洗它，然后把它交给顾客。更好的解决办法是把sellBicycle方法中“创建新实例”这部分工作转交给一个简单工厂对象：

    /* BicycleFactory namespace. */
    var BicycleFactory = {
        createBicycle:function(model){
            var bicycle;
            switch (model) {
                case "The Speedster":
                    bicycle = new SpeedSter();
                    break;
                case "The Lowrider":
                    bicycle = new Lowrider();
                    break;
                case "The Comfort Cruiser":
                default:
                    bicycle = new ComfortCruiser();
            }
            Interface.ensureImplements(bicycle, Bicycle);
            return bicycle;
        }
    };

BicycleFactory是一个单体，用来把createBicycle方法封装在一个命名空间中。这个方法返回一个实现了Bicycle接口的对象，然后你可以照常对其进行组装和清洗：

    /* BicycleShop class, improved. */
    var BicycleShop = function () {
    };
    BicycleShop.prototype = {
        sellBicycle: function (model) {
            var bicycle = BicycleFactory.createBicycle(model);
            bicycle.assemble();
            bicycle.wash();
            return bicycle;
        }
    };

这个BicycleFactory对象可以供各种类用来创建新的自行车实例。有关可供车型的所有信息集中在一个地方管理 ，所以添加更多车型很容易：

    /* BicycleFactory namespace,with more models. */
    var BicycleFactory = {
        createBicycle: function (model) {
            var bicycle;
            switch (model) {
                case "The Speedster":
                    bicycle = new SpeedSter();
                    break;
                case "The Lowrider":
                    bicycle = new Lowrider();
                    break;
                case "The Flatlander":
                    bicycle = new Flatlander();
                    break;
                case "The Comfort Cruiser":
                default:
                    bicycle = new ComfortCruiser();
            }
            Interface.ensureImplements(bicycle, Bicycle);
            return bicycle;
        }
    };

###15.工厂模式

> 真正的工厂模式与简单工厂模式的区别在于，它不是另外使用一个类或对象来创建自行车，而是使用一个子类。按照正式定义，工厂是一个将其成员对象的实例化推迟到子类中进行的类。

###16.工厂模式的适用场合

> - 动态实现：如果需要创建一些用不同方式实现同一接口的对象，那么可以使用一个工厂方法或简单工厂对象来简化选择实现的过程。
> - 节省设置开销：如果对象需要进行复杂并且彼此相关的设置，那么使用工厂模式可以减少每种对象所需的代码量。如果这种设置只需要为特定类型的所有实例执行一次即可，这种作用尤为突出。把这种设置代码放到类的构造函数中并不是一种高效的做法，这是因为即便设置工作已经完成，每次创建新实例的时候这些代码还是会执行，而且这样做会把设置代码分散到不同的类中。工厂方法非常适合于这种场合。它可以在实例化所有需要的对象之前先一次性地进行设置。无论有多少类会被实例化，这种办法都可以让设置代码集中在一个地方。
> - 用许多小型对象组成一个大对象

###17.工厂模式之利

> - 工厂模式的主要好处在于消除对象间的耦合。通过使用工厂方法而不是new关键字及具体类，你可以把所有实例化的代码集中在一个位置。这可以大大简化更换所用的类或在运行期间动态选择所用的类的工作。在派生子类时它也提供了更强大的灵活性。
> - 所有这些好处都与面向对象设计的这两条原则有关：弱化对象间的耦合；防止代码的重复。在一个方法中进行类的实例化，可以消除重复性的代码。这是在用一个对接口的调用取代一个具体的实现。这些都有助于创建模块化的代码。


###18.桥接模式

桥接模式最常见和实际的应用场合之一就是事件监听器回调函数。假设有一个名为getBeerById的API函数，它根据一个标识符返回有关某种啤酒的信息。你希望用户在点击的时候获取这种信息。那个被点击的元素很可能有啤酒的标识符信息，它可能是作为元素自身的ID保存，也可能是作为别的自定义属性保存。下面是一种做法：

    addEvent(element, 'click', getBeerById);
    function getBeerById(e) {
        var id = this.id;
        asyncRequest('GET', 'beer.uri?id=' + id, function (resp) {
            console.log(resp.responseText);
        });
    }
这个API只能工作在浏览器中，如果要对这个API函数做单元测试，或者在命令行中执行，可能会报错。一个优良的API设计，不应该把它与任何特定的实现搅在一起。

    function getBeerById(id, callback) {
        asyncRequest('GET', 'beer.uri?id=' + id, function (resp) {
            callback(resp.responseText);
        })
    }
现在我们将针对接口而不是实现进行编程，用桥接模式把抽象隔离开来：

    addEvent(element, 'click', getBeerByIdBridge);
    function getBeerBIdBridge(e) {
        getBeerById(this.id, function (beer) {
            console.log(beer);
        });
    }
这下getBeerById并没有和事件对象捆绑在一起了。

###19.用桥接模式联结多个类

    var Class1 = function (a, b, c) {
        this.a = a;
        this.b = b;
        this.c = c;
    };
    var Class2 = function (d) {
        this.d = d;
    };
    var BridgeClass = function (a, b, c, d) {
        this.one = new Class1(a, b, c);
        this.two = new Class2(d);
    };

###20.适配器模式

适配器模式可以用来在现有接口和不兼容的类之间进行适配。使用这种模式的对象又叫包装器，因为它们是在用一个新的接口包装另一个对象。

###21.适配器的特点

- 适配器可以被添加到现有代码中以协调两个不同的接口。如果现有代码的接口能很好地满足需要，那就可能没有必要使用适配器。
- 从表面上看，适配器模式很像门面模式。它们都要对别的对象进行包装并改变其呈现的接口。二者的差别在于它们如何改变接口。门面元素展现的是一个简化的接口，它并不提供额外的选择，而且有时为了方便完成某些常见任务它还会做出一些假定。而适配器则要把一个接口转换为另一个接口，它并不会滤除某些能力，也不会简化接口。如果客户系统期待的API不可用，那就需要用到适配器。
- 适配器可被实现为不兼容的方法调用之间的一个代码薄层。
- 示例：
- 假如你有一个对象还有一个以三个字符串为参数的函数：
```
    var clientObject = {
        string1: "foo",
        string2: "bar",
        string3: "baz"
    };
    function interfaceMethod(str1, str2, str3) {

    }
```
为了把clientObject作为参数传递给interfaceMethod，需要用到适配器。我们可以这样创建一个：

    function clientToInterfaceAdapter(o) {
        interfaceMethod(o.string1, o.string2, o.string3);
    }
    //现在就可以把整个对象传给这个函数
    clientToInterfaceAdapter(clientObject);

clientToInterfaceAdapter函数的作用就在于对interfaceMethod函数进行包装，并把传递给它的参数转换给后者需要的形式。

###22.装饰者模式

> 装饰者模式可用来透明地把对象包装在具有同样接口的另一对象中。这样一来，你可以给一个方法添加一些行为，然后将方法调用传递给原始对象。相对于创建子类来说，使用装饰者对象是一种更灵活的选择。

###23.享元模式

> 享元模式最适合于解决因创建大量类似对象而累及的性能问题。这种模式在JavaScript中尤其有用，因为复杂的JavaScript代码可能很快就会用光浏览器的所有可用内存。通过把大量独立对象转化为少量共享对象，可以降低运行Web应用程序所需的资源数量。

享元模式用于减少应用程序所需对象的数量。这是通过将对象的内部状态划分为内在数据和外在数据两类而实现的。内在数据是指类的内部方法所需的信息，没有这种数据的话类不能正常运转。外在数据则是可以从类身上剥离并存储在其外部的信息。我们可以将内在状态相同的所有对象替换为同一个共享对象，这种方法可以把对象数量减少到不同内在状态的数量。

###24.实现享元模式的一般步骤

1. **将所有外在数据从目标剥离。**具体做法是尽可能多地删除该类的属性，所删除的应该是那种因实例而异的属性。构造函数的参数也要这样处理。这些参数应该被添加到该类的各个方法。这些外在数据现在不再保存在类的内部，而是由管理器提供给类的方法。经过这样的处理后，目标类应该依然具有与之前一样的功能。唯一的区别在于数据的来源发生了变化。
2. **创建一个用来控制该类的实例化的工厂。**这个工厂应该掌握该类所有已创建出来的独一无二的实例。**其具体做法之一是用一个对象字面量来保存每一个这类对象的引用，并以用来生成这些对象的参数的唯一性组合作为它们的索引。**这样一来，每次要求工厂提供一个对象时，它会先检查那个对象字面量，看看以前是否请求过这个对象。如果是，那么只要返回那个现有对象的引用就行。否则它会创建一个新对象并将其引用保存在那个对象字面量中，然后返回这个对象。**另一种做法称为对象池**，这种技术用数组来保存所创建的对象的引用。它适合于注重可用对象的数量而不是那些单独配置的实例的场合。这种技术可用来将所实例化的对象的数目维持在最低值。工厂会处理根据内在数据创建对象的所有事宜。
3. **创建一个用来保存外在数据的管理器。**该管理器对象负责控制处理外在数据的种种事宜。在实施优化之前，要是需要一个目标类的实例，你会把所有数据传给构造函数以创建其新实例。而现在要是需要一个实例，你会调用管理器的某个方法，把所有数据都提供给它。这个方法会分辨内在数据和外在数据。它把内在数据提供给工厂对象以创建一个对象(或者，如果已经存在这样一个对象的话，则重用该对象)。外在数据则被保存在管理器内的一个数据结构中。管理器随后会根据需要将这些数据提供给共享对象的方法，其效果就如同该类有许多实例一样。

###25.观察者模式

- 在事件驱动的环境中，比如浏览器这种持续寻求用户关注的环境中，观察者模式(又名发布者-订阅者模式)是一种管理人与其任务之间的关系(确切的说，是对象及其行为和状态之间的关系)的得力工具。
- 观察者模式中存在两个角色：观察者和被观察者。