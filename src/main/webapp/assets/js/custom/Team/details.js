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