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
                                <h3 class="fw-bolder m-0">Class Details</h3>
                            </div>
                            <!--end::Card title-->
                            <!--begin::Action-->
                            <a href="/settingDetail?id=<%=sd.getClass_id()%>&action=update"
                                class="btn btn-primary align-self-center">Edit Setting</a>
                            <!--end::Action-->
                        </div>
                        <!--begin::Card header-->
                        <!--begin::Card body-->
                        <div class="card-body p-9">
                            <!--begin::Row-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Code</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8">
                                    <span class="fw-bolder fs-6">
                                        <%=sd.getClass_code()%>
                                    </span>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Row-->
                            <!--begin::Input group-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Term</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8 fv-row">
                                    <span class="fw-bold fs-6">
                                        <%=sd.getTermString()%>
                                    </span>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Input group-->
                            <!--begin::Input group-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Trainer</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8 fv-row">
                                    <span class="fw-bold fs-6">
                                        <%=sd.getTrainerString()%>
                                    </span>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Input group-->
                            <!--begin::Input group-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Supporter</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8 d-flex align-items-center">
                                    <span class="fw-bolder fs-6">
                                        <%=sd.getSupporterString()%>
                                    </span>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Input group-->
                            <!--begin::Input group-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Status</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8">
                                    <% if (sd.getStatusString().equals("Active")) { %>
                                        <span class="badge badge-success fw-bolder fs-6">
                                            <%=sd.getStatusString()%>
                                        </span>
                                        <% } else { %>
                                            <span class="badge badge-danger fw-bolder fs-6">
                                                <%=sd.getStatusString()%>
                                            </span>
                                            <% } %>
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Input group-->
                            <!--begin::Input group-->
                            <div class="row mb-7">
                                <!--begin::Label-->
                                <label class="col-lg-4 fw-bold text-muted">Description</label>
                                <!--end::Label-->
                                <!--begin::Col-->
                                <div class="col-lg-8">
                                    <span class="fw-bolder fs-6">
                                        <%=sd.getDescription()%>
                                    </span>
                                </div>
                                <!--end::Col-->
                            </div>
                            <div>
                                <a class="btn btn-bg-danger" href="/class/list">Back</a>
                            </div>
                            <!--end::Input group-->
                        </div>
                        <!--end::Card body-->
                    </div>
                    <!--end::details View-->
                </div>
                <!--end::Container-->
            </div>