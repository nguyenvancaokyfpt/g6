const createIssue = () => {
    fetch(window.location.origin + `/issue/list?action=create`, {
      method: "POST",
      body: new FormData(document.getElementById("testForm")),
    })
      .then((response) => {
        if (response.status === 200) {
          toastr.success("Added Successfully!");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };