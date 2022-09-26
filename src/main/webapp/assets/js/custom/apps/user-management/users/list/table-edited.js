"use strict";
var KTUsersList = function () {
  var e, t, n, r, o = document.getElementById("kt_table_users"),
    c = () => {
      const a = o.querySelectorAll('[type="checkbox"]');
      t = document.querySelector('[data-kt-user-table-toolbar="base"]'), n =
        document.querySelector('[data-kt-user-table-toolbar="selected"]'), r =
        document.querySelector('[data-kt-user-table-select="selected_count"]');
      const s = document.querySelector('[data-kt-user-table-select="delete_selected"]');
      a.forEach((e => {
        e.addEventListener("click", (function () {
          setTimeout((function () {
            l()
          }), 50)
        }))
      })), s.addEventListener("click", (function () {
        Swal.fire({
          text: "Are you sure you want to delete selected customers?",
          icon: "warning",
          showCancelButton: !0,
          buttonsStyling: !1,
          confirmButtonText: "Yes, delete!",
          cancelButtonText: "No, cancel",
          customClass: {
            confirmButton: "btn fw-bold btn-danger",
            cancelButton: "btn fw-bold btn-active-light-primary"
          }
        }).then((function (t) {
          t.value ? Swal.fire({
            text: "You have deleted all selected customers!.",
            icon: "success",
            buttonsStyling: !1,
            confirmButtonText: "Ok, got it!",
            customClass: {
              confirmButton: "btn fw-bold btn-primary"
            }
          }).then((function () {
            a.forEach((t => {
              t.checked && e.row($(t.closest("tbody tr"))).remove().draw()
            }));
            o.querySelectorAll('[type="checkbox"]')[0].checked = !1
          })).then((function () {
            l(), c()
          })) : "cancel" === t.dismiss && Swal.fire({
            text: "Selected customers was not deleted.",
            icon: "error",
            buttonsStyling: !1,
            confirmButtonText: "Ok, got it!",
            customClass: {
              confirmButton: "btn fw-bold btn-primary"
            }
          })
        }))
      }))
    };
  const l = () => {
    const e = o.querySelectorAll('tbody [type="checkbox"]');
    let c = !1,
      l = 0;
    e.forEach((e => {
      e.checked && (c = !0, l++)
    })), c ? (r.innerHTML = l, t.classList.add("d-none"), n.classList.remove("d-none")) : (t.classList.remove("d-none"),
      n.classList.add("d-none"))
  };
  return {
    init: function () {
      o && (o.querySelectorAll("tbody tr").forEach((e => {
        const t = e.querySelectorAll("td"),
          n = t[3].innerText.toLowerCase();
        let r = 0,
          o = "minutes";
        n.includes("yesterday") ? (r = 1, o = "days") : n.includes("mins") ? (r = parseInt(n.replace(/\D/g, "")), o = "minutes")
          : n.includes("hours") ? (r = parseInt(n.replace(/\D/g, "")), o = "hours") : n.includes("days") ? (r =
            parseInt(n.replace(/\D/g, "")), o = "days") : n.includes("weeks") && (r = parseInt(n.replace(/\D/g, "")), o = "weeks");
        const c = moment().subtract(r, o).format();
        t[3].setAttribute("data-order", c);
        const l = moment(t[5].innerHTML, "DD MMM YYYY, LT").format();
        t[5].setAttribute("data-order", l)
      })), e = $(o).DataTable({
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
          { data: "role" },
          { data: "avatarUrl" },
          { data: "updatedAt" }, // fake data for mobile
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
            title: "ROLE",
            class: "text-center",
            render: function (data) {
              return data.title;
            },
          },
          {
            targets: 3,
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
            targets: 4,
            title: "Mobile",
            className: "text-center",
            render: function (data) {
              return data;
            },
          },
          {
            targets: 5,
            title: "Last Active",
            className: "text-center",
            render: function (data) {
              return moment(data).format("DD/MM/YYYY HH:mm:ss");
            },
          },
          {
            targets: 6,
            title: "Joined Date",
            className: "text-center",
            render: function (data) {
              return moment(data).format("DD/MM/YYYY");
            },
          },
          {
            targets: 7,
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
      }), c(), document.querySelector('[data-kt-user-table-filter="search"]').addEventListener("keyup", (function (t) {
        e.search(t.target.value).draw()
      })), document.querySelector('[data-kt-user-table-filter="reset"]').addEventListener("click", (function () {
        document.querySelector('[data-kt-user-table-filter="form"]').querySelectorAll("select").forEach((e => {
          $(e).val("").trigger("change")
        })), e.search("").draw()
      })), o.querySelectorAll('[data-kt-users-table-filter="delete_row"]').forEach((t => {
        t.addEventListener("click", (function (t) {
          t.preventDefault();
          const n = t.target.closest("tr"),
            r = n.querySelectorAll("td")[1].querySelectorAll("a")[1].innerText;
          Swal.fire({
            text: "Are you sure you want to delete " + r + "?",
            icon: "warning",
            showCancelButton: !0,
            buttonsStyling: !1,
            confirmButtonText: "Yes, delete!",
            cancelButtonText: "No, cancel",
            customClass: {
              confirmButton: "btn fw-bold btn-danger",
              cancelButton: "btn fw-bold btn-active-light-primary"
            }
          }).then((function (t) {
            t.value ? Swal.fire({
              text: "You have deleted " + r + "!.",
              icon: "success",
              buttonsStyling: !1,
              confirmButtonText: "Ok, got it!",
              customClass: {
                confirmButton: "btn fw-bold btn-primary"
              }
            }).then((function () {
              e.row($(n)).remove().draw()
            })).then((function () {
              l()
            })) : "cancel" === t.dismiss && Swal.fire({
              text: customerName + " was not deleted.",
              icon: "error",
              buttonsStyling: !1,
              confirmButtonText: "Ok, got it!",
              customClass: {
                confirmButton: "btn fw-bold btn-primary"
              }
            })
          }))
        }))
      })), (() => {
        const t = document.querySelector('[data-kt-user-table-filter="form"]'),
          n = t.querySelector('[data-kt-user-table-filter="filter"]'),
          r = t.querySelectorAll("select");
        n.addEventListener("click", (function () {
          var t = "";
          r.forEach(((e, n) => {
            console.log(e);
            e.value && "" !== e.value && (0 !== n && (t += " "), t += e.value)
          })), e.search(t).draw(), e.columns(3).search(t).draw()
        }))
      })())
    }
  }
}();
KTUtil.onDOMContentLoaded((function () {
  KTUsersList.init()
}));