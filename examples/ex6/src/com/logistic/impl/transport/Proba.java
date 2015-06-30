package com.logistic.impl.transport;

import java.awt.*;

/**
 * Created by Эдуард on 06.06.15.
 */
public class Proba {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static enum Type {
        SINGLE_CHOICE, MULIT_CHOICE, TEXT
    }

}


//
//    public static void main (String[]args){
//        int numberOfWays=0;
//        Point point  = new Point(5,6);
//        Point point1 = new Point(8,34);
//        Point point2 = new Point(45,65);
//        Point point3 = new Point(34,54);
//        Point point4 = new Point(243,54);
//        Point point5 = new Point(234,545);
//        Point point6 = new Point(545,233);
//        Point point7 = new Point(34,343);
//        Point point8 = new Point(43,34);
//        Point point9 = new Point(56,34);
//        Point [] points;
//        points = new Point[10];
//        for (int i=points.length-1;i>=0;i-- ){
//            int []a;
//            a= new int[points.length];
//            a[i]=i;
//            numberOfWays += a[i];
//        }
//        points[0] = point;
//        points[1] = point1;
//        points[2] = point2;
//        points[3] = point3;
//        points[4] = point4;
//        points[5] = point5;
//        points[6] = point6;
//        points[7] = point7;
//        points[8] = point8;
//        points[9] = point9;
//        Point point10 = new Point();
//        double [] ways;
//        ways = new double[numberOfWays];
//        int g = points.length-1;
//        for (int j =0;j<numberOfWays;g--) {
//            for (int i=g;i>0;i-- ,j++) {
//                ways[j] = Math.sqrt(Math.pow((points[g].x - points[i-1].x), 2) +
//                        Math.pow((points[g].y - points[i-1].y), 2));
//                //System.out.println(ways[j]);
//            }
//        }
//double arrayways[] [];
//        int t=0;
//        int k=0;
//        arrayways = new double[points.length-1][points.length];
//      for (int j =0;j<=points.length-1;j++,t++) {
//          for (int i = t; i <= points.length - 2; i++,k++) {
//              arrayways[t][i]=ways[k];
//              System.out.print(arrayways[j][i]+ "\t");
//          }
//          System.out.println();
//      }
//    }
//}
