package ir.ac.aut.ceit;


import ir.ac.aut.ceit.address.AddressGenerator;

public class Main {

    public static void main(String[] args) {
        /*
        If you want to generate a new instruction file just uncomment two fallowing lines.
        for example -> 1-   generate("input10") 2-  String instructions = "inputs/input10.txt"
         */

//        AddressGenerator addressGenerator = new AddressGenerator();
//        addressGenerator.generate("input10");

            String instructions = "inputs/input5.txt";
            Simulator simulator1 = new Simulator(12, 8, 4, instructions);
            simulator1.run(false);
            Simulator simulator2 = new Simulator(12, 8, 4, instructions);
            simulator2.run(true);


    }
}
