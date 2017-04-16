package org.coursera.pojo;

/**
 * Created by TouxStudio on 07/03/2017.
 */

public class Pets {
    private String id;
    private String name;
    private String pic;
    private int rate;


    public Pets(){}

    public Pets (String name, String pic, int rate){

        this.name = name;
        this.pic = pic;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
