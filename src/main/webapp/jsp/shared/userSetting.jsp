<%-- 
    Document   : index
    Created on : Sep 17, 2022, 8:24:20 AM
    Author     : ADMIN
--%>
<%@page import="com.tss.model.User"%>
<%@page import="com.tss.model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<base href="/">
	<meta charset="utf-8" />
	<title>Training Support System</title>
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
<body id="kt_body"
	class="header-fixed header-tablet-and-mobile-fixed toolbar-enabled toolbar-fixed toolbar-tablet-and-mobile-fixed aside-enabled aside-fixed"
	style="--kt-toolbar-height:55px;--kt-toolbar-height-tablet-and-mobile:55px">
    <div class="d-flex flex-column flex-root">
		<!--begin::Page-->
		<div class="page d-flex flex-row flex-column-fluid">
			<!--begin::Aside-->
			<jsp:include page="shared/aside.jsp"></jsp:include>
			<!--end::Aside-->
			<!--begin::Wrapper-->
			<div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
				<!--begin::Header-->
				<div id="kt_header" class="header align-items-stretch">
					<!--begin::Container-->
					<div class="container-fluid d-flex align-items-stretch justify-content-between">
						<!--begin::Aside mobile toggle-->
						<div class="d-flex align-items-center d-lg-none ms-n3 me-1" title="Show aside menu">
							<div class="btn btn-icon btn-active-light-primary" id="kt_aside_mobile_toggle">
								<!--begin::Svg Icon | path: icons/duotone/Text/Menu.svg-->
								<span class="svg-icon svg-icon-2x mt-1">
									<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
										width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
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
							</div>
						</div>
						<!--end::Aside mobile toggle-->
						<!--begin::Mobile logo-->
						<div class="d-flex align-items-center flex-grow-1 flex-lg-grow-0">
							<a href="index.html" class="d-lg-none">
								<img alt="Logo" src="assets/media/logos/logo-3.svg" class="h-30px" />
							</a>
						</div>
						<!--end::Mobile logo-->
						<!--begin::Wrapper-->
						<div class="d-flex align-items-stretch justify-content-between flex-lg-grow-1">
							<!--begin::Navbar-->
							<jsp:include page="shared/navbar.jsp"></jsp:include>
							<!--end::Navbar-->
							<!--begin::Topbar-->
							<jsp:include page="shared/topbar.jsp"></jsp:include>
							<!--end::Topbar-->
						</div>
						<!--end::Wrapper-->
					</div>
					<!--end::Container-->
				</div>
				<!--end::Header-->
				<!--begin::Content-->
				<div class="content d-flex flex-column flex-column-fluid" id="kt_content">
					<!--begin::Toolbar-->
					<div class="toolbar" id="kt_toolbar">
						<!--begin::Container-->
						<div id="kt_toolbar_container" class="container-fluid d-flex flex-stack">
							<!--begin::Page title-->
							<jsp:include page="shared/page-title.jsp"></jsp:include>
							<!--end::Page title-->
							<!--begin::Actions-->

							<!--end::Actions-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Toolbar-->
					<!--begin::Post-->

					 <div class="content d-flex flex-column flex-column-fluid" id="kt_content">

                            <div class="post d-flex flex-column-fluid" id="kt_post">

                                <!--begin::Container-->
                                <div id="kt_content_container" class="container">
                                 
                                    <span class="bullet bg-gray-200 w-5px h-2px"></span>
                                    <!--begin::Navbar-->
                                    <div class="card mb-5 mb-xxl-8">
                                        <div class="card-body pt-9 pb-0">
                                            <!--begin::Details-->
                                            <div class="d-flex flex-wrap flex-sm-nowrap mb-3">
                                                <!--begin: Pic-->
                                                <div class="me-7 mb-4">
                                                      <% if (request.getAttribute("user") != null) {
                                                    User user = (User)request.getAttribute("user");
                                                       %>
                                                    <div class="symbol symbol-100px symbol-lg-160px symbol-fixed position-relative">
                                                        <img src=<%=user.getAvatarUrl()%> alt="image">
                                                        <div class="position-absolute translate-middle bottom-0 start-100 mb-6 bg-success rounded-circle border border-4 border-white h-20px w-20px"></div>
                                                    </div>
                                                </div>
                                                <!--end::Pic-->
                                                <!--begin::Info-->
                                                <div class="flex-grow-1">
                                                    <!--begin::Title-->
                                                    <div class="d-flex justify-content-between align-items-start flex-wrap mb-2">
                                                        <!--begin::User-->
                                                        <div class="d-flex flex-column">
                                                            <!--begin::Name-->
                                                            <div class="d-flex align-items-center mb-2">
                                                                <a href="#" class="text-gray-800 text-hover-primary fs-2 fw-bolder me-1">Max Smith</a>
                                                                <a href="#">
                                                                    <!--begin::Svg Icon | path: icons/duotone/Design/Verified.svg-->
                                                                    <span class="svg-icon svg-icon-1 svg-icon-primary">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                        <path d="M10.0813 3.7242C10.8849 2.16438 13.1151 2.16438 13.9187 3.7242V3.7242C14.4016 4.66147 15.4909 5.1127 16.4951 4.79139V4.79139C18.1663 4.25668 19.7433 5.83365 19.2086 7.50485V7.50485C18.8873 8.50905 19.3385 9.59842 20.2758 10.0813V10.0813C21.8356 10.8849 21.8356 13.1151 20.2758 13.9187V13.9187C19.3385 14.4016 18.8873 15.491 19.2086 16.4951V16.4951C19.7433 18.1663 18.1663 19.7433 16.4951 19.2086V19.2086C15.491 18.8873 14.4016 19.3385 13.9187 20.2758V20.2758C13.1151 21.8356 10.8849 21.8356 10.0813 20.2758V20.2758C9.59842 19.3385 8.50905 18.8873 7.50485 19.2086V19.2086C5.83365 19.7433 4.25668 18.1663 4.79139 16.4951V16.4951C5.1127 15.491 4.66147 14.4016 3.7242 13.9187V13.9187C2.16438 13.1151 2.16438 10.8849 3.7242 10.0813V10.0813C4.66147 9.59842 5.1127 8.50905 4.79139 7.50485V7.50485C4.25668 5.83365 5.83365 4.25668 7.50485 4.79139V4.79139C8.50905 5.1127 9.59842 4.66147 10.0813 3.7242V3.7242Z" fill="#00A3FF"></path>
                                                                        <path class="permanent" d="M14.8563 9.1903C15.0606 8.94984 15.3771 8.9385 15.6175 9.14289C15.858 9.34728 15.8229 9.66433 15.6185 9.9048L11.863 14.6558C11.6554 14.9001 11.2876 14.9258 11.048 14.7128L8.47656 12.4271C8.24068 12.2174 8.21944 11.8563 8.42911 11.6204C8.63877 11.3845 8.99996 11.3633 9.23583 11.5729L11.3706 13.4705L14.8563 9.1903Z" fill="white"></path>
                                                                        </svg>
                                                                    </span>
                                                                    <!--end::Svg Icon-->
                                                                </a>
                                                            </div>
                                                            <!--end::Name-->
                                                            <!--begin::Info-->
                                                            <div class="d-flex flex-wrap fw-bold fs-6 mb-4 pe-2">
                                                                <a href="#" class="d-flex align-items-center text-gray-400 text-hover-primary me-5 mb-2">
                                                                    <!--begin::Svg Icon | path: icons/duotone/General/User.svg-->
                                                                    <span class="svg-icon svg-icon-4 me-1">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                        <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                                        <path d="M12,11 C9.790861,11 8,9.209139 8,7 C8,4.790861 9.790861,3 12,3 C14.209139,3 16,4.790861 16,7 C16,9.209139 14.209139,11 12,11 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
                                                                        <path d="M3.00065168,20.1992055 C3.38825852,15.4265159 7.26191235,13 11.9833413,13 C16.7712164,13 20.7048837,15.2931929 20.9979143,20.2 C21.0095879,20.3954741 20.9979143,21 20.2466999,21 C16.541124,21 11.0347247,21 3.72750223,21 C3.47671215,21 2.97953825,20.45918 3.00065168,20.1992055 Z" fill="#000000" fill-rule="nonzero"></path>
                                                                        </g>
                                                                        </svg>
                                                                    </span>
                                                                    <!--end::Svg Icon-->Developer</a>
                                                                <a href="#" class="d-flex align-items-center text-gray-400 text-hover-primary me-5 mb-2">
                                                                    <!--begin::Svg Icon | path: icons/duotone/Map/Marker1.svg-->
                                                                    <span class="svg-icon svg-icon-4 me-1">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                        <rect x="0" y="0" width="24" height="24"></rect>
                                                                        <path d="M5,10.5 C5,6 8,3 12.5,3 C17,3 20,6.75 20,10.5 C20,12.8325623 17.8236613,16.03566 13.470984,20.1092932 C12.9154018,20.6292577 12.0585054,20.6508331 11.4774555,20.1594925 C7.15915182,16.5078313 5,13.2880005 5,10.5 Z M12.5,12 C13.8807119,12 15,10.8807119 15,9.5 C15,8.11928813 13.8807119,7 12.5,7 C11.1192881,7 10,8.11928813 10,9.5 C10,10.8807119 11.1192881,12 12.5,12 Z" fill="#000000" fill-rule="nonzero"></path>
                                                                        </g>
                                                                        </svg>
                                                                    </span>
                                                                    <!--end::Svg Icon-->SF, Bay Area</a>
                                                                <a href="#" class="d-flex align-items-center text-gray-400 text-hover-primary mb-2">
                                                                    <!--begin::Svg Icon | path: icons/duotone/Communication/Mail-at.svg-->
                                                                    <span class="svg-icon svg-icon-4 me-1">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                        <path d="M11.575,21.2 C6.175,21.2 2.85,17.4 2.85,12.575 C2.85,6.875 7.375,3.05 12.525,3.05 C17.45,3.05 21.125,6.075 21.125,10.85 C21.125,15.2 18.825,16.925 16.525,16.925 C15.4,16.925 14.475,16.4 14.075,15.65 C13.3,16.4 12.125,16.875 11,16.875 C8.25,16.875 6.85,14.925 6.85,12.575 C6.85,9.55 9.05,7.1 12.275,7.1 C13.2,7.1 13.95,7.35 14.525,7.775 L14.625,7.35 L17,7.35 L15.825,12.85 C15.6,13.95 15.85,14.825 16.925,14.825 C18.25,14.825 19.025,13.725 19.025,10.8 C19.025,6.9 15.95,5.075 12.5,5.075 C8.625,5.075 5.05,7.75 5.05,12.575 C5.05,16.525 7.575,19.1 11.575,19.1 C13.075,19.1 14.625,18.775 15.975,18.075 L16.8,20.1 C15.25,20.8 13.2,21.2 11.575,21.2 Z M11.4,14.525 C12.05,14.525 12.7,14.35 13.225,13.825 L14.025,10.125 C13.575,9.65 12.925,9.425 12.3,9.425 C10.65,9.425 9.45,10.7 9.45,12.375 C9.45,13.675 10.075,14.525 11.4,14.525 Z" fill="#000000"></path>
                                                                        </svg>
                                                                    </span>
                                                                    <!--end::Svg Icon-->max@kt.com</a>
                                                            </div>
                                                            <!--end::Info-->
                                                        </div>
                                                        <!--end::User-->
                                                        <!--begin::Actions-->
                                                        <div class="d-flex my-4">
                                                            <a href="#" class="btn btn-sm btn-light me-2" id="kt_user_follow_button">
                                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Double-check.svg-->
                                                                <span class="svg-icon svg-icon-3 d-none">
                                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                    <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                                    <path d="M9.26193932,16.6476484 C8.90425297,17.0684559 8.27315905,17.1196257 7.85235158,16.7619393 C7.43154411,16.404253 7.38037434,15.773159 7.73806068,15.3523516 L16.2380607,5.35235158 C16.6013618,4.92493855 17.2451015,4.87991302 17.6643638,5.25259068 L22.1643638,9.25259068 C22.5771466,9.6195087 22.6143273,10.2515811 22.2474093,10.6643638 C21.8804913,11.0771466 21.2484189,11.1143273 20.8356362,10.7474093 L17.0997854,7.42665306 L9.26193932,16.6476484 Z" fill="#000000" fill-rule="nonzero" opacity="0.5" transform="translate(14.999995, 11.000002) rotate(-180.000000) translate(-14.999995, -11.000002)"></path>
                                                                    <path d="M4.26193932,17.6476484 C3.90425297,18.0684559 3.27315905,18.1196257 2.85235158,17.7619393 C2.43154411,17.404253 2.38037434,16.773159 2.73806068,16.3523516 L11.2380607,6.35235158 C11.6013618,5.92493855 12.2451015,5.87991302 12.6643638,6.25259068 L17.1643638,10.2525907 C17.5771466,10.6195087 17.6143273,11.2515811 17.2474093,11.6643638 C16.8804913,12.0771466 16.2484189,12.1143273 15.8356362,11.7474093 L12.0997854,8.42665306 L4.26193932,17.6476484 Z" fill="#000000" fill-rule="nonzero" transform="translate(9.999995, 12.000002) rotate(-180.000000) translate(-9.999995, -12.000002)"></path>
                                                                    </g>
                                                                    </svg>
                                                                </span>
                                                                <!--end::Svg Icon-->
                                                                <!--begin::Indicator-->
                                                                <span class="indicator-label">Follow</span>
                                                                <span class="indicator-progress">Please wait...
                                                                    <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                                                <!--end::Indicator-->
                                                            </a>
                                                            <a href="#" class="btn btn-sm btn-primary me-3" data-bs-toggle="modal" data-bs-target="#kt_modal_offer_a_deal">Hire Me</a>
                                                            <!--begin::Menu-->
                                                            <div class="me-0">
                                                                <button class="btn btn-sm btn-icon btn-bg-light btn-active-color-primary" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">
                                                                    <i class="bi bi-three-dots fs-3"></i>
                                                                </button>
                                                                <!--begin::Menu 3-->
                                                                <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg-light-primary fw-bold w-200px py-3" data-kt-menu="true">
                                                                    <!--begin::Heading-->
                                                                    <div class="menu-item px-3">
                                                                        <div class="menu-content text-muted pb-2 px-3 fs-7 text-uppercase">Payments</div>
                                                                    </div>
                                                                    <!--end::Heading-->
                                                                    <!--begin::Menu item-->
                                                                    <div class="menu-item px-3">
                                                                        <a href="#" class="menu-link px-3">Create Invoice</a>
                                                                    </div>
                                                                    <!--end::Menu item-->
                                                                    <!--begin::Menu item-->
                                                                    <div class="menu-item px-3">
                                                                        <a href="#" class="menu-link flex-stack px-3">Create Payment
                                                                            <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip" title="" data-bs-original-title="Specify a target name for future usage and reference" aria-label="Specify a target name for future usage and reference"></i></a>
                                                                    </div>
                                                                    <!--end::Menu item-->
                                                                    <!--begin::Menu item-->
                                                                    <div class="menu-item px-3">
                                                                        <a href="#" class="menu-link px-3">Generate Bill</a>
                                                                    </div>
                                                                    <!--end::Menu item-->
                                                                    <!--begin::Menu item-->
                                                                    <div class="menu-item px-3" data-kt-menu-trigger="hover" data-kt-menu-placement="left-start" data-kt-menu-flip="center, top">
                                                                        <a href="#" class="menu-link px-3">
                                                                            <span class="menu-title">Subscription</span>
                                                                            <span class="menu-arrow"></span>
                                                                        </a>
                                                                        <!--begin::Menu sub-->
                                                                        <div class="menu-sub menu-sub-dropdown w-175px py-4">
                                                                            <!--begin::Menu item-->
                                                                            <div class="menu-item px-3">
                                                                                <a href="#" class="menu-link px-3">Plans</a>
                                                                            </div>
                                                                            <!--end::Menu item-->
                                                                            <!--begin::Menu item-->
                                                                            <div class="menu-item px-3">
                                                                                <a href="#" class="menu-link px-3">Billing</a>
                                                                            </div>
                                                                            <!--end::Menu item-->
                                                                            <!--begin::Menu item-->
                                                                            <div class="menu-item px-3">
                                                                                <a href="#" class="menu-link px-3">Statements</a>
                                                                            </div>
                                                                            <!--end::Menu item-->
                                                                            <!--begin::Menu separator-->
                                                                            <div class="separator my-2"></div>
                                                                            <!--end::Menu separator-->
                                                                            <!--begin::Menu item-->
                                                                            <div class="menu-item px-3">
                                                                                <div class="menu-content px-3">
                                                                                    <!--begin::Switch-->
                                                                                    <label class="form-check form-switch form-check-custom form-check-solid">
                                                                                        <!--begin::Input-->
                                                                                        <input class="form-check-input w-30px h-20px" type="checkbox" value="1" checked="checked" name="notifications">
                                                                                        <!--end::Input-->
                                                                                        <!--end::Label-->
                                                                                        <span class="form-check-label text-muted fs-6">Recuring</span>
                                                                                        <!--end::Label-->
                                                                                    </label>
                                                                                    <!--end::Switch-->
                                                                                </div>
                                                                            </div>
                                                                            <!--end::Menu item-->
                                                                        </div>
                                                                        <!--end::Menu sub-->
                                                                    </div>
                                                                    <!--end::Menu item-->
                                                                    <!--begin::Menu item-->
                                                                    <div class="menu-item px-3 my-1">
                                                                        <a href="#" class="menu-link px-3">Settings</a>
                                                                    </div>
                                                                    <!--end::Menu item-->
                                                                </div>
                                                                <!--end::Menu 3-->
                                                            </div>
                                                            <!--end::Menu-->
                                                        </div>
                                                        <!--end::Actions-->
                                                    </div>
                                                    <!--end::Title-->
                                                    <!--begin::Stats-->
                                                    <div class="d-flex flex-wrap flex-stack">
                                                        <!--begin::Wrapper-->
                                                        <div class="d-flex flex-column flex-grow-1 pe-8">
                                                            <!--begin::Stats-->
                                                            <div class="d-flex flex-wrap">
                                                                <!--begin::Stat-->
                                                                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                                                    <!--begin::Number-->
                                                                    <div class="d-flex align-items-center">
                                                                        <!--begin::Svg Icon | path: icons/duotone/Navigation/Arrow-up.svg-->
                                                                        <span class="svg-icon svg-icon-3 svg-icon-success me-2">
                                                                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                            <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                                            <rect fill="#000000" opacity="0.5" x="11" y="5" width="2" height="14" rx="1"></rect>
                                                                            <path d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z" fill="#000000" fill-rule="nonzero"></path>
                                                                            </g>
                                                                            </svg>
                                                                        </span>
                                                                        <!--end::Svg Icon-->
                                                                        <div class="fs-2 fw-bolder counted" data-kt-countup="true" data-kt-countup-value="4500" data-kt-countup-prefix="$">$4,500</div>
                                                                    </div>
                                                                    <!--end::Number-->
                                                                    <!--begin::Label-->
                                                                    <div class="fw-bold fs-6 text-gray-400">Earnings</div>
                                                                    <!--end::Label-->
                                                                </div>
                                                                <!--end::Stat-->
                                                                <!--begin::Stat-->
                                                                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                                                    <!--begin::Number-->
                                                                    <div class="d-flex align-items-center">
                                                                        <!--begin::Svg Icon | path: icons/duotone/Navigation/Arrow-down.svg-->
                                                                        <span class="svg-icon svg-icon-3 svg-icon-danger me-2">
                                                                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                            <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                                            <rect fill="#000000" opacity="0.5" x="11" y="5" width="2" height="14" rx="1"></rect>
                                                                            <path d="M6.70710678,18.7071068 C6.31658249,19.0976311 5.68341751,19.0976311 5.29289322,18.7071068 C4.90236893,18.3165825 4.90236893,17.6834175 5.29289322,17.2928932 L11.2928932,11.2928932 C11.6714722,10.9143143 12.2810586,10.9010687 12.6757246,11.2628459 L18.6757246,16.7628459 C19.0828436,17.1360383 19.1103465,17.7686056 18.7371541,18.1757246 C18.3639617,18.5828436 17.7313944,18.6103465 17.3242754,18.2371541 L12.0300757,13.3841378 L6.70710678,18.7071068 Z" fill="#000000" fill-rule="nonzero" transform="translate(12.000003, 14.999999) scale(1, -1) translate(-12.000003, -14.999999)"></path>
                                                                            </g>
                                                                            </svg>
                                                                        </span>
                                                                        <!--end::Svg Icon-->
                                                                        <div class="fs-2 fw-bolder counted" data-kt-countup="true" data-kt-countup-value="75">75</div>
                                                                    </div>
                                                                    <!--end::Number-->
                                                                    <!--begin::Label-->
                                                                    <div class="fw-bold fs-6 text-gray-400">Projects</div>
                                                                    <!--end::Label-->
                                                                </div>
                                                                <!--end::Stat-->
                                                                <!--begin::Stat-->
                                                                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                                                    <!--begin::Number-->
                                                                    <div class="d-flex align-items-center">
                                                                        <!--begin::Svg Icon | path: icons/duotone/Navigation/Arrow-up.svg-->
                                                                        <span class="svg-icon svg-icon-3 svg-icon-success me-2">
                                                                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                            <polygon points="0 0 24 0 24 24 0 24"></polygon>
                                                                            <rect fill="#000000" opacity="0.5" x="11" y="5" width="2" height="14" rx="1"></rect>
                                                                            <path d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z" fill="#000000" fill-rule="nonzero"></path>
                                                                            </g>
                                                                            </svg>
                                                                        </span>
                                                                        <!--end::Svg Icon-->
                                                                        <div class="fs-2 fw-bolder counted" data-kt-countup="true" data-kt-countup-value="60" data-kt-countup-prefix="%">%60</div>
                                                                    </div>
                                                                    <!--end::Number-->
                                                                    <!--begin::Label-->
                                                                    <div class="fw-bold fs-6 text-gray-400">Success Rate</div>
                                                                    <!--end::Label-->
                                                                </div>
                                                                <!--end::Stat-->
                                                            </div>
                                                            <!--end::Stats-->
                                                        </div>
                                                        <!--end::Wrapper-->
                                                        <!--begin::Progress-->
                                                        <div class="d-flex align-items-center w-200px w-sm-300px flex-column mt-3">
                                                            <div class="d-flex justify-content-between w-100 mt-auto mb-2">
                                                                <span class="fw-bold fs-6 text-gray-400">Profile Compleation</span>
                                                                <span class="fw-bolder fs-6">50%</span>
                                                            </div>
                                                            <div class="h-5px mx-3 w-100 bg-light mb-3">
                                                                <div class="bg-success rounded h-5px" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </div>
                                                        <!--end::Progress-->
                                                    </div>
                                                    <!--end::Stats-->
                                                </div>
                                                <!--end::Info-->
                                            </div>
                                            <!--end::Details-->
                                            <!--begin::Navs-->
                                            <div class="d-flex overflow-auto h-55px">
                                                <ul class="nav nav-stretch nav-line-tabs nav-line-tabs-2x border-transparent fs-5 fw-bolder flex-nowrap">
                                                    <!--begin::Nav item-->
                                                    <li class="nav-item">
                                                        <a class="nav-link text-active-primary me-6 active" href="userProfile.jsp">Overview</a>
                                                    </li>
                                                    <!--end::Nav item-->
                                                    <!--begin::Nav item-->
                                                    <li class="nav-item">
                                                        <a class="nav-link text-active-primary me-6" href="userSettings.jsp">Settings</a>
                                                    </li>
                                                    <!--end::Nav item-->
                                                </ul>
                                            </div>
                                            <!--begin::Navs-->
                                        </div>
                                    </div>
                                    <!--end::Navbar-->
                                      <div class="card mb-5 mb-xl-10">
                                        <!--begin::Card header-->
                                        <div class="card-header border-0 cursor-pointer" role="button" data-bs-toggle="collapse" data-bs-target="#kt_account_profile_details" aria-expanded="true" aria-controls="kt_account_profile_details">
                                            <!--begin::Card title-->
                                            <div class="card-title m-0">
                                                <h3 class="fw-bolder m-0">Profile Details</h3>
                                            </div>
                                            <!--end::Card title-->
                                        </div>
                                        <!--begin::Card header-->
                                        <!--begin::Content-->
                                        <div id="kt_account_profile_details" class="collapse show">
                                            <!--begin::Form-->
                                            <form id="kt_account_profile_details_form" class="form fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate" action="profile?id=2" method="post">
                                                <!--begin::Card body-->
                                                <div class="card-body border-top p-9">
                                                    <!--begin::Input group-->
                                                    <div class="row mb-6">
                                                        <!--begin::Label-->
                                                        <label class="col-lg-4 col-form-label fw-bold fs-6">Avatar</label>
                                                        <!--end::Label-->
                                                        <!--begin::Col-->
                                                        <div class="col-lg-8">
                                                            <!--begin::Image input-->
                                                            <div class="image-input image-input-outline" data-kt-image-input="true" style="background-image: url(assets/media/avatars/blank.png)">
                                                                <!--begin::Preview existing avatar-->
                                                                <div name= "avatar" class="image-input-wrapper w-125px h-125px" style="background-image: url(<%=user.getAvatarUrl()%>)"></div>
                                                                <!--end::Preview existing avatar-->
                                                                <!--begin::Label-->
                                                                <label class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-white shadow" data-kt-image-input-action="change" data-bs-toggle="tooltip" title="" data-bs-original-title="Change avatar">
                                                                    <i class="bi bi-pencil-fill fs-7"></i>
                                                                    <!--begin::Inputs-->
                                                                    <input type="file" name="avatar" accept=".png, .jpg, .jpeg">
                                                                    <input type="hidden" name="avatar_remove">
                                                                    <!--end::Inputs-->
                                                                </label>
                                                                <!--end::Label-->
                                                                <!--begin::Cancel-->
                                                                <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-white shadow" data-kt-image-input-action="cancel" data-bs-toggle="tooltip" title="" data-bs-original-title="Cancel avatar">
                                                                    <i class="bi bi-x fs-2"></i>
                                                                </span>
                                                                <!--end::Cancel-->
                                                                <!--begin::Remove-->
                                                                <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-white shadow" data-kt-image-input-action="remove" data-bs-toggle="tooltip" title="" data-bs-original-title="Remove avatar">
                                                                    <i class="bi bi-x fs-2"></i>
                                                                </span>
                                                                <!--end::Remove-->
                                                            </div>
                                                            <!--end::Image input-->
                                                            <!--begin::Hint-->
                                                            <div class="form-text">Allowed file types: png, jpg, jpeg.</div>
                                                            <!--end::Hint-->
                                                        </div>
                                                        <!--end::Col-->
                                                    </div>
                                                    <!--end::Input group-->
                                                    <!--begin::Input group-->
                                                    <div class="row mb-6">
                                                        <!--begin::Label-->
                                                        <label class="col-lg-4 col-form-label required fw-bold fs-6">Full Name</label>
                                                        <!--end::Label-->
                                                        <!--begin::Col-->
                                                        <div class="col-lg-8 fv-row fv-plugins-icon-container">
                                                            <!--begin::Row-->
                                                           
                                                                    <input type="text" name="fullName" class="form-control form-control-lg form-control-solid mb-3 mb-lg-0" placeholder="First name" value="<%=user.getFullname()%>">
                                                                    <div class="fv-plugins-message-container invalid-feedback"></div>
                                                                <!--end::Col-->
                                                               
                                                            
                                                            <!--end::Row-->
                                                        </div>
                                                        <!--end::Col-->
                                                    </div>
                                                    <!--end::Input group-->
                                                    <!--begin::Input group-->
<!--                                                    <div class="row mb-6">
                                                        begin::Label
                                                        <label class="col-lg-4 col-form-label required fw-bold fs-6">Company</label>
                                                        end::Label
                                                        begin::Col
                                                        <div class="col-lg-8 fv-row fv-plugins-icon-container">
                                                            <input type="text" name="company" class="form-control form-control-lg form-control-solid" placeholder="Company name" value="Keenthemes">
                                                            <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                        end::Col
                                                    </div>-->
                                                    <!--end::Input group-->
                                                   
                                                 <!--begin::Input group-->
                                                    <div class="row mb-6">
                                                        <label class="col-lg-4 col-form-label required fw-bold fs-6">Phone</label>
                                                        <div class="col-lg-8 fv-row fv-plugins-icon-container">
                                                            <input type="text" name="mobile" class="form-control form-control-lg form-control-solid" placeholder="Phone" value="<%=user.getMobile()%>">
                                                            <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                    </div>
                                                    <!--end::Input group-->
                                                       <!--begin::Input group-->
                                                    <div class="row mb-6">
                                                        <!--begin::Label-->
                                                        <label class="col-lg-4 col-form-label required fw-bold fs-6">Email</label>
                                                        <!--end::Label-->
                                                        <!--begin::Col-->
                                                        <div class="col-lg-8 fv-row fv-plugins-icon-container">
                                                            <input type="email" name="email" class="form-control form-control-lg form-control-solid" placeholder="Email" value="<%=user.getEmail()%>">
                                                            <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                        <!--end::Col-->
                                                    </div>
                                                    <!--end::Input group-->
                                                     <!--begin::Input group-->
<!--                                                    <div class="row mb-6">
                                                        begin::Label
                                                        <label class="col-lg-4 col-form-label required fw-bold fs-6">Address</label>
                                                        end::Label
                                                        begin::Col
                                                        <div class="col-lg-8 fv-row fv-plugins-icon-container">
                                                            <input type="text" name="address" class="form-control form-control-lg form-control-solid" placeholder="Address" value="Ha Noi, Viet Nam">
                                                            <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                        end::Col
                                                    </div>-->
                                                     <%
                                                     }
                                                     %>
                                                    <!--end::Input group-->
                                                </div>
                                                <!--end::Card body-->
                                                <!--begin::Actions-->
                                                <div class="card-footer d-flex justify-content-end py-6 px-9">
                                                    <button type="reset" class="btn btn-white btn-active-light-primary me-2">Discard</button>
                                                    <button type="submit" class="btn btn-primary" id="kt_account_profile_details_submit">Save Changes</button>
                                                </div>
                                                <!--end::Actions-->
                                                <input type="hidden"><div></div></form>
                                            <!--end::Form-->
                                        </div>
                                        <!--end::Content-->
                                    </div>
                                    <div class="card mb-5 mb-xl-10">
                                        <!--begin::Card header-->
                                        <div class="card-header border-0 cursor-pointer" role="button" data-bs-toggle="collapse" data-bs-target="#kt_account_signin_method">
                                            <div class="card-title m-0">
                                                <h3 class="fw-bolder m-0">Sign-in Method</h3>
                                            </div>
                                        </div>
                                        <!--end::Card header-->
                                        <!--begin::Content-->
                                        <div id="kt_account_signin_method" class="collapse show">
                                            <!--begin::Card body-->
                                            <div class="card-body border-top p-9">
                                                <!--begin::Email Address-->
                                                <div class="d-flex flex-wrap align-items-center">
                                                    <!--begin::Label-->
                                                    <div id="kt_signin_email">
                                                        <div class="fs-6 fw-bolder mb-1">Email Address</div>
                                                        <div class="fw-bold text-gray-600">support@keenthemes.com</div>
                                                    </div>
                                                    <!--end::Label-->
                                                    <!--begin::Edit-->
                                                    <div id="kt_signin_email_edit" class="flex-row-fluid d-none">
                                                        <!--begin::Form-->
                                                        <form id="kt_signin_change_email" class="form fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate">
                                                            <div class="row mb-6">
                                                                <div class="col-lg-6 mb-4 mb-lg-0">
                                                                    <div class="fv-row mb-0 fv-plugins-icon-container">
                                                                        <label for="emailaddress" class="form-label fs-6 fw-bolder mb-3">Enter New Email Address</label>
                                                                        <input type="email" class="form-control form-control-lg form-control-solid" id="emailaddress" placeholder="Email Address" name="emailaddress" value="support@keenthemes.com">
                                                                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                                </div>
                                                                <div class="col-lg-6">
                                                                    <div class="fv-row mb-0 fv-plugins-icon-container">
                                                                        <label for="confirmemailpassword" class="form-label fs-6 fw-bolder mb-3">Confirm Password</label>
                                                                        <input type="password" class="form-control form-control-lg form-control-solid" name="confirmemailpassword" id="confirmemailpassword">
                                                                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                                </div>
                                                            </div>
                                                            <div class="d-flex">
                                                                <button id="kt_signin_submit" type="button" class="btn btn-primary me-2 px-6">Update Email</button>
                                                                <button id="kt_signin_cancel" type="button" class="btn btn-color-gray-400 btn-active-light-primary px-6">Cancel</button>
                                                            </div>
                                                            <div></div></form>
                                                        <!--end::Form-->
                                                    </div>
                                                    <!--end::Edit-->
                                                    <!--begin::Action-->
                                                    <div id="kt_signin_email_button" class="ms-auto">
                                                        <button class="btn btn-light btn-active-light-primary">Change Email</button>
                                                    </div>
                                                    <!--end::Action-->
                                                </div>
                                                <!--end::Email Address-->
                                                <!--begin::Separator-->
                                                <div class="separator separator-dashed my-6"></div>
                                                <!--end::Separator-->
                                                <!--begin::Password-->
                                                <div class="d-flex flex-wrap align-items-center mb-10">
                                                    <!--begin::Label-->
                                                    <div id="kt_signin_password">
                                                        <div class="fs-6 fw-bolder mb-1">Password</div>
                                                        <div class="fw-bold text-gray-600">************</div>
                                                    </div>
                                                    <!--end::Label-->
                                                    <!--begin::Edit-->
                                                    <div id="kt_signin_password_edit" class="flex-row-fluid d-none">
                                                        <!--begin::Form-->
                                                        <form id="kt_signin_change_password" class="form fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate">
                                                            <div class="row mb-1">
                                                                <div class="col-lg-4">
                                                                    <div class="fv-row mb-0 fv-plugins-icon-container">
                                                                        <label for="currentpassword" class="form-label fs-6 fw-bolder mb-3">Current Password</label>
                                                                        <input type="password" class="form-control form-control-lg form-control-solid" name="currentpassword" id="currentpassword">
                                                                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                                </div>
                                                                <div class="col-lg-4">
                                                                    <div class="fv-row mb-0 fv-plugins-icon-container">
                                                                        <label for="newpassword" class="form-label fs-6 fw-bolder mb-3">New Password</label>
                                                                        <input type="password" class="form-control form-control-lg form-control-solid" name="newpassword" id="newpassword">
                                                                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                                </div>
                                                                <div class="col-lg-4">
                                                                    <div class="fv-row mb-0 fv-plugins-icon-container">
                                                                        <label for="confirmpassword" class="form-label fs-6 fw-bolder mb-3">Confirm New Password</label>
                                                                        <input type="password" class="form-control form-control-lg form-control-solid" name="confirmpassword" id="confirmpassword">
                                                                        <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-text mb-5">Password must be at least 8 character and contain symbols</div>
                                                            <div class="d-flex">
                                                                <button id="kt_password_submit" type="button" class="btn btn-primary me-2 px-6">Update Password</button>
                                                                <button id="kt_password_cancel" type="button" class="btn btn-color-gray-400 btn-active-light-primary px-6">Cancel</button>
                                                            </div>
                                                            <div></div></form>
                                                        <!--end::Form-->
                                                    </div>
                                                    <!--end::Edit-->
                                                    <!--begin::Action-->
                                                    <div id="kt_signin_password_button" class="ms-auto">
                                                        <button class="btn btn-light btn-active-light-primary">Reset Password</button>
                                                    </div>
                                                    <!--end::Action-->
                                                </div>
                                                <!--end::Password-->
                                            </div>
                                            <!--end::Card body-->
                                        </div>
                                        <!--end::Content-->
                                    </div>
                                </div>
                                <!--end::Container-->
                            </div>
                        </div>
					<!--end::Post-->
				</div>
				<!--end::Content-->
				<!--begin::Footer-->
				<jsp:include page="shared/footer.jsp"></jsp:include>
				<!--end::Footer-->
			</div>
			<!--end::Wrapper-->
		</div>
		<!--end::Page-->
	</div>
	<!--end::Root-->
	<!--begin::Modals-->
	<jsp:include page="modal.jsp"></jsp:include>
	<!--end::Modals-->
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
        <!--begin::Javascript-->
        <!--begin::Global Javascript Bundle(used by all pages)-->
        <script src="assets/plugins/global/plugins.bundle.js"></script>
        <script src="assets/js/scripts.bundle.js"></script>
        <!--end::Global Javascript Bundle-->
        <!--begin::Page Custom Javascript(used by this page)-->
        <script src="assets/js/custom/widgets.js"></script>
        <script src="assets/js/custom/apps/chat/chat.js"></script>
        <script src="assets/js/custom/modals/create-app.js"></script>
        <script src="assets/js/custom/modals/upgrade-plan.js"></script>
        <!--end::Page Custom Javascript-->
        <!--end::Javascript-->
    </body>
</html>