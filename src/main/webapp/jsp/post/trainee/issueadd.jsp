<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <!--begin::Card-->
        <div class="card">
            <!--begin::Card header-->
            <div class="card-header">
                <!--begin::Card title-->
                <div class="card-title fs-3 fw-bolder">Add New Issue</div>
                <!--end::Card title-->
            </div>
            <!--end::Card header-->
            <!--begin::Form-->
            <form id="addForm" method="get" action="team/detail" class="form">
                <!--begin::Card body-->
                <div class="card-body p-9">
                    <!--begin::Row-->
                    <div class="row mb-8 justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3"> Milestone
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <select name="issue_mile" onchange="getTeam()" id="iterMilestone" class="form-select">
                                <% 
                                    boolean flag = false;
                                %>
                                <c:forEach items="${requestScope.miles}" var="m">
                                    <c:if test="${m.statusId == 2}">
                                        <% 
                                            flag = true;
                                        %>
                                        <option value="${m.milestoneId}">${m.title} - ${m.classCode}</option>
                                    </c:if>
                                </c:forEach>
                                    <c:if test="<%= !flag%>"><option value="-1">Empty Milestone</option></c:if>
                            </select>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">Team
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <select name="issue_team" onchange="getAssignee()" id="iterTeam" class="form-select">
                            </select>
                        </div>
                        <!--end::Col-->
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row mb-8 justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3"> Asignee
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <select name="issue_assignee" id="iterAssignee"  class="form-select">
                            </select>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">Title
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input id="issueTitle" name="issue_title" type="text" class="form-control" placeholder="Issue Title" />
                        </div>
                        <!--end::Col-->
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row mb-8 justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3"> Git url
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input id="issueUrl" name="issue_url" type="text" class="form-control" placeholder="https://gitlab.com/..." />
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">Status
                                <span class=" text-danger">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <select id="issueStatus" name="issue_status" class="form-select" aria-label="Select example">
                                <option value="3">To do</option>
                                <option value="4">Doing</option>
                                <option value="5">Done</option>
                            </select>
                        </div>
                        <!--end::Col-->
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">Team Description</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-8 fv-row">
                            <textarea name="issue_description" id="issueDescription"
                                      class="form-control form-control-solid h-200px "
                                      placeholder="Type something for description....."></textarea>
                        </div>
                        <!--begin::Col-->
                    </div>
                    <!--end::Row-->
                </div>
                <!--end::Card body-->
                <!--begin::Card footer-->
                <div class="card-footer d-flex justify-content-center py-6 px-9">
                    <button  type="button" id="btnClear" class="btn btn-secondary ">Clear</button>
                    <button onclick="createIssue()" type="button" class="btn btn-primary mx-5">Add</button>
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