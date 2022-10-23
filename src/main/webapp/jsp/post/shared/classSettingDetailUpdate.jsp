<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tss.constants.ScreenConstants" %>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <!--begin::Layout-->
        <div class="d-flex flex-column flex-xl-row">
            <!--begin::Content-->
            <div class="flex-lg-row-fluid me-lg-15">
                <!--begin::Basic info-->
                <div class="card mb-5 mb-xl-10">
                    <!--begin::Card header-->
                    <div class="card-header border-0 cursor-pointer" role="button" data-bs-toggle="collapse"
                         data-bs-target="#kt_account_profile_details" aria-expanded="true"
                         aria-controls="kt_account_profile_details">
                        <!--begin::Card title-->
                        <div class="card-title m-0">
                            <h3 class="fw-bolder m-0">Update Setting Detail</h3>
                        </div>
                        <!--end::Card title-->
                    </div>
                    <!--begin::Card header-->
                    <!--begin::Content-->
                    <div id="kt_account_profile_details" class="collapse show">
                        <!--begin::Form-->
                        <form id="kt_account_profile_details_form" class="form">
                            <!--begin::Card body-->
                            <div class="card-body border-top p-9">
                                <!--begin::Input group-->
                                <div class="row mb-6">
                                    <!--begin::Label-->
                                    <label class="col-lg-4 col-form-label required fw-bold fs-6">Title</label>
                                    <!--end::Label-->
                                    <!--begin::Col-->
                                    <div class="col-lg-8 fv-row">
                                        <input type="text"
                                               class="form-control form-control-lg form-control-solid"
                                               placeholder="Value" value="${setting.getTitle()}" readonly/>
                                        <input type="hidden" name="id" value="${setting.getSettingId()}"/>
                                    </div>
                                    <!--end::Col-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="row mb-6">
                                    <!--begin::Label-->
                                    <label class="col-lg-4 col-form-label required fw-bold fs-6">Value</label>
                                    <!--end::Label-->
                                    <!--begin::Col-->
                                    <c:if test="${setting.getValueType() == 'string'}">
                                        <div class="col-lg-8 fv-row">
                                            <input type="text" name="value"
                                                   class="form-control form-control-lg form-control-solid"
                                                   placeholder="Value" value="${setting.getValue()}" />
                                        </div>
                                    </c:if>
                                    <c:if test="${setting.getValueType() == 'boolean'}">
                                        <div class="col-lg-8 fv-row">
                                            <!--begin::Options-->
                                            <div class="d-flex align-items-center mt-3">
                                                <!--begin::Option-->
                                                <label class="form-check form-check-inline form-check-solid me-5">
                                                    <input class="form-check-input" name="value" type="radio"
                                                           value="true" ${setting.getValue() == 'true' ? 'checked' : ''}/>
                                                    <span class="fw-bold ps-2 fs-6">True</span>
                                                </label>
                                                <!--end::Option-->
                                                <!--begin::Option-->
                                                <label class="form-check form-check-inline form-check-solid">
                                                    <input class="form-check-input" name="value" type="radio"
                                                           value="false" ${setting.getValue() == 'false' ? 'checked' : ''}/>
                                                    <span class="fw-bold ps-2 fs-6">False</span>
                                                </label>
                                                <!--end::Option-->
                                            </div>
                                            <!--end::Options-->
                                        </div>
                                    </c:if>
                                    <c:if test="${setting.getValueType() == 'number'}">
                                        <div class="col-lg-8 fv-row">
                                            <input type="number" name="value" min="0" max="100"
                                                   class="form-control form-control-lg form-control-solid"
                                                   placeholder="Value" value="${setting.getValue()}" />
                                        </div>
                                    </c:if>
                                    <!--end::Col-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="row mb-6">
                                    <!--begin::Label-->
                                    <label class="col-lg-4 col-form-label required fw-bold fs-6">Active</label>
                                    <!--end::Label-->
                                    <!--begin::Col-->
                                    <div class="col-lg-8 fv-row">
                                        <!--begin::Options-->
                                        <div class="d-flex align-items-center mt-3">
                                            <!--begin::Option-->
                                            <label class="form-check form-check-inline form-check-solid me-5">
                                                <input class="form-check-input" name="active" type="radio"
                                                       value="0" ${setting.getStatusId() == 0 ? 'checked' : ''}/>
                                                <span class="fw-bold ps-2 fs-6">Inactive</span>
                                            </label>
                                            <!--end::Option-->
                                            <!--begin::Option-->
                                            <label class="form-check form-check-inline form-check-solid">
                                                <input class="form-check-input" name="active" type="radio"
                                                       value="1" ${setting.getStatusId() == 1 ? 'checked' : ''}/>
                                                <span class="fw-bold ps-2 fs-6">Active</span>
                                            </label>
                                            <!--end::Option-->
                                        </div>
                                        <!--end::Options-->
                                    </div>
                                    <!--end::Col-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="row mb-6">
                                    <!--begin::Label-->
                                    <label class="col-lg-4 col-form-label required fw-bold fs-6">Display
                                        order</label>
                                    <!--end::Label-->
                                    <!--begin::Col-->
                                    <div class="col-lg-8 fv-row">
                                        <!--begin::Options-->
                                        <div class="d-flex align-items-center mt-3">
                                            <!--begin::Option-->
                                            <label class="form-check form-check-inline form-check-solid me-5">
                                                <input class="form-check-input" name="displayOrther" type="radio"
                                                       value="ASC" ${setting.getDisplayOrder() == 'ASC' ? 'checked' : ''}/>
                                                <span class="fw-bold ps-2 fs-6">ASC</span>
                                            </label>
                                            <!--end::Option-->
                                            <!--begin::Option-->
                                            <label class="form-check form-check-inline form-check-solid">
                                                <input class="form-check-input" name="displayOrther" type="radio"
                                                       value="DESC" ${setting.getDisplayOrder() == 'DESC' ? 'checked' : ''}/>
                                                <span class="fw-bold ps-2 fs-6">DESC</span>
                                            </label>
                                            <!--end::Option-->
                                        </div>
                                        <!--end::Options-->
                                    </div>
                                    <!--end::Col-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="row mb-6">
                                    <!--begin::Label-->
                                    <label class="col-lg-4 col-form-label fw-bold fs-6">
                                        <span class="required">Description</span>
                                        <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip"
                                           title="Description"></i>
                                    </label>
                                    <!--end::Label-->
                                    <!--begin::Col-->
                                    <div class="col-lg-8 fv-row">
                                        <textarea name="description" class="form-control" id="description" rows="3">${setting.getDescription()}</textarea>
                                    </div>
                                    <!--end::Col-->
                                </div>
                                <!--end::Input group-->
                            </div>
                            <!--end::Card body-->
                            <!--begin::Actions-->
                            <div class="card-footer d-flex justify-content-end py-6 px-9">
                                <button type="submit" class="btn btn-primary"
                                        id="kt_account_profile_details_submit">Save Changes</button>
                            </div>
                            <!--end::Actions-->
                        </form>
                        <!--end::Form-->
                    </div>
                    <!--end::Content-->
                </div>
                <!--end::Basic info-->
            </div>
            <!--end::Content-->
        </div>
        <!--end::Layout-->
    </div>
    <!--end::Container-->
</div>