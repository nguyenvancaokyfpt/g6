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
                            <form action="attendance/detail">
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
                                                <th class="">Title</th>
                                                <th class="">Time</th>
                                                <th class="">Room</th>
                                                <th class="">Action</th> 
                                            </tr>
                                        </thead>
                                        <tbody id="content">
                                            <c:set var = "i" value = "1"/>
                                            <c:forEach items="${scheduleList}" var="sl">
                                                <c:set var = "flag" value = "false"/>
                                                <tr class="border-bottom-1 border-gray-200">
                                                    <td>${i}</td>
                                                    <c:set var = "i" value = "${i+1}"/>
                                                    <td>${sl.training_date}</td>
                                                    <td>${sl.title}</td>
                                                    <td>${sl.from_time} - ${sl.to_time}</td>
                                                    <td>${sl.room}</td>
                                                    <c:forEach items="${attendanceList}" var="al">
                                                        <c:choose>
                                                            <c:when test="${al.schedule_id == sl.schedule_id}">
                                                                <c:set var = "flag" value = "true"/>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <c:choose>
                                                        <c:when test="${flag != true}">
                                                            <td>
                                                                <a href="/attendance/detail?action=take&class_id=${sl.class_id}&schedule_id=${sl.schedule_id}"><span class="badge badge-success fw-bold fs-6">Take attendance</span></a>
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                <a href="/attendance/detail?action=change&class_id=${sl.class_id}&schedule_id=${sl.schedule_id}"><span class="badge badge-secondary fw-bold fs-6">Change attendance</span></a>
                                                            </td>
                                                        </c:otherwise>
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