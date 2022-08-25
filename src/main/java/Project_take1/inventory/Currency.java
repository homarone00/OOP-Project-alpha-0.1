package Project_take1.inventory;

import com.google.protobuf.BoolValueOrBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Currency {
    static final int COPPER = 0;
    static final int SILVER = 1;
    static final int ELECTRUM = 2;
    static final int GOLD = 3;
    static final int PLATINUM = 4;
    static Boolean copper = true;
    static Boolean silver = true;
    static Boolean electrum = true;
    static Boolean gold = true;
    static Boolean platinum = true;
    static ArrayList<Integer> conversion = new ArrayList<>(Arrays.asList(1,10,50,100,1000));

    public static void setCurrency(int METAL, Boolean use){
        if(METAL == COPPER) {
            copper = use;
        }
        if(METAL == SILVER) {
            silver = use;
        }
        if(METAL == ELECTRUM) {
            electrum = use;
        }
        if(METAL == GOLD) {
            gold = use;
        }
        if(METAL == PLATINUM) {
            platinum = use;
        }
        else{
            throw new IllegalArgumentException("Metal must be >= COPPER && <= PLATINUM");
        }
    }
    public static Boolean getCurrency(int METAL){
        if(METAL == COPPER) {
            return copper;
        }
        if(METAL == SILVER) {
            return silver;
        }
        if(METAL == ELECTRUM) {
            return electrum;
        }
        if(METAL == GOLD) {
            return gold;
        }
        if(METAL == PLATINUM) {
            return platinum;
        }
        else{
            throw new IllegalArgumentException("Metal must be >= COPPER && <= PLATINUM");
        }
    }
    public static void changeConversion(int METAL, int value){
        if(METAL < COPPER || METAL > PLATINUM){
            throw new IllegalArgumentException("Metal must be >= COPPER && <= PLATINUM");
        }
        conversion.set(METAL, value);
    }
    public int convert(int IN, int OUT, int value){
        if(IN < COPPER || IN > PLATINUM || OUT < COPPER || OUT > PLATINUM){
            throw new IllegalArgumentException("IN || OUT must be >= COPPER && <= PLATINUM");
        }
        value *= conversion.get(IN);
        return  value/conversion.get(OUT);
    }
    public static int getConversion(int METAL){
        if(METAL < COPPER || METAL > PLATINUM){
            throw new IllegalArgumentException("Metal must be >= COPPER && <= PLATINUM");
        }
        return conversion.get(METAL);
    }
}
