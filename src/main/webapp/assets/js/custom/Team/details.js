let teamMember;
let waitingList;
let baseTeam = [];
function showItem() {
  if ($("#going").val() == "1") {
    toastr.error("This milestone is on going or closed!");
    return;
  }
  editMember();
  var hide = document.getElementsByClassName("itemHidden");
  var show = document.getElementsByClassName("itemShow");
  var inline = document.getElementsByClassName("itemHiddenInline");
  hide.forEach((e) => {
    e.style.setProperty("display", "block", "important");
  });
  inline.forEach((e) => {
    e.style.setProperty("display", "inline", "important");
  });
  show.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
}

function hideItem() {
  var show = document.getElementsByClassName("itemHidden");
  var hide = document.getElementsByClassName("itemShow");
  var inline = document.getElementsByClassName("itemHiddenInline");
  hide.forEach((e) => {
    e.style.setProperty("display", "block", "important");
  });
  inline.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
  show.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
}

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
  showToast();
  $("#btnShow").click(() => {
    showItem();
  });
  $("#btnHide").click(() => {
    hideItem();
    cancelEdit();
  });

  let classId = document.getElementById("classId").value;
  let teamId = document.getElementById("teamId").value;
  let mileId = document.getElementById("mileId").value;
  getWaitingList(classId, mileId);
  getTeamMember(classId, teamId);
});

function showToast() {
  try {
    var type = document.getElementById("toastStatus").value;
    if (type == "1") {
      toastr.success("Update Successfully");
    } else if (type == "2") {
      toastr.success("Added Successfully");
    }
  } catch (e) {}
}

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

const cancelEdit = () => {
  $(".teamMember").each(function () {
    let currentHTML = $(this).html();
    $(this).hover(function () {
      $(this).html(currentHTML);
    });
  });
};

const getTeamMember = (classId, teamId) => {
  fetch(
    window.location.origin +
      `/team/detail?action=getMember&classId=${classId}&teamId=${teamId}`,
    { method: "GET" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      teamMember = data;
      teamMember.map((t) => {
        baseTeam.push(t);
      });
      console.log(baseTeam);
      render();
    })
    .catch((error) => {
      console.log(error);
    });
};

const getWaitingList = (classId, mileId) => {
  fetch(
    window.location.origin +
      `/team/detail?action=getWaiting&classId=${classId}&mileId=${mileId}`,
    { method: "GET" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      waitingList = data;
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
  content += ` <button type="button" class="btn btn-secondary itemHiddenInline d-none" data-bs-toggle="modal" data-bs-target="#btnAdd" style="height: 64px;"><i class="fa fa-plus" style="font-size: 30px;"></i></button>
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
  showItem();
};

const AddTeam = (id) => {
  let userId = $("#selectAdd").val();
  if (userId == null) return;
  waitingList.forEach((t, index) => {
    if (t.userId == userId) {
      teamMember.push(t);
      waitingList.splice(index, 1);
    }
  });
  render();
  editMember();
  showItem();
};

const AddToTeam = (traineeId, teamId) => {
  fetch(
    window.location.origin +
      `/team/list?action=addToTeam&traineeId=${traineeId}&teamId=${teamId}`,
    { method: "POST" }
  )
    .then((response) => {})
    .catch((error) => {
      console.log(error);
    });
};

const changeTeam = (traineeId, classId, teamId) => {
  fetch(
    window.location.origin +
      `/team/list?action=update2&traineeId=${traineeId}&classId=${classId}&teamId=${teamId}`,
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

const RemoveFromTeam = (teamId) => {
  fetch(
    window.location.origin + `/team/detail?action=delete&teamId=${teamId}`,
    { method: "GET" }
  )
    .then((response) => {
      if (response.status === 200) {
        teamMember.forEach((t) => {
          AddToTeam(t.userId, teamId);
        });
      }
    })
    .catch((error) => {
      console.log(error);
    });
};

const saveAll = () => {
  let teamId = document.getElementById("teamId").value;
  RemoveFromTeam(teamId);
  document.getElementById("myForm").submit();
};
