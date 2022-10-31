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
                    <div class="card-title fs-3 fw-bolder">Trainee Details</div>
                    <!--end::Card title-->
                </div>
                <!--end::Card header-->
                <!--begin::Card body-->
                <div class="card-body p-9">
                    <!--begin::Form-->
                    <form id="kt_modal_new_target_form" class="form" action="#">
                        <!--begin::Input group-->
                        <div class="row g-9 mb-8">
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row">
                                <label class="required fs-6 fw-bold mb-2">Fullname</label>
                                <input type="text" class="form-control form-control-lg form-control${action == '' ? '-solid' : ''}"
                                    name="fullname" placeholder="Fullname" ${action == '' ? 'readonly' : ''} value="${trainee.getFullname()}"/>
                                <input type="hidden" name="id" value="${trainee.getUserId()}"/>
                                <input type="hidden" name="classId" value="${trainee.getClassId()}"/>
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row">
                                <label class="required fs-6 fw-bold mb-2">Email</label>
                                <!--begin::Input-->
                                <input type="text" class="form-control form-control-lg form-control${action == '' ? '-solid' : ''}" name="email"
                                    placeholder="Email" ${action == '' ? 'readonly' : ''} value="${trainee.getEmail()}" />
                                <!--end::Input-->
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row g-9 mb-8">
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row">
                                <label class="required fs-6 fw-bold mb-2">Mobile</label>
                                <input type="text" class="form-control form-control-lg form-control${action == '' ? '-solid' : ''}" name="mobile"
                                    placeholder="Mobile" ${action == '' ? 'readonly' : ''} value="${trainee.getMobile()}" />
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row">
                                <label class="fs-6 fw-bold mb-2">Dropout Date</label>
                                <!--begin::Input-->
                                <div class="position-relative d-flex align-items-center">
                                    <!--begin::Icon-->
                                    <div class="symbol symbol-20px me-4 position-absolute ms-4">
                                        <span class="symbol-label bg-secondary">
                                            <!--begin::Svg Icon | path: icons/duotone/Layout/Layout-grid.svg-->
                                            <span class="svg-icon">
                                                <svg xmlns="http://www.w3.org/2000/svg"
                                                    xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                    height="24px" viewBox="0 0 24 24" version="1.1">
                                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                        <rect x="0" y="0" width="24" height="24" />
                                                        <rect fill="#000000" opacity="0.3" x="4" y="4" width="4"
                                                            height="4" rx="1" />
                                                        <path
                                                            d="M5,10 L7,10 C7.55228475,10 8,10.4477153 8,11 L8,13 C8,13.5522847 7.55228475,14 7,14 L5,14 C4.44771525,14 4,13.5522847 4,13 L4,11 C4,10.4477153 4.44771525,10 5,10 Z M11,4 L13,4 C13.5522847,4 14,4.44771525 14,5 L14,7 C14,7.55228475 13.5522847,8 13,8 L11,8 C10.4477153,8 10,7.55228475 10,7 L10,5 C10,4.44771525 10.4477153,4 11,4 Z M11,10 L13,10 C13.5522847,10 14,10.4477153 14,11 L14,13 C14,13.5522847 13.5522847,14 13,14 L11,14 C10.4477153,14 10,13.5522847 10,13 L10,11 C10,10.4477153 10.4477153,10 11,10 Z M17,4 L19,4 C19.5522847,4 20,4.44771525 20,5 L20,7 C20,7.55228475 19.5522847,8 19,8 L17,8 C16.4477153,8 16,7.55228475 16,7 L16,5 C16,4.44771525 16.4477153,4 17,4 Z M17,10 L19,10 C19.5522847,10 20,10.4477153 20,11 L20,13 C20,13.5522847 19.5522847,14 19,14 L17,14 C16.4477153,14 16,13.5522847 16,13 L16,11 C16,10.4477153 16.4477153,10 17,10 Z M5,16 L7,16 C7.55228475,16 8,16.4477153 8,17 L8,19 C8,19.5522847 7.55228475,20 7,20 L5,20 C4.44771525,20 4,19.5522847 4,19 L4,17 C4,16.4477153 4.44771525,16 5,16 Z M11,16 L13,16 C13.5522847,16 14,16.4477153 14,17 L14,19 C14,19.5522847 13.5522847,20 13,20 L11,20 C10.4477153,20 10,19.5522847 10,19 L10,17 C10,16.4477153 10.4477153,16 11,16 Z M17,16 L19,16 C19.5522847,16 20,16.4477153 20,17 L20,19 C20,19.5522847 19.5522847,20 19,20 L17,20 C16.4477153,20 16,19.5522847 16,19 L16,17 C16,16.4477153 16.4477153,16 17,16 Z"
                                                            fill="#000000" />
                                                    </g>
                                                </svg>
                                            </span>
                                            <!--end::Svg Icon-->
                                        </span>
                                    </div>
                                    <!--end::Icon-->
                                    <!--begin::Datepicker-->
                                    <input class="form-control form-control-solid ps-12" placeholder="Select a date"
                                        name="due_date" ${action == '' ? 'readonly' : ''} value="${trainee.getDropoutDate()}"/>
                                    <!--end::Datepicker-->
                                </div>
                                <!--end::Input-->
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="d-flex flex-column mb-8">
                            <label class="fs-6 fw-bold mb-2">Note</label>
                            <textarea class="form-control form-control${action == '' ? '-solid' : ''}" rows="3" name="note"
                                placeholder="Note" ${action == '' ? 'readonly' : ''}>${trainee.getNote()}</textarea>
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="mb-15 fv-row">
                            <!--begin::Wrapper-->
                            <div class="d-flex flex-center">
                                <!--begin::Checkboxes-->
                                <div class="d-flex align-items-center">
                                    <!--begin::Checkbox-->
                                    <label class="form-check form-check-custom form-check${action == '' ? '-solid' : ''} me-10">
                                        <input class="form-check-input h-20px w-20px" type="radio" name="status_id"
                                            value="1" ${trainee.getStatusId() == 1 ? "checked" : ""} ${action == '' ? 'disabled' : ''} />
                                        <span class="form-check-label fw-bold">Active</span>
                                    </label>
                                    <!--end::Checkbox-->
                                    <!--begin::Checkbox-->
                                    <label class="form-check form-check-custom form-check${action == '' ? '-solid' : ''} me-10">
                                        <input class="form-check-input h-20px w-20px" type="radio" name="status_id"
                                            value="0" ${trainee.getStatusId() == 0 ? "checked" : ""} ${action == '' ? 'disabled' : ''} />
                                        <span class="form-check-label fw-bold">Inactive</span>
                                    </label>
                                    <!--end::Checkbox-->
                                    <!--begin::Checkbox-->
                                    <label class="form-check form-check-custom form-check${action == '' ? '-solid' : ''}">
                                        <input class="form-check-input h-20px w-20px" type="radio" name="status_id"
                                            value="2" ${trainee.getStatusId() == 2 ? "checked" : ""} ${action == '' ? 'disabled' : ''} />
                                        <span class="form-check-label fw-bold">Dropout</span>
                                    </label>
                                    <!--end::Checkbox-->
                                </div>
                                <!--end::Checkboxes-->
                            </div>
                            <!--end::Wrapper-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Actions-->
                        <div class="text-center">
                            <c:if test="${action == ''}">
                                <a href="management/trainee/detail?action=update&id=${trainee.getUserId()}&classId=${trainee.getClassId()}" class="btn btn-primary me-3" data-bs-dismiss="modal">Edit Trainee</a>
                            </c:if>
                            <c:if test="${action == 'update'}">
                            <button type="submit" id="kt_modal_new_target_submit" class="btn btn-primary">
                                <span class="indicator-label">Submit</span>
                                <span class="indicator-progress">Please wait...
                                    <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                            </button>
                            </c:if>
                        </div>
                        <!--end::Actions-->
                    </form>
                    <!--end:Form-->
                </div>
            </div>
            <!--end::Card-->
        </div>
        <!--end::Container-->
    </div>
    <!--end::Content-->