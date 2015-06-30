package com.logistic.impl.service;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.SenderService;
import com.logistic.api.service.Storage;
import com.logistic.impl.person.AddressP;
import com.logistic.impl.post.Package1;
import com.logistic.impl.post.PostOffice1;
import com.logistic.impl.post.Stamp1;
import com.logistic.impl.transport.Transit1;
import com.logistic.impl.transport.Ways;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Этот класс содержит массив возможных оффисов, массив сообщений путей
 * Created by Эдуард on 09.06.15.
 */
public class SenderService1 implements SenderService {
    private static List<PostOffice> POST_OFFICES = new ArrayList<>();

    static {
        PostOffice1 postOffice1 = new PostOffice1();
        PostOffice1 postOffice2 = new PostOffice1();
        PostOffice1 postOffice3 = new PostOffice1();
        PostOffice1 postOffice4 = new PostOffice1();
        PostOffice1 postOffice5 = new PostOffice1();
        PostOffice1 postOffice6 = new PostOffice1();
        PostOffice1 postOffice7 = new PostOffice1();
        PostOffice1 postOffice8 = new PostOffice1();
        PostOffice1 postOffice9 = new PostOffice1();
        PostOffice1 postOffice10 = new PostOffice1();

        //1 почтовое отделение

        AddressP addressP1 = new AddressP();
        postOffice1.setGeolocation(35, 50);
        addressP1.setCode(2);
        addressP1.setCity("Khmelnickiy");
        addressP1.setStreet("50 Let SSSR 6 ");
        postOffice1.setStamp(addressP1);
        postOffice1.setAddress(addressP1);

        //2 почтовое отделение
        AddressP addressP2 = new AddressP();
        postOffice2.setGeolocation(50, 64);
        addressP2.setCode(3);
        addressP2.setCity("Kiev");
        addressP2.setStreet("Kalachevskaya 13 ");
        postOffice2.setStamp(addressP2);
        postOffice2.setAddress(addressP2);

        //3 почтовое отделение
        AddressP addressP3 = new AddressP();
        postOffice3.setGeolocation(10, 57);
        addressP3.setCode(4);
        addressP3.setCity("Lviv");
        addressP3.setStreet("Kulpaekovskaya 93a");
        postOffice3.setStamp(addressP3);
        postOffice3.setAddress(addressP3);
        postOffice3.setGeolocation(10, 57);

        //4 почтовое отделение
        AddressP addressP4 = new AddressP();
        postOffice4.setGeolocation(45, 15);
        addressP4.setCode(69);
        addressP4.setCity("Odessa");
        addressP4.setStreet("Chernahovskogo 4 ");
        postOffice4.setStamp(addressP4);
        postOffice4.setAddress(addressP4);

        //5 почтовое отделение
        AddressP addressP5 = new AddressP();
        postOffice5.setGeolocation(87, 40);
        addressP5.setCode(57);
        addressP5.setCity("Dnepropetrovsk");
        addressP5.setStreet("Titova 36 ");
        postOffice5.setStamp(addressP5);
        postOffice5.setAddress(addressP5);

        //6 почтовое отделение
        AddressP addressP6 = new AddressP();
        postOffice6.setGeolocation(94, 54);
        addressP6.setCode(30);
        addressP6.setCity("Kharkov");
        addressP6.setStreet("Moskovskiy avenu 259 ");
        postOffice6.setStamp(addressP6);
        postOffice6.setAddress(addressP6);

        //7 почтовое отделение
        AddressP addressP7 = new AddressP();
        postOffice7.setGeolocation(85, 20);
        addressP7.setCode(32);
        addressP7.setCity("Zaporozie");
        addressP7.setStreet("Zadneprovskaya 9 ");
        postOffice7.setStamp(addressP7);
        postOffice7.setAddress(addressP7);
        //8 почтовое отделение
        AddressP addressP8 = new AddressP();
        postOffice8.setGeolocation(3445, 5055);
        addressP8.setCode(32);
        addressP8.setCity("Sumu");
        addressP8.setStreet("Lebedinskaya 2 ");
        postOffice8.setStamp(addressP8);
        postOffice8.setAddress(addressP8);
        //9 почтовое отделение
        AddressP addressP9 = new AddressP();
        postOffice9.setGeolocation(90, 65);
        addressP9.setCode(44);
        addressP9.setCity("Rovno");
        addressP9.setStreet("Fabrichnaya 1 ");
        postOffice9.setStamp(addressP9);
        postOffice9.setAddress(addressP9);
        //10 почтовое отделение
        AddressP addressP10 = new AddressP();
        postOffice10.setGeolocation(25, 70);
        addressP10.setCode(87);
        addressP10.setCity("Luck");
        addressP10.setStreet("Karpatska 49 ");
        postOffice10.setStamp(addressP10);
        postOffice10.setAddress(addressP10);


        POST_OFFICES.add(postOffice1);
        POST_OFFICES.add(postOffice2);
        POST_OFFICES.add(postOffice3);
        POST_OFFICES.add(postOffice4);
        POST_OFFICES.add(postOffice5);
        POST_OFFICES.add(postOffice6);
        POST_OFFICES.add(postOffice7);
        POST_OFFICES.add(postOffice8);
        POST_OFFICES.add(postOffice9);
        POST_OFFICES.add(postOffice10);

    }// Статический блок инициализаци


    @Override
    public List getAllOffices() {
        return POST_OFFICES;
    }

    @Override
    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice) {
        return new Transit[0];
    }

    //Получаем посылку которую нужно передать, меняем в посылке адрес
    public void sendPackage1(Package parcel, List<Ways> waysList) {
        SenderService1 senderService11 = new SenderService1();
        for (Ways wey : waysList) {
            System.out.println(wey.getStartOffice().getAddress().getCity());
            boolean hasBeenSent = senderService11.sendPackage(parcel, wey);
            if (hasBeenSent) {
                System.out.println(parcel.getStamp().getPostOfficeAddress().getCity());
                System.out.println(parcel.getStamp().getStampDate());
            } else {
                break;
            }
        }
    }

    @Override
    public boolean sendPackage(Package parcel, Ways wayses) {
        Storage.getInstance().putToStorage(parcel.getPackageId(), parcel);
        //Если штамп посылке соответсвует адресу получателя то слать дальше не надо
        if ((Address) parcel.getStamp().getPostOfficeAddress() == (Address) parcel.getReceiverAddress()) {
            System.out.println(parcel.getStamp().getPostOfficeAddress().getCity());
//            System.out.println(parcel.getStamp().getStampDate());

            return false;
        }
        //если штамп не соответствует то
        else {

            //Если штамп посылки равен штампу первого адреса пути то поменять на второй
            if ((Address) parcel.getStamp().getPostOfficeAddress() == (Address) wayses.getFinishOffice().getStamp().getPostOfficeAddress()) {
                Stamp1 stamp = new Stamp1();
                stamp.setPostOfficeAddress(wayses.getStartOffice().getAddress());
                parcel.setStamp(stamp);
                return true;

            }
            if ((Address) parcel.getStamp().getPostOfficeAddress() == (Address) wayses.getStartOffice().getStamp().getPostOfficeAddress()) {
                Stamp1 stamp = new Stamp1();
                stamp.setPostOfficeAddress(wayses.getFinishOffice().getAddress());
                parcel.setStamp(stamp);
                return true;
            }
            return true;
        }
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        //((Package1)Storage.getInstance().getById(id)).getStamp().getPostOfficeAddress();
        Package1 package1 = (Package1)Storage.getInstance().getById(id);
        PostOffice postOffice1 = new PostOffice1();
        String fg;
        fg = package1.getPackageId();
        Address addressP = new AddressP();
        System.out.println(fg);
        System.out.println(package1);
//        if(fg==id) {
//            System.out.println(fg);
//            addressP = package1.getStamp().getPostOfficeAddress();
//            for (PostOffice p : POST_OFFICES) {
//                if (p.getAddress() == addressP) {
//                    postOffice1 = p;
//                }
//            }
//            return postOffice1;
//        }
//        if(package1.getPackageId()!=id){System.out.println("You enter incorrect Id!!! ");
//        return null;}

        return POST_OFFICES.get(3);


    }

    @Override
    public double getMilesToDestination(String id) {
        return 0;
    }
}
