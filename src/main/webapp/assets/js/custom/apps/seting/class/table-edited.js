"use strict";
var KTUsersList = (function () {
  var e,
    classId,
    typeId,
    statusId,
    t,
    n,
    r,
    o = document.getElementById("kt_table_users"),
    c = () => {
      const a = o.querySelectorAll('[type="checkbox"]');
      (t = document.querySelector('[data-kt-user-table-toolbar="base"]')),
        (n = document.querySelector('[data-kt-user-table-toolbar="selected"]')),
        (r = document.querySelector(
          '[data-kt-user-table-select="selected_count"]'
        ));
      const s = document.querySelector(
        '[data-kt-user-table-select="delete_selected"]'
      );
      a.forEach((e) => {
        e.addEventListener("click", function () {
          setTimeout(function () {
            l();
          }, 50);
        });
      }),
        s.addEventListener("click", function () {
          Swal.fire({
            text: "Are you sure you want to delete selected customers?",
            icon: "warning",
            showCancelButton: !0,
            buttonsStyling: !1,
            confirmButtonText: "Yes, delete!",
            cancelButtonText: "No, cancel",
            customClass: {
              confirmButton: "btn fw-bold btn-danger",
              cancelButton: "btn fw-bold btn-active-light-primary",
            },
          }).then(function (t) {
            t.value
              ? Swal.fire({
                  text: "You have deleted all selected customers!.",
                  icon: "success",
                  buttonsStyling: !1,
                  confirmButtonText: "Ok, got it!",
                  customClass: {
                    confirmButton: "btn fw-bold btn-primary",
                  },
                })
                  .then(function () {
                    a.forEach((t) => {
                      t.checked &&
                        e
                          .row($(t.closest("tbody tr")))
                          .remove()
                          .draw();
                    });
                    o.querySelectorAll('[type="checkbox"]')[0].checked = !1;
                  })
                  .then(function () {
                    l(), c();
                  })
              : "cancel" === t.dismiss &&
                Swal.fire({
                  text: "Selected customers was not deleted.",
                  icon: "error",
                  buttonsStyling: !1,
                  confirmButtonText: "Ok, got it!",
                  customClass: {
                    confirmButton: "btn fw-bold btn-primary",
                  },
                });
          });
        });
    };
  const l = () => {
    const e = o.querySelectorAll('tbody [type="checkbox"]');
    let c = !1,
      l = 0;
    e.forEach((e) => {
      e.checked && ((c = !0), l++);
    }),
      c
        ? ((r.innerHTML = l),
          t.classList.add("d-none"),
          n.classList.remove("d-none"))
        : (t.classList.remove("d-none"), n.classList.add("d-none"));
  };
  return {
    init: function () {
      o &&
        (o.querySelectorAll("tbody tr").forEach((e) => {
          const t = e.querySelectorAll("td");
        }),
        (e = $(o).DataTable({
          searchDelay: 50,
          processing: true,
          serverSide: true,
          order: [[1, "asc"]],
          stateSave: true,
          select: {
            style: "multi",
            selector: 'td:first-child input[type="checkbox"]',
            className: "row-selected",
          },
          drawCallback: function (settings) {
            // set timeout for init Nested Menu
            setTimeout(function () {
              KTMenu.init();
              KTMenu.init();
              document
                .querySelectorAll('[data-kt-users-table-filter="Active"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    console.log(n);
                    Swal.fire({
                      text: "Are you sure you want deactivate setting id " + n,
                      icon: "warning",
                      showCancelButton: !0,
                      buttonsStyling: !1,
                      confirmButtonText: "Yes, deactivate!",
                      cancelButtonText: "No, cancel",
                      customClass: {
                        confirmButton: "btn fw-bold btn-danger",
                        cancelButton: "btn fw-bold btn-active-light-primary",
                      },
                    }).then(function (t) {
                      t.value
                        ? (() => {
                            axios
                              .post("/setting/class?action=update", {
                                action: "deactive",
                                settingId: n,
                              })
                              .then(function (response) {
                                $.toast({
                                  heading: "Success",
                                  text: "Setting has been deactivated",
                                  showHideTransition: "slide",
                                  icon: "success",
                                  position: "bottom-right",
                                });
                                e.draw();
                              })
                              .catch(function (error) {
                                console.log(error);
                              });
                          })()
                        : "cancel" === t.dismiss &&
                          $.toast({
                            heading: "Info",
                            text: "Setting has not been deactivated",
                            showHideTransition: "slide",
                            icon: "info",
                            position: "bottom-right",
                          });
                    });
                  });
                });
              document
                .querySelectorAll('[data-kt-users-table-filter="Inactive"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    console.log(n);
                    Swal.fire({
                      text: "Are you sure you want activate setting id " + n,
                      icon: "warning",
                      showCancelButton: !0,
                      buttonsStyling: !1,
                      confirmButtonText: "Yes, activate!",
                      cancelButtonText: "No, cancel",
                      customClass: {
                        confirmButton: "btn fw-bold btn-success",
                        cancelButton: "btn fw-bold btn-active-light-primary",
                      },
                    }).then(function (t) {
                      t.value
                        ? (() => {
                            axios
                              .post("/setting/class?action=update", {
                                action: "active",
                                settingId: n,
                              })
                              .then(function (response) {
                                $.toast({
                                  heading: "Success",
                                  text: "Setting has been activated",
                                  showHideTransition: "slide",
                                  icon: "success",
                                  position: "bottom-right",
                                });
                                e.draw();
                              })
                              .catch(function (error) {
                                console.log(error);
                              });
                          })()
                        : "cancel" === t.dismiss &&
                          $.toast({
                            heading: "Info",
                            text: "Setting has not been activated",
                            showHideTransition: "slide",
                            icon: "info",
                            position: "bottom-right",
                          });
                    });
                  });
                });
              console.log("drawCallback");
            }, 100);
          },
          ajax: {
            url: window.location.origin + "/setting/class?action=list",
            type: "POST",
            data: function (d) {
              return $.extend({}, d, {
                numberOfColumns: 6,
                classId: $("#classId").val(),
              });
            },
          },
          columns: [
            { data: "settingId" },
            { data: "settingTitle" },
            { data: "title" },
            { data: "value" },
            { data: "displayOrder" },
            { data: "statusTitle" },
            { data: "settingId" },
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
              title: "Setting Type",
              class: "text-center",
              render: function (data, type, row) {
                switch (row.typeId) {
                  case 31:
                    return (
                      `<a href="#" class="badge badge-light-danger fs-7 m-1">` +
                      data +
                      `</a>`
                    );
                  case 32:
                    return (
                      `<a href="#" class="badge badge-light-success fs-7 m-1">` +
                      data +
                      `</a>`
                    );
                  case 33:
                    return (
                      `<a href="#" class="badge badge-light-primary fs-7 m-1">` +
                      data +
                      `</a>`
                    );
                }
              },
            },
            {
              targets: 2,
              title: "Title",
              class: "text-start",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 3,
              title: "Value",
              class: "text-center",
              render: function (data) {
                const TypeValue = KTUsersList.checkTypeValue(data);
                switch (TypeValue.type) {
                  case "youtube":
                    return (
                      `
                    <a href="` +
                      TypeValue.value +
                      `" target="_blank" class="btn btn-sm btn-icon btn-light-youtube"><i class="fab fa-youtube fs-2"></i></a>
                    `
                    );
                  case "boolean":
                    if (TypeValue.value) {
                      return `
                        <span class="btn btn-sm btn-icon btn-light-success"><i class="las la-check fs-4"></i></span>
                      `;
                    } else {
                      return `
                        <span class="btn btn-sm btn-icon btn-light-danger"><i class="las la-times fs-4"></i></span>
                      `;
                    }
                  default:
                    return data;
                }
              },
            },
            {
              targets: 4,
              title: "Display Order",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 5,
              title: "Status",
              class: "text-center",
              render: function (data, type, row) {
                switch (row.statusId) {
                  case 0:
                    return (
                      `<a href="#" class="badge badge-light-danger fs-7">` +
                      data +
                      `</a>`
                    );
                  case 1:
                    return (
                      `<a href="#" class="badge badge-light-success fs-7">` +
                      data +
                      `</a>`
                    );
                }
              },
            },
            {
              targets: 6,
              title: "Actions",
              orderable: false,
              class: "text-center",
              render: function (data, type, row) {
                const actions = row.statusId == 1 ? "Deactive" : "Active";

                return (
                  `
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
                    <a href="setting/class/detail?id=` +
                  data +
                  `" class="menu-link px-3">View</a>
                  </div>
                  <!--end::Menu item-->
                  <!--begin::Menu item-->
                  <div class="menu-item px-3">
                    <a href="setting/class/detail?action=update&id=` +
                  data +
                  `" class="menu-link px-3">Edit</a>
                  </div>
                  <!--end::Menu item-->
                  <!--begin::Menu item-->
                  <div class="menu-item px-3">
                    <a href="#" value="` +
                  data +
                  `" class="menu-link px-3" data-kt-users-table-filter="` +
                  row.statusTitle +
                  `">` +
                  actions +
                  `</a>
                  </div>
                  <!--end::Menu item-->
                </div>
                <!--end::Menu-->
                `
                );
              },
            },
          ],
        })),
        c(),
        document
          .querySelector('[data-kt-user-table-filter="search"]')
          .addEventListener("keyup", function (t) {
            e.search(t.target.value).draw();
          }),
        document
          .querySelector('[data-kt-user-table-filter="reset"]')
          .addEventListener("click", function () {
            document
              .querySelector('[data-kt-user-table-filter="form"]')
              .querySelectorAll("select")
              .forEach((e) => {
                $(e).val("").trigger("change");
              }),
              e.columns(1).search("").columns(5).search("").draw();
          }),
        (() => {
          const t = document.querySelector(
              '[data-kt-user-table-filter="form"]'
            ),
            k = document.querySelector('[data-kt-user-table-filter="class"]'),
            n = t.querySelector('[data-kt-user-table-filter="filter"]'),
            r = t.querySelectorAll("select");
          k.addEventListener("change", function (t) {
            classId = t.target.value;
            console.log($("#classId").val());
            // reload ajax
            e.ajax.reload();
            e.draw();
          }),
            n.addEventListener("click", function () {
              r.forEach((e, n) => {
                var filter = e.getAttribute("data-kt-user-table-filter");
                if (filter == "type") {
                  typeId = e.value;
                }
                if (filter == "status") {
                  statusId = e.value;
                }
              }),
                e.columns(5).search(statusId).columns(1).search(typeId).draw();
            });
        })());
    },
    checkTypeValue: function (value) {
      // if value is youtube link
      if (
        value.includes("https://youtu.be") ||
        value.includes("https://www.youtube.com")
      ) {
        return {
          type: "youtube",
          value: value,
        };
      }
      // if value is true or false
      if (
        value.toLowerCase() == "true" ||
        value.toLowerCase() == "false" ||
        value.toLowerCase() == "1" ||
        value.toLowerCase() == "0" ||
        value.toLowerCase() == "yes" ||
        value.toLowerCase() == "no"
      ) {
        const v = value.toLowerCase();
        switch (v) {
          case "true":
          case "1":
          case "yes":
            return {
              type: "boolean",
              value: true,
            };
          case "false":
          case "0":
          case "no":
            return {
              type: "boolean",
              value: false,
            };
        }
      }
      // if value is number or string
      if (!isNaN(value)) {
        return {
          type: "number",
          value: value,
        };
      } else {
        return {
          type: "string",
          value: value,
        };
      }
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersList.init();
});
