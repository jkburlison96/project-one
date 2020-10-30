async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

const setUrl = (url) => (window.location.href = url);

async function login() {
  let u = document.forms['loginF'].elements["usernameIn"];
  let p = document.forms['loginF'].elements["passwordIn"];

  try {
    const response = await fetch(`http://${location.host}/p1-0.0.1-SNAPSHOT/userLogin.json`, {
      method: "post",
      body: JSON.stringify({
        // username: document.querySelector("#usernameIn").value,
        username: u.value,
        // password: document.querySelector("#passwordIN").value,
        password: p.value,
      }),
    });
    const user = await response.json();
    if (response.ok) {
      console.log(user.userRole.userRole);
      sessionStorage.setItem("accessLevel", user.userRole.userRole);
      sessionStorage.setItem("isSession", "true");
      setUrl(`http://${location.host}/p1-0.0.1-SNAPSHOT/home.page`);
    }
  } catch (error) {
    setUrl(`http://${location.host}/p1-0.0.1-SNAPSHOT/login.page`);
  }
  //reimbursement should have been successfully created
  //notify user then redirect
}

document.getElementById("loginSubmit").onclick = function () {
  login();
};
