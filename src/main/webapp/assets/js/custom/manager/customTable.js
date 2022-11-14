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
              subjectId: function () {
                return $("#subSelect").val();
              },
              assId: function () {
                return $("#assSelect").val();
              },
              status: function () {
                return $("#statusSelect").val();
              },
            },
          },
          columns: [
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
              title: "Name",
              className: "text-left",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 1,
              title: "Subject",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 2,
              title: "Assignment",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },

            {
              targets: 3,
              title: "Weight",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 4,
              title: "Max LOC",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 5,
              title: "Team Eval",
              orderable: false,
              className: "text-center",
              render: function (data) {
                var Status;
                var classStatus;
                if (data == 1) {
                  Status = "Group";
                  classStatus = "btn-warning";
                } else {
                  Status = "Individual";
                  classStatus = "btn-primary";
                }

                return Status;
              },
            },
            {
              targets: 6,
              title: "Status",
              orderable: false,
              className: "text-center",
              render: function (data) {
                var Status;
                var classStatus;
                if (data == 1) {
                  Status = "Active";
                  classStatus = "btn-success";
                } else {
                  Status = "Inactive";
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
              targets: 7,
              title: "Actions",
              orderable: false,
              className: "text-center",
              render: function (data, type, row) {
                const actions = row.status == 1 ? "Deactivate" : "Activate";
                const classStatus = row.status == 1 ? "btn-danger" : "btn-success";
                return `
                <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="action${data}" data-bs-toggle="dropdown" aria-expanded="false">
                  Actions
                </button>
                  <ul class="dropdown-menu" aria-labelledby="action${data}">
                    <li><a class="dropdown-item text-center" href="/evalCriteria/evalCriteriaDetails?action=get&evalId=${data}">View/Edit</a></li>
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
                        Do you want to ${actions} this Eval Criteria?
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <a class="btn ${classStatus}" href="/evalCriteria/evalCriteriaDetails?action=changeStatus&evalId=${data}&status=${row.status}">${actions}</a>
                      </div>
                    </div>
                  </div>
                </div>  
                `;
              },
            },
          ],
        })),document
        .querySelector('[data-kt-eval-table-filter="search"]')
        .addEventListener("keyup", function (t) {
          e.search(t.target.value).draw();
        }),
        (() => {
          $("#subSelect").on("change", function () {
            setTimeout(() => {
              e.ajax.reload();
            }, 300);
            
          }),
            $("#assSelect").on("change", function () {
              e.ajax.reload();
            }),
            $("#statusSelect").on("change", function () {
              e.ajax.reload();
            });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  getSub();
  setTimeout(() => {
    KTUsersList.init();
  }, 500);
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
  showToast();
});

const getSub = () => {
  let id = document.getElementById("subSelect").value;
  if (id == -1) {
    document.getElementById(
      "assSelect"
    ).innerHTML = `<option value="-1"> All Assignments</option>`;
    return;
  }
  if (id == "") id = 0;
  fetch(
    window.location.origin +
      `/evalCriteria/evalCriteriaList?action=getSub&subId=${id}`,
    { method: "POST" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {

      if(data == false){
        document.getElementById(
          "assSelect"
        ).innerHTML = `<option value="-1"> All Assignments</option>`;
        return;
      }
      let assSelect = document.getElementById("assSelect");
      let content = `<option value="-1"> All Assignments</option>`;
      // let content = `<option value="">--- Select Assignment ---</option>`;
      data.forEach((e) => {
        content += `
            <option value="${e.assId}">${e.title}</option>
        `;
      });
      assSelect.innerHTML = content;
    })
    .catch((error) => {
      document.getElementById(
        "assSelect"
      ).innerHTML = `<option value="" disabled selected>--- Empty ---</option>`;
    });
};

function showToast() {
  var type = document.getElementById("toastStatus").value;
  if (type == "1") {
    toastr.success("Update Successfully");
  } else if (type == "2") {
    toastr.success("Added Successfully");
  }
}
