package ir.ac.ceit.aut.memory;


import ir.ac.ceit.aut.address.AddressGenerator;

public class DirectMapCache extends Memory implements Cache {

    public DirectMapCache(int sizeBitCount, int blockSize) {
        super(sizeBitCount, blockSize);
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
    public void requestWord(String word) {
        if(this.containsAddress(word)){
            // hit
            System.out.println("hit!");
        }
        else {
            // miss
            System.out.println("miss!");
            String[] parsed = parseDmAddress(word);
            long index = AddressGenerator.toLong(parsed[1]);
            long tag = AddressGenerator.toLong(parsed[0]);
            String firstWordInBlock = parsed[0] + parsed[1];
            for(int i = 0; i < blockSizeBitCount; i++){
                firstWordInBlock += "0";
            }
            String[] parsedFirstWordInBlock = parseDmAddress(firstWordInBlock);
            System.out.println("block first -> " + firstWordInBlock + " index:" + parsedFirstWordInBlock[1] );
            long blockStartIndex = AddressGenerator.toLong(parsedFirstWordInBlock[1]) * blockSize;
            for(int i = 0; i < Math.pow(2,blockSizeBitCount); i++){
                wordArray[(int) (i + blockStartIndex)].setData(AddressGenerator.toBinString(AddressGenerator.toLong(firstWordInBlock) + i));
                wordArray[(int) (i + blockStartIndex)].setValidBit(true);
            }
        }
    }

}
