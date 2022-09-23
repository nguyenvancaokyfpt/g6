"use strict";

// Class definition
var KTDatatablesServerSide = function () {
    // Shared variables
    var table;
    var dt;
    var filterPayment;

    // Private functions
    var initDatatable = function () {
        dt = $("#kt_table_users").DataTable({
            searchDelay: 50,
            processing: true,
            serverSide: true,
            order: [[3, 'desc']],
            stateSave: true,
            select: {
                style: 'multi',
                selector: 'td:first-child input[type="checkbox"]',
                className: 'row-selected'
            },
            ajax: {
                url: window.location.origin + "/management/user?action=list",
                type: "POST"
            },
            columns: [
                { data: 'userId' },
                { data: 'avatarUrl' },
                { data: 'userId' },
                { data: 'lastActive' },
                { data: 'createdAt' },
                { data: 'userId' },
            ],
            columnDefs: [
                {
                    targets: 0,
                    orderable: false,
                    render: function (data) {
                        return `
                        <!--begin::Checkbox-->
                        <td>
                            <div class="form-check form-check-sm form-check-custom form-check-solid">
                                <input class="form-check-input" type="checkbox" value="`+ data  +`" />
                            </div>
                        </td>
                        <!--end::Checkbox-->
                        `;
                    }
                },
                {
                    targets: 1,
                    title: 'User',
                    className: 'd-flex align-items-center',
                    render: function (data, type, row) {
                        return `
                        <!--begin::User=-->
                            <td class="d-flex align-items-center">
                                <!--begin:: Avatar -->
                                <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
                                    <a href="/users/detail?id=`+ row.userId +`">
                                        <div class="symbol-label">
                                            <img src="`+ data +`" alt="Emma Smith" class="w-100" />
                                        </div>
                                    </a>
                                </div>
                                <!--end::Avatar-->
                                <!--begin::User details-->
                                <div class="d-flex flex-column">
                                    <a href="/users/detail?id=`+ row.userId +`" class="text-gray-800 text-hover-primary mb-1">`+ row.fullname +`</a>
                                    <span>`+ row.email +`</span>
                                </div>
                                <!--begin::User details-->
                            </td>
                        <!--end::User=-->
                        `
                    }
                },
                {
                    targets: 2,
                    title: 'Role',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 3,
                    title: 'Last Active',
                    className: 'text-center',
                    render: function (data) {
                        return moment(data).format('DD/MM/YYYY HH:mm:ss');
                    }
                },
                {
                    targets: 4,
                    title: 'Joined Date',
                    className: 'text-center',
                    render: function (data) {
                        return moment(data).format('DD/MM/YYYY');
                    }
                },
                { 
                    targets: 5,
                    title: 'Actions',
                    orderable: false,
                    className: 'text-end',
                    render: function (data, type, row) {
                        return `
                        <!--begin::Action=-->
                        <td class="text-end">
                            <a href="#" class="btn btn-light btn-active-light-primary btn-sm" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end" data-kt-menu-flip="top-end">Actions
                            <!--begin::Svg Icon | path: icons/duotone/Navigation/Angle-down.svg-->
                            <span class="svg-icon svg-icon-5 m-0">
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                        <polygon points="0 0 24 0 24 24 0 24" />
                                        <path d="M6.70710678,15.7071068 C6.31658249,16.0976311 5.68341751,16.0976311 5.29289322,15.7071068 C4.90236893,15.3165825 4.90236893,14.6834175 5.29289322,14.2928932 L11.2928932,8.29289322 C11.6714722,7.91431428 12.2810586,7.90106866 12.6757246,8.26284586 L18.6757246,13.7628459 C19.0828436,14.1360383 19.1103465,14.7686056 18.7371541,15.1757246 C18.3639617,15.5828436 17.7313944,15.6103465 17.3242754,15.2371541 L12.0300757,10.3841378 L6.70710678,15.7071068 Z" fill="#000000" fill-rule="nonzero" transform="translate(12.000003, 11.999999) rotate(-180.000000) translate(-12.000003, -11.999999)" />
                                    </g>
                                </svg>
                            </span>
                            <!--end::Svg Icon--></a>
                            <!--begin::Menu-->
                            <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold fs-7 w-125px py-4" data-kt-menu="true">
                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="apps/user-management/users/view.html" class="menu-link px-3">Edit</a>
                                </div>
                                <!--end::Menu item-->
                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-users-table-filter="delete_row">Delete</a>
                                </div>
                                <!--end::Menu item-->
                            </div>
                            <!--end::Menu-->
                        </td>
                        <!--end::Action=-->
                        `;
                    }
                }
            ],
        });

        table = dt.$;

    }

    // Search Datatable --- official docs reference: https://datatables.net/reference/api/search()
    var handleSearchDatatable = function () {
        const filterSearch = document.querySelector('[data-kt-user-table-filter="search"]');
        filterSearch.addEventListener('keyup', function (e) {
            dt.search(e.target.value).draw();
        });
    }


    // Public methods
    return {
        init: function () {
            initDatatable();
            handleSearchDatatable();
        }
    }
}();

// On document ready
KTUtil.onDOMContentLoaded(function () {
    KTDatatablesServerSide.init();
});