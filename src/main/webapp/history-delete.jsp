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
    #customers th {
      border: 1px solid #ddd;
      width: 25%;
      padding: 8px;
    }
    #customers td {
      border: 1px solid #ddd;
      width: 75%;
      padding: 8px;
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
    #center {
      text-align: center;
    }
  </style>
</head>
<body>
<h1><b>위치 히스토리 삭제</b></h1><br>
<a href='/'>홈</a> | <a href='history'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a> | <a href="/bookmark-list">즐겨찾기 보기</a> | <a href="/bookmarkGroup">즐겨찾기 그룹 관리</a><br><br>
<table id="customers">
  <tr>
    <th>X 좌표</th><td>${historyDTO.history_lat}</td>
  </tr>
  <tr>
    <th>Y 좌표</th><td>${historyDTO.history_lnt}</td>
  </tr>
  <tr>
    <th>조회일자</th><td>${historyDTO.history_regDate}</td>
  </tr>
  <tr>
    <td colspan="3" id="center">
      <a href="javascript:window.history.go(-1)">돌아가기</a> |
      <form action="/history-delete-submit" method="post">
        <input type="hidden" name="history_id" value="${historyDTO.history_id}">
        <button type="submit">삭제</button>
      </form>
    </td>
  </tr>
</table>
</body>
</html>
