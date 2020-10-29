let session = sessionStorage.getItem("isSession");
const setUrl = (url) => (window.location.href = url);

async function checkSession() {
  if (session != "true") {
    setUrl("http://localhost:8080/p1/login.page");
  }
}

checkSession();
