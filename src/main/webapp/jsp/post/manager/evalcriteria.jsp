<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <input type="text" class="d-none" value="${requestScope.toastStatus == null ? 0: requestScope.toastStatus}"
        id="toastStatus">
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container-fluid">
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
                            <input type="text" data-kt-eval-table-filter="search"
                                class="form-control form-control-solid w-250px ps-14"
                                placeholder="Search Eval Criteria" />
                        </div>
                        <!--end::Search-->
                        <!-- begin::Input group-->
                        <div style="margin: 0 0 20px 20px;">
                            <label class="form-label fs-6 fw-bold">Subject</label>
                            <select onchange="getSub()" id="subSelect" class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                data-placeholder="Select option" data-allow-clear="true"
                                data-kt-eval-table-filter="subject" data-hide-search="true">
                                <option value="-1">All Subjects</option>
                                <c:forEach items="${requestScope.subjects}" var="s">
                                    <option value="${s.subjectId}">${s.subjectName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <!--end::Input group -->
                        <!--begin::Input group-->
                        <div style="margin: 0 0 20px 20px;">
                            <label class="form-label fs-6 fw-bold">Assignment</label>
                            <select id="assSelect" class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                data-placeholder="Select option" data-allow-clear="true"
                                data-kt-eval-table-filter="assign" data-hide-search="true">
                            </select>
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div style="margin: 0 0 20px 20px;">
                            <label class="form-label fs-6 fw-bold">Status</label>
                            <select id="statusSelect" class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                data-placeholder="Select option" data-allow-clear="true"
                                data-kt-eval-table-filter="status" data-hide-search="true">
                                <option value="-1">All Status</option>
                                <option value="1">Active</option>
                                <option value="0">Deactivate</option>
                            </select>
                        </div>
                        <!--end::Input group-->
                    </div>
                    <!--begin::Card title-->
                </div>
                <!--end::Card header-->
                <!--begin::Card body-->
                <div class="card-body pt-0">
                    <!--begin::Table-->
                    <table class="table align-middle table-row-dashed fs-6 gy-5" id="kt_table_evalCriteria"></table>
                    <!--end::Table-->
                </div>
                <!--end::Card body-->
            </div>
            <!--end::Card-->
        </div>
        <!--end::Container-->
    </div>