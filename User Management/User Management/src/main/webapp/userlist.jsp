<%@page import="com.usermanagent.bean.Userbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<form action="U" method="post">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
  <label>UserManagement</label>
  
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="list">Users</a>
        </li>
        </ul>
        </div>
       </div>
       </nav>
       <br>
       <h1><center>User Management Project</center></h1>
        
       <div class="container">
       <hr></hr>
       <div>
       <a href="<%=request.getContextPath()%>/add" class="btn btn-success">Add User</a>
       </div>
       <br>
       <table class="table table-success table-striped">
 <thead>
 <tr>
 <th>ID</th>
 <th>Name</th>
 <th>Email</th>
 <th>City</th>
 <th>Actions</th>
 </tr>
 </thead>
 <tbody>
 <b:forEach items="${userlist}" var="u">
 <tr>
 <td><b:out value="${u.id}"></b:out></td>
 <td><b:out value="${u.name}"></b:out></td>
 <td><b:out value="${u.email}"></b:out></td>
 <td><b:out value="${u.city}"></b:out></td>
 <td>&nbsp;&nbsp;<a href="edit?id=<b:out value="${u.id}"></b:out>">edit/</a> <a href="delete?id=<b:out value="${u.id}"></b:out>">delete</a> 
 </tr> 
 </b:forEach>
</tbody>
</table>
</div>
</form>
</body>
</html>