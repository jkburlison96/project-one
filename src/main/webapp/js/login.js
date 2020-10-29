async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

const setUrl = (url) => (window.location.href = url);

async function login() {
  try {
    const response = await fetch("http://localhost:8080/p1/userLogin.json", {
      method: "post",
      body: JSON.stringify({
        username: document.querySelector("#usernameIn").value,
        password: document.querySelector("#passwordIN").value,
      }),
    });
    const user = await response.json();
    if (response.ok) {
      console.log(user.userRole.userRole);
      sessionStorage.setItem("accessLevel", user.userRole.userRole);
      sessionStorage.setItem("isSession", "true");
      setUrl("http://localhost:8080/p1/home.page");
    }
  } catch (error) {
    setUrl("http://localhost:8080/p1/login.page");
  }
  //reimbursement should have been successfully created
  //notify user then redirect
}

document.getElementById("loginSubmit").onclick = function () {
  this.disabled=true;
  login();
};

