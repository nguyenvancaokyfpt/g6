<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="com.tss.constants.ScreenConstants" %>
		<!DOCTYPE html>
		<html lang="en">
		<!--begin::Head-->

		<head>
			<base href="/">
			<meta charset="utf-8" />
			<title>Register account</title>
			<meta name="description" content="" />
			<meta name="keywords" content="" />
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
				<!--begin::Authentication - Sign-up -->
				<div class="d-flex flex-column flex-column-fluid bgi-position-y-bottom position-x-center bgi-no-repeat bgi-size-contain bgi-attachment-fixed"
					style="background-image: url(assets/media/illustrations/progress-hd.png)">
					<!--begin::Content-->
					<div class="d-flex flex-center flex-column flex-column-fluid p-10 pb-lg-20">
						<!--begin::Logo-->
						<a href="/" class="mb-12">
							<img alt="Logo" src="assets/media/logos/logo-2-dark.svg" class="h-45px" />
						</a>
						<!--end::Logo-->
						<!--begin::Wrapper-->
						<div class="w-lg-600px bg-white rounded shadow-sm p-10 p-lg-15 mx-auto">
							<!--begin::Form-->
							<form class="form w-100" novalidate="novalidate" id="kt_sign_up_form">
								<!--begin::Heading-->
								<div class="mb-10 text-center">
									<!--begin::Title-->
									<h1 class="text-dark mb-3">Create an Account</h1>
									<!--end::Title-->
									<!--begin::Link-->
									<div class="text-gray-400 fw-bold fs-4">Already have an account?
										<a href="${ScreenConstants.LOGIN.getPath()}" class="link-primary fw-bolder">Sign
											in here</a>
									</div>
									<!--end::Link-->
								</div>
								<!--end::Heading-->
								<!--begin::Action-->
								<button type="button" class="btn btn-light-primary fw-bolder w-100 mb-10">
									<img alt="Logo" src="assets/media/svg/brand-logos/facebook-4.svg"
										class="h-20px me-3" />Sign in with Facebook</button>
								<!--end::Action-->
								<!--begin::Separator-->
								<div class="d-flex align-items-center mb-10">
									<div class="border-bottom border-gray-300 mw-50 w-100"></div>
									<span class="fw-bold text-gray-400 fs-7 mx-2">OR</span>
									<div class="border-bottom border-gray-300 mw-50 w-100"></div>
								</div>
								<!--end::Separator-->
								<!--begin::Input group-->
								<div class="row fv-row mb-7">
									<!--begin::Col-->
									<div class="col-xl-12">
										<label class="form-label fw-bolder text-dark fs-6">Your name</label>
										<input class="form-control form-control-lg form-control-solid" type="text"
											placeholder="" name="user-fullname" autocomplete="off" />
									</div>
									<!--end::Col-->
								</div>
								<!--end::Input group-->
								<!--begin::Input group-->
								<div class="fv-row mb-7">
									<label class="form-label fw-bolder text-dark fs-6">Email</label>
									<input class="form-control form-control-lg form-control-solid" type="email"
										placeholder="" name="email" autocomplete="off" />
								</div>
								<!--end::Input group-->
								<!--begin::Input group-->
								<div class="mb-10 fv-row" data-kt-password-meter="true">
									<!--begin::Wrapper-->
									<div class="mb-1">
										<!--begin::Label-->
										<label class="form-label fw-bolder text-dark fs-6">Password</label>
										<!--end::Label-->
										<!--begin::Input wrapper-->
										<div class="position-relative mb-3">
											<input class="form-control form-control-lg form-control-solid"
												type="password" placeholder="" name="password" autocomplete="off" />
											<span
												class="btn btn-sm btn-icon position-absolute translate-middle top-50 end-0 me-n2"
												data-kt-password-meter-control="visibility">
												<i class="bi bi-eye-slash fs-2"></i>
												<i class="bi bi-eye fs-2 d-none"></i>
											</span>
										</div>
										<!--end::Input wrapper-->
										<!--begin::Meter-->
										<div class="d-flex align-items-center mb-3"
											data-kt-password-meter-control="highlight">
											<div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2">
											</div>
											<div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2">
											</div>
											<div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2">
											</div>
											<div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px"></div>
										</div>
										<!--end::Meter-->
									</div>
									<!--end::Wrapper-->
									<!--begin::Hint-->
									<div class="text-muted">Use 8 or more characters with a mix of letters, numbers
										&amp; symbols.</div>
									<!--end::Hint-->
								</div>
								<!--end::Input group=-->
								<!--begin::Input group-->
								<div class="fv-row mb-5">
									<label class="form-label fw-bolder text-dark fs-6">Confirm Password</label>
									<input class="form-control form-control-lg form-control-solid" type="password"
										placeholder="" name="confirm-password" autocomplete="off" />
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
								<!--begin::Input group-->
								<div class="fv-row mb-10">
									<label class="form-check form-check-custom form-check-solid form-check-inline">
										<input class="form-check-input" type="checkbox" name="toc" value="1" />
										<span class="form-check-label fw-bold text-gray-700 fs-6">I Agree &amp;
											<a href="#" class="ms-1 link-primary">Terms and conditions</a>.</span>
									</label>
								</div>
								<!--end::Input group-->
								<!--begin::Actions-->
								<div class="text-center">
									<button type="button" id="kt_sign_up_submit" class="btn btn-lg btn-primary">
										<span class="indicator-label">Submit</span>
										<span class="indicator-progress">Please wait...
											<span
												class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
									</button>
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
				<!--end::Authentication - Sign-up-->
			</div>
			<!--end::Main-->
			<!--begin::Javascript-->
			<!--begin::Global Javascript Bundle(used by all pages)-->
			<script src="assets/plugins/global/plugins.bundle.js"></script>
			<script src="assets/js/scripts.bundle.js"></script>
			<script src="assets/js/axios.min.js"></script>
			<!--end::Global Javascript Bundle-->
			<!--begin::Page Custom Javascript(used by this page)-->
			<script src="assets/js/custom/authentication/sign-up/general.js"></script>
			<script src="https://accounts.google.com/gsi/client" async defer></script>
			<script>
				window.onload = function () {
					google.accounts.id.initialize({
						client_id: '${googleClientSecret.getClient_id()}',
						callback: function (credentialResponse) {
							let response = credentialResponse;
							console.log(response);
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