 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--begin::Content-->
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container">
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card header-->
                <div class="card-header">
                    <!--begin::Card title-->
                    <div class="card-title fs-3 fw-bolder">Class Eval Criteria Details</div>
                    <!--end::Card title-->
                </div>
                <!--end::Card header-->
                 <c:set var="s" value="${requestScope.eval}" />
                <!--begin::Form-->
                <form id="kt_modal_update_eval_form" method="post" action="/evalCriteria/classEvalCriteria/list?action=update" class="form">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Criteria ID</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                       name="criteria_id" readonly value="${s.id}" />
                                <input type="text" class="form-control form-control-solid itemShow" readonly disabled
                                   value="${s.id}" />
                            </div>
                        </div>
                        <!--end::Row-->
                          <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Criteria Name</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                       name="criteria_name"  value="${s.name}" />
                                <input type="text" class="form-control form-control-solid itemShow" readonly disabled
                                   value="${s.name}" />
                            </div>
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Assignment</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Assignment"
                                aria-hidden="true" name="criteria_assign">
                                <c:forEach items="${requestScope.assigns}" var="u">
                                    <option value="${u.assId}" ${u.assId==s.assign? 'selected ':''}>
                                        ${u.title}
                                    </option>
                                </c:forEach>
                            </select>
                            </div>
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Description</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <textarea name="criteria_description"
                                    class="form-control form-control-solid h-200px itemHidden"
                                    maxlength="100"
                                    placeholder="Type something for description....."> ${s.description}</textarea>
                                <textarea class="form-control form-control-solid h-200px itemShow"
                                    disabled> ${s.description}</textarea>
                            </div>
                            <!--begin::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Team Eval</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9">
                                <div class="d-flex fw-bold">
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="criteria_team"
                                            <c:if test="${s.isTeam==1}">checked</c:if> />
                                        <label class="form-check-label ms-3">Group</label>
                                    </div>
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="1" name="criteria_team"
                                            <c:if test="${s.isTeam==0}">checked</c:if> />
                                        <label class="form-check-label ms-3">Individual</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled 
                                <c:if test="${s.isTeam ==1}">value="Group"</c:if>
                                <c:if test="${s.isTeam ==0}">value="Individual"</c:if>
                               />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                         <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Eval Weight</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                       name="criteria_weight"  value="${s.weight}" />
                                <input type="text" class="form-control form-control-solid itemShow" readonly disabled
                                   value="${s.weight}" />
                            </div>
                        </div>
                        <!--end::Row-->
                         <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Max LOC</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                       name="criteria_loc"  value="${s.maxLoc}" />
                                <input type="text" class="form-control form-control-solid itemShow" readonly disabled
                                   value="${s.maxLoc}" />
                            </div>
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Status</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9">
                                <div class="d-flex fw-bold">
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="criteria_status"
                                            <c:if test="${s.status==0}">checked</c:if> />
                                        <label class="form-check-label ms-3">Active</label>
                                    </div>
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="1" name="criteria_status"
                                            <c:if test="${s.status==1}">checked</c:if> />
                                        <label class="form-check-label ms-3">In Active</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled 
                                <c:if test="${s.status ==0}">value="Active"</c:if>
                                <c:if test="${s.status ==1}">value="In Active"</c:if>
                               />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                    </div>
                    <!--end::Card body-->
                    <!--begin::Card footer-->
                    <div class="card-footer d-flex justify-content-center py-6 px-9">
                        <button type="button" class="btn btn-secondary itemShow" onclick="showItem()">
                            Edit Milestone </button>
                        <button type="button" onclick="hideItem()" class="btn btn-secondary me-9 itemHidden">Cancel</button>
                           <button type="submit" class="btn btn-primary itemHidden" data-kt-users-modal-action="submit">
                                                <span class="indicator-label">Update</span>
                                                <span class="indicator-progress">Please wait...
                                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                            </button>
                    </div>
                    <!--end::Card footer-->
                </form>
                <!--end:Form-->
            </div>
            <!--end::Card-->
        </div>
        <!--end::Container-->
    </div>
    <!--end::Content-->