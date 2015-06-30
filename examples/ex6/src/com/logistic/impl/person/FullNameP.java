package com.logistic.impl.person;

import com.logistic.api.model.person.*;
/**
 * Created by Эдуард on 31.05.15.
 */
public class FullNameP  implements FullName {
    private String firstNaime = "Panin";
    private String naime ="Eduard";
    private String lastNaim = "Aleksandrovich";

    @Override
    public String toString(){
        return this.firstNaime+"  "+this.naime+"    "+this.lastNaim;
    }
    @Override
    public String getFirstName() {
        return firstNaime;
    }
    public void setFirstNaime(String firstNaime){
        this.firstNaime =firstNaime;
    }

    @Override
    public String getLastName() {
        return lastNaim;
    }
    public void setNaime(String naime){
        this.naime =naime;
    }

    @Override
    public String getMiddleName() {
        return naime;
    }
    public void setLastNaim(String lastNaim){
        this.lastNaim =lastNaim;
    }


}
