// To create Dropdown team
const dropdown = () => {
  document.querySelectorAll(".accordion__button").forEach((button) => {
    button.addEventListener("click", () => {
      const accordionContent =
        button.parentElement.parentElement.nextElementSibling;
      button.classList.toggle("accordion__button--active");
      if (button.classList.contains("accordion__button--active")) {
        accordionContent.style.maxHeight = accordionContent.scrollHeight + "px";
      } else {
        accordionContent.style.maxHeight = 0;
      }
    });
  });
};

const changeStatus = (teamId, statusId) => {
  fetch(
    window.location.origin +
      `/team/list?action=changeStatus&teamId=${teamId}&statusId=${statusId}`,
    { method: "POST" }
  )
    .then((response) => {
      if (response.status === 200) {
        getClass();
        toastr.success("Team Status Updated Successfully!");
      }
    })
    .catch((error) => {
      console.log(error);
    });
};


const changeTeam = (traineeId, classId) => {
  teamId = document.getElementById(`selectAdd${traineeId}`).value;
  fetch(
    window.location.origin + `/team/list?action=update&traineeId=${traineeId}&classId=${classId}&teamId=${teamId}`,
    { method: "POST" }
  ).then((response) => {
    if (response.status === 200) {
      getClass();
      toastr.success("Team Updated Successfully!");
    }else{
      toastr.error("Team Updated Fail!");
    }
  }).catch((error) => {
    console.log(error);
  });
};

const RemoveFromTeam = (traineeId, classId,teamId) => {
  fetch(
    window.location.origin + `/team/detail?action=delete&traineeId=${traineeId}&classId=${classId}&teamId=${teamId}`,
    { method: "GET" }
  ).then((response) => {
    if (response.status === 200) {
      getClass();
      toastr.success("Remove Successfully!");
    }
  }).catch((error) => {
    console.log(error);
  });
};

const SetLeader = (traineeId, classId,teamId) => {
  fetch(
    window.location.origin + `/team/list?action=leader&traineeId=${traineeId}&classId=${classId}&teamId=${teamId}`,
    { method: "POST" }
  ).then((response) => {
    if (response.status === 200) {
      getClass();
      toastr.success("Set leader Successfully!");
    }
  }).catch((error) => {
    console.log(error);
  });
};

const removeTeam = (teamId) => {
  fetch(window.location.origin + `/team/list?action=delete&teamId=${teamId}`, {
    method: "POST",
  })
    .then((response) => {
      if (response.status === 200) {
        getClass();
        toastr.success("Team Deleted Successfully!");
      }
    })
    .catch((error) => {
      console.log(error);
    });
};

const getClass = () => {
  let selectedMile = document.getElementById("selectedMile").value;
  if (selectedMile == "") return;
  fetch(
    window.location.origin + `/team/list?action=list&mileId=${selectedMile}`,
    { method: "POST" }
  )
    .catch((error) => {
      console.log("Please select a milestone");
    })
    .then((response) => {
      return response.json();
    })

    .then((data) => {
      let listTeams = data.listTeam;
      let listTrainees = data.listTrainee;
      data.listWaiting = getWaitingList(listTrainees, listTeams);
      console.log(data);

      if (listTeams.length == 0) {
        $("#teamBody").html(`
          <div class="memberItem" style="padding-left: 20px;">
              <div class="row">
                <p class="create_notification">Trainees have not been grouped. <a class="btn-create">Create Groups</a> </p>
              </div>
          </div>
        `);
        return;
      }

      //Team list content
      let teamContent = ``;
      listTeams.forEach((team, index) => {
        let traineeContent = ``;
        team.listTrainee.forEach((trainee) => {
          traineeContent += `
                <div class="memberItem text-left">
                    <div class="row">
                        <div class="col-1">${trainee.userId}</div>
                        <div class="col-3">${trainee.fullname} ${trainee.isLeader == 1 ? `<i class="fa fa-star text-warning"></i>` :""}</div>
                        <div class="col-4">${trainee.email.toUpperCase()}</div>
                        <div class="col-1">${
                          trainee.statusId == 1 ? "Active" : "Inactive"
                        }</div>
                        <div class="col-3">
                          <div class="btn-group dropend">
                              <button type="button" class="after-none btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                                  aria-expanded="false"  style="padding: 0 10px;">
                                  <i class="fa fa-ellipsis-v"></i>
                              </button>
                              <ul class="dropdown-menu">
                                  <li><a type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelLeader${
                                    trainee.userId
                                  }">Set as leader</a></li>
                                  <li><a type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelChange${
                                    trainee.userId
                                  }">Change Group</a></li>
                                  <li><a type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelRemove${
                                    trainee.userId
                                  }">Remove from group</a></li>
                              </ul>
                              <div class="modal fade" id="modelChange${
                                trainee.userId
                              }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                  <div class="modal-content">
                                    <div class="modal-header">
                                      <h5 class="modal-title">Comfirm</h5>
                                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                    <select id="selectAdd${
                                      trainee.userId
                                    }" class="form-select" aria-label="Default select example">
                                      <option selected disabled>Select the group</option>
                                      ${data.listTeam
                                        .map((team, indexx) => {
                                          if(index == indexx) return "";
                                          return `<option value="${team.id}">Group ${
                                            indexx + 1
                                          }</option>`;
                                        })
                                        .join("")}
                                    </select>
                                    </div>
                                    <div div class="modal-footer">
                                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                      <a class="btn btn-primary" data-bs-dismiss="modal" onclick="changeTeam(${trainee.userId},${data.id})">Change</a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="modal fade" id="modelRemove${
                                trainee.userId
                              }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                  <div class="modal-content">
                                    <div class="modal-header">
                                      <h5 class="modal-title">Comfirm</h5>
                                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                      Are you sure you want to remove this trainee from the group?
                                    </div>
                                    <div div class="modal-footer">
                                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                      <a class="btn btn-primary" data-bs-dismiss="modal" onclick="RemoveFromTeam(${trainee.userId},${data.id},${team.id})">Remove</a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="modal fade" id="modelLeader${
                                trainee.userId
                              }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                  <div class="modal-content">
                                    <div class="modal-header">
                                      <h5 class="modal-title">Comfirm</h5>
                                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                      Are you sure you want to set this trainee as leader?
                                    </div>
                                    <div div class="modal-footer">
                                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                      <a class="btn btn-primary" data-bs-dismiss="modal" onclick="SetLeader(${trainee.userId},${data.id},${team.id})">Submit</a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                          </div>
                        </div>
                    </div>
                </div>
                `;
        });
        teamContent += `
        <div class="row">
            <div class="teamIteam p-0">
                <div class="accordion">
                <div class="row align-items-center">
                  <div class="col-8" style="padding-right: 0;">
                    <button type="button" class="accordion__button">
                        Group ${index + 1} (${team.topic_name})
                    </button>
                  </div>
                  <div class="col-1 text-left list-group-item" style="padding: 15px;">
                    ${team.status_id ? "Active" : "Inactive"}
                  </div>
                  <div class="col-3 text-left list-group-item" style="width: 24.4%;border-right: 1px solid #e4e6ef;padding: 14px;">
                    <div class="btn-group dropend">
                    <button type="button" class="after-none btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                        aria-expanded="false" style="padding: 0 10px;">
                        <i class="fa fa-ellipsis-v"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/team/detail?action=get&teamId=${
                          team.id
                        }&classId=${data.id}">View/Edit</a></li>
                        <li><a type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelRemoveTeam${
                          team.id
                        }">Remove Group</a></li>
                        <li><a type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelStatusTeam${
                          team.id
                        }">${
                          team.status_id ? "Deactive" : "Active"
                        }</a></li>
                    </ul>
                    <div class="modal fade" id="modelRemoveTeam${
                      team.id
                    }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title">Comfirm</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            Are you sure you want to remove this group?
                          </div>
                          <div div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <a class="btn btn-primary" data-bs-dismiss="modal" onclick="removeTeam(${team.id})">Remove</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="modal fade" id="modelStatusTeam${
                      team.id
                    }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title">Comfirm</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            Are you sure you want to ${team.status_id ? "Deactive" : "Active"} this group?
                          </div>
                          <div div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <a class="btn btn-primary" data-bs-dismiss="modal" onclick="changeStatus(${team.id },${team.status_id})">${team.status_id ? "Deactive" : "Active"}</a>
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
                  </div>
                </div>
                <div class="accordion__content">
                    ${
                      traineeContent != ``
                        ? traineeContent
                        : `
                    <div class="memberItem text-center" style="padding-left: 20px;">
                      <div class="row">
                          There is no trainee in this group
                      </div>
                    </div>
                    `
                    }
                </div>
              </div>
            </div>
        </div>
        `;
      });

      //Wating list content
      let waitingTrainees = ``;
      data.listWaiting.forEach((trainee) => {
        waitingTrainees += `
        <div class="memberItem text-left">
          <div class="row">
              <div class="col-1">${trainee.userId}</div>
              <div class="col-3">${trainee.fullname}</div>
              <div class="col-4">${trainee.email.toUpperCase()}</div>
              <div class="col-1"></div>
              <div class="col-3">
                <div class="btn-group dropend">
                  <button type="button" class="after-none btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                      aria-expanded="false"  style="padding: 0 10px;">
                      <i class="fa fa-ellipsis-v"></i>
                  </button>
                  <ul class="dropdown-menu">
                      <li><a type="button" class="dropdown-item text-center" data-bs-toggle="modal" data-bs-target="#modelAdd${
                        trainee.userId
                      }">Add to group</a></li>
                  </ul>
                  <div class="modal fade" id="modelAdd${
                    trainee.userId
                  }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title">Add to Group</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <select id="selectAdd${
                            trainee.userId
                          }" class="form-select" aria-label="Default select example">
                            <option selected disabled>Select the group</option>
                            ${data.listTeam
                              .map((team, index) => {
                                return `<option value="${team.id}">Group ${
                                  index + 1
                                }</option>`;
                              })
                              .join("")}
                          </select>
                        </div>
                        <div div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          <a class="btn btn-primary" data-bs-dismiss="modal" onclick="changeTeam(${trainee.userId},${data.id})">Add</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
          </div>
        </div>
        `;
      });
      let waitingContent = `
      <div class="row">
        <div class="teamIteam p-0">
            <div class="accordion">
            <div>
              <div>
                <button type="button" class="accordion__button Waiting"><span
                            style="color: #cc6961;">Waiting List</span> (These trainees would work
                        personally)</button>
              </div>
            </div>
                
                <div class="accordion__content">
                    ${
                      waitingTrainees != ``
                        ? waitingTrainees
                        : `
                        <div class="memberItem text-center" style="padding-left: 20px;">
                            <div class="row">
                                There is no trainee in this waiting list
                            </div>
                        </div>
                    `
                    }
                </div>
            </div>
        </div>
      </div>
      `;

      //Team body content
      $("#teamBody").html(
        `
        <div class="memberItem" style="padding-left: 20px;">
              <div class="row">
                <p class="create_notification">This milestone has groups already. 
                  <a class="btn-create">Reset Groups</a> 
                  <a class="btn-create" href="team/detail?action=create&classId=${data.id}">Add New Group</a> 
                </p>
              </div>
        </div>
        <div class="container-fluid">
          <div class="row py-5 fs-5 text-left fw-bold" style="border: 1px solid #e4e6ef;">
              <div class="col-1">#</div>
              <div class="col-3">Student</div>
              <div class="col-4">Email</div>
              <div class="col-1">Status</div>
              <div class="col-3">Actions</div>
          </div>
          <div id="waitingsList">
          </div>
          <div id="groupsList">
          </div>
        </div>
        `
      );
      document.getElementById("waitingsList").innerHTML = waitingContent;
      document.getElementById("groupsList").innerHTML = teamContent;
      dropdown();
    })
    .catch((error) => {
      console.log(error);
    });
};

// Fuction to get Waiting List
const checkInTeam = (trainee, listTeam) => {
  let check = false;
  listTeam.forEach((team) => {
    team.listTrainee.forEach((traineeTeam) => {
      if (traineeTeam.userId == trainee.userId) {
        check = true;
      }
    });
  });
  return check;
};

const getWaitingList = (listTrainees, listTeams) => {
  let trainees = [];
  listTrainees.forEach((trainee) => {
    if (checkInTeam(trainee, listTeams) == false) {
      trainees.push(trainee);
    }
  });
  return trainees;
};
//End

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
  getClass();
});


