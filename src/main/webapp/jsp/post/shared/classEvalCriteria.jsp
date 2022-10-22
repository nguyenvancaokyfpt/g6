<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                    <rect x="0" y="0" width="24" height="24" />
                                    <path d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3" />
                                    <path d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z" fill="#000000" fill-rule="nonzero" />
                                </g>
                            </svg>
                        </span>
                        <!--end::Svg Icon-->
                        <input type="text" data-kt-class-eval-table-filter="search" class="form-control form-control-solid w-250px ps-14" placeholder="Search" />
                    </div>
                    <!--end::Search-->
                </div>
                <!--begin::Card title-->
                <!--begin::Card toolbar-->
                <div class="card-toolbar">
                    <!--begin::Toolbar-->
                    <div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
                        <!--begin::Filter-->
                        <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click"
                                data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">
                            <!--begin::Svg Icon | path: icons/duotone/Text/Filter.svg-->
                            <span class="svg-icon svg-icon-2">
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                     height="24px" viewBox="0 0 24 24" version="1.1">
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                        <rect x="0" y="0" width="24" height="24" />
                                        <path
                                            d="M5,4 L19,4 C19.2761424,4 19.5,4.22385763 19.5,4.5 C19.5,4.60818511 19.4649111,4.71345191 19.4,4.8 L14,12 L14,20.190983 C14,20.4671254 13.7761424,20.690983 13.5,20.690983 C13.4223775,20.690983 13.3458209,20.6729105 13.2763932,20.6381966 L10,19 L10,12 L4.6,4.8 C4.43431458,4.5790861 4.4790861,4.26568542 4.7,4.1 C4.78654809,4.03508894 4.89181489,4 5,4 Z"
                                            fill="#000000" />
                                    </g>
                                </svg>
                            </span>
                            <!--end::Svg Icon-->Filter
                        </button>
                        <!--begin::Menu 1-->
                        <div class="menu menu-sub menu-sub-dropdown w-300px w-md-325px" data-kt-menu="true">
                            <!--begin::Header-->
                            <div class="px-7 py-5">
                                <div class="fs-5 text-dark fw-bolder">Filter Options</div>
                            </div>
                            <!--end::Header-->
                            <!--begin::Separator-->
                            <div class="separator border-gray-200"></div>
                            <!--end::Separator-->
                            <!--begin::Content-->
                            <div class="px-7 py-5" data-kt-user-table-filter="form">
                                <!--begin::Input group-->
                                <div class="mb-10">
                                    <label class="form-label fs-6 fw-bold">Class Code</label>
                                    <select
                                        id="classId"
                                        class="form-select form-select-solid fw-bolder"
                                        data-kt-select2="true" data-placeholder="Select Class"
                                        aria-hidden="true" name="classId">
                                        <option value="">
                                            Select Class
                                        </option>
                                        <c:forEach items="${requestScope.classList}" var="u">
                                            <option value="${u.classCode}">
                                                ${u.classCode}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!--end::Input group-->
                                <!--begin::Actions-->
                                <div class="d-flex justify-content-end">
                                    <button type="reset" class="btn btn-white me-3" data-kt-users-modal-action="cancel">Reset</button>
                                    <button type="submit" class="btn btn-primary" data-kt-class-evel-criteria-table-filter="submit">
                                        <span class="indicator-label">Apply</span>
                                        <span class="indicator-progress">Please wait...
                                            <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                    </button>
                                </div>
                                <!--end::Actions-->
                            </div>
                            <!--end::Content-->
                        </div>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addClassEval">
                            Add Class Eval Criteria
                        </button>
                    </div>
                    <!--end::Toolbar-->
                </div>
                <!--end::Card toolbar-->
            </div>
            <!--end::Card header-->
            <!--begin::Card body-->
            <div class="card-body pt-0">
                <!--begin::Table-->
                <table class="table align-middle table-row-dashed fs-6 gy-5" id="kt_table_classEvalCriteria">
                    <!--begin::Table head-->
                    <thead>
                        <!--begin::Table row-->
                        <tr class="text-start text-gray-400 fw-bolder fs-7 text-uppercase gs-0">
                            <th class="w-10px pe-2">
                                <div class="form-check form-check-sm form-check-custom form-check-solid me-3">
                                    <input class="form-check-input" type="checkbox" data-kt-check="true" data-kt-check-target="#kt_table_milestone .form-check-input" value="1" />
                                </div>
                            </th>
                            <th class="min-w-125px">ID</th>
                            <th class="min-w-175px">NAME</th>
                            <th class="min-w-125px">CLASS</th>
                            <th class="min-w-125px">ASSIGNMENT</th>
                            <th class="min-w-125px">WEIGHT</th>       
                            <th class="min-w-125px">MAX LOC</th> 
                            <th class="min-w-125px">TEAM SHARE</th> 
                            <th class="min-w-125px">STATUS</th>

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
<!--add subject-->
<div class="modal fade" id="addClassEval" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Class Eval Criteria</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="kt_modal_add_user_form" class="form" action="/evalCriteria/classEvalCriteria/list" method="post">
                <div class="modal-body">
                    <input hidden type="text" name="action" value="create" />

                    <div class="card-body p-9">
                        <div class="row mb-6">

                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Criteria Name</label>

                            <div class="col-lg-8 fv-row">
                                <input type="text" name="criteria_name"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>

                        </div>
                        <div class="row mb-6">

                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Assignment</label>

                            <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Assignment"
                                aria-hidden="true" name="criteria_assign">
                                <c:forEach items="${requestScope.assigns}" var="u">
                                    <option value="${u.assId}">
                                        ${u.title}
                                    </option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="row mb-6">
                            <label class="col-lg-4 col-form-label fw-bold fs-6">Description</label>
                            <div class="col-lg-8 fv-row">
                                <textarea name="criteria_description"  class="form-control" id="description" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="row mb-6">
                             <label class="col-lg-4 col-form-label required fw-bold fs-6">Team Eval</label>
                            <div class="d-flex fw-bold h-100">
                                <div class="form-check form-check-custom form-check-solid me-9">
                                    <input class="form-check-input" type="radio" value="1" name="criteria_team"/>
                                    <label class="form-check-label ms-3" for="email">Yes</label>
                                </div>
                                <div class="form-check form-check-custom form-check-solid">
                                    <input class="form-check-input" type="radio" value="0" name="criteria_team" checked="checked" />
                                    <label class="form-check-label ms-3" for="phone">No</label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-6">

                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Eval weight</label>

                            <div class="col-lg-8 fv-row">
                                <input type="text" name="criteria_weight"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>

                        </div>

                        <div class="row mb-6">

                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Max LOC</label>

                            <div class="col-lg-8 fv-row">
                                <input type="text" name="criteria_loc"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit">
                            <span class="indicator-label">Add</span>
                            <span class="indicator-progress">Please wait...
                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button>
                        <button type="reset" class="btn btn-white me-3" data-kt-users-modal-action="cancel">Discard</button>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
