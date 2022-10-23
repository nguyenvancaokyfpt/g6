<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set value="${requestScope.schedule}" var="s"/>
<!--begin::Container-->
<div id="kt_content_container" class="container">
    <!--begin::Layout-->
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid mb-10 mb-lg-0 me-lg-7 me-xl-10">
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card body-->
                <div class="card-body p-12">
                    <!--begin::Form-->
                    <form action="/schedule/list?action=update" id="kt_invoice_form" method="post">
                        <input hidden value="${s.scheduleId}" name="scheduleId"/>
                        <!--begin::Wrapper-->
                        <div class="d-flex flex-column align-items-start flex-xxl-row">
                            <!--begin::Input group-->
                            <div class="d-flex flex-center flex-equal fw-row text-nowrap order-1 order-xxl-2 me-4" data-bs-toggle="tooltip">
                                <span class="fs-2x fw-bolder text-gray-800">Details of Schedule</span>
                            </div>
                            <!--end::Input group-->
                        </div>
                        <!--end::Top-->
                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-10"></div>
                        <!--end::Separator-->
                        <!--begin::Wrapper-->
                        <div class="mb-0">
                            <!--begin::Row-->
                            <div class="row gx-10 mb-5">
                                <!--begin::Col-->
                                <div class="col-lg-6">
                                    <div class="mb-5">
                                        <label class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select Slot</label>
                                        <select required class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                                data-placeholder="Select slot" data-hide-search="true" name="slot">
                                            <option value="1" ${s.slot == 1 ? 'selected':''}>Slot 1 (7:30 - 9:00)</option>
                                            <option value="2" ${s.slot == 2 ? 'selected':''}>Slot 2 (9:10 - 10:40)</option>
                                            <option value="3" ${s.slot == 3 ? 'selected':''}>Slot 3 (10:50 - 12:20)</option>
                                            <option value="4" ${s.slot == 4 ? 'selected':''}>Slot 4 (12:50 - 14:20)</option>
                                            <option value="5" ${s.slot == 5 ? 'selected':''}>Slot 5 (14:30 - 16:00)</option>
                                            <option value="6" ${s.slot == 6 ? 'selected':''}>Slot 6 (16:10 - 17:40)</option>
                                        </select>
                                    </div>
                                    <div class="mb-5">
                                        <label class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select Class</label>
                                        <select required class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                                data-placeholder="Select class" data-hide-search="true" name="classId">
                                            <c:forEach items="${requestScope.classes}" var="cl">
                                                <option value="${cl.classId}" ${s.classId == cl.classId ? 'selected' : '' }>${cl.classCode}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-lg-6">
                                    <div class="mb-5">
                                        <label class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select Training Date</label>
                                        <!--begin::date-->
                                        <div style="width: 100%" class="d-flex align-items-center flex-equal fw-row me-4 order-2" data-bs-toggle="tooltip">
                                            <!--begin::Date-->
                                            <!--end::Date-->
                                            <!--begin::Input-->
                                            <div class="position-relative d-flex align-items-center" style="width: 100%">
                                                <!--begin::Datepicker-->
                                                <input required style="background-color: #f5f8fa; border-color: #f5f8fa;" 
                                                       class="form-control form-control-white fw-bolder pe-6" 
                                                       placeholder="Select date" name="invoice_date"
                                                       value="${s.fmtDate(s.trainingDate)}"/>
                                                <!--end::Datepicker-->
                                                <!--begin::Icon-->
                                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-down.svg-->
                                                <span style="transform: translateX(-10px)" class="svg-icon svg-icon-2 position-absolute ms-4 end-0">
                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <polygon points="0 0 24 0 24 24 0 24" />
                                                    <path d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z" fill="#000000" fill-rule="nonzero" transform="translate(12.000003, 11.999999) rotate(-180.000000) translate(-12.000003, -11.999999)" />
                                                    </g>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                                <!--end::Icon-->
                                            </div>
                                            <!--end::Input-->
                                        </div>
                                        <!--end::Input group-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-5">
                                        <label class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Room</label>
                                        <input name="room" value="${s.room}" required type="text" class="form-control form-control-solid" placeholder="Room" />
                                    </div>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Row-->
                            <!--begin::Notes-->
                            <div class="mb-0">
                                <label class="required form-label fs-6 fw-bolder text-gray-700">Title</label>
                                <input name="title" value="${s.title}" required name="notes" class="form-control form-control-solid" rows="3" placeholder="Title for schedule"/>
                            </div>
                            <!--end::Notes-->
                            <div hidden="" class="table-responsive mb-10">
                                <table class="table g-5 gs-0 mb-0 fw-bolder text-gray-700" data-kt-element="items">
                                    <th class="">
                                        <button data-kt-element="add-item">Add item</button>
                                    </th>
                                </table>
                            </div>
                        </div>
                        <div style="margin: 20px 0 -20px 0;" class="card-footer d-flex justify-content-end py-6 px-9">
                            <button style="margin-right: 10px " type="submit" class="btn btn-primary" id="kt_account_profile_details_submit">Submit</button>
                            <button type="button" class="btn btn-white btn-active-light-primary me-2" onclick="history.back()">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/plugins/global/plugins.bundle.js"></script>
<script src="assets/js/scripts.bundle.js"></script>
<script src="assets/js/custom/apps/invoices/create.js"></script>
<script src="assets/js/custom/widgets.js"></script>
<script src="assets/js/custom/apps/chat/chat.js"></script>
<script src="assets/js/custom/modals/create-app.js"></script>
<script src="assets/js/custom/modals/upgrade-plan.js"></script>












