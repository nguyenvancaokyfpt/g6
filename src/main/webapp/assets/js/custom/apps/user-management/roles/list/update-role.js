"use strict";
var KTUsersUpdatePermissions = (function () {
  const t = document.getElementById("kt_modal_update_role"),
    k = document.getElementsByName("edit-role"),
    e = t.querySelector("#kt_modal_update_role_form"),
    n = new bootstrap.Modal(t);
  var role_id_selected = null,
    role_title_selected = null,
    role_permissions = {};
  k.forEach((element) => {
    element.addEventListener("click", function () {
      // reset all checkbox
      const screen = e.querySelectorAll('[name="screen"]');
      screen.forEach((e) => {
        e.querySelectorAll('[type="checkbox"]').forEach((v) => {
          v.checked = false;
        });
      });
      role_id_selected = element.getAttribute("role-id");
      role_title_selected = element.getAttribute("role-title");
      t.querySelector('[name="role_name"]').value = role_title_selected;
      axios
        .post("setting/role/permissions?action=get", {
          roleId: role_id_selected,
        })
        .then(function (response) {
          role_permissions = response.data.data.permissions;
          role_permissions.forEach((permission) => {
            const screen = e.querySelectorAll('[name="screen"]');
            screen.forEach((e) => {
              const screenId = e.getAttribute("value");
              if (screenId == permission.screenId) {
                e.querySelectorAll('[type="checkbox"]').forEach((v) => {
                  switch (v.getAttribute("name")) {
                    case "canGet":
                      v.checked = permission.canGet;
                      break;
                    case "canCreate":
                      v.checked = permission.canCreate;
                      break;
                    case "canUpdate":
                      v.checked = permission.canUpdate;
                      break;
                    case "canDelete":
                      v.checked = permission.canDelete;
                      break;
                    default:
                      v.checked = false;
                      break;
                  }
                });
              }
            });
          });
        })
        .catch(function (error) {
          console.log(error);
        });
    });
  });
  return {
    init: function () {
      (() => {
        var o = FormValidation.formValidation(e, {
          fields: {
            role_name: {
              validators: { notEmpty: { message: "Role name is required" } },
            },
          },
          plugins: {
            trigger: new FormValidation.plugins.Trigger(),
            bootstrap: new FormValidation.plugins.Bootstrap5({
              rowSelector: ".fv-row",
              eleInvalidClass: "",
              eleValidClass: "",
            }),
          },
        });
        t
          .querySelector('[data-kt-roles-modal-action="close"]')
          .addEventListener("click", (t) => {
            t.preventDefault(),
              Swal.fire({
                text: "Are you sure you would like to close?",
                icon: "warning",
                showCancelButton: !0,
                buttonsStyling: !1,
                confirmButtonText: "Yes, close it!",
                cancelButtonText: "No, return",
                customClass: {
                  confirmButton: "btn btn-primary",
                  cancelButton: "btn btn-active-light",
                },
              }).then(function (t) {
                t.value && n.hide();
              });
          }),
          t
            .querySelector('[data-kt-roles-modal-action="cancel"]')
            .addEventListener("click", (t) => {
              t.preventDefault(),
                Swal.fire({
                  text: "Are you sure you would like to cancel?",
                  icon: "warning",
                  showCancelButton: !0,
                  buttonsStyling: !1,
                  confirmButtonText: "Yes, cancel it!",
                  cancelButtonText: "No, return",
                  customClass: {
                    confirmButton: "btn btn-primary",
                    cancelButton: "btn btn-active-light",
                  },
                }).then(function (t) {
                  t.value
                    ? (e.reset(), n.hide())
                    : "cancel" === t.dismiss &&
                      Swal.fire({
                        text: "Your form has not been cancelled!.",
                        icon: "error",
                        buttonsStyling: !1,
                        confirmButtonText: "Ok, got it!",
                        customClass: { confirmButton: "btn btn-primary" },
                      });
                });
            });
        const i = t.querySelector('[data-kt-roles-modal-action="submit"]');
        i.addEventListener("click", function (t) {
          t.preventDefault(),
            o &&
              o.validate().then(function (t) {
                "Valid" == t
                  ? (i.setAttribute("data-kt-indicator", "on"),
                    (i.disabled = !0),
                    setTimeout(function () {
                      i.removeAttribute("data-kt-indicator"),
                        (i.disabled = !1),
                        (() => {
                          const data = {
                            roleId: role_id_selected,
                            permissions: [],
                          };
                          const screen = e.querySelectorAll('[name="screen"]');
                          screen.forEach((e) => {
                            const permission = {
                              screenId: parseInt(e.getAttribute("value")),
                              canGet: false,
                              canCreate: false,
                              canDelete: false,
                              canUpdate: false,
                            };
                            e.querySelectorAll('[type="checkbox"]').forEach(
                              (v) => {
                                switch (v.getAttribute("name")) {
                                  case "canGet":
                                    permission.canGet = v.checked;
                                    break;
                                  case "canCreate":
                                    permission.canCreate = v.checked;
                                    break;
                                  case "canUpdate":
                                    permission.canUpdate = v.checked;
                                    break;
                                  case "canDelete":
                                    permission.canDelete = v.checked;
                                    break;
                                  default:
                                    break;
                                }
                              }
                            );
                            data.permissions.push(permission);
                          });
                          axios
                            .post(
                              "setting/role/permissions?action=update",
                              data
                            )
                            .then(function (response) {
                              axios
                                .post("setting/role/permissions?action=get", {
                                  roleId: role_id_selected,
                                  showAll: false,
                                })
                                .then(function (response) {
                                  const permissions =
                                    response.data.data.permissions;
                                  const element = document.getElementById(
                                    "list-permission-role-" + role_id_selected
                                  );
                                  // empty element
                                  element.innerHTML = "";
                                  for (let index = 0; index <= 5; index++) {
                                    const permission = permissions[index];
                                    const html =
                                      `
                                    <div class="d-flex align-items-center py-2">
                                      <span class="bullet bg-primary me-3"></span>` +
                                      permission.screenTitle +
                                      `
                                    </div>`;
                                    element.innerHTML =
                                      element.innerHTML + html;
                                    if (index == permissions.length - 1) {
                                      break;
                                    }
                                  }
                                  if (permissions.length > 5) {
                                    const html =
                                      `
                                    <div class="d-flex align-items-center py-2">
                                      <span class="bullet bg-primary me-3"></span>and ` +
                                      (permissions.length - 6) +
                                      ` more
                                    </div>`;
                                    element.innerHTML =
                                      element.innerHTML + html;
                                  }
                                })
                                .catch(function (error) {
                                  console.log(error);
                                });
                              $.toast({
                                heading: "Success",
                                text: "Update permission successfully",
                                showHideTransition: "slide",
                                icon: "success",
                                position: 'bottom-right',
                              });
                              n.hide();
                            })
                            .catch(function (error) {
                              console.log(error);
                              $.toast({
                                heading: "Error",
                                text: "Sorry, looks like there are some errors detected, please try again.",
                                showHideTransition: "slide",
                                icon: "error",
                                position: 'bottom-right',
                              });
                              n.hide();
                            });
                        })();
                    }, 5))
                  : Swal.fire({
                      text: "Sorry, looks like there are some errors detected, please try again.",
                      icon: "error",
                      buttonsStyling: !1,
                      confirmButtonText: "Ok, got it!",
                      customClass: { confirmButton: "btn btn-primary" },
                    });
              });
        });
      })(),
        (() => {
          const t = e.querySelector("#kt_roles_select_all"),
            n = e.querySelectorAll('[type="checkbox"]');
          t.addEventListener("change", (t) => {
            n.forEach((e) => {
              e.checked = t.target.checked;
            });
          });
        })();
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTUsersUpdatePermissions.init();
});
