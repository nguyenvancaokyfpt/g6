<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        .teamMember {
            width: 160px;
            height: 64px;
        }
    </style>
    <input type="text" class="d-none" id="going" value="${requestScope.going}">
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
                    <div class="card-title fs-3 fw-bolder">Team Details</div>
                    <!--end::Card title-->
                </div>
                <!--end::Card header-->
                <!--begin::Form-->
                <form id="myForm" method="get" action="team/detail" class="form">
                    <input type="text" class="d-none" name="action" value="update">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Class
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid" disabled
                                    value="${requestScope.team.className}" />
                                <!-- store ID to submit -->
                                <input id="classId" type="text" class="d-none" name="team_class"
                                    value="${requestScope.team.getClassId()}" />
                                <input id="mileId" type="text" class="d-none" name="team_mile"
                                    value="${requestScope.mile}" />
                                <input id="teamId" type="text" name="team_id" class="d-none"
                                    value="${requestScope.team.id}">
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Project Code
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.team.project_code}" />
                                <input type="text" class="form-control form-control-solid itemHidden"
                                    name="team_project" placeholder="Type Criterial Name"
                                    value="${requestScope.team.project_code}" required />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Topic Name
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                    name="team_topicName" placeholder="Type Criterial Name"
                                    value="${requestScope.team.topic_name}" required />
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.team.topic_name}" />
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Topic Code
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid itemShow" disabled
                                    value="${requestScope.team.topic_code}" />
                                <input type="text" class="form-control form-control-solid itemHidden"
                                    name="team_topicCode" placeholder="Type Criterial Name"
                                    value="${requestScope.team.topic_code}" required />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Team Member
                                    <span class="itemHidden text-danger itemHiddenInline">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-8 fv-row" id="teamMember">
                                <!-- <c:forEach items="${requestScope.team.listTrainee}" var="t" varStatus="loop">
                                    <button id="btnMem${t.userId}}" type="button"
                                        class="btn btn-secondary teamMember <c:if test="${loop.index > 3}">mt-1</c:if> ">
                                        ${t.fullname }<br>ID: ${t.userId}
                                    </button>
                                </c:forEach> -->
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
                                <textarea name="team_description"
                                    class="form-control form-control-solid h-200px itemHidden"
                                    placeholder="Type something for description.....">${requestScope.team.description}</textarea>
                                <textarea class="form-control form-control-solid h-200px itemShow"
                                    disabled>${requestScope.team.description}</textarea>
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
                                        class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="1" name="team_status" <c:if
                                            test="${requestScope.team.status_id ==1}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div style="display: none;"
                                        class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="team_status" <c:if
                                            test="${requestScope.team.status_id ==0}">checked</c:if> />
                                        <label class="form-check-label ms-3" for="phone">Inactive</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled <c:if
                                    test="${requestScope.team.status_id ==1}">value="Active"</c:if>
                                <c:if test="${requestScope.team.status_id ==0}">value="Inactive"</c:if>/>
                            </div>
                            <!--end::Col-->
                            <div class="col-xl-5"></div>
                        </div>
                        <!--end::Row-->

                    </div>
                    <!--end::Card body-->
                    <!--begin::Card footer-->
                    <div class="card-footer d-flex justify-content-center py-6 px-9">
                        <button id="btnShow" type="button" class="btn btn-secondary itemShow">
                            Edit team </button>
                        <button type="button" id="btnHide" class="btn btn-secondary itemHidden">Cancel</button>
                        <button type="button" class="btn btn-primary mx-5 itemHidden"
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