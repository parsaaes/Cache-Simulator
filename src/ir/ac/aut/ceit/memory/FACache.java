package ir.ac.aut.ceit.memory;


import ir.ac.aut.ceit.address.AddressGenerator;

public class FACache extends Memory implements Cache {

    private int[] usage;
    private int age;

    public FACache(int sizeBitCount, int blockSizeBitCount) {
        super(sizeBitCount, blockSizeBitCount);
        usage = new int[(int) Math.pow(2, sizeBitCount - blockSizeBitCount)];
        age = 0;
    }

    @Override
    public boolean requestWord(String word) {
        age++;
        if(this.containsAddress(word)){
            // hit
            //System.out.println("fa says: hit!");
            updateUsage(word);
            return true;
        }
        else {
            // miss
            //System.out.println("fa says: miss!");
            //insertData(word);
            return false;
        }
    }


    @Override
    public void insertData(String word) {
        String firstWordInBlock = parseFAAddress(word)[0];
        for(int i = 0; i < blockSizeBitCount; i++){
            firstWordInBlock += "0";
        }
        int blockStartIndex =  getLRUIndex() * blockSize;
        for(int i = 0; i < blockSize; i++){
            wordArray[(int) (i + blockStartIndex)].setData(AddressGenerator.toBinString(AddressGenerator.toLong(firstWordInBlock) + i));
            wordArray[(int) (i + blockStartIndex)].setValidBit(true);
        }
        usage[getLRUIndex()] = age;
    }

    public void rePlaceData(String word, String lastWord) {
        String firstWordInBlock = parseFAAddress(word)[0];
        for(int i = 0; i < blockSizeBitCount; i++){
            firstWordInBlock += "0";
        }
        int blockStartIndex =  getWordIndex(lastWord);
        for(int i = 0; i < blockSize; i++){
            wordArray[(int) (i + blockStartIndex)].setData(AddressGenerator.toBinString(AddressGenerator.toLong(firstWordInBlock) + i));
            wordArray[(int) (i + blockStartIndex)].setValidBit(true);
        }
    }

    @Override
    protected boolean containsAddress(String searching) {
        for (int i = 0; i < wordArray.length; i++) {
            if(parseFAAddress(wordArray[i].getData())[0].equals(parseFAAddress(searching)[0])){
                return wordArray[i].isValid();
            }
        }
        return false;
    }

    private int getLRUIndex(){
        int result = 0;
        int min = usage[result];
        for (int i = 0; i < usage.length; i++) {
            if(usage[i] < min){
                min = usage[i];
                result = i;
            }
        }
        return result;
    }

    private int getWordIndex(String word){
        String tag = parseFAAddress(word)[0];
        for (int i = 0; i < wordArray.length; i++) {
            if(parseFAAddress(wordArray[i].getData())[0].equals(tag)){
                return i;
            }
        }
        return -1;
    }

    private void updateUsage(String word) {
        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i].getData().equals(word)){
                usage[i / blockSize] = age;
            }
        }
    }

    /**
     * parse binary address by this shape: n-b|b
     * @param address address of the memory
     * @return array of size 2 {n-b,b}
     */
    public String[] parseFAAddress(String address){
        return new String[]
                {address.substring(0, address.length() - blockSizeBitCount),
                        address.substring(address.length() - blockSizeBitCount)
                };
    }

    public int[] getUsage() {
        return usage;
    }
}
