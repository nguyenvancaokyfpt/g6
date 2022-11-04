<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .userMember {
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
                <div class="card-title fs-3 fw-bolder">User Details</div>
                <!--end::Card title-->
            </div>
            <!--end::Card header-->
            <!--begin::Form-->
            <form method="get" action="user/detail" class="form">
                <input type="text" class="d-none" name="action" value="update">
                <!--begin::Card body-->
                <div class="card-body p-9">
                    <!--begin::Row-->
                    <div class="row mb-8 justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3"> Full Name
                                <span class="itemHidden text-danger itemHiddenInline">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.user.fullname}" />
                            <input id="userName" type="text" class="form-control form-control-solid itemHidden"
                                   name="user_project" placeholder="Type User Name"
                                   value="${requestScope.user.fullname}" required />
                            <!-- store ID to submit -->
                            <input id="userId" type="text" name="user_id" class="d-none" value="${requestScope.user.userId}">
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">Role
                                <span class="itemHidden text-danger itemHiddenInline">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.user.role.title}" />
                            <select id="userRole" class="form-select form-select-solid itemHidden" aria-label="Select example">
                                <c:forEach items="${requestScope.roles}" var="r">
                                    <option value="${r.id}" <c:if test="${r.id == user.role.id}">selected</c:if> >${r.title}</option>
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
                            <div class="fs-6 fw-bold mt-2 mb-3"> Email
                                <span class="itemHidden text-danger itemHiddenInline">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input id="userEmail" type="text" class="form-control form-control-solid itemHidden"
                                   name="user_topicName" placeholder="Type Criterial Name"
                                   value="${requestScope.user.email}" required />
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.user.email}" />
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">mobile
                                <span class="itemHidden text-danger itemHiddenInline">*</span>
                            </div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-3 fv-row">
                            <input type="text" class="form-control form-control-solid itemShow" disabled
                                   value="${requestScope.user.mobile}" />
                            <input id="userMobile" type="text" class="form-control form-control-solid itemHidden"
                                   name="user_topicCode" placeholder="Type mobile"
                                   value="${requestScope.user.mobile}" required />
                        </div>
                        <!--end::Col-->
                    </div>
                    <!--end::Row-->
                    <!--begin::Row-->
                    <div class="row mb-8 justify-content-center">
                        <!--begin::Col-->
                        <div class="col-xl-2">
                            <div class="fs-6 fw-bold mt-2 mb-3">User Note</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-8 fv-row">
                            <textarea id="userNote" name="user_description"
                                      class="form-control form-control-solid h-200px itemHidden"
                                      placeholder="Type something about user.....">${requestScope.user.note}</textarea>
                            <textarea class="form-control form-control-solid h-200px itemShow"
                                      disabled>${requestScope.user.note}</textarea>
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
                                    <input id="userStatus" class="form-check-input" type="radio" value="1" name="user_status" <c:if
                                               test="${requestScope.user.statusId ==1}">checked</c:if> />
                                           <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div style="display: none;"
                                         class="form-check form-check-custom form-check-solid itemHidden">
                                        <input class="form-check-input" type="radio" value="0" name="user_status" <c:if
                                               test="${requestScope.user.statusId ==0}">checked</c:if> />
                                           <label class="form-check-label ms-3" for="phone">Inactive</label>
                                    </div>
                                </div>
                                <input type="text" class="form-control form-control-solid itemShow" disabled <c:if
                                       test="${requestScope.user.statusId ==1}">value="Active"</c:if>
                                   <c:if test="${requestScope.user.statusId ==0}">value="Inactive"</c:if>/>
                        </div>
                        <!--end::Col-->
                        <div class="col-xl-5"></div>
                    </div>
                    <!--end::Row-->

                </div>
                <!--end::Card body-->
                <!--begin::Card footer-->
                <div class="card-footer d-flex justify-content-center py-6 px-9">
                    <button onclick="showItem()" id="btnShow" type="button" class="btn btn-secondary itemShow" >
                        Edit user </button>
                    <button onclick="hideItem()" type="button" id="btnHide" class="btn btn-secondary itemHidden">Cancel</button>
                    <button type="button" class="btn btn-primary mx-5 itemHidden" onclick="update()">Update</button>
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