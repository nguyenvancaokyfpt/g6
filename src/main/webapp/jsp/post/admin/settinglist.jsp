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
                            <!--begin::Content-->
                            <div class="content d-flex flex-column flex-column-fluid" id="kt_content">

                                <!--begin::Post-->
                                <div class="post d-flex flex-column-fluid" id="kt_post">                                   
                                    <!--begin::Container-->
                                    <div id="kt_content_container" class="container">
                                        <div class="card">
                                            <form action="settingList">
                                                <!--begin::Card header-->
                                                <div class="card-header border-0 pt-6">
                                                    <!--begin::Card title-->
                                                    <div class="card-title">
                                                        <!--begin::Search-->
                                                        <div class="d-flex align-items-center position-relative my-1">
                                                            <input name="searchword" type="text" data-kt-customer-table-filter="search" class="form-control form-control-solid w-250px ps-15" placeholder="Search Setting">
                                                            <div class="d-flex align-items-center" id="kt_header_search_toggle">
                                                                <button type="submit" class="btn btn-icon btn-active-light-primary"> <span class="svg-icon svg-icon-1">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                        <rect x="0" y="0" width="24" height="24"></rect>
                                                                        <path d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
                                                                        <path d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z" fill="#000000" fill-rule="nonzero"></path>
                                                                        </g>
                                                                        </svg>
                                                                    </span>
                                                                </button>
                                                            </div>

                                                        </div>
                                                        <!--end::Search-->
                                                    </div>
                                                    <!--begin::Card title-->
                                                    <!--begin::Card toolbar-->
                                                    <div class="card-toolbar">
                                                        <!--begin::Group actions-->
                                                        <div class="d-flex justify-content-end align-items-center d-none" data-kt-customer-table-toolbar="selected">
                                                            <div class="fw-bolder me-5">
                                                                <span class="me-2" data-kt-customer-table-select="selected_count"></span>Selected</div>
                                                            <button type="button" class="btn btn-danger" data-kt-customer-table-select="delete_selected">Delete Selected</button>
                                                        </div>
                                                        <!--end::Group actions-->
                                                    </div>
                                                    <!--end::Card toolbar-->
                                                </div>
                                                <!--end::Card header-->
                                            </form>
                                            <!--begin::Card-->
                                            <div class="card">
                                                <!--begin::Card Body-->
                                                <div class="card-body fs-6 p-10 p-lg-15">
                                                    <!--begin::Section-->
                                                    <div class="pb-10">
                                                        <!--begin::Heading-->
                                                        <h1 class="anchor fw-bolder mb-5" id="basic-table">
                                                            <a href="#basic-table"></a>Setting List</h1>
                                                        <!--end::Heading-->
                                                        <!--begin::Block-->
                                                        <div class="my-5">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr class="fw-bold fs-6 text-gray-800 border-bottom border-gray-500">
                                                                        <th>ID
                                                                            <a href="/settingList?order=setting_id&page=${i}&order=${order}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=setting_id&page=${i}&order=${order}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>Type
                                                                        <a href="/settingList?order=type_id&page=${i}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=type_id&page=${i}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>Title
                                                                        <a href="/settingList?order=setting_title&page=${i}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=setting_title&page=${i}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>Value
                                                                        <a href="/settingList?order=setting_value&page=${i}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=setting_value&page=${i}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>Display Order
                                                                        <a href="/settingList?order=display_order&page=${i}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=display_order&page=${i}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>Status
                                                                        <a href="/settingList?order=status_title&page=${i}&searchword=${searchword}&dir=asc"> A</a>
                                                                        <a href="/settingList?order=status_title&page=${i}&searchword=${searchword}&dir=desc">| D</a>
                                                                    </th>
                                                                    <th>View</th>
                                                                    <th>Edit</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="content">
                                                                <c:forEach items="${settinglist}" var="sl">
                                                                    <tr class="fw-bold fs-6 text-gray-800 border-bottom border-gray-200">                                                   
                                                                        <td>${sl.id}</td>
                                                                        <td>${sl.type_id}</td>
                                                                        <td>${sl.title}</td>
                                                                        <td>${sl.value}</td>
                                                                        <td>${sl.display_order}</td>
                                                                        <c:choose>
                                                                            <c:when test="${sl.statusString=='Active'}">
                                                                                <td><span class="badge badge-success">${sl.statusString}</span></td>
                                                                                </c:when>    
                                                                                <c:otherwise>
                                                                                <td><span class="badge badge-danger">${sl.statusString}</span></td>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        <td class="border-gray-200"><a href="/settingDetail?id=${sl.id}&action=view">View</a></td>
                                                                        <td class="border-gray-200"><a href="/settingDetail?id=${sl.id}&action=edit">Edit</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <tr>
                                                                    <td>                                                            
                                                                        <a type="button" class="btn btn-primary" href="/settingList?action=add">
                                                                            <!--begin::Svg Icon | path: icons/duotone/Navigation/Plus.svg-->
                                                                            <span class="svg-icon svg-icon-2">
                                                                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
                                                                                     width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                                                <rect fill="#000000" x="4" y="11" width="16" height="2" rx="1"></rect>
                                                                                <rect fill="#000000" opacity="0.5" transform="translate(12.000000, 12.000000) 
                                                                                      rotate(-270.000000) translate(-12.000000, -12.000000)" x="4" y="11" width="16" height="2" rx="1"></rect>
                                                                                </svg>
                                                                            </span>
                                                                            <!--end::Svg Icon-->Add Setting
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <div class="pagination">
                                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                                <c:choose>
                                                                    <c:when test="${i == page}">
                                                                        <a class="btn btn-icon btn-bg-primary" 
                                                                           href="/settingList?page=${i}&order=${order}&searchword=${searchword}&dir=${dir}">${i}</a>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <a class="btn btn-icon btn-active-light-primary" 
                                                                           href="/settingList?page=${i}&order=${order}&searchword=${searchword}&dir=${dir}">${i}</a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <!--end::Block-->
                                                </div>
                                                <!--end::Section-->
                                            </div>
                                            <!--end::Card Body-->
                                        </div>
                                        <!--end::Card-->
                                    </div>
                                </div>
                                <!--end::Container-->
                            </div>
                            <!--end::Post-->
                        </div>
                        <!--end::Content-->
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
