"use strict";
var KTUsersList = (function () {
  var e,
    fileUrls,
    classId,
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
  var bm = new bootstrap.Modal(
    document.getElementById("kt_modal_export_users")
  );
  var fm = $("#kt_modal_export_users_form").get(0);
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
      var mydropzone = new Dropzone("#kt_modal_create_project_settings_logo", {
        url: window.location.origin + "/upload",
        paramName: "file",
        maxFiles: 1,
        maxFilesize: 10,
        addRemoveLinks: !0,
        acceptedFiles: ".xlsx, .xls",
        accept: function (e, t) {
          t();
        },
        init: function () {
          fileUrls = "";
          this.on("success", function (e, t) {
            fileUrls = t.data[0];
            console.log(fileUrls);
          });
        },
      });
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
                .querySelectorAll('[data-kt-users-table-filter="0"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    console.log(n);
                    Swal.fire({
                      text: "Are you sure you want activate Trainee id " + n,
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
                              .post("/management/trainee/list?action=update", {
                                action: "active",
                                userID: n,
                              })
                              .then(function (response) {
                                $.toast({
                                  heading: "Success",
                                  text: "Trainee has been activated",
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
                            text: "Trainee has not been activated",
                            showHideTransition: "slide",
                            icon: "info",
                            position: "bottom-right",
                          });
                    });
                  });
                });
              document
                .querySelectorAll('[data-kt-users-table-filter="1"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    Swal.fire({
                      text: "Are you sure you want deactivate trainee id " + n,
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
                              .post("/management/trainee/list?action=update", {
                                action: "deactive",
                                userID: n,
                              })
                              .then(function (response) {
                                $.toast({
                                  heading: "Success",
                                  text: "Trainee has been deactivated",
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
                            text: "Trainee has not been deactivated",
                            showHideTransition: "slide",
                            icon: "info",
                            position: "bottom-right",
                          });
                    });
                  });
                });
              document
                .querySelectorAll('[data-kt-users-table-filter="2"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    console.log(n);
                    Swal.fire({
                      text: "Are you sure you want activate trainee id " + n,
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
                              .post("/management/trainee/list?action=update", {
                                action: "active",
                                userID: n,
                              })
                              .then(function (response) {
                                $.toast({
                                  heading: "Success",
                                  text: "Trainee has been activated",
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
                            text: "Trainee has not been activated",
                            showHideTransition: "slide",
                            icon: "info",
                            position: "bottom-right",
                          });
                    });
                  });
                });
              document
                .querySelectorAll('[data-kt-users-table-filter="dropout"]')
                .forEach((t) => {
                  t.addEventListener("click", function (t) {
                    t.preventDefault();
                    const n = t.target.getAttribute("value");
                    Swal.fire({
                      title: "Day dropout",
                      html: `
                      <div class="col-md-12 fv-row">
                      <!--begin::Input-->
                      <div class="position-relative d-flex align-items-center">
                        <!--begin::Icon-->
                        <div class="symbol symbol-20px me-4 position-absolute ms-4">
                          <span class="symbol-label bg-secondary">
                            <!--begin::Svg Icon | path: icons/duotone/Layout/Layout-grid.svg-->
                            <span class="svg-icon">
                              <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                  <rect x="0" y="0" width="24" height="24" />
                                  <rect fill="#000000" opacity="0.3" x="4" y="4" width="4" height="4" rx="1" />
                                  <path d="M5,10 L7,10 C7.55228475,10 8,10.4477153 8,11 L8,13 C8,13.5522847 7.55228475,14 7,14 L5,14 C4.44771525,14 4,13.5522847 4,13 L4,11 C4,10.4477153 4.44771525,10 5,10 Z M11,4 L13,4 C13.5522847,4 14,4.44771525 14,5 L14,7 C14,7.55228475 13.5522847,8 13,8 L11,8 C10.4477153,8 10,7.55228475 10,7 L10,5 C10,4.44771525 10.4477153,4 11,4 Z M11,10 L13,10 C13.5522847,10 14,10.4477153 14,11 L14,13 C14,13.5522847 13.5522847,14 13,14 L11,14 C10.4477153,14 10,13.5522847 10,13 L10,11 C10,10.4477153 10.4477153,10 11,10 Z M17,4 L19,4 C19.5522847,4 20,4.44771525 20,5 L20,7 C20,7.55228475 19.5522847,8 19,8 L17,8 C16.4477153,8 16,7.55228475 16,7 L16,5 C16,4.44771525 16.4477153,4 17,4 Z M17,10 L19,10 C19.5522847,10 20,10.4477153 20,11 L20,13 C20,13.5522847 19.5522847,14 19,14 L17,14 C16.4477153,14 16,13.5522847 16,13 L16,11 C16,10.4477153 16.4477153,10 17,10 Z M5,16 L7,16 C7.55228475,16 8,16.4477153 8,17 L8,19 C8,19.5522847 7.55228475,20 7,20 L5,20 C4.44771525,20 4,19.5522847 4,19 L4,17 C4,16.4477153 4.44771525,16 5,16 Z M11,16 L13,16 C13.5522847,16 14,16.4477153 14,17 L14,19 C14,19.5522847 13.5522847,20 13,20 L11,20 C10.4477153,20 10,19.5522847 10,19 L10,17 C10,16.4477153 10.4477153,16 11,16 Z M17,16 L19,16 C19.5522847,16 20,16.4477153 20,17 L20,19 C20,19.5522847 19.5522847,20 19,20 L17,20 C16.4477153,20 16,19.5522847 16,19 L16,17 C16,16.4477153 16.4477153,16 17,16 Z" fill="#000000" />
                                </g>
                              </svg>
                            </span>
                            <!--end::Svg Icon-->
                          </span>
                        </div>
                        <!--end::Icon-->
                        <!--begin::Datepicker-->
                        <input class="form-control form-control-solid ps-12" placeholder="Select a date" name="due_date" />
                        <!--end::Datepicker-->
                      </div>
                      <!--end::Input-->
                    </div>`,
                      icon: "warning",
                      showCancelButton: !0,
                      buttonsStyling: !1,
                      confirmButtonText: "Dropout",
                      cancelButtonText: "Cancel",
                      customClass: {
                        confirmButton: "btn fw-bold btn-danger",
                        cancelButton: "btn fw-bold btn-active-light-primary",
                      },
                      didOpen: function () {
                        $('[name="due_date"]').flatpickr({
                          enableTime: !1,
                          dateFormat: "Y-m-d",
                          maxDate: new Date().fp_incr(5),
                        });
                      },
                    }).then(function (t) {
                      t.value
                        ? (() => {
                            if ($('[name="due_date"]').val() != "") {
                              axios
                                .post(
                                  "/management/trainee/list?action=update",
                                  {
                                    action: "dropout",
                                    userID: n,
                                    dateDropout: $('[name="due_date"]').val(),
                                  }
                                )
                                .then(function (response) {
                                  $.toast({
                                    heading: "Success",
                                    text: "Trainee has been dropout",
                                    showHideTransition: "slide",
                                    icon: "success",
                                    position: "bottom-right",
                                  });
                                  e.draw();
                                })
                                .catch(function (error) {
                                  $.toast({
                                    heading: "Error",
                                    text: error.response.data.message,
                                    showHideTransition: "slide",
                                    icon: "error",
                                    position: "bottom-right",
                                  });
                                });
                            } else {
                              Swal.fire({
                                text: "Please select dropout date",
                                icon: "warning",
                                buttonsStyling: !1,
                                confirmButtonText: "Ok, got it!",
                                customClass: {
                                  confirmButton:
                                    "btn fw-bold btn-active-light-primary",
                                },
                              });
                            }
                          })()
                        : "cancel" === t.dismiss &&
                          $.toast({
                            heading: "Info",
                            text: "Trainee has not been dropout",
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
            url:
              window.location.origin + "/management/trainee/list?action=list",
            type: "POST",
            data: function (d) {
              return $.extend({}, d, {
                numberOfColumns: 7,
                classId: $("#classId").val(),
              });
            },
          },
          columns: [
            { data: "userId" },
            { data: "userId" },
            { data: "avatarUrl" },
            { data: "mobile" },
            { data: "grade" },
            { data: "dropoutDate" },
            { data: "statusId" },
            { data: "userId" },
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
              render: function (data, type, row) {
                return data;
              },
            },
            {
              targets: 2,
              title: "User",
              class: "text-start",
              render: function (data, type, row) {
                return (
                  `
  <!--begin::User=-->
  <td>
      <!--begin:: Avatar -->
  
      <div class=" d-flex align-items-center">
          <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
              <a href="/management/user/detail?id=` +
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
              <a href="/management/user/detail?id=` +
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
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 4,
              title: "Grade",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 5,
              title: "Dropout Date",
              class: "text-center",
              render: function (data, type, row) {
                if (row.statusId == 2) {
                  return moment(data).format("DD/MM/YYYY");
                } else {
                  return "Not dropout";
                }
              },
            },
            {
              targets: 6,
              title: "Status",
              class: "text-center",
              render: function (data, type, row) {
                switch (data) {
                  case 0:
                    return `<a href="#" class="badge badge-light-dark fs-7">Inactive</a>`;
                  case 1:
                    return `<a href="#" class="badge badge-light-success fs-7">Active</a>`;
                  case 2:
                    return `<a href="#" class="badge badge-light-danger fs-7">Dropout</a>`;
                }
              },
            },
            {
              targets: 7,
              title: "Actions",
              className: "text-center",
              render: function (data, type, row) {
                const actions = row.statusId == 1 ? "Deactive" : "Active";
                const dropdownMenu =
                  row.statusId == 2
                    ? ``
                    : `
                <!--begin::Menu item-->
                <div class="menu-item px-3">
                  <a href="#" value="` +
                      data +
                      `" class="menu-link px-3" data-kt-users-table-filter="dropout">Dropout</a>
                </div>
                <!--end::Menu item-->
                `;
                const dataHtml =
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
                    <a href="management/trainee/detail?id=` +
                  data +
                  `" class="menu-link px-3">View</a>
                  </div>
                  <!--end::Menu item-->
                  <!--begin::Menu item-->
                  <div class="menu-item px-3">
                    <a href="management/trainee/detail?action=update&id=` +
                  data +
                  `" class="menu-link px-3">Edit</a>
                  </div>
                  <!--end::Menu item-->
                  <!--begin::Menu item-->
                  <div class="menu-item px-3">
                    <a href="#" value="` +
                  data +
                  `" class="menu-link px-3" data-kt-users-table-filter="` +
                  row.statusId +
                  `">` +
                  actions +
                  `</a>
                  </div>
                  <!--end::Menu item-->
                  ` +
                  dropdownMenu +
                  `
                </div>
                <!--end::Menu-->
                `;
                return dataHtml;
              },
            },
          ],
        })),
        c(),
        document
          .querySelector('[data-kt-users-modal-action="close"]')
          .addEventListener("click", (t) => {
            t.preventDefault(),
              Swal.fire({
                text: "Are you sure you would like to cancel?",
                icon: "warning",
                showCancelButton: !0,
                buttonsStyling: !1,
                confirmButtonText: "Yes, cancel it!",
                cancelButtonText: "No, return",
                customClass: {
                  confirmButton: "btn btn-primary",
                  cancelButton: "btn btn-active-light",
                },
              }).then(function (t) {
                t.value
                  ? (bm.hide(),
                    fm.reset(),
                    $('[name="classImport"]').val("").trigger("change"),
                    mydropzone.removeAllFiles(true))
                  : "cancel" === bm.dismiss &&
                    Swal.fire({
                      text: "Your form has not been cancelled!.",
                      icon: "error",
                      buttonsStyling: !1,
                      confirmButtonText: "Ok, got it!",
                      customClass: {
                        confirmButton: "btn btn-primary",
                      },
                    });
              });
          }),
        document
          .querySelector('[data-kt-users-modal-action="cancel"]')
          .addEventListener("click", (t) => {
            t.preventDefault(),
              Swal.fire({
                text: "Are you sure you would like to cancel?",
                icon: "warning",
                showCancelButton: !0,
                buttonsStyling: !1,
                confirmButtonText: "Yes, cancel it!",
                cancelButtonText: "No, return",
                customClass: {
                  confirmButton: "btn btn-primary",
                  cancelButton: "btn btn-active-light",
                },
              }).then(function (t) {
                t.value
                  ? (bm.hide(),
                    fm.reset(),
                    $('[name="classImport"]').val("").trigger("change"),
                    mydropzone.removeAllFiles(true))
                  : "cancel" === bm.dismiss &&
                    Swal.fire({
                      text: "Your form has not been cancelled!.",
                      icon: "error",
                      buttonsStyling: !1,
                      confirmButtonText: "Ok, got it!",
                      customClass: {
                        confirmButton: "btn btn-primary",
                      },
                    });
              });
          }),
        document
          .querySelector('[data-kt-users-modal-action="submit"]')
          .addEventListener("click", (t) => {
            t.preventDefault(),
              axios
                .post("/management/trainee/list?action=create", {
                  classId: $('[name="classImport"]').val(),
                  fileUrls: fileUrls,
                  action: "import",
                })
                .then(function (response) {
                  $.toast({
                    heading: "Success",
                    text: "Trainee import successfully",
                    showHideTransition: "slide",
                    icon: "success",
                    position: "bottom-right",
                  });
                  bm.hide();
                  fm.reset();
                  $('[name="classImport"]').val("").trigger("change");
                  mydropzone.removeAllFiles(true);
                  e.draw();
                })
                .catch(function (error) {
                  $.toast({
                    heading: "Error",
                    text: "Something went wrong",
                    showHideTransition: "slide",
                    icon: "error",
                    position: "bottom-right",
                  });
                });
          }),
        document
          .querySelector('[data-kt-user-table-filter="search"]')
          .addEventListener("keyup", function (t) {
            e.search(t.target.value).draw();
          }),
        (() => {
          const t = document.querySelector(
              '[data-kt-user-table-filter="form"]'
            ),
            k = document.querySelector('[data-kt-user-table-filter="class"]'),
            n = document.querySelector('[data-kt-user-table-filter="status"]');
          console.log(n);
          k.addEventListener("change", function (t) {
            classId = t.target.value;
            console.log($("#classId").val());
            // reload ajax
            e.ajax.reload();
            e.draw();
          }),
            n.addEventListener("change", function (t) {
              console.log("status");
              e.columns(6).search(t.target.value).draw();
            });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersList.init();
});
