<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <c:set var="w" value="${requestScope.webContactDetails}" />
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
                            <form action="/webcontact/list?action=reply" id="kt_invoice_form" method="post">
                                <input hidden value="${w.category_id}" name="categoryId" />
                                <!--begin::Wrapper-->
                                <div class="d-flex flex-column align-items-start flex-xxl-row">
                                    <!--begin::Input group-->
                                    <div class="d-flex flex-center flex-equal fw-row text-nowrap order-1 order-xxl-2 me-4"
                                        data-bs-toggle="tooltip">
                                        <span class="fs-2x fw-bolder text-gray-800">Web Contact Details</span>
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
                                                    class="form-label fs-6 fw-bolder text-gray-700 mb-3">Customer</label>
                                                <input value="${w.full_name}" disabled
                                                    class="form-control form-control-solid" />
                                            </div>
                                            <div class="mb-5">
                                                <label
                                                    class="form-label fs-6 fw-bolder text-gray-700 mb-3">Email</label>
                                                <input value="${w.email}" disabled
                                                    class="form-control form-control-solid" />
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-lg-6">
                                            <div class="mb-5">
                                                <label
                                                    class="form-label fs-6 fw-bolder text-gray-700 mb-3">Mobile</label>
                                                <input value="${w.mobile}" disabled
                                                    class="form-control form-control-solid" />
                                            </div>
                                            <!--end::Input group-->
                                            <!--begin::Input group-->
                                            <div class="mb-5">
                                                <label
                                                    class="form-label fs-6 fw-bolder text-gray-700 mb-3">Response</label>
                                                <br />
                                                <c:if test="${w.response == 'Not response'}">
                                                    <div class="btn btn-danger">Not Response!</div>
                                                </c:if>
                                                <c:if test="${w.response != 'Not response'}">
                                                    <div onclick="unsent(${w.category_id})" class="btn btn-warning">
                                                        Unsent Response?</div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <div class="mb-5">
                                        <label class="form-label fs-6 fw-bolder text-gray-700 mb-3">Message</label>
                                        <textarea disabled minlength="20" class="form-control form-control-solid"
                                            rows="3">
                                    ${w.message}
                                </textarea>
                                    </div>
                                    <br />
                                    <!--begin::Notes-->
                                    <div class="mb-0">
                                        <label class="required form-label fs-6 fw-bolder text-gray-700">Reply</label>
                                        <textarea minlength="20" name="reply" required
                                            class="form-control form-control-solid" rows="3"
                                            placeholder="Reply to message">
                                    ${w.response == 'Not response' ? '' : w.response}
                                </textarea>
                                    </div>
                                    <!--end::Notes-->
                                </div>
                                <div style="margin: 20px 0 -20px 0;"
                                    class="card-footer d-flex justify-content-end py-6 px-9">
                                    <button type="submit" class="btn btn-primary me-5"
                                        id="kt_account_profile_details_submit">Submit</button>
                                    <button type="button" class="btn btn-secondary me-2"
                                        onclick="history.back()">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form hidden id="form1" action="/webcontact/list?action=reply" method="post">
            <input name="categoryId" id="categoryId" />
            <input name="reply" value="Not response" />
        </form>
        <script type="text/javascript">
            function unsent(categoryId) {
                document.getElementById('categoryId').value = categoryId;
                document.getElementById('form1').submit();
            }
        </script>