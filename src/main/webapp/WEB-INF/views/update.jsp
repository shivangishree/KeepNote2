<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="form-group form">
		<form action='update' method="get">
		    <label>Note ID:</label>
			<input type="hidden" id="noteId" name="noteId" value=${note.noteId}   class="form-control"/>
			<label>Note Title:</label>
			<input type="text" id="noteTitle" name="noteTitle" value=${note.noteTitle} class="form-control"/>
			<br/>
			<label>Note Content:</label>
			<input type="text" id="noteContent" name="noteContent" value=${note.noteContent} class="form-control"/>
			<br/>
			<label>Note Status:</label>
			<select name="noteStatus">
	            <option value="active">active</option>
	            <option value="inactive">inactive</option>
	        </select>
			<br/>
			<button type="submit" class="form-control">Update</button>
		</form>
	</div>
	<c:if test="${!errorMessage.isEmpty()}">
		<p style= "color:blue;">${errorMessage}</p>
	</c:if>
</body>

</html>