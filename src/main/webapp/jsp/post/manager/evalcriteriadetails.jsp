<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        .teamMember {
            width: 160px;
            height: 64px;
        }
    </style>
    <input type="text" class="d-none" id="toastStatus" value="${requestScope.toast}">
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
                <form  method="get" action="/evalCriteria/evalCriteriaDetails" class="form">
                    <!-- action -->
                    <input type="text" name="action" class="d-none" value="doUpdate">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Criteria Name
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow"
                                    value="${requestScope.eval.name}" />
                                <input type="text" class="form-control itemHidden"
                                    name="criteria_name" placeholder="Type Criterial Name"
                                    value="${requestScope.eval.name}" required />
                                <!-- store ID to submit -->
                                <input type="text" name="criteria_id" class="d-none" value="${requestScope.eval.id}">
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Subject
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.sub.subjectName}" />
                                <select class="form-select itemHidden" name="criteria_subject" id="subSelect"
                                    onchange="getSub()">
                                    <c:forEach items="${requestScope.subjects}" var="s">
                                        <option value="${s.subjectId}" <c:if
                                            test="${s.subjectId == requestScope.sub.subjectId}">selected
                                            </c:if>
                                            >${s.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Assignment
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="d-none" id="assSelected"
                                                value="${requestScope.assign.assId}">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.assign.title}" />
                                <select class="form-select itemHidden" name="criteria_assign" id="assSelect" required>

                                </select>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Eval Weight
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.eval.weight}" />
                                <input type="number" min="1" max="100"
                                    class="form-control itemHidden" name="criteria_weight"
                                    placeholder="Type number of weight (%)" value="${requestScope.eval.weight}"
                                    required />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Max LOC
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.eval.maxLoc}" />
                                <input type="number" min="0" class="form-control itemHidden"
                                    name="criteria_loc" placeholder="Type Criterial Name"
                                    value="${requestScope.eval.maxLoc}" required />
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Team Eval
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <div class="d-flex fw-bold">
                                    <div style="display: none;"
                                        class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input id="userStatus" class="form-check-input" type="radio" value="1"
                                            name="criteria_team" <c:if test="${requestScope.eval.isTeam ==1}">checked
                                        </c:if> />
                                        <label class="form-check-label ms-3" for="email">Group</label>
                                    </div>
                                    <div style="display: none;"
                                        class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="criteria_team" <c:if
                                            test="${requestScope.eval.isTeam ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Individual</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control itemShow" disabled <c:if
                                    test="${requestScope.eval.isTeam ==1}">value="Group"</c:if>
                                <c:if test="${requestScope.eval.isTeam ==0}">value="Individual"</c:if>/>
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->

                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Team Description</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-8 fv-row">
                                <textarea name="criteria_description"
                                class="form-control h-200px itemHidden"
                                placeholder="Type something for description.....">${requestScope.eval.description}</textarea>
                                <textarea class="form-control form-control-solid h-200px itemShow"
                                    disabled>${requestScope.eval.description}</textarea>
                            </div>
                            <!--begin::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Status
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="d-flex fw-bold">
                                    <div style="display: none;"
                                        class="form-check form-check-custom me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="1" name="criteria_status" <c:if
                                            test="${requestScope.eval.status ==1}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div style="display: none;"
                                        class="form-check form-check-custom itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="criteria_status" <c:if
                                            test="${requestScope.eval.status ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Inactive</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control itemShow" disabled <c:if
                                    test="${requestScope.eval.status ==1}">value="Active"</c:if>
                                <c:if test="${requestScope.eval.status ==0}">value="Inactive"</c:if>/>
                            </div>
                            <!--end::Col-->
                            <div class="col-xl-5"></div>
                        </div>
                        <!--end::Row-->
                    </div>
                    <!--end::Card body-->
                    <!--begin::Card footer-->
                    <div class="card-footer d-flex justify-content-center py-6 px-9">
                        <button onclick="showItem()" id="btnShow" type="button" class="btn btn-secondary itemShow">
                            Edit team </button>
                        <button onclick="hideItem()" type="button" id="btnHide"
                            class="btn btn-secondary itemHidden">Cancel</button>
                        <button type="submit" class="btn btn-primary mx-5 itemHidden"
                            onclick="saveAll()">Update</button>
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