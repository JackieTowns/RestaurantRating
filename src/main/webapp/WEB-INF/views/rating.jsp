<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="restastyle.css"/> 
<title> Restaurant Rating</title>
</head>
<body>

<h1> Restaurant Ratings</h1>


<table class="table table-striped table-bordered table-sm" id="table2">
			<thead class="thead-dark">
				<tr>
					<th>Name</th><th>Rating</th>
				</tr>
			</thead>
			<tbody id="tbody" >
			<c:forEach var="ratingsAll" items="${rating}">
				<tr>
					<td><a href="/rating?id=${ratingsAll.id}">${ratingsAll.name}</a></td>
					<td>${ratingsAll.rating}</td> 
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		
    <button type="submit" name="upvote">Up</button>
    <button type="submit" name="downvote">Down</button>


</body>
</html>