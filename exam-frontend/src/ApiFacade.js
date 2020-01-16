const URL = "https://shpat.dk/3SEM-EXAM/";
function handleHttpErrors(res) {
  if (!res.ok) {
    return Promise.reject({ status: res.status, fullError: res.json() });
  }
  return res.json();
}

class ApiFacade {
  roles = [0];

  getRole = () => {
    let jwtToken = localStorage.getItem("jwtToken");
    if (jwtToken !== null) {
      let tokenData = jwtToken.split(".")[1];
      let decodedData = window.atob(tokenData);
      let dataJson = JSON.parse(decodedData);
      return dataJson.roles;
    }
    return "notloggedin";
  };

  setToken = token => {
    localStorage.setItem("jwtToken", token);
  };
  getToken = () => {
    return localStorage.getItem("jwtToken");
  };
  loggedIn = () => {
    const loggedIn = this.getToken() != null;
    return loggedIn;
  };
  logout = () => {
    localStorage.removeItem("jwtToken");
    this.roles = [0];
  };

  makeOptions(method, addToken, body) {
    var opts = {
      method: method,
      headers: {
        "Content-type": "application/json",
        Accept: "application/json"
      }
    };
    if (addToken && this.loggedIn()) {
      opts.headers["x-access-token"] = this.getToken();
    }
    if (body) {
      opts.body = JSON.stringify(body);
    }
    return opts;
  }

  fetchData = () => {
    const urlFetch = this.roles.includes("user")
      ? "/api/info/user"
      : "/api/info/admin";
    const options = this.makeOptions("GET", true); //True add's the token
    return fetch(URL + urlFetch, options).then(handleHttpErrors);
  };

  login = (user, pass) => {
    const options = this.makeOptions("POST", true, {
      username: user,
      password: pass
    });

    return fetch(URL + "login", options)
      .then(handleHttpErrors)
      .then(res => {
        this.setToken(res.token);
        this.roles = res.roles;
      });
  };

  addMovie = async movie => {
    const options = this.makeOptions("POST", true, movie);
    const res = await fetch(URL + "movie/addmovie", options);
    return handleHttpErrors(res);
  };

  deleteMovie = async id => {
    const options = this.makeOptions("GET", true); //True add's the token
    const res = await fetch(URL + `movie/deletemovie/${id}`, options);
    return handleHttpErrors(res);
  };

  fetchAllMovies = async () => {
    const options = this.makeOptions("GET", false); //True add's the token
    const res = await fetch(URL + `movie/all`, options);
    return handleHttpErrors(res);
  };

  fetchMovies = async search => {
    const options = this.makeOptions("GET", false); //True add's the token
    const res = await fetch(
      URL + `movie/${search.searchBy}/${search.query}`,
      options
    );
    return handleHttpErrors(res);
  };
}
const facade = new ApiFacade();
export default facade;
