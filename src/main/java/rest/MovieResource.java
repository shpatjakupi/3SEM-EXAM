/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import errorhandling.NotFoundException;
import facades.IMovieFacade;
import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author shpattt
 */
@Path("movie")
public class MovieResource {
    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MovieResource
     */
    public MovieResource() {
    }

    /**
     * Retrieves representation of an instance of rest.MovieResource
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addmovie")
    public String addMovie(String jsonString) throws NotFoundException {
        Movie movie = GSON.fromJson(jsonString, Movie.class);
        return GSON.toJson(FACADE.addMovie(movie));
    }

    /**
     * PUT method for updating or creating an instance of MovieResource
     * @param content representation for the resource
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletemovie/{id}")
    public String deleteMovie(@PathParam("id") Long id) throws NotFoundException {
        return GSON.toJson(FACADE.deleteMovie(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAllMovies() throws NotFoundException {
        return GSON.toJson(FACADE.getAllMovies());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbytitle/{title}")
    public String getMovieByTitle(@PathParam("title") String title) throws NotFoundException {
        return GSON.toJson(FACADE.getMovieByTitle(title));
    }
}
