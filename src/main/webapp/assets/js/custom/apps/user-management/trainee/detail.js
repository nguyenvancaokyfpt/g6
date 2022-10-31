"use strict";
var KTTraineeDetail = (function () {
  var submitBtn = document.querySelector("#kt_modal_new_target_submit");
  var cancelBtn = document.querySelector("#kt_modal_new_target_cancel");
  var form = document.querySelector("#kt_modal_new_target_form");

  var t = FormValidation.formValidation(form, {
    fields: {
      email: {
        validators: {
          notEmpty: {
            message: "Email address is required",
          },
          emailAddress: {
            message: "The value is not a valid email address",
          },
        },
      },
      fullname: {
        validators: {
          notEmpty: {
            message: "Full name is required",
          },
        },
      },
      mobile: {
        validators: {
          notEmpty: {
            message: "Mobile is required",
          },
          digits: {
            message: "The value is not a valid number",
          },
          stringLength: {
            min: 10,
            max: 10,
            message: "The value must be 10 digits",
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
  });
  return {
    init: function () {
      $('[name="due_date"]').flatpickr({
        enableTime: !1,
        dateFormat: "Y-m-d",
        maxDate: new Date().fp_incr(1),
      });

      submitBtn.addEventListener("click", function (e) {
        e.preventDefault(),
          t.validate().then(function (e) {
            console.log("Valid? => ", e);
            const fullname = $('[name="fullname"]').val();
            const email = $('[name="email"]').val();
            const mobile = $('[name="mobile"]').val();
            const due_date = $('[name="due_date"]').val();
            const note = $('[name="note"]').val();
            const status = $('[name="status_id"]:checked').val();
            const id = $('[name="id"]').val();
            const classId = $('[name="classId"]').val();

            if (status == 2 && due_date == "") {
              $.toast({
                text: "Due date is required",
                showHideTransition: "slide",
                icon: "error",
                position: "bottom-right",
              });
              return;
            }

            console.log({
              fullname,
              email,
              mobile,
              due_date,
              note,
              status,
              id,
              classId,
            });
            axios
              .post("management/trainee/detail?action=update", {
                id: id,
                classId: classId,
                email: email,
                fullname: fullname,
                due_date: due_date,
                mobile: mobile,
                note: note,
                status: status,
              })
              .then(function (response) {
                console.log(response);
                $.toast({
                  text: response.data.message,
                  showHideTransition: "slide",
                  icon: "success",
                  position: "bottom-right",
                });
                setTimeout(function () {
                  // redirect to list
                  window.location.href = "management/trainee/list";
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
      });
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTTraineeDetail.init();
});
