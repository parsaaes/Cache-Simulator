package ir.ac.aut.ceit.memory;


import ir.ac.aut.ceit.address.AddressGenerator;

public class DirectMapCache extends Memory implements Cache {

    private String evictedBlockFirstWord = AddressGenerator.toBinString(0);
    public DirectMapCache(int sizeBitCount, int blockSizeBitCount) {
        super(sizeBitCount, blockSizeBitCount);
    }

    @Override
    public boolean containsAddress(String searching) {
        // TODO
        String[] parsed = parseDmAddress(searching);
        long index = AddressGenerator.toLong(parsed[1]);
        long tag = AddressGenerator.toLong(parsed[0]);
        Word found = wordArray[(int)index * blockSize];
        String[] foundAddress = parseDmAddress(found.getData());
        return found.isValid() && tag == AddressGenerator.toLong(foundAddress[0]);
    }

    @Override
    public boolean requestWord(String word) {
        if(this.containsAddress(word)){
            // hit
            // System.out.println("dm says: hit!");
            return true;
        }
        else {
            // miss
            // System.out.println("dm says: miss!");
            //insertData(word);
            return false;
        }
    }

    public void insertData(String word) {
        String[] parsed = parseDmAddress(word);
        long index = AddressGenerator.toLong(parsed[1]);
        long tag = AddressGenerator.toLong(parsed[0]);
        String firstWordInBlock = parsed[0] + parsed[1];
        for(int i = 0; i < blockSizeBitCount; i++){
            firstWordInBlock += "0";
        }
        String[] parsedFirstWordInBlock = parseDmAddress(firstWordInBlock);

        evictedBlockFirstWord = firstWordInBlock;

        //System.out.println("block first -> " + firstWordInBlock + " index:" + parsedFirstWordInBlock[1] );
        long blockStartIndex = AddressGenerator.toLong(parsedFirstWordInBlock[1]) * blockSize;
        for(int i = 0; i < blockSize; i++){
            wordArray[(int) (i + blockStartIndex)].setData(AddressGenerator.toBinString(AddressGenerator.toLong(firstWordInBlock) + i));
            wordArray[(int) (i + blockStartIndex)].setValidBit(true);
        }
    }

    public String getEvictedBlockFirstWord() {
        return evictedBlockFirstWord;
    }


    /**
     * parse binary address by this shape: n-c|c-b|b
     * @param address address of the memory
     * @return array of size 3 {n-c,c-b,b}
     */
    private String[] parseDmAddress(String address){
        return new String[]
                {address.substring(0, address.length() - sizeBitCount),
                        address.substring(address.length() - sizeBitCount,address.length()-  blockSizeBitCount),
                        address.substring(address.length() - blockSizeBitCount)
                };
    }
}
