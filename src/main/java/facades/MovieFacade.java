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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Director getDirectorById(long id) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            if (id == 0) {
                throw new NotFoundException("Person not found on the id: " + id);
                
            }
            return em.find(Director.class, id);
            
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public Genre getGenreById(long id) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            if (id == 0) {
                throw new NotFoundException("Genre not found on the id: " + id);
                
            }
            return em.find(Genre.class, id);
            
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public Actor getActorByName(long id) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            if (id == 0) {
                throw new PersonNotFoundException("Actor not found on the id: " + id);
                
            }
            return em.find(Actor.class, id);
            
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
     public MovieDTO addMovie(Movie m){
        EntityManager em = emf.createEntityManager();
        
       return null;
     }
             

}
