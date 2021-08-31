/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vipin.leetcode;

import java.util.*;

/**
 *
 * @author Vipin
 */
public class LetterCombinations {
    public static void main(String[] args) {
        letterCombinations("23");
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0) return result;
        
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            
            List<String> characters = getLettersForDigit(digit);
            List<String> temp = new ArrayList<>();
            
            for (String character : characters) {
                for (String str : result) {
                    temp.add(str+character);
                }    
            }
            
            result = temp;
        }
        
        return result;
    }
    
    private static List<String> getLettersForDigit(char digit) {
        switch (digit) {
            case '2':
                return Arrays.asList("a","b","c");
            case '3':
                return Arrays.asList("d","e","f");
            case '4':
                return Arrays.asList("g","h","i");
            case '5':
                return Arrays.asList("j","k","l");
            case '6':
                return Arrays.asList("m","n","o");
            case '7':
                return Arrays.asList("p","q","r","s");
            case '8':
                return Arrays.asList("t","u","v");
            case '9':
                return Arrays.asList("w","x","y","z");
                
            default:
                return new ArrayList<String>();
        }
    }
}


