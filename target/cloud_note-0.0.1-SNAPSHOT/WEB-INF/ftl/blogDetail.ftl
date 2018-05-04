<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <link rel="stylesheet" type="text/css" href="${baseurl}/styles/myBlog.css" media="screen"/>
    <link rel="shortcut icon" href="${baseurl}/ico/blog.png">
    <#--<link rel="stylesheet" type="text/css" href="../../styles/calendar.css" media="screen"/>-->
    <title>${title}</title>
</head>
<body>
<div  class="head">
    <img src="${baseurl}/images/head01.jpg"/>
</div>
<div class="menu">
    <ul id="menu-list">
        <li>
            <a href="${baseurl}/blog/index.do"><font size="4" face="arial" color="#ffffff">首页</font><a>
        </li>
        <li>
            <a href=""><font size="4" face="arial" color="#ffffff">分类</font><a>
        </li>
    </ul>
</div>

<div class="content">
    <div  class="left-list">
        <div class="myPot">
            <img src="${baseurl}/images/touxiang.jpg"/>
        </div>
        <div class="aphorism">
            <span>PHP 是最好的语言!</span>
            <p>我选择java。</p>
        </div>
        <div class="notice">
            <p>大家好，我是吴雪风，欢迎来到我的博客哟！</p>
        </div>
        <div class="title">
            <p>近期文章</p>
        </div>
        <div class="recent-list">
            <ul>
            <#list recentList as list>
                <li>
                    <a href="${baseurl}/blog/detail.do?noteId=${list.noteId}">${list.title}</a>
                </li>
            </#list>
            </ul>
        </div>
    </div>
    <div class="center-list">
        <div class="detail">
            <div class="t1">
                <h1 style="text-align: center">${title}</h1>

            </div>
            <div>
                <hr class="hr"/>
            </div>
            <div class="main ">
                ${body}
            </div>
        </div>
    </div>
    <#--<div class="right-list">
        <div class="classify-list">
            <div class="name">
                <span>分类目录</span>
            </div>
            <div class="list">
                <ul>
                    <li>
                        <a href="">工作笔记</a>
                    </li>
                    <li>
                        <a href="">随笔</a>
                    </li>
                    <li>
                        <a href="">OOP</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="date">
            &lt;#&ndash;<div id="calendar" class="calendar"></div>&ndash;&gt;
        </div>
        <div class="hot">
            <div class="name">
                <span>热门笔记</span>
            </div>
            <div class="list">
                <ul>
                    <li>
                        <a href="">工作笔记</a>
                    </li>
                    <li>
                        <a href="">随笔</a>
                    </li>
                    <li>
                        <a href="">OOP</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>-->
</div>

<div class="foot">

</div>
</body>
<script src="${baseurl}/scripts/jquery.min.js"></script>
</html>
