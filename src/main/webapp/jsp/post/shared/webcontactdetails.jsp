<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="w" value="${requestScope.webContactDetails}"/>
<style>
    .card-body.pt-0{
        padding: 0 !important;
    }

    .card-header{
        align-items: center !important;
    }

    .form-color {
        background-color: #fafafa
    }

    .form-control {
        height: 48px;
        border-radius: 25px
    }

    .form-control:focus {
        color: #495057;
        background-color: #fff;
        border-color: #35b69f;
        outline: 0;
        box-shadow: none;
        text-indent: 10px
    }

    .c-badge {
        background-color: #35b69f;
        color: white;
        height: 20px;
        font-size: 11px;
        width: 92px;
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 2px
    }

    .comment-text {
        font-size: 13px
    }

    .wish {
        color: #35b69f
    }

    .user-feed {
        font-size: 14px;
        margin-top: 12px
    }
</style>
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
                <h3>Web Contact Details</h3>
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
                            <th class="min-w-125px">Customer</th>
                            <th class="min-w-125px">Email</th>
                            <th class="min-w-125px">Mobile</th>
                            <th class="min-w-125px">Supporter</th>
                            <th class="min-w-125px">Status</th>
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
                            <td class="d-flex align-items-center">
                                <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
                                    <div class="symbol-label">
                                        <img src="../../../assets/media/avatars/blank.png" class="w-100">
                                    </div>
                                </div>
                                <div class="d-flex flex-column">
                                    <p class="text-gray-800 text-hover-primary mb-1">${w.full_name}</p>
                                </div>
                                <!--begin::User details-->
                            </td>
                            <td>${w.email}</td>
                            <td>${w.mobile}</td>
                            <c:forEach items="${requestScope.userList}" var="u">
                                <c:if test="${u.userId == w.supporter_id}">
                                    <td class="d-flex align-items-center">
                                        <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
                                            <div class="symbol-label">
                                                <img src="../../../${u.avatarUrl}" class="w-100">
                                            </div>
                                        </div>
                                        <div class="d-flex flex-column">
                                            <p class="text-gray-800 text-hover-primary mb-1">
                                                ${u.fullname}
                                            </p>
                                        </div>
                                    </td>
                                </c:if>
                            </c:forEach>
                            <td>
                                <c:if test="${w.response == 'Not response'}">
                                    <div class="btn btn-bg-secondary">
                                        Not Response!
                                    </div>
                                </c:if>
                                <c:if test="${w.response != 'Not response'}">
                                    <div class="btn btn-bg-warning">
                                        Had Response!
                                    </div>
                                </c:if>
                            </td>
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
<div style="margin: 5px"></div>
<div id="kt_content_container" class="container">
    <div class="card mb-5 mb-xl-10">
        <!--begin::Card header-->
        <div class="card-header border-0">
            <!--begin::Card title-->
            <div class="m-0">
                <h3 class="fw-bolder m-0">Details of Message and Response</h3>
            </div>
            <!--end::Card title-->
        </div>
        <!--begin::Card header-->
        <!--begin::Content-->
        <div id="kt_account_profile_details" class="collapse show">
            <div class="container mt-5 mb-5">
                <div class="row height d-flex justify-content-center align-items-center">
                    <div class="col-md-7">
                        <div class="card">
                            <div class="mt-2">
                                <div class="d-flex flex-row p-3"> 
                                    <img src="../../../assets/media/avatars/blank.png" 
                                         width="60" height="60" class="rounded-circle mr-3"
                                         style="margin-right: 10px"/>
                                    <div class="w-100">
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="d-flex flex-row align-items-center"> 
                                                <h4 class="mr-2">Brian selter</h4> 
                                            </div> 
                                        </div>
                                        <p class="text-justify comment-text mb-0">
                                            ${w.message}
                                        </p>
                                        <div class="d-flex flex-row user-feed"> 
                                            <label for="reply" class="ml-3 cursor-pointer">
                                                <i class="fa fa-reply"></i>
                                                Reply
                                            </label> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-3 align-items-center p-3 form-color"
                                 style="transform: translate(75px,0);">
                                <div class="d-flex flex-row">
                                    <c:forEach items="${requestScope.userList}" var="u">
                                        <c:if test="${u.userId == w.supporter_id}">
                                            <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
                                                <div class="symbol-label">
                                                    <img src="../../../${u.avatarUrl}" width="30" class="rounded-circle mr-2">
                                                </div>
                                            </div>
                                            <div class="d-flex align-items-center">
                                                <p style="transform: translateX(-10px)" class="text-gray-800 mb-1">
                                                    ${u.fullname}
                                                </p>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <form action="/webcontact/list" method="post">
                                    <input hidden name="webcontactid" value="${w.category_id}"/>
                                    <input hidden name="action" value="reply"/>
                                    <textarea id="reply" name="reply" rows="10" cols="90" style="transform: translateX(50px)">
                                        ${w.response == 'Not response' ? '' : w.response}
                                    </textarea> 
                                    <div class="d-flex justify-content-end py-6 px-9">
                                        <button type="submit" class="btn btn-primary" id="kt_account_profile_details_submit">Reply Message</button>
                                        <button type="button" class="btn btn-white btn-active-light-primary me-2" onclick="history.back()">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--end::Content-->
    </div>
    <!--end::Basic info-->
</div>
