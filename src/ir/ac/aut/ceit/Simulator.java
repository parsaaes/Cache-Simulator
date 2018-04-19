package ir.ac.aut.ceit;

import ir.ac.aut.ceit.memory.FACache;
import ir.ac.aut.ceit.memory.DirectMapCache;
import ir.ac.aut.ceit.processor.CPU;

import java.util.ArrayList;

public class Simulator {
    private CPU cpu;
    private DirectMapCache mainCache;
    private FACache victimCache;

    public Simulator(int dmSizeBitCount, int victimSizeBitCount, int blockSizeBitCount, String instructions) {
        cpu = new CPU(instructions,500);
        mainCache = new DirectMapCache(dmSizeBitCount,blockSizeBitCount);
        victimCache = new FACache(victimSizeBitCount,blockSizeBitCount);
    }
    public void run(boolean useVictim) {
        int miss = 0;
        String evictedWordData = "";
        ArrayList<String> input = cpu.getRequestedAddresses();
        if(useVictim) {
            for (String s : input) {
                if (mainCache.requestWord(s) == false) {
                    if (victimCache.requestWord(s) == false) {

                        miss++;
                        mainCache.insertData(s);
                        victimCache.insertData(mainCache.getEvictedBlockFirstWord());

                        //System.out.println("dm miss! victim miss!");

                    } else {

                        mainCache.insertData(s);
                        victimCache.rePlaceData(mainCache.getEvictedBlockFirstWord(), mainCache.isEvictedBlockValid(),s);

                        //System.out.println("dm miss! victim hit!");

                    }
                }
                else {

                    //System.out.println("dm hit!");

                }
            }
            System.out.println("special: " + useVictim + " --> " + String.valueOf((1 - (miss / 500f))*100));
        }
        else {
            for (String s : input) {
                if (mainCache.requestWord(s) == false) {
                    miss++;
                    mainCache.insertData(s);
                }
                else {
                    //System.out.println("hit!");
                }
            }
            System.out.println("special: " + useVictim + " --> " + String.valueOf((1 - (miss / 500f))*100));
        }
    }

}