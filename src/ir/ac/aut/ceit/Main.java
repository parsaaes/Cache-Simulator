package ir.ac.aut.ceit;


import ir.ac.aut.ceit.address.AddressGenerator;

public class Main {

    public static void main(String[] args) {

//        AddressGenerator addressGenerator = new AddressGenerator();
//        addressGenerator.generate("test");

        String instructions = "inputs/inp5.txt";
        Simulator simulator1 = new Simulator(12,8,4,instructions);
        simulator1.run(false);
        Simulator simulator2 = new Simulator(12,8,4,instructions);
        simulator2.run(true);

    }
}
