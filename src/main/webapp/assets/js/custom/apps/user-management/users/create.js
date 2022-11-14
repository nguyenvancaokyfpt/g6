"use strict";
var KTCreateUser = (function () {
  var btn = document.querySelector("#kt_create_user_submit");
  var form = document.querySelector("#kt_create_user_form");
  var validator = FormValidation.formValidation(form, {
    fields: {
      user_name: {
        validators: {
          notEmpty: { message: "Fullname is required" },
        },
      },
      user_email: {
        validators: {
          notEmpty: { message: "Email is required" },
          emailAddress: {
            message: "The value is not a valid email",
          },
        },
      },
      user_mobile: {
        validators: {
          notEmpty: { message: "Phone is required" },
          digits: { message: "The value is not a valid phone number" },
          stringLength: {
            min: 10,
            max: 10,
            message: "The value must be 10 digits",
          },
        },
      },
      user_role: {
        validators: {
          notEmpty: { message: "Role is required" },
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
      btn.addEventListener("click", function (e) {
        e.preventDefault();
        validator.validate().then(function (status) {
          console.log(status);
          if (status == "Valid") {
            axios
              .post("http://localhost:8080/management/user?action=create", {
                fullname: $("[name=user_name]").val(),
                email: $("[name=user_email]").val(),
                mobile: $("[name=user_mobile]").val(),
                roleId: $("[name=user_role]").val(),
                statusId: $("[name=user_status]").val(),
                note: $("[name=user_note]").val(),
              })
              .then(function (response) {
                $.toast({
                  heading: "Success",
                  text: "User created successfully",
                  position: "top-right",
                  loaderBg: "#ff6849",
                  icon: "success",
                });
                setTimeout(function () {
                  window.location.href =
                    "http://localhost:8080/management/user";
                }, 2000);
              })
              .catch(function (error) {
                $.toast({
                  heading: "Error",
                  text: "User email already exists",
                  position: "top-right",
                  loaderBg: "#ff6849",
                  icon: "error",
                });
              });
          }
        });
      });
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTCreateUser.init();
});
