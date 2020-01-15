package entities;

import entities.Actor;
import entities.Director;
import entities.Genre;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T22:27:36")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile ListAttribute<Movie, Actor> actors;
    public static volatile SingularAttribute<Movie, Integer> year;
    public static volatile ListAttribute<Movie, Genre> genres;
    public static volatile ListAttribute<Movie, Director> directors;
    public static volatile SingularAttribute<Movie, Integer> votes;
    public static volatile SingularAttribute<Movie, Long> id;
    public static volatile SingularAttribute<Movie, String> title;

}