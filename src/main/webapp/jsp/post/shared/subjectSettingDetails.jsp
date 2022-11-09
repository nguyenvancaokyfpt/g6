<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <c:set value="${requestScope.subjectSetting}" var="ss" />
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
                            <form action="/subject/setting?action=update" id="kt_invoice_form" method="post">
                                <input hidden value="${ss.settingId}" name="settingId" />
                                <!--begin::Wrapper-->
                                <div class="d-flex flex-column align-items-start flex-xxl-row">
                                    <!--begin::Input group-->
                                    <div class="d-flex flex-center flex-equal fw-row text-nowrap order-1 order-xxl-2 me-4"
                                        data-bs-toggle="tooltip">
                                        <span class="fs-2x fw-bolder text-gray-800">Details of Subject Setting</span>
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
                                                    class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Setting
                                                    Title</label>
                                                <input minlength="5" name="title" value="${ss.title}" required
                                                    type="text" class="form-control form-control-solid"
                                                    placeholder="Setting title" />
                                            </div>
                                            <div class="mb-5">
                                                <label
                                                    class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Setting
                                                    value</label>
                                                <input name="value" value="${ss.value}" required type="number" min="1"
                                                    class="form-control form-control-solid"
                                                    placeholder="Setting value" />
                                            </div>
                                            <div class="mb-5">
                                                <label
                                                    class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Subject
                                                    Name</label>
                                                <select required class="form-select form-select-solid fw-bolder"
                                                    data-kt-select2="true" data-placeholder="Select subject"
                                                    data-hide-search="true" name="subjectId">
                                                    <c:forEach items="${requestScope.subjectList}" var="s">
                                                        <option value="${s.subjectId}" ${ss.subjectId==s.subjectId
                                                            ? 'selected' : '' }>${s.subjectName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <!--end::Col-->
                                        <!--begin::Col-->
                                        <div class="col-lg-6">
                                            <div class="mb-5">
                                                <label
                                                    class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Type</label>
                                                <select required class="form-select form-select-solid fw-bolder"
                                                    data-kt-select2="true" data-placeholder="Select type"
                                                    data-hide-search="true" name="typeId">
                                                    <c:forEach items="${requestScope.subjectTypes}" var="st">
                                                        <c:if test="${st.typeId == 4 and st.description != 'hidden'}">
                                                            <option value="${st.id}" ${ss.typeId==st.id ? 'selected'
                                                                : '' }>${st.title}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <!--end::Input group-->
                                            <!--begin::Input group-->
                                            <div class="mb-5">
                                                <label
                                                    class="required form-label fs-6 fw-bolder text-gray-700 mb-3">Display
                                                    Order</label>
                                                <select required class="form-select form-select-solid fw-bolder"
                                                    data-kt-select2="true" data-placeholder="Select order"
                                                    data-hide-search="true" name="displayOrder">
                                                    <option value="Simple" ${ss.displayOrder=='Simple' ? 'selected' : ''
                                                        }>Simple</option>
                                                    <option value="Normal" ${ss.displayOrder=='Normal' ? 'selected' : ''
                                                        }>Normal</option>
                                                    <option value="Complex" ${ss.displayOrder=='Complex' ? 'selected'
                                                        : '' }>Complex</option>
                                                </select>
                                            </div>
                                            <div class="mb-5">
                                                <label
                                                    class="required form-label fs-6 fw-bolder text-gray-700 me-5 pb-5">Status</label>
                                                <br>
                                                <input class="form-check-input me-1" ${ss.statusId==1 ? 'checked' : '' }
                                                    type="radio" value="1" name="statusId" id="flexRadioDefault1" />
                                                <label class="form-check-label me-4" for="flexRadioDefault1">
                                                    <h6>Active</h6>
                                                </label>
                                                <input class="form-check-input me-1" ${ss.statusId==0 ? 'checked' : '' }
                                                    type="radio" value="0" name="statusId" id="flexRadioDefault2" />
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    <h6>Inactive</h6>
                                                </label>
                                            </div>
                                        </div>

                                        <!--end::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Notes-->
                                    <div class="mb-0">
                                        <label
                                            class="required form-label fs-6 fw-bolder text-gray-700">Description</label>
                                        <textarea minlength="20" name="description" required
                                            class="form-control form-control-solid" rows="5"
                                            placeholder="Body description of subject">
                                    ${ss.description}
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