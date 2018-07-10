<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
	<div class="form-group form">
		<form action='add' method="post">
<!-- 		    <label>Note Id</label> -->
<!-- 		    <input type="text" id="noteId" name="noteId" placeholder="note Id" class="form-control"/></input> -->
<!-- 		    <br> -->
			<label>Note Title:</label>
			<input type="text" id="noteTitle" name="noteTitle" placeholder="note title" class="form-control"/>
			<br/>
			<label>Note Content:</label>
			<input type="text" id="noteContent" name="noteContent" placeholder="note content" class="form-control"/>
			<br/>
			<label>Note Status:</label>
			<select name="noteStatus">
	            <option value="active">active</option>
	            <option value="inactive">inactive</option>
	        </select>
			<br/>
			<button type="submit" class="form-control">Submit</button>
		</form>
	</div>
	<c:if test="${!errorMessage.isEmpty()}">
		<p style= "color:red;">${errorMessage}</p>
	</c:if>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->

      <table border="1">
        <tr>
            <th>Note Id</th>
            <th>Note Title</th>            
            <th>Note Content</th>
            <th>Note Created</th>
            <th>Note Status</th>
            <th>Delete Note</th>
            <th>Update Note</th>
        </tr>
        
        <c:forEach items="${noteList}" var="note">
            <tr>
                <td>${note.noteId}</td>
                <td>${note.noteTitle}</td>
                <td>${note.noteContent}</td>
                <td>${note.createdAt}</td>
                <td>${note.noteStatus}</td>
                <td><a href="delete?noteId=${note.noteId}">Delete</a></td>
                <td><a href="updateNote?noteId=${note.noteId}">Update</a></td>
            </tr>
        </c:forEach>
    </table> 
</body>
</html>