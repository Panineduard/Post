package com.logistic.impl.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.Stamp;
import com.logistic.api.model.transport.DeliveryTransport;
import com.logistic.impl.person.AddressP;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Эдуард on 04.06.15.
 */
public class Stamp1 implements Stamp {
    private Address postOfficeAddress = new AddressP();
    private Date date = new Date();
    @Override
    public String toString(){
        return getPostOfficeAddress().getCity()+"  "+date  ;}
    @Override
    public Address getPostOfficeAddress() {
        return postOfficeAddress;
    }
    public void setPostOfficeAddress(Address postOfficeAddress){
        this.postOfficeAddress = postOfficeAddress;
    }

    @Override
    public Date getStampDate() {
        return date;
    }
}
