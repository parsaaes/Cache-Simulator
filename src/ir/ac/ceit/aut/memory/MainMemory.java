package ir.ac.ceit.aut.memory;
//Ino man mizanam...
public class MainMemory {
    private DirectMapCache mainCache;
    private VictimCache victimCache;
    private int missedAddressesNumber;
    public MainMemory(int sizeBitCount, int blockSize,int victimSize) {
        mainCache = new DirectMapCache(sizeBitCount,blockSize);
        victimCache = new VictimCache(victimSize,blockSize);
        missedAddressesNumber = 0;
    }
    public void requestWord(String address) {
        String evictedWordData = "";
        //evictedWordData = DirectMapCache.insertData(String address);
        if (!evictedWordData.equals("miss")) {
            victimCache.insertData(evictedWordData);
        }
        missedAddressesNumber++;
    }
    public void requestInterCacheSwap(String address) {
            requestWord(address);
            missedAddressesNumber--;
    }

    public int getMissedAddressesNumber() {
        return missedAddressesNumber;
    }
}
