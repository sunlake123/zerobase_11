<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin-top: 10px;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
        form {
            display: inline;
        }
    </style>
</head>
<body>
<h1><b>와이파이 정보 구하기</b></h1><br>
<a href=''>홈</a> | <a href='/'>위치 히스토리 목록</a> | <a href='load-wifi'>Open API 와이파이 정보 가져오기</a><br><br>
<form action="/" name="myLoc" method="get" id="myLoc">
    LAT : <input type="text" name="lat" value="${param.lat}">
    LNT : <input type="text" name="lnt" value="${param.lnt}">
</form> <button onclick="takeMyLoc(myLoc)">내 위치 가져오기</button> <button type="submit" form="myLoc">근처 WIFI 정보 보기</button><br>

<table id="customers">
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    <c:choose>
        <c:when test="${empty param.lat and empty param.lnt}">
            <tr><td colspan="17">아</td></tr>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
</table>
</body>
<script>
    function takeMyLoc(myLoc) {
        navigator.geolocation.getCurrentPosition(position => {
            let latitude = position.coords.latitude;
            let longitude = position.coords.longitude;
            myLoc.lat.value = latitude;
            myLoc.lnt.value = longitude;
        });
    }
</script>
</html>