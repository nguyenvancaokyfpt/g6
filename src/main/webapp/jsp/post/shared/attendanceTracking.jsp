<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <div class="card">
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card Body-->
                <div class="card-body fs-6 p-10 p-lg-15">
                    <!--begin::Section-->
                    <div class="card-toolbar">
                        <!--begin::Toolbar-->

                        <div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
                            <form action="attendance/tracking">
                                <input type="hidden" name="action" value="get">
                                <div class="d-flex justify-content-end me-3">
                                    <!--begin::Filter-->
                                    <select name="class_id" class="form-select form-select">
                                        <c:forEach items="${myClass}" var="d">
                                            <c:choose>
                                                <c:when test="${class_id == d.getClassId()}">
                                                    <option value="${d.getClassId()}" selected="true">${d.getClassCode()}</option>
                                                </c:when>    
                                                <c:otherwise>
                                                    <option value="${d.getClassId()}">${d.getClassCode()}</option>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:forEach>
                                    </select>
                                    <!--end::Filter-->
                                    <!--begin::Separator-->
                                    <div class="separator border-gray-200"></div>
                                    <input type="submit" value="Track attendance" class="btn btn-primary">
                                    <!--end::Separator-->
                                </div>
                            </form>
                        </div>
                        <!--end::Toolbar-->
                    </div>
                    <!--begin::Heading-->
                    <h1 class="anchor fw-bolder mb-5" id="basic-table">
                        <a href="#basic-table"></a>Attendance Tracking
                    </h1>
                    <!--end::Heading-->
                    <!--begin::Block-->
                    <div class="my-5">

                        <div class="pb-10">
                            <c:choose>
                                <c:when test="${!scheduleList.isEmpty()}">
                                    <table class="table table-sm">
                                        <thead>
                                            <tr class="text-gray-600 fw-bold">
                                                <th class="">Full Name</th>
                                                    <c:forEach items="${scheduleList}" var="sl">
                                                    <th>${sl.training_date}</th>
                                                    </c:forEach>
                                            </tr>
                                            <tr class="text-gray-600 fw-bold">
                                                <th class=""></th>
                                                    <c:forEach items="${scheduleList}" var="sl">
                                                    <th>Slot ${sl.slot_id}</th>
                                                    </c:forEach>
                                            </tr>
                                        </thead>
                                        <tbody id="content">
                                            <c:forEach items="${userList}" var="ul">
                                                <tr class="fw-bold fs-6 text-gray-800 border-bottom border-gray-200">
                                                    <td>${ul.full_name}</td>
                                                    <c:forEach items="${scheduleList}" var="sl">
                                                        <c:set var = "flag" value = "false"/>
                                                        <c:forEach items="${attendanceList}" var="al">
                                                            <c:choose>
                                                                <c:when test="${al.slot_id == sl.slot_id && ul.user_id == al.trainer_id}">
                                                                    <c:set var = "flag" value = "true"/>
                                                                </c:when>    
                                                            </c:choose>
                                                        </c:forEach>
                                                        <c:forEach items="${attendanceList}" var="al">
                                                            <c:choose>
                                                                <c:when test="${al.slot_id == sl.slot_id && ul.user_id == al.trainer_id}">
                                                                    <c:choose>
                                                                        <c:when test="${al.status == 'Present'}">
                                                                            <td style="color: green">P</td>
                                                                        </c:when>
                                                                        <c:when test="${al.status == 'Absent'}">
                                                                            <td style="color: red">A</td>
                                                                        </c:when>
                                                                        <c:when test="${al.status == 'Late'}">
                                                                            <td style="color: orange">L</td>
                                                                        </c:when>
                                                                    </c:choose>
                                                                </c:when> 
                                                            </c:choose>
                                                        </c:forEach>
                                                        <c:choose>
                                                            <c:when test="${flag != true}">
                                                                <td>_</td>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>                                 
                                </c:when>    
                                <c:otherwise>
                                    <p style="text-align: center">Choose a class that has a schedule</p>
                                </c:otherwise>
                            </c:choose>
                        </div>


                    </div>
                    <!--end::Block-->
                    <!--end::Section-->
                </div>
                <!--end::Card Body-->
            </div>
            <!--end::Card-->
        </div>
    </div>
    <!--end::Container-->
</div>