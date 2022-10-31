/* global KTUtil, moment */

"use strict";

// Class definition
var KTDatatablesServerSide = function () {
    // Shared variables
    var table;
    var dt;
    // Private functions
    var initDatatable = function () {
        dt = $("#kt_table_classEvalCriteria").DataTable({
            searchDelay: 50,
            processing: true,
            serverSide: true,
            order: [[3, 'desc']],
            stateSave: true,
            ajax: {
                url: window.location.origin + "/evalCriteria/classEvalCriteria/list?action=list",
                type: "POST"
            },
            columns: [
                {data: 'id'},
                {data: 'name'},
                {data: 'classCode'},
                {data: 'assignName'},
                {data: 'weight'},
                {data: 'maxLoc'},
                {data: 'isTeam'},
                {data: 'status'},
                {data: 'id'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    title: 'ID',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 1,
                    title: 'NAME',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 2,
                    title: 'CLASS',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 3,
                    title: 'ASSIGNMENT',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 4,
                    title: 'WEIGHT',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 5,
                    title: 'MAX LOC',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 6,
                    title: 'TEAM SHARE',
                    className: 'text-center',
                    render: function (data) {
                        switch (data) {
                            case 0:
                                return (
                                        ` <div class="d-flex justify-content-center">
                                  <button type="submit" class="btn btn-primary">
                                      Individual
                                  </button>
                              
                          </div>`
                                        );
                            case 1:
                                return (
                                        `<div class="d-flex justify-content-center">
                                  <button type="submit" class="btn btn-warning">
                                      Group
                                  </button>
                              
                          </div>`
                                        );
                        }
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
                                <form action="/evalCriteria/classEvalCriteria/list?action=get" method="post">
                                    <input type="hidden" name="action" value="get">
                                    <input name="id" type="hidden" value="${data}">
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
        console.log("abc");
        const filterSearch = document.querySelector('[data-kt-class-evel-criteria-table-filter="submit"]');
        filterSearch.addEventListener('click', function () {
            var classid = document.getElementById('classId');
            console.log(classid.value);
            dt.search(classid.value).draw();

        });
        const searchtext = document.querySelector('[data-kt-class-eval-table-filter="search"]');
        searchtext.addEventListener('keyup', function (e) {
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