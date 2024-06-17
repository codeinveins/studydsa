package com.mixer.trees.problems1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacterFromString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = s.nextLine();

        Map<Character, Integer> freqMap = prepareFreqMap(str);
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println(entry.getKey() + " is the first non repeating character in " + str);
                break;
            }
        }
    }

    private static Map<Character, Integer> prepareFreqMap(String str) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        for(Character c : str.toCharArray()) {
            if(m.containsKey(c)) {
                m.put(c, m.get(c)+1);
            } else {
                m.put(c, 1);
            }
        }
        return m;
    }
}
