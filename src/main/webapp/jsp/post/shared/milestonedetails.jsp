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
                    <div class="card-title fs-3 fw-bolder">Milestone Details</div>
                    <!--end::Card title-->
                </div>
                <!--end::Card header-->
                 <c:set var="s" value="${requestScope.milestoneDetails}" />
                <!--begin::Form-->
                <form id="kt_modal_update_form" method="post" action="milestone/list?action=update" class="form">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Milestone ID</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden"
                                       name="milestoneId" readonly value="${s.milestoneId}" />
                                <input type="text" class="form-control form-control-solid itemShow" readonly disabled
                                   value="${s.milestoneId}" />
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
                                <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Subject"
                                aria-hidden="true" name="subjectId">
                                <c:forEach items="${requestScope.subjectList}" var="u">
                                    <option value="${u.subjectId}" ${u.subjectId==s.subjectId? 'selected ':''}>
                                        ${u.subjectCode}
                                    </option>
                                </c:forEach>
                            </select>
                            </div>
                        </div>
                        <!--end::Row-->
<!--                         begin::Row
                        <div class="row mb-8">
                            begin::Col
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Assignment</div>
                            </div>
                            end::Col
                            begin::Col
                            <div class="col-xl-9 fv-row">
                                <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Assignment"
                                aria-hidden="true" name="assId">
                          <%--      <c:forEach items="${requestScope.classList}" var="u">
                                    <option value="${u.id}">
                                        ${u.classCode}
                                    </option>
                                      </c:forEach> --%>
                            </select>
                            </div>
                        </div>
                        end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Class Code</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <select
                                class="form-select form-select-solid fw-bolder"
                                data-kt-select2="true" data-placeholder="Select Class"
                                aria-hidden="true" name="classId">
                                   <c:forEach items="${requestScope.classList}" var="u">
                                    <option value="${u.id}" ${u.id==s.classId? 'selected ':''}>
                                        ${u.classCode}
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
                                <div class="fs-6 fw-bold mt-2 mb-3">From Date</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                 <input type="date" class="form-control form-control-solid itemHidden" name="fromDate" 
                                        value="${s.fromDate}">
                                  <input type="date" class="form-control form-control-solid itemShow" disabled
                                    value="${s.fromDate}" />
                            </div>
                        </div>
                        <!--end::Row-->
                              <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">To Date</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                 <input type="date" class="form-control form-control-solid itemHidden" name="toDate" value="${s.toDate}">
                              <input type="date" class="form-control form-control-solid itemShow" disabled
                                    value="${s.toDate}"/>
                            </div>
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Title</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                 <input type="text" class="form-control form-control-solid itemHidden" name="title" value="${s.title}">
                        <input type="text" class="form-control form-control-solid itemShow" disabled
                                  value="${s.title}"/>
                            </div>
                        </div>
                        <!--end::Row-->
                            <!--begin::Row-->
                        <div class="row mb-8">
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="fs-6 fw-bold mt-2 mb-3">Assignment Body</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9 fv-row">
                                <input type="text" class="form-control form-control-solid itemHidden" name="assBody" value="${s.assBody}">
                              <input type="text" class="form-control form-control-solid itemShow" disabled
                                  value="${s.assBody}"/>  
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
                                <textarea name="description"
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
                                <div class="fs-6 fw-bold mt-2 mb-3">Status</div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-9">
                                <div class="d-flex fw-bold">
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="statusId"
                                            <c:if test="${s.statusId==0}">checked</c:if> />
                                        <label class="form-check-label ms-3">Active</label>
                                    </div>
                                    <div style="display: none;" class="form-check form-check-custom form-check-solid me-9 itemHidden">
                                        <input class="form-check-input" type="radio" value="1" name="statusId"
                                            <c:if test="${s.statusId==1}">checked</c:if> />
                                        <label class="form-check-label ms-3">In Active</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled 
                                <c:if test="${s.statusId ==0}">value="Active"</c:if>
                                <c:if test="${s.statusId ==1}">value="In Active"</c:if>
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