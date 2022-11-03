<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    a:hover {
        cursor: pointer !important;
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
                    <div style="margin: 0 100px 25px 0; display: flex">
                        <div style="margin-right: 5px">
                            Year: <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                          data-placeholder="Select year" data-hide-search="true" id="year"
                                          onchange="list(getYear(), getWeek(), getClassFilter(), getSearch())">
                                <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
                                <option value="${year-1}" ${requestScope.year == (year-1) ? 'selected':''}>${year-1}</option>
                                <option value="${year}" ${requestScope.year == year ? 'selected':''}>${year}</option>
                                <option value="${year+1}" ${requestScope.year == (year+1) ? 'selected':''}>${year+1}</option>
                            </select>
                        </div>
                        <div>
                            Week: <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                          data-placeholder="Select year" data-hide-search="true" id="week" 
                                          onchange="list(getYear(), getWeek(), getClassFilter(), getSearch())">
                                <c:forEach items="${requestScope.listWeek}" var="w">
                                    <option ${requestScope.current == w ? 'selected' : ''}>${w}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <!--begin::Filter-->
                    <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click"
                            data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">
                        <!--begin::Svg Icon | path: icons/duotone/Text/Filter.svg-->
                        <span class="svg-icon svg-icon-2">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                 width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                    <rect x="0" y="0" width="24" height="24" />
                                    <path
                                        d="M5,4 L19,4 C19.2761424,4 19.5,4.22385763 19.5,4.5 C19.5,4.60818511 19.4649111,4.71345191 19.4,4.8 L14,12 L14,20.190983 C14,20.4671254 13.7761424,20.690983 13.5,20.690983 C13.4223775,20.690983 13.3458209,20.6729105 13.2763932,20.6381966 L10,19 L10,12 L4.6,4.8 C4.43431458,4.5790861 4.4790861,4.26568542 4.7,4.1 C4.78654809,4.03508894 4.89181489,4 5,4 Z"
                                        fill="#000000" />
                                </g>
                            </svg>
                        </span>
                        <!--end::Svg Icon-->Filter
                    </button>
                    <!--begin::Menu 1-->
                    <div class="menu menu-sub menu-sub-dropdown w-300px w-md-325px" data-kt-menu="true">
                        <!--begin::Header-->
                        <div class="px-7 py-5">
                            <div class="fs-5 text-dark fw-bolder">Filter Options</div>
                        </div>
                        <!--end::Header-->
                        <!--begin::Separator-->
                        <div class="separator border-gray-200"></div>
                        <!--end::Separator-->
                        <!--begin::Content-->
                        <div class="px-7 py-5" data-kt-user-table-filter="form">
                            <!--begin::Input group-->
                            <div class="mb-10">
                                <label class="form-label fs-6 fw-bold">Class:</label>
                                <select class="selectFilter form-select form-select-solid fw-bolder" data-kt-select2="true"
                                        data-placeholder="Select option" data-allow-clear="true" data-hide-search="true"
                                        id="classFilter">
                                    <option value="" ${requestScope.classFilter == '' ? 'selected' : '' }></option>
                                    <c:forEach items="${requestScope.classes}" var="cl">
                                        <option value="${cl.classId}" ${requestScope.classFilter == cl.classId ? 'selected' : '' }>${cl.classCode}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!--end::Input group-->
                            <!--begin::Actions-->
                            <div class="d-flex justify-content-end">
                                <button type="reset"
                                        class="btn btn-white btn-active-light-primary fw-bold me-2 px-6"
                                        >
                                    Reset</button>
                                <button type="submit" class="btn btn-primary fw-bold px-6"
                                        >
                                    Apply</button>
                            </div>
                            <!--end::Actions-->
                        </div>
                        <!--end::Content-->
                    </div>
                    <!--end::Menu 1-->
                    <!--end::Filter-->

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
                               class="form-control form-control-solid w-250px ps-14"
                               placeholder="Search date(yyyy-MM-dd), class, title" style="margin-right: 10px;" id="search"
                               value="${requestScope.searchRg}" />
                        <button type="button" class="btn btn-primary mb-3" style="margin-top: 10px;" 
                                onclick="list(getYear(), getWeek(), getClassFilter(), getSearch())">
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
                            <th class="min-w-175px">Slot</th>
                            <th class="min-w-125px">Class</th>
                            <th class="min-w-125px">Title</th>
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
                    <tbody class="text-gray-600 fw-bold">
                        <!--begin::Table row-->
                        <c:forEach items="${requestScope.scheduleList}" var="s">
                            <tr>
                                <td></td>
                                <td></td>
                                <td class="d-flex align-items-center">
                                    <!--begin::User details-->
                                    <div class="d-flex flex-column">
                                        <p href="" class="text-gray-800 mb-1">${s.slot}</p>
                                        <span>(${s.from} - ${s.to})</span>
                                    </div>
                                </td>
                                <td>
                                    <c:forEach items="${requestScope.classes}" var="cl">
                                        ${cl.classId == s.classId ? cl.classCode : ''}
                                    </c:forEach>
                                </td>
                                <td>${s.title}</td>
                                <td>${s.trainingDate}</td>
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
                                    <form action="/schedule/list?action=get&scheduleId=${s.scheduleId}" method="post">
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
                ${requestScope.notice}
                <!--end::Table-->
            </div>
            <!--end::Card body-->
        </div>
        <!--end::Card-->
    </div>
    <!--end::Container-->
</div>
<!--end::Post-->

<form hidden id="formList" action="/schedule/list" method="post">
    <input name="action" value="list" />
    <input name="year" value="" id="yearInp" />
    <input name="week" value="" id="weekInp" />
    <input name="searchRg" value="" id="searchInp" />
    <input name="classFilter" value="" id="classInp" />
</form>


<script type="text/javascript">

    function getYear() {
        return document.getElementById('year').value;
    }

    function getWeek() {
        return document.getElementById('week').value;
    }

    function getSearch() {
        return document.getElementById('search').value;
    }

    function getClassFilter() {
        return document.getElementById('classFilter').value;
    }

    function list(year, week, classFilter, searchRg) {
        document.getElementById('yearInp').value = year;
        document.getElementById('weekInp').value = week;
        document.getElementById('classInp').value = classFilter;
        document.getElementById('searchInp').value = searchRg;
        document.getElementById('formList').submit();
    }

</script>