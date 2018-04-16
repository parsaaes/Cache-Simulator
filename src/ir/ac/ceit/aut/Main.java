package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;
import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.FACache;
import ir.ac.ceit.aut.memory.Word;

public class Main {

    public static void main(String[] args) {
        AddressGenerator addressGenerator = new AddressGenerator();
        addressGenerator.generate("in2");
        Simulator simulator = new Simulator(12,4);
        simulator.run(false);
        simulator.run(true);
//
//        FACache faCache = new FACache(8,4);
//        System.out.println(faCache.i("00000000000000000000000000000000"));

//
//        FACache dm = new FACache(8,4);
//
//
//        for(int i = 0; i < 16; i++){
//            String w = "";
//            for(int j = 0; j < i; j++){
//                w += "0";
//            }
//            for(int k = 0; k < 32 - i; k++){
//                w+="1";
//            }
//            System.out.println(w + "-> " + w.length());
//            dm.requestWord(w);
//        }
//
//
//        for (int i = 0; i < dm.getWordArray().length; i++) {
//            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid() + ": " + dm.getUsage()[(int) (i / Math.pow(2,dm.getBlockSizeBitCount()))]);
//        }
//
//        System.out.println("requested->");
//        dm.requestWord("00000000001111111111111111111110");
//
//        for (int i = 0; i < dm.getWordArray().length; i++) {
//            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid() + ": " + dm.getUsage()[(int) (i / Math.pow(2,dm.getBlockSizeBitCount()))]);
//        }
//
//        System.out.println("requested->");
//        dm.requestWord("00000000001111111110011111111110");
//
//        for (int i = 0; i < dm.getWordArray().length; i++) {
//            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid() + ": " + dm.getUsage()[(int) (i / Math.pow(2,dm.getBlockSizeBitCount()))]);
//        }
//
//        System.out.println("requested->");
//        dm.requestWord("01100000001111111111111111111110");
//
//        for (int i = 0; i < dm.getWordArray().length; i++) {
//            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid() + ": " + dm.getUsage()[(int) (i / Math.pow(2,dm.getBlockSizeBitCount()))]);
//        }
//
//        System.out.println("requested->");
//        dm.requestWord("00000000001111111111111111111010");
//
//        for (int i = 0; i < dm.getWordArray().length; i++) {
//            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid() + ": " + dm.getUsage()[(int) (i / Math.pow(2,dm.getBlockSizeBitCount()))]);
//        }
    }
}
