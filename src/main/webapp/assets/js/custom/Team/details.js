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
    e.style.setProperty("display", "inline", "important");
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
  showToast();
});

function showToast() {
  try {
    var type = document.getElementById("toastStatus").value;
    if (type == "1") {
      toastr.success("Update Successfully");
    } else if (type == "2") {
      toastr.success("Added Successfully");
    }
  } catch (e) {}
}
