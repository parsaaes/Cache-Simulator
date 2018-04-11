package ir.ac.ceit.aut.memory;

public abstract class Memory {
    protected int sizeBitCount;
    protected int blockSizeBitCount;
    protected Word[] wordArray;

    protected abstract boolean containsAddress(String searching);


    public Memory(int sizeBitCount, int blockSizeBitCount) {
        this.sizeBitCount = sizeBitCount;
        this.blockSizeBitCount = blockSizeBitCount;
        this.wordArray = new Word[(int) Math.pow(2,sizeBitCount)];
        instantiateWordArr();
    }
    private void instantiateWordArr(){
        for (Word word : wordArray) {
            word = new Word();
        }
    }

    public int getSizeBitCount() {
        return sizeBitCount;
    }

    public int getBlockSizeBitCount() {
        return blockSizeBitCount;
    }

    /**
     * parse binary address by this shape: n-c|c-b|b
     * @param address address of the memory
     * @return array of size 3 {n-c,c-b,b}
     */
    public String[] parseDmAddress(String address){
        return new String[]
                {address.substring(0, address.length() - sizeBitCount),
                address.substring(address.length() - sizeBitCount,address.length()-  blockSizeBitCount),
                address.substring(address.length() - blockSizeBitCount)
                };
    }
}
