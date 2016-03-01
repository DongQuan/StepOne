JSON风格指南

双引号

使用双引号

如果（某个）属性需要引号，则必须使用双引号。所有的属性名必须在双引号内。字符类型的属性值必须使用双引号。其它类型值（如布尔或数字）不应该使用双引号。
扁平化数据 VS 结构层次

不能为了方便而将数据任意分组

JSON中的数据元素应以扁平化方式呈现。不能为了方便而将数据任意分组。

在某些情况下，比如描述单一结构的一批属性，因为它被用来保持结构层次，因而是有意义的。但是遇到这些情况还是应当慎重考虑，记住只有语义上有意义的时候才使用它。例如，一个地址可以有表示两种方式，但结构化的方式对开发人员来讲可能更有意义：

扁平化地址:

{
  "company": "Google",
  "website": "http://www.google.com/",
  "addressLine1": "111 8th Ave",
  "addressLine2": "4th Floor",
  "state": "NY",
  "city": "New York",
  "zip": "10011"
}

结构化地址：

{
  "company": "Google",
  "website": "http://www.google.com/",
  "address": {
    "line1": "111 8th Ave",
    "line2": "4th Floor",
    "state": "NY",
    "city": "New York",
    "zip": "10011"
  }
}


属性名格式

选择有意义的属性名

属性名必须遵循以下准则:

    属性名应该是具有定义语义的有意义的名称。
    属性名必须是驼峰式的，ASCII码字符串。
    首字符必须是字母，下划线(_)或美元符号($)。
    随后的其他字符可以是字母，数字，下划线(_)或美元符号($)。
    应该避免使用Javascript中的保留关键字(下文附有Javascript保留字清单)

这些准则反映JavaScript标识符命名的指导方针。使JavaScript的客户端可以使用点符号来访问属性。(例如, result.thisIsAnInstanceVariable).

下面是一个对象的一个属性的例子：

{
  "thisPropertyIsAnIdentifier": "identifier value"
}



日期属性值

日期应该使用RFC3339建议的格式

日期应该是RFC 3339所建议的字符串格式。

{
  "lastUpdate": "2007-11-06T16:34:41.000Z"
}


时间间隔属性值

时间间隔应该使用ISO 8601建议的格式

时间间隔应该是ISO 8601所建议的字符串格式。

{
  // 三年, 6个月, 4天, 12小时,
  // 三十分钟, 5秒
  "duration": "P3Y6M4DT12H30M5S"
}

纬度/经度属性值

纬度/经度应该使用ISO 6709建议的格式

纬度/经度应该是ISO 6709所建议的字符串格式。 而且, 它应该更偏好使用 e Â±DD.DDDDÂ±DDD.DDDD 角度格式.

{
  // 自由女神像的纬度/经度位置.
  "statueOfLiberty": "+40.6894-074.0447"
}