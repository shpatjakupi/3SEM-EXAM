package entities;

import entities.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-16T00:10:22")
@StaticMetamodel(Director.class)
public class Director_ { 

    public static volatile ListAttribute<Director, Movie> movies;
    public static volatile SingularAttribute<Director, String> name;
    public static volatile SingularAttribute<Director, String> about;
    public static volatile SingularAttribute<Director, Long> id;

}