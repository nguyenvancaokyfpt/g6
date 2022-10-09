<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .card-header{
        align-items: center !important;
    }
</style>
<!--begin::Basic info-->
<div id="kt_content_container" class="container">
    <div style="margin-bottom: 10px">
        <button class="btn btn-primary" onclick="history.back()">
            Go back
        </button>
    </div>
    <div class="card mb-5 mb-xl-10">
        <!--begin::Card header-->
        <div class="card-header border-0">
            <!--begin::Card title-->
            <div class="m-0">
                <h3 class="fw-bolder m-0">Add Subject Setting</h3>
            </div>
            <!--end::Card title-->
        </div>
        <!--begin::Card header-->
        <!--begin::Content-->
        <div id="kt_account_profile_details" class="collapse show">
            <!--begin::Form-->
            <form id="kt_account_profile_details_form" class="form" action="/subjectSetting" method="post">
                <!--begin::Card body-->
                <input hidden name="action" value="create"/>
                <div class="card-body border-top p-9">
                    <h4>Setting Subject: </h4>
                    <select required name="subjectId" class="form-select form-select-solid" aria-label="Select example">
                        <c:forEach items="${requestScope.subjectList}" var="s">
                            <option value="${s.subjectId}"
                                    ${ss.subjectId == s.subjectId ? 'selected' : ''}>
                                ${s.subjectName}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <h4>Setting Title: </h4>
                    <select name="typeId" class="form-select form-select-solid" aria-label="Select example">
                        <option></option>
                        <option value="1">Marks</option>
                        <option value="2">Learning Progress</option>
                        <option value="3">Lecturers</option>
                        <option value="4">Complexity</option>
                    </select>
                    <br>
                    <h4>Setting Order: </h4>
                    <select name="value" class="form-select form-select-solid" aria-label="Select example">
                        <option></option>
                        <option value="1">Simple</option>
                        <option value="2">Normal</option>
                        <option value="3">Complex</option>
                    </select>
                    <br>
                    <div>
                        <div class="form-check form-check-inline">
                            <input name="statusId" class="form-check-input" checked type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1">
                            <label class="form-check-label" for="inlineRadio1">Active</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input name="statusId" class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="0">
                            <label class="form-check-label" for="inlineRadio2">Inactive</label>
                        </div>
                    </div>
                    <br>
                    <h4>Setting Description: </h4>
                    <div class="form-outline">
                        <textarea name="description" required class="form-control" id="textAreaExample2" rows="8"
                                  >${ss.description}</textarea>
                    </div>
                </div>
                <!--end::Card body-->
                <!--begin::Actions-->
                <div class="card-footer d-flex justify-content-end py-6 px-9">
                    <button type="submit" class="btn btn-primary" id="kt_account_profile_details_submit">Save Changes</button>
                    <button type="button" class="btn btn-white btn-active-light-primary me-2" onclick="history.back()">Cancel</button>
                </div>
                <!--end::Actions-->
            </form>
            <!--end::Form-->
        </div>
        <!--end::Content-->
    </div>
    <!--end::Basic info-->
</div>
