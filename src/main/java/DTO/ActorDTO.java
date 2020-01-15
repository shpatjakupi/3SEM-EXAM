package DTO;

import entities.Actor;




public class ActorDTO {
   private String name;
   private String about;
   

 
   public ActorDTO(Actor actor) {
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
        return "ActorDTO{" + "name=" + name + ", about=" + about + '}';
    }

 
    

   

}