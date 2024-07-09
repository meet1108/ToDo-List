<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Create Task</title>
<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Create
										Task</p>
									<c:set var="email" value="${email}"></c:set>
									<c:set var="taskId" value="${taskId}"></c:set>
									<c:set var="task" value="${task}"></c:set>

									<form class="mx-1 mx-md-4" method="post" action="/ToDo-List/createTask">

										<div>
											<input type="text" name="email" value="${email }" />
											<input type="text" name="taskId" value="${taskId}" />
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label h5" for="form3Example3c">
													Task Title</label> <input type="text" id="taskTitle"
													name="taskTitle" value="${task.getTaskTitle() }"class="form-control" />
											</div>
										</div>



										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label h5" for="form3Example4c">Task
													Description</label>
												<textarea id="taskDescription"  name="taskDescription"
												 class="form-control" rows="3"></textarea>
											</div>	
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" data-mdb-button-init
												data-mdb-ripple-init class="btn btn-primary btn-lg">Submit</button>
										</div>

									</form>

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
<script src="<c:url value='/js/validation.js' />"></script>
