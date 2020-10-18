<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/main.css" rel="stylesheet" />
</head>
<body>
    
    <div>
    <header>
        <div style="img">
            <img class="img1" src="../images/img1-2.jpg">
        </div>

        <nav id="inline">
            <ul class="menu">
                <li><a href="../platform_index.jsp">綜合討論</a></li>
                <li><a href="knowledge.jsp">知識</a></li>
                <li><a href="group.jsp">揪團</a></li>
                <li><a href="question.jsp">雜症求助</a></li>
                <li><a style="color:#f9fd04">失物招領</a></li>
            </ul>
        </nav>

    </header>
</div>
<main>
    <div class="board">
        <div class="listTable_thead">
            <div class="listTable_tr listTable_tr_1">
                <div class="listTable_td">
                    <span>主題</span></div>
                <div class="listTable_td listTable_td_time">
                    <span>發佈時間</span></div>
                <div class="listTable_td listTable_td_time">
                    <span>最後討論時間</span></div>
                <div class="listTable_td listTable_td_time">
                    <span>回復次數</span></div>
            </div>
        </div>

        <article>


            <!-- to do -->
            <div class="listTable_tbody">
                <div class="listTable_tr">
                    <div class="listTable_td">
                        <div>

                            <a href="html/公告.html" class="c_link u_ellipsis">失物招領[分享]死亡稜線撿到錢包</a>
                        </div>
                    </div>
                    <div class="listTable_td listTable_td_time">
                        <a href="發文者" class="c_link u_ellipsis">user_Cheng</a>
                        <a class="">2020/10/03</a>
                    </div>
                    <div class="listTable_td listTable_td_time">
                        <a href="回復人" class="c_link u_ellipsis">user_Cheng</a>
                        <a class="">2020/10/04</a>
                    </div>
                    <div class="listTable_td listTable_td_count">
                        <a class="">回應次數:25</a>
                    </div>
                </div>


            </div>


        </article>
        <nav class="inline1">
            <div class="menu">
                <a href="../../index.jsp">返回躍進者</a>
            </div>
        </nav>
                <div class="st02">
                    <button type="button" value="發文"><a href="po.jsp">我要發文</a></button>
                    
                </div>

    </div>
</main>
    
</body>
</html>