<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="post text-dark" id="kt_post" style="width: 96%; margin: 0 auto">
        <!--begin::Container-->
        <div id="kt_content_container" class="">
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card header-->
                <div class="card-header border-0 pt-6">
                    <!--begin::Card title-->
                    <div class="card-title">
                        <!--begin::Filter-->
                        <div class="d-flex align-items-center position-relative my-1">
                            <div class="mb-10 me-3">
                                <label class="form-label fs-6 fw-bold">Manager:</label>
                                <select class="selectFilter form-select form-select-solid fw-bolder"
                                    data-kt-select2="true" data-placeholder="Select manager" data-allow-clear="true"
                                    data-hide-search="true" id="managerFilter">
                                    <option value=""></option>
                                    <c:forEach items="${requestScope.userList}" var="u">
                                        <c:if test="${u.role.id == 22}">
                                            <option value="${u.userId}" ${requestScope.managerId==u.userId ? 'selected'
                                                : '' }>${u.fullname}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-10 me-3">
                                <label class="form-label fs-6 fw-bold">Expert:</label>
                                <select class="selectFilter form-select form-select-solid fw-bolder"
                                    data-kt-select2="true" data-placeholder="Select expert" data-allow-clear="true"
                                    data-hide-search="true" id="expertFilter">
                                    <option value=""></option>
                                    <c:forEach items="${requestScope.userList}" var="u">
                                        <c:if test="${u.role.id == 23}">
                                            <option value="${u.userId}" ${requestScope.expertId==u.userId ? 'selected'
                                                : '' }>${u.fullname}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-10 me-3">
                                <label class="form-label fs-6 fw-bold">Status:</label>
                                <select class="selectFilter form-select form-select-solid fw-bolder"
                                    data-kt-select2="true" data-placeholder="Select status" data-allow-clear="true"
                                    data-hide-search="true" id="statusFilter">
                                    <option value="" ${requestScope.status=='' ? 'selected' : '' }></option>
                                    <option value="1" ${requestScope.status=='1' ? 'selected' : '' }>Active</option>
                                    <option value="0" ${requestScope.status=='0' ? 'selected' : '' }>Inactive</option>
                                </select>
                            </div>
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
                                class="form-control form-control-solid w-250px ps-14" placeholder="Search"
                                style="margin-right: 10px;" id="searchRg" value="${requestScope.searchRg}" />
                            <button type="button" class="btn btn-primary mb-3" style="margin-top: 10px;"
                                onclick="list(1)">
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
                            <form action="/subject/list?action=get&subjectId=-1" method="post">
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
                                    <!--end::Svg Icon-->Add Subject
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
                                <th class="min-w-125px">Subject Code</th>
                                <th class="min-w-125px">Subject Name</th>
                                <th class="min-w-125px">Manager</th>
                                <th class="min-w-125px">Expert</th>
                                <th class="min-w-125px">Status</th>
                                <th class="min-w-75px">Actions</th>
                            </tr>
                            <!--end::Table row-->
                        </thead>
                        <!--end::Table head-->
                        <!--begin::Table body-->
                        <tbody class="text-gray-900 fw-bold">
                            <!--begin::Table row-->
                            <c:forEach items="${requestScope.subjectList}" var="s">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td><a onclick="details(${s.subjectId})"><b
                                                class="text-gray-800">${s.subjectCode}</b></a></td>
                                    <td><a onclick="details(${s.subjectId})"><b
                                                class="text-gray-800">${s.subjectName}</b></a></td>
                                    <td>
                                        <c:forEach items="${requestScope.userList}" var="u">
                                            ${s.managerId == u.userId ? u.fullname : ''}
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:forEach items="${requestScope.userList}" var="u">
                                            ${s.expertId == u.userId ? u.fullname : ''}
                                        </c:forEach>
                                    </td>
                                    <!--begin::Action=-->
                                    <td>
                                        <c:if test="${s.statusId == 1}">
                                            <div class="btn btn-success">Active</div>
                                        </c:if>
                                        <c:if test="${s.statusId == 0}">
                                            <div class="btn btn-danger">Inactive</div>
                                        </c:if>
                                    </td>
                                    <td style="width: 75px">
                                        <div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                id="dropdownMenuButton1" data-bs-toggle="dropdown"
                                                aria-expanded="false">
                                                Actions
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                                <c:if test="${s.statusId==1}">
                                                    <li>
                                                        <button
                                                            onclick="changeStatus('${s.subjectId}', '${s.subjectName}', 'deactivate')"
                                                            type="button" class="dropdown-item" data-bs-toggle="modal"
                                                            data-bs-target="#exampleModal">
                                                            Deactivate
                                                        </button>
                                                    </li>
                                                </c:if>
                                                <c:if test="${s.statusId == 0}">
                                                    <li>
                                                        <button
                                                            onclick="changeStatus('${s.subjectId}', '${s.subjectName}', 'activate')"
                                                            type="button" class="dropdown-item" data-bs-toggle="modal"
                                                            data-bs-target="#exampleModal">
                                                            Activate
                                                        </button>
                                                    </li>
                                                </c:if>
                                                <li><a class="dropdown-item"
                                                        onclick="details(${s.subjectId})">Details</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                    <!--end::Action=-->
                                </tr>
                                <!--end::Table row-->
                            </c:forEach>
                        </tbody>
                        <!--end::Table body-->
                    </table>
                    <!--end::Table-->
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
                </div>
                <!--end::Card body-->
            </div>
            <!--end::Card-->
        </div>
        <!--end::Container-->
    </div>
    <!--end::Post-->

    <!--form search filter paging status-->
    <form hidden id="form1" action="/subject/list?action=list" method="post">
        <input id="managerId" name="managerId" />
        <input id="expertId" name="expertId" />
        <input id="status" name="status" />
        <input id="search" name="search" />
        <input id="curPage" name="curPage" />
    </form>

    <form id="form2" action="" method="post">
        <input hidden id="subjectId" name="subjectId" />
    </form>

    <!-- Modal status -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Subject</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="content_modal">

                </div>
                <div class="modal-footer">
                    <button onclick="document.getElementById('form2').submit();" id="btn_cf" type="submit"
                        class="btn btn-primary">Confirm</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>


    <div id="successToast">
        <i style="color: #fff; font-size: 23px" class="fa fa-check me-4"></i>
        <span style="font-size: 16px">Successfully !!!</span>
    </div>



    <script type="text/javascript">
        function list(page) {
            document.getElementById('managerId').value = document.getElementById('managerFilter').value;
            document.getElementById('expertId').value = document.getElementById('expertFilter').value;
            document.getElementById('status').value = document.getElementById('statusFilter').value;
            document.getElementById('search').value = document.getElementById('searchRg').value;
            document.getElementById('curPage').value = page;
            document.getElementById('form1').submit();
        }

        function changeStatus(subjectId, subjectName, action) {
            document.getElementById('content_modal').innerHTML =
                'Do you want to ' + action + " " + subjectName + "?";
            document.getElementById('subjectId').value = subjectId;
            document.getElementById('form2').action = '/subject/list?action=changeStatus';
        }

        function details(subjectId) {
            document.getElementById('subjectId').value = subjectId;
            document.getElementById('form2').action = '/subject/list?action=get';
            document.getElementById('form2').submit();
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