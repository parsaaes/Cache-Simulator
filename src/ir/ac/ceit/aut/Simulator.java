package ir.ac.ceit.aut;

import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.VictimCache;
import ir.ac.ceit.aut.processor.CPU;

import java.util.ArrayList;

public class Simulator {
    private CPU cpu;
    private DirectMapCache mainCache;
    // private VictimCache victimCache;
    private int miss;

    public Simulator(int sizeBitCount, int blockSizeBitCount) {
        cpu = new CPU("inputs/in2.txt",500);
        mainCache = new DirectMapCache(sizeBitCount,blockSizeBitCount);
        // victimCache = new VictimCache(victimSize,blockSize);
        miss = 0;
    }
    public void run() {
        String evictedWordData = "";
        ArrayList<String> input = cpu.getRequestedAddresses();
        for (String s : input) {
           if (mainCache.requestWord(s) == false){
               miss++;
               System.out.println("miss!");
           }
           else {
               System.out.println("hit!");
           }
        }
        System.out.println(miss);
    }

}
