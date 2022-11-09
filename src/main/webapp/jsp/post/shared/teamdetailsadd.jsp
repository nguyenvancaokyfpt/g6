<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        .teamMember {
            width: 160px;
            height: 64px;
        }
    </style>
    <!--begin::Content-->
    <div class="post d-flex flex-column-fluid" id="kt_post">
        <!--begin::Container-->
        <div id="kt_content_container" class="container">
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card header-->
                <div class="card-header">
                    <!--begin::Card title-->
                    <div class="card-title fs-3 fw-bolder">Add New Team</div>
                    <!--end::Card title-->
                </div>
                <!--end::Card header-->
                <!--begin::Form-->
                <form method="get" action="team/detail" class="form">
                    <input type="text" class="d-none" name="action" value="create">
                    <input type="text" class="d-none" name="doing" value="doing">
                    <!--begin::Card body-->
                    <div class="card-body p-9">
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Class
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid " placeholder="Type Name"
                                    value="${requestScope.myClass.getClassCode()}" required disabled />
                                <input id="mileId" type="text" class="d-none" name="team_mile"
                                    value="${requestScope.mile}" />
                                <input type="text" id="team_class" class="d-none" value="${requestScope.myClass.id}"
                                    name="team_class">
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Project Code
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid " id="team_project"
                                    name="team_project" placeholder="Type Project Code" value="" required />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Topic Name
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid " id="team_topicName"
                                    name="team_topicName" placeholder="Type Topic Name" value="" required />
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Topic Code
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3 fv-row">
                                <input type="text" class="form-control form-control-solid " id="team_topicCode"
                                    name="team_topicCode" placeholder="Type Topic Code" value="" required />
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row mb-8 justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3"> Team Member
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-8 fv-row" id="teamMember">

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
                                <textarea name="team_description" id="team_description"
                                    class="form-control form-control-solid h-200px "
                                    placeholder="Type something for description....."></textarea>
                            </div>
                            <!--begin::Col-->
                        </div>
                        <!--end::Row-->
                        <!--begin::Row-->
                        <div class="row justify-content-center">
                            <!--begin::Col-->
                            <div class="col-xl-2">
                                <div class="fs-6 fw-bold mt-2 mb-3">Status
                                    <span class=" text-danger">*</span>
                                </div>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-xl-3">
                                <div class="d-flex fw-bold">
                                    <div class="form-check form-check-custom form-check-solid me-9 ">
                                        <input class="form-check-input" type="radio" value="1" name="team_status"
                                            checked />
                                        <label class="form-check-label ms-3" for="email">Active</label>
                                    </div>
                                    <div class="form-check form-check-custom form-check-solid ">
                                        <input class="form-check-input" type="radio" value="0" name="team_status" />
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
                        <button type="reset" id="btnClear" class="btn btn-secondary ">Clear</button>
                        <button type="button" class="btn btn-primary mx-5 " onclick="newTeam()">Add</button>
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