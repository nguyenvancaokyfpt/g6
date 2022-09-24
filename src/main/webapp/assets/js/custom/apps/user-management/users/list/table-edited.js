"use strict";

// Class definition
var KTDatatablesServerSide = (function () {
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
      order: [[3, "desc"]],
      stateSave: true,
      select: {
        style: "multi",
        selector: 'td:first-child input[type="checkbox"]',
        className: "row-selected",
      },
      ajax: {
        url: window.location.origin + "/management/user?action=list",
        type: "POST",
      },
      columns: [
        { data: "userId" },
        { data: "userId" },
        { data: "avatarUrl" },
        { data: "mobile" },
        { data: "lastActive" },
        { data: "createdAt" },
        { data: "statusId" },
      ],
      columnDefs: [
        {
          targets: 0,
          orderable: false,
          render: function (data) {
            return (
              `
                        <!--begin::Checkbox-->
                        <td>
                            <div class="form-check form-check-sm form-check-custom form-check-solid">
                                <input class="form-check-input" type="checkbox" value="` +
              data +
              `" />
                            </div>
                        </td>
                        <!--end::Checkbox-->
                        `
            );
          },
        },
        {
          targets: 1,
          title: "ID",
          class: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 2,
          title: "User",
          render: function (data, type, row) {
            return (
              `
                        <!--begin::User=-->
                            <td>
                                <!--begin:: Avatar -->

                                <div class=" d-flex align-items-center">
                                <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
                                <a href="/management/userdetails?id=` +
              row.userId +
              `">
                                    <div class="symbol-label">
                                        <img src="` +
              data +
              `" alt="Emma Smith" class="w-100" />
                                    </div>
                                </a>
                            </div>
                            <!--end::Avatar-->
                            <!--begin::User details-->
                            <div class="d-flex flex-column">
                                <a href="/management/userdetails?id=` +
              row.userId +
              `" class="text-gray-800 text-hover-primary mb-1">` +
              row.fullname +
              `</a>
                                <span>` +
              row.email +
              `</span>
                            </div>
                            <!--begin::User details-->
                            </div>
                        </td>
                               
                        <!--end::User=-->
                        `
            );
          },
        },
        {
          targets: 3,
          title: "Mobile",
          className: "text-center",
          render: function (data) {
            return data;
          },
        },
        {
          targets: 4,
          title: "Last Active",
          className: "text-center",
          render: function (data) {
            return moment(data).format("DD/MM/YYYY HH:mm:ss");
          },
        },
        {
          targets: 5,
          title: "Joined Date",
          className: "text-center",
          render: function (data) {
            return moment(data).format("DD/MM/YYYY");
          },
        },
        {
          targets: 6,
          title: "Status",
          orderable: false,
          className: "text-end",
          render: function (data, type, row) {
            var Status;
            var classStatus;
            if (data == 1) {
              Status = "Activate";
              classStatus = "btn-success";
            } else {
              Status = "Deactivate";
              classStatus = "btn-danger";
            }

            return `
      <td>
            <div class="d-flex justify-content-center">
                <form action="/management/user?action=update" method="post">
                    <input name="userID" type="hidden" value="${row.userId}">
                    <button type="submit" class="btn ${classStatus}">
                        ${Status}
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
