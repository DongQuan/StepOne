####Web静态笔记

1. CSS单行文本溢出显示省略号：

		html：
			<ul id="demo1">
				<li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>
			    <li>Aliquam tincidunt mauris eu risus.</li>
			    <li>Vestibulum auctor dapibus.</li>
	        </ul>


		css：
			#demo1 li{
				-o-text-overflow: ellipsis;
				text-overflow: ellipsis;	 //省略号，这个必须有
				overflow: hidden; //超出隐藏，这个必须有
				white-space: nowrap; //不允许换行，这个必须有
				width:250px;
				margin-left:12px;
				list-style:disc inside none;	
			}

2.