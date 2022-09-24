"use strict";
var KTPasswordResetGeneral = function () {
    var t, e, i;
    return {
        init: function () {
            t = document.querySelector("#kt_password_reset_form"), e = document.querySelector("#kt_password_reset_submit"), i = FormValidation.formValidation(t, {
                fields: {
                    email: {
                        validators: {
                            notEmpty: {
                                message: "Email address is required"
                            },
                            emailAddress: {
                                message: "The value is not a valid email address"
                            }
                        }
                    },
                    "captcha": {
                        validators: {
                            notEmpty: {
                                message: "The capcha is required"
                            }
                        }
                    }
                },
                plugins: {
                    trigger: new FormValidation.plugins.Trigger,
                    bootstrap: new FormValidation.plugins.Bootstrap5({
                        rowSelector: ".fv-row",
                        eleInvalidClass: "",
                        eleValidClass: ""
                    })
                }
            }), e.addEventListener("click", (function (o) {
                o.preventDefault(), i.validate().then((function (i) {
                    "Valid" == i ? (e.setAttribute("data-kt-indicator", "on"), e.disabled = !0, setTimeout((function () {
                        e.removeAttribute("data-kt-indicator"), e.disabled = !1,
                            // show loading
                            Swal.fire({
                                title: 'Please wait...',
                                icon: 'info',
                                onBeforeOpen() {
                                    Swal.showLoading()
                                },
                                onAfterClose() {
                                    Swal.hideLoading()
                                },
                                allowOutsideClick: false,
                                allowEscapeKey: false,
                                allowEnterKey: false,
                                showConfirmButton: false,

                            });
                        // Post to server
                        axios.post('/resetPassword', {
                            email: t.querySelector('[name="email"]').value,
                            captcha: t.querySelector('[name="captcha"]').value
                        }).then(function (response) {
                            Swal.fire({
                                text: response.data.message,
                                icon: "success",
                                buttonsStyling: !1,
                                confirmButtonText: "Ok, got it!",
                                customClass: {
                                    confirmButton: "btn btn-primary"
                                }
                            });
                        }).catch(function (error) {
                            console.log(error);
                            // Show error message
                            Swal.fire({
                                text: error.response.data.message,
                                icon: "error",
                                buttonsStyling: !1,
                                confirmButtonText: "Ok, got it!",
                                customClass: {
                                    confirmButton: "btn btn-primary"
                                }
                            });
                            // Reset captcha
                            axios.post('/captchaGenerator').then(function (response) {
                                document.getElementById('captcha').src = response.data.data;
                            }).catch(function (error) {
                                // reload page
                                window.location.reload();
                            });
                        })
                    }), 1)) : Swal.fire({
                        text: "Sorry, looks like there are some errors detected, please try again.",
                        icon: "error",
                        buttonsStyling: !1,
                        confirmButtonText: "Ok, got it!",
                        customClass: {
                            confirmButton: "btn btn-primary"
                        }
                    })
                }))
            }))
        }
    }
}();
KTUtil.onDOMContentLoaded((function () {
    KTPasswordResetGeneral.init()
}));