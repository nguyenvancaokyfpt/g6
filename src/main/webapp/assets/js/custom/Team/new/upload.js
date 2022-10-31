"use strict";
var KTTeamUpload = (function () {
  var fileUrl = "";
  var teamPreviewSelector = $("#kt-team-preview");
  var discardBtn = document.querySelector(
    '[data-kt-users-modal-action="cancel"]'
  );
  var submitBtn = document.querySelector(
    '[data-kt-users-modal-action="submit"]'
  );
  var resetBtn = document.querySelector(
    '[data-kt-users-modal-action="reset-team"]'
  );
  var mydropzone = new Dropzone("#kt_modal_create_project_settings_logo", {
    url: window.location.origin + "/upload",
    paramName: "file",
    maxFiles: 1,
    maxFilesize: 10,
    addRemoveLinks: !0,
    acceptedFiles: ".xlsx, .xls",
    accept: function (e, t) {
      t();
    },
    init: function () {
      fileUrl = "";
      this.on("success", function (e, t) {
        fileUrl = t.data[0];
        console.log(fileUrl);
        axios
          .post("/team/new?action=get", {
            fileUrl: fileUrl,
            action: "readTeamImportFile",
          })
          .then(function (e) {
            console.log(e.data);
            // replace group 1 with group 2
            var data = JSON.parse(
              e.data.replace(/[\{\,]((\d):)[[]/gm, function (match, p1, p2) {
                return match.replace(p1, '"' + p2 + '":');
              })
            );
            // remove all child
            teamPreviewSelector.empty();
            // add new child
            const teamItems = data.data.traineeTeamMap;
            console.log(teamItems);
            for (const teamItem in teamItems) {
              let html_body = ``;
              for (const traineeItem in teamItems[teamItem]) {
                let html_leader = ``;
                if (teamItems[teamItem][traineeItem].isLeader) {
                  html_leader = `
                    <span class="badge badge-light-danger fs-8 fw-bolder">Leader</span>
                    `;
                }
                html_body +=
                  `
                <div class="d-flex align-items-center mb-7">
                <!--begin::Avatar-->
                <div class="symbol symbol-50px me-5">
                    <img src="` +
                  teamItems[teamItem][traineeItem].avatarUrl +
                  `" class="" alt="" />
                </div>
                <!--end::Avatar-->
                <!--begin::Text-->
                <div class="flex-grow-1">
                    <a href="#" class="text-dark fw-bolder text-hover-primary fs-6">` +
                  teamItems[teamItem][traineeItem].fullname +
                  `</a>
                    <span class="text-muted d-block fw-bold">` +
                  teamItems[teamItem][traineeItem].email +
                  `</span>
                </div>
                <!--end::Text-->
                ` +
                  html_leader +
                  `
                </div>
                `;
              }
              let html =
                `
              <div kt-team-item class="col-xl-4">
              <!--begin::List Widget 2-->
              <div class="card card-xl-stretch mb-xl-8">
                  <!--begin::Header-->
                  <div class="card-header border-0">
                      <h3 class="card-title fw-bolder text-dark">Group ` +
                teamItem +
                `</h3>
                      <div class="card-toolbar">
                          <!--begin::Menu-->
                          <button type="button"
                              class="btn btn-sm btn-icon btn-color-primary btn-active-light-primary"
                              data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end"
                              data-kt-menu-flip="top-end">
                              <!--begin::Svg Icon | path: icons/duotone/Layout/Layout-4-blocks-2.svg-->
                              <span class="svg-icon svg-icon-2">
                                  <svg xmlns="http://www.w3.org/2000/svg"
                                      xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                      viewBox="0 0 24 24" version="1.1">
                                      <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                          <rect x="5" y="5" width="5" height="5" rx="1" fill="#000000" />
                                          <rect x="14" y="5" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                          <rect x="5" y="14" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                          <rect x="14" y="14" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                      </g>
                                  </svg>
                              </span>
                              <!--end::Svg Icon-->
                          </button>
                          <!--end::Menu-->
                      </div>
                  </div>
                  <!--end::Header-->
                  <!--begin::Body-->
                  <div class="card-body pt-2">
                      <!--begin::Item-->
                        ` +
                html_body +
                `
                      <!--end::Item-->
                  </div>
                  <!--end::Body-->
              </div>
              <!--end::List Widget 2-->
            </div>
              `;
              teamPreviewSelector.append(html);
            }
          })
          .catch(function (e) {
            console.log(e);
          });
      });
      this.on("removedfile", function (f) {
        fileUrl = "";
        teamPreviewSelector.empty();
      });
    },
  });
  var classSelector = $('[name="milestoneId"]');
  return {
    init: function () {
      classSelector.on("select2:selecting", function (e) {
        let milestoneId = e.params.args.data.id;
        let classId = $('[name="classId"]').val();
        axios
          .post("team/new?action=get", {
            classId: classId,
            milestoneId: milestoneId,
            action: "teamMember",
          })
          .then((e) => {
            console.log(e.data);
            // replace group 1 with group 2
            var data = JSON.parse(
              e.data.replace(/[\{\,]((\d):)[[]/gm, function (match, p1, p2) {
                return match.replace(p1, '"' + p2 + '":');
              })
            );
            // remove all child
            teamPreviewSelector.empty();
            // add new child
            const teamItems = data.data;
            for (const teamItem in teamItems) {
              let html_body = ``;
              for (const traineeItem in teamItems[teamItem]) {
                let html_leader = ``;
                if (teamItems[teamItem][traineeItem].isLeader) {
                  html_leader = `
                    <span class="badge badge-light-danger fs-8 fw-bolder">Leader</span>
                    `;
                }
                html_body +=
                  `
                <div class="d-flex align-items-center mb-7">
                <!--begin::Avatar-->
                <div class="symbol symbol-50px me-5">
                    <img src="` +
                  teamItems[teamItem][traineeItem].avatarUrl +
                  `" class="" alt="" />
                </div>
                <!--end::Avatar-->
                <!--begin::Text-->
                <div class="flex-grow-1">
                    <a href="#" class="text-dark fw-bolder text-hover-primary fs-6">` +
                  teamItems[teamItem][traineeItem].fullname +
                  `</a>
                    <span class="text-muted d-block fw-bold">` +
                  teamItems[teamItem][traineeItem].email +
                  `</span>
                </div>
                <!--end::Text-->
                ` +
                  html_leader +
                  `
                </div>
                `;
              }
              let html =
                `
              <div kt-team-item class="col-xl-4">
              <!--begin::List Widget 2-->
              <div class="card card-xl-stretch mb-xl-8">
                  <!--begin::Header-->
                  <div class="card-header border-0">
                      <h3 class="card-title fw-bolder text-dark">Group ` +
                teamItem +
                `</h3>
                      <div class="card-toolbar">
                          <!--begin::Menu-->
                          <button type="button"
                              class="btn btn-sm btn-icon btn-color-primary btn-active-light-primary"
                              data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end"
                              data-kt-menu-flip="top-end">
                              <!--begin::Svg Icon | path: icons/duotone/Layout/Layout-4-blocks-2.svg-->
                              <span class="svg-icon svg-icon-2">
                                  <svg xmlns="http://www.w3.org/2000/svg"
                                      xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
                                      viewBox="0 0 24 24" version="1.1">
                                      <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                          <rect x="5" y="5" width="5" height="5" rx="1" fill="#000000" />
                                          <rect x="14" y="5" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                          <rect x="5" y="14" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                          <rect x="14" y="14" width="5" height="5" rx="1" fill="#000000"
                                              opacity="0.3" />
                                      </g>
                                  </svg>
                              </span>
                              <!--end::Svg Icon-->
                          </button>
                          <!--end::Menu-->
                      </div>
                  </div>
                  <!--end::Header-->
                  <!--begin::Body-->
                  <div class="card-body pt-2">
                      <!--begin::Item-->
                        ` +
                html_body +
                `
                      <!--end::Item-->
                  </div>
                  <!--end::Body-->
              </div>
              <!--end::List Widget 2-->
            </div>
              `;
              if (html_body != "") {
                teamPreviewSelector.append(html);
              }
            }
            $.toast({
              heading: "Success",
              text: "Team member loaded",
              showHideTransition: "slide",
              icon: "success",
              position: "bottom-right",
            });
          })
          .catch((err) => {
            console.log(err);
            teamPreviewSelector.empty();
            $.toast({
              heading: "Warning",
              text: "No team member found",
              showHideTransition: "slide",
              icon: "warning",
              position: "bottom-right",
            });
            teamPreviewSelector.append(
              `
                <!--begin::Navbar-->
                <div class="card">
                    <div class="card-body pt-9 pb-0">
                        <!--begin::Details-->
                        <div class="d-flex flex-wrap flex-sm-nowrap mt-6">
                            <!--begin::Wrapper-->
                            <div class="flex-grow-1">
                                <!--begin::Info-->
                                <div class="d-flex flex-wrap justify-content-center">
                                    <!--begin::Form-->
                                    <form id="kt_modal_export_users_form" class="form mb-6" action="#">
                                        <div class="mb-13 text-center">
                                            <!--begin::Dropzone-->
                                            <div class="dropzone" id="ps">
                                                <!--begin::Message-->
                                                <div class="dz-message needsclick">
                                                    <!--begin::Icon-->
                                                    <!--begin::Svg Icon | path: icons/duotone/Files/Uploaded-file.svg-->
                                                    <span class="svg-icon svg-icon-3hx svg-icon-primary">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                            xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                                                            height="24px" viewBox="0 0 24 24" version="1.1">
                                                            <g stroke="none" stroke-width="1" fill="none"
                                                                fill-rule="evenodd">
                                                                <circle fill="#000000" opacity="0.3" cx="12" cy="12"
                                                                    r="10" />
                                                                <rect fill="#000000" x="11" y="10" width="2" height="7"
                                                                    rx="1" />
                                                                <rect fill="#000000" x="11" y="7" width="2" height="2"
                                                                    rx="1" />
                                                            </g>
                                                        </svg>
                                                    </span>
                                                    <!--end::Svg Icon-->
                                                    <!--end::Icon-->
                                                    <!--begin::Info-->
                                                    <div class="ms-4">
                                                        <h2 class="dfs-2 fw-bolder text-gray-900 mb-1 mt-3">Not created
                                                            yet
                                                        </h2>
                                                    </div>
                                                    <!--end::Info-->
                                                </div>
                                            </div>
                                            <!--end::Dropzone-->
                                        </div>
                                    </form>
                                    <!--end::Form-->
                                </div>
                                <!--end::Info-->
                            </div>
                            <!--end::Wrapper-->
                        </div>
                        <!--end::Details-->
                    </div>
                </div>
                <!--end::Navbar-->
                `
            );
          });
      });
      discardBtn.addEventListener("click", function (e) {
        e.preventDefault();
        mydropzone.removeAllFiles(true);
        teamPreviewSelector.empty();
        fileUrl = "";
        $('[name="milestoneId"]').val("").trigger("change");
      });
      submitBtn.addEventListener("click", function (e) {
        e.preventDefault();
        const milestoneId = $('[name="milestoneId"]').val();
        const classId = $('[name="classId"]').val();
        if (milestoneId == "") {
          $.toast({
            heading: "Error",
            text: "Please select a milestone",
            showHideTransition: "slide",
            icon: "error",
            position: "bottom-right",
          });
          return;
        }
        if (mydropzone.files.length == 0 || fileUrl == "") {
          $.toast({
            heading: "Error",
            text: "Please select file to import",
            showHideTransition: "slide",
            icon: "error",
            position: "bottom-right",
          });
          return;
        }
        axios
          .post("team/new?action=create", {
            fileUrl: fileUrl,
            action: "import",
            milestoneId: milestoneId,
            classId: classId,
          })
          .then(function (e) {
            $.toast({
              heading: "Success",
              text: "Import team successfully!",
              showHideTransition: "slide",
              icon: "success",
              position: "bottom-right",
            });
            mydropzone.removeAllFiles(true);
            $('[name="milestoneId"]').val("").trigger("change");
          })
          .catch(function (e) {
            console.log(e);
            $.toast({
              heading: "Error",
              text: "Import team failed!",
              showHideTransition: "slide",
              icon: "error",
              position: "bottom-right",
            });
          });
      });
      resetBtn.addEventListener("click", function (e) {
        e.preventDefault();
        const milestoneId = $('[name="milestoneId"]').val();
        const classId = $('[name="classId"]').val();
        if (milestoneId == "") {
          $.toast({
            heading: "Error",
            text: "Please select milestone!",
            showHideTransition: "slide",
            icon: "error",
            position: "bottom-right",
          });
          return;
        }
        Swal.fire({
          title: "Are you sure?",
          text: "You won't be able to revert this!",
          icon: "warning",
          showCancelButton: !0,
          buttonsStyling: !1,
          confirmButtonText: "Yes, reset it!",
          cancelButtonText: "No, cancel!",
          customClass: {
            confirmButton: "btn btn-primary",
            cancelButton: "btn btn-active-light",
          },
        }).then(function (e) {
          if (e.isConfirmed) {
            axios
              .post("team/new?action=delete", {
                action: "resetTeam",
                milestoneId: milestoneId,
                classId: classId,
              })
              .then(function (e) {
                $.toast({
                  heading: "Success",
                  text: "Reset team successfully!",
                  showHideTransition: "slide",
                  icon: "success",
                  position: "bottom-right",
                });
                teamPreviewSelector.empty();
              })
              .catch(function (e) {
                console.log(e);
                $.toast({
                  heading: "Error",
                  text: "Reset team failed!",
                  showHideTransition: "slide",
                  icon: "error",
                  position: "bottom-right",
                });
              });
          }
        });
      });
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTTeamUpload.init();
});
