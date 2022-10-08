"use strict";
var KTUsersList = (function () {
  var e,
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
          ajax: {
            url: window.location.origin + "/setting/class?action=list",
            type: "POST",
            data: function (d) {
              return $.extend({}, d, {
                numberOfColumns: 8,
                classId: $("#classId").val(),
              });
            },
          },
          columns: [
            { data: "settingId" },
            { data: "settingId" },
            { data: "classId" },
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
              title: "ID",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 2,
              title: "Class ID",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 3,
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
              targets: 4,
              title: "Title",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 5,
              title: "Value",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 6,
              title: "Display Order",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 7,
              title: "Status",
              class: "text-center",
              render: function (data, type, row) {
                switch (row.statusId) {
                  case 0:
                    return (
                      `<a href="#" class="badge badge-light-danger fs-7 m-1">` +
                      data +
                      `</a>`
                    );
                  case 1:
                    return (
                      `<a href="#" class="badge badge-light-success fs-7 m-1">` +
                      data +
                      `</a>`
                    );
                }
              },
            },
            {
              targets: 8,
              title: "Actions",
              orderable: false,
              class: "text-center",
              render: function (data) {
                return data;
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
              e.columns(2).search("").columns(7).search("").draw();
          }),
        o
          .querySelectorAll('[data-kt-users-table-filter="delete_row"]')
          .forEach((t) => {
            t.addEventListener("click", function (t) {
              t.preventDefault();
              const n = t.target.closest("tr"),
                r = n
                  .querySelectorAll("td")[1]
                  .querySelectorAll("a")[1].innerText;
              Swal.fire({
                text: "Are you sure you want to delete " + r + "?",
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
                      text: "You have deleted " + r + "!.",
                      icon: "success",
                      buttonsStyling: !1,
                      confirmButtonText: "Ok, got it!",
                      customClass: {
                        confirmButton: "btn fw-bold btn-primary",
                      },
                    })
                      .then(function () {
                        e.row($(n)).remove().draw();
                      })
                      .then(function () {
                        l();
                      })
                  : "cancel" === t.dismiss &&
                    Swal.fire({
                      text: customerName + " was not deleted.",
                      icon: "error",
                      buttonsStyling: !1,
                      confirmButtonText: "Ok, got it!",
                      customClass: {
                        confirmButton: "btn fw-bold btn-primary",
                      },
                    });
              });
            });
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
              var typeId = -1;
              var status = -1;
              r.forEach((e, n) => {
                var filter = e.getAttribute("data-kt-user-table-filter");
                if (filter == "type") {
                  typeId = e.value;
                }
                if (filter == "status") {
                  status = e.value;
                }
              }),
                e.columns(2).search(typeId).columns(7).search(status).draw();
            });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersList.init();
});
