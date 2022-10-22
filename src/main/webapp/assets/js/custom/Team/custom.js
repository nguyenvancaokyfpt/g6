// To create Dropdown team
const dropdown = () => {
  document.querySelectorAll(".accordion__button").forEach((button) => {
    button.addEventListener("click", () => {
      const accordionContent = button.nextElementSibling;
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
  if(selectedMile == '')return
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
                        <div class="col-2">${
                          trainee.statusId == 1 ? "Active" : "Inactive"
                        }</div>
                        <div class="col-2">
                          <i class="fa fa-ellipsis-v"></i>
                        </div>
                    </div>
                </div>
                `;
        });
        teamContent += `
        <div class="row">
            <div class="teamIteam p-0">
                <div class="accordion">
                    <button type="button" class="accordion__button">
                        <div class="row">
                            <div class="col-8">Group ${index + 1} (${
          team.topic_name
        })</div>
                            <div class="col-2 text-center">${
                              team.status_id ? "Active" : "Inactive"
                            }</div>
                            <div class="col-2 text-center">
                              <i class="fa fa-ellipsis-v"></i>
                            </div>
                        </div>
                    </button>
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

      let waitingTrainees = ``;
      data.listWaiting.forEach((trainee) => {
        waitingTrainees += `
        <div class="memberItem text-center">
          <div class="row">
              <div class="col-1">${trainee.userId}</div>
              <div class="col-3">${trainee.fullname}</div>
              <div class="col-4">${trainee.email.toUpperCase()}</div>
              <div class="col-2"></div>
              <div class="col-2">
                <i class="fa fa-ellipsis-v"></i>
              </div>
          </div>
        </div>
        `;
      });
      let waitingContent = `
      <div class="row">
        <div class="teamIteam p-0">
            <div class="accordion">
                <button type="button" class="accordion__button Waiting"><span
                        style="color: #cc6961;">Waiting List</span> (These trainees would work
                    personally)</button>
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
              <div class="col-2">Status</div>
              <div class="col-2">Actions</div>
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
