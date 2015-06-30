package com.logistic.impl.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.Stamp;
import com.logistic.impl.person.AddressP;
import com.logistic.impl.person.FullNameP;

/**
 * Created by Эдуард on 31.05.15.
 */

public class Package1 implements Package {
    private Stamp stamp1;
    private String packageId;
    private double weight;
    private Type type;
    private Address receiverAddress = new AddressP();
    private Address senderAddress = new AddressP();
    private FullNameP senderFullName = new FullNameP();
    private FullNameP receiverFullName = new FullNameP();
    public Stamp getStamp(){return stamp1;}
    public void setStamp(Stamp stamp1){
        this.stamp1 = stamp1;
    }

    @Override
    public String getPackageId() {
        return packageId;
    }
    public  void setPackageId(String packageId){
    this.packageId =packageId;
}
    @Override
    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight){this.weight=weight;}

    @Override
    public Type getType() {
        if(weight <=Type.T_27.getMaxWeight()){return Type.T_27;}
        if(weight <=Type.T_10.getMaxWeight()&&weight>Type.T_27.getMaxWeight()){return Type.T_10;}
        if(weight <=Type.T_25.getMaxWeight()&&weight>Type.T_10.getMaxWeight()){return Type.T_25;}
        if(weight <=Type.T_30.getMaxWeight()&&weight>Type.T_25.getMaxWeight()){return Type.T_30;}
        if(weight <=Type.T_CP.getMaxWeight()&&weight>Type.T_30.getMaxWeight()){return Type.T_CP;}
        else  return null;
    }
    @Override
    public Address getReceiverAddress() {
        return receiverAddress;
    }
    public void setReceiverAddress(Address address){receiverAddress=address;}

    @Override
    public Address getSenderAddress() {
        return senderAddress;
    }
    public void setSenderAddress(Address address){senderAddress = address;}
    @Override
    public FullName getSenderFullName() {
        return senderFullName;
    }
    public void setSenderFullName(FullNameP fullName){senderFullName = fullName;}
    @Override
    public FullName getReceiverFullName() {
        return receiverFullName;
    }
    public void setReceiverFullName(FullNameP fullName){receiverFullName= fullName;}
}
