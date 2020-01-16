import React from "react";
import { NavLink } from "react-router-dom";

import Nav from "react-bootstrap/Nav";

const MovieUserface = props => {
  return (
    <div className="default-box">
      <div className="box-header">Movie Menu</div>
      <Nav className="flex-column">
        <Nav>
          <NavLink to="/admin/movies/add">Add Movie</NavLink>
        </Nav>
        <Nav>
          <NavLink to="/admin/movies/delete">Delete Movie</NavLink>
        </Nav>
      </Nav>
    </div>
  );
};
export default MovieUserface;
