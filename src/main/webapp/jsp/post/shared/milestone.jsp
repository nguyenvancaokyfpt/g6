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
                     <input type="text" data-kt-milestone-table-filter="search" class="form-control form-control-solid w-250px ps-14" placeholder="Search" />
                    </div>
                    <!--end::Search-->
                </div>
                <!--begin::Card title-->
                <!--begin::Card toolbar-->
                <div class="card-toolbar">
                    <!--begin::Toolbar-->
                    <div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
                        <!--begin::Filter-->
                      
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addMilestone">
                            Add Milestone
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
                <table class="table align-middle table-row-dashed fs-6 gy-5" id="kt_table_milestone">
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
                            <th class="min-w-125px">MILESTONE NAME</th>
                            <th class="min-w-125px">CLASS</th>
                            <th class="min-w-125px">FROM DATE</th>                           
                            <th class="min-w-125px">TO DATE</th>
                            <th class="min-w-125px">ASSIGNMENT TITLE</th>                           
                            <th class="min-w-125px">STATUS</th>
                            <th class="text-end min-w-100px">ACTION</th>
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
<div class="modal fade" id="addMilestone" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Milestone</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="kt_modal_add_user_form" class="form" action="/milestone/list" method="post">
                <div class="modal-body">
                    <input hidden type="text" name="action" value="create" />
                    <!--begin::Card body-->
                    <div class="card-body border-top p-9">
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Assignment</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <select
                                id="assId"
                                class="form-select form-select-solid fw-bolder"
                                data-placeholder="Select Assigment"
                                name="assId">

                                <c:forEach items="${requestScope.assignmentDetails}" var="u">
                                    <option value="${u.assId}">
                                        ${u.title}
                                    </option>
                                </c:forEach>
                            </select>
                            <select
                                hidden
                                id="assId2"
                                class="form-select form-select-solid fw-bolder"
                                data-placeholder="Select Assigment"
                                name="assId">

                                <c:forEach items="${requestScope.assignmentDetails}" var="u">
                                    <option value="${u.assId}">
                                        ${u.assBody}
                                    </option>
                                </c:forEach>
                            </select>

                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Class Code</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Class"
                                aria-hidden="true" name="classId">
                                <c:forEach items="${requestScope.classList}" var="u">
                                    <option value="${u.id}">
                                        ${u.classCode}
                                    </option>
                                </c:forEach>
                            </select>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label required fw-bold fs-6">From Date</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <div class="col-lg-8 fv-row">
                                <input type="date" name="fromDate"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label required fw-bold fs-6">To Date</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <div class="col-lg-8 fv-row">
                                <input type="date" id="input_to_date" name="toDate"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label required fw-bold fs-6">Title</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <div class="col-lg-8 fv-row">
                                <input type="text" name="title"
                                       class="form-control form-control-lg form-control-solid"
                                       />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-6">
                            <!--begin::Label-->
                            <label class="col-lg-4 col-form-label fw-bold fs-6">Description</label>
                            <!--end::Label-->
                            <!--begin::Col-->
                            <div class="col-lg-8 fv-row">
                                <textarea name="description"  class="form-control" id="description" rows="3"></textarea>
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                    </div>
                    <!--end::Card body-->
                    <!--begin::Actions-->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit">
                            <span class="indicator-label">Add</span>
                            <span class="indicator-progress">Please wait...
                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button>
                        <button type="reset" class="btn btn-white me-3" data-kt-users-modal-action="cancel">Discard</button>
                    </div>
                    <!--end::Actions-->
                </div>
            </form>
        </div>
    </div>
</div>

<script>

    function inputChange(event) {
        let assId2 = document.getElementById('assId2');
        let max = assId2.options.length;
         
        for (var i = 0; i < max; i++) {
            if (event.path[0].value === assId2.options[i].value)
                document.getElementById("description").value = assId2.options[i].text;
          
        }
    }
    let assId = document.getElementById('assId');
    assId.addEventListener('change', inputChange);
</script>