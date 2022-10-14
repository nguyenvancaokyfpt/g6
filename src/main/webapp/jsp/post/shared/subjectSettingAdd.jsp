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
            <form id="kt_account_profile_details_form" class="form" action="/subject/setting" method="post">
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
                    <input required name="title" type="text" class="form-control" placeholder="Setting Title"/>
                    <br>
                    <h4>Setting Value: </h4>
                    <input required name="value" type="number" class="form-control" placeholder="Setting Value"/>
                    <br>
                    <h4>Setting Order: </h4>
                    <select required name="displayOrder" class="form-select form-select-solid" aria-label="Select example">
                        <option value="Simple" selected>Simple</option>
                        <option value="Normal">Normal</option>
                        <option value="Complex">Complex</option>
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
                        <textarea name="description" required class="form-control" id="textAreaExample2" rows="8">
                            
                        </textarea>
                    </div>
                </div>
                <!--end::Card body-->
                <!--begin::Actions-->
                <div class="card-footer d-flex justify-content-end py-6 px-9">
                    <button type="submit" class="btn btn-primary" id="kt_account_profile_details_submit">Add Setting</button>
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
