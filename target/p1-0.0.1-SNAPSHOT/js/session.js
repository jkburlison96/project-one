let session = sessionStorage.getItem("isSession");
const setUrl = (url) => (window.location.href = url);

async function checkSession() {
  if (session != "true") {
    setUrl(`http://${location.host}/p1-0.0.1-SNAPSHOT/login.page`);
  }
}

checkSession();
