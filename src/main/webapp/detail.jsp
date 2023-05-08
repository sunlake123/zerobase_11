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
</head>
<body>
<h1><b>와이파이 상세 정보</b></h1><br>
<a href='/'>홈</a> | <a href='history'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a> | <a href="/bookmark-list">즐겨찾기 보기</a> | <a href="/bookmarkGroup">즐겨찾기 그룹 관리</a><br><br>
<form method="post" action="bookmark-add-submit">
  <select name="bookmark_name">
    <option value="" selected disabled hidden>북마크 그룹 이름 선택</option>

    <c:forEach items="${bookmarkDTOS}" var="item">
      <option value="${item.bookmark_name}">${item.bookmark_name}</option>
    </c:forEach>

  </select>
  <input type="hidden" name="wifi_name" value="${detail.xSwifiMainNm}">
  <button type="submit">즐겨찾기 추가하기</button>
</form>
<table id="customers">
  <tr>
    <th>관리번호</th>
    <td>${detail.xSwifiMgrNo}</td>
  </tr>
  <tr>
    <th>자치구</th>
    <td>${detail.xSwifiWrdofc}</td>
  </tr>
  <tr>
    <th>와이파이명</th>
    <td>${detail.xSwifiMainNm}</td>
  </tr>
  <tr>
    <th>도로명주소</th>
    <td>${detail.xSwifiAdres1}</td>
  </tr>
  <tr>
    <th>상세주소</th>
    <td>${detail.xSwifiAdres2}</td>
  </tr>
  <tr>
    <th>설치위치(층)</th>
    <td>${detail.xSwifiInstlFloor}</td>
  </tr>
  <tr>
    <th>설치유형</th>
    <td>${detail.xSwifiInstlTy}</td>
  </tr>
  <tr>
    <th>설치기관</th>
    <td>${detail.xSwifiInstlMby}</td>
  </tr>
  <tr>
    <th>서비스구분</th>
    <td>${detail.xSwifiSvcSe}</td>
  </tr>
  <tr>
    <th>망종류</th>
    <td>${detail.xSwifiCmcwr}</td>
  </tr>
  <tr>
    <th>설치년도</th>
    <td>${detail.xSwifiCnstcYear}</td>
  </tr>
  <tr>
    <th>실내외구분</th>
    <td>${detail.xSwifiInoutDoor}</td>
  </tr>
  <tr>
    <th>WIFI접속환경</th>
    <td>${detail.xSwifiRemars3}</td>
  </tr>
  <tr>
    <th>X좌표</th>
    <td>${detail.lat}</td>
  </tr>
  <tr>
    <th>Y좌표</th>
    <td>${detail.lnt}</td>
  </tr>
  <tr>
    <th>작업일자</th>
    <td>${detail.workDttm}</td>
  </tr>

</table>
</body>
</html>
