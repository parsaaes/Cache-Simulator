package ir.ac.ceit.aut.memory;


public class FACache extends Memory implements Cache {

    private int[] usage;

    public FACache(int sizeBitCount, int blockSizeBitCount) {
        super(sizeBitCount, blockSizeBitCount);
        usage = new int[(int) Math.pow(2, sizeBitCount - blockSizeBitCount)];
    }

    @Override
    public boolean requestWord(String word) {
        return false;
    }

    @Override
    public void insertData(String word) {

    }

    @Override
    protected boolean containsAddress(String searching) {
        return false;
    }
}
