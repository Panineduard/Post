package com.logistic.impl.transport;

import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.DeliveryTransport;
import com.logistic.api.service.SenderService;
import com.logistic.impl.post.Package1;
import com.logistic.impl.post.PostOffice1;
import com.logistic.impl.service.SenderService1;

import java.util.*;

/**
 * Created by Эдуард on 05.06.15.
 */
public class DeliveryTransport1 implements DeliveryTransport {
    Type type;
    private PostOffice destinationPostOffice = new PostOffice1();
    private PostOffice startPostOffice = new PostOffice1();

    @Override
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public PostOffice getStartPostOffice() {
        return startPostOffice;
    }

    @Override
    public PostOffice getDestinationPostOffice() {
        return destinationPostOffice;
    }

    private List<Ways> possible_waysHelp(PostOffice office1, Ways distance_traveled) {//Возвращает список возможных путей с одной точки
        List<Ways> possibleWayFromThisOffice = new ArrayList<>();
        Transit1 transit1 = new Transit1();
        List<Ways> d;
        d = transit1.getTransitOffices();
        for (Ways wey : d) {
            if (wey != distance_traveled) {
                if (wey.getStartOffice() == office1 || wey.getFinishOffice() == office1) {
                    possibleWayFromThisOffice.add(wey);
                }
            }
        }
        return possibleWayFromThisOffice;
    }

    public TreeMap possibleWays(Package1 package1, int variants) {
        Random random = new Random();
        SenderService1 senderService1 = new SenderService1();
        DeliveryTransport1 deliveryTransport1 = new DeliveryTransport1();

        List<PostOffice1> list;
        list = senderService1.getAllOffices();
        PostOffice1 postOffice1;
        //По посылке выясняем от куда и куда
        for (int i = 0; i <= list.size() - 1; i++) {
            postOffice1 = list.get(i);
            if (package1.getReceiverAddress() == postOffice1.getAddress()) {
                this.destinationPostOffice = postOffice1;
            }
            if (package1.getSenderAddress() == postOffice1.getAddress()) {
                this.startPostOffice = postOffice1;
            }
        }
        System.out.println(startPostOffice.getAddress().getCity());
        System.out.println(destinationPostOffice.getAddress().getCity());
        PostOffice startOf = startPostOffice;
        List<Ways> possibl = deliveryTransport1.possible_waysHelp(startPostOffice, null);

        PostOffice nextPoint = new PostOffice1();
        List<Ways> r = new ArrayList<>();
        TreeMap<Integer, List<Ways>> puty = new TreeMap<>();
        for (int i = 0; i <= variants - 1; ) {
            for (int j = 1; j <= 5; j++) {
                Ways we = possibl.get(random.nextInt(possibl.size()));

                r.add(we);
                for (Ways equal : r) {
                    if (equal == we) break;
                }
                if (we.getFinishOffice() == startOf) {
                    nextPoint = we.getStartOffice();
                }
                if (we.getStartOffice() == startOf) {
                    nextPoint = we.getFinishOffice();
                }
                if (nextPoint == destinationPostOffice) {
                    if (r.size() > 1) {
                        puty.put(i, new ArrayList(r));
                        i++;
                        break;
                    } else break;
                }
                if (nextPoint == startPostOffice) break;
                possibl = deliveryTransport1.possible_waysHelp(nextPoint, we);
                startOf = nextPoint;
            }
            r.clear();
            startOf = startPostOffice;
            possibl = deliveryTransport1.possible_waysHelp(startPostOffice, null);
        }
        return puty;
    }
}

