<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <link rel="stylesheet" type="text/css" href="${baseurl}/../../styles/myBlog.css" media="screen"/>
    <#--<link rel="stylesheet" type="text/css" href="../../styles/calendar.css" media="screen"/>-->
    <title>吴雪风的博客</title>
</head>
<body>
<div  class="head">
    <img src="${baseurl}/images/head01.jpg"/>
</div>
<div class="menu">
    <ul id="menu-list">
        <li>
            <a href="/blog/index.do"><font size="4" face="arial" color="#ffffff">首页</font><a>
        </li>
        <li>
            <a href=""><font size="4" face="arial" color="#ffffff">分类</font><a>
        </li>
    </ul>
</div>

<div class="content">
    <div  class="left-list">
        <div class="myPot">
            <img src="${baseurl}../../images/touxiang.jpg"/>
        </div>
        <div class="aphorism">
            <span>PHP 是最好的语言!</span>
            <p>我选择java。</p>
        </div>
        <div class="notice">
            <p>大家好，我是吴雪风，欢迎来到我的博客哟！</p>
        </div>
        <#--<div id="calendar" class="calendar"></div>-->
        <div class="title">
            <p>近期文章</p>
        </div>
        <div class="recent-list">
            <ul>
                <#list recentList as list>
                    <li>
                        <a href="/blog/detail.do?noteId=${list.noteId}">${list.title}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="center-list">
        <ul id="blog-list">
            <#list pageData.data as list>
                <li>
                    <a href="/blog/detail.do?noteId=${list.noteId}">
                    <div class="preview">
                        <div  class="title">
                            <span class="t2">${list.title}</span>
                        </div>
                        <div class="describe">
                            <p>${list.describtion!}</p>
                        </div>
                        <div class="t-foot">
                            <span class="classify">${list.categoryName!}</span>
                            <span class="dateMan">${list.createTime!} &nbsp&nbsp&nbsp  围观:${list.watchNumber}人 &nbsp&nbsp评论：${list.commentNum}条</span>
                        </div>
                    </div>
                    </a>
                </li>
            </#list>
        </ul>
        <div class="page">
            <ul class="page-list">
                <#if (page-2>1)>
                    <li>
                        <div  class="noPage">
                            <a href="/blog/next.do?page=1&pageSize=5">1</a>
                        </div>
                    </li>
                </#if>
                <#if (page-2>1)>
                    <li>
                        <div  class="noPage">
                            <a>...</a>
                        </div>
                    </li>
                </#if>
                <#if (page-2>0)>
                    <li>
                        <div  class="noPage">
                            <a href="/blog/next.do?page=${page-2}&pageSize=5"">${page-2}</a>
                        </div>
                    </li>
                </#if>
                <#if (page-1>0)>
                    <li>
                        <div class="noPage">
                            <a href="/blog/next.do?page=${page-1}&pageSize=5"">${page-1}</a>
                        </div>
                    </li>
                </#if>

                <#if (page>0)>
                    <li>
                        <div  class="dd">
                            <a href="/blog/next.do?page=${page}&pageSize=5"">${page}</a>
                        </div>
                    </li>
                </#if>
                <#if (page+1<totalPage)>
                    <li>
                        <div class="noPage">
                            <a href="/blog/next.do?page=${page+1}&pageSize=5"">${page+1}</a>
                        </div>
                    </li>
                </#if>
                <#if (page+2<totalPage)>
                    <li>
                        <div class="noPage">
                            <a href="/blog/next.do?page=${page+2}&pageSize=5"">${page+2}</a>
                        </div>
                    </li>
                </#if>
                <#if (page+3<totalPage)>
                    <li>
                        <div class="noPage">
                            <a href="/blog/next.do?page=${page+3}&pageSize=5"">${page+3}</a>
                        </div>
                    </li>
                </#if>
                <#if (page<totalPage)>
                    <li>
                        <div class="noPage">
                            <a>...</a>
                        </div>
                    </li>
                </#if>
                <#if (page<totalPage)>
                    <li>
                        <div class="noPage">
                            <a href="/blog/next.do?page=${totalPage}&pageSize=5">${totalPage}</a>
                        </div>
                    </li>
                </#if>
            </ul>
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
<script src="${baseurl}../../scripts/jquery.min.js"></script>

</html>
