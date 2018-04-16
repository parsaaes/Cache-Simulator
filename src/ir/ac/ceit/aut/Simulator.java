package ir.ac.ceit.aut;

import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.FACache;
import ir.ac.ceit.aut.memory.VictimCache;
import ir.ac.ceit.aut.processor.CPU;

import java.util.ArrayList;

public class Simulator {
    private CPU cpu;
    private DirectMapCache mainCache;
    private FACache victimCache;

    public Simulator(int sizeBitCount, int blockSizeBitCount) {
        cpu = new CPU("inputs/in2.txt",500);
        mainCache = new DirectMapCache(sizeBitCount,blockSizeBitCount);
        victimCache = new FACache(8,blockSizeBitCount);
    }
    public void run(boolean useSpecialCache) {
        int miss = 0;
        String evictedWordData = "";
        ArrayList<String> input = cpu.getRequestedAddresses();
        if(useSpecialCache) {
            for (String s : input) {
                if (mainCache.requestWord(s) == false) {
                    if (victimCache.requestWord(s) == false) {
                        miss++;
                        //System.out.println("miss!");
                    } else {
                        //System.out.println("victim hit!");
                    }
                    //miss++;
                } else {
                    //System.out.println("hit!");
                }
            }
            System.out.println("special: " + useSpecialCache + " --> " + String.valueOf((1 - (miss / 500f))*100));
        }
        else {
            for (String s : input) {
                if (mainCache.requestWord(s) == false) {
                    miss++;
                } else {
                    //System.out.println("hit!");
                }
            }
            System.out.println("special: " + useSpecialCache + " --> " + String.valueOf((1 - (miss / 500f))*100));
        }
    }

}