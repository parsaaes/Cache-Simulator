package ir.ac.ceit.aut.inputs;

import java.util.Random;

public class AddressGenerator {
    private static final long MIN = 0;
    private static final long MAX = (long) (Math.pow(2,32) - 1);
    private static final int COUNT = 500;
    private String[] addresses;

    public AddressGenerator(){
        addresses = new String[COUNT];
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            addresses[i] = toBinaryString( (Math.abs(random.nextLong()) % (MAX - MIN)) + MIN);
        }
        for (int i = 100;i<addresses.length; ) {
            String number = addresses[Math.abs(random.nextInt())%100];
            if (Math.abs(random.nextInt())%3 != 0) {
                long size = Math.min(Math.abs(random.nextInt())%20+10,(MAX-toLong(number)));
                for (int j = 0; j < size && i<addresses.length; j++,i++) {
                    addresses[i] = String.valueOf(toBinaryString(toLong(number)+j));
                }
            } else {
                addresses[i] = number;
                i++;
            }
        }

        for (int i = 0; i < addresses.length; i++) {
            String address = addresses[i];
            System.out.println(i+":"+address);
            if(address != null)
                System.out.println(toLong(address));
        }

    }

    public String[] getAddresses() {
        return addresses;
    }

    public static long toLong(String address){
        return Long.parseUnsignedLong(address,2);
    }

    public static String toBinaryString(long num){
        return  Long.toBinaryString(((num  & 0xffffffffL | 0x100000000L ))).substring(1);
    }
}
