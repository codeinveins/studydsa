package com.mixer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {

        double limit = 50000d;
        int totalRecordsToLoad = 452511;
        double totalNumberOfPages = totalRecordsToLoad / limit;
        int tot = totalRecordsToLoad / (int) limit;
        System.out.println(totalNumberOfPages);
        System.out.println(tot);

        int noOfPages = (int)Math.ceil(totalRecordsToLoad * 1.0 / 50000);
        System.out.println(noOfPages);

    }

    private void mapCheck() {
        Map<String, String> hm = new ConcurrentHashMap<>();
        String K = "120.49.192.112_SECURITY-SSHD-6-INFO_GENERAL";
        String V = "120.49.192.112_SECURITY-SSHD-6-INFO_GENERAL##SubAlarm@@_";
        long size = 0;
        for(int i=1; i<=4000000; i++) {
            size += K.length()+i;
            size += V.length()+i;
            hm.put(K+i,V+i);
        }

        System.out.println();
        long start = System.currentTimeMillis();
        StringBuffer response = new StringBuffer();
        int counter = 1;
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            response.append("KEY-VALUE-" + counter + " :: " + entry.getKey() + " ** " + entry.getValue() + System.getProperty("line.separator"));
            counter++;
            if(counter == 1000000) {
                break;
            }
        }



        System.out.println(response.toString());

        System.out.println("Map Filled: " + hm.size() + " -- " + size);
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end-start) +" ms.");
    }
}