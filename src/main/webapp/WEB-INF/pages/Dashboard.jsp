
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.dataTables.min.css" />"
	rel="stylesheet">

<title>DashBoard</title>

<body>
	<c:set var="user" value="${user}"></c:set>

	<section class="vh-100" style="background-color: #eee;">
		<div class="row d-flex justify-content-center ">
			<div class="col-lg-12 col-xl-11">
				<div class="card text-black mt-5" style="border-radius: 25px;">
					<div class="card-body p-md-5 ">
						<div class="row justify-content-center">


							<p class="h1 fw-bold mb-0 me-auto">Your All Task</p>
							<div
								class="d-flex justify-content-center align-items-center mb-3 mb-lg-4">
								<p class="fw-bold mb-0 me-auto">
									<br>WelCome, ${user.getFullName() }
								</p>
								<a class="btn btn-outline-primary"
									href="openCreateTask/${user.getEmail() }" role="button">Create
									Task</a> &nbsp;&nbsp;&nbsp;&nbsp; 
									<a class="btn btn-outline-warning" href="/ToDo-List/Logout"
									role="button">Logout</a>

							</div>


							<div>
								<table id="myTable">
									<thead>
										<tr>

											<th>Title</th>
											<th>Description</th>
											<th>Action</th>
											<th>Status</th>



										</tr>
									</thead>
									<tbody>
										<c:forEach items="${allTask}" var="Task">

											<tr>

												<td>${Task.getTaskTitle()}</td>
												<td>${Task.getTaskDescription() }</td>

												<td><a role="button" class="btn btn-outline-primary"
													href="taskupdate/${Task.getTaskId() }">Update</a>&nbsp <a
													role="button" 
													class="btn btn-outline-success" data-toggle="modal"
													data-target="#confirmationModal"
													onclick="openConfrimationModal(${Task.getTaskId()})">Complete</a></td>

												<td>${Task.getTaskStatus() }</td>


											</tr>

										</c:forEach>
									</tbody>
								</table>
								<div class="modal" id="confirmationModal">
									<div class="modal-dialog">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Confirm Deletion</h4>
												<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
											</div>
											<!-- Modal Body -->
											<div class="modal-body">Are you sure you want to delete
												this user?</div>
											<!-- Modal Footer -->
											<div class="modal-footer">
												<!-- Confirm Button -->
												<button type="button" class="btn btn-danger"
													onclick="updateTaskStatus()">Yes</button>
												<!-- Close Button -->
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">No</button>
											</div>
										</div>
									</div>
								</div>

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

<script type="text/javascript">
var taskIdToUpdate;

function openConfrimationModal(taskId){
	taskIdToUpdate = taskId;
	$('#confirmationModal').modal('show');
}

function updateTaskStatus(){
	$.ajax({
		type: 'POST',
		url: 'updateStatus',
		data: {taskId: taskIdToUpdate },
		success: function(resp){
			location.reload();   
		    
		    
		},
		error: function(xhr, status, error) {
            // Handle error response
			Swal
            .fire({
                icon : "error",
                title : "Oops...",
                text : "Something Went Wrong.",
            });
		}
	});
	$('#confirmationModal').modal('hide');
	
}

</script>



