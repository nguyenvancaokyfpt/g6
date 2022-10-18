// handel  click to button id kt_account_profile_details_submit

$(document).ready(function () {
  $("#kt_account_profile_details_form").on("submit", function (e) {
    e.preventDefault();
    const form = $(e.target);
    const json = convertFormToJSON(form);
    axios
      .post("/setting/class/detail?action=update", json)
      .then(function (response) {
        window.location.href = "/setting/class";
      })
      .catch(function (error) {
        Swal.fire({
          text: error.response.data.message,
          icon: "error",
          buttonsStyling: !1,
          confirmButtonText: "Ok, got it!",
          customClass: {
            confirmButton: "btn btn-primary",
          },
        });
      });
  });
});

function convertFormToJSON(form) {
  return $(form)
    .serializeArray()
    .reduce(function (json, { name, value }) {
      json[name] = value;
      return json;
    }, {});
}
