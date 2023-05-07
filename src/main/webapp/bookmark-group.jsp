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
    #customers td, th {
    border: 1px solid #ddd;
    width: 20%;
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
    #note {
      text-align: center;
    }
  </style>
</head>
<body>
<h1><b>즐겨찾기 그룹 관리</b></h1><br>
<a href='/'>홈</a> | <a href='/'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a> | <a href="#">즐겨찾기 보기</a> | <a href="/bookmarkGroup">즐겨찾기 그룹 관리</a><br><br>
<button type="button" onclick="location.href='bookmark-group-add.jsp'">북마크 그룹 이름 추가</button>
<table id="customers">
  <tr>
    <th>순서</th>
    <th>북마크 이름</th>
    <th>등록일자</th>
    <th>수정일자</th>
    <th>비고</th>
  </tr>
  <c:choose>
    <c:when test="${empty bookmark}">
      <tr><td colspan="4">정보가 존재하지 않습니다.</td></tr>
    </c:when>
    <c:otherwise>
      <c:forEach var="item" items="${bookmark}">
        <c:set var="i" value="${i + 1}"></c:set>
        <tr>
          <td>${i}</td>
          <td>${item.bookmark_name}</td>
          <td>${item.bookmark_regDate}</td>
          <td>${item.bookmark_editDate}</td>
          <td id="note">
            <a href="bookmark-group-edit?bookmark_no=${item.bookmark_no}">수정</a>
            <a href="bookmark-group-delete?bookmark_no=${item.bookmark_no}">삭제</a>
          </td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</table>
</body>
</html>
