<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.tss.constants.ScreenConstants" %>
        <div class="post d-flex flex-column-fluid" id="kt_post">
            <!--begin::Container-->
            <div id="kt_content_container" class="container">
                <!--begin::Card-->
                <div class="card">
                    <!--begin::Card header-->
                    <div class="card-header border-0 pt-6">
                        <!--begin::Card title-->
                        <div class="card-title">
                            <!--begin::Search-->
                            <div class="d-flex align-items-center position-relative my-1">
                                <!--begin::Svg Icon | path: icons/duotone/General/Search.svg-->
                                <span class="svg-icon svg-icon-1 position-absolute ms-6">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                        width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                            <rect x="0" y="0" width="24" height="24" />
                                            <path
                                                d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z"
                                                fill="#000000" fill-rule="nonzero" opacity="0.3" />
                                            <path
                                                d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z"
                                                fill="#000000" fill-rule="nonzero" />
                                        </g>
                                    </svg>
                                </span>
                                <!--end::Svg Icon-->
                                <input type="text" data-kt-user-table-filter="search"
                                    class="form-control form-control-solid w-250px ps-14" placeholder="Search" />
                            </div>
                            <!--end::Search-->
                        </div>
                        <!--begin::Card title-->
                        <!--begin::Card toolbar-->
                        <div class="card-toolbar">
                            <!--begin::Toolbar-->
                            <div class="d-flex justify-content-end me-3" data-kt-user-table-toolbar="base">
                                <!--begin::Filter-->
                                <select id="classId" data-kt-user-table-filter="class"
                                    class="me-3 form-select form-select-solid" aria-label="Select Class">
                                    <c:forEach items="${myClass}" var="d">
                                        <option value="${d.getClassId()}">${d.getClassCode()}</option>
                                    </c:forEach>
                                </select>
                                <!--end::Filter-->

                            </div>

                            <div class="d-flex justify-content-end me-3" data-kt-user-table-toolbar="base">
                                <select data-kt-user-table-filter="status" class="form-select form-select-solid"
                                    aria-label="Select status">
                                    <option value="" disabled selected>Status</option>
                                    <option value="">All</option>
                                    <option value="1">Active</option>
                                    <option value="0">Inactive</option>
                                    <option value="2">Dropout</option>
                                </select>

                            </div>
                            <!--begin::Export-->
                            <button type="button" class="btn btn-light-primary me-3" data-bs-toggle="modal"
                                data-bs-target="#kt_modal_export_users">
                                <!--begin::Svg Icon | path: icons/duotone/Files/Export.svg-->
                                <span class="svg-icon svg-icon-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                        width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                            <rect x="0" y="0" width="24" height="24" />
                                            <rect fill="#000000" opacity="0.3"
                                                transform="translate(12.000000, 7.000000) rotate(-180.000000) translate(-12.000000, -7.000000) "
                                                x="11" y="1" width="2" height="12" rx="1" />
                                            <path
                                                d="M17,8 C16.4477153,8 16,7.55228475 16,7 C16,6.44771525 16.4477153,6 17,6 L18,6 C20.209139,6 22,7.790861 22,10 L22,18 C22,20.209139 20.209139,22 18,22 L6,22 C3.790861,22 2,20.209139 2,18 L2,9.99305689 C2,7.7839179 3.790861,5.99305689 6,5.99305689 L7.00000482,5.99305689 C7.55228957,5.99305689 8.00000482,6.44077214 8.00000482,6.99305689 C8.00000482,7.54534164 7.55228957,7.99305689 7.00000482,7.99305689 L6,7.99305689 C4.8954305,7.99305689 4,8.88848739 4,9.99305689 L4,18 C4,19.1045695 4.8954305,20 6,20 L18,20 C19.1045695,20 20,19.1045695 20,18 L20,10 C20,8.8954305 19.1045695,8 18,8 L17,8 Z"
                                                fill="#000000" fill-rule="nonzero" opacity="0.3" />
                                            <path
                                                d="M14.2928932,10.2928932 C14.6834175,9.90236893 15.3165825,9.90236893 15.7071068,10.2928932 C16.0976311,10.6834175 16.0976311,11.3165825 15.7071068,11.7071068 L12.7071068,14.7071068 C12.3165825,15.0976311 11.6834175,15.0976311 11.2928932,14.7071068 L8.29289322,11.7071068 C7.90236893,11.3165825 7.90236893,10.6834175 8.29289322,10.2928932 C8.68341751,9.90236893 9.31658249,9.90236893 9.70710678,10.2928932 L12,12.5857864 L14.2928932,10.2928932 Z"
                                                fill="#000000" fill-rule="nonzero" />
                                        </g>
                                    </svg>
                                </span>
                                <!--end::Svg Icon-->Import
                            </button>
                            <!--end::Export-->
                            <!--begin::Export-->
                            <button type="button" class="btn btn-light-primary me-3" data-bs-toggle="modal"
                                data-bs-target="#kt_modal_create_account">
                                <!--begin::Svg Icon | path: icons/duotone/Files/Export.svg-->
                                <span class="svg-icon svg-icon-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                        width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                            <circle fill="#000000" opacity="0.3" cx="12" cy="12" r="10" />
                                            <path
                                                d="M11,11 L11,7 C11,6.44771525 11.4477153,6 12,6 C12.5522847,6 13,6.44771525 13,7 L13,11 L17,11 C17.5522847,11 18,11.4477153 18,12 C18,12.5522847 17.5522847,13 17,13 L13,13 L13,17 C13,17.5522847 12.5522847,18 12,18 C11.4477153,18 11,17.5522847 11,17 L11,13 L7,13 C6.44771525,13 6,12.5522847 6,12 C6,11.4477153 6.44771525,11 7,11 L11,11 Z"
                                                fill="#000000" />
                                        </g>
                                    </svg>
                                </span>
                                <!--end::Svg Icon-->Add new
                            </button>
                            <!--end::Export-->
                            <!--end::Toolbar-->
                            <!--begin::Group actions-->
                            <div class="d-flex justify-content-end align-items-center d-none"
                                data-kt-user-table-toolbar="selected">
                                <div class="fw-bolder me-5">
                                    <span class="me-2" data-kt-user-table-select="selected_count"></span>Selected
                                </div>
                                <button type="button" class="btn btn-danger"
                                    data-kt-user-table-select="delete_selected">Delete
                                    Selected</button>
                            </div>
                            <!--end::Group actions-->
                            <!--begin::Modal - Adjust Balance-->
                            <div class="modal fade" id="kt_modal_export_users" aria-hidden="true">
                                <!--begin::Modal dialog-->
                                <div class="modal-dialog modal-dialog-centered mw-650px">
                                    <!--begin::Modal content-->
                                    <div class="modal-content">
                                        <!--begin::Modal header-->
                                        <div class="modal-header">
                                            <!--begin::Modal title-->
                                            <h2 class="fw-bolder">Import Trainee</h2>
                                            <!--end::Modal title-->
                                            <!--begin::Close-->
                                            <div class="btn btn-icon btn-sm btn-active-icon-primary"
                                                data-kt-users-modal-action="close">
                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Close.svg-->
                                                <span class="svg-icon svg-icon-1">
                                                    <svg xmlns="http://www.w3.org/2000/svg"
                                                        xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                        height="24px" viewBox="0 0 24 24" version="1.1">
                                                        <g transform="translate(12.000000, 12.000000) rotate(-45.000000) translate(-12.000000, -12.000000) translate(4.000000, 4.000000)"
                                                            fill="#000000">
                                                            <rect fill="#000000" x="0" y="7" width="16" height="2"
                                                                rx="1" />
                                                            <rect fill="#000000" opacity="0.5"
                                                                transform="translate(8.000000, 8.000000) rotate(-270.000000) translate(-8.000000, -8.000000)"
                                                                x="0" y="7" width="16" height="2" rx="1" />
                                                        </g>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Close-->
                                        </div>
                                        <!--end::Modal header-->
                                        <!--begin::Modal body-->
                                        <div class="modal-body scroll-y mx-5 mx-xl-15 my-7">
                                            <!--begin::Form-->
                                            <form id="kt_modal_export_users_form" class="form" action="#">
                                                <div class="mb-13 text-center">
                                                    <!--begin::Title-->
                                                    <h1 class="mb-3">Template for Inport Trainee</h1>
                                                    <!--end::Title-->
                                                    <!--begin::Description-->
                                                    <div class="text-gray-400 fw-bold fs-5">Download file here
                                                        <a href="assets/media/file/Import_Trainee.xlsx" target="_blank"
                                                            class="fw-bolder link-primary">Import_Trainee.xlsx</a>.
                                                    </div>
                                                    <!--end::Description-->
                                                </div>
                                                <!--begin::Input group-->
                                                <div class="fv-row mb-10">
                                                    <!--begin::Label-->
                                                    <label class="required fs-6 fw-bold form-label mb-2">Select
                                                        Class:</label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <select name="classImport" data-control="select2"
                                                        data-placeholder="Select a class" data-hide-search="true"
                                                        class="form-select form-select-solid fw-bolder">
                                                        <option></option>
                                                        <c:forEach items="${myClass}" var="d">
                                                            <option value="${d.getClassId()}">${d.getClassCode()}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                    <!--end::Input-->
                                                </div>
                                                <!--end::Input group-->
                                                <!--begin::Input group-->
                                                <div class="fv-row mb-8">
                                                    <!--begin::Dropzone-->
                                                    <div class="dropzone" id="kt_modal_create_project_settings_logo">
                                                        <!--begin::Message-->
                                                        <div class="dz-message needsclick">
                                                            <!--begin::Icon-->
                                                            <!--begin::Svg Icon | path: icons/duotone/Files/Uploaded-file.svg-->
                                                            <span class="svg-icon svg-icon-3hx svg-icon-primary">
                                                                <svg xmlns="http://www.w3.org/2000/svg"
                                                                    xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                    width="24px" height="24px" viewBox="0 0 24 24"
                                                                    version="1.1">
                                                                    <g stroke="none" stroke-width="1" fill="none"
                                                                        fill-rule="evenodd">
                                                                        <polygon points="0 0 24 0 24 24 0 24" />
                                                                        <path
                                                                            d="M5.85714286,2 L13.7364114,2 C14.0910962,2 14.4343066,2.12568431 14.7051108,2.35473959 L19.4686994,6.3839416 C19.8056532,6.66894833 20,7.08787823 20,7.52920201 L20,20.0833333 C20,21.8738751 19.9795521,22 18.1428571,22 L5.85714286,22 C4.02044787,22 4,21.8738751 4,20.0833333 L4,3.91666667 C4,2.12612489 4.02044787,2 5.85714286,2 Z"
                                                                            fill="#000000" fill-rule="nonzero"
                                                                            opacity="0.3" />
                                                                        <path
                                                                            d="M8.95128003,13.8153448 L10.9077535,13.8153448 L10.9077535,15.8230161 C10.9077535,16.0991584 11.1316112,16.3230161 11.4077535,16.3230161 L12.4310522,16.3230161 C12.7071946,16.3230161 12.9310522,16.0991584 12.9310522,15.8230161 L12.9310522,13.8153448 L14.8875257,13.8153448 C15.1636681,13.8153448 15.3875257,13.5914871 15.3875257,13.3153448 C15.3875257,13.1970331 15.345572,13.0825545 15.2691225,12.9922598 L12.3009997,9.48659872 C12.1225648,9.27584861 11.8070681,9.24965194 11.596318,9.42808682 C11.5752308,9.44594059 11.5556598,9.46551156 11.5378061,9.48659872 L8.56968321,12.9922598 C8.39124833,13.2030099 8.417445,13.5185067 8.62819511,13.6969416 C8.71848979,13.773391 8.8329684,13.8153448 8.95128003,13.8153448 Z"
                                                                            fill="#000000" />
                                                                    </g>
                                                                </svg>
                                                            </span>
                                                            <!--end::Svg Icon-->
                                                            <!--end::Icon-->
                                                            <!--begin::Info-->
                                                            <div class="ms-4">
                                                                <h3 class="dfs-3 fw-bolder text-gray-900 mb-1">Drop
                                                                    files here or click to upload.</h3>
                                                                <span class="fw-bold fs-4 text-gray-400">Upload Excel
                                                                    trainee data.</span>
                                                            </div>
                                                            <!--end::Info-->
                                                        </div>
                                                    </div>
                                                    <!--end::Dropzone-->
                                                </div>
                                                <!--end::Input group-->
                                                <!--begin::Actions-->
                                                <div class="text-center">
                                                    <button type="reset" class="btn btn-white me-3"
                                                        data-kt-users-modal-action="cancel">Discard</button>
                                                    <button type="submit" class="btn btn-primary"
                                                        data-kt-users-modal-action="submit">
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
                                        <!--end::Modal body-->
                                    </div>
                                    <!--end::Modal content-->
                                </div>
                                <!--end::Modal dialog-->
                            </div>
                            <!--end::Modal - New Card-->
                            <!--begin::Modal - Create account-->
                            <div class="modal fade" id="kt_modal_create_account" aria-hidden="true">
                                <!--begin::Modal dialog-->
                                <div class="modal-dialog mw-1000px">
                                    <!--begin::Modal content-->
                                    <div class="modal-content">
                                        <!--begin::Modal header-->
                                        <div class="modal-header">
                                            <!--begin::Title-->
                                            <h2>Add Trainee</h2>
                                            <!--end::Title-->
                                            <!--begin::Close-->
                                            <div class="btn btn-sm btn-icon btn-active-color-primary"
                                                data-bs-dismiss="modal">
                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Close.svg-->
                                                <span class="svg-icon svg-icon-1">
                                                    <svg xmlns="http://www.w3.org/2000/svg"
                                                        xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                        height="24px" viewBox="0 0 24 24" version="1.1">
                                                        <g transform="translate(12.000000, 12.000000) rotate(-45.000000) translate(-12.000000, -12.000000) translate(4.000000, 4.000000)"
                                                            fill="#000000">
                                                            <rect fill="#000000" x="0" y="7" width="16" height="2"
                                                                rx="1" />
                                                            <rect fill="#000000" opacity="0.5"
                                                                transform="translate(8.000000, 8.000000) rotate(-270.000000) translate(-8.000000, -8.000000)"
                                                                x="0" y="7" width="16" height="2" rx="1" />
                                                        </g>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Close-->
                                        </div>
                                        <!--end::Modal header-->
                                        <!--begin::Modal body-->
                                        <div class="modal-body scroll-y m-5">
                                            <!--begin::Stepper-->
                                            <div class="stepper stepper-links d-flex flex-column"
                                                id="kt_create_account_stepper">
                                                <!--begin::Nav-->
                                                <div class="stepper-nav py-5" style="display: none;">
                                                    <!--begin::Step 1-->
                                                    <div class="stepper-item current" data-kt-stepper-element="nav">
                                                        <h3 class="stepper-title">Add Method</h3>
                                                    </div>
                                                    <!--end::Step 1-->
                                                    <!--begin::Step 2-->
                                                    <div class="stepper-item" data-kt-stepper-element="nav">
                                                        <h3 class="stepper-title">Add To Class</h3>
                                                    </div>
                                                    <!--end::Step 2-->
                                                    <!--begin::Step 3-->
                                                    <div class="stepper-item" data-kt-stepper-element="nav">
                                                        <h3 class="stepper-title">Create New</h3>
                                                    </div>
                                                    <!--end::Step 3-->
                                                </div>
                                                <!--end::Nav-->
                                                <!--begin::Form-->
                                                <form class="mx-auto mw-600px w-100 py-10" novalidate="novalidate"
                                                    id="kt_create_account_form">
                                                    <!--begin::Step 1-->
                                                    <div class="current" data-kt-stepper-element="content">
                                                        <!--begin::Wrapper-->
                                                        <div class="w-100">
                                                            <!--begin::Heading-->
                                                            <div class="pb-10 pb-lg-15">
                                                                <!--begin::Title-->
                                                                <h2
                                                                    class="fw-bolder d-flex align-items-center text-dark">
                                                                    Choose Method
                                                                    <i class="fas fa-exclamation-circle ms-2 fs-7"
                                                                        data-bs-toggle="tooltip"
                                                                        title="Add users to classroom or create new user"></i>
                                                                </h2>
                                                                <!--end::Title-->
                                                                <!--begin::Notice-->
                                                                <div class="text-gray-400 fw-bold fs-6">Select
                                                                    method to add trainee.
                                                                </div>
                                                                <!--end::Notice-->
                                                            </div>
                                                            <!--end::Heading-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row">
                                                                <!--begin::Row-->
                                                                <div class="row">
                                                                    <!--begin::Col-->
                                                                    <div class="col-lg-6">
                                                                        <!--begin::Option-->
                                                                        <input type="radio" class="btn-check"
                                                                            name="account_type" value="1"
                                                                            checked="checked"
                                                                            id="kt_create_account_form_account_type_personal" />
                                                                        <label
                                                                            class="btn btn-outline btn-outline-dashed btn-outline-default p-7 d-flex align-items-center mb-10"
                                                                            for="kt_create_account_form_account_type_personal">
                                                                            <!--begin::Svg Icon | path: icons/duotone/Interface/User.svg-->
                                                                            <span class="svg-icon svg-icon-3x me-5">
                                                                                <svg xmlns="http://www.w3.org/2000/svg"
                                                                                    width="24" height="24"
                                                                                    viewBox="0 0 24 24" fill="none">
                                                                                    <path
                                                                                        d="M17 6C17 8.76142 14.7614 11 12 11C9.23858 11 7 8.76142 7 6C7 3.23858 9.23858 1 12 1C14.7614 1 17 3.23858 17 6Z"
                                                                                        fill="#121319" />
                                                                                    <path opacity="0.25"
                                                                                        fill-rule="evenodd"
                                                                                        clip-rule="evenodd"
                                                                                        d="M18.818 14.1248C18.2016 13.4101 17.1428 13.4469 16.3149 13.9001C15.0338 14.6013 13.5635 15 12 15C10.4365 15 8.96618 14.6013 7.68505 13.9001C6.85717 13.4469 5.79841 13.4101 5.182 14.1248C3.82222 15.7014 3 17.7547 3 20V21C3 22.1045 3.89543 23 5 23H19C20.1046 23 21 22.1045 21 21V20C21 17.7547 20.1778 15.7014 18.818 14.1248Z"
                                                                                        fill="#191213" />
                                                                                </svg>
                                                                            </span>
                                                                            <!--end::Svg Icon-->
                                                                            <!--begin::Info-->
                                                                            <span class="d-block fw-bold text-start">
                                                                                <span
                                                                                    class="text-dark fw-bolder d-block fs-4 mb-2">Existing
                                                                                    Trainee</span>
                                                                                <span
                                                                                    class="text-gray-400 fw-bold fs-6">Add
                                                                                    existing trainee to this
                                                                                    classroom.</span>
                                                                            </span>
                                                                            <!--end::Info-->
                                                                        </label>
                                                                        <!--end::Option-->
                                                                    </div>
                                                                    <!--end::Col-->
                                                                    <!--begin::Col-->
                                                                    <div class="col-lg-6">
                                                                        <!--begin::Option-->
                                                                        <input type="radio" class="btn-check"
                                                                            name="account_type" value="2"
                                                                            id="kt_create_account_form_account_type_corporate" />
                                                                        <label
                                                                            class="btn btn-outline btn-outline-dashed btn-outline-default p-7 d-flex align-items-center"
                                                                            for="kt_create_account_form_account_type_corporate">
                                                                            <!--begin::Svg Icon | path: icons/duotone/Interface/Briefcase.svg-->
                                                                            <span class="svg-icon svg-icon-3x me-5">
                                                                                <svg xmlns="http://www.w3.org/2000/svg"
                                                                                    width="24" height="24"
                                                                                    viewBox="0 0 24 24" fill="none">
                                                                                    <circle fill="#000000" opacity="0.3"
                                                                                        cx="12" cy="12" r="10" />
                                                                                    <path
                                                                                        d="M11,11 L11,7 C11,6.44771525 11.4477153,6 12,6 C12.5522847,6 13,6.44771525 13,7 L13,11 L17,11 C17.5522847,11 18,11.4477153 18,12 C18,12.5522847 17.5522847,13 17,13 L13,13 L13,17 C13,17.5522847 12.5522847,18 12,18 C11.4477153,18 11,17.5522847 11,17 L11,13 L7,13 C6.44771525,13 6,12.5522847 6,12 C6,11.4477153 6.44771525,11 7,11 L11,11 Z"
                                                                                        fill="#000000" />
                                                                                </svg>
                                                                            </span>
                                                                            <!--end::Svg Icon-->
                                                                            <!--begin::Info-->
                                                                            <span class="d-block fw-bold text-start">
                                                                                <span
                                                                                    class="text-dark fw-bolder d-block fs-4 mb-2">Create
                                                                                    new Trainee</span>
                                                                                <span
                                                                                    class="text-gray-400 fw-bold fs-6">Create
                                                                                    new trainee and add to this
                                                                                    classroom.</span>
                                                                            </span>
                                                                            <!--end::Info-->
                                                                        </label>
                                                                        <!--end::Option-->
                                                                    </div>
                                                                    <!--end::Col-->
                                                                </div>
                                                                <!--end::Row-->
                                                            </div>
                                                            <!--end::Input group-->
                                                        </div>
                                                        <!--end::Wrapper-->
                                                    </div>
                                                    <!--end::Step 1-->
                                                    <!--begin::Step 2-->
                                                    <div data-kt-stepper-element="content">
                                                        <!--begin::Wrapper-->
                                                        <div class="w-100" style="margin-bottom: 180px !important;">
                                                            <!--begin::Heading-->
                                                            <div class="pb-10 pb-lg-15">
                                                                <!--begin::Title-->
                                                                <h2 class="fw-bolder text-dark">Add Trainee to Class
                                                                </h2>
                                                                <!--end::Title-->
                                                            </div>
                                                            <!--end::Heading-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row mb-10">
                                                                <!--begin::Label-->
                                                                <label
                                                                    class="required fs-6 fw-bold form-label mb-2">Select
                                                                    Class:</label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <select name="ClasstraineeAdd" data-control="select2"
                                                                    data-placeholder="Select a class"
                                                                    data-hide-search="true"
                                                                    class="form-select form-select-solid fw-bolder">
                                                                    <option></option>
                                                                    <c:forEach items="${myClass}" var="d">
                                                                        <option value="${d.getClassId()}">
                                                                            ${d.getClassCode()}
                                                                        </option>
                                                                    </c:forEach>
                                                                </select>
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row">
                                                                <!--begin::Label-->
                                                                <label
                                                                    class="required fs-6 fw-bold form-label mb-2">Select
                                                                    Trainee:</label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <select class="form-select form-select-solid"
                                                                    name="traineeAddId" data-control="select2-c"
                                                                    data-dropdown-parent="#kt_create_account_stepper">
                                                                    <option>Trainee</option>
                                                                </select>
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                        </div>
                                                        <!--end::Wrapper-->
                                                    </div>
                                                    <!--end::Step 2-->
                                                    <!--begin::Step 3-->
                                                    <div data-kt-stepper-element="content">
                                                        <!--begin::Wrapper-->
                                                        <div class="w-100">
                                                            <!--begin::Heading-->
                                                            <div class="pb-10 pb-lg-12">
                                                                <!--begin::Title-->
                                                                <h2 class="fw-bolder text-dark">Create Trainee</h2>
                                                                <!--end::Title-->
                                                            </div>
                                                            <!--end::Heading-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row mb-10">
                                                                <!--begin::Label-->
                                                                <label class="form-label required">Fullname</label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <input name="trainee_name"
                                                                    class="form-control form-control-lg form-control"
                                                                    placeholder="Fullname" value="" />
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row mb-10">
                                                                <!--begin::Label-->
                                                                <label class="d-flex align-items-center form-label">
                                                                    <span class="required">Email</span>
                                                                </label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <input name="trainee_email"
                                                                    class="form-control form-control-lg form-control"
                                                                    placeholder="Email" value="" />
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row mb-10">
                                                                <!--end::Label-->
                                                                <label class="form-label">Note</label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <textarea name="trainee_note"
                                                                    class="form-control form-control-lg form-control"
                                                                    rows="3"></textarea>
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                            <!--begin::Input group-->
                                                            <div class="fv-row mb-10">
                                                                <!--begin::Label-->
                                                                <label
                                                                    class="required fs-6 fw-bold form-label mb-2">Select
                                                                    Class:</label>
                                                                <!--end::Label-->
                                                                <!--begin::Input-->
                                                                <select name="ClasstraineeAdd" data-control="select2"
                                                                    data-placeholder="Select a class"
                                                                    data-hide-search="true"
                                                                    class="form-select form-select-solid fw-bolder">
                                                                    <option></option>
                                                                    <c:forEach items="${myClass}" var="d">
                                                                        <option value="${d.getClassId()}">
                                                                            ${d.getClassCode()}
                                                                        </option>
                                                                    </c:forEach>
                                                                </select>
                                                                <!--end::Input-->
                                                            </div>
                                                            <!--end::Input group-->
                                                        </div>
                                                        <!--end::Wrapper-->
                                                    </div>
                                                    <!--end::Step 3-->
                                                    <!--begin::Actions-->
                                                    <div class="d-flex flex-stack pt-15">
                                                        <!--begin::Wrapper-->
                                                        <div class="mr-2">
                                                            <button type="button"
                                                                class="btn btn-lg btn-light-primary me-3"
                                                                data-kt-stepper-action="previous">
                                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Left-2.svg-->
                                                                <span class="svg-icon svg-icon-4 me-1">
                                                                    <svg xmlns="http://www.w3.org/2000/svg"
                                                                        xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                        width="24px" height="24px" viewBox="0 0 24 24"
                                                                        version="1.1">
                                                                        <g stroke="none" stroke-width="1" fill="none"
                                                                            fill-rule="evenodd">
                                                                            <polygon points="0 0 24 0 24 24 0 24" />
                                                                            <rect fill="#000000" opacity="0.3"
                                                                                transform="translate(15.000000, 12.000000) scale(-1, 1) rotate(-90.000000) translate(-15.000000, -12.000000)"
                                                                                x="14" y="7" width="2" height="10"
                                                                                rx="1" />
                                                                            <path
                                                                                d="M3.7071045,15.7071045 C3.3165802,16.0976288 2.68341522,16.0976288 2.29289093,15.7071045 C1.90236664,15.3165802 1.90236664,14.6834152 2.29289093,14.2928909 L8.29289093,8.29289093 C8.67146987,7.914312 9.28105631,7.90106637 9.67572234,8.26284357 L15.6757223,13.7628436 C16.0828413,14.136036 16.1103443,14.7686034 15.7371519,15.1757223 C15.3639594,15.5828413 14.7313921,15.6103443 14.3242731,15.2371519 L9.03007346,10.3841355 L3.7071045,15.7071045 Z"
                                                                                fill="#000000" fill-rule="nonzero"
                                                                                transform="translate(9.000001, 11.999997) scale(-1, -1) rotate(90.000000) translate(-9.000001, -11.999997)" />
                                                                        </g>
                                                                    </svg>
                                                                </span>
                                                                <!--end::Svg Icon-->Back
                                                            </button>
                                                        </div>
                                                        <!--end::Wrapper-->
                                                        <!--begin::Wrapper-->
                                                        <div>
                                                            <button type="button" class="btn btn-lg btn-primary me-3"
                                                                data-kt-stepper-action="submit">
                                                                <span class="indicator-label">Submit
                                                                    <!--begin::Svg Icon | path: icons/duotone/Navigation/Right-2.svg-->
                                                                    <span class="svg-icon svg-icon-3 ms-2 me-0">
                                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                                            xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                            width="24px" height="24px"
                                                                            viewBox="0 0 24 24" version="1.1">
                                                                            <g stroke="none" stroke-width="1"
                                                                                fill="none" fill-rule="evenodd">
                                                                                <polygon points="0 0 24 0 24 24 0 24" />
                                                                                <rect fill="#000000" opacity="0.5"
                                                                                    transform="translate(8.500000, 12.000000) rotate(-90.000000) translate(-8.500000, -12.000000)"
                                                                                    x="7.5" y="7.5" width="2" height="9"
                                                                                    rx="1" />
                                                                                <path
                                                                                    d="M9.70710318,15.7071045 C9.31657888,16.0976288 8.68341391,16.0976288 8.29288961,15.7071045 C7.90236532,15.3165802 7.90236532,14.6834152 8.29288961,14.2928909 L14.2928896,8.29289093 C14.6714686,7.914312 15.281055,7.90106637 15.675721,8.26284357 L21.675721,13.7628436 C22.08284,14.136036 22.1103429,14.7686034 21.7371505,15.1757223 C21.3639581,15.5828413 20.7313908,15.6103443 20.3242718,15.2371519 L15.0300721,10.3841355 L9.70710318,15.7071045 Z"
                                                                                    fill="#000000" fill-rule="nonzero"
                                                                                    transform="translate(14.999999, 11.999997) scale(1, -1) rotate(90.000000) translate(-14.999999, -11.999997)" />
                                                                            </g>
                                                                        </svg>
                                                                    </span>
                                                                    <!--end::Svg Icon-->
                                                                </span>
                                                                <span class="indicator-progress">Please wait...
                                                                    <span
                                                                        class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                                            </button>
                                                            <button type="button" class="btn btn-lg btn-primary"
                                                                data-kt-stepper-action="next">Continue
                                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Right-2.svg-->
                                                                <span class="svg-icon svg-icon-4 ms-1 me-0">
                                                                    <svg xmlns="http://www.w3.org/2000/svg"
                                                                        xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                        width="24px" height="24px" viewBox="0 0 24 24"
                                                                        version="1.1">
                                                                        <g stroke="none" stroke-width="1" fill="none"
                                                                            fill-rule="evenodd">
                                                                            <polygon points="0 0 24 0 24 24 0 24" />
                                                                            <rect fill="#000000" opacity="0.5"
                                                                                transform="translate(8.500000, 12.000000) rotate(-90.000000) translate(-8.500000, -12.000000)"
                                                                                x="7.5" y="7.5" width="2" height="9"
                                                                                rx="1" />
                                                                            <path
                                                                                d="M9.70710318,15.7071045 C9.31657888,16.0976288 8.68341391,16.0976288 8.29288961,15.7071045 C7.90236532,15.3165802 7.90236532,14.6834152 8.29288961,14.2928909 L14.2928896,8.29289093 C14.6714686,7.914312 15.281055,7.90106637 15.675721,8.26284357 L21.675721,13.7628436 C22.08284,14.136036 22.1103429,14.7686034 21.7371505,15.1757223 C21.3639581,15.5828413 20.7313908,15.6103443 20.3242718,15.2371519 L15.0300721,10.3841355 L9.70710318,15.7071045 Z"
                                                                                fill="#000000" fill-rule="nonzero"
                                                                                transform="translate(14.999999, 11.999997) scale(1, -1) rotate(90.000000) translate(-14.999999, -11.999997)" />
                                                                        </g>
                                                                    </svg>
                                                                </span>
                                                                <!--end::Svg Icon-->
                                                            </button>
                                                        </div>
                                                        <!--end::Wrapper-->
                                                    </div>
                                                    <!--end::Actions-->
                                                </form>
                                                <!--end::Form-->
                                            </div>
                                            <!--end::Stepper-->
                                        </div>
                                        <!--end::Modal body-->
                                    </div>
                                    <!--end::Modal content-->
                                </div>
                                <!--end::Modal dialog-->
                            </div>
                            <!--end::Modal - Create project-->
                        </div>
                        <!--end::Card toolbar-->
                    </div>
                    <!--end::Card header-->
                    <!--begin::Card body-->
                    <div class="card-body pt-0">
                        <!--begin::Table-->
                        <table class="table align-middle table-row-dashed fs-6 gy-5" id="kt_table_users">
                            <!--begin::Table head-->
                            <thead>
                                <!--begin::Table row-->
                                <tr class="text-start text-gray-400 fw-bolder fs-7 text-uppercase gs-0">
                                    <th class="w-10px pe-2">
                                        <div class="form-check form-check-sm form-check-custom form-check-solid me-3">
                                            <input class="form-check-input" type="checkbox" data-kt-check="true"
                                                data-kt-check-target="#kt_table_users .form-check-input" value="1" />
                                        </div>
                                    </th>
                                    <th class="min-w-10px">ID</th>
                                    <th class="min-w-150px">User</th>
                                    <th class="min-w-70px">Mobile</th>
                                    <th class="min-w-80px">Grade</th>
                                    <th class="min-w-80px">Dropout Date</th>
                                    <th class="min-w-100px">Status</th>
                                    <th class="text-end min-w-125px">Actions</th>
                                </tr>
                                <!--end::Table row-->
                            </thead>
                            <!--end::Table head-->
                            <!--begin::Table body-->
                            <tbody class="text-gray-600 fw-bold">
                            </tbody>
                            <!--end::Table body-->
                        </table>
                        <!--end::Table-->
                    </div>
                    <!--end::Card body-->
                </div>
                <!--end::Card-->
            </div>
            <!--end::Container-->
        </div>