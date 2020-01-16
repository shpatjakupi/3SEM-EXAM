import React from "react";
import { Route, NavLink } from "react-router-dom";

import MovieMenu from "./HomePageForAdmin";

import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Nav from "react-bootstrap/Nav";

const AdminUserface = props => {
  return (
    <Col style={{ flexDirection: "column" }} md="3">
      <div className="default-box">
        <div className="box-header">Admin Menu</div>
        <Nav className="flex-column">
          <Nav>
            <NavLink to="/admin/movies">Movies</NavLink>
          </Nav>
        </Nav>
      </div>

      <Route path="/admin/movies">
        <MovieMenu />
      </Route>
    </Col>
  );
};
export default AdminUserface;
