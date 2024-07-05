<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Register</title>
<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container ">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register</p>


									<form class="mx-1 mx-md-4" method="post" action="registration">

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c">Full Name</label>
												<input type="text" id="fullName" name="fullName" class="form-control" />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example3c">
													Email</label> <input type="email" id="email" name="email"
													class="form-control" />
											</div>
										</div>



										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4c">Password</label>
												<input type="password" id="password" name="password" 
													class="form-control" />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4cd">Conform
													Password</label> <input type="password" id="conformPassword" name="conformPassword"
													class="form-control" />
											</div>
										</div>


										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" name="Registration" id="Registration" data-mdb-button-init
												data-mdb-ripple-init class="btn btn-primary btn-lg">Register</button>
										</div>

									</form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex flex-column align-items-center order-1 order-lg-2">
									<div class="mt-5"></div>
									<div class="mt-5"></div>
									<div class="mt-5">
										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
											class="img-fluid" alt="Sample image">
									</div>
									<div>
										<p class=" text-muted mt-3 mb-0">
											Already have an account? <a href="login"
												class="fw-bold text-body"><u>Login here</u></a>
										</p>
										
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
<script src="<c:url value='/js/validation.js' />"></script>
