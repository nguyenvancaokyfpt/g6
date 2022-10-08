function showItem() {
    var hide = document.getElementsByClassName("itemHidden");
    var show = document.getElementsByClassName("itemShow");
    hide.forEach((e) => {
      e.style.setProperty('display', 'block', 'important');
    });
    show.forEach((e) => {
      e.style.setProperty('display', 'none', 'important');
    });
  }
  
  function hideItem() {
    var hide = document.getElementsByClassName("itemHidden");
    var show = document.getElementsByClassName("itemShow");
    hide.forEach((e) => {
      e.style.setProperty('display', 'none', 'important');
    });
    show.forEach((e) => {
      e.style.setProperty('display', 'block', 'important');
    });
  }