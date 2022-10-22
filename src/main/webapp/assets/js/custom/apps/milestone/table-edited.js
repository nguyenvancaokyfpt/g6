/* global KTUtil, moment */

"use strict";

// Class definition
var KTDatatablesServerSide = function () {
    // Shared variables
    var table;
    var dt;
    // Private functions
    var initDatatable = function () {
        dt = $("#kt_table_milestone").DataTable({
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
                url: window.location.origin + "/milestone/list?action=list",
                type: "POST"
            },
            columns: [
                 { data: 'milestoneId'},
                 { data: 'milestoneId'},
                 { data: 'title' },
                { data: 'classCode' },
                { data: 'fromDate' },
                { data: 'toDate' },
                { data: 'assTitle'},
                { data: 'statusId' },
                { data: 'milestoneId'}
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
                                <input class="form-check-input" type="checkbox" value="`+ data + `" />
                            </div>
                        </td>
                        <!--end::Checkbox-->
                        `;
                    }
                },
                {
                    targets: 1,
                    title: 'ID',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 2,
                    title: 'MILESTONE NAME',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 3,
                    title: 'CLASS',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 4,
                    title: 'FROM DATE',
                    className: 'text-center',
                    render: function (data) {
                        return moment(data).format("DD/MM/YYYY");
                    }
                },
                {
                    targets: 5,
                    title: 'TO DATE',
                    className: 'text-center',
                    render: function (data) {
                        return moment(data).format("DD/MM/YYYY");
                    }
                },
                    {
                    targets: 6,
                    title: 'ASSIGNMENT TITLE',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                  {
              targets: 7,
              title: "STATUS",
              class: "text-center",
              render: function (data) {
                switch (data) {
                  case 0:
                    return (
                      `<div href="#" class="badge badge-light-success fs-7">Active</div>`
                    );
                  case 1:
                    return (
                     `<div href="#" class="badge badge-light-danger fs-7">In Active</div>`
                    );
                }
                }
            },
                {
                    targets: 8,
                    title: 'ACTION',
                    className: 'text-center',
                    render: function (data) {
                        return  `
                        <td>
                            <div class="d-flex justify-content-center">
                                <form action="/milestone/list?action=get" method="post">
                                    <input type="hidden" name="action" value="get">
                                    <input name="milestoneId" type="hidden" value="${data}">
                                    <button type="submit" class="btn btn-secondary">
                                        View
                                    </button>
                                </form>
                            </div>
                        </td>
                        `;
                    }
                }

            ]
        });

        table = dt.$;
    };
    // Search Datatable --- official docs reference: https://datatables.net/reference/api/search()
    var handleSearchDatatable = function () {
        const filterSearch = document.querySelector('[data-kt-milestone-table-filter="search"]');
        filterSearch.addEventListener('keyup', function (e) {
               dt.search(e.target.value).draw();
               console.log(e.target.value);
        });
    };
    // Public methods
    return {
        init: function () {
            initDatatable();
            handleSearchDatatable();
        }
    };
}();

// On document ready
KTUtil.onDOMContentLoaded(function () {
    KTDatatablesServerSide.init();
});