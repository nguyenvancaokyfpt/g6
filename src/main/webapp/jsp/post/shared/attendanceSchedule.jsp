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
                            <form action="/schedule/attendance" hidden="true">
                                <input type="hidden" name="action" value="get">
                                <div class="d-flex justify-content-end me-3">
                                    <!--begin::Filter-->
                                    <select name="class_id" class="form-select form-select">
                                        <c:forEach items="${myClass}" var="d">
                                            <c:choose>
                                                <c:when test="${class_id == d.getClassId()}">
                                                    <option value="${d.getClassId()}" selected="true">${d.getClassCode()}</option>
                                                    <c:set var="class_name" value="${d.getClassCode()}"></c:set>
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
                        <a href="#basic-table"></a>Schedule Attendance for class ${class_name}
                    </h1>
                    <!--end::Heading-->
                    <!--begin::Block-->
                    <div class="my-5">

                        <div class="pb-10">
                            <c:choose>
                                <c:when test="${!scheduleList.isEmpty()}">
                                    <table class="table table-sm">
                                        <thead>
                                            <tr class="text-gray-600 fw-bold border-2 border-gray-400">
                                                <th class="" style="padding-left: 3px;">Slot</th>
                                                <th class="">Training date</th>
                                                <th class="">Topic</th>
                                                <th class="">Time</th>
                                                <th class="">Room</th>
                                                <th class="">Attendance</th> 
                                                <th class="">Status</th> 
                                                <th class="">Comment</th> 
                                            </tr>
                                        </thead>
                                        <tbody id="content">
                                            <c:set var = "i" value = "1"/>
                                            <c:forEach items="${scheduleList}" var="sl">
                                                <c:set var = "flag" value = "false"/>
                                                <tr class="border-2 border-gray-300">
                                                    <td style="padding-left: 3px;">${i}</td>
                                                    <c:set var = "i" value = "${i+1}"/>
                                                    <td><span class="">${sl.training_date}</span></td>
                                                    <td>${sl.title}</td>
                                                    <td><span class="">${sl.from_time} - ${sl.to_time}</span></td>
                                                    <td>${sl.room}</td>

                                                    <c:forEach items="${attendanceList}" var="al">
                                                        <c:choose>
                                                            <c:when test="${al.schedule_id == sl.schedule_id}">
                                                                <c:set var = "flag" value = "true"/>
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:forEach items="${attendanceList}" var="al">
                                                        <c:choose>
                                                            <c:when test="${al.schedule_id == sl.schedule_id}">
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
                                                                <td>${al.comment}</td>
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:choose>
                                                        <c:when test="${flag != true}">
                                                            <td style="color: red">False</td>
                                                            <td>Not yet</td>
                                                            <td></td>
                                                        </c:when>
                                                    </c:choose>

                                                </tr>

                                            </c:forEach>
                                                <tr>
                                                    <h3>Absent: ${absentSofar}% absent so far (${absent} out of ${totalSchedule})</h3>
                                                </tr>
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