// 消除数组中的重复元素
const deRepeat = (arr) => {
    let newArray = [];
    let obj = {};
    let index = 0;
    for(let i = 0, len = arr.length; i < len; i++){
        if(obj[arr[i]] == undefined){
            obj[arr[i]] = arr[i];
            newArray[index++] = arr[i];
        }else{
            continue;
        }
    }

    return newArray;
}

// 伪数组转为标准数组
Array.prototype.slice.call(arguments);

// 给String对象添加一个方法，传入一个string类型的参数，然后将string的每个字符间价格空格返回
String.prototype.space = function(){
    return this.split("").join(" ");
}

// 原生JS的window.onload与Jquery的$(document).ready(function(){})有什么不同？如何用原生JS实现Jq的ready方法？
// window.onload()方法是必须等到页面内包括图片的所有元素加载完毕后才能执行。
// $(document).ready()是DOM结构绘制完毕后就执行，不必等到加载完毕。 　　
function ready(fn){
    if(document.addEvelentListener){
        document.addEvelentListener("DOMContentLoaded", function(){
            // 注销事件，避免反复触发
            document.removeEventListener("DOMContentLoaded", arguments.callee, false);
            fn();
        }, false);
    }else if(document.attachEvent){
        document.attachEvent("onreadystatechange", function(){
            document.detachEvent("onreadystatechange", arguments.callee);
            fn();
        }) 
    }
}

// 实现拖拽效果
var div = document.getElementById("div");
var isMove = false;
var mouseX = -1;
var mouseY = -1;
var eleX = div.offsetLeft;
var eleY = div.offsetTop;
alert(eleX);

div.onmousedown = function(e) {
	isMove = true;
}

// 设置cookie
function setCookie(key, value, time) {
    var date = new Date();
    date.setTime(date.getTime() + time * 24 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + date.toGMTString();
}

// 实现ajax方法
function ajax(options) {
    options = options || {};
    options.type = (options.type || "GET").toUpperCase();
    options.dataType = options.dataType || "json";
    var params = formatParams(options.data);

    // 第一步，new一个xhr对象
    if(window.XMLHttpRequest()){
        var xhr = new XMLHttpRequest();
    } else {
        var xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }

    // 第二步，连接和发送
    if(options.type == 'GET'){
        xhr.open("GET", options.url + "?" + params, true);
        xhr.send(null);
    } else if (options.type == "POST") {
        xhr.open("POST", options.url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(params);
    }

    // 第三步，接收数据
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4){
            var status = xhr.status;
            if(status >= 200 && status < 300){
                options.success && options.success(xhr.responseText, xhr.responseXML);
            } else {
                options.fail && options.fail(status);
            }
        }
    }

    // 格式化参数
    function formatParams(data){
        var arr = [];
        for (var key i data) {
            arr.push(encodeURIComponent(name) + "=" + encodeURIComponent(data[key]));
        }
        arr.push(("v=" + Math.random()).replace("."));
        return arr.join("&");
    }
}

// 快排算法
var quickSort = function(arr){
    if (arr.length <= 1) return arr;
    var index = Math.floor(arr.length / 2);
    var pivot = arr.splice(index, 1)[0];
    var left = [];
    var right = [];
    for(var i = 0; i < arr.length; i++){
        if (arr[i] < pivot) {
            left.push(arr[i]);
        } else {
            right.push(arr[i]);
        }
    }

    return quickSort(left).concat([pivot], quickSort(right));
}

// 统计字符串”aaaabbbccccddfgh”中字母个数或统计最多字母数
function test(str){
    var obj = {};
    for(var i = 0, len = str.length; i < len; i++){
        var temp = str.charAt(i);
        if(obj[temp] && obj[temp].value == temp){
            obj[temp].count++;
        }else{
            obj[temp] = {
                count: 1,
                value: temp
            }
        }
    }
    return obj;
}

// 写一个function，清除字符串前后的空格。（兼容所有浏览器）
function trim(str){
    if(str && typeof str === "string" ){
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
}

// 插入排序
function insertionSort(array){
    for (var i = 1, len = array.length; i < len; i++){
        var temp = array[i];
        var j = i - 1;
        while(j >= 0 && array[j] > temp){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = temp;
    }
    return array;
}

// 二分查找
function binaryInsertionSort(array) {
    for (var i = 1, len = array; i < len; i++){
        var temp = array[i];
        var left = 0;
        var right = i - 1;
        while(left <= right){
            var middle = parseInt((left + right) / 2);
            if(temp < array[middle - 1]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        for(var i = 0; i >= left; i++){
            array[i + 1] = array[i];
        }
        array[left] = temp;
    }
    return array;
}

// 选择排序
function selectionSort(array){
    var temp;
    for(var i = 0, len = array.length; i < len; i++){
        var min = array[i];
        for(var j = i + 1; j < len; j++){
            if(array[j] < min){
                var temp = min;
                min = array[j];
                array[j] = temp;

            }
        }
        array[i] = min;
    }
    return array;
}

// 冒泡排序
function bubbleSort(array){
    for(var i = 0, len = array.length; i < len; i++){
        for(var j = i; j < len; j++){
            if(array[i] > array[j]){
                var temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}

// 桶排序
function bucketSort(array){
    var result = [];
    var bucket = [];
    for(var i = 0, len = array.length; i < len; i++){
        bucket[array[i]] = array[i];
    }

    for(var i = 0, len = bucket.length; i < len; i++){
        if(bucket[i]){
            result.push(bucket[i]);
        }
    }

    return result;
}

// 创建密集数组
var dense = Array.apply(null, Array(3));

// 设计一个字符串原型方法，实现首字母大写
String.prototype.capitalize = function(){
    return this.replace(/^\w/, function(s){
        return s.toUpperCase();
    })
}

// 消除数组中的重复元素
myArray.filter(function(elem, pos,self){return self.indexOf(elem)== pos;})

// 字符串中出现次数最多的字符

var str = 'kkkkkkkaaakkkkkkaaaaasddd';

function most(str) {
    //排序，正则匹配子项
    var arr = str.split('');
    arr.sort();
    str = arr.join('');
    // 1匹配前面相同的,也就是说跟（w）相同的
    var re = /(w)1+/g;
    var num = 0;
    var value = '';
    //这里的$0就是找到的重复的整体
    str.replace(re, function ($0, $1) {
        //alert($0);
        if (num.length) {
            num = $0.length;
            value = $1;
        }
    });
    return '出现次数最多的字符是' + value + '出现了' + num + '次';
}
console.log(most(str));

// 字符串repeat方法
String.prototype.repeat = 



