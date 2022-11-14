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
                <form method="post" action="/management/user/detail" class="form">
                    <input type="text" class="d-none" name="action" value="create">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Full Name
                                    <span class="text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input name="user_name" placeholder="Type User Full Name" type="text" class="form-control" required/>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Role
                                    <span class="text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <select name="user_role" class="form-select" aria-label="Select example">
                                    <c:forEach items="${requestScope.roles}" var="r">
                                        <option value="${r.id}">${r.title}</option>
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
                                    <span class="text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input name="user_email" type="email" class="form-control" name="user_topicName"
                                    placeholder="Type User Email" required />

                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Mobile
                                    <span class="text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input name="user_mobile" placeholder="Type User Mobile" type="number" class="form-control" required/>
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
                                <textarea name="user_note" id="userNote" name="user_description" class="form-control h-200px"
                                    placeholder="Type something about user....."></textarea>
                            </div>
                            <!--begin::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Status
                                    <span class="text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="d-flex fw-bold">
                                    <div class="form-check form-check-custom me-9">
                                        <input id="userStatus" class="form-check-input" type="radio" value="1"
                                            name="user_status" checked />
                                        <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div class="form-check form-check-custom">
                                        <input class="form-check-input" type="radio" value="0" name="user_status" />
                                        <label class="form-check-label ms-3" for="phone">Inactive</label>
                                    </div>
                                </div>
                            </div>
                            <!--end::Col-->
                            <div class="col-xl-5"></div>
                        </div>
                        <!--end::Row-->

                    </div>
                    <!--end::Card body-->
                    <!--begin::Card footer-->
                    <div class="card-footer d-flex justify-content-center py-6 px-9">
                        <button  type="reset" id="btnClear"
                            class="btn btn-secondary">Clear</button>
                        <button type="submit" class="btn btn-primary mx-5" >Add</button>
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