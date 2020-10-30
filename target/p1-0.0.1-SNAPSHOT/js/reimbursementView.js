var filter = document.getElementById("myInput");

function renderTable(reimbursements) {
  //create table element
  //for each row append to table element
  document.getElementById("reimbTable").innerHTML = "";
  for (let reimbursement of reimbursements) {
    const tr = document.createElement("tr");
    const att = document.createAttribute("class");
    att.value = "t_row";
    tr.setAttributeNode(att);
    const idTD = document.createElement("td");
    const statusTD = document.createElement("td");
    const authorTD = document.createElement("td");
    const typeTD = document.createElement("td");
    const amountTD = document.createElement("td");
    const submittedTD = document.createElement("td");
    const resolvedTD = document.createElement("td");
    const resolverTD = document.createElement("td");
    idTD.innerText = reimbursement.id;
    statusTD.innerText = reimbursement.status.status;
    authorTD.innerText = reimbursement.author;
    typeTD.innerText = reimbursement.type.type;
    amountTD.innerText = "$" + reimbursement.amount;
    submittedTD.innerText = reimbursement.submitted;
    resolvedTD.innerText = reimbursement.resolved;
    resolverTD.innerText = reimbursement.resolver;
    tr.append(
      idTD,
      statusTD,
      authorTD,
      typeTD,
      amountTD,
      submittedTD,
      resolvedTD,
      resolverTD
    );
    document.getElementById("reimbTable").append(tr);
  }
}

function addFinMngrFunctionality() {
  if (sessionStorage.getItem("accessLevel") === "fin mngr") {
    toggleAccess();
    // const reimbIdIn = document.createElement("input");
    // const textTypeAtt = document.createAttribute("type");
    // const textIdAtt = document.createAttribute("id");
    // const textPlaceholderAtt = document.createAttribute("placeholder");
    // textTypeAtt.value = "text";
    // textIdAtt.value = "reimbIdIn";
    // textPlaceholderAtt.value = "Enter id of reimbursement";
    // reimbIdIn.setAttribute(textTypeAtt);
    // reimbIdIn.setAttribute(textIdAtt);
    // reimbIdIn.setAttribute(textPlaceholderAtt);
    // const buttonDeny = document.createElement("button");
    // const denyIdAtt = document.createAttribute("id");
    // denyIdAtt.value = "denyID";
    // buttonDeny.innerText = "Deny";
    // const buttonAccept = document.createElement("button");
    // buttonAccept.innerText = "Accept";
    // document.getElementById("reimbViewControls").append(reimbIdIn, buttonDeny, buttonAccept);
  }
}

function toggleAccess() {
  var x = document.getElementById("extraControls");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

function filterTable() {
  // Declare variables
  let input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value;
  table = document.getElementById("rTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.innerText;
      if (txtValue.indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

async function updateStatus(s) {
  const statusUpdate = {
    id: document.getElementById("idIN").value,
    status: s,
  };
  const fetched = await fetch(
    `http://${location.host}/p1-0.0.1-SNAPSHOT/updateStatusReimbursements.json`,
    {
      method: "post",
      body: JSON.stringify(statusUpdate),
    }
  );
}

addFinMngrFunctionality();
document.getElementById("denyID").onclick = function () {
  updateStatus("denied");
  asyncFetch(`http://${location.host}/p1-0.0.1-SNAPSHOT/allReimbursements.json`, renderTable);
};

document.getElementById("acceptID").onclick = function () {
  updateStatus("approved");
  asyncFetch(`http://${location.host}/p1-0.0.1-SNAPSHOT/allReimbursements.json`, renderTable);
};

document.getElementById("myInput").onchange = function () {
  filterTable();
};
asyncFetch(`http://${location.host}/p1-0.0.1-SNAPSHOT/allReimbursements.json`, renderTable);
