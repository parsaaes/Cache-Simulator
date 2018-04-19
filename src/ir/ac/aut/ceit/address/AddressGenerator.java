package ir.ac.aut.ceit.address;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AddressGenerator {
    private static final long MIN = 0;
    private static final long MAX = (long) (Math.pow(2,32) - 1);
    private static final int COUNT = 500;
    private String[] addresses;

    public AddressGenerator(){
        addresses = new String[COUNT];
    }

    public void generate(String fileName){
        // 100 -> 50 and uncomment another method
        int startOfLocality = 100;
        Random random = new Random();
        for(int i = 0; i < startOfLocality; i++){
            addresses[i] = toBinString( (Math.abs(random.nextLong()) % (MAX - MIN)) + MIN);
        }

        for (int i = startOfLocality; i< addresses.length; ) {
            String number = addresses[Math.abs(random.nextInt()) % (startOfLocality / 5 * (int)Math.ceil(( 2d * i / COUNT)))];
            addresses[i++] = number;
            if ((Math.abs(random.nextInt()) % 10) == 0) {
                long lengthOfLocality = Math.min(Math.abs(random.nextInt()) % 3,(MAX-toLong(number)));
                for (int j = 0; j < lengthOfLocality && i < addresses.length; j++) {
                    addresses[i++] = String.valueOf(toBinString(toLong(number)+j));
                }
            }
        }

        /* another method: */
//        for (int i = startOfLocality; i< addresses.length; ) {
//            String number = addresses[Math.abs(random.nextInt())% startOfLocality];
//            addresses[i++] = number;
//            if ((Math.abs(random.nextInt()) % 10) == 0) {
//                long lengthOfLocality = Math.min(Math.abs(random.nextInt()) % 10 + 5,(MAX-toLong(number)));
//                for (int j = 0; j < lengthOfLocality && i < addresses.length; j++) {
//                    addresses[i++] = String.valueOf(toBinString(toLong(number)+j));
//                }
//            }
//        }
        /* end of method */


//        for (int i = 0; i < addresses.length; i++) {
//            String address = addresses[i];
//            System.out.println(i+":"+address);
//            if(address != null)
//                System.out.println(toLong(address));
//        }

        File file = new File(System.getProperty("user.dir") + "/inputs/" + fileName + ".txt");
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < addresses.length; i++){
                bf.write(addresses[i] + System.lineSeparator());
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getAddresses() {
        return addresses;
    }

    public static long toLong(String address){
        return Long.parseUnsignedLong(address,2);
    }

    public static String toBinString(long num){
        return  Long.toBinaryString(((num  & 0xffffffffL | 0x100000000L ))).substring(1);
    }
}
