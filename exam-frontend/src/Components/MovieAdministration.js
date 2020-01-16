import React, { useEffect } from "react";
import { Route } from "react-router-dom";
import Col from "react-bootstrap/Col";

const AdminMovies = props => {
  return (
    <Col style={{ flexDirection: "column" }} md="7">
      <div className="default-box">
        <div className="box-header">Movie administration</div>

        <Route exact path="/admin/movies/add">
          {" "}
          add a movie
        </Route>
      </div>
    </Col>
  );
};
export default AdminMovies;
