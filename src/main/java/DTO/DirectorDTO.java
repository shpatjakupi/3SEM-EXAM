package DTO;

import entities.Director;




public class DirectorDTO {
   private String name;
   private String about;
   

 
   public DirectorDTO(Director actor) {
       this.name = actor.getName();
       this.about = actor.getAbout();
     
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "DirectorDTO{" + "name=" + name + ", about=" + about + '}';
    }

 
    

   

}