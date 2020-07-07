package com.company;

import sun.java2d.pipe.SpanShapeRenderer;

import java.lang.reflect.Array;
import java.util.*;


public class MyHashMap {
    private static boolean ch(String s) {
        return s.charAt(s.length() - 1) == ',' || s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == ':';
    }
    private static boolean prov(char s){
        return (s>='A'&& s<='Z');
    }

    public static String isk(String Text) {
        Map<String, Integer> lol = new SimpleHashMap<>(10);
        Scanner sc = new Scanner(Text);
        String[] help2;
        String help;
        while (sc.hasNextLine()) {
            help = sc.nextLine();
            help2 = help.split(" ");
            String helpy;
            for (int i = 0; i < help2.length; i++) {
                if (ch(help2[i])) {
                    helpy = help2[i].substring(0, help2.length - 1);
                    for (int k = 0; k < helpy.length(); k++) {
                        if (prov(helpy.charAt(k))) {
                            if (k!=helpy.length()-1) {
                                continue;
                            }
                        } else {
                            break;
                        }
                        if (helpy.length() <= 5) {
                            if (!(lol.containsKey(helpy))) {
                                System.out.println();
                            } else {
                                lol.put(helpy, lol.get(helpy) + 1);
                            }
                        }
                    }
                }
                else {
                    for (int j = 0; j < help2[i].length(); j++) {
                        if (prov(help2[i].charAt(j))) {
                            if (j!=help2[i].length()-1) {
                                continue;
                            }
                        } else {
                            break;
                        }
                        if (help2[i].length() <= 5) {
                            if (!(lol.containsKey(help2[i]))) {
                                lol.put(help2[i], 1);
                            } else {
                                lol.put(help2[i], lol.get(help2[i]) + 1);
                            }
                        }
                    }
                }
            }
        }

        Set set = lol.entrySet();
        String isk = "";
        for (Map.Entry s: lol.entrySet()) {
            isk = isk + s.getKey() + " — " + s.getValue() + " times" + "\n";
        }
        return isk;
    }
}
