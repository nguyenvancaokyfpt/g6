"use strict";
var KTUsersList = (function () {
  var e,
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
          const t = e.querySelectorAll("td"),
            n = t[3].innerText.toLowerCase();
          let r = 0,
            o = "minutes";
          n.includes("yesterday")
            ? ((r = 1), (o = "days"))
            : n.includes("mins")
            ? ((r = parseInt(n.replace(/\D/g, ""))), (o = "minutes"))
            : n.includes("hours")
            ? ((r = parseInt(n.replace(/\D/g, ""))), (o = "hours"))
            : n.includes("days")
            ? ((r = parseInt(n.replace(/\D/g, ""))), (o = "days"))
            : n.includes("weeks") &&
              ((r = parseInt(n.replace(/\D/g, ""))), (o = "weeks"));
          const c = moment().subtract(r, o).format();
          t[3].setAttribute("data-order", c);
          const l = moment(t[5].innerHTML, "DD MMM YYYY, LT").format();
          t[5].setAttribute("data-order", l);
        }),
        (e = $(o).DataTable({
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
            url: window.location.origin + "/management/user?action=list",
            type: "POST",
            data: {
              numberOfColumns: 6,
              role: () => {
                return $("#filterRoles").val();
              },
              status: () => {
                return $("#filterStatus").val();
              },
            },
          },
          columns: [
            { data: "userId" },
            { data: "role" },
            { data: "avatarUrl" },
            { data: "mobile" },
            { data: "lastActive" },
            { data: "createdAt" },
            { data: "statusId" },
            { data: "userId" },
          ],
          columnDefs: [
            {
              targets: 0,
              title: "ID",
              class: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 1,
              title: "ROLE",
              orderable: false,
              class: "text-center",
              render: function (data) {
                switch (data.id) {
                  case 21:
                    return (
                      `<a href="#" class="badge badge-light-danger fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  case 22:
                    return (
                      `<a href="#" class="badge badge-light-success fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  case 23:
                    return (
                      `<a href="#" class="badge badge-light-primary fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  case 24:
                    return (
                      `<a href="#" class="badge badge-light-warning fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  case 25:
                    return (
                      `<a href="#" class="badge badge-light-info fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  case 26:
                    return (
                      `<a href="#" class="badge badge-light-dark fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                  default:
                    return (
                      `<a href="#" class="badge badge-light-primary fs-7 m-1">` +
                      data.title +
                      `</a>`
                    );
                }
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
              className: "text-center",
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
                                <button type="button" class="btn ${classStatus}">
                                    ${Status}
                                </button>
                        </div>
                    </td>

`;
              },
            },
            {
              targets: 7,
              title: "Actions",
              orderable: false,
              className: "text-center",
              render: function (data, type, row) {
                const actions = row.statusId == 1 ? "Deactivate" : "Active";
                const actionClass =
                  row.statusId == 1 ? "btn-danger" : "btn-success";
                return `
              <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" id="action${data}" data-bs-toggle="dropdown" aria-expanded="false">
                Actions
              </button>
                <ul class="dropdown-menu" aria-labelledby="action${data}">
                  <li><a class="dropdown-item text-center" href="/management/user/detail?id=${row.userId}">View/Edit</a></li>
                  <li>
                  <!-- Button trigger modal -->
                  <a type="button" class="dropdown-item text-center" data-bs-toggle="modal" data-bs-target="#model${data}">
                  ${actions}
                  </a>           
                 </li>
                </ul>
              </div>
              <!-- Modal -->
              <div class="modal fade" id="model${data}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">Comfirm</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      Do you want to ${actions} this user?
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      <button type="button" class="btn ${actionClass}" data-bs-dismiss="modal" onclick="changeStatus(${data})">${actions}</button>
                    </div>
                  </div>
                </div>
              </div>  
              `;
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
        (() => {
          // Your code here
          $("#filterRoles").on("change", function () {
            e.draw();
          }),
            $("#filterStatus").on("change", function () {
              e.draw();
            }),
            $("#resetTb").on("click", function () {
              e.draw();
            });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersList.init();
  toastr.options = {
    closeButton: true,
    debug: false,
    newestOnTop: false,
    progressBar: false,
    positionClass: "toast-bottom-right",
    preventDuplicates: false,
    onclick: null,
    showDuration: "300",
    hideDuration: "1000",
    timeOut: "3000",
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut",
  };
});

const changeStatus = (id) => {
  fetch(`/management/user?action=update&userID=${id}`, {
    method: "POST",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      if (data) {
        $("#resetTb").click();
        toastr.success("Update success");
      }
    });
};
