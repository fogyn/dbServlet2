package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
    private int idCountry;
    private String nameCountry;
    private String capital;
    private int people;
    private List<City> listCity = new ArrayList<>();

    public Country() {
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public List<City> getListCity() {
        return this.listCity;
    }

    public void setListCity(List<City> listCity) {
        this.listCity = listCity;
    }

    public void addListCity(City city){
        this.listCity.add(city);
    }
}
