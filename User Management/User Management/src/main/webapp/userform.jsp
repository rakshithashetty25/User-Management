<%@page import="com.usermanagent.bean.Userbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
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
       <c:if test="${user==null}">
       <form action="insert" method="post">
       
       </c:if>
       <c:if test="${user!=null}">
       <form action="update" method="post">
       
       </c:if>
       <h2 align="center">
       <c:if test="${user==null}">
       Add User
       </c:if>
       <c:if test="${user!=null}">
       Edit User
       </c:if>
       </h2>
<div class="mb-3">
  
  <input type="hidden" class="form-control" id="id" value="${user.id}" name="id" style="width:300px">
</div>

<div class="mb-3">
  <label for="name" class="form-label">UserName</label>
  <input type="text" class="form-control" id="name" value="${user.name}" name="name" style="width:300px">
</div>
<div class="mb-3">
  <label for="email" class="form-label">Email</label>
  <input type="email" class="form-control" id="email" value="${user.email}" name="email" style="width:300px">
</div>
<div class="mb-3">
  <label for="city" class="form-label">City</label>
  <input type="city" class="form-control" id="city"  value="${user.city}" name="city" style="width:300px">
</div>
<div class="col-12">
    <button class="btn btn-success" type="submit" style=width:300px">Save</button>
  </div>
  
</body>
</html>