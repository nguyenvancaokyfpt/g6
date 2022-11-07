<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="post d-flex flex-column-fluid" id="kt_post">
    <!--begin::Container-->
    <div id="kt_content_container" class="container">
        <div class="card">

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
                                    <rect x="0" y="0" width="24" height="24"></rect>
                                    <path
                                        d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z"
                                        fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
                                    <path
                                        d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z"
                                        fill="#000000" fill-rule="nonzero"></path>
                                </g>
                            </svg>
                        </span>
                        <!--end::Svg Icon-->
                        <form action="/class/list">
                            <input name="searchword" type="text" data-kt-customer-table-filter="search"
                                   class="form-control form-control-solid w-250px ps-15"
                                   placeholder="Search Class Code" value="${searchword}">
                        </form>
                    </div>
                    <!--end::Search-->
                </div>

                <!--begin::Card title-->
                <!--begin::Card toolbar-->
                <div class="card-toolbar">
                    <!--begin::Toolbar-->
                    <div class="d-flex justify-content-end" data-kt-customer-table-toolbar="base">
                        <!--begin::Filter-->
                        <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click"
                                data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">
                            <!--begin::Svg Icon | path: icons/duotone/Text/Filter.svg-->
                            <span class="svg-icon svg-icon-2">
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                     width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                        <rect x="0" y="0" width="24" height="24"></rect>
                                        <path
                                            d="M5,4 L19,4 C19.2761424,4 19.5,4.22385763 19.5,4.5 C19.5,4.60818511 19.4649111,4.71345191 19.4,4.8 L14,12 L14,20.190983 C14,20.4671254 13.7761424,20.690983 13.5,20.690983 C13.4223775,20.690983 13.3458209,20.6729105 13.2763932,20.6381966 L10,19 L10,12 L4.6,4.8 C4.43431458,4.5790861 4.4790861,4.26568542 4.7,4.1 C4.78654809,4.03508894 4.89181489,4 5,4 Z"
                                            fill="#000000"></path>
                                    </g>
                                </svg>
                            </span>
                            <!--end::Svg Icon-->Filter
                        </button>
                        <!--begin::Menu 1-->
                        <div class="menu menu-sub menu-sub-dropdown w-300px w-md-325px" data-kt-menu="true">
                            <!--begin::Separator-->
                            <div class="separator border-gray-200"></div>
                            <!--end::Separator-->
                            <form action="/class/list">
                                <!--begin::Content-->
                                <div class="px-7 py-5">
                                    <!--begin::Input group-->
                                    <div class="mb-5">
                                        <!--begin::Label-->
                                        <label class="form-label fs-5 fw-bold mb-3">Term</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <select
                                            class="form-select form-select-solid fw-bolder select2-hidden-accessible h-35px"
                                            data-kt-select2="true" data-placeholder="Select option"
                                            aria-hidden="true" name="term">
                                            <option data-select2-id="select2-data-12-dqg1"></option>
                                            <c:forEach items="${termList}" var="tl">
                                                <option value="${tl.title}">${tl.title}</option>
                                            </c:forEach>
                                        </select>
                                        <!--end::Input-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-5">
                                        <!--begin::Label-->
                                        <label class="form-label fs-5 fw-bold mb-3">Subject</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <select
                                            class="form-select form-select-solid fw-bolder select2-hidden-accessible h-35px"
                                            data-kt-select2="true" data-placeholder="Select option"
                                            aria-hidden="true" name="subject">
                                            <option data-select2-id="select2-data-12-dqg1"></option>
                                            <c:forEach items="${subjectList}" var="tl">
                                                <option value="${tl.subjectCode}">${tl.subjectCode}</option>
                                            </c:forEach>
                                        </select>
                                        <!--end::Input-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-5">
                                        <!--begin::Label-->
                                        <label class="form-label fs-5 fw-bold mb-3">Trainer</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <select
                                            class="form-select form-select-solid fw-bolder select2-hidden-accessible h-35px"
                                            data-kt-select2="true" data-placeholder="Select option"
                                            aria-hidden="true" name="trainer">
                                            <option data-select2-id="select2-data-12-dqg1"></option>
                                            <c:forEach items="${trainerList}" var="trl">
                                                <option value="${trl.trainer_id}">${trl.trainerString}</option>
                                            </c:forEach>
                                        </select>
                                        <!--end::Input-->
                                    </div>
                                    <!--end::Input group-->                                  
                                    <!--begin::Input group-->
                                    <div class="mb-5">
                                        <!--begin::Label-->
                                        <label class="form-label fs-5 fw-bold mb-3">Status</label>
                                        <!--end::Label-->
                                        <!--begin::Options-->
                                        <div class="d-flex flex-column flex-wrap fw-bold">
                                            <!--begin::Option-->
                                            <label
                                                class="form-check form-check-sm form-check-custom form-check-solid mb-3 me-5">
                                                <input class="form-check-input" type="radio" name="status" value=""
                                                       checked="checked">
                                                    <span class="form-check-label text-gray-600">All</span>
                                            </label>
                                            <!--end::Option-->
                                            <!--begin::Option-->
                                            <label
                                                class="form-check form-check-sm form-check-custom form-check-solid mb-3 me-5">
                                                <input class="form-check-input" type="radio" name="status"
                                                       value="active">
                                                    <span class="form-check-label text-gray-600">Active</span>
                                            </label>
                                            <!--end::Option-->
                                            <!--begin::Option-->
                                            <label
                                                class="form-check form-check-sm form-check-custom form-check-solid mb-3 me-5">
                                                <input class="form-check-input" type="radio" name="status"
                                                       value="inactive">
                                                    <span class="form-check-label text-gray-600">Inactive</span>
                                            </label>
                                            <!--end::Option-->
                                        </div>
                                        <!--end::Options-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Actions-->
                                    <div class="d-flex justify-content-end">
                                        <button type="submit" class="btn btn-primary">Apply</button>
                                    </div>
                                    <!--end::Actions-->
                                </div>
                                <!--end::Content-->
                                <input type="hidden" name="searchword" value="${searchword}">
                            </form>
                        </div>
                        <!--end::Menu 1-->
                        <!--end::Filter-->
                        <!--begin::Add customer-->
                        <a type="button" class="btn btn-primary" href="/class/list?action=create">
                            <!--begin::Svg Icon | path: icons/duotone/Navigation/Plus.svg-->
                            <span class="svg-icon svg-icon-2">
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                     width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                    <rect fill="#000000" x="4" y="11" width="16" height="2" rx="1"></rect>
                                    <rect fill="#000000" opacity="0.5"
                                          transform="translate(12.000000, 12.000000) rotate(-270.000000) translate(-12.000000, -12.000000)"
                                          x="4" y="11" width="16" height="2" rx="1"></rect>
                                </svg>
                            </span>
                            <!--end::Svg Icon-->Add Class
                        </a>
                        <!--end::Add customer-->
                    </div>
                    <!--end::Toolbar-->
                </div>
                <!--end::Card toolbar-->
            </div>
            <!--begin::Card-->
            <div class="card">
                <!--begin::Card Body-->
                <div class="card-body fs-6 p-10 p-lg-15">
                    <!--begin::Section-->
                    <div class="pb-10">
                        <!--begin::Heading-->
                        <h1 class="anchor fw-bolder mb-5" id="basic-table">
                            <a href="#basic-table"></a>Class List
                        </h1>
                        <!--end::Heading-->
                        <!--begin::Block-->
                        <div class="my-5">
                            <table class="table">
                                <thead>
                                    <tr class="text-gray-600 fw-bold">
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('class_id') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_id&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">ID</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when test="${order.equals('class_id') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_id&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">ID</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_id&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">ID</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('class_code') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_code&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Code</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when test="${order.equals('class_code') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_code&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Code</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=class_code&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Code</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('subject_code') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=subject_code&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Subject</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when test="${order.equals('subject_code') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=subject_code&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Subject</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=subject_code&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Subject</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when
                                                    test="${order.equals('setting_title') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=setting_title&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Term</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when
                                                    test="${order.equals('setting_title') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=setting_title&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Term</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=setting_title&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Term</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('a.full_name') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=a.full_name&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Trainer</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when test="${order.equals('a.full_name') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=a.full_name&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Trainer</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=a.full_name&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Trainer</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('b.full_name') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=b.full_name&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Supporter</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when test="${order.equals('b.full_name') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=b.full_name&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Supporter</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=b.full_name&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Supporter</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>
                                            <c:choose>
                                                <c:when test="${order.equals('status_title') && dir.equals('asc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=status_title&page=${i}&searchword=${searchword}&dir=desc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Status</a>
                                                    <i class="fas fa-sort-amount-down"></i>
                                                </c:when>
                                                <c:when
                                                    test="${order.equals('status_title') && dir.equals('desc')}">
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=status_title&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Status</a>
                                                    <i class="fas fa-sort-amount-up"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-gray-600 fw-bold"
                                                       href="/class/list?order=status_title&page=${i}&searchword=${searchword}&dir=asc&term=${term}&status=${status}&trainer=${trainer}&subject=${subject}">Status</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody id="content">
                                    <c:forEach items="${classList}" var="sl">
                                        <tr class="fw-bold fs-6 text-gray-800 border-bottom border-gray-200">
                                            <td>${sl.class_id}</td>
                                            <td>${sl.class_code}</td>
                                            <td>${sl.subjectString}</td>
                                            <td>${sl.termString}</td>
                                            <td>${sl.trainerString}</td>
                                            <td>${sl.supporterString}</td>
                                            <c:choose>
                                                <c:when test="${sl.statusString=='Active'}">
                                                    <td><span
                                                            class="badge badge-success fw-bold fs-6">${sl.statusString}</span>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><span
                                                            class="badge badge-danger fw-bold fs-6">${sl.statusString}</span>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <a href="/class/detail?id=${sl.class_id}" title="View"><i class='fas fa-eye' style='font-size:24px'></i></a>
                                                <a href="/class/list?id=${sl.class_id}&action=update" title="Edit"><i class='fas fa-edit' style='font-size:24px'></i></a>
                                                    <c:choose>
                                                        <c:when test="${sl.statusString=='Active'}">
                                                        <a href="/class/list?id=${sl.class_id}&page=${i}&searchword=${searchword}&term=${term}&status_id=${sl.status_id}&order=${order}&dir=${dir}&trainer=${trainer}&subject=${subject}&action=delete" title="Deactivate"><i class='fas fa-times-circle' style='font-size:24px'></i></a>
                                                        </c:when>    
                                                        <c:otherwise>
                                                        <a href="/class/list?id=${sl.class_id}&page=${i}&searchword=${searchword}&term=${term}&status_id=${sl.status_id}&order=${order}&dir=${dir}&trainer=${trainer}&subject=${subject}&action=delete" title="Activate"><i class='fas fa-check-square' style='font-size:24px'></i></a>
                                                        </c:otherwise>
                                                    </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="pagination float-end">
                                <c:forEach begin="1" end="${endPage}" var="i">
                                    <c:choose>
                                        <c:when test="${i == page}">
                                            <a class="btn btn-icon btn-bg-primary"
                                               href="/class/list?page=${i}&searchword=${searchword}&term=${term}&status=${status}&order=${order}&dir=${dir}&subject=${subject}&trainer=${trainer}">${i}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-icon btn-active-light-primary"
                                               href="/class/list?page=${i}&searchword=${searchword}&term=${term}&status=${status}&order=${order}&dir=${dir}&subject=${subject}&trainer=${trainer}">${i}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
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