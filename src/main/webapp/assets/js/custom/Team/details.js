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

const updateTeam = (e) => {
    console.log( $('form').serializeArray());
    
    // e.preventDefault();
    // const form = e.target;
    // const data = new FormData(form);
    // const team = {
    //     team_id: data.get("name"),
    //     team_project: data.get("description"),
    //     team_topicName: data.get("id"),
    //     team_topicCode: data.get("id"),
    //     team_description: data.get("id"),
    //     team_status: data.get("id"),
    // };
    // fetch("/api/teams", {
    //     method: "PUT",
    //     headers: {
    //     "Content-Type": "application/json",
    //     },
    //     body: JSON.stringify(team),
    // })
    //     .then((res) => res.json())
    //     .then((res) => {
    //     if (res.status === "success") {
    //         window.location = "/teams";
    //     } else {
    //         alert("Error");
    //     }
    //     });
    console.log(team);
}