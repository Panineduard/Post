package com.logistic.impl.transport;

import com.logistic.api.model.post.PostOffice;
import com.logistic.impl.post.PostOffice1;

/**
 * Created by Эдуард on 21.06.15.
 */
public class Ways {
    @Override
    public String toString(){
        return startOffice.getAddress().getCity()+ " - "+finishOffice.getAddress().getCity()  ;
    }
    private PostOffice startOffice;
    private PostOffice finishOffice;
    public Ways(PostOffice postOffice1,PostOffice postOffice2){
        startOffice =postOffice1;
        finishOffice = postOffice2;
    }
    public PostOffice getStartOffice(){
        return startOffice;
    }
    public PostOffice getFinishOffice(){
        return finishOffice;
    }
}
