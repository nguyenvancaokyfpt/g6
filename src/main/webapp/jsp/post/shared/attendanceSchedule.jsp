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
                            <form action="/schedule/attendance">
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
                                    <input type="submit" value="Apply" class="btn btn-primary">
                                    <!--end::Separator-->
                                </div>
                            </form>
                        </div>
                        <!--end::Toolbar-->
                    </div>
                    <!--begin::Heading-->
                    <h1 class="anchor fw-bolder mb-5" id="basic-table">
                        <a href="#basic-table"></a>List of Schedule
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
                                                <th class="">Slot</th>
                                                <th class="">Training date</th>
                                                <th class="">From time</th>
                                                <th class="">To time</th>
                                                <th class="">Room</th>
                                                <th class="">Take attendance</th> 
                                                <th class="">Status</th> 
                                            </tr>
                                        </thead>
                                        <tbody id="content">
                                            <c:forEach items="${scheduleList}" var="sl">
                                                <c:set var = "flag" value = "false"/>
                                                <tr>
                                                    <td>${sl.schedule_id}</td>
                                                    <td>${sl.training_date}</td>
                                                    <td>${sl.from_time}</td>
                                                    <td>${sl.to_time}</td>
                                                    <td>${sl.room}</td>
                                                    
                                                    <c:forEach items="${attendanceList}" var="al">
                                                        <c:choose>
                                                            <c:when test="${al.slot_id == sl.schedule_id}">
                                                                <c:set var = "flag" value = "true"/>
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:forEach items="${attendanceList}" var="al">
                                                        <c:choose>
                                                            <c:when test="${al.slot_id == sl.schedule_id}">
                                                                <td style="color: green">True</td>
                                                                <c:choose>
                                                                        <c:when test="${al.status == 'Present'}">
                                                                            <td style="color: green">Present</td>
                                                                        </c:when>
                                                                        <c:when test="${al.status == 'Absent'}">
                                                                            <td style="color: red">Absent</td>
                                                                        </c:when>
                                                                        <c:when test="${al.status == 'Late'}">
                                                                            <td style="color: orange">Late</td>
                                                                        </c:when>
                                                                    </c:choose>
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:choose>
                                                        <c:when test="${flag != true}">
                                                            <td style="color: red">False</td>
                                                            <td>Not yet</td>
                                                        </c:when>
                                                    </c:choose>

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