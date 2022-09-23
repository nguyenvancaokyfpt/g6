"use strict";

// Class definition
var KTDatatablesServerSide = function () {
    // Shared variables
    var table;
    var dt;
    var filterPayment;

    // Private functions
    var initDatatable = function () {
        dt = $("#kt_table_web_contact").DataTable({
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
                url: window.location.origin + "/webcontact/webcontactlist?action=list",
                type: "POST"
            },
            columns: [
                { data: 'category_id' },
                { data: 'category_id' },
                { data: 'full_name' },
                { data: 'email' },
                { data: 'mobile' },
                { data: 'message' },
                { data: 'response' },
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
                    title: 'ID',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 2,
                    title: 'FULL NAME',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 3,
                    title: 'EMAIL',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 4,
                    title: 'MOBILE',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 5,
                    title: 'MASSAGE',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                {
                    targets: 6,
                    title: 'RESPONSE',
                    className: 'text-center',
                    render: function (data) {
                        return data;
                    }
                },
                
                
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