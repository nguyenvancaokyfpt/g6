<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container">
            <!--begin::Navbar-->
            <div class="card">
                <div class="card-body pt-9 pb-0">

                    <!--begin::Nav wrapper-->
                    <!-- Center item -->
                    <div class="d-flex overflow-auto align-items-center justify-content-center h-55px">
                        <!--begin::Nav links-->
                        <ul
                            class="nav nav-stretch nav-line-tabs nav-line-tabs-2x border-transparent fs-5 fw-bolder flex-nowrap">
                            <!--begin::Nav item-->
                            <li class="nav-item">
                                <a class="nav-link text-active-primary me-6 ${nav_action == "upload" ? 'active' : '' }"
                                    href="/team/new?action=upload">Upload
                                    File</a>
                            </li>
                            <!--end::Nav item-->
                            <!--begin::Nav item-->
                            <li class="nav-item">
                                <a class="nav-link text-active-primary me-6 ${nav_action == "random" ? 'active' : '' }"
                                    href="/team/new?action=random">Random</a>
                            </li>
                            <!--end::Nav item-->
                            <!--begin::Nav item-->
                            <li class="nav-item">
                                <a class="nav-link text-active-primary me-6 ${nav_action == "reuse" ? 'active' : '' }"
                                    href="/team/new?action=reuse">Reuse</a>
                            </li>
                            <!--end::Nav item-->
                            <!--begin::Nav item-->
                            <li class="nav-item">
                                <a class="nav-link text-active-primary me-6 ${nav_action == "clone" ? 'active' : '' }"
                                    href="/team/new?action=clone">Clone</a>
                            </li>
                            <!--end::Nav item-->
                        </ul>
                        <!--end::Nav links-->
                    </div>
                    <!--end::Nav wrapper-->
                    <div class="separator"></div>
                    <!--begin::Details-->
                    <div class="d-flex flex-wrap flex-sm-nowrap mt-6">
                        <!--begin::Wrapper-->
                        <div class="flex-grow-1">
                            <!--begin::Info-->
                            <div class="d-flex flex-wrap justify-content-center">
                                <!--begin::Form-->
                                <form id="kt_modal_export_users_form" class="form mb-6" action="#">
                                    <div class="mb-13 text-center">
                                        <!--begin::Title-->
                                        <h1 class="mb-3">Template for Inport Team</h1>
                                        <!--end::Title-->
                                        <!--begin::Description-->
                                        <div class="text-gray-400 fw-bold fs-5">Download file here
                                            <a href="team/new?action=get&classId=${classroom.getClassId()}"
                                                target="_blank"
                                                class="fw-bolder link-primary">Import_Team_${classroom.getClassCode()}.xlsx</a>.
                                        </div>
                                        <!--end::Description-->
                                    </div>
                                    <!--begin::Input group-->
                                    <div class="fv-row mb-10">
                                        <!--begin::Label-->
                                        <label class="required fs-6 fw-bold form-label mb-2">Select
                                            Milestone:</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <select name="milestoneId" data-control="select2"
                                            data-placeholder="Select a milestone" data-hide-search="true"
                                            class="form-select form-select-solid fw-bolder">
                                            <option></option>
                                            <option value="0">Team default</option>
                                            <c:forEach items="${listMilestone}" var="d">
                                                <option selected value="${d.getMilestoneId()}">${d.getTitle()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <!--end::Input-->
                                        <!--begin::Input-->
                                        <input type="hidden" name="classId" value="${classroom.getClassId()}">
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
                                                        xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                        height="24px" viewBox="0 0 24 24" version="1.1">
                                                        <g stroke="none" stroke-width="1" fill="none"
                                                            fill-rule="evenodd">
                                                            <polygon points="0 0 24 0 24 24 0 24" />
                                                            <path
                                                                d="M5.85714286,2 L13.7364114,2 C14.0910962,2 14.4343066,2.12568431 14.7051108,2.35473959 L19.4686994,6.3839416 C19.8056532,6.66894833 20,7.08787823 20,7.52920201 L20,20.0833333 C20,21.8738751 19.9795521,22 18.1428571,22 L5.85714286,22 C4.02044787,22 4,21.8738751 4,20.0833333 L4,3.91666667 C4,2.12612489 4.02044787,2 5.85714286,2 Z"
                                                                fill="#000000" fill-rule="nonzero" opacity="0.3" />
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
                                                        team data.</span>
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
                            <!--end::Info-->
                        </div>
                        <!--end::Wrapper-->
                    </div>
                    <!--end::Details-->
                </div>
            </div>
            <!--end::Navbar-->
            <!--begin::Modals-->
            <!--end::Modals-->
            <!--begin::Toolbar-->
            <div class="d-flex flex-wrap flex-stack my-5">
                <!--begin::Heading-->
                <h3 class="fw-bolder my-2">Team Details
                    <span class="fs-6 text-gray-400 fw-bold ms-1"></span>
                </h3>
                <!--end::Heading-->
                <!--begin::Controls-->
                <div class="d-flex my-2">
                    <a href="#" data-kt-users-modal-action="reset-team" class='btn btn-primary btn-sm fw-bolder'>Reset
                        Team</a>
                </div>
                <!--end::Controls-->
            </div>

            <!--end::Toolbar-->
            <!--begin::Row-->
            <div id="kt-team-preview" class="row g-6 g-xl-9 mb-6 mb-xl-9">
                <!--begin::Col-->
                <!--begin::Navbar-->
                <div class="card">
                    <div class="card-body pt-9 pb-0">
                        <!--begin::Details-->
                        <div class="d-flex flex-wrap flex-sm-nowrap mt-6">
                            <!--begin::Wrapper-->
                            <div class="flex-grow-1">
                                <!--begin::Info-->
                                <div class="d-flex flex-wrap justify-content-center">
                                    <!--begin::Form-->
                                    <form id="kt_modal_export_users_form" class="form mb-6" action="#">
                                        <div class="mb-13 text-center">
                                            <!--begin::Title-->
                                            <h1 class="mb-3">Guide</h1>
                                            <!--end::Title-->
                                            <!--begin::Description-->
                                            <div class="text-gray-400 fw-bold fs-5">
                                                <a class="fw-bolder link-primary">Upload File</a>.
                                            </div>
                                            <!--end::Description-->
                                            <!--begin::Dropzone-->
                                            <div class="dropzone" id="ps">
                                                <!--begin::Message-->
                                                <div class="dz-message needsclick">
                                                    <!--begin::Icon-->
                                                    <!--begin::Svg Icon | path: icons/duotone/Files/Uploaded-file.svg-->
                                                    <span class="svg-icon svg-icon-3hx svg-icon-primary">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                            xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                            height="24px" viewBox="0 0 24 24" version="1.1">
                                                            <g stroke="none" stroke-width="1" fill="none"
                                                                fill-rule="evenodd">
                                                                <circle fill="#000000" opacity="0.3" cx="12" cy="12"
                                                                    r="10" />
                                                                <rect fill="#000000" x="11" y="10" width="2" height="7"
                                                                    rx="1" />
                                                                <rect fill="#000000" x="11" y="7" width="2" height="2"
                                                                    rx="1" />
                                                            </g>
                                                        </svg>
                                                    </span>
                                                    <!--end::Svg Icon-->
                                                    <!--end::Icon-->
                                                    <!--begin::Info-->
                                                    <div class="ms-4">
                                                        <h6 class="dfs-6 fw-bolder text-gray-900 mb-1">Step 1: Download
                                                            file Template Import</h6>
                                                        <h6 class="dfs-6 fw-bolder text-gray-900 mb-1">Step 2: Fill in
                                                            the data</h6>
                                                        <h6 class="dfs-6 fw-bolder text-gray-900 mb-1">Step 3: Select
                                                            milestone</h6>
                                                        <h6 class="dfs-6 fw-bolder text-gray-900 mb-1">Step 4: Upload
                                                            file</h6>
                                                        <h6 class="dfs-6 fw-bolder text-gray-900 mb-1">Step 5: Click
                                                            Submit</h6>
                                                    </div>
                                                    <!--end::Info-->
                                                </div>
                                            </div>
                                            <!--end::Dropzone-->
                                        </div>
                                    </form>
                                    <!--end::Form-->
                                </div>
                                <!--end::Info-->
                            </div>
                            <!--end::Wrapper-->
                        </div>
                        <!--end::Details-->
                    </div>
                </div>
                <!--end::Navbar-->
                <!--end::Col-->
            </div>
            <!--end:Row-->
        </div>
        <!--end::Container-->
    </div>