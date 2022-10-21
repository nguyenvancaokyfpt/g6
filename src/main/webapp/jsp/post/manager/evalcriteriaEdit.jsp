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
                            <form method="get" action="/evalCriteria/evalCriteriaDetails" class="form">
                                <!-- action -->
                                <input type="text" name="action" class="d-none" value="doUpdate">
                                <!--begin::Card body-->
                                <div class="card-body p-9">
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Criteria Name
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input id="test" type="text" class="form-control form-control-solid"
                                                name="criteria_name" placeholder="Type Criterial Name"
                                                value="${requestScope.eval.name}" required />
                                            <!-- store ID to submit -->
                                            <input type="text" name="criteria_id" class="d-none"
                                                value="${requestScope.eval.id}">
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Subject
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <select class="form-select" name="criteria_subject" id="subSelect" onchange="getSub()">
                                                <c:forEach items="${requestScope.subjects}" var="s">
                                                    <option value="${s.subjectId}" <c:if
                                                        test="${s.subjectId == requestScope.sub.subjectId}">selected
                                                        </c:if>
                                                        >${s.subjectName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Assignment
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="text" class="d-none" id="assSelected"
                                                value="${requestScope.assign.assId}">
                                            <select class="form-select" name="criteria_assign" id="assSelect" required>
                                               
                                            </select>
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
                                            <textarea name="criteria_description"
                                                class="form-control form-control-solid h-200px "
                                                placeholder="Type something for description.....">${requestScope.eval.description}</textarea>
                                        </div>
                                        <!--begin::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Team Eval
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9">
                                            <div class="d-flex fw-bold">
                                                <div class="form-check form-check-custom form-check-solid me-9">
                                                    <input class="form-check-input" type="radio" value="1"
                                                        name="criteria_team" <c:if
                                                        test="${requestScope.eval.isTeam ==1}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="email">Group</label>
                                                </div>
                                                <div class="form-check form-check-custom form-check-solid">
                                                    <input class="form-check-input" type="radio" value="0"
                                                        name="criteria_team" <c:if
                                                        test="${requestScope.eval.isTeam ==0}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="phone">Individual</label>
                                                </div>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Eval Weight
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="number" min="1" max="100"
                                                class="form-control form-control-solid" name="criteria_weight"
                                                placeholder="Type number of weight (%)"
                                                value="${requestScope.eval.weight}" required />
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Max LOC
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9 fv-row">
                                            <input type="number" class="form-control form-control-solid"
                                                name="criteria_loc" placeholder="Type Criterial Name"
                                                value="${requestScope.eval.maxLoc}" required />
                                        </div>
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row mb-8">
                                        <!--begin::Col-->
                                        <div class="col-xl-3">
                                            <div class="fs-6 fw-bold mt-2 mb-3">Status
                                                <span class="text-danger">*</span>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-xl-9">
                                            <div class="d-flex fw-bold">
                                                <div class="form-check form-check-custom form-check-solid me-9 ">
                                                    <input class="form-check-input" type="radio" value="1"
                                                        name="criteria_status" <c:if
                                                        test="${requestScope.eval.status ==1}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="email">Active</label>
                                                </div>
                                                <div class="form-check form-check-custom form-check-solid ">
                                                    <input class="form-check-input" type="radio" value="0"
                                                        name="criteria_status" <c:if
                                                        test="${requestScope.eval.status ==0}">checked</c:if> />
                                                    <label class="form-check-label ms-3" for="phone">Deactivate</label>
                                                </div>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                    </div>
                                    <!--end::Row-->
                                </div>
                                <!--end::Card body-->
                                <!--begin::Card footer-->
                                <div class="card-footer d-flex justify-content-center py-6 px-9">
                                    <a type="submit" href="evalCriteria/evalCriteriaList" class="btn btn-secondary mx-5">Cancel</a>
                                    <button type="submit" class="btn btn-primary mx-5">Update</button>
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
            </div>
            <!--end::Layout-->
        </div>
        <!--end::Container-->
    </div>