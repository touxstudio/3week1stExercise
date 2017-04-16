package org.coursera.apiRest.model;

import org.coursera.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by TouxStudio on 29/03/2017.
 */

public class PetResponse {

    ArrayList<Pets> myPets;

    public ArrayList<Pets> getMyPets() {
        return myPets;
    }

    public void setMyPets(ArrayList<Pets> myPets) {
        this.myPets = myPets;
    }



}
