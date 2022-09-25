"use strict";
var KTAccountSettingsProfileDetails = function () {
    var e, t;
    return {
        init: function () {
            e = document.getElementById("kt_account_profile_details_form"), e.querySelector("#kt_account_profile_details_submit"), t = FormValidation.formValidation(e, {
                fields: {
                    fullName: {
                        validators: {
                            notEmpty: {
                                message: "First name is required"
                            }
                        }
                    },
                    mobile: {
                        validators: {
                            notEmpty: {
                                message: "Last name is required"
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: "Company name is required"
                            },
                            emailAddress: {
                                message: "The value is not a valid email address"
                            }
                        }
                    }
                },
                plugins: {
                    trigger: new FormValidation.plugins.Trigger,
                    submitButton: new FormValidation.plugins.SubmitButton,
                    bootstrap: new FormValidation.plugins.Bootstrap5({
                        rowSelector: ".fv-row",
                        eleInvalidClass: "",
                        eleValidClass: ""
                    })
                }
            }), e.querySelector("#kt_account_profile_details_submit").addEventListener("click", (function (e) {
                e.preventDefault(), console.log("click"), t.validate().then((function (t) {
                    "Valid" == t ? // Post to server
                        axios.post('profile?action=update', {
                            email: document.getElementById("kt_account_profile_details_form").querySelector('[name="email"]').value,
                            fullName: document.getElementById("kt_account_profile_details_form").querySelector('[name="fullName"]').value,
                            mobile: document.getElementById("kt_account_profile_details_form").querySelector('[name="mobile"]').value,
                        }).then(function (response) {
                            Swal.fire({
                                text: "Your profile has been updated!",
                                icon: "success",
                                buttonsStyling: !1,
                                confirmButtonText: "Ok, got it!",
                                customClass: {
                                    confirmButton: "btn btn-primary"
                                }
                            })
                        }).catch(function (error) {
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
                        }) : swal.fire({
                            text: "Sorry, looks like there are some errors detected, please try again.",
                            icon: "error",
                            buttonsStyling: !1,
                            confirmButtonText: "Ok, got it!",
                            customClass: {
                                confirmButton: "btn font-weight-bold btn-light-primary"
                            }
                        })
                }))
            }))
        }
    }
}();
KTUtil.onDOMContentLoaded((function () {
    KTAccountSettingsProfileDetails.init()
}));