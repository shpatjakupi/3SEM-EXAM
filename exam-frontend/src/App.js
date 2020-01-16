import React, { useState, useEffect } from "react";
import "./App.css";
import facade from "./ApiFacade";
import LogIn from "./Components/LogIn";
import HomePage from "./Components/HomePage";
import AdminUserface from "./Components/AdminUserface";
import MovieAdministration from "./Components/MovieAdministration";

import {
  BrowserRouter as Router,
  Route,
  Switch,
  NavLink,
  Redirect
} from "react-router-dom";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  const [allMovies] = useState([{}]);
  const [deletedMovie] = useState({});

  const login = (user, pass) => {
    facade
      .login(user, pass)
      .then(res => setLoggedIn(true))
      .catch(err => console.log("wrong credentials"));
  };
  const logout = () => {
    facade.logout();
    setLoggedIn(false);
  };

  return (
    <div>
      <Router>
        <Header loggedIn={loggedIn} logout={logout} facade={facade} />
        <Switch>
          <Route exact path="/">
            <HomePage loggedIn={loggedIn} facade={facade} />
          </Route>
          <Route path="/login">
            {!loggedIn ? <LogIn login={login} /> : <Redirect to="/" />}
          </Route>

          <Route path="/admin">
            <AdminUserface />
            <Route path="/admin/movies">
              <MovieAdministration
                facade={facade}
                allMovies={allMovies}
                deletedMovie={deletedMovie}
              />
            </Route>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

const Header = props => {
  return (
    <ul className="menu">
      <li>
        <NavLink to="/" exact activeClassName="active">
          HomePage
        </NavLink>
      </li>
      {props.loggedIn && props.facade.getRole() === "admin" ? (
        <li>
          <NavLink to="/admin" activeClassName="active">
            Admin
          </NavLink>
        </li>
      ) : null}

      {props.loggedIn ? (
        <li>
          <NavLink to="/login" activeClassName="active" onClick={props.logout}>
            Logout
          </NavLink>
        </li>
      ) : (
        <li>
          <NavLink to="/login" activeClassName="active">
            Login
          </NavLink>
        </li>
      )}
    </ul>
  );
};

export default App;
