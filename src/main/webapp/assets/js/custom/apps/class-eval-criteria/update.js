"use strict";
var KTUsersAddUser = function () {

    const t = document.getElementById("kt_content_container"),
            e = t.querySelector("#kt_modal_update_eval_form"),
            n = new bootstrap.Modal(t);
    return {
        init: function () {
            (() => {
                var o = FormValidation.formValidation(e, {
                     fields: {
                        criteria_name: {
                            validators: {
                                notEmpty: {
                                    message: "Criteria Name is required"
                                }
                            }
                        },
                        criteria_loc: {
                            validators: {
                                notEmpty: {
                                    message: "Max LOC is required"
                                }
                            }
                        },
                        criteria_weight: {
                            validators: {
                                notEmpty: {
                                    message: "Eval weight is required"
                                }
                            }
                        },
                        criteria_description: {
                            validators: {
                                stringLength: {
                                    max: 100,
                                    message: "Description has to be less than 100 characters"
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
                });
                const i = t.querySelector('[data-kt-users-modal-action="submit"]');
                i.addEventListener("click", (function (e) {
                    e.preventDefault(), console.log(e), o.validate().then((function (t) {
                        var status = document.getElementsByName("criteria_status");
                        console.log(t);
                        var statusValue="";
                          for (var i = 0; i < status.length; i++){
                    if (status[i].checked === true){
                        statusValue = status[i].value;
                    }
                }
                        "Valid" == t ? // Post to server
                                axios.post('/evalCriteria/classEvalCriteria/list?action=update', {
                                    criteria_id:document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_id"]').value,
                                    criteria_assign: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_assign"]').value,
                                    criteria_name: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_name"]').value,
                                    criteria_description: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_description"]').value,
                                    criteria_team: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_team"]').value,
                                    criteria_weight: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_weight"]').value,
                                    criteria_loc: document.getElementById("kt_modal_update_eval_form").querySelector('[name="criteria_loc"]').value,
                                    criteria_status: statusValue,
                                }).then(function (response) {
                          window.location.href ='/evalCriteria/classEvalCriteria/list?action=list';
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
            })()
        }
    }
}();

KTUtil.onDOMContentLoaded((function () {
    KTUsersAddUser.init()
}));