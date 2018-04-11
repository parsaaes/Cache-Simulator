package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;
import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.Word;

public class Main {

    public static void main(String[] args) {
        AddressGenerator addressGenerator = new AddressGenerator();


        DirectMapCache dm = new DirectMapCache(12,4);


        //Example :
        String address = "00111011110100100101111111001001";
        String n_c = (address.substring(0, address.length() - dm.getSizeBitCount()));
        String c_b = address.substring(address.length() - dm.getSizeBitCount(),address.length()-dm.getBlockSizeBitCount());
        String b = address.substring(address.length() - dm.getBlockSizeBitCount());
        System.out.println(b + " -> " + b.length());
        System.out.println(c_b + " -> " + c_b.length());
        System.out.println(n_c + " -> " + n_c.length());




        dm.requestWord(AddressGenerator.toBinString((long) (Math.pow(2,6)-1)));

        for (int i = 0; i < dm.getWordArray().length; i++) {
            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid());
        }

        dm.requestWord(AddressGenerator.toBinString((long) (Math.pow(2,22)-8)));

        for (int i = 0; i < dm.getWordArray().length; i++) {
            System.out.println(i + "- " + dm.getWordArray()[i].getData() + " "+ dm.getWordArray()[i].isValid());
        }

        dm.requestWord(AddressGenerator.toBinString((long) (Math.pow(2,22)-12)));
        dm.requestWord(AddressGenerator.toBinString((long) (Math.pow(2,32)-8)));

    }
}
