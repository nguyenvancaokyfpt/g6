<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    label {
        width: 100px;
        margin: 5px 0;
    }

    .nav_search_and_add {
        display: flex;
        justify-content: space-between;
        padding: 0 7%;
    }
</style>
<div class="nav_search_and_add">
    <div class="row g-3">
        <div class="col-auto">
            <label for="search_form" class="visually-hidden">Search</label>
            <input type="search" value="${requestScope.searchRg}" class="form-control" onkeyup="getSearchRg()"
                   id="search_form" placeholder="Search" />
        </div>
        <div class="col-auto">
            <button type="button" onclick="paging_search_filter(getSearchRg(), getFilterStatus(), 1)"
                    class="btn btn-primary mb-3">Search</button>
        </div>
    </div>
    <div>
        <!--begin::Filter-->
        <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click"
                data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">
            <!--begin::Svg Icon | path: icons/duotone/Text/Filter.svg-->
            <span class="svg-icon svg-icon-2">
                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                     height="24px" viewBox="0 0 24 24" version="1.1">
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
                    <label class="form-label fs-6 fw-bold">Status:</label>
                    <select class="form-select form-select-solid fw-bolder" data-kt-select2="true"
                            data-placeholder="Select option" data-allow-clear="true" data-kt-user-table-filter="status"
                            data-hide-search="true" id="filterStatus" onchange="getFilterStatus()">
                        <option ${requestScope.filterStatus=='' ?'selected':''}></option>
                        <option value="1" ${requestScope.filterStatus=='1' ?'selected':''}>Active</option>
                        <option value="0" ${requestScope.filterStatus=='0' ?'selected':''}>Inactive</option>
                    </select>
                </div>
                <!--end::Input group-->
                <!--begin::Actions-->
                <div class="d-flex justify-content-end">
                    <button type="button" class="btn btn-white btn-active-light-primary fw-bold me-2 px-6"
                            data-kt-menu-dismiss="true" data-kt-user-table-filter="reset"
                            onclick="paging_search_filter(getSearchRg(), '', 1)">
                        Reset
                    </button>
                    <button type="button" class="btn btn-primary fw-bold px-6" data-kt-menu-dismiss="true"
                            data-kt-user-table-filter="filter"
                            onclick="paging_search_filter(getSearchRg(), getFilterStatus(), 1)">
                        Apply
                    </button>
                </div>
                <!--end::Actions-->
            </div>
            <!--end::Content-->
        </div>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addSubject">
            Add Subject
        </button>
    </div>

</div>
<section class="bg-light py-4 my-5">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 class="mb-3 text-primary">Subject List</h2>
            </div>
            <c:forEach items="${requestScope.subjectList}" var="s">
                <div class="col-md-6 col-lg-4">
                    <div class="card my-3 subject_card">
                        <img style="height: 300px" onclick="viewDetails('${s.subjectId}', 'get')"
                             src="${s.imgSrc}" class="card-image-top" alt="thumbnail">
                            <div class="card-body">
                                <h3 class="card-title">
                                    <a onclick="viewDetails('${s.subjectId}', 'get')"
                                       style="color: #181c32">${s.subjectName}</a>
                                </h3>
                                <p class="card-text subject_des">
                                    ${s.body}
                                </p>
                                <a onclick="viewDetails('${s.subjectId}', 'get')" class="btn btn-primary">Read More</a>
                                <c:if test="${s.statusId==1}">
                                    <button onclick="loaddata('${s.subjectId}', '${s.subjectName}', 'inactive')"
                                            type="button" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal">
                                        Inactive
                                    </button>
                                </c:if>
                                <c:if test="${s.statusId!=1}">
                                    <button onclick="loaddata('${s.subjectId}', '${s.subjectName}', 'active')"
                                            type="button" class="btn btn-success" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal">
                                        Active
                                    </button>
                                </c:if>
                            </div>
                    </div>
                </div>
            </c:forEach>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-end">
                    <c:forEach items="${requestScope.pages}" var="p">
                        <li class="page-item">
                            <button class="page-link active"
                                    onclick="paging_search_filter(getSearchRg(), getFilterStatus(), '${p}')">${p}</button>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</section>

<form hidden id="callPost" action="/subject/list" method="post">
    <input type="text" value="" name="subjectId" id="subjectId" />
    <input type="text" value="" name="action" id="action" />
</form>

<form hidden id="paging_search_filter" action="/subject/list" method="post">
    <input type="text" value="find_paging_filter" name="action" />
    <input type="text" value="" name="filterStatus" id="filterStatusInput" />
    <input type="text" value="" name="pageNo" id="pageNo" />
    <input type="text" value="" name="searchRg" id="searchRg" />
</form>

<!-- Modal -->
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
                <button id="btn_cf" onclick="cf()" type="button" class="btn btn-primary">Confirm</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!--add subject-->
<div class="modal fade" id="addSubject" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Subject</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/subject/list" method="post">
                <div class="modal-body">
                    <input hidden type="text" name="action" value="create" />
                    <div class="">
                        <div class="row r1">
                            <div class="col-md-9 abc">
                                <h1>
                                    <label style="width: max-content">Subject Name:</label>
                                    <input type="type" name="subjectName" required/>
                                </h1>
                            </div>
                            <p class="text-right para">
                                <label>Subject code:</label>
                                <input type="type" name="subjectCode" required/>
                            </p>
                        </div>
                    </div>
                    <div class="container-body mt-4">
                        <div class="row r3">
                            <div class="col-md-10 p-0 klo">
                                <ul>
                                    <li>
                                        <label>Expert:</label>
                                        <select name="expertId">
                                            <c:forEach items="${requestScope.userList}" var="u">
                                                <option value="${u.userId}">
                                                    ${u.fullname}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </li>
                                    <li>
                                        <label>Manager:</label>
                                        <select name="managerId">
                                            <c:forEach items="${requestScope.userList}" var="u">
                                                <option value="${u.userId}">
                                                    ${u.fullname}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </li>
                                    <li>
                                        <label>Status:</label>
                                        <input type="radio" name="statusId"
                                               value="0" />Inactive&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="statusId" value="1" checked />Active
                                    </li>
                                    <li>
                                        <label>Description:</label>
                                        <textarea name="body" rows="7" cols="50" required>

                                        </textarea>
                                    </li>
                                    <li>
                                        <label>Image:</label>
                                        <input type="file" name="imgSrc" required/>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Add</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>

    var myModal = document.getElementById('myModal');
    var myInput = document.getElementById('myInput');

    myModal.addEventListener('shown.bs.modal', function () {
        myInput.focus();
    });

    var subjectId;
    var action;
    function loaddata(x, y, z) {
        document.getElementById('content_modal').innerHTML = "Do you want to " + z + " this " + y + " ?";
        subjectId = x;
        action = z;
    }

    function viewDetails(x, y) {
        document.getElementById('subjectId').value = x;
        document.getElementById('action').value = y;
        document.getElementById('callPost').submit();
    }

    function changeStatus() {
        document.getElementById('subjectId').value = subjectId;
        document.getElementById('action').value = 'changeStatus';
        document.getElementById('callPost').submit();
    }

    function cf() {
        document.getElementById('btn_cf').onclick = changeStatus();
    }

    function getSearchRg() {
        return document.getElementById('search_form').value;
    }

    function getFilterStatus() {
        return document.getElementById('filterStatus').value;
    }

    function paging_search_filter(searchRg, filterStatus, pageNo) {
        document.getElementById('searchRg').value = searchRg;
        document.getElementById('filterStatusInput').value = filterStatus;
        document.getElementById('pageNo').value = pageNo;
        document.getElementById('paging_search_filter').submit();
    }

</script>