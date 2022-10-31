const getSub = () => {
  let id = document.getElementById("subSelect").value;
  if (id == "") id = 0;
  fetch(
    window.location.origin +
      `/evalCriteria/evalCriteriaList?action=getSub&subId=${id}`,
    { method: "POST" }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      let assSelect = document.getElementById("assSelect");
      let ass = document.getElementById("assSelected").value;
      let content = ``;
      //   let content = `<option value="">--- Select Assignment ---</option>`;
      data.forEach((e) => {
        if (e.assId == ass) {
          content += `
              <option value="${e.assId}" selected>${e.title}</option>
          `;
        } else {
          content += `
          <option
           value="${e.assId}">${e.title}</option>
      `;
        }
      });
      assSelect.innerHTML = content;
    })
    .catch((error) => {
      document.getElementById(
        "assSelect"
      ).innerHTML = `<option value="" disabled selected>--- Empty ---</option>`;
    });
};

$(document).ready(function () {
  getSub();
});
