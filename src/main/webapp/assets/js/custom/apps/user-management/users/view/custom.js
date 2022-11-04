function showItem() {
  var hide = document.getElementsByClassName("itemHidden");
  var show = document.getElementsByClassName("itemShow");
  var inline = document.getElementsByClassName("itemHiddenInline");
  hide.forEach((e) => {
    e.style.setProperty("display", "block", "important");
  });
  inline.forEach((e) => {
    e.style.setProperty("display", "inline", "important");
  });
  show.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
}

function hideItem() {
  var show = document.getElementsByClassName("itemHidden");
  var hide = document.getElementsByClassName("itemShow");
  var inline = document.getElementsByClassName("itemHiddenInline");
  hide.forEach((e) => {
    e.style.setProperty("display", "block", "important");
  });
  inline.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
  show.forEach((e) => {
    e.style.setProperty("display", "none", "important");
  });
}

$(document).ready(function () {
  toastr.options = {
    closeButton: true,
    debug: false,
    newestOnTop: false,
    progressBar: false,
    positionClass: "toast-bottom-right",
    preventDuplicates: false,
    onclick: null,
    showDuration: "300",
    hideDuration: "1000",
    timeOut: "3000",
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut",
  };
});

const update = () => {
  let name = $("#userName").val();
  let role = $("#userRole").val();
  let email = $("#userEmail").val();
  let mobile = $("#userMobile").val();
  let note = $("#userNote").val();
  let id = $("#userId").val();
  let status = $("#userStatus").is(":checked") ? 1 : 0;

  console.log(note);

  if (name == "" || email == "" || mobile == "") {
    toastr.error("Please fill all the fields!");
    return;
  }
  //check mobile is number
  if (!phonenumber(mobile)) {
    toastr.error("Mobile number must be number!");
    return;
  }
  //check email is valid
  if (!validateEmail(email)) {
    toastr.error("Email is not valid!");
    return;
  }

  fetch(
    `/management/user/detail?action=update&userName=${name}&role=${role}&email=${email}&mobile=${mobile}&note=${note}&id=${id}&status=${status}`,
    {
      method: "POST",
    }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      if (data) {
        toastr.success("User updated successfully!");
      } else {
        toastr.error("User update failed!");
      }
    });
};

function phonenumber(inputtxt) {
  const regex = new RegExp(
    /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/
  );
  return regex.test(inputtxt);
}

const validateEmail = (email) => {
  const regex = new RegExp(
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
  return regex.test(email);
};
