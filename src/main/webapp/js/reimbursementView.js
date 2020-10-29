var filter = document.getElementById( "myInput" );

function renderTable(reimbursements) {
  //create table element
  //for each row append to table element
  document.getElementById('reimbTable').innerHTML='';
  for (let reimbursement of reimbursements) {
    const tr = document.createElement("tr");
    const att = document.createAttribute("class");
    att.value = "t_row";
    tr.setAttributeNode(att);
    const statusTD = document.createElement("td");
    const authorTD = document.createElement("td");
    const typeTD = document.createElement("td");
    const amountTD = document.createElement("td");
    const submittedTD = document.createElement("td");
    const resolvedTD = document.createElement("td");
    const resolverTD = document.createElement("td");
    statusTD.innerText = reimbursement.status.status;
    authorTD.innerText = reimbursement.author;
    typeTD.innerText = reimbursement.type.type;
    amountTD.innerText = "$" + reimbursement.amount;
    submittedTD.innerText = reimbursement.submitted;
    resolvedTD.innerText = reimbursement.resolved;
    resolverTD.innerText = reimbursement.resolver;
    tr.append(
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

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

function myFunction() {
  // Declare variables
  let input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value;
  table = document.getElementById("rTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
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

// Add active class to the current control button (highlight it)

document.getElementById("myInput").onchange = function() {myFunction();};
asyncFetch("http://localhost:8080/p1/allReimbursements.json", renderTable);