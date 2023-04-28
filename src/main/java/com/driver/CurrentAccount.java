package com.driver;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CurrentAccount extends BankAccount{
    private static final double minBalance = 5000;
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,minBalance);
        if(balance<minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!tradeLicenseId.equals(tradeLicenseId.toUpperCase())  || !isValidTradeId()){
            throw new Exception("Valid License can not be generated");
        }
//        while(!isValidTradeId()){
//            char ch[]=tradeLicenseId.toCharArray();
//        }
        return;
    }
    private boolean isValidTradeId(){
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            char p=tradeLicenseId.charAt(i);
            hm.put(p,hm.getOrDefault(p,0)+1);
        }
        int checkLength;
        if(tradeLicenseId.length()%2==0){
            checkLength=((tradeLicenseId.length()+1)/2);
        }
        else{
            checkLength=((tradeLicenseId.length())/2);
        }
        if(int x: hm.values()){
            if(x>checkLength){return false;}
        }
        return true;
    }

}
