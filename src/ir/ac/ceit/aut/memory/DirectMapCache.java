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
        Word found = wordArray[(int)index];
        String[] foundAddress = parseDmAddress(wordArray[(int)index].getData());
        System.out.println(found.isValid() && tag == AddressGenerator.toLong(foundAddress[0]));
        return found.isValid() && tag == AddressGenerator.toLong(foundAddress[0]);
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
