package ir.ac.ceit.aut.memory;


public class DirectMapCache extends Memory implements Cache {

    public DirectMapCache(int sizeBitCount, int blockSize) {
        super(sizeBitCount, blockSize);
    }

    @Override
    protected boolean containsAddress(String searching) {
        // TODO
        return false;
    }

    @Override
    public void requestWord(String word) {
        if(this.containsAddress(word)){
            // hit
        }
        else {
            // miss
        }
    }

}
