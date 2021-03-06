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
        //�������//person
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
        //������ ��� ����������
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
        //������ �������
//        He brought a parcel
        Package1 package1 = new Package1();
        //�� ��������� ����� �� ������ ��������� ����� 2 � ����� �������� � ��������� 4
//        At the post office department at the number 2 and wants to go to the Department of 4
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
// ������� �� ����� ��������� ���� � �� ��������� ������� ���� �� ���
// Display the possible ways and their cost Choose one
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
        //���������� ��������� � ��������� ����//Calculate the distance and the cost of the path
        Transit1 transit1 = new Transit1();

        System.out.println("The chosen route");
        System.out.println(n.get(ps));
        System.out.println((int) transit1.Distans(n.get(ps), DeliveryTransport.Type.AIR));
        System.out.println(transit1.getPrice());
        //������ �� ���������� �������//Now we will send the parcel
        senderService1.sendPackage1(package1, n.get(ps));
        //�������� ��� ���� ������� ������//We find out where our package today
        System.out.println("It is package in  " + senderService1.getPackageCurrentPosition("GAN").getAddress().getCity());

    }
}
