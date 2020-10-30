async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

const setUrl = (url) => (window.location.href = url);
// setUrl("http://localhost:8080/p1/home.page")

async function addReimbursement() {
  const reimbursement = {
    amount: document.getElementById("reimbAmount").value,
    description: document.getElementById("reimbDescription").value,
    author: "e", //document.getElementById("reimbAuthor").value,
    receipt: document.getElementById("reimbReceipt").value,
    type: {
      type: document.getElementById("reimbType").value,
    },
  };
  const fetched = await fetch(
    `http://${location.host}/p1-0.0.1-SNAPSHOT/reqReimbursement.json`,
    {
      method: "post",
      body: JSON.stringify(reimbursement),
    }
  );
  //reimbursement should have been successfully created
  //notify user then redirect
}

document
  .getElementById("reimbSubmit")
  .addEventListener("click", addReimbursement);
