function showItem(){
    var hide = document.getElementsByClassName("itemHidden");
    var show = document.getElementsByClassName("itemShow");
    hide.forEach(e => {
       e.style.display = "block"
    });
    show.forEach(e => {
        e.style.display = "none"
    });
}

function hideItem(){
    var hide = document.getElementsByClassName("itemHidden");
    var show = document.getElementsByClassName("itemShow");
    hide.forEach(e => {
       e.style.display = "none"
    });
    show.forEach(e => {
        e.style.display = "block"
    });
}

alert(document.getElementById("userID").value);