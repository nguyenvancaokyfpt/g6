<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <c:set value="${requestScope.schedule}" var="s" />
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
                                    <input hidden value="${s.scheduleId}" name="scheduleId" />
                                    <!--begin::Wrapper-->
                                    <div class="d-flex flex-column align-items-start flex-xxl-row">
                                        <!--begin::Input group-->
                                        <div class="d-flex flex-center flex-equal fw-row text-nowrap order-1 order-xxl-2 me-4"
                                            data-bs-toggle="tooltip">
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
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select
                                                        Slot</label>
                                                    <select required class="form-select form-select-solid fw-bolder"
                                                        data-kt-select2="true" data-placeholder="Select slot"
                                                        data-hide-search="true" name="slot">
                                                        <option value="1" ${s.slot==1 ? 'selected' :''}>Slot 1 </option>
                                                        <option value="2" ${s.slot==2 ? 'selected' :''}>Slot 2</option>
                                                        <option value="3" ${s.slot==3 ? 'selected' :''}>Slot 3 </option>
                                                        <option value="4" ${s.slot==4 ? 'selected' :''}>Slot 4 </option>
                                                        <option value="5" ${s.slot==5 ? 'selected' :''}>Slot 5 </option>
                                                        <option value="6" ${s.slot==6 ? 'selected' :''}>Slot 6 </option>
                                                        <option value="7" ${s.slot==6 ? 'selected' :''}>Slot 7 </option>
                                                        <option value="8" ${s.slot==6 ? 'selected' :''}>Slot 8</option>
                                                    </select>
                                                </div>
                                                <div class="mb-5">
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select
                                                        Class</label>
                                                    <select required class="form-select form-select-solid fw-bolder"
                                                        data-kt-select2="true" data-placeholder="Select class"
                                                        data-hide-search="true" name="classId">
                                                        <c:forEach items="${requestScope.classes}" var="cl">
                                                            <option value="${cl.classId}" ${s.classId==cl.classId
                                                                ? 'selected' : '' }>${cl.classCode}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="mb-5">
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">From
                                                        time</label>
                                                    <input required
                                                        style="background-color: #f5f8fa; border-color: #f5f8fa;"
                                                        class="form-control form-control-white fw-bolder pe-6"
                                                        placeholder="Select from time" type="time" name="from" id="from"
                                                        value="${s.from}" />
                                                </div>
                                            </div>
                                            <!--end::Col-->
                                            <!--begin::Col-->
                                            <div class="col-lg-6">
                                                <div class="mb-5">
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Select
                                                        Training Date</label>
                                                    <!--begin::date-->
                                                    <div style="width: 100%"
                                                        class="d-flex align-items-center flex-equal fw-row me-4 order-2"
                                                        data-bs-toggle="tooltip">
                                                        <!--begin::Date-->
                                                        <!--end::Date-->
                                                        <!--begin::Input-->
                                                        <div class="position-relative d-flex align-items-center"
                                                            style="width: 100%">
                                                            <!--begin::Datepicker-->
                                                            <input required
                                                                style="background-color: #f5f8fa; border-color: #f5f8fa;"
                                                                class="form-control form-control-white fw-bolder pe-6"
                                                                placeholder="Select date" type="date" name="date"
                                                                id="datepicker" value="${s.trainingDate}" />
                                                            <!--end::Datepicker-->
                                                        </div>
                                                        <!--end::Input-->
                                                    </div>
                                                    <!--end::Input group-->
                                                </div>
                                                <!--end::Input group-->
                                                <!--begin::Input group-->
                                                <div class="mb-5">
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Room</label>
                                                    <input name="room" value="${s.room}" required type="text"
                                                        class="form-control form-control-solid" placeholder="Room" />
                                                </div>
                                                <div class="mb-5">
                                                    <label
                                                        class="required form-label fs-6 fw-bolder text-gray-700 mb-3">To
                                                        time</label>
                                                    <input required
                                                        style="background-color: #f5f8fa; border-color: #f5f8fa;"
                                                        class="form-control form-control-white fw-bolder pe-6"
                                                        placeholder="Select to time" type="time" name="to" id="to"
                                                        value="${s.to}" />
                                                </div>
                                            </div>
                                            <!--end::Col-->
                                        </div>
                                        <!--end::Row-->
                                        <!--begin::Notes-->
                                        <!--end::Notes-->
                                        <div hidden="" class="table-responsive mb-10">
                                            <table class="table g-5 gs-0 mb-0 fw-bolder text-gray-700"
                                                data-kt-element="items">
                                                <th class="">
                                                    <button data-kt-element="add-item">Add item</button>
                                                </th>
                                            </table>
                                        </div>
                                    </div>
                                    <div style="margin: 20px 0 -20px 0;"
                                        class="card-footer d-flex justify-content-end py-6 px-9">
                                        <button style="margin-right: 10px " type="submit" class="btn btn-primary"
                                            id="kt_account_profile_details_submit">Submit</button>
                                        <button type="button" class="btn btn-white btn-active-light-primary me-2"
                                            onclick="history.back()">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">

                var today = new Date();
                var dd = today.getDate() + 1;
                var mm = today.getMonth() + 1; //January is 0!
                var yyyy = today.getFullYear();
                if (dd < 10) {
                    dd = '0' + dd;
                }
                if (mm < 10) {
                    mm = '0' + mm;
                }
                today = yyyy + '-' + mm + '-' + dd;
                document.getElementById("datepicker").setAttribute("min", today);


            </script>
            <script src="assets/plugins/global/plugins.bundle.js"></script>
            <script src="assets/js/scripts.bundle.js"></script>
            <script src="assets/js/custom/apps/invoices/create.js"></script>
            <script src="assets/js/custom/widgets.js"></script>
            <script src="assets/js/custom/apps/chat/chat.js"></script>
            <script src="assets/js/custom/modals/create-app.js"></script>
            <script src="assets/js/custom/modals/upgrade-plan.js"></script>