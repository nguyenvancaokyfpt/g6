"use strict";
var KTCreateAccount = (function () {
  var e,
    t,
    i,
    o,
    r,
    s,
    a = [];
  var accountTypes = 1;
  return {
    init: function () {
      $('[data-control="select2-c"]').select2({
        ajax: {
          method: "POST",
          dataType: "json",
          contentType: "application/json",
          url: "management/trainee/list?action=list2",
          data: function (params) {
            return JSON.stringify({
              q: params.term,
              page: params.page || 1,
            });
          },
          processResults: function (data, params) {
            params.page = params.page || 1;
            data.data.forEach(function (entry, index) {
              entry.id = entry.userId;
            });
            console.log(data.data);
            return {
              results: data.data,
              pagination: {
                more: params.page * 10 < data.recordsFiltered,
              },
            };
          },
          cache: false,
        },
        placeholder: "Select a trainee",
        minimumInputLength: 1,
        templateResult: function (repo) {
          if (repo.loading) return repo.text;

          var $container = $(
            `
<div class=" d-flex align-items-center">
          <div class="symbol symbol-circle symbol-50px overflow-hidden me-3">
              <span>
                  <div class="symbol-label">
                      <img src="` +
              repo.avatarUrl +
              `" alt="` +
              repo.fullname +
              `" class="w-100">
                  </div>
              </span>
          </div>
          <!--end::Avatar-->
          <!--begin::User details-->
          <div class="d-flex flex-column">
              <span class="text-gray-800 text-hover-primary mb-1">` +
              repo.fullname +
              `</span>
              <span>` +
              repo.email +
              `</span>
          </div>
          <!--begin::User details-->
      </div>
`
          );
          return $container;
        },
        templateSelection: function (trainee) {
          return trainee.email;
        },
        dropdownParent: $("#kt_create_account_stepper"),
      });
      document.querySelectorAll('[name="account_type"]').forEach(function (e) {
        e.addEventListener("click", function (e) {
          accountTypes = e.target.value;
          console.log(accountTypes);
        });
      }),
        (t = document.querySelector("#kt_modal_create_account")) &&
          (e = new bootstrap.Modal(t)),
        (i = document.querySelector("#kt_create_account_stepper")),
        (o = i.querySelector("#kt_create_account_form")),
        (r = i.querySelector('[data-kt-stepper-action="submit"]')),
        (s = new KTStepper(i)).on("kt.stepper.next", function (e) {
          console.log("stepper.next" + e.getCurrentStepIndex());
          if (e.getCurrentStepIndex() == 2) {
            e.goTo(1);
            Swal.fire({
              text: "Are you sure you would like add this trainee to class?",
              icon: "warning",
              showCancelButton: true,
              buttonsStyling: false,
              confirmButtonText: "Yes, add it!",
              cancelButtonText: "No, cancel",
              customClass: {
                confirmButton: "btn fw-bold btn-primary",
                cancelButton: "btn fw-bold btn-active-light-primary",
              },
            }).then(function (t) {
              axios
                .post("management/trainee/list?action=addToClass", {
                  userId: $('[name="traineeAddId"]').val(),
                  classId: $('[name="ClasstraineeAdd"').val(),
                })
                .then(function (response) {
                  $.toast({
                    heading: "Success",
                    text: "Add trainee to class successfully",
                    showHideTransition: "slide",
                    icon: "success",
                    position: "bottom-right",
                  });
                  // TIMEOUT 2s
                  setTimeout(function () {
                    window.location.reload();
                  }, 2000);
                })
                .catch(function (error) {
                  console.log(error);
                  $.toast({
                    heading: "Error",
                    text: error.response.data.message,
                    showHideTransition: "slide",
                    icon: "error",
                    position: "bottom-right",
                  });
                });
            });
          }
          if (accountTypes == 2) {
            e.goLast();
          } else {
            e.goNext(), KTUtil.scrollTop();
          }
        }),
        s.on("kt.stepper.previous", function (e) {
          console.log("stepper.previous");
          e.goFirst();
          KTUtil.scrollTop();
        }),
        a.push(
          FormValidation.formValidation(o, {
            fields: {
              trainee_name: {
                validators: {
                  notEmpty: { message: "Account type is required" },
                },
              },
              trainee_email: {
                validators: {
                  notEmpty: { message: "Email is required" },
                  emailAddress: {
                    message: "The value is not a valid email",
                  },
                },
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
          })
        ),
        r.addEventListener("click", function (t) {
          t.preventDefault();
          var valid = a[0];
          valid.validate().then(function (i) {
            if ("Valid" === i) {
              axios
                .post("management/trainee/list?action=add", {
                  fullname: $('[name="trainee_name"]').val(),
                  email: $('[name="trainee_email"]').val(),
                  note: $('[name="trainee_note"]').val(),
                  classId: $('[name="ClasstraineeAdd"').val(),
                })
                .then(function (response) {
                  $.toast({
                    heading: "Success",
                    text: "Add trainee successfully",
                    showHideTransition: "slide",
                    icon: "success",
                    position: "bottom-right",
                  });
                  // TIMEOUT 2s
                  setTimeout(function () {
                    window.location.reload();
                  }, 2000);
                })
                .catch(function (error) {
                  console.log(error);
                  $.toast({
                    heading: "Error",
                    text: error.response.data.message,
                    showHideTransition: "slide",
                    icon: "error",
                    position: "bottom-right",
                  });
                });
            } else {
              Swal.fire({
                text: "Sorry, looks like there are some errors detected, please try again.",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, got it!",
                customClass: {
                  confirmButton: "btn fw-bold btn-primary",
                },
              });
            }
          });
        });
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTCreateAccount.init();
});
