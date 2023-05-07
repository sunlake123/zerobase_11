<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><b>와이파이 정보 구하기</b></h1><br>
<a href='/'>홈</a> | <a href='/'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a> | <a href="#">즐겨찾기 보기</a> | <a href="/bookmarkGroup">즐겨찾기 그룹 관리</a><br><br>
<style>
    #customers {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
        margin-top: 10px;
    }

    #customers td {
        border: 1px solid #ddd;
        width: 75%;
        padding: 8px;
    }
    #customers th {
        border: 1px solid #ddd;
        width: 25%;
        padding: 8px;
    }
    #button {
        text-align: center;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
    form {
        display: inline;
    }
</style>
</body>
<form action="/bookmark-group-edit-submit" method="post">
    <table id="customers">
        <tr>
            <th>북마크 이름</th>
            <td><input type="text" name="bookmark_name" value="${bookmark_name}"></td>
            <input type="hidden" name="bookmark_no" value="${bookmark_no}">
        </tr>
        <tr>
            <td colspan="2" id="button">
                <a href="javascript:window.history.go(-1)">돌아가기</a> | <button type="submit">수정</button>
            </td>
        </tr>
    </table>
</form>
</html>
