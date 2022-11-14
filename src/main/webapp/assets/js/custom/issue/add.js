const createIssue = () => {
  if ($("#issueTitle").val() == "" || $("#issueUrl").val() == "") {
    toastr.error("Please fill all required fields!");
    return;
  }
  if (
    $("#iterMilestone").val() == -1 ||
    $("#iterTeam").val() == -1 ||
    $("#iterAssignee").val() == -1
  ) {
    toastr.error("Empty Milestone, Team or Assignee!");
    return;
  }

  let team = document.getElementById("iterTeam").value;
  let assignee = document.getElementById("iterAssignee").value;
  let status = document.getElementById("issueStatus").value;
  let title = document.getElementById("issueTitle").value;
  let url = document.getElementById("issueUrl").value;
  let description = document.getElementById("issueDescription").value;
  fetch(
    window.location.origin +
      `/issue/list?action=create&issue_team=${team}&issue_assignee=${assignee}&issue_title=${title}&issue_url=${url}
  &issue_status=${status}&issue_description=${description}`,
    {
      method: "POST",
      body: new FormData(document.getElementById("addForm")),
    }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      if (data == true) {
        toastr.success("Added Successfully!");
        $("#btnClear").click();
      } else {
        toastr.error("Added Failed!");
      }
    })
    .catch((error) => {
      console.log(error);
    });
};



//document ready
$(document).ready(function () {
  getTeam();
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
  $("#btnClear").click(function () {
    $("#addForm").trigger("reset");
    getTeam();
  })
});

let team = [];
const getTeam = () => {
  let mileId = document.getElementById("iterMilestone").value;
  fetch(
    window.location.origin + `/issue/list?action=getTeam&mileId=${mileId}`,
    { method: "POST" }
  )
    .then((response) => response.json())
    .then((data) => {
      team = data;
      console.log(data);
      var teamSelect = document.getElementById("iterTeam");
      teamSelect.innerHTML = "";
      data.forEach((element, index) => {
        teamSelect.innerHTML += `<option value="${element.id}">Group ${
          index + 1
        }</option>`;
      });
      if (teamSelect.innerHTML == "") {
        teamSelect.innerHTML += `<option value="-1">Empty Group</option>`;
      }
      getAssignee();
    });
};

const getAssignee = () => {
  let teamId = document.getElementById("iterTeam").value;
  let assigneeSelect = document.getElementById("iterAssignee");
  assigneeSelect.innerHTML = "";
  team.forEach((element) => {
    if (element.id == teamId) {
      element.listTrainee.forEach((member) => {
        assigneeSelect.innerHTML += `<option value="${member.userId}">${member.fullname}</option>`;
      });
    }
  });
  if (assigneeSelect.innerHTML == "") {
    assigneeSelect.innerHTML += `<option value="-1">Empty Asignee</option>`;
  }
};
