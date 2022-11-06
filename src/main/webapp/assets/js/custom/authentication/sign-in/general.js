"use strict";
var KTSigninGeneral = (function () {
  var e, t, i;
  var captcha;
  return {
    init: function () {
      (e = document.querySelector("#kt_sign_in_form")),
        (t = document.querySelector("#kt_sign_in_submit")),
        (i = FormValidation.formValidation(e, {
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
            password: {
              validators: {
                notEmpty: {
                  message: "The password is required",
                },
                callback: {
                  message: "Please enter valid password",
                  callback: function (e) {
                    if (e.value.length > 0) return _validatePassword();
                  },
                },
              },
            },
            captcha: {
              validators: {
                notEmpty: {
                  message: "The capcha is required",
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
        })),
        t.addEventListener("click", function (n) {
          // get style of id captcha-form
          var captcha_form = document.querySelector("#captcha-form");
          console.log(captcha_form.style.display);
          if (captcha_form.style.display == "none") {
            e.querySelector('[name="captcha"]').value = "captcha";
          }
          n.preventDefault(),
            i.validate().then(function (i) {
              "Valid" == i
                ? (t.setAttribute("data-kt-indicator", "on"),
                  (t.disabled = !0),
                  setTimeout(function () {
                    t.removeAttribute("data-kt-indicator"),
                      (t.disabled = !1),
                      // Post to server
                      axios
                        .post("/login", {
                          email: e.querySelector('[name="email"]').value,
                          password: e.querySelector('[name="password"]').value,
                          captcha: e.querySelector('[name="captcha"]').value,
                        })
                        .then(function (response) {
                          // get redirect param from url
                          const urlParams = new URLSearchParams(
                            window.location.search
                          );
                          const redirect = urlParams.get("redirect");
                          if (redirect) {
                            window.location.href = redirect;
                          } else {
                            // Redirect to dashboard
                            window.location.href = "/dashboard";
                          }
                        })
                        .catch(function (error) {
                          // Show error message
                          $.toast({
                            heading: "Error",
                            text: error.response.data.message,
                            showHideTransition: "slide",
                            icon: "error",
                            position: "bottom-right",
                          });
                          // show captcha form
                          if (error.response.data.data == "captcha_required") {
                            captcha_form.style.display = "flex";
                            e.querySelector('[name="captcha"]').value = "";
                          }
                          // Reset captcha
                          if (captcha_form.style.display != "none") {
                            axios
                              .post("/captchaGenerator")
                              .then(function (response) {
                                document.getElementById("captcha").src =
                                  response.data.data;
                              })
                              .catch(function (error) {
                                // reload page
                                window.location.reload();
                              });
                          }
                        });
                  }, 1))
                : $.toast({
                    heading: "Error",
                    text: "Please check your input",
                    showHideTransition: "slide",
                    icon: "error",
                    position: "bottom-right",
                  });
            });
        });
    },
  };
})();
KTUtil.onDOMContentLoaded(function () {
  KTSigninGeneral.init();
});
