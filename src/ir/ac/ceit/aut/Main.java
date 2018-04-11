package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;
import ir.ac.ceit.aut.processor.CPU;

public class Main {

    public static void main(String[] args) {
        AddressGenerator addressGenerator = new AddressGenerator();
        addressGenerator.generate("test1");
        CPU cpu = new CPU(System.getProperty("user.dir") + "/inputs/test1.txt",500);
        for (String s : cpu.getRequestedAddresses()) {
            System.out.println(s);
        }
    }
}
