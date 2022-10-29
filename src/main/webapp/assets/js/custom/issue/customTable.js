"use strict";
var KTUsersList = (function () {
  var e,
    t,
    n,
    r,
    o = document.getElementById("kt_table_issue");
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
            url: window.location.origin + "/issue/list?action=list",
            type: "POST",
            data: {
              numberOfColumns: 6,
              classId: function () {
                return document.getElementById("iterMilestone").value;
              },
              teamId: function () {
                return document.getElementById("iterTeam").value;
              },
              assigneeId: function () {
                return document.getElementById("iterAssignee").value;
              },
              status: function () {
                return document.getElementById("iterStatus").value;
              },
            },
          },
          columns: [
            { data: "issueId" },
            { data: "title" },
            { data: "milestone" },
            { data: "assignee" },
            { data: "status" },
            { data: "isClose" },
            { data: "issueId" },
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
              title: "Title",
              className: "text-center",
              render: function (data) {
                return data;
              },
            },
            {
              targets: 2,
              title: "Milestone",
              className: "text-center",
              render: function (data) {
                return data.title;
              },
            },
            {
              targets: 3,
              title: "Assignee",
              className: "text-center",
              render: function (data) {
                return data.fullname;
              },
            },
            {
              targets: 4,
              title: "Status",
              className: "text-center",
              render: function (data) {
                return data.title;
              },
            },
            {
              targets: 5,
              title: "IsClose",
              className: "text-center",
              render: function (data) {
                return data == 0 ? "Open" : "Close";
              },
            },
            {
              targets: 6,
              title: "Actions",
              orderable: false,
              className: "text-center",
              render: function (data) {
                return `
                <button class="btn btn-secondary type="button">
                  View
                </button>
                `;
              },
            },
          ],
        })),
        document
          .querySelector('[data-kt-issue-table-filter="search"]')
          .addEventListener("keyup", function (t) {
            e.search(t.target.value).draw();
          }),
        (() => {
          $("#iterMilestone").on("change", function () {
            getTeam(e);
          });
          $(".issueFilter").on("change", function () {
            e.draw(e);
          });
        })());
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  getTeam(null);
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

let team = [];
const getTeam = (e) => {
  let classId = document.getElementById("iterMilestone").value;
  fetch(
    window.location.origin + `/issue/list?action=getTeam&classId=${classId}`,
    { method: "POST" }
  )
    .then((response) => response.json())
    .then((data) => {
      team = data;
      var teamSelect = document.getElementById("iterTeam");
      teamSelect.innerHTML = "";
      data.forEach((element, index) => {
        teamSelect.innerHTML += `<option value="${element.id}">Group ${
          index + 1
        }</option>`;
      });
      if (data.length == 0) {
        teamSelect.innerHTML += `<option value="-1">No Group</option>`;
      }
      getAssignee();
      if (e != null) e.draw();
    });
};

const getAssignee = () => {
  let teamId = document.getElementById("iterTeam").value;
  let assigneeSelect = document.getElementById("iterAssignee");
  assigneeSelect.innerHTML = "";
  assigneeSelect.innerHTML += `<option value="-1">All Assignee</option>`;
  team.forEach((element) => {
    if (element.id == teamId) {
      element.listTrainee.forEach((member) => {
        assigneeSelect.innerHTML += `<option value="${member.userId}">${member.fullname}</option>`;
      });
    }
  });
};
