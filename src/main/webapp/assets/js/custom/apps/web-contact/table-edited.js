"use strict";

// Class definition
var KTDatatablesServerSide = (function () {
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
      order: [[0, "asc"]],
      stateSave: true,
      select: {
        style: "multi",
        selector: 'td:first-child input[type="checkbox"]',
        className: "row-selected",
      },
      ajax: {
        url: window.location.origin + "/webcontact/list?action=list",
        type: "POST",
        data: {
          supId: () => {return $("#selectSup").val()},
        },
      },
      columns: [
        { data: "id" },
        { data: "full_name" },
        { data: "email" },
        { data: "mobile" },
        { data: "date" },
        { data: "suporter" },
        { data: "category_id" },
      ],
      columnDefs: [
        {
          targets: 0,
          title: "ID",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 1,
          title: "FULL NAME",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 2,
          title: "EMAIL",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 3,
          title: "MOBILE",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 4,
          title: "DATE",
          className: "text-center",
          render: function (data) {
            return moment(data).format("DD/MM/YYYY HH:mm:ss");
          },
        },
        {
          targets: 5,
          title: "SUPPORTER",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 6,
          title: "ACTIONS",
          className: "text-center",
          render: function (data) {
            return `
                        <td>
                            <div class="d-flex justify-content-center">
                                <form action="/webcontact/list" method="post">
                                    <input type="hidden" name="action" value="get">
                                    <input name="categoryId" type="hidden" value="${data}">
                                    <button type="submit" class="btn btn-secondary">
                                        View
                                    </button>
                                </form>
                            </div>
                        </td>
                        `;
          },
        },
      ],
    });
    table = dt.$;
    $("#selectSup").on("change", function () {
        dt.draw();
    });
  };

  // Search Datatable --- official docs reference: https://datatables.net/reference/api/search()
  var handleSearchDatatable = function () {
    const filterSearch = document.querySelector(
      '[data-kt-user-table-filter="search"]'
    );
    filterSearch.addEventListener("keyup", function (e) {
      dt.search(e.target.value).draw();
    });
  };

  // Public methods
  return {
    init: function () {
      initDatatable();
      handleSearchDatatable();
    },
  };
})();

// On document ready
KTUtil.onDOMContentLoaded(function () {
  KTDatatablesServerSide.init();
});
