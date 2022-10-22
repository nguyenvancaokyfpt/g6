"use strict";
var KTUsersAddUser = function () {

    const t = document.getElementById("kt_content_container"),
            e = t.querySelector("#kt_modal_update_form"),
            n = new bootstrap.Modal(t);
    return {
        init: function () {
            (() => {
                var o = FormValidation.formValidation(e, {
                    fields: {
                        fromDate: {
                            validators: {
                                notEmpty: {
                                    message: "From Date is required"
                                }
                            }
                        },
                        toDate: {
                            validators: {
                                notEmpty: {
                                    message: "To Date is required"
                                }
                            }
                        },
                        title: {
                            validators: {
                                notEmpty: {
                                    message: "Title is required"
                                }
                            }
                        },
                        assBody: {
                            validators: {
                                notEmpty: {
                                    message: "Assignment Body is required"
                                }
                            }
                        },
                        description: {
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
                    e.preventDefault(), console.log("click"), o.validate().then((function (t) {
                        var status = document.getElementsByName("statusId");
                        console.log(status);
                        var statusValue="";
                          for (var i = 0; i < status.length; i++){
                    if (status[i].checked === true){
                        statusValue = status[i].value;
                    }
                }
                        "Valid" == t ? // Post to server
                                axios.post('/milestone/list?action=update', {
                                      milestoneId: document.getElementById("kt_modal_update_form").querySelector('[name="milestoneId"]').value,
                                    classId: document.getElementById("kt_modal_update_form").querySelector('[name="classId"]').value,
                                     subjectId: document.getElementById("kt_modal_update_form").querySelector('[name="subjectId"]').value,
                                    fromDate: document.getElementById("kt_modal_update_form").querySelector('[name="fromDate"]').value,
                                    toDate: document.getElementById("kt_modal_update_form").querySelector('[name="toDate"]').value,
                                    title: document.getElementById("kt_modal_update_form").querySelector('[name="title"]').value,
                                    assBody: document.getElementById("kt_modal_update_form").querySelector('[name="assBody"]').value,
                                    description: document.getElementById("kt_modal_update_form").querySelector('[name="description"]').value,
                                    statusId: statusValue,
                                }).then(function (response) {
                          window.location.href ='/milestone/list?action=list';
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