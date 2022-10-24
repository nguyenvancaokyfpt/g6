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
            <form method="post" action="assignment/list?action=create" class="form">
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
                            <input type="text" required class="form-control form-control-solid"
                                   name="name" placeholder="Type Assignment Name"/>
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
                            <select class="form-select" name="subjectId">
                                <c:forEach items="${requestScope.subjects}" var="s">
                                    <option value="${s.subjectId}">
                                        ${s.subjectName}
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
                            <div class="fs-6 fw-bold mt-2 mb-3">Assignment Description</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9 fv-row">
                            <textarea required name="description"
                                      class="form-control form-control-solid h-200px"
                                      placeholder="Type something for description....."></textarea>
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
                                <div class="form-check form-check-custom form-check-solid me-9">
                                    <input class="form-check-input" checked type="radio" value="1" name="teamwork"/>
                                    <label class="form-check-label ms-3">Group</label>
                                </div>
                                <div class="form-check form-check-custom form-check-solid">
                                    <input class="form-check-input" type="radio" value="0" name="teamwork"/>
                                    <label class="form-check-label ms-3">Individual</label>
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
                            <div class="fs-6 fw-bold mt-2 mb-3">Assignment Weight</div>
                        </div>
                        <!--end::Col-->
                        <!--begin::Col-->
                        <div class="col-xl-9 fv-row">
                            <input required type="number" min="1" max="100"
                                   class="form-control form-control-solid" name="evalWeight"
                                   placeholder="Type number of weight (%)"/>
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
                                <div class="form-check form-check-custom form-check-solid me-9">
                                    <input class="form-check-input" checked type="radio" value="1" name="ongoing"/>
                                    <label class="form-check-label ms-3">On-Going</label>
                                </div>
                                <div class="form-check form-check-custom form-check-solid">
                                    <input class="form-check-input" type="radio" value="0" name="ongoing"/>
                                    <label class="form-check-label ms-3">Finished</label>
                                </div>
                            </div>
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
                                <div class="form-check form-check-custom form-check-solid me-9">
                                    <input class="form-check-input" checked type="radio" value="1" name="status"/>
                                           <label class="form-check-label ms-3">Active</label>
                                    </div>
                                    <div class="form-check form-check-custom form-check-solid">
                                        <input class="form-check-input" type="radio" value="0" name="status"/>
                                        <label class="form-check-label ms-3">Inactive</label>
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
                    <button type="submit" class="btn btn-primary mx-5">Create</button>
                    <button type="button" onclick="history.back()" class="btn btn-secondary">Cancel</button>
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