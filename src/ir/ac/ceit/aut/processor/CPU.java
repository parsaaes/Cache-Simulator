package ir.ac.ceit.aut.processor;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CPU {
    private String filePath;
    private int count;

    public CPU(String filePath, int count){
        this.filePath = filePath;
        this.count = count;
    }

    public ArrayList<String> getRequestedAddresses(){
        ArrayList<String> result = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        if(sc != null) {
            while (sc.hasNextLine()) {
                result.add(sc.nextLine());
                i++;
            }
            sc.close();
        }
        if(count != i){
            System.err.println("CPU Error! not all requested address exist. number requested:" + count + " returned:" + i);
        }
        return result;
    }
}

