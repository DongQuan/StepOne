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
            