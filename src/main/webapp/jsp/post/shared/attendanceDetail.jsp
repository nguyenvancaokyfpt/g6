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
                    <div class="pb-10">
                        <!--begin::Heading-->
                        <h1 class="anchor fw-bolder mb-5" id="basic-table">
                            <a href="#basic-table"></a>Take attendance
                        </h1>
                        <!--end::Heading-->
                        <!--begin::Block-->
                        <div class="my-5">
                            <form action="/attendance/detail">
                                <input type="hidden" name="action" value="create">
                                <table class="table table-sm table-striped">
                                    <thead>
                                        <tr class="text-gray-900 fw-bold border-1 border-white">
                                            <th>Group</th>
                                            <th>Full name</th>
                                            <th>Present</th>
                                            <th>Absent</th>
                                            <th>Late</th>
                                            <th>Comment</th>
                                            <th>Image</th>
                                        </tr>
                                    </thead>
                                    <tbody id="content">
                                    <input type="hidden" name="class_id" value="${class_id}">
                                    <input type="hidden" name="schedule_id" value="${schedule_id}">
                                    <c:forEach items="${userList}" var="ul">
                                        <tr>
                                            <td class="fw-bolder text-dark fs-6">${ul.class_code}</td>
                                            <td class="fw-bolder text-dark fs-6">${ul.full_name}</td>
                                            <td class="form-label fw-bolder text-dark fs-6">
                                                <input type="radio" name="user_status[${ul.user_id}]" value="3" class="form-check-input" checked="true"> Present
                                            </td>
                                            <td class="form-label fw-bolder text-dark fs-6">
                                                <input type="radio" name="user_status[${ul.user_id}]" value="4" class="form-check-input"> Absent
                                            </td>
                                            <td class="form-label fw-bolder text-dark fs-6">
                                                <input type="radio" name="user_status[${ul.user_id}]" value="5" class="form-check-input"> Late
                                            </td>
                                            <td>
                                                <input type="text" name="user_comment[${ul.user_id}]" placeholder="Enter comment" class="form-control">
                                            </td>
                                            <td class="float-lg-start">
                                                <object data="${ul.avatarUrl}" type="image/png" style="width:105px;height:110px;">
                                                    <img src="assets/media/avatars/blank.png" alt="No image found" style="width:105px;height:110px;">
                                                </object>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                    <input type="submit" class="btn btn-primary" value="Take attendance">
                            </form>
                        </div>
                        <!--end::Block-->
                    </div>
                    <!--end::Section-->
                </div>
                <!--end::Card Body-->
            </div>
            <!--end::Card-->
        </div>
    </div>
    <!--end::Container-->
</div>