<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    a:hover {
        cursor: pointer !important;
    }

    /* The snackbar - position it at the bottom and in the middle of the screen */
    #successToast {
        visibility: hidden;
        /* Hidden by default. Visible on click */
        background-color: #50cd89;
        /* Black background color */
        width: max-content;
        color: #fff;
        /* White text color */
        text-align: center;
        /* Centered text */
        padding: 16px;
        /* Padding */
        position: fixed;
        /* Sit on top of the screen */
        right: 40px;
        /* Center the snackbar */
        bottom: 70px;
        /* 30px from the bottom */
        border-radius: 0.475rem;
    }

    /* Show the snackbar when clicking on a button (class added with JavaScript) */
    #successToast.show {
        visibility: visible;
        /* Show the snackbar */
        /* Add animation: Take 0.5 seconds to fade in and out the snackbar.
However, delay the fade out process for 2.5 seconds */
        -webkit-animation: fadein 0.5s, fadeout 0.5s 3s;
        animation: fadein 0.5s, fadeout 0.5s 3s;
    }

    /* Animations to fade the snackbar in and out */
    @-webkit-keyframes fadein {
        from {
            bottom: 0;
            opacity: 0;
        }

        to {
            bottom: 70px;
            opacity: 1;
        }
    }

    @keyframes fadein {
        from {
            bottom: 0;
            opacity: 0;
        }

        to {
            bottom: 70px;
            opacity: 1;
        }
    }

    @-webkit-keyframes fadeout {
        from {
            bottom: 70px;
            opacity: 1;
        }

        to {
            bottom: 0;
            opacity: 0;
        }
    }

    @keyframes fadeout {
        from {
            bottom: 70px;
            opacity: 1;
        }

        to {
            bottom: 0;
            opacity: 0;
        }
    }
</style>
<!--begin::Post-->
<c:set var="now" value="<%= new java.util.Date()%>" />
<div class="post" id="kt_post" style="width: 96%; margin: 0 auto">
    <!--begin::Container-->
    <div id="kt_content_container" class="">
        <!--begin::Card-->
        <div class="card">
            <!--begin::Card header-->
            <div class="card-header border-0 pt-6">
                <!--begin::Card title-->
                <div class="card-title">
                    <!--begin::Search-->
                    <div class="d-flex align-items-center position-relative my-1">
                        <!--begin::Svg Icon | path: icons/duotone/General/Search.svg-->
                        <span class="svg-icon svg-icon-1 position-absolute ms-6">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                 width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                    <rect x="0" y="0" width="24" height="24" />
                                    <path
                                        d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z"
                                        fill="#000000" fill-rule="nonzero" opacity="0.3" />
                                    <path
                                        d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z"
                                        fill="#000000" fill-rule="nonzero" />
                                </g>
                            </svg>
                        </span>
                        <!--end::Svg Icon-->
                        <input type="text" data-kt-user-table-filter="search"
                               class="form-control form-control-solid w-350px ps-14"
                               placeholder="Search date(dd/MM/yyyy) / class" style="margin-right: 10px;"
                               id="search" value="${requestScope.searchRg}" />
                        <button class="btn btn-primary mb-3 mt-3" onclick="list(1)">
                            Search
                        </button>
                    </div>
                    <!--end::Search-->
                </div>
                <!--begin::Card title-->
                <!--begin::Card toolbar-->
                <div class="card-toolbar">
                    <!--begin::Toolbar-->
                    <div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
                        <!--begin::Add user-->
                        <form action="/schedule/list?action=get&scheduleId=-1" method="post">
                            <button type="submit" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#kt_modal_add_user">
                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Plus.svg-->
                                <span class="svg-icon svg-icon-2">
                                    <svg xmlns="http://www.w3.org/2000/svg"
                                         xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                         viewBox="0 0 24 24" version="1.1">
                                        <rect fill="#000000" x="4" y="11" width="16" height="2" rx="1" />
                                        <rect fill="#000000" opacity="0.5"
                                              transform="translate(12.000000, 12.000000) rotate(-270.000000) translate(-12.000000, -12.000000)"
                                              x="4" y="11" width="16" height="2" rx="1" />
                                    </svg>
                                </span>
                                <!--end::Svg Icon-->Add Schedule
                            </button>
                        </form>
                        <!--end::Add user-->
                    </div>
                    <!--end::Toolbar-->
                    <!--end::Modal - New Card-->

                </div>
                <!--end::Card toolbar-->
            </div>
            <!--end::Card header-->
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
                            <th class="min-w-75px">Slot</th>
                            <th class="min-w-125px">From</th>
                            <th class="min-w-125px">To</th>
                            <th class="min-w-125px">Class</th>
                            <th class="min-w-125px">Training Date</th>
                            <th class="min-w-125px">Room</th>
                            <th class="min-w-125px">Status</th>
                            <th class="min-w-125px">Details</th>
                            <th class="min-w-175px">Attendance</th>
                        </tr>
                        <!--end::Table row-->
                    </thead>
                    <!--end::Table head-->
                    <!--begin::Table body-->
                    <tbody class="text-gray-700 fw-bold">
                        <!--begin::Table row-->
                        <c:forEach items="${requestScope.scheduleList}" var="s">
                            <tr>
                                <td></td>
                                <td></td>
                                <td>${s.slot}</td>
                                <td>${s.from}</td>
                                <td>${s.to}</td>
                                <td>
                                    <c:forEach items="${requestScope.classes}" var="cl">
                                        ${cl.classId == s.classId ? cl.classCode : ''}
                                    </c:forEach>
                                </td>
                                <td>
                                    <fmt:formatDate value="${s.trainingDate}" pattern="dd/MM/yyyy" />
                                </td>
                                <td>${s.room}</td>
                                <fmt:formatDate var="time" value="${now}" pattern="HH:mm:ss" />
                                <fmt:formatDate var="day" value="${now}" pattern="yyyy-MM-dd" />
                                <td>
                                    <c:if test="${s.isAttendance(s.scheduleId) eq false}">
                                        <div class="btn btn-secondary">
                                            Not yet
                                        </div>
                                    </c:if>
                                    <c:if test="${s.isAttendance(s.scheduleId) eq true}">
                                        <div class="btn btn-success">
                                            Attend
                                        </div>
                                    </c:if>
                                </td>
                                <!--begin::Action=-->
                                <td>
                                    <form action="/schedule/list?action=get&scheduleId=${s.scheduleId}"
                                          method="post">
                                        <button type="submit" class="btn btn-secondary">
                                            Details
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <c:if test="${s.trainingDate eq day}">
                                        <c:if test="${s.isAttendance(s.scheduleId) eq false}">
                                            <button onclick="" type="button" class="btn btn-primary">
                                                Take Attendance
                                            </button>
                                        </c:if>
                                        <c:if test="${s.isAttendance(s.scheduleId) eq true}">
                                            <button onclick="" type="button" class="btn btn-primary">
                                                Edit Attendance
                                            </button>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${s.trainingDate gt day}">
                                        <button onclick="" type="button" class="btn btn-secondary">
                                            Not yet
                                        </button>
                                    </c:if>
                                    <c:if test="${s.trainingDate lt day}">
                                        <button onclick="" type="button" class="btn btn-warning">
                                            Taken !
                                        </button>
                                    </c:if>
                                </td>
                                <!--end::Action=-->
                            </tr>
                            <!--end::Table row-->
                        </c:forEach>
                    </tbody>
                    <!--end::Table body-->
                </table>
                <ul style="float: right" class="pagination me-6">
                    <li class="page-item previous ${requestScope.curPage == 1 ? 'disabled' : ''}">
                        <button onclick="list(${requestScope.curPage - 1})" class="page-link"><i
                                class="previous"></i></button>
                    </li>
                    <c:forEach items="${requestScope.pages}" var="p">
                        <li class="page-item ${requestScope.curPage == p ? 'active' : ''}">
                            <button onclick="list(${p})" class="page-link">${p}</button>
                        </li>
                    </c:forEach>
                    <li class="page-item next ${requestScope.curPage == requestScope.endPage ? 'disabled' : ''}"">
                        <button onclick=" list(${requestScope.curPage + 1})" class="page-link"><i
                                class="next"></i></button>
                    </li>
                </ul>
                <!--end::Table-->
            </div>
            <!--end::Card body-->
        </div>
        <!--end::Card-->
    </div>
    <!--end::Container-->
</div>
<!--end::Post-->

<div id="successToast">
    <i style="color: #fff; font-size: 23px" class="fa fa-check me-4"></i>
    <span style="font-size: 16px">Successfully !!!</span>
</div>

<script type="text/javascript">
    function list(x) {
        window.location.href = "/schedule/list?search=" + document.getElementById('search').value
                + "&curPage=" + x;
    }

    <c:if test="${sessionScope.toast == true}">
    var x = document.getElementById("successToast");

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () {
        x.className = x.className.replace("show", "");
    }, 3000);
    </c:if>
    <c:remove scope="session" var="toast"/>
</script>