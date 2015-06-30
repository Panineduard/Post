package com.logistic.api.service;

import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.Transit;
import com.logistic.impl.transport.Ways;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * Created by Denis on 5/25/2015.
 */
public interface SenderService {
    public List getAllOffices();
    public Transit[] calculatePossibleTransits(Package parcel, PostOffice senderOffice);
    public boolean sendPackage(Package parcel,  Ways wayses);
    public PostOffice getPackageCurrentPosition(String id);
    public double getMilesToDestination(String id);

}
