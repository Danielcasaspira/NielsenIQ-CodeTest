package org.nielsen;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(getMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println(getMissingLetters("A slow yellow fox crawls under the proactive dog"));
        System.out.println(getMissingLetters("Lions, and tigers, and bears, oh my!"));
        System.out.println(getMissingLetters("abcdefghijklmnopqrstuvwxyz"));
        System.out.println("------Problem N° 2 ----------");
        System.out.println(animate(2, "..R...."));
        System.out.println(animate(3, "RR..LRL"));
        System.out.println(animate(2, "LRLR.LRLR"));
        System.out.println(animate(10, "RLRLRLRLRL"));
        System.out.println(animate(1, "..."));
        System.out.println(animate(1, "LRRL.LR.LRR.R.LRRL."));
    }


    public static String getMissingLetters(String sentence){

        sentence = sentence.toLowerCase();

        boolean[] present = new boolean[26];

        for(char ch : sentence.toCharArray()){
             if(ch >= 'a' && ch <= 'z'){
                 present[ch - 'a'] = true;
             }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < present.length; i++){
            if(!present[i]){
                result.append((char)('a' + i));
            }
        }

        return result.toString();

    }

    public static List<String> animate(int speed, String init){
        List<String> result = new ArrayList<>();
        int length = init.length();
        char[] chamber = init.toCharArray();

        while(true){
            StringBuilder current = new StringBuilder();
            boolean hasParticles = false;

            for(int i = 0; i < length; i++){
                current.append('.');
            }
            for(int i = 0; i < length; i++){
                if (chamber[i] == 'R') {
                    int newPos = i + speed;
                    if(newPos < length) {
                        current.setCharAt(newPos, 'R');
                        hasParticles = true;
                    }

                } else if(chamber[i] == 'L'){
                    int newPos = i - speed;
                    if (newPos >= 0){
                        current.setCharAt(newPos, 'L');
                        hasParticles = true;
                    }
                }
            }

            result.add(current.toString().replaceAll("[LR]", "X"));

            if(!hasParticles){
                break;
            }

            chamber = current.toString().toCharArray();
        }

        return result;

    }

}