####JavaScript

1. Mustache模板引擎示例：

        var template = "<li>\
                <p>\
                <a class=\"piece\" href=\"{{ url }}\">{{ title }}</a>\
                <span class=\"time\">{{ createTime }}</span>\
                </p>\
                </li>";
        
            var article = {
                url: "",
                title: "",
                createTime: ""
            };
        
            element.empty();
        
            for (var i = 0; i < data.length; i++) {
                article.url = data[i].url;
                article.title = data[i].title;
                article.createTime = data[i].createTime;
                element.append(Mustache.render(template, article));
            }
            
2. JavaScript生成uuid:

        Javascript function
        function generateUUID(){
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = (d + Math.random()*16)%16 | 0;
                d = Math.floor(d/16);
                return (c=='x' ? r : (r&0x7|0x8)).toString(16);
            });
            return uuid;
        };
        
3. JavaScript中document.getElementById的返回值的类型为Object

4.