<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	
%> 


<fmt:setLocale value="en_US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="mycss.css" />
</head>
<body >

<script language="javascript" type="text/javascript">
function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}


</script>

<nav class="navbar navbar-default" style="background-color: #01579b">
  <div class="container-fluid ">
    <div class="navbar-header" >
      <a class="navbar-brand " href="login.jsp" style="color: #fff; font-weight: bold;font-size:20px">Bullhorn</a>
    </div>
    <ul class="nav navbar-nav">
     <li><a href="userprofile.jsp" style="color: #fff; font-weight: bold;font-size:20px"><img src= ${ images}  width="20" height="20"></img> ${username}</a></li>
      <li ><a href="home.jsp" style="color: #fff; font-weight: bold;font-size:20px" class="active">Home</a></li>
      <li><a href="newsfeed.jsp" name="allpost" type="button" style="color: #fff; font-weight: bold;font-size:20px">News Feed</a></li>
      <li ><a href="<%=request.getContextPath() %>/logout"  style="color: #fff; font-weight: bold;font-size:20px">Log Out</a></li>
    </ul>
  
  </div>
</nav>


<form action="homeServlet"   id="myform" name="myform" >
<div class="container">
<table align="center" border="0" class="table">
<thead>
<tr ><th>Search posts</th></tr>
</thead>
<tbody>
<tr style="backgroundcolor:#4db6ac "><td >Please enter post, at most 141 characters:</td></tr>
<tr>
<td>
<textarea name="limitedtextarea" rows="5" cols="30" onKeyDown="limitText(this.form.limitedtextarea,this.form.countdown,141);" 
onKeyUp="limitText(this.form.limitedtextarea,this.form.countdown,141);">
</textarea>
</td>
</tr>
<tr>
<td><font size="2" >(Maximum characters: 141)<br>
You have <input readonly type="text" name="countdown" size="3" value="141" style="width: 50px; border:none" > characters left.</font><br>
</td>
</tr>
<tr align="center"><td>
<input type="submit" name="method" value="Add" class="button"/>
<input type="submit" name="method" value="Search" class="button"/>
</td>
</tr>
</tbody>
</table>
</div>



<div class="container">


<c:if test="false">
    <input type="button" onclick="location.href='home.jsp'" class="button"
            value="Reset List" />
</c:if>
<c:if test="true">
    <input type="submit" name="method" value="Save" class="button" />
</c:if>
<input type="submit" name="method" value="Edit" class="button"/>
<input type="submit" name="method" value="Delete" class="button" />

<br /><br />


 
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<c:forEach var="column" items="${columnnamelists}" >
<th><c:out value="${column}" />
</th>

</c:forEach>

</thead>

  <c:forEach var="list" items="${lists}" >
  <tr>

<td>
	<c:out value="${list}" />
	</td>	
	<td>
   </tr>
	 </c:forEach>
	
 </table> 
 </div> 
 
</form>

</body>
</html>


