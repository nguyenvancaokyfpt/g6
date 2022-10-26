let teamMember = [];
let waitingList;

const editMember = () => {
  //for each element in class teamMember
  $(".teamMember").each(function () {
    let currentHTML = $(this).html();
    $(this).hover(
      function () {
        $(this).html(
          `<i class="fa fa-minus" style="font-size: 30px;" onclick="RemoveTeam(${this.id})"></i>`
        );
      },
      function () {
        $(this).html(currentHTML);
      }
    );
  });
};

const getWaitingList = (classId) => {
  fetch(
    window.location.origin +
      `/team/detail?action=getWaiting&classId=${classId}`,
    { method: "GET" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      waitingList = data;
      console.log(waitingList);
      render();
    })
    .catch((error) => {
      console.log(error);
    });
};

const render = () => {
  let content = "";
  teamMember.forEach((t, index) => {
    content += `
        <button id="btnMem${
          t.userId
        }" type="button" class="btn btn-secondary teamMember ${
      index > 3 ? "mt-1" : ""
    }">
            ${t.fullname}
          <br>ID: ${t.userId}
          </button>
        `;
  });
  content += ` <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#btnAdd" style="height: 64px;"><i class="fa fa-plus" style="font-size: 30px;"></i></button>
    <div class="modal fade" id="btnAdd" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Comfirm</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
          <select id="selectAdd" class="form-select" aria-label="Default select example">
            <option selected disabled>${
              waitingList.length == 0
                ? "Empty Trainee"
                : "Select Trainee in waiting list"
            }</option>
            ${waitingList.map((w) => {
              return `<option value="${w.userId}">${w.fullname}</option>`;
            })}
          </select>
          </div>
          <div div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <a class="btn btn-primary" data-bs-dismiss="modal" onclick="AddTeam()">Add</a>
          </div>
        </div>
      </div>
    </div>
    `;
  document.getElementById("teamMember").innerHTML = content;
};

const RemoveTeam = (id) => {
  let userId = id.id.replace("btnMem", "");
  // let classId = document.getElementById("classId").value;
  teamMember.forEach((t, index) => {
    if (t.userId == userId) {
      waitingList.push(t);
      teamMember.splice(index, 1);
    }
  });
  render();
  editMember();
};

const AddTeam = () => {
  let userId = $("#selectAdd").val();
  if (userId == null) return;
  waitingList.forEach((t, index) => {
    if (t.userId == userId) {
      console.log("test");
      teamMember.push(t);
      waitingList.splice(index, 1);
    }
  });
  render();
  editMember();
};

$(document).ready(function () {
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

  let classId = document.getElementById("team_class").value;
  getWaitingList(classId);
});

const changeTeam = (traineeId, classId, teamId) => {
  fetch(
    window.location.origin +
      `/team/list?action=update&traineeId=${traineeId}&classId=${classId}&teamId=${teamId}`,
    { method: "POST" }
  )
    .then((response) => {
      if (response.status === 200) {
      } else {
        toastr.error("Team Updated Fail!");
      }
    })
    .catch((error) => {
      console.log(error);
    });
};

const newTeam = () => {
  let team_class = document.getElementById("team_class").value;
  let team_project = document.getElementById("team_project").value;
  let team_topicName = document.getElementById("team_topicName").value;
  let team_topicCode = document.getElementById("team_topicCode").value;
  let team_description = document.getElementById("team_description").value;
  let team_status = document.getElementsByName("team_status")[0].checked
    ? 1
    : 0;
  if (team_project == "" || team_topicName == "" || team_topicCode == "") {
    toastr.error("Please fill all information!");
    return;
  }
  // call api
  fetch(
    window.location.origin +
      `/team/detail?action=doAdd&team_class=${team_class}&team_project=${team_project}&team_topicName=${team_topicName}&team_topicCode=${team_topicCode}&team_description=${team_description}&team_status=${team_status}`,
    { method: "GET" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      saveAll(data);
      teamMember = [];
      render();
      $("#btnClear").click();
      toastr.success("Team Added Successfully!");
    })
    .catch((error) => {
      console.log(error);
    });
};

const saveAll = (teamId) => {
  let classId = document.getElementById("team_class").value;
  teamMember.forEach((t) => {
    changeTeam(t.userId, classId, teamId);
  });
};
