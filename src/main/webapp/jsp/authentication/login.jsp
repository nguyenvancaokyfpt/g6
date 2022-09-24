<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="com.tss.constants.ScreenConstants" %>
		<!DOCTYPE html>
		<html lang="en">
		<!--begin::Head-->

		<head>
			<meta charset="utf-8" />
			<title>Login</title>
			<meta name="description" content="Login" />
			<meta name="keywords" content="Login" />
			<link rel="canonical" href="Https://preview.keenthemes.com/metronic8" />
			<meta name="viewport" content="width=device-width, initial-scale=1" />
			<link rel="shortcut icon" href="assets/media/logos/favicon.ico" />
			<!--begin::Fonts-->
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
			<!--end::Fonts-->
			<!--begin::Global Stylesheets Bundle(used by all pages)-->
			<link href="assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
			<link href="assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
			<!--end::Global Stylesheets Bundle-->
		</head>
		<!--end::Head-->
		<!--begin::Body-->

		<body id="kt_body" class="bg-white">
			<!--begin::Main-->
			<div class="d-flex flex-column flex-root">
				<!--begin::Authentication - Sign-in -->
				<div class="d-flex flex-column flex-column-fluid bgi-position-y-bottom position-x-center bgi-no-repeat bgi-size-contain bgi-attachment-fixed"
					style="background-image: url(assets/media/illustrations/progress-hd.png)">
					<!--begin::Content-->
					<div class="d-flex flex-center flex-column flex-column-fluid p-10 pb-lg-20">
						<!--begin::Logo-->
						<a href="index.html" class="mb-12">
							<img alt="Logo" src="assets/media/logos/logo-2-dark.svg" class="h-45px" />
						</a>
						<!--end::Logo-->
						<!--begin::Wrapper-->
						<div class="w-lg-500px bg-white rounded shadow-sm p-10 p-lg-15 mx-auto">
							<!--begin::Form-->
							<form class="form w-100" novalidate="novalidate" id="kt_sign_in_form" action="#">
								<!--begin::Heading-->
								<div class="text-center mb-10">
									<!--begin::Title-->
									<h1 class="text-dark mb-3">Sign In to Metronic</h1>
									<!--end::Title-->
									<!--begin::Link-->
									<div class="text-gray-400 fw-bold fs-4">New Here?
										<a href="${ScreenConstants.REGISTER.getPath()}"
											class="link-primary fw-bolder">Create
											an Account</a>
									</div>
									<!--end::Link-->
								</div>
								<!--begin::Heading-->
								<!--begin::Input group-->
								<div class="fv-row mb-10">
									<!--begin::Label-->
									<label class="form-label fs-6 fw-bolder text-dark">Email</label>
									<!--end::Label-->
									<!--begin::Input-->
									<input class="form-control form-control-lg form-control-solid" type="text"
										name="email" autocomplete="off" />
									<!--end::Input-->
								</div>
								<!--end::Input group-->
								<!--begin::Input group-->
								<div class="fv-row mb-10">
									<!--begin::Wrapper-->
									<div class="d-flex flex-stack mb-2">
										<!--begin::Label-->
										<label class="form-label fw-bolder text-dark fs-6 mb-0">Password</label>
										<!--end::Label-->
										<!--begin::Link-->
										<a href="${ScreenConstants.RESET_PASSWORD.getPath()}"
											class="link-primary fs-6 fw-bolder">Forgot Password ?</a>
										<!--end::Link-->
									</div>
									<!--end::Wrapper-->
									<!--begin::Input-->
									<input class="form-control form-control-lg form-control-solid" type="password"
										name="password" autocomplete="off" />
									<!--end::Input-->
								</div>
								<!--end::Input group-->
								<!--begin::Input group-->
								<div class="fv-row row mb-10">
									<!--begin::Col-->
									<div class="col-xl-6 text-center justify-content-center align-self-center">
										<img id="captcha" src="data:image/png;base64,${captchaImage}" alt="captcha" />
									</div>
									<!--end::Col-->
									<!--begin::Col-->
									<div class="col-xl-6">
										<label class="form-label fw-bolder text-dark fs-6">Captcha</label>
										<input class="form-control form-control-lg form-control-solid" type="text"
											placeholder="" name="captcha" autocomplete="off" />
									</div>
									<!--end::Col-->

								</div>
								<!--end::Input group-->
								<!--begin::Actions-->
								<div class="text-center">
									<!--begin::Submit button-->
									<button type="submit" id="kt_sign_in_submit"
										class="btn btn-lg btn-primary w-100 mb-5">
										<span class="indicator-label">Continue</span>
										<span class="indicator-progress">Please wait...
											<span
												class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
									</button>
									<!--end::Submit button-->
									<!--begin::Separator-->
									<div class="text-center text-muted text-uppercase fw-bolder mb-5">or</div>
									<!--end::Separator-->
									<!--begin::Google link-->
									<a href="#" class="btn btn-flex flex-center btn-light btn-lg w-100 mb-5">
										<img alt="Logo" src="assets/media/svg/brand-logos/facebook-4.svg"
											class="h-20px me-3" />Continue with Facebook</a>
									<!--end::Google link-->
								</div>
								<!--end::Actions-->
							</form>
							<!--end::Form-->
						</div>
						<!--end::Wrapper-->
					</div>
					<!--end::Content-->
					<!--begin::Footer-->
					<div class="d-flex flex-center flex-column-auto p-10">
						<!--begin::Links-->
						<div class="d-flex align-items-center fw-bold fs-6">
							<a href="https://keenthemes.com/faqs" class="text-muted text-hover-primary px-2">About</a>
							<a href="mailto:support@keenthemes.com"
								class="text-muted text-hover-primary px-2">Contact</a>
							<a href="https://1.envato.market/EA4JP" class="text-muted text-hover-primary px-2">Contact
								Us</a>
						</div>
						<!--end::Links-->
					</div>
					<!--end::Footer-->
				</div>
				<!--end::Authentication - Sign-in-->
			</div>
			<!--end::Main-->
			<!--begin::Javascript-->
			<!--begin::Global Javascript Bundle(used by all pages)-->
			<script src="assets/plugins/global/plugins.bundle.js"></script>
			<script src="assets/js/scripts.bundle.js"></script>
			<script src="assets/js/axios.min.js"></script>
			<!--end::Global Javascript Bundle-->
			<!--begin::Page Custom Javascript(used by this page)-->
			<script src="assets/js/custom/authentication/sign-in/general.js"></script>
			<script src="https://accounts.google.com/gsi/client" async defer></script>
			<script>
				window.onload = function () {
					google.accounts.id.initialize({
						client_id: '${googleClientSecret.getClient_id()}',
						callback: function (credentialResponse) {
							let response = credentialResponse;
							// show loading
							Swal.fire({
								title: 'Please wait...',
								icon: 'info',
								onBeforeOpen() {
									Swal.showLoading()
								},
								onAfterClose() {
									Swal.hideLoading()
								},
								allowOutsideClick: false,
								allowEscapeKey: false,
								allowEnterKey: false,
								showConfirmButton: false,

							})
							// Post to server
							axios.post('${googleClientSecret.getRedirect_uris()}', {
								credential: response.credential
							}).then(function (response) {
								// Redirect to dashboard
								window.location.href = '/dashboard';
								// hide loading
								Swal.close();
							}).catch(function (error) {
								// hide loading
								Swal.close();
								// Show error message
								Swal.fire({
									text: error.response.data.message,
									icon: "error",
									buttonsStyling: !1,
									confirmButtonText: "Ok, got it!",
									customClass: {
										confirmButton: "btn btn-primary"
									}
								});
							});

						}
					});
					google.accounts.id.prompt();
				};
			</script>
			<!--end::Page Custom Javascript-->
			<!--end::Javascript-->
		</body>
		<!--end::Body-->

		</html>