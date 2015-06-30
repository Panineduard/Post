package com.logistic.impl.transport;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.transport.DeliveryTransport.Type;
import com.logistic.api.service.SenderService;
import com.logistic.impl.post.PostOffice1;
import com.logistic.api.model.post.*;
import com.logistic.api.model.transport.Transit;
import com.logistic.impl.service.SenderService1;

import java.awt.*;
import java.util.List;
import java.util.*;

public class Transit1 implements Transit {
    private static List <PostOffice> list=new ArrayList<>();
    private static SenderService senderService =new SenderService1();
    private static List <Ways> WEYS =new ArrayList<>();
    private double prise=0;

    static {
        list = senderService.getAllOffices();
             //Возможные пути
    
        Ways ways2= new Ways(list.get(0),list.get(1));
        Ways ways3= new Ways(list.get(7),list.get(6));
        Ways ways4= new Ways(list.get(6),list.get(1));
        Ways ways5= new Ways(list.get(2),list.get(0));
        Ways ways6= new Ways(list.get(8),list.get(7));
        Ways ways7= new Ways(list.get(7),list.get(5));
        Ways ways8= new Ways(list.get(3),list.get(2));
        Ways ways9= new Ways(list.get(7),list.get(0));
        Ways ways10= new Ways(list.get(5),list.get(1));
        Ways ways11= new Ways(list.get(0),list.get(4));
        Ways ways12= new Ways(list.get(1),list.get(3));
        Ways ways13= new Ways(list.get(3),list.get(6));
        Ways ways14= new Ways(list.get(3),list.get(4));
        Ways ways15= new Ways(list.get(0),list.get(3));
        Ways ways16= new Ways(list.get(8),list.get(0));
        Ways ways17= new Ways(list.get(5),list.get(9));


//        for (int i=0;i<17;i++){ //Как использовать цикл
//            WEYS.add(postOffice1s+1)
//        }
        WEYS.add(ways2);WEYS.add(ways3);WEYS.add(ways4);
        WEYS.add(ways5);WEYS.add(ways6);WEYS.add(ways7);WEYS.add(ways8);
        WEYS.add(ways9);WEYS.add(ways10);WEYS.add(ways11);WEYS.add(ways12);
        WEYS.add(ways13);WEYS.add(ways14);WEYS.add(ways15);WEYS.add(ways16);
        WEYS.add(ways17);
}
public double Distans(List<Ways> ways,Type type){
    //Считаем стоимость в зависимости от коэфициента и пити
Transit1 transit1 = new Transit1();
    double kof = 0;
    kof=type.getCostPerMile();
    double distans1=0;
for (int i=0;i<ways.size()-1;i++) {
    distans1 += transit1.calculationOfDistances(ways.get(i).getStartOffice(), ways.get(i).getFinishOffice());
}
   this.prise=distans1*kof;
return distans1;
}

private double calculationOfDistances(PostOffice postOffice1,PostOffice postOffice2){
    double x1 = postOffice1.getGeolocation().getX();
    double x2 = postOffice2.getGeolocation().getX();
    double y1= postOffice1.getGeolocation().getY();
    double y2 = postOffice2.getGeolocation().getY();
    double distans22 = 0;
    distans22=Math.sqrt(Math.pow((x2 - x1), 2) +
            Math.pow((y2 - y1), 2));
    return distans22;
}
    @Override
    public List getTransitOffices() {
        return  WEYS;
    }

    @Override
    public double getPrice() {
        return prise;
    }
}
