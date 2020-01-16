import React, { useState } from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";

const UserInterface = props => {
  const facade = props.facade;
  const [search, setSearch] = useState({ query: "", searchBy: "" });
  const [searchResults, setSearchResults] = useState([
    { directors: [], actors: [], genres: [] }
  ]);
  const onChange = evt => {
    const target = evt.target;
    if (target.tagName === "SELECT") {
      search["searchBy"] = target.value;
      setSearch({ ...search });
      switch (target.value) {
        case "getbytitle":
          document.getElementById("searchInput").placeholder = "Type title";
          break;

        default:
          break;
      }
    } else if (target.tagName === "INPUT") {
      search["query"] = target.value;
      setSearch({ ...search });
    }
  };

  const onClick = evt => {
    evt.preventDefault();
    if (search.query === "" || search.searchBy === "") {
      document.getElementById("search-results").innerText =
        "You may not leave any fields empty.";
    } else {
      facade
        .fetchMovies(search)
        .then(res => setSearchResults([...res]))
        .catch(err => {
          console.log(err);
          setSearchResults([{ directors: [], actors: [], genres: [] }]);
        });
    }
  };

  return (
    <Container>
      <Row className="d-flex justify-content-center">
        <div className="box-header">Home</div>
        <div>
          <p>Search for movie title</p>
          <Form onChange={onChange}>
            <InputGroup className="mb-3">
              <Form.Control
                id="searchInput"
                placeholder="Enter movie name"
                aria-label="search-input"
              />
            </InputGroup>
            <button onClick={onClick}>Search for movie</button>
          </Form>
        </div>
        <div className="search-results-box" id="search-results">
          {searchResults[0].directors.length > 0 ? (
            <ul className="movie-list">
              {searchResults.map((movie, map1) => (
                <li key={map1} className="movie-box">
                  <div>
                    <label>Title:</label>
                    {movie.title}
                  </div>

                  <div>
                    <label>Directors:</label>
                    <ul>
                      {movie.directors.map((director, map2) => (
                        <li key={map2}> {director.name}</li>
                      ))}
                    </ul>
                  </div>

                  <div>
                    <label>Actors:</label>
                    <ul>
                      {movie.actors.map((actor, map3) => (
                        <li key={map3}> {actor.name}</li>
                      ))}
                    </ul>
                  </div>

                  <div>
                    <label>Genres:</label>
                    <ul>
                      {movie.genres.map((genre, map4) => (
                        <li key={map4}> {genre.name}</li>
                      ))}
                    </ul>
                  </div>
                </li>
              ))}
            </ul>
          ) : (
            <span>No results</span>
          )}
        </div>
      </Row>
    </Container>
  );
};

export default UserInterface;
