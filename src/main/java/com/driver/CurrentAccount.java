package com.driver;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CurrentAccount extends BankAccount {
    private static final double minBalance = 5000;
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, minBalance);
        if (balance < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = tradeLicenseId.length();
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1))
                break;
            else {
                if (tradeLicenseId.charAt(i) != tradeLicenseId.charAt(i + 1))
                    temp++;
            }
        }
        if (temp == n - 1)
            return;
        int freq[] = new int[26];
        for (int i = 0; i < n; i++)
            freq[tradeLicenseId.charAt(i) - 'A']++;
        int max = 0, letter = 0;
        for (int i = 0; i < 26; i++) {
            if (max < freq[i]) {
                max = freq[i];
                letter = i;
            }
        }
        if (max > (n + 1) / 2)
            throw new Exception("Valid License can not be generated");
        char ch[] = new char[n];

        // For Even position filling
        for (int i = 0; i < n; i += 2) {
            if (freq[letter] > 0) {
                ch[i] = (char) (letter + 'A');
                freq[letter]--;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (freq[j] > 0) {
                        letter = j;
                        break;
                    }
                }
                ch[i] = (char) (letter + 'A');
                freq[letter]--;
            }
        }

        // For Odd position filling
        for (int i = 1; i < n; i += 2) {
            if (freq[letter] > 0) {
                ch[i] = (char) (letter + 'A');
                freq[letter]--;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (freq[j] > 0) {
                        letter = j;
                        break;
                    }
                }
                ch[i] = (char) (letter + 'A');
                freq[letter]--;
            }
        }
        tradeLicenseId = String.valueOf(ch);
        return;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
    //    private boolean isValidTradeId(){
//        HashMap<Character,Integer> hm=new HashMap<>();
//        for(int i=0;i<tradeLicenseId.length()-1;i++){
//            char p=tradeLicenseId.charAt(i);
//            hm.put(p,hm.getOrDefault(p,0)+1);
//        }
//        int checkLength;
//        if(tradeLicenseId.length()%2==0){
//            checkLength=((tradeLicenseId.length()+1)/2);
//        }
//        else{
//            checkLength=((tradeLicenseId.length())/2);
//        }
//        int x;
//        if(x: hm.values()){
//            if(x>checkLength){return false;}
//        }
//        return true;
//    }
}