/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.Actor;
import entities.Director;
import entities.Genre;
import entities.Movie;
import DTO.MovieDTO;
import DTO.GenreDTO;
import DTO.ActorDTO;
import DTO.DirectorDTO;
import errorhandling.NotFoundException;
import java.util.List;

/**
 *
 * @author shpattt
 */
public interface IMovieFacade {
    public MovieDTO addMovie(Movie m);
    public MovieDTO deleteMovie(Long id) throws NotFoundException;
    public List<MovieDTO> getAllMovies() throws NotFoundException;
    public List<MovieDTO> getMovieByTitle(String title) throws NotFoundException;
 
}
