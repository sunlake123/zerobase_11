<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin-top: 10px;
        }
        #customers th, td {
            border: 1px solid #ddd;
            width: 20%;
            padding: 8px;
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
        #empty {
            text-align: center;
        }
        #note {
            text-align: center;
        }
    </style>
</head>
<body>
<h1><b>위치 히스토리 목록</b></h1><br>
<a href='/'>홈</a> | <a href='history'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a> | <a href="/bookmark-list">즐겨찾기 보기</a> | <a href="/bookmarkGroup">즐겨찾기 그룹 관리</a><br><br>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    <c:choose>
        <c:when test="${empty historyDTOS}">
            <tr><td colspan="5" id="empty">정보가 존재하지 않습니다.</td></tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="item" items="${historyDTOS}">
                <c:set var="size" value="${size - 1}"></c:set>
                <tr>
                    <td id="no">${size + 1}</td>
                    <td>${item.history_lat}</td>
                    <td>${item.history_lnt}</td>
                    <td>${item.history_regDate}</td>
                    <td id="note">
                        <form action="history-delete">
                            <input type="hidden" name="history_id" value="${item.history_id}">
                            <button type="submit">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>

</table>
</body>
</html>
