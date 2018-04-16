package ir.ac.aut.ceit.memory;

public abstract class Memory {
    protected int sizeBitCount;
    protected int size;
    protected int blockSize;
    protected int blockSizeBitCount;
    protected Word[] wordArray;

    protected abstract boolean containsAddress(String searching);


    public Memory(int sizeBitCount, int blockSizeBitCount) {
        this.sizeBitCount = sizeBitCount;
        this.blockSizeBitCount = blockSizeBitCount;
        blockSize = (int) Math.pow(2,blockSizeBitCount);
        size = (int) Math.pow(2,sizeBitCount);
        this.wordArray = new Word[(int) Math.pow(2,sizeBitCount)];
        instantiateWordArr();
    }
    private void instantiateWordArr(){
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = new Word();
        }
    }

    public int getSizeBitCount() {
        return sizeBitCount;
    }

    public int getBlockSizeBitCount() {
        return blockSizeBitCount;
    }

    public Word[] getWordArray() {
        return wordArray;
    }
}
