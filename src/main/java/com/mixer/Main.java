package com.mixer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static String deriveClausesFromCriteria(String criteria) {
        StringBuilder whereClauseBuilder = new StringBuilder();
        StringBuilder limitClauseBuilder = new StringBuilder();
        StringBuilder orderClauseBuilder = new StringBuilder();

        boolean isWhere = false;
        boolean isLimit = false;
        boolean isOrder = false;
        boolean breakLoop = false;
        int counter = 0;

        StringTokenizer strToken = new StringTokenizer(criteria);
        while (strToken.hasMoreTokens()) {
            String temp = strToken.nextToken();

            //check first token and assign respective bool to true
            if(counter == 0) {
                if(temp.equals("order")) {
                    isOrder = true;
                } else if(temp.equals("limit")) {
                    isLimit = true;
                } else if(temp.equals("where")) {
                    isWhere = true;
                }
                if(isOrder || isLimit || isWhere) {
                    counter ++;
                }
            }

            if(isWhere) {
                while(!temp.equals("order") && !temp.equals("limit")) {
                    whereClauseBuilder.append(" " + temp);
                    if(strToken.hasMoreTokens()) {
                        temp = strToken.nextToken();
                    } else {
                        breakLoop = true;
                        break;
                    }
                }
                if(breakLoop) {
                    break;
                }
                //modify bools and initalize next stringbuilder
                if(temp.equals("order")) {
                    orderClauseBuilder.append(temp);
                    isOrder = true;
                    isLimit = false;
                    isWhere = false;
                } else if(temp.equals("limit")) {
                    limitClauseBuilder.append(temp);
                    isOrder = false;
                    isLimit = true;
                    isWhere = false;
                }
            } else if(isLimit) {
                while(!temp.equals("order") && !temp.equals("where")) {
                    limitClauseBuilder.append(" " + temp);
                    if(strToken.hasMoreTokens()) {
                        temp = strToken.nextToken();
                    } else {
                        breakLoop = true;
                        break;
                    }
                }
                if(breakLoop) {
                    break;
                }
                //modify bools and initalize next stringbuilder
                if(temp.equals("order")) {
                    orderClauseBuilder.append(temp);
                    isOrder = true;
                    isLimit = false;
                    isWhere = false;
                } else if(temp.equals("where")) {
                    whereClauseBuilder.append(temp);
                    isOrder = false;
                    isLimit = false;
                    isWhere = true;
                }
            } else if(isOrder) {
                while(!temp.equals("limit") && !temp.equals("where")) {
                    orderClauseBuilder.append(" " + temp);
                    if(strToken.hasMoreTokens()) {
                        temp = strToken.nextToken();
                    } else {
                        breakLoop = true;
                        break;
                    }
                }
                if(breakLoop) {
                    break;
                }
                //modify bools and initalize next stringbuilder
                if(temp.equals("limit")) {
                    limitClauseBuilder.append(temp);
                    isOrder = false;
                    isLimit = true;
                    isWhere = false;
                } else if(temp.equals("where")) {
                    whereClauseBuilder.append(temp);
                    isOrder = false;
                    isLimit = false;
                    isWhere = true;
                }
            }

        }

        return whereClauseBuilder.toString().trim() + "&&&"
                + limitClauseBuilder.toString().trim() + "&&&"
                + orderClauseBuilder.toString().trim();
    }

    private static String assign(String input, String output) {
        return input+1 + "&&&" + output+2;
    }

   /* public static void main(String[] args) {
        List<String> l = List.of("WIRED");
        String s = String.join(",", l);
        System.out.println(s);
    }

    */

    private static Date getDate(long time) {
        LocalDateTime ld = Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentdate = LocalDateTime.now();
        if((currentdate.getYear()- ld.getYear()) < 2) {
            return new Date(time);
        }else {
            return new Date(time *1000);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Date(1692856259l));
        System.out.println(getDate(1692856259l));
        System.out.println(getDate(1692856259915l));
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