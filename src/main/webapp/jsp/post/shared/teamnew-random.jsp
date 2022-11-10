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
                                        <h1 class="mb-3">Generate Random Team</h1>
                                        <!--end::Title-->
                                        <!--begin::Description-->
                                        <div class="text-gray-400 fw-bold fs-5">
                                            <a class="fw-bolder link-primary">Input a number team you want to
                                                generate.</a>.
                                        </div>
                                        <!--end::Description-->
                                    </div>
                                    <!--begin::Input group-->
                                    <div class="fv-row mb-10">
                                        <!--begin::Label-->
                                        <label class="required fs-6 fw-bold form-label mb-2">Number Team:</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <select name="teamNum" data-control="select2-num" data-placeholder="Number Team"
                                            data-hide-search="true" data-select2-tags="true"
                                            class="form-select form-select-solid fw-bolder">
                                            <option></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                        <!--end::Input-->
                                        <!--begin::Input group-->
                                        <div class="fv-row mb-10 mt-10">
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
                                                    <h3 class="dfs-6 fw-bolder text-gray-900 mb-1">If Number Team >
                                                        Trainee number</h3>
                                                    <span class="fw-bold fs-4 text-gray-400">Number team
                                                        automatically<br />
                                                        set to trainee number</span>
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
                                            <span class="indicator-label">Generate</span>
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

                <!--end::Col-->
            </div>
            <!--end:Row-->
        </div>
        <!--end::Container-->
    </div>