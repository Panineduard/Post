package com.logistic.impl.person;

import com.logistic.api.model.person.*;

/**
 * Created by Эдуард on 31.05.15.
 */
public class  AddressP  implements Address {
    private String street = "Mejlayka";
    private String city = "Kharkov";
    private String contry = "Ukraine";
    private int code = 23;
    private String setCity;

    @Override
    public String toString(){
        return contry+"  "+city+"    "+street+ "   "+code;
    }
    @Override
    public String getStreet() {
        return street;
    }
    public void setStreet(String street){
        this.street =street;
    }
    @Override
    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city =city;
    }
    @Override
    public String getCountry() {
        return contry;
    }


    @Override
    public int getCode() {
        return code;
    }
    public void setCode(int code){
        this.code =code;
    }
}
