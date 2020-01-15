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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

    public Director getDirectorById(long id) throws NotFoundException {
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
    
    public Genre getGenreById(long id) throws NotFoundException {
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
    
    public Actor getActorById(long id) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            if (id == 0) {
                throw new NotFoundException("Actor not found on the id: " + id);
                
            }
            return em.find(Actor.class, id);
            
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
     public MovieDTO addMovie(Movie m) throws NotFoundException{
        EntityManager em = emf.createEntityManager();
        
        Director director;
        Actor actor;
        Genre genre;
        
        List<Director> Directors = new ArrayList<>();
        List<Actor> Actors = new ArrayList<>();
        List<Genre> Genres = new ArrayList<>();
        
        try{
            em.getTransaction().begin();
            em.persist(m);
            
            for(Director d : m.getDirectors()){
                director = getDirectorById(d.getId());
                if(director == null){
                    em.persist(d);
                }else{
                    Directors.add(director);
                }
            }
            
            for(Actor a : m.getActors()){
                actor = getActorById(a.getId());
                if(actor == null){
                    em.persist(a);
                    System.out.println(a);
                }else{
                    Actors.add(actor);
                }
            }
            
            for(Genre g : m.getGenres()){
                genre = getGenreById(g.getId());
                if(genre == null){
                    em.persist(g);
                }else{
                    Genres.add(genre);
                }
            }
        
            
            em.getTransaction().commit();
            return new MovieDTO(m);
        }finally{
            em.close();
        }
      
     }
             
     public List<MovieDTO> getMovieByTitle(String title) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<MovieDTO> tq = em.createNamedQuery("Movie.getByTitle", MovieDTO.class).setParameter("title", title);
            List<MovieDTO> movies = tq.getResultList();
            if(movies.size() < 1) throw new NotFoundException("No movies named " + title + " exists in the database.");
            return movies;
        } finally {
            em.close();
        }
    }
     
   
    public MovieDTO deleteMovie(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try{
            Movie m = em.find(Movie.class, id);
            if(m == null) throw new NotFoundException("Movie with id " + id + " doesnt exist.");
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
            return new MovieDTO(m);
        }finally{
            em.close();
        }
    }

}
