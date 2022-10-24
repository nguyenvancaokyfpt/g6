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
                <div class="card-title fs-3 fw-bolder">Assignment Details</div>
                <!--end::Card title-->
            </div>
            <!--end::Card header-->
            <!--begin::Form-->
            <form method="post" action="assignment/list?action=update" class="form">
                <!--begin::Card body-->
                <div class="card-body p-9">
                    <!--begin::Row-->
                    <div class="row mb-8">
                        <!--begin::Col-->
                        <div class="col-xl-3">
                            <div class="fs-6 fw-bold mt-2 mb-3">Assignment Name</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9 fv-row">
                            <input type="text" class="form-control form-control-solid itemHidden"
                                   name="assign_name" placeholder="Type Criterial Name"
                                   value="${requestScope.assign.title}" />
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.assign.title}" />
                            <!-- store ID to submit -->
                            <input type="text" name="assign_id" class="d-none" value="${requestScope.assign.assId}">
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
                                   value="${requestScope.assign.subjectName}" />
                            <select class="form-select itemHidden" name="assign_subject">
                                <c:forEach items="${requestScope.subjects}" var="s">
                                    <option value="${s.subjectId}" <c:if test="${s.subjectId == requestScope.assign.subjectId}">
                                            selected</c:if>
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
                            <div class="fs-6 fw-bold mt-2 mb-3">Assignment Description</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9 fv-row">
                            <textarea name="assign_description"
                                      class="form-control form-control-solid h-200px itemHidden"
                                      placeholder="Type something for description.....">${requestScope.assign.assBody}</textarea>
                            <textarea class="form-control form-control-solid h-200px itemShow"
                                      disabled>${requestScope.assign.assBody}</textarea>
                        </div>
                        <!--begin::Col-->
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row mb-8">
                        <!--begin::Col-->
                        <div class="col-xl-3">
                            <div class="fs-6 fw-bold mt-2 mb-3">Team Work</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9">
                            <div class="d-flex fw-bold">
                                <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                    <input class="form-check-input" type="radio" value="1" name="assign_team"
                                           <c:if test="${requestScope.assign.isTeamwork ==1}">checked</c:if> />
                                           <label class="form-check-label ms-3" for="email">Group</label>
                                    </div>
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="assign_team"
                                        <c:if test="${requestScope.assign.isTeamwork ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Individual</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled <c:if
                                       test="${requestScope.assign.isTeamwork ==1}">value="Group"</c:if>
                                   <c:if test="${requestScope.assign.isTeamwork ==0}">value="Individual"</c:if> />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Assignment Weight</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="number" min="1" max="100"
                                       class="form-control form-control-solid itemHidden" name="assign_weight"
                                       placeholder="Type number of weight (%)" value="${requestScope.assign.evalWeight}" />
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.assign.evalWeight}" />
                        </div>
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row mb-8">
                        <!--begin::Col-->
                        <div class="col-xl-3">
                            <div class="fs-6 fw-bold mt-2 mb-3">On Going</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9">
                            <div class="d-flex fw-bold">
                                <div style="display: none;"  class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                    <input class="form-check-input" type="radio" value="1" name="assign_going"
                                           <c:if test="${requestScope.assign.isOngoing ==1}">checked</c:if> />
                                           <label class="form-check-label ms-3" for="email">On-Going</label>
                                    </div>
                                    <div  style="display: none;" class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="assign_going"
                                        <c:if test="${requestScope.assign.isOngoing ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Finished</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled <c:if
                                       test="${requestScope.assign.isOngoing ==1}">value="On-Going"</c:if>
                                   <c:if test="${requestScope.assign.isOngoing ==0}">value="Finished"</c:if>/>
                            </div>
                            <!--end::Col-->
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
                                        <input class="form-check-input" type="radio" value="1" name="assign_status"
                                        <c:if test="${requestScope.assign.statusId ==1}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="assign_status"
                                        <c:if test="${requestScope.assign.statusId ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Inactive</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled <c:if
                                       test="${requestScope.assign.statusId ==1}">value="Active"</c:if>
                                   <c:if test="${requestScope.assign.statusId ==0}">value="Inactive"</c:if>/>
                        </div>
                        <!--end::Col-->
                    </div>
                    <!--end::Row-->
                </div>
                <!--end::Card body-->
                <!--begin::Card footer-->
                <div class="card-footer d-flex justify-content-center py-6 px-9">
                    <button type="button" class="btn btn-secondary itemShow" onclick="showItem()">
                        Edit Assignment </button>
                    <button type="button" onclick="hideItem()" class="btn btn-secondary itemHidden">Cancel</button>
                    <button type="submit" class="btn btn-primary mx-5 itemHidden">Update</button>
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