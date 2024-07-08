
<%@ page isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet">

<title>DashBoard</title>

<body>
<c:set var="user" value="${user}"></c:set>

	<section class="vh-100" style="background-color: #eee;">
		<div class="row d-flex justify-content-center ">
			<div class="col-lg-12 col-xl-11">
				<div class="card text-black mt-5" style="border-radius: 25px;">
					<div class="card-body p-md-5 ">
						<div class="row justify-content-center">

							<form action="create">
							<p class="h1 fw-bold mb-0 me-auto"> Your All Task </p>
								<div
									class="d-flex justify-content-center align-items-center mb-3 mb-lg-4">
									<p class="fw-bold mb-0 me-auto">  <br>WelCome, ${user.getFullName() } </p>
									<button type="submit" class="btn btn-primary btn-lg">Create
										Task</button>
								</div>
							</form>
<c:set var="Task" value="${allTask}"></c:set>
							<div>
								<table id="myTable" >
									<thead>
										<tr>
											<th>Task No.</th>
											<th>Title</th>
											<th>Description</th>
											<th>Action</th>
											
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Tiger Nixon</td>
											<td>${Task.getTaskTitle()}</td>
											<td>${Task.getTaskDescription() }</td>
											<td>61</td>
											
										</tr>
									</tbody>
								</table>

							</div>





						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>


<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
 <script src="<c:url value="/resources/js/jquery.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
 <script src="<c:url value="/resources/js/validation.js" />"></script>
	

<script> 
$(document).ready(function(){
	$("#myTable").dataTable();
});
</script>


