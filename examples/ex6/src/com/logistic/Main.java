package com.logistic;


import com.logistic.api.model.person.Address;
import com.logistic.api.model.transport.DeliveryTransport;
import com.logistic.impl.person.*;
import com.logistic.impl.person.AddressP;
import com.logistic.impl.post.Package1;
import com.logistic.impl.post.PostOffice1;
import com.logistic.impl.post.Stamp1;
import com.logistic.impl.service.SenderService1;
import com.logistic.impl.transport.DeliveryTransport1;
import com.logistic.impl.transport.Transit1;
import com.logistic.impl.transport.Ways;

import java.util.*;


/**
 * Created by Denis on 5/25/2015.
 */

public class Main {


    public static void main(String[] args) {
        //Человек
        Person1 person1 = new Person1();
        FullNameP fullNameP = new FullNameP();
        fullNameP.setNaime("Eduard");
        fullNameP.setFirstNaime("Panin");
        fullNameP.setLastNaim("Aleksandrovich");
        AddressP addressP = new AddressP();
        addressP.setStreet("Klochkovskaya");
        addressP.setCity("Kharkov");
        addressP.setCode(6764);
        person1.setFullNameP(fullNameP);
        person1.setAddressP(addressP);
        //Данные про получателя
        Person1 person2 = new Person1();
        FullNameP fullNameP2 = new FullNameP();
        fullNameP2.setNaime("Nechaev");
        fullNameP2.setFirstNaime("Sergey");
        fullNameP2.setLastNaim("Anatolievich");
        AddressP addressP1 = new AddressP();
        addressP.setStreet("Molodegnaya5");
        addressP.setCity("Lviv");
        addressP.setCode(5643);
        person1.setFullNameP(fullNameP2);
        person1.setAddressP(addressP1);
        //Принес посылку

        Package1 package1 = new Package1();
        //На отделение почты по адресу отделения номер 2 и хочет отправит в отделение 4
        Stamp1 stamp1 = new Stamp1();
        Address addressPost;
        Address addressPost2;
        List<PostOffice1> list = new ArrayList<>();
        SenderService1 senderService1 = new SenderService1();
        list = senderService1.getAllOffices();
        addressPost = list.get(1).getAddress();
        addressPost2 = list.get(5).getAddress();
        package1.setWeight(56);
        package1.setPackageId("GAN");
        package1.setSenderAddress(addressPost);
        package1.setReceiverAddress(addressPost2);
        package1.setSenderFullName(fullNameP);
        package1.setReceiverFullName(fullNameP2);
        stamp1.setPostOfficeAddress(addressPost);
        package1.setStamp(stamp1);
//       Вывести на экран возможные пути и их стоимость Выбрать один из них
        Scanner scanner = new Scanner(System.in);
        DeliveryTransport1 deliveryTransport1 = new DeliveryTransport1();
        TreeMap<Integer, List<Ways>> n = new TreeMap<>();
        System.out.println("Enter the number of options");
        int options = 9;
        if (scanner.hasNextInt()) {
            options = scanner.nextInt();
        } else System.out.println("Incorrect number of retry");
        n = deliveryTransport1.possibleWays(package1, options);
        System.out.println(n);
        int ps = 1;
        System.out.println("Enter the way of the above");
        if (scanner.hasNextInt()) {
            ps = scanner.nextInt();
        }
        //Подсчитать растояние и стоимость пути
        Transit1 transit1 = new Transit1();

        System.out.println("The chosen route");
        System.out.println(n.get(ps));
        System.out.println((int) transit1.Distans(n.get(ps), DeliveryTransport.Type.AIR));
        System.out.println(transit1.getPrice());
        //Теперь мы отправляем посылку9
        senderService1.sendPackage1(package1, n.get(ps));
        //Выясняем где наша посылка сейчас

        System.out.println(senderService1.getPackageCurrentPosition("GAN").getAddress().getCity());


//      SenderService1 senderService1 =new  SenderService1();
//       Transit1 transit1 = new  Transit1();
//List<PostOffice1> list = new ArrayList<>();
//       list=senderService1.getAllOffices();
//       transit1.calculationOfDistances(list.get(1), list.get(2));
//       System.out.println(transit1.calculationOfDistances(list.get(1), list.get(2)));
//       Proba proba = new Proba();
//       Proba.Type type =  proba.getType();
//       type = Proba.Type.TEXT;
//       System.out.println(type);
//
//       Package1 package1 =new Package1();
//       Package1.Type type1 = package1.getType();
//       System.out.println(Package.Type.T_10.getDescription());
//       System.out.println(Package.Type.T_10.getMaxWeight());
//
//       SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:s:Ms");
//
//       DeliveryTransport1 deliveryTransport1 = new DeliveryTransport1();


        //Storage.getInstance().putToStorage("1", "Bla");
        // Storage.getInstance().putToStorage("2", new Integer(45));
        //Integer i = Storage.getInstance().<Integer>getById("2");
        // String s = Storage.getInstance().<String>getById("1");
        //i = Storage.getInstance().<Integer>getById("1");// don't do like this!!!! You should know about the type inside!!!
        // System.out.println(Storage.getInstance().<Integer>getById("1"));// But you can do this here java doesn't do a cast to a variable
    }
}
