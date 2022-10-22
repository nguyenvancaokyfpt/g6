<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container">
            <!--begin::Layout-->
            <div class="d-flex flex-column flex-xl-row">
                <!--begin::Content-->
                <div class="post d-flex flex-column-fluid" id="kt_post">
                    <!--begin::Container-->
                    <div id="kt_content_container" class="container">
                        <!--begin::Card-->
                        <div class="card">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <!--begin::Card title-->
                                <div class="card-title fs-3 fw-bolder">Eval Criteria Details</div>
                                <!--end::Card title-->
                            </div>
                            <!--end::Card header-->
                            <!--begin::Form-->
                            <form method="post" action="evalCriteria/evalCriteriaList?action=update" class="form">
                                <!--begin::Card body-->
                                <div class="card-body p-9">
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Criteria Name</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                value="${requestScope.eval.name}" />
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Subject</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                value="${requestScope.sub.subjectName}" />
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
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                value="${requestScope.assign.title}" />
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Criteria Description</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <textarea class="form-control form-control-solid h-200px itemShow"
                                                disabled>${requestScope.eval.description}</textarea>
                                        </div>
                                        <!--begin::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Team Eval</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9">
                                            <div class="d-flex fw-bold">
                                                <input type="text" class="form-control form-control-solid itemShow"
                                                    disabled <c:if test="${requestScope.eval.isTeam ==1}">value="Group"
                                                </c:if>
                                                <c:if test="${requestScope.eval.isTeam ==0}">value="Individual"</c:if>
                                                />
                                            </div>
                                            <!--end::Col-->
                                        </div>
                                        <!--end::Row-->

                                    </div>
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Eval Weight</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                value="${requestScope.eval.weight}" />
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
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                value="${requestScope.eval.maxLoc}" />
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Status</div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9">
                                            <div class="d-flex fw-bold">
                                                <div
                                                    class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                                    <input class="form-check-input" type="radio" value="1"
                                                        name="criteria_status" <c:if
                                                        test="${requestScope.eval.status ==1}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="email">Active</label>
                                                </div>
                                                <div class="form-check form-check-custom form-check-solid itemHidden">
                                                    <input class="form-check-input" type="radio" value="0"
                                                        name="criteria_status" <c:if
                                                        test="${requestScope.eval.status ==0}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="phone">Inactive</label>
                                                </div>
                                            </div>
                                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                                <c:if test="${requestScope.eval.status ==1}">value="Active"
                                            </c:if>
                                            <c:if test="${requestScope.eval.status ==0}">value="Inactive"</c:if>/>
                                        </div>
                                        <!--end::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--end::Card body-->
                            </form>
                            <!--end:Form-->
                        </div>
                        <!--end::Card-->
                    </div>
                    <!--end::Container-->
                </div>
                <!--end::Content-->
            </div>
            <!--end::Layout-->
        </div>
        <!--end::Container-->
    </div>