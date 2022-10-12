"use strict";
var KTUsersList = (function () {
  var e,
    t,
    n,
    r,
    o = document.getElementById("kt_table_evalCriteria");
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
          stateSave: false,
          select: {
            style: "multi",
            selector: 'td:first-child input[type="checkbox"]',
            className: "row-selected",
          },
          ajax: {
            url:
              window.location.origin +
              "/evalCriteria/evalCriteriaList?action=list",
            type: "POST",
            data: {
              numberOfColumns: 8,
            },
          },
          columns: [
            { data: "id" },
            { data: "name" },
            { data: "subjectName" },
            { data: "assignName" },
            { data: "weight" },
            { data: "maxLoc" },
            { data: "isTeam" },
            { data: "status" },
            { data: "id" },
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
              title: "Name",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 2,
              title: "Subject",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 3,
              title: "Assignment",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },

            {
              targets: 4,
              title: "Weight",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 5,
              title: "Max LOC",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 6,
              title: "Team Share",
              orderable: false,
              className: "text-center",
              render: function (data, type, row) {
                var Status;
                var classStatus;
                if (data == 1) {
                  Status = "Group";
                  classStatus = "btn-warning";
                } else {
                  Status = "Individual";
                  classStatus = "btn-primary";
                }

                return `
                      <td>
                          <div class="d-flex justify-content-center">
                                  <button type="submit" class="btn ${classStatus}">
                                      ${Status}
                                  </button>
                              </form>
                          </div>
                      </td>
                      
                      `;
              },
            },
            {
              targets: 7,
              title: "Status",
              orderable: false,
              className: "text-center",
              render: function (data) {
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
                                  <button type="submit" class="btn ${classStatus}">
                                      ${Status}
                                  </button>
                              </form>
                          </div>
                      </td>
                      
                      `;
              },
            },
            {
              targets: 8,
              title: "Actions",
              orderable: false,
              className: "text-center",
              render: function (data, type, row) {
                console.log(row.status);
                const actions = row.status == 1 ? "Deactive" : "Active";
                return `
                <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="action${data}" data-bs-toggle="dropdown" aria-expanded="false">
                  Actions
                </button>
                  <ul class="dropdown-menu" aria-labelledby="action${data}">
                    <li><a class="dropdown-item text-center" href="/evalCriteria/evalCriteriaDetails?action=get&evalId=${data}">View</a></li>
                    <li><a class="dropdown-item text-center" href="/evalCriteria/evalCriteriaDetails?action=update&evalId=${data}">Edit</a></li>
                    <li><a class="dropdown-item text-center" href="/evalCriteria/evalCriteriaDetails?action=changeStatus&evalId=${data}&status=${row.status}">${actions}</a></li>
                  </ul>
                </div>
                `;
              },
            },
          ],
        })),
        document
          .querySelector('[data-kt-eval-table-filter="search"]')
          .addEventListener("keyup", function (t) {
            e.search(t.target.value).draw();
          }),
        document
          .querySelector('[data-kt-eval-table-filter="reset"]')
          .addEventListener("click", function () {
            document
              .querySelector('[data-kt-eval-table-filter="form"]')
              .querySelectorAll("select")
              .forEach((e) => {
                $(e).val("").trigger("change");
              }),
              e
                .columns(2)
                .search("")
                .columns(3)
                .search("")
                .columns(7)
                .search("")
                .draw();
          }),
        (() => {
          const t = document.querySelector(
              '[data-kt-eval-table-filter="form"]'
            ),
            n = t.querySelector('[data-kt-eval-table-filter="filter"]'),
            r = t.querySelectorAll("select");
          n.addEventListener("click", function () {
            var subject = -1;
            var assign = -1;
            var status = -1;
            r.forEach((e, n) => {
              var filter = e.getAttribute("data-kt-eval-table-filter");
              if (filter == "subject") {
                subject = e.value;
              }
              if (filter == "assign") {
                assign = e.value;
              }
              if (filter == "status") {
                status = e.value;
              }
            }),
              //e.columns(2).search(role).columns(7).search(status).draw();
              e
                .columns(2)
                .search(subject)
                .columns(3)
                .search(assign)
                .columns(7)
                .search(status)
                .draw();
          });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersList.init();
});
