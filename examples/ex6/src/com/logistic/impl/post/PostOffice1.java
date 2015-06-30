package com.logistic.impl.post;
import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.impl.person.AddressP;
import java.awt.*;

public class PostOffice1 implements PostOffice {
    private Stamp1 stamp = new Stamp1();
    private Address address =new AddressP();
    private int maxWeight = 0;
    private Package1 package1= new Package1();

    private Point geolocation = new Point(0,0);


    @Override
    public Stamp getStamp() {
        Stamp1 stamp1 = new Stamp1();
        stamp1.setPostOfficeAddress((AddressP)address);

        return stamp1;
    }
    public void setStamp(Address address){
        this.address=address;

    }


    @Override
    public Address getAddress() {
        return address;
    }
    public  void setAddress(AddressP address){this.address = address;}

    @Override
    public Package.Type getAcceptableTypes() {
        return package1.getType();
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }


    @Override
    public boolean sendPackage(Package parcel) {
       if(parcel != null) return true;
       else return false;
    }

    @Override
    public boolean receivePackage(Package parcel) {


        return false;
    }

    @Override
    public int getCode() {
        return address.getCode();
    }

    @Override
    public Point getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(int x,int y){
        Point point = new Point(x,y);
        geolocation=point;

    }
}
