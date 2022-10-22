<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="en">
	<!--begin::Head-->

	<head>
		<base href="/">
		<meta charset="utf-8" />
		<title>Metronic | Training Support System</title>
		<meta name="description" content="Training Support System" />
		<meta name="keywords" content="Training Support System" />
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

	<body id="kt_body" data-bs-spy="scroll" data-bs-target="#kt_landing_menu" data-bs-offset="200"
		class="bg-white position-relative">
		<!--begin::Main-->
		<div class="d-flex flex-column flex-root">
			<!--begin::Header Section-->
			<div class="mb-0" id="home">
				<!--begin::Wrapper-->
				<div class="bgi-no-repeat bgi-size-contain bgi-position-x-center bgi-position-y-bottom landing-dark-bg"
					style="background-image: url(assets/media/svg/illustrations/landing.svg)">
					<!--begin::Header-->
					<div class="landing-header" data-kt-sticky="true" data-kt-sticky-name="landing-header"
						data-kt-sticky-offset="{default: '200px', lg: '300px'}">
						<!--begin::Container-->
						<div class="container">
							<!--begin::Wrapper-->
							<div class="d-flex align-items-center justify-content-between">
								<!--begin::Logo-->
								<div class="d-flex align-items-center flex-equal">
									<!--begin::Mobile menu toggle-->
									<button class="btn btn-icon btn-active-color-primary me-3 d-flex d-lg-none"
										id="kt_landing_menu_toggle">
										<!--begin::Svg Icon | path: icons/duotone/Text/Menu.svg-->
										<span class="svg-icon svg-icon-2hx">
											<svg xmlns="http://www.w3.org/2000/svg"
												xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
												viewBox="0 0 24 24" version="1.1">
												<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
													<rect x="0" y="0" width="24" height="24" />
													<rect fill="#000000" x="4" y="5" width="16" height="3" rx="1.5" />
													<path
														d="M5.5,15 L18.5,15 C19.3284271,15 20,15.6715729 20,16.5 C20,17.3284271 19.3284271,18 18.5,18 L5.5,18 C4.67157288,18 4,17.3284271 4,16.5 C4,15.6715729 4.67157288,15 5.5,15 Z M5.5,10 L18.5,10 C19.3284271,10 20,10.6715729 20,11.5 C20,12.3284271 19.3284271,13 18.5,13 L5.5,13 C4.67157288,13 4,12.3284271 4,11.5 C4,10.6715729 4.67157288,10 5.5,10 Z"
														fill="#000000" opacity="0.3" />
												</g>
											</svg>
										</span>
										<!--end::Svg Icon-->
									</button>
									<!--end::Mobile menu toggle-->
									<!--begin::Logo image-->
									<a href="/">
										<img alt="Logo" src="assets/media/logos/logo-2.svg"
											class="logo-default h-25px h-lg-30px" />
										<img alt="Logo" src="assets/media/logos/logo-2-dark.svg"
											class="logo-sticky h-20px h-lg-25px" />
									</a>
									<!--end::Logo image-->
								</div>
								<!--end::Logo-->
								<!--begin::Menu wrapper-->
								<div class="d-lg-block" id="kt_header_nav_wrapper">
									<div class="d-lg-block p-5 p-lg-0" data-kt-drawer="true"
										data-kt-drawer-name="landing-menu"
										data-kt-drawer-activate="{default: true, lg: false}"
										data-kt-drawer-overlay="true" data-kt-drawer-width="200px"
										data-kt-drawer-direction="start" data-kt-drawer-toggle="#kt_landing_menu_toggle"
										data-kt-place="true" data-kt-place-mode="prepend"
										data-kt-place-parent="{default: '#kt_body', lg: '#kt_header_nav_wrapper'}">
										<!--begin::Menu-->
										<div class="menu menu-column flex-nowrap menu-rounded menu-lg-row menu-title-gray-500 menu-state-title-primary nav nav-flush fs-5 fw-bold"
											id="kt_landing_menu">
											<!--begin::Menu item-->
											<div class="menu-item">
												<!--begin::Menu link-->
												<a class="menu-link nav-link active py-3 px-4 px-xxl-6" href="#kt_body"
													data-kt-scroll-toggle="true" data-kt-drawer-dismiss="true">Home</a>
												<!--end::Menu link-->
											</div>
											<!--end::Menu item-->
											<!--begin::Menu item-->
											<div class="menu-item">
												<!--begin::Menu link-->
												<a class="menu-link nav-link py-3 px-4 px-xxl-6" href="#how-it-works"
													data-kt-scroll-toggle="true" data-kt-drawer-dismiss="true">Why Metronic works</a>
												<!--end::Menu link-->
											</div>
											<!--end::Menu item-->
											<!--begin::Menu item-->
											<div class="menu-item">
												<!--begin::Menu link-->
												<a class="menu-link nav-link py-3 px-4 px-xxl-6" href="#achievements"
													data-kt-scroll-toggle="true"
													data-kt-drawer-dismiss="true">Achievements</a>
												<!--end::Menu link-->
											</div>
											<!--end::Menu item-->
											<!--begin::Menu item-->
											<div class="menu-item">
												<!--begin::Menu link-->
												<a class="menu-link nav-link py-3 px-4 px-xxl-6" href="#team"
													data-kt-scroll-toggle="true" data-kt-drawer-dismiss="true">Teacher</a>
												<!--end::Menu link-->
											</div>
											<!--end::Menu item-->
											<!--begin::Menu item-->
											<div class="menu-item">
												<!--begin::Menu link-->
												<a class="menu-link nav-link py-3 px-4 px-xxl-6" href="#portfolio"
													data-kt-scroll-toggle="true"
													data-kt-drawer-dismiss="true">Portfolio</a>
												<!--end::Menu link-->
											</div>
											<!--end::Menu item-->
										</div>
										<!--end::Menu-->
									</div>
								</div>
								<!--end::Menu wrapper-->
								<!--begin::Toolbar-->
								<c:if test="${logged==false}">
									<div class="flex-equal text-end ms-1">
                                                                            <a href="/register" class="btn btn-success">Sign Up</a>
										<a href="/login" class="btn btn-success">Sign In</a>
									</div>
                                                                        
								</c:if>
								<c:if test="${logged==true}">
									<div class="flex-equal text-end ms-1">
										<a href="/dashboard" class="btn btn-success">Dashboard</a>
									</div>
								</c:if>
								<!--end::Toolbar-->
							</div>
							<!--end::Wrapper-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Header-->
					<!--begin::Landing hero-->
					<div class="d-flex flex-column flex-center w-100 min-h-350px min-h-lg-500px px-9">
						<!--begin::Heading-->
						<div class="text-center mb-5 mb-lg-10 py-10 py-lg-20">
							<!--begin::Title-->
							<h1 class="text-white lh-base fw-bolder fs-2x fs-lg-3x mb-15">For every student,
								every classroom.
								<br />with
								<span
									style="background: linear-gradient(to right, #12CE5D 0%, #FFD80C 100%);-webkit-background-clip: text;-webkit-text-fill-color: transparent;">
									<span id="kt_landing_hero_text">Real results.</span>
								</span>
							</h1>
							<!--end::Title-->
							<!--begin::Action-->
							<a href="/login" class="btn btn-primary">Try Metronic</a>
							<!--end::Action-->
						</div>
						<!--end::Heading-->
						<!--begin::Clients-->

						<!--end::Clients-->
					</div>
					<!--end::Landing hero-->
				</div>
				<!--end::Wrapper-->
				<!--begin::Curve bottom-->
				<div class="landing-curve landing-dark-color mb-10 mb-lg-20">
					<svg viewBox="15 12 1470 48" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path
							d="M0 11C3.93573 11.3356 7.85984 11.6689 11.7725 12H1488.16C1492.1 11.6689 1496.04 11.3356 1500 11V12H1488.16C913.668 60.3476 586.282 60.6117 11.7725 12H0V11Z"
							fill="currentColor"></path>
					</svg>
				</div>
				<!--end::Curve bottom-->
			</div>
			<!--end::Header Section-->
			<!--begin::How It Works Section-->
			<div class="mb-n10 mb-lg-n20 z-index-2">
				<!--begin::Container-->
				<div class="container">
					<!--begin::Heading-->
					<div class="text-center mb-17">
						<!--begin::Title-->
						<h3 class="fs-2hx text-dark mb-5" id="how-it-works"
							data-kt-scroll-offset="{default: 100, lg: 150}">
							Why Metronic works</h3>
						<!--end::Title-->
						<!--begin::Text-->
						<div class="fs-5 text-muted fw-bold">We're a nonprofit with the mission to provide a free,
							world-class education for anyone, anywhere.
						</div>
						<!--end::Text-->
					</div>
					<!--end::Heading-->
					<!--begin::Row-->
					<div class="row w-100 gy-10 mb-md-20">
						<!--begin::Col-->
						<div class="col-md-4 px-5">
							<!--begin::Story-->
							<div class="text-center mb-10 mb-md-0">
								<!--begin::Illustration-->
								<img src="assets/media/illustrations/process-2.png" class="mh-125px mb-9" alt="" />
								<!--end::Illustration-->
								<!--begin::Heading-->
								<div class="d-flex flex-center mb-5">
									<!--begin::Badge-->
									<span
										class="badge badge-circle badge-light-success fw-bolder p-5 me-3 fs-3">1</span>
									<!--end::Badge-->
									<!--begin::Title-->
									<div class="fs-5 fs-lg-3 fw-bolder text-dark">Personalized learning</div>
									<!--end::Title-->
								</div>
								<!--end::Heading-->
								<!--begin::Description-->
								<div class="fw-bold fs-6 fs-lg-4 text-muted">Students practice at their own pace,
									<br /> first filling in gaps in their understanding
									<br />and then accelerating their learning.
								</div>
								<!--end::Description-->
							</div>
							<!--end::Story-->
						</div>
						<!--end::Col-->
						<!--begin::Col-->
						<div class="col-md-4 px-5">
							<!--begin::Story-->
							<div class="text-center mb-10 mb-md-0">
								<!--begin::Illustration-->
								<img src="assets/media/illustrations/process-3.png" class="mh-125px mb-9" alt="" />
								<!--end::Illustration-->
								<!--begin::Heading-->
								<div class="d-flex flex-center mb-5">
									<!--begin::Badge-->
									<span
										class="badge badge-circle badge-light-success fw-bolder p-5 me-3 fs-3">2</span>
									<!--end::Badge-->
									<!--begin::Title-->
									<div class="fs-5 fs-lg-3 fw-bolder text-dark">Trusted content</div>
									<!--end::Title-->
								</div>
								<!--end::Heading-->
								<!--begin::Description-->
								<div class="fw-bold fs-6 fs-lg-4 text-muted">Created by experts, Metronic Academy's
									library
									<br />of trusted practice and lessons covers math,
									<br /> science, and more. Always free for learners and teachers.
								</div>
								<!--end::Description-->
							</div>
							<!--end::Story-->
						</div>
						<!--end::Col-->
						<!--begin::Col-->
						<div class="col-md-4 px-5">
							<!--begin::Story-->
							<div class="text-center mb-10 mb-md-0">
								<!--begin::Illustration-->
								<img src="assets/media/illustrations/process-4.png" class="mh-125px mb-9" alt="" />
								<!--end::Illustration-->
								<!--begin::Heading-->
								<div class="d-flex flex-center mb-5">
									<!--begin::Badge-->
									<span
										class="badge badge-circle badge-light-success fw-bolder p-5 me-3 fs-3">3</span>
									<!--end::Badge-->
									<!--begin::Title-->
									<div class="fs-5 fs-lg-3 fw-bolder text-dark">Tools to empower teachers</div>
									<!--end::Title-->
								</div>
								<!--end::Heading-->
								<!--begin::Description-->
								<div class="fw-bold fs-6 fs-lg-4 text-muted">With Metronic Academy, teachers can
									identify
									<br />gaps in their students understanding, tailor
									<br />instruction, and meet the needs of every student.
								</div>
								<!--end::Description-->
							</div>
							<!--end::Story-->
						</div>
						<!--end::Col-->
					</div>
					<!--end::Row-->
					<!--begin::Product slider-->
					<div class="tns tns-default">
						<!--begin::Slider-->
						<div data-tns="true" data-tns-loop="true" data-tns-swipe-angle="false" data-tns-speed="2000"
							data-tns-autoplay="true" data-tns-autoplay-timeout="18000" data-tns-controls="true"
							data-tns-nav="false" data-tns-items="1" data-tns-center="false" data-tns-dots="false"
							data-tns-prev-button="#kt_team_slider_prev1" data-tns-next-button="#kt_team_slider_next1">
							<!--begin::Item-->
							<div class="text-center px-5 pt-5 pt-lg-10 px-lg-10">
								<img src="assets/media/product-demos/demo1.png" class="card-rounded shadow mw-100"
									alt="" />
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center px-5 pt-5 pt-lg-10 px-lg-10">
								<img src="assets/media/product-demos/demo2.png" class="card-rounded shadow mw-100"
									alt="" />
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center px-5 pt-5 pt-lg-10 px-lg-10">
								<img src="assets/media/product-demos/demo4.png" class="card-rounded shadow mw-100"
									alt="" />
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center px-5 pt-5 pt-lg-10 px-lg-10">
								<img src="assets/media/product-demos/demo5.png" class="card-rounded shadow mw-100"
									alt="" />
							</div>
							<!--end::Item-->
						</div>
						<!--end::Slider-->
						<!--begin::Slider button-->
						<button class="btn btn-icon btn-active-color-primary" id="kt_team_slider_prev1">
							<!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-left.svg-->
							<span class="svg-icon svg-icon-3x">
								<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
									width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
									<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
										<polygon points="0 0 24 0 24 24 0 24" />
										<path
											d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z"
											fill="#000000" fill-rule="nonzero"
											transform="translate(12.000003, 11.999999) scale(-1, 1) rotate(-270.000000) translate(-12.000003, -11.999999)" />
									</g>
								</svg>
							</span>
							<!--end::Svg Icon-->
						</button>
						<!--end::Slider button-->
						<!--begin::Slider button-->
						<button class="btn btn-icon btn-active-color-primary" id="kt_team_slider_next1">
							<!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-right.svg-->
							<span class="svg-icon svg-icon-3x">
								<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
									width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
									<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
										<polygon points="0 0 24 0 24 24 0 24" />
										<path
											d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z"
											fill="#000000" fill-rule="nonzero"
											transform="translate(12.000003, 11.999999) rotate(-270.000000) translate(-12.000003, -11.999999)" />
									</g>
								</svg>
							</span>
							<!--end::Svg Icon-->
						</button>
						<!--end::Slider button-->
					</div>
					<!--end::Product slider-->
				</div>
				<!--end::Container-->
			</div>
			<!--end::How It Works Section-->
			<!--begin::Statistics Section-->
			<div class="mt-sm-n10">
				<!--begin::Curve top-->
				<div class="landing-curve landing-dark-color">
					<svg viewBox="15 -1 1470 48" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path
							d="M1 48C4.93573 47.6644 8.85984 47.3311 12.7725 47H1489.16C1493.1 47.3311 1497.04 47.6644 1501 48V47H1489.16C914.668 -1.34764 587.282 -1.61174 12.7725 47H1V48Z"
							fill="currentColor"></path>
					</svg>
				</div>
				<!--end::Curve top-->
				<!--begin::Wrapper-->
				<div class="pb-15 pt-18 landing-dark-bg">
					<!--begin::Container-->
					<div class="container">
						<!--begin::Heading-->
						<div class="text-center mt-15 mb-18" id="achievements"
							data-kt-scroll-offset="{default: 100, lg: 150}">
							<!--begin::Title-->
							<h3 class="fs-2hx text-white fw-bolder mb-5">You can learn anything.</h3>
							<!--end::Title-->
							<!--begin::Description-->
							<div class="fs-5 text-gray-700 fw-bold">Build a deep, solid understanding in math, science,
								and more.
							</div>
							<!--end::Description-->
						</div>
						<!--end::Heading-->
						<!--begin::Statistics-->
						<div class="d-flex flex-center">
							<!--begin::Items-->
							<div
								class="d-flex flex-wrap flex-center justify-content-lg-between mb-15 mx-auto w-xl-900px">
								<!--begin::Item-->
								<div class="d-flex flex-column flex-center h-200px w-200px h-lg-250px w-lg-250px m-3 bgi-no-repeat bgi-position-center bgi-size-contain"
									style="background-image: url('assets/media/svg/misc/octagon.svg')">
									<!--begin::Symbol-->
									<!--begin::Svg Icon | path: icons/duotone/Interface/Grid.svg-->
									<span class="svg-icon svg-icon-2tx svg-icon-white mb-3">
										<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none">
											<path opacity="0.25"
												d="M13.1721 15.4724C13.3364 14.2725 14.2725 13.3364 15.4724 13.1721C16.1606 13.0778 16.9082 13 17.5 13C18.0918 13 18.8394 13.0778 19.5276 13.1721C20.7275 13.3364 21.6636 14.2725 21.8279 15.4724C21.9222 16.1606 22 16.9082 22 17.5C22 18.0918 21.9222 18.8394 21.8279 19.5276C21.6636 20.7275 20.7275 21.6636 19.5276 21.8279C18.8394 21.9222 18.0918 22 17.5 22C16.9082 22 16.1606 21.9222 15.4724 21.8279C14.2725 21.6636 13.3364 20.7275 13.1721 19.5276C13.0778 18.8394 13 18.0918 13 17.5C13 16.9082 13.0778 16.1606 13.1721 15.4724Z"
												fill="#12131A" />
											<path opacity="0.25"
												d="M2.17209 15.4724C2.33642 14.2725 3.27253 13.3364 4.47244 13.1721C5.16065 13.0778 5.90816 13 6.5 13C7.09184 13 7.83935 13.0778 8.52756 13.1721C9.72747 13.3364 10.6636 14.2725 10.8279 15.4724C10.9222 16.1606 11 16.9082 11 17.5C11 18.0918 10.9222 18.8394 10.8279 19.5276C10.6636 20.7275 9.72747 21.6636 8.52756 21.8279C7.83935 21.9222 7.09184 22 6.5 22C5.90816 22 5.16065 21.9222 4.47244 21.8279C3.27253 21.6636 2.33642 20.7275 2.17209 19.5276C2.07784 18.8394 2 18.0918 2 17.5C2 16.9082 2.07784 16.1606 2.17209 15.4724Z"
												fill="#12131A" />
											<path opacity="0.25"
												d="M13.1721 4.47244C13.3364 3.27253 14.2725 2.33642 15.4724 2.17209C16.1606 2.07784 16.9082 2 17.5 2C18.0918 2 18.8394 2.07784 19.5276 2.17209C20.7275 2.33642 21.6636 3.27253 21.8279 4.47244C21.9222 5.16065 22 5.90816 22 6.5C22 7.09184 21.9222 7.83935 21.8279 8.52756C21.6636 9.72747 20.7275 10.6636 19.5276 10.8279C18.8394 10.9222 18.0918 11 17.5 11C16.9082 11 16.1606 10.9222 15.4724 10.8279C14.2725 10.6636 13.3364 9.72747 13.1721 8.52756C13.0778 7.83935 13 7.09184 13 6.5C13 5.90816 13.0778 5.16065 13.1721 4.47244Z"
												fill="#12131A" />
											<path
												d="M2.17209 4.47244C2.33642 3.27253 3.27253 2.33642 4.47244 2.17209C5.16065 2.07784 5.90816 2 6.5 2C7.09184 2 7.83935 2.07784 8.52756 2.17209C9.72747 2.33642 10.6636 3.27253 10.8279 4.47244C10.9222 5.16065 11 5.90816 11 6.5C11 7.09184 10.9222 7.83935 10.8279 8.52756C10.6636 9.72747 9.72747 10.6636 8.52756 10.8279C7.83935 10.9222 7.09184 11 6.5 11C5.90816 11 5.16065 10.9222 4.47244 10.8279C3.27253 10.6636 2.33642 9.72747 2.17209 8.52756C2.07784 7.83935 2 7.09184 2 6.5C2 5.90816 2.07784 5.16065 2.17209 4.47244Z"
												fill="#12131A" />
										</svg>
									</span>
									<!--end::Svg Icon-->
									<!--end::Symbol-->
									<!--begin::Info-->
									<div class="mb-0">
										<!--begin::Value-->
										<div class="fs-lg-2hx fs-2x fw-bolder text-white d-flex flex-center">
											<div class="min-w-70px" data-kt-countup="true" data-kt-countup-value="700"
												data-kt-countup-suffix="+">0</div>
										</div>
										<!--end::Value-->
										<!--begin::Label-->
										<span class="text-gray-600 fw-bold fs-5 lh-0">Known Companies</span>
										<!--end::Label-->
									</div>
									<!--end::Info-->
								</div>
								<!--end::Item-->
								<!--begin::Item-->
								<div class="d-flex flex-column flex-center h-200px w-200px h-lg-250px w-lg-250px m-3 bgi-no-repeat bgi-position-center bgi-size-contain"
									style="background-image: url('assets/media/svg/misc/octagon.svg')">
									<!--begin::Symbol-->
									<!--begin::Svg Icon | path: icons/duotone/Interface/Pie-04.svg-->
									<span class="svg-icon svg-icon-2tx svg-icon-white mb-3">
										<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none">
											<path opacity="0.25" fill-rule="evenodd" clip-rule="evenodd"
												d="M13.998 21.9445C13.4491 22.0057 13 21.5523 13 21L13 14C13 13.4477 13.4477 13 14 13L21 13C21.5523 13 22.0058 13.4491 21.9445 13.998C21.8509 14.8372 21.6394 15.6609 21.3149 16.4442C20.8626 17.5361 20.1997 18.5282 19.364 19.364C18.5282 20.1997 17.5361 20.8626 16.4442 21.3149C15.6609 21.6394 14.8373 21.8509 13.998 21.9445Z"
												fill="#12131A" />
											<path fill-rule="evenodd" clip-rule="evenodd"
												d="M21.9445 10.0019C22.0057 10.5508 21.5523 10.9999 21 10.9999L14 10.9999C13.4477 10.9999 13 10.5521 13 9.99986L13 2.99986C13 2.44758 13.4491 1.99412 13.9979 2.05536C14.8372 2.149 15.6609 2.3605 16.4441 2.68495C17.5361 3.13724 18.5282 3.80017 19.3639 4.6359C20.1997 5.47163 20.8626 6.46378 21.3149 7.55571C21.6393 8.33899 21.8508 9.16262 21.9445 10.0019Z"
												fill="#12131A" />
											<path opacity="0.25" fill-rule="evenodd" clip-rule="evenodd"
												d="M10.002 3.05559C10.5509 2.99437 11 3.44784 11 4.00012L11 20.0001C11 20.5524 10.5509 21.0059 10.002 20.9446C7.98222 20.7193 6.08694 19.815 4.63604 18.3641C2.94821 16.6763 2 14.3871 2 12.0001C2 9.61317 2.94821 7.32398 4.63604 5.63616C6.08694 4.18525 7.98222 3.2809 10.002 3.05559Z"
												fill="#12131A" />
										</svg>
									</span>
									<!--end::Svg Icon-->
									<!--end::Symbol-->
									<!--begin::Info-->
									<div class="mb-0">
										<!--begin::Value-->
										<div class="fs-lg-2hx fs-2x fw-bolder text-white d-flex flex-center">
											<div class="min-w-70px" data-kt-countup="true" data-kt-countup-value="80"
												data-kt-countup-suffix="K+">0</div>
										</div>
										<!--end::Value-->
										<!--begin::Label-->
										<span class="text-gray-600 fw-bold fs-5 lh-0">Statistic Reports</span>
										<!--end::Label-->
									</div>
									<!--end::Info-->
								</div>
								<!--end::Item-->
								<!--begin::Item-->
								<div class="d-flex flex-column flex-center h-200px w-200px h-lg-250px w-lg-250px m-3 bgi-no-repeat bgi-position-center bgi-size-contain"
									style="background-image: url('assets/media/svg/misc/octagon.svg')">
									<!--begin::Symbol-->
									<!--begin::Svg Icon | path: icons/duotone/Shopping/Cart4.svg-->
									<span class="svg-icon svg-icon-2tx svg-icon-white mb-3">
										<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none">
											<path opacity="0.25"
												d="M3.19406 11.1644C3.09247 10.5549 3.56251 10 4.18045 10H19.8195C20.4375 10 20.9075 10.5549 20.8059 11.1644L19.4178 19.4932C19.1767 20.9398 17.9251 22 16.4586 22H7.54138C6.07486 22 4.82329 20.9398 4.58219 19.4932L3.19406 11.1644Z"
												fill="#7E8299" />
											<path
												d="M2 9.5C2 8.67157 2.67157 8 3.5 8H20.5C21.3284 8 22 8.67157 22 9.5C22 10.3284 21.3284 11 20.5 11H3.5C2.67157 11 2 10.3284 2 9.5Z"
												fill="#7E8299" />
											<path
												d="M10 13C9.44772 13 9 13.4477 9 14V18C9 18.5523 9.44772 19 10 19C10.5523 19 11 18.5523 11 18V14C11 13.4477 10.5523 13 10 13Z"
												fill="#7E8299" />
											<path
												d="M14 13C13.4477 13 13 13.4477 13 14V18C13 18.5523 13.4477 19 14 19C14.5523 19 15 18.5523 15 18V14C15 13.4477 14.5523 13 14 13Z"
												fill="#7E8299" />
											<g opacity="0.25">
												<path
													d="M10.7071 3.70711C11.0976 3.31658 11.0976 2.68342 10.7071 2.29289C10.3166 1.90237 9.68342 1.90237 9.29289 2.29289L4.29289 7.29289C3.90237 7.68342 3.90237 8.31658 4.29289 8.70711C4.68342 9.09763 5.31658 9.09763 5.70711 8.70711L10.7071 3.70711Z"
													fill="#7E8299" />
												<path
													d="M13.2929 3.70711C12.9024 3.31658 12.9024 2.68342 13.2929 2.29289C13.6834 1.90237 14.3166 1.90237 14.7071 2.29289L19.7071 7.29289C20.0976 7.68342 20.0976 8.31658 19.7071 8.70711C19.3166 9.09763 18.6834 9.09763 18.2929 8.70711L13.2929 3.70711Z"
													fill="#7E8299" />
											</g>
										</svg>
									</span>
									<!--end::Svg Icon-->
									<!--end::Symbol-->
									<!--begin::Info-->
									<div class="mb-0">
										<!--begin::Value-->
										<div class="fs-lg-2hx fs-2x fw-bolder text-white d-flex flex-center">
											<div class="min-w-70px" data-kt-countup="true" data-kt-countup-value="35"
												data-kt-countup-suffix="M+">0</div>
										</div>
										<!--end::Value-->
										<!--begin::Label-->
										<span class="text-gray-600 fw-bold fs-5 lh-0">Secure Payments</span>
										<!--end::Label-->
									</div>
									<!--end::Info-->
								</div>
								<!--end::Item-->
							</div>
							<!--end::Items-->
						</div>
						<!--end::Statistics-->
						<!--begin::Testimonial-->
						<!--end::Testimonial-->
						<!--begin::Author-->
						<!--end::Author-->
					</div>
					<!--end::Container-->
				</div>
				<!--end::Wrapper-->
				<!--begin::Curve bottom-->
				<div class="landing-curve landing-dark-color">
					<svg viewBox="15 12 1470 48" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path
							d="M0 11C3.93573 11.3356 7.85984 11.6689 11.7725 12H1488.16C1492.1 11.6689 1496.04 11.3356 1500 11V12H1488.16C913.668 60.3476 586.282 60.6117 11.7725 12H0V11Z"
							fill="currentColor"></path>
					</svg>
				</div>
				<!--end::Curve bottom-->
			</div>
			<!--end::Statistics Section-->
			<!--begin::Team Section-->
			<div class="py-10 py-lg-20">
				<!--begin::Container-->
				<div class="container">
					<!--begin::Heading-->
					<div class="text-center mb-12">
						<!--begin::Title-->
						<h3 class="fs-2hx text-dark mb-5" id="team" data-kt-scroll-offset="{default: 100, lg: 150}">Our
							Great Teacher</h3>
						<!--end::Title-->
						<!--begin::Sub-title-->
						<div class="fs-5 text-muted fw-bold">It's no doubt that when a development takes longer to
							complete,
							additional costs to
							<br />integrate and test each extra feature creeps up and haunts most of us.
						</div>
						<!--end::Sub-title=-->
					</div>
					<!--end::Heading-->
					<!--begin::Slider-->
					<div class="tns tns-default">
						<!--begin::Wrapper-->
						<div data-tns="true" data-tns-loop="true" data-tns-swipe-angle="false" data-tns-speed="2000"
							data-tns-autoplay="true" data-tns-autoplay-timeout="18000" data-tns-controls="true"
							data-tns-nav="false" data-tns-items="1" data-tns-center="false" data-tns-dots="false"
							data-tns-prev-button="#kt_team_slider_prev" data-tns-next-button="#kt_team_slider_next"
							data-tns-responsive="{1200: {items: 3}, 992: {items: 2}}">
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-2.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Paul Miles</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Development Lead</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-3.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Melisa Marcus</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Creative Director</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-4.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">David Nilson</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Python Expert</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-5.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Anne Clarc</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Project Manager</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-6.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Ricky Hunt</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Art Director</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-7.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Alice Wayde</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">Marketing Manager</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
							<!--begin::Item-->
							<div class="text-center">
								<!--begin::Photo-->
								<div class="octagon mx-auto mb-5 d-flex w-200px h-200px bgi-no-repeat bgi-size-contain bgi-position-center"
									style="background-image:url('assets/media/avatars/150-8.jpg')"></div>
								<!--end::Photo-->
								<!--begin::Person-->
								<div class="mb-0">
									<!--begin::Name-->
									<a href="#" class="text-dark fw-bolder text-hover-primary fs-3">Carles Puyol</a>
									<!--end::Name-->
									<!--begin::Position-->
									<div class="text-muted fs-6 fw-bold mt-1">QA Managers</div>
									<!--begin::Position-->
								</div>
								<!--end::Person-->
							</div>
							<!--end::Item-->
						</div>
						<!--end::Wrapper-->
						<!--begin::Button-->
						<button class="btn btn-icon btn-active-color-primary" id="kt_team_slider_prev">
							<!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-left.svg-->
							<span class="svg-icon svg-icon-3x">
								<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
									width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
									<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
										<polygon points="0 0 24 0 24 24 0 24" />
										<path
											d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z"
											fill="#000000" fill-rule="nonzero"
											transform="translate(12.000003, 11.999999) scale(-1, 1) rotate(-270.000000) translate(-12.000003, -11.999999)" />
									</g>
								</svg>
							</span>
							<!--end::Svg Icon-->
						</button>
						<!--end::Button-->
						<!--begin::Button-->
						<button class="btn btn-icon btn-active-color-primary" id="kt_team_slider_next">
							<!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-right.svg-->
							<span class="svg-icon svg-icon-3x">
								<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
									width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
									<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
										<polygon points="0 0 24 0 24 24 0 24" />
										<path
											d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z"
											fill="#000000" fill-rule="nonzero"
											transform="translate(12.000003, 11.999999) rotate(-270.000000) translate(-12.000003, -11.999999)" />
									</g>
								</svg>
							</span>
							<!--end::Svg Icon-->
						</button>
						<!--end::Button-->
					</div>
					<!--end::Slider-->
				</div>
				<!--end::Container-->
			</div>
			<!--end::Team Section-->
			<!--begin::Projects Section-->
			<div class="mb-lg-n15 position-relative z-index-2">
				<!--begin::Container-->
				<div class="container">
					<!--begin::Card-->
					<div class="card" style="filter: drop-shadow(0px 0px 40px rgba(68, 81, 96, 0.08))">
						<!--begin::Card body-->
						<div class="card-body p-lg-20">
							<!--begin::Heading-->
							<div class="text-center mb-5 mb-lg-10">
								<!--begin::Title-->
								<h3 class="fs-2hx text-dark mb-5" id="portfolio"
									data-kt-scroll-offset="{default: 100, lg: 150}">Our Projects</h3>
								<!--end::Title-->
							</div>
							<!--end::Heading-->
							<!--begin::Tabs wrapper-->
							<div class="d-flex flex-center mb-5 mb-lg-15">
								<!--begin::Tabs-->
								<ul class="nav border-transparent flex-center fs-5 fw-bold">
									<li class="nav-item">
										<a class="nav-link text-gray-500 text-active-primary px-3 px-lg-6 active"
											href="#" data-bs-toggle="tab"
											data-bs-target="#kt_landing_projects_latest">Latest</a>
									</li>
									<li class="nav-item">
										<a class="nav-link text-gray-500 text-active-primary px-3 px-lg-6" href="#"
											data-bs-toggle="tab" data-bs-target="#kt_landing_projects_web_design">Web
											Design</a>
									</li>
									<li class="nav-item">
										<a class="nav-link text-gray-500 text-active-primary px-3 px-lg-6" href="#"
											data-bs-toggle="tab"
											data-bs-target="#kt_landing_projects_mobile_apps">Mobile
											Apps</a>
									</li>
									<li class="nav-item">
										<a class="nav-link text-gray-500 text-active-primary px-3 px-lg-6" href="#"
											data-bs-toggle="tab"
											data-bs-target="#kt_landing_projects_development">Development</a>
									</li>
								</ul>
								<!--end::Tabs-->
							</div>
							<!--end::Tabs wrapper-->
							<!--begin::Tabs content-->
							<div class="tab-content">
								<!--begin::Tab pane-->
								<div class="tab-pane fade show active" id="kt_landing_projects_latest">
									<!--begin::Row-->
									<div class="row g-10">
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Item-->
											<a class="d-block card-rounded overlay h-lg-100"
												data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x600/img-23.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-lg-100 min-h-250px"
													style="background-image:url('assets/media/stock/600x600/img-23.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Row-->
											<div class="row g-10 mb-10">
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-22.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-22.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-21.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-21.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
											</div>
											<!--end::Row-->
											<!--begin::Item-->
											<a class="d-block card-rounded overlay" data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x400/img-20.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
													style="background-image:url('assets/media/stock/600x600/img-20.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
									</div>
									<!--end::Row-->
								</div>
								<!--end::Tab pane-->
								<!--begin::Tab pane-->
								<div class="tab-pane fade" id="kt_landing_projects_web_design">
									<!--begin::Row-->
									<div class="row g-10">
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Item-->
											<a class="d-block card-rounded overlay h-lg-100"
												data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x600/img-11.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-lg-100 min-h-250px"
													style="background-image:url('assets/media/stock/600x600/img-11.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Row-->
											<div class="row g-10 mb-10">
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-12.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-12.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-21.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-21.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
											</div>
											<!--end::Row-->
											<!--begin::Item-->
											<a class="d-block card-rounded overlay" data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x400/img-20.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
													style="background-image:url('assets/media/stock/600x600/img-20.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
									</div>
									<!--end::Row-->
								</div>
								<!--end::Tab pane-->
								<!--begin::Tab pane-->
								<div class="tab-pane fade" id="kt_landing_projects_mobile_apps">
									<!--begin::Row-->
									<div class="row g-10">
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Row-->
											<div class="row g-10 mb-10">
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-16.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-16.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-12.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-12.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
											</div>
											<!--end::Row-->
											<!--begin::Item-->
											<a class="d-block card-rounded overlay" data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x400/img-15.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
													style="background-image:url('assets/media/stock/600x600/img-15.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Item-->
											<a class="d-block card-rounded overlay h-lg-100"
												data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x600/img-23.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-lg-100 min-h-250px"
													style="background-image:url('assets/media/stock/600x600/img-23.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
									</div>
									<!--end::Row-->
								</div>
								<!--end::Tab pane-->
								<!--begin::Tab pane-->
								<div class="tab-pane fade" id="kt_landing_projects_development">
									<!--begin::Row-->
									<div class="row g-10">
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Item-->
											<a class="d-block card-rounded overlay h-lg-100"
												data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x600/img-15.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-lg-100 min-h-250px"
													style="background-image:url('assets/media/stock/600x600/img-15.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
										<!--begin::Col-->
										<div class="col-lg-6">
											<!--begin::Row-->
											<div class="row g-10 mb-10">
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-22.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-22.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
												<!--begin::Col-->
												<div class="col-lg-6">
													<!--begin::Item-->
													<a class="d-block card-rounded overlay"
														data-fslightbox="lightbox-projects"
														href="assets/media/stock/600x600/img-21.jpg">
														<!--begin::Image-->
														<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
															style="background-image:url('assets/media/stock/600x600/img-21.jpg')">
														</div>
														<!--end::Image-->
														<!--begin::Action-->
														<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
															<i class="bi bi-eye-fill fs-3x text-white"></i>
														</div>
														<!--end::Action-->
													</a>
													<!--end::Item-->
												</div>
												<!--end::Col-->
											</div>
											<!--end::Row-->
											<!--begin::Item-->
											<a class="d-block card-rounded overlay" data-fslightbox="lightbox-projects"
												href="assets/media/stock/600x400/img-14.jpg">
												<!--begin::Image-->
												<div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded h-250px"
													style="background-image:url('assets/media/stock/600x600/img-14.jpg')">
												</div>
												<!--end::Image-->
												<!--begin::Action-->
												<div class="overlay-layer card-rounded bg-dark bg-opacity-25">
													<i class="bi bi-eye-fill fs-3x text-white"></i>
												</div>
												<!--end::Action-->
											</a>
											<!--end::Item-->
										</div>
										<!--end::Col-->
									</div>
									<!--end::Row-->
								</div>
								<!--end::Tab pane-->
							</div>
							<!--end::Tabs content-->
						</div>
						<!--end::Card body-->
					</div>
					<!--end::Card-->
				</div>
				<!--end::Container-->
			</div>
			<!--end::Projects Section-->
			<!--begin::Pricing Section-->
			<!--end::Pricing Section-->
			<!--begin::Testimonials Section-->
			<div class="mt-20 mb-n20 position-relative z-index-2">
				<!--begin::Container-->
				<div class="container">
					<!--begin::Heading-->
					<div class="text-center mb-17">
						<!--begin::Title-->
						<h3 class="fs-2hx text-dark mb-5" id="clients" data-kt-scroll-offset="{default: 125, lg: 150}">
							What
							Our Clients Say</h3>
						<!--end::Title-->
						<!--begin::Description-->
						<div class="fs-5 text-muted fw-bold">Save thousands to millions of bucks by using single tool
							<br />for different amazing and great useful admin
						</div>
						<!--end::Description-->
					</div>
					<!--end::Heading-->
					<!--begin::Row-->
					<div class="row g-lg-10 mb-10 mb-lg-20">
						<!--begin::Col-->
						<div class="col-lg-4">
							<!--begin::Testimonial-->
							<div
								class="d-flex flex-column justify-content-between h-lg-100 px-10 px-lg-0 pe-lg-10 mb-15 mb-lg-0">
								<!--begin::Wrapper-->
								<div class="mb-7">
									<!--begin::Rating-->
									<div class="rating mb-6">
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
									</div>
									<!--end::Rating-->
									<!--begin::Title-->
									<div class="fs-2 fw-bolder text-dark mb-3">This is by far the cleanest template
										<br />and the most well structured
									</div>
									<!--end::Title-->
									<!--begin::Feedback-->
									<div class="text-gray-500 fw-bold fs-4">The most well thought out design theme I
										have
										ever used. The codes are up to tandard. The css styles are very clean. In fact
										the
										cleanest and the most up to standard I have ever seen.</div>
									<!--end::Feedback-->
								</div>
								<!--end::Wrapper-->
								<!--begin::Author-->
								<div class="d-flex align-items-center">
									<!--begin::Avatar-->
									<div class="symbol symbol-circle symbol-50px me-5">
										<img src="assets/media/avatars/150-2.jpg" class="" alt="" />
									</div>
									<!--end::Avatar-->
									<!--begin::Name-->
									<div class="flex-grow-1">
										<a href="#" class="text-dark fw-bolder text-hover-primary fs-6">Paul Miles</a>
										<span class="text-muted d-block fw-bold">Development Lead</span>
									</div>
									<!--end::Name-->
								</div>
								<!--end::Author-->
							</div>
							<!--end::Testimonial-->
						</div>
						<!--end::Col-->
						<!--begin::Col-->
						<div class="col-lg-4">
							<!--begin::Testimonial-->
							<div
								class="d-flex flex-column justify-content-between h-lg-100 px-10 px-lg-0 pe-lg-10 mb-15 mb-lg-0">
								<!--begin::Wrapper-->
								<div class="mb-7">
									<!--begin::Rating-->
									<div class="rating mb-6">
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
									</div>
									<!--end::Rating-->
									<!--begin::Title-->
									<div class="fs-2 fw-bolder text-dark mb-3">This is by far the cleanest template
										<br />and the most well structured
									</div>
									<!--end::Title-->
									<!--begin::Feedback-->
									<div class="text-gray-500 fw-bold fs-4">The most well thought out design theme I
										have
										ever used. The codes are up to tandard. The css styles are very clean. In fact
										the
										cleanest and the most up to standard I have ever seen.</div>
									<!--end::Feedback-->
								</div>
								<!--end::Wrapper-->
								<!--begin::Author-->
								<div class="d-flex align-items-center">
									<!--begin::Avatar-->
									<div class="symbol symbol-circle symbol-50px me-5">
										<img src="assets/media/avatars/150-3.jpg" class="" alt="" />
									</div>
									<!--end::Avatar-->
									<!--begin::Name-->
									<div class="flex-grow-1">
										<a href="#" class="text-dark fw-bolder text-hover-primary fs-6">Janya
											Clebert</a>
										<span class="text-muted d-block fw-bold">Development Lead</span>
									</div>
									<!--end::Name-->
								</div>
								<!--end::Author-->
							</div>
							<!--end::Testimonial-->
						</div>
						<!--end::Col-->
						<!--begin::Col-->
						<div class="col-lg-4">
							<!--begin::Testimonial-->
							<div
								class="d-flex flex-column justify-content-between h-lg-100 px-10 px-lg-0 pe-lg-10 mb-15 mb-lg-0">
								<!--begin::Wrapper-->
								<div class="mb-7">
									<!--begin::Rating-->
									<div class="rating mb-6">
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
										<div class="rating-label me-2 checked">
											<i class="bi bi-star-fill fs-5"></i>
										</div>
									</div>
									<!--end::Rating-->
									<!--begin::Title-->
									<div class="fs-2 fw-bolder text-dark mb-3">This is by far the cleanest template
										<br />and the most well structured
									</div>
									<!--end::Title-->
									<!--begin::Feedback-->
									<div class="text-gray-500 fw-bold fs-4">The most well thought out design theme I
										have
										ever used. The codes are up to tandard. The css styles are very clean. In fact
										the
										cleanest and the most up to standard I have ever seen.</div>
									<!--end::Feedback-->
								</div>
								<!--end::Wrapper-->
								<!--begin::Author-->
								<div class="d-flex align-items-center">
									<!--begin::Avatar-->
									<div class="symbol symbol-circle symbol-50px me-5">
										<img src="assets/media/avatars/150-18.jpg" class="" alt="" />
									</div>
									<!--end::Avatar-->
									<!--begin::Name-->
									<div class="flex-grow-1">
										<a href="#" class="text-dark fw-bolder text-hover-primary fs-6">Steave Brown</a>
										<span class="text-muted d-block fw-bold">Development Lead</span>
									</div>
									<!--end::Name-->
								</div>
								<!--end::Author-->
							</div>
							<!--end::Testimonial-->
						</div>
						<!--end::Col-->
					</div>
					<!--end::Row-->
					<!--begin::Highlight-->
					<div class="d-flex flex-stack flex-wrap flex-md-nowrap card-rounded shadow p-8 p-lg-12 mb-n5 mb-lg-n13"
						style="background: linear-gradient(90deg, #20AA3E 0%, #03A588 100%);">
						<!--begin::Content-->
						<div class="my-2 me-5">
							<!--begin::Title-->
							<div class="fs-1 fs-lg-2qx fw-bolder text-white mb-2">Start With Metronic Today,
								<span class="fw-normal">Speed Up Development!</span>
							</div>
							<!--end::Title-->
							<!--begin::Description-->
							<div class="fs-6 fs-lg-5 text-white fw-bold opacity-75">Join over 100,000 Professionals
								Community to Stay Ahead</div>
							<!--end::Description-->
						</div>
						<!--end::Content-->
						<!--begin::Link-->
						<a href="/login"
							class="btn btn-lg btn-outline border-2 btn-outline-white flex-shrink-0 my-2">Try now</a>
						<!--end::Link-->
					</div>
					<!--end::Highlight-->
				</div>
				<!--end::Container-->
			</div>
			<!--end::Testimonials Section-->
			<!--begin::Footer Section-->
			<div class="mb-0">
				<!--begin::Curve top-->
				<div class="landing-curve landing-dark-color">
					<svg viewBox="15 -1 1470 48" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path
							d="M1 48C4.93573 47.6644 8.85984 47.3311 12.7725 47H1489.16C1493.1 47.3311 1497.04 47.6644 1501 48V47H1489.16C914.668 -1.34764 587.282 -1.61174 12.7725 47H1V48Z"
							fill="currentColor"></path>
					</svg>
				</div>
				<!--end::Curve top-->
				<!--begin::Wrapper-->
				<div class="landing-dark-bg pt-20">
					<!--begin::Container-->
					<div class="container">
						<!--begin::Row-->
						<div class="row py-10 py-lg-20">
							<!--begin::Col-->
							<div class="col-lg-6 pe-lg-16 mb-10 mb-lg-0">
								<!--begin::Block-->
								<div class="rounded landing-dark-border p-9 mb-10">
									<!--begin::Title-->
									<h2 class="text-white">Would you need a Custom License?</h2>
									<!--end::Title-->
									<!--begin::Text-->
									<span class="fw-normal fs-4 text-gray-700">Email us to
										<a href="https://keenthemes.com/support"
											class="text-white opacity-50 text-hover-primary">support@keenthemes.com</a></span>
									<!--end::Text-->
								</div>
								<!--end::Block-->
								<!--begin::Block-->
								<div class="rounded landing-dark-border p-9">
									<!--begin::Title-->
									<h2 class="text-white">How About a Custom Project?</h2>
									<!--end::Title-->
									<!--begin::Text-->
									<span class="fw-normal fs-4 text-gray-700">Use Our Custom Development Service.
										<a href="pages/profile/overview.html"
											class="text-white opacity-50 text-hover-primary">Click to Get a
											Quote</a></span>
									<!--end::Text-->
								</div>
								<!--end::Block-->
							</div>
							<!--end::Col-->
							<!--begin::Col-->
							<div class="col-lg-6 ps-lg-16">
								<!--begin::Navs-->
								<div class="d-flex justify-content-center">
									<!--begin::Links-->
									<div class="d-flex fw-bold flex-column me-20">
										<!--begin::Subtitle-->
										<h4 class="fw-bolder text-gray-400 mb-6">More for Metronic</h4>
										<!--end::Subtitle-->
										<!--begin::Link-->
										<a href="#" class="text-white opacity-50 text-hover-primary fs-5 mb-6">FAQ</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#"
											class="text-white opacity-50 text-hover-primary fs-5 mb-6">Documentaions</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="text-white opacity-50 text-hover-primary fs-5 mb-6">Video
											Tuts</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#"
											class="text-white opacity-50 text-hover-primary fs-5 mb-6">Changelog</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#"
											class="text-white opacity-50 text-hover-primary fs-5 mb-6">Github</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="text-white opacity-50 text-hover-primary fs-5">Tutorials</a>
										<!--end::Link-->
									</div>
									<!--end::Links-->
									<!--begin::Links-->
									<div class="d-flex fw-bold flex-column ms-lg-20">
										<!--begin::Subtitle-->
										<h4 class="fw-bolder text-gray-400 mb-6">Stay Connected</h4>
										<!--end::Subtitle-->
										<!--begin::Link-->
										<a href="#" class="mb-6">
											<img src="assets/media/svg/brand-logos/facebook-4.svg" class="h-20px me-2"
												alt="" />
											<span
												class="text-white opacity-50 text-hover-primary fs-5 mb-6">Facebook</span>
										</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="mb-6">
											<img src="assets/media/svg/brand-logos/github.svg" class="h-20px me-2"
												alt="" />
											<span
												class="text-white opacity-50 text-hover-primary fs-5 mb-6">Github</span>
										</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="mb-6">
											<img src="assets/media/svg/brand-logos/twitter.svg" class="h-20px me-2"
												alt="" />
											<span
												class="text-white opacity-50 text-hover-primary fs-5 mb-6">Twitter</span>
										</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="mb-6">
											<img src="assets/media/svg/brand-logos/dribbble-icon-1.svg"
												class="h-20px me-2" alt="" />
											<span
												class="text-white opacity-50 text-hover-primary fs-5 mb-6">Dribbble</span>
										</a>
										<!--end::Link-->
										<!--begin::Link-->
										<a href="#" class="mb-6">
											<img src="assets/media/svg/brand-logos/instagram-2-1.svg"
												class="h-20px me-2" alt="" />
											<span
												class="text-white opacity-50 text-hover-primary fs-5 mb-6">Instagram</span>
										</a>
										<!--end::Link-->
									</div>
									<!--end::Links-->
								</div>
								<!--end::Navs-->
							</div>
							<!--end::Col-->
						</div>
						<!--end::Row-->
					</div>
					<!--end::Container-->
					<!--begin::Separator-->
					<div class="landing-dark-separator"></div>
					<!--end::Separator-->
					<!--begin::Container-->
					<div class="container">
						<!--begin::Wrapper-->
						<div class="d-flex flex-column flex-md-row flex-stack py-7 py-lg-10">
							<!--begin::Copyright-->
							<div class="d-flex align-items-center order-2 order-md-1">
								<!--begin::Logo-->
								<a href="/">
									<img alt="Logo" src="assets/media/logos/logo-2.svg"
										class="h-15px h-md-20px" />
								</a>
								<!--end::Logo image-->
							</div>
							<!--end::Copyright-->
							<!--begin::Menu-->
							<ul class="menu menu-gray-600 menu-hover-primary fw-bold fs-6 fs-md-5 order-1 mb-5 mb-md-0">
								<li class="menu-item">
									<a href="/" target="_blank"
										class="menu-link px-2">About</a>
								</li>
								<li class="menu-item mx-5">
									<a href="/" target="_blank"
										class="menu-link px-2">Support</a>
								</li>
								<li class="menu-item">
									<a href="/" target="_blank" class="menu-link px-2">Purchase</a>
								</li>
							</ul>
							<!--end::Menu-->
						</div>
						<!--end::Wrapper-->
					</div>
					<!--end::Container-->
				</div>
				<!--end::Wrapper-->
			</div>
			<!--end::Footer Section-->
			<!--begin::Scrolltop-->
			<div id="kt_scrolltop" class="scrolltop" data-kt-scrolltop="true">
				<!--begin::Svg Icon | path: icons/duotone/Navigation/Up-2.svg-->
				<span class="svg-icon">
					<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
						height="24px" viewBox="0 0 24 24" version="1.1">
						<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
							<polygon points="0 0 24 0 24 24 0 24" />
							<rect fill="#000000" opacity="0.5" x="11" y="10" width="2" height="10" rx="1" />
							<path
								d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z"
								fill="#000000" fill-rule="nonzero" />
						</g>
					</svg>
				</span>
				<!--end::Svg Icon-->
			</div>
			<!--end::Scrolltop-->
		</div>
		<!--end::Main-->
		<!--begin::Javascript-->
		<!--begin::Global Javascript Bundle(used by all pages)-->
		<script src="assets/plugins/global/plugins.bundle.js"></script>
		<script src="assets/js/scripts.bundle.js"></script>
		<!--end::Global Javascript Bundle-->
		<!--begin::Page Vendors Javascript(used by this page)-->
		<script src="assets/plugins/custom/fslightbox/fslightbox.bundle.js"></script>
		<script src="assets/plugins/custom/typedjs/typedjs.bundle.js"></script>
		<!--end::Page Vendors Javascript-->
		<!--begin::Page Custom Javascript(used by this page)-->
		<script src="assets/js/custom/landing.js"></script>
		<script src="assets/js/custom/pages/company/pricing.js"></script>
		<!--end::Page Custom Javascript-->
		<!--end::Javascript-->
	</body>
	<!--end::Body-->

	</html>