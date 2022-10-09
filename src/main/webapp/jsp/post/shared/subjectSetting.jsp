<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    a:hover {
        cursor: pointer !important;
    }
</style>
<!--begin::Post-->
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
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
                               class="form-control form-control-solid w-250px ps-14" placeholder="Search subject setting"
                               style="margin-right: 5px;" id="search" value="${requestScope.searchRg}"/>
                        <button type="button" class="btn btn-primary mb-3"
                                style="margin-top: 10px;"
                                onclick="
                                        list(getSearchRg(),
                                                getSubjectFilter(),
                                                getTitleFilter(),
                                                getDisplayOrderFilter(),
                                                getStatusFilter(), getSort(), '1')
                                ">
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
                                    <label class="form-label fs-6 fw-bold">Subject:</label>
                                    <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                            data-placeholder="Select option" data-allow-clear="true"
                                            data-hide-search="true" id="subject">
                                        <option ${requestScope.subjectFilter == '' ? 'selected' : ''}></option>
                                        <c:forEach items="${requestScope.subjectList}" var="s">
                                            <option value="${s.subjectId}"
                                                    ${requestScope.subjectFilter == s.subjectId ? 'selected' : ''}>
                                                ${s.subjectName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-10">
                                    <label class="form-label fs-6 fw-bold">Setting title:</label>
                                    <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                            data-placeholder="Select option" data-allow-clear="true"
                                            data-hide-search="true" id="title">
                                        <option ${requestScope.titleFilter == '' ? 'selected' : ''}></option>
                                        <option value="1" ${requestScope.titleFilter == '1' ? 'selected' : ''}>Marks</option>
                                        <option value="2" ${requestScope.titleFilter == '2' ? 'selected' : ''}>Learning Progress</option>
                                        <option value="3" ${requestScope.titleFilter == '3' ? 'selected' : ''}>Complexity</option>
                                        <option value="4" ${requestScope.titleFilter == '4' ? 'selected' : ''}>Lecturers</option>
                                    </select>
                                </div>
                                <div class="mb-10">
                                    <label class="form-label fs-6 fw-bold">Setting order:</label>
                                    <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                            data-placeholder="Select option" data-allow-clear="true"
                                            data-hide-search="true" id="displayOrder">
                                        <option ${requestScope.displayOrderFilter == '' ? 'selected' : ''}></option>
                                        <option value="1" ${requestScope.displayOrderFilter == '1' ? 'selected' : ''}>Simple</option>
                                        <option value="2" ${requestScope.displayOrderFilter == '2' ? 'selected' : ''}>Normal</option>
                                        <option value="3" ${requestScope.displayOrderFilter == '3' ? 'selected' : ''}>Complex</option>
                                    </select>
                                </div>
                                <div class="mb-10">
                                    <label class="form-label fs-6 fw-bold">Status:</label>
                                    <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                                            data-placeholder="Select option" data-allow-clear="true"
                                            data-hide-search="true" id="status">
                                        <option ${requestScope.statusFilter == '' ? 'selected' : ''}></option>
                                        <option value="1" ${requestScope.statusFilter == '1' ? 'selected' : ''}>Active</option>
                                        <option value="0" ${requestScope.statusFilter == '0' ? 'selected' : ''}>Inactive</option>
                                    </select>
                                </div>
                                <!--end::Input group-->
                                <!--begin::Actions-->
                                <div class="d-flex justify-content-end">
                                    <button type="reset"
                                            class="btn btn-white btn-active-light-primary fw-bold me-2 px-6"
                                            data-kt-menu-dismiss="true"
                                            onclick="list(getSearchRg(),
                                                            '',
                                                            '',
                                                            '',
                                                            '', getSort(), '${requestScope.currentPage}')
                                            ">
                                        Reset
                                    </button>
                                    <button type="submit" class="btn btn-primary fw-bold px-6"
                                            data-kt-menu-dismiss="true"
                                            onclick="
                                                    list(getSearchRg(),
                                                            getSubjectFilter(),
                                                            getTitleFilter(),
                                                            getDisplayOrderFilter(),
                                                            getStatusFilter(), getSort(), '1')
                                            ">
                                        Apply
                                    </button>
                                </div>
                                <!--end::Actions-->
                            </div>
                            <!--end::Content-->
                        </div>
                        <!--end::Menu 1-->
                        <!--end::Filter-->

                        <!--begin::Add user-->
                        <a href="/addSubjectSetting">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#kt_modal_add_user">
                                <!--begin::Svg Icon | path: icons/duotone/Navigation/Plus.svg-->
                                <span class="svg-icon svg-icon-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                         width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                        <rect fill="#000000" x="4" y="11" width="16" height="2" rx="1" />
                                        <rect fill="#000000" opacity="0.5"
                                              transform="translate(12.000000, 12.000000) rotate(-270.000000) translate(-12.000000, -12.000000)"
                                              x="4" y="11" width="16" height="2" rx="1" />
                                    </svg>
                                </span>
                                <!--end::Svg Icon-->Add Subject Setting
                            </button>
                        </a>
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
                            <th></th>
                            <th class="min-w-125px">Setting ID</th>
                            <th class="min-w-125px">Setting Title</th>
                            <th class="min-w-125px">Subject Name</th>
                            <th class="min-w-125px">Setting Order</th>
                            <th class="min-w-125px">Status Action</th>
                            <th class="min-w-100px">Details</th>
                        </tr>
                        <!--end::Table row-->
                    </thead>
                    <!--end::Table head-->
                    <!--begin::Table body-->
                    <tbody class="text-gray-600 fw-bold">
                        <!--begin::Table row-->
                        <c:forEach items="${requestScope.ssList}" var="ss">
                            <tr>
                                <td></td>
                                <td></td>   
                                <td></td>
                                <td>${ss.settingId}</td>
                                <!--begin::User=-->
                                <td class="align-items-center">
                                    <!--begin::User details-->
                                    <div class="flex-column">
                                        <a onclick="viewDetails('${ss.settingId}')"
                                           class="text-gray-800 mb-1">${ss.title}</a>
                                    </div>
                                </td>
                                <td>${ss.subjectName}</td>
                                <td>
                                    ${ss.displayOrder == '0' ? '' : ss.displayOrder}
                                </td>
                                <td>
                                    <c:if test="${ss.statusId==1}">
                                        <button onclick="loaddata('${ss.settingId}', '${ss.title}', '${ss.subjectName}', 'inactivate')"
                                                type="button" class="btn btn-danger" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal">
                                            Inactivate
                                        </button>
                                    </c:if>
                                    <c:if test="${ss.statusId!=1}">
                                        <button onclick="loaddata('${ss.settingId}', '${ss.title}', '${ss.subjectName}', 'activate')"
                                                type="button" class="btn btn-success" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal">
                                            Activate
                                        </button>
                                    </c:if>
                                </td>
                                <!--begin::Action=-->
                                <td>
                                    <button onclick="viewDetails('${ss.settingId}')" type="button" class="btn btn-secondary">
                                        Details
                                    </button>
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
                <div>
                    <nav aria-label="...">
                        <ul class="pagination pagination-lg">
                            <c:forEach items="${requestScope.pages}" var="p">
                                <li class="page-item ${requestScope.currentPage == p ? 'active' : ''}">
                                    <button class="page-link"
                                            onclick="
                                                    list(getSearchRg(),
                                                            getSubjectFilter(),
                                                            getTitleFilter(),
                                                            getDisplayOrderFilter(),
                                                            getStatusFilter(), getSort(), '${p}')
                                            ">
                                        ${p}
                                    </button>
                                </li>
                            </c:forEach>
                        </ul>
                    </nav>  
                </div>
            </div>
            <!--end::Card body-->
        </div>
        <!--end::Card-->
    </div>
    <!--end::Container-->
</div>
<!--end::Post-->

<form hidden id="formList" action="/subjectSetting" method="post">
    <input name="action" value="list"/>
    <input name="searchRg" value="" id="searchInp"/>
    <input name="subjectFilter" value="" id="subjectInp"/>
    <input name="titleFilter" value="" id="titleInp"/>
    <input name="displayOrderFilter" value="" id="displayOrderInp"/>
    <input name="statusFilter" value="" id="statusInp"/>
    <input name="sort" value="" id="sortInp"/>
    <input name="pageNo" value="" id="pageNo"/>
</form>

<form hidden id="formChangeStatus" action="/subjectSetting" method="post">
    <input name="action" value="changeStatus"/>
    <input name="settingId" value="" id="settingIdInp"/>
</form>

<form hidden id="formDetails" action="/subjectSetting" method="post">
    <input name="action" value="get"/>
    <input name="settingId" value="" id="settingIdInp1"/>
</form>

<!-- Modal status -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Subject Setting</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="content_modal">

            </div>
            <div class="modal-footer">
                <button id="btn_cf" onclick="cf()" type="button" class="btn btn-primary">Confirm</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    function getSearchRg() {
        return document.getElementById('search').value;
    }
    function getSubjectFilter() {
        return document.getElementById('subject').value;
    }
    function getTitleFilter() {
        return document.getElementById('title').value;
    }
    function getDisplayOrderFilter() {
        return document.getElementById('displayOrder').value;
    }
    function getStatusFilter() {
        return document.getElementById('status').value;
    }
    function getSort() {
        return "";
    }

    function list(search, subjectFilter, titleFilter, displayOrderFilter, statusFilter, sort, pageNo) {
        document.getElementById('searchInp').value = search;
        document.getElementById('subjectInp').value = subjectFilter;
        document.getElementById('titleInp').value = titleFilter;
        document.getElementById('displayOrderInp').value = displayOrderFilter;
        document.getElementById('statusInp').value = statusFilter;
        document.getElementById('sortInp').value = "";
        document.getElementById('pageNo').value = pageNo;
        document.getElementById('formList').submit();
    }

    function loaddata(settingId, title, subjectName, action) {
        document.getElementById('content_modal').innerHTML = "Do you want to <b>"
                + action + "</b> setting <b>" + title + "</b> of <b>" + subjectName + "</b>";
        document.getElementById('settingIdInp').value = settingId;
    }

    function cf() {
        document.getElementById('formChangeStatus').submit();
    }

    function viewDetails(settingId) {
        document.getElementById('settingIdInp1').value = settingId;
        document.getElementById('formDetails').submit();
    }
</script>