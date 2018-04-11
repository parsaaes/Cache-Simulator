package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;
import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.Word;

public class Main {

    public static void main(String[] args) {
        AddressGenerator addressGenerator = new AddressGenerator();
//        addressGenerator.generate("test1");
//        CPU cpu = new CPU(System.getProperty("user.dir") + "/inputs/test1.txt",500);
//        for (String s : cpu.getRequestedAddresses()) {
//            System.out.println(s);
//        }

        DirectMapCache dm = new DirectMapCache(12,4);
        String address = "00111011110100100101111111001001";
        System.out.println(addressGenerator.toLong(address));
        System.out.println(address);
        String n_c = (address.substring(0, address.length() - dm.getSizeBitCount()));
        String c_b = address.substring(address.length() - dm.getSizeBitCount(),address.length()-dm.getBlockSizeBitCount());
        String b = address.substring(address.length() - dm.getBlockSizeBitCount());
        System.out.println(dm.parseDmAddress(address)[0] + dm.parseDmAddress(address)[1] + dm.parseDmAddress(address)[2]);
        System.out.println(b + " -> " + b.length());
        System.out.println(c_b + " -> " + c_b.length());
        System.out.println(n_c + " -> " + n_c.length());
        System.out.println(addressGenerator.toBinString(addressGenerator.toLong(n_c)) + " -> " + n_c.length());
//        int i = 0;
//        for (Word word : dm.getWordArray()) {
//            System.out.println(AddressGenerator.toBinString(i) + "--" + word.getData());
//            i++;
//        }
        dm.containsAddress("00000000000000000000000000000001");

    }
}
