package ir.ac.ceit.aut;

import ir.ac.ceit.aut.address.AddressGenerator;

public class Main {

    public static void main(String[] args) {

        AddressGenerator addressGenerator = new AddressGenerator();
        addressGenerator.generate("in2");

        Simulator simulator1 = new Simulator(12,4);
        simulator1.run(false);
        Simulator simulator2 = new Simulator(12,4);
        simulator2.run(true);

    }
}
