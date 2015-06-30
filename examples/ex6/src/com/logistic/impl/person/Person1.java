package com.logistic.impl.person;

/**
 * Created by Эдуард on 31.05.15.
 */
import com.logistic.api.model.person.*;

public class Person1  implements Person {

  AddressP addressP = new AddressP();
  FullNameP fullNameP = new FullNameP() ;
    @Override
    public String toString(){
        return addressP+"  "+"\n"+fullNameP;
    }
    @Override
    public Address getAddress() {
        return addressP ;
    }
    public void setAddressP (AddressP addressP){
        this.addressP =addressP;
    }

    @Override
    public FullName getFullName() {
        return fullNameP;
    }
    public void setFullNameP(FullNameP fullNameP){
        this.fullNameP =fullNameP;
    }
}
