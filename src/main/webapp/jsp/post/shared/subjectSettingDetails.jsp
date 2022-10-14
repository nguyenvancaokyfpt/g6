<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .card-body.pt-0{
        padding: 0 !important;
    }

    .card-header{
        align-items: center !important;
    }
</style>
<c:set value="${requestScope.subjectSetting}" var="ss"/>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <!--begin::Card-->
        <div style="margin-bottom: 10px">
            <button class="btn btn-primary" onclick="history.back()">
                Go back
            </button>
        </div>
        <div class="card">
            <div class="card-header">
                <h3>Subject Setting</h3>
            </div>
            <!--begin::Card body-->
            <div class="card-body pt-0">
                <!--begin::Table-->
                <table class="table align-middle table-row-dashed fs-6 gy-5" id="kt_table_users">
                    <!--begin::Table head-->
                    <thead>
                        <!--begin::Table row-->
                        <tr class="text-start text-gray-400 fw-bolder fs-7 text-uppercase gs-0">
                            <th></th>   
                            <th></th>
                            <th></th>
                            <th class="min-w-125px">Setting ID</th>
                            <th class="min-w-125px">Type ID</th>
                            <th class="min-w-125px">Setting Title</th>
                            <th class="min-w-125px">Setting Value</th>
                            <th class="min-w-125px">Setting Order</th>
                            <th class="min-w-125px">Status</th>
                            <th class="min-w-125px">Description</th>
                            <th class="min-w-125px">Subject Name</th>
                        </tr>
                        <!--end::Table row-->
                    </thead>
                    <!--end::Table head-->
                    <!--begin::Table body-->
                    <tbody class="text-gray-600 fw-bold">
                        <!--begin::Table row-->
                        <tr>
                            <td></td>
                            <td></td>   
                            <td></td>
                            <td>${ss.settingId}</td>
                            <td>${ss.typeId}</td>
                            <td>${ss.title}</td>
                            <td>${ss.value}</td>
                            <td>
                                ${ss.displayOrder}
                            </td>
                            <td>
                                <c:if test="${ss.statusId==1}">
                                    <div class="btn btn-success">
                                        Active
                                    </div>
                                </c:if>
                                <c:if test="${ss.statusId!=1}">
                                    <div class="btn btn-danger">
                                        Inactive
                                    </div>
                                </c:if>
                            </td>
                            <td>
                                <div class="text-wrap" style="width: 23em;">
                                    ${ss.description}
                                </div>
                            </td>
                            <td>${ss.subjectName}</td>
                        </tr>
                        <!--end::Table row-->
                    </tbody>
                    <!--end::Table body-->
                </table>
                <!--end::Table-->
            </div>
            <!--end::Card body-->
        </div>
        <!--end::Card-->
    </div>
    <!--end::Container-->
</div>
<!--end::Post-->
<div style="margin: 5px"></div>
<!--begin::Basic info-->
<div id="kt_content_container" class="container">
    <div class="card mb-5 mb-xl-10">
        <!--begin::Card header-->
        <div class="card-header border-0">
            <!--begin::Card title-->
            <div class="m-0">
                <h3 class="fw-bolder m-0">Subject Setting Details</h3>
            </div>
            <!--end::Card title-->
        </div>
        <!--begin::Card header-->
        <!--begin::Content-->
        <div id="kt_account_profile_details" class="collapse show">
            <!--begin::Form-->
            <form id="kt_account_profile_details_form" class="form" action="/subject/setting" method="post">
                <!--begin::Card body-->
                <input hidden name="action" value="update"/>
                <input hidden name="settingId" value="${ss.settingId}"/>
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
                    <input required value="${ss.title}" name="title" type="text" class="form-control" placeholder="Setting Title"/>
                    <br>
                    <h4>Setting Value: </h4>
                    <input required value="${ss.value}" name="value" type="number" class="form-control" placeholder="Setting Value"/>
                    <br>
                    <h4>Setting Order: </h4>
                    <select required name="displayOrder" class="form-select form-select-solid" aria-label="Select example">
                        <option value="Simple" ${ss.displayOrder == 'Simple' ? 'selected' : ''}>Simple</option>
                        <option value="Normal" ${ss.displayOrder == 'Normal' ? 'selected' : ''}>Normal</option>
                        <option value="Complex" ${ss.displayOrder == 'Complex' ? 'selected' : ''}>Complex</option>
                    </select>
                    <br>
                    <div>
                        <div class="form-check form-check-inline">
                            <input name="statusId" class="form-check-input" ${ss.statusId == '1' ? 'checked' : ''} type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1">
                            <label class="form-check-label" for="inlineRadio1">Active</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input name="statusId" class="form-check-input" ${ss.statusId == '0' ? 'checked' : ''} type="radio" name="inlineRadioOptions" id="inlineRadio2" value="0">
                            <label class="form-check-label" for="inlineRadio2">Inactive</label>
                        </div>
                    </div>
                    <br>
                    <h4>Setting Description: </h4>
                    <div class="form-outline">
                        <textarea name="description" required class="form-control" id="textAreaExample2" rows="8"
                                  >${ss.description}
                        </textarea>
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
