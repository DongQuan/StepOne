1. 四种整型: int(4) short(2) byte(1) long(8)
2. 两种浮点: float(4) double(8) 默认为double
3. 按值传递的Java
    
        
        StringBuffer a = new StringBuffer("A");
            StringBuffer b = new StringBuffer("B");
            operator(a, b);
            System.out.println(a + "," + b);
        }
        public static void operator(StringBuffer x, StringBuffer y) {
            x.append(y); //改变引用里的值可以
            y = x; // 改变引用没用
        }
        // AB, B
        
4. 重载的方法的返回值类型可以一样的， 也可以不一样
5. length()是字符串的方法， length是数组的属性