/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author shpattt
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Movie.getAll", query = "SELECT new dto.MovieDTO(m) FROM Movie m"),
    @NamedQuery(name = "Movie.deleteAll", query = "DELETE FROM Movie m"),
    @NamedQuery(name = "Movie.getByTitle", query = "SELECT new dto.MovieDTO(m) FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.getByDirector", query = "SELECT new dto.MovieDTO(m) FROM Movie m WHERE m.directors = :director"),
    @NamedQuery(name = "Movie.getByActor", query = "SELECT new dto.MovieDTO(m) FROM Movie m WHERE m.actors = :actor"),
    @NamedQuery(name = "Movie.getByGenre", query = "SELECT new dto.MovieDTO(m) FROM Movie m WHERE m.genres = :genre")
})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private int year;
    private int votes;
 

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

   

//    @Override
//    public String toString() {
//        return "Movie{" + "id=" + id + ",\n title=" + title + ",\n year=" + year + ",\n votes=" + votes + ",\n directors=" + directors + ",\n actors=" + actors + ",\n genres=" + genres + '}';
//    }
}