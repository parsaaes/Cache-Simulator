package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;
import ir.ac.ceit.aut.memory.DirectMapCache;
import ir.ac.ceit.aut.memory.Word;

public class Main {

    public static void main(String[] args) {
//        AddressGenerator addressGenerator = new AddressGenerator();
//        addressGenerator.generate("in2.txt");
        Simulator simulator = new Simulator(12,4);
        simulator.run();
    }
}
