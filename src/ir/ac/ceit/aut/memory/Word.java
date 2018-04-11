package ir.ac.ceit.aut.memory;

import ir.ac.ceit.aut.address.AddressGenerator;

public class Word {
    private String data = AddressGenerator.toBinString(0);
    private boolean validBit;

    public boolean isValid() {
        return validBit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValidBit(boolean validBit) {
        this.validBit = validBit;
    }
}
