package com.example.homeworkt3;

import com.android.volley.toolbox.StringRequest;

public class Cats {
    public String breed;
    public String description;
    public int weight;
    public String temperament;
    public String origin;
    public int lifespan;
    public String wikipedia;
    public int dogfriendlinesslevel;

    public Cats(){

    }

    public Cats(String breed, String description, int weight, String temperament, String origin, int lifespan,
                String wikipedia, int dogfriendlinesslevel){
        this.breed = breed;
        this.description = description;
        this.weight = weight;
        this.temperament = temperament;
        this.origin = origin;
        this.lifespan = lifespan;
        this.wikipedia = wikipedia;
        this.dogfriendlinesslevel = dogfriendlinesslevel;
    }

    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed= breed;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description= description;
    }

    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight= weight;
    }

    public String getTemperament(){
        return temperament;
    }
    public void setTemperament(String temperament){
        this.temperament= temperament;
    }


    public String getOrigin(){
        return origin;
    }
    public void setOrigin(String origin){
        this.origin = origin;
    }

    public int getLifespan(){
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getDogfriendlinesslevel(){
        return dogfriendlinesslevel;
    }

    public void setDogfriendlinesslevel(int dogfriendlinesslevel) {
        this.dogfriendlinesslevel = dogfriendlinesslevel;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }
}
