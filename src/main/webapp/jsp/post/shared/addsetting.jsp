<%-- 
    Document   : addsetting
    Created on : Sep 23, 2022, 4:48:51 PM
    Author     : msi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
    <!--begin::Body-->
    <body id="kt_body"
          class="header-fixed header-tablet-and-mobile-fixed toolbar-enabled toolbar-fixed toolbar-tablet-and-mobile-fixed aside-enabled aside-fixed"
          style="--kt-toolbar-height:55px;--kt-toolbar-height-tablet-and-mobile:55px">
        <!--begin::Main-->
        <!--begin::Root-->
        <div class="d-flex flex-column flex-root">
            <!--begin::Page-->
            <div class="page d-flex flex-row flex-column-fluid">
                <!--begin::Aside-->
                <jsp:include page="/jsp/shared/aside.jsp"></jsp:include>
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
                                <jsp:include page="/jsp/shared/navbar.jsp"></jsp:include>
                                    <!--end::Navbar-->
                                    <!--begin::Topbar-->
                                <jsp:include page="/jsp/shared/topbar.jsp"></jsp:include>
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
                                <jsp:include page="/jsp/shared/page-title.jsp"></jsp:include>
                                    <!--end::Page title-->
                                </div>
                                <!--end::Container-->
                            </div>
                            <!--end::Toolbar-->
                            <!--begin::Post-->
                            <!--begin::details View-->
                            <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
                                <!--begin::Card header-->
                                <div class="card-header cursor-pointer">
                                    <!--begin::Card title-->
                                    <div class="card-title m-0">
                                        <h3 class="fw-bolder m-0">Setting Details</h3>
                                    </div>
                                    <!--end::Card title-->
                                    <!--begin::Action-->
                                    <!--end::Action-->
                                </div>
                                <!--begin::Card header-->
                                <!--begin::Card body-->
                                <div class="card-body p-9">
                                    <!--begin::Row-->
                                    <!--end::Row-->
                                    <form action="/setting/system">
                                        <input type="hidden" name="action" value="create">
                                        <div class="col-xl-10">
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">ID</label>
                                                <input class="form-control form-control-lg form-control-solid" placeholder="Enter setting id" type="number"  name="setting_id" required value="" min="1">
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>

                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Type</label>
                                                <input class="form-control form-control-lg form-control-solid" type="number" placeholder="Enter type id" name="type_id" required value="">
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Title</label>
                                                <input class="form-control form-control-lg form-control-solid" type="text" placeholder="Enter setting title" name="title" required value="">
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Value</label>
                                                <input class="form-control form-control-lg form-control-solid" type="text"  name="value" placeholder="Enter setting value" autocomplete="off" value="">
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Display order</label>
                                                <input class="form-control form-control-lg form-control-solid" type="text"  name="display_order" placeholder="Enter display order" autocomplete="off" value="">
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Status</label><br>
                                                <input class="form-check-input" type="radio" id="html" name="status" value="0">
                                                <label for="0" class="form-label fw-bolder text-dark fs-6">Inactive</label>
                                                <input class="form-check-input" type="radio" id="css" name="status" value="1"  checked="true">
                                                <label for="1" class="form-label fw-bolder text-dark fs-6">Active</label>


                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                            <div class="col-xl-10">
                                                <label class="form-label fw-bolder text-dark fs-6">Description</label>
                                                <textarea class="form-control form-control-lg form-control-solid" name="description" placeholder="Enter description" autocomplete="off"></textarea>
                                                <div class="fv-plugins-message-container invalid-feedback"></div></div>
                                                <p style="color: red">${error}</p>
                                            <a class="btn btn-bg-danger" href="/setting/system">Cancel</a>
                                            <button type="submit" class="btn btn-primary">Create setting</button>
                                        </div>
                                    </form>


                                    <!--end::Card body-->
                                </div>
                                <!--end::details View-->
                                <!--end::Post-->
                                <!--begin::Footer-->
                            <jsp:include page="/jsp/shared/footer.jsp"></jsp:include>
                                <!--end::Footer-->
                            </div>
                            <!--end::Wrapper-->
                        </div>
                        <!--end::Page-->
                    </div>
                    <!--end::Root-->
                    <!--begin::Modals-->
                <jsp:include page="/jsp/modal.jsp"></jsp:include>
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
                    <!--end::Scrolltop-->
                    <!--end::Main-->
                    <!--begin::Javascript-->
                    <!--begin::Global Javascript Bundle(used by all pages)-->
                    <script src="assets/plugins/global/plugins.bundle.js"></script>
                    <script src="assets/js/scripts.bundle.js"></script>
                    <!--end::Global Javascript Bundle-->
                    <!--begin::Page Vendors Javascript(used by this page)-->
                    <script src="assets/plugins/custom/datatables/datatables.bundle.js"></script>
                    <!--end::Page Vendors Javascript-->
                    <!--begin::Page Custom Javascript(used by this page)-->
                <jsp:include page="/jsp/shared/customJavascript.jsp"></jsp:include>

                <!--TEST-->
                <script src="assets/js/custom/pages/projects/list/list.js"></script>
                <script src="assets/js/custom/modals/users-search.js"></script>
                <script src="assets/js/custom/widgets.js"></script>
                <script src="assets/js/custom/apps/chat/chat.js"></script>
                <script src="assets/js/custom/modals/create-app.js"></script>
                <script src="assets/js/custom/modals/upgrade-plan.js"></script>
                <!--end::Page Custom Javascript-->
                <!--end::Javascript-->
                </body>
                <!--end::Body-->
                </html>