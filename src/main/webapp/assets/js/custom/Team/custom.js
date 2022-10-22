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
                <p class="create_notification">Trainees have not been grouped. <a class="btn-create">Creat Groups</a> </p>
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
                <div class="memberItem text-center">
                    <div class="row">
                        <div class="col-1">${trainee.userId}</div>
                        <div class="col-3">${trainee.fullname}</div>
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
                                  <li><a class="dropdown-item" href="#">View/Edit</a></li>
                                  <li><a class="dropdown-item" href="#">Change Status</a></li>
                              </ul>
                          </div>
                        </div>
                    </div>
                </div>
                `;
        });
        teamContent += `
        <div class="row overflow-hidden">
            <div class="teamIteam p-0">
                <div class="accordion">
                <div class="row align-items-center">
                  <div class="col-8" style="padding-right: 0;">
                    <button type="button" class="accordion__button">
                        Group ${index + 1} (${team.topic_name})
                    </button>
                  </div>
                  <div class="col-1 text-center list-group-item" style="padding: 15px;">
                    ${team.status_id ? "Active" : "Inactive"}
                  </div>
                  <div class="col-3 text-center list-group-item" style="padding: 14px;">
                    <div class="btn-group dropend">
                    <button type="button" class="after-none btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                        aria-expanded="false" style="padding: 0 10px;">
                        <i class="fa fa-ellipsis-v"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">View/Edit</a></li>
                        <li><a class="dropdown-item" href="#">Change Status</a></li>
                    </ul>
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
        <div class="memberItem text-center">
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
                      <li><a class="dropdown-item" href="#">View/Edit</a></li>
                      <li><a class="dropdown-item" href="#">Change Status</a></li>
                  </ul>
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
                  <a class="btn-create">Remove Group</a>
                  <a class="btn-create">Add New Group</a> 
                </p>
              </div>
        </div>
        <div class="container-fluid">
          <div class="row py-5 fs-5 text-center fw-bold" style="border: 1px solid #e4e6ef;">
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
  console.log("ready!");
  getClass();
});
