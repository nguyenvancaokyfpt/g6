<%-- Document : listdetail Created on : Sep 23, 2022, 4:48:51 PM Author : msi --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tss.model.ClassAnhPT" %>
<% ClassAnhPT sd=(ClassAnhPT)request.getAttribute("classdetail"); %>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <!--begin::details View-->
        <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
            <!--begin::Card header-->
            <div class="card-header cursor-pointer">
                <!--begin::Card title-->
                <div class="card-title m-0">
                    <h3 class="fw-bolder m-0">Update Class</h3>
                </div>
                <!--end::Card title-->
                <!--begin::Action-->
                <!--end::Action-->
            </div>
            <!--begin::Card header-->
            <!--begin::Card body-->
            <div class="card-body p-9">
                <!--begin::Row-->

                <!--end::Row-->
                <!--begin::Form-->
                <form action="/class/list">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="<%=sd.getClass_id()%>">
                    <div class="modal-body py-10 px-lg-17">
                        <!--begin::Input group-->
                        <div class="d-flex flex-column mb-5 fv-row fv-plugins-icon-container">
                            <!--begin::Label-->
                            <label class="required fs-5 fw-bold mb-2">Class Code</label>
                            <!--end::Label-->
                            <!--begin::Input-->
                            <input class="form-control form-control-solid"
                                   placeholder="Enter setting title" name="class_code" required="true"
                                   value="<%=sd.getClass_code()%>">
                            <!--end::Input-->
                            <div class="fv-plugins-message-container invalid-feedback"></div>
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-5">
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row fv-plugins-icon-container">
                                <!--begin::Label-->
                                <label class="d-flex align-items-center fs-5 fw-bold mb-2">
                                    <span class="required">Term</span>
                                </label>
                                <!--end::Label-->
                                <!--begin::Select-->
                                <select
                                    class="form-select form-select-solid fw-bolder select2-hidden-accessible"
                                    data-kt-select2="true" data-placeholder="Select term" aria-hidden="true"
                                    name="term_id" required="true">
                                    <option data-select2-id="select2-data-12-dqg1"></option>
                                    <c:forEach items="${termList}" var="tl">
                                        <c:choose>
                                            <c:when test="${term_id==tl.id}">
                                                <option value="${tl.id}" selected="true">${tl.title}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${tl.id}">${tl.title}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <!--end::Select-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row fv-plugins-icon-container">
                                <!--begin::Label-->
                                <label class="d-flex align-items-center fs-5 fw-bold mb-2">
                                    <span class="required">Subject</span>
                                </label>
                                <!--end::Label-->
                                <!--begin::Select-->
                                <select class="form-select form-select-solid fw-bolder select2-hidden-accessible"
                                        data-kt-select2="true" data-placeholder="Select term" aria-hidden="true"
                                        name="subject_id" required="true">
                                    <option data-select2-id="select2-data-12-dqg1"></option>
                                    <c:forEach items="${subjectList}" var="tl">                                        
                                        <c:choose>
                                            <c:when test="${subject_id==tl.subjectId}">
                                                <option value="${tl.subjectId}" selected="true">${tl.subjectCode}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${tl.subjectId}">${tl.subjectCode}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <!--end::Select-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="row mb-5">
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row fv-plugins-icon-container">
                                <!--begin::Label-->
                                <label class="d-flex align-items-center fs-5 fw-bold mb-2">
                                    <span class="required">Trainer</span>
                                </label>
                                <!--end::Label-->
                                <!--begin::Select-->
                                <select
                                    class="form-select form-select-solid fw-bolder select2-hidden-accessible"
                                    data-kt-select2="true" data-placeholder="Select trainer"
                                    aria-hidden="true" name="trainer_id" required="true">
                                    <option data-select2-id="select2-data-12-dqg1"></option>
                                    <c:forEach items="${trainerList}" var="trl">
                                        <c:choose>
                                            <c:when test="${trainer_id==trl.trainer_id}">
                                                <option value="${trl.trainer_id}" selected="true">
                                                    ${trl.trainerString}</option>
                                                </c:when>
                                                <c:otherwise>
                                                <option value="${trl.trainer_id}">${trl.trainerString}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <!--end::Select-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>
                            <!--begin::Col-->
                            <div class="col-md-6 fv-row fv-plugins-icon-container">
                                <!--begin::Label-->
                                <label class="d-flex align-items-center fs-5 fw-bold mb-2">
                                    <span class="required">Supporter</span>
                                </label>
                                <!--end::Label-->
                                <!--begin::Select-->
                                <select
                                    class="form-select form-select-solid fw-bolder select2-hidden-accessible"
                                    data-kt-select2="true" data-placeholder="Select supporter"
                                    aria-hidden="true" name="supporter_id" required="true">
                                    <option data-select2-id="select2-data-12-dqg1"></option>
                                    <c:forEach items="${supporterList}" var="sl">
                                        <c:choose>
                                            <c:when test="${supporter_id==sl.trainer_id}">
                                                <option value="${sl.trainer_id}" selected="true">
                                                    ${sl.trainerString}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${sl.trainer_id}">${sl.trainerString}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <!--end::Select-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="">
                            <label class="form-label fw-bolder text-dark fs-6">Status</label><br>
                            <% if (sd.getStatusString().equals("Active")) { %>
                            <input class="form-check-input" type="radio" id="html" name="status_id"
                                   value="0">
                            <label for="0"
                                   class="form-label fw-bolder text-dark fs-6">Inactive</label>
                            <input class="form-check-input" type="radio" id="css" name="status_id"
                                   value="1" checked="true">
                            <label for="1"
                                   class="form-label fw-bolder text-dark fs-6">Active</label>
                            <% } else { %>
                            <input class="form-check-input" type="radio" id="html"
                                   name="status_id" value="0" checked="true">
                            <label for="0"
                                   class="form-label fw-bolder text-dark fs-6">Inactive</label>
                            <input class="form-check-input" type="radio" id="css"
                                   name="status_id" value="1">
                            <label for="1"
                                   class="form-label fw-bolder text-dark fs-6">Active</label>
                            <% } %>

                            <div class="fv-plugins-message-container invalid-feedback">
                            </div>
                        </div><br>
                        <!--end::Input group-->
                        <!--begin::Input group-->
                        <div class="d-flex flex-column mb-5 fv-row fv-plugins-icon-container">
                            <!--begin::Label-->
                            <label class="fs-5 fw-bold mb-2">Description</label>
                            <!--end::Label-->
                            <!--begin::Input-->
                            <textarea class="form-control form-control-solid"
                                      placeholder="Enter description"
                                      name="description"><%=sd.getDescription()%></textarea>
                            <!--end::Input-->
                            <div class="fv-plugins-message-container invalid-feedback"></div>
                        </div>
                        <!--end::Input group-->
                        <a class="btn btn-bg-danger" href="/class/list">Cancel</a>
                        <button type="submit" class="btn btn-primary">Update Class</button>
                    </div>
                </form>
                <!--end::Form-->
                <!--end::Card body-->
            </div>
            <!--end::details View-->
        </div>
        <!--end::Container-->
    </div>