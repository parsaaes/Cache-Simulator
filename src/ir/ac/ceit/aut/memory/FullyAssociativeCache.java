package ir.ac.ceit.aut.memory;

import ir.ac.ceit.aut.address.AddressGenerator;

public class FullyAssociativeCache extends Memory implements Cache {

    private int[] requestedIndices;
    private int numberOfDistinctRequests;

    public FullyAssociativeCache(int sizeBitCount, int blockSizeBitCount) {
        super(sizeBitCount, blockSizeBitCount);
        numberOfDistinctRequests = 0;
        requestedIndices = new int[wordArray.length];
        for (int i = 0; i < requestedIndices.length; i++) {
            requestedIndices[i] = -1;
        }
    }

    private int getRequestedWordIndex(String searchedAddress) {
        int index = getIndex(searchedAddress);
        long SearchedAddressTag = getFullyAssociativeTag(searchedAddress);
        if (wordArray[index].isValid() && SearchedAddressTag == getFullyAssociativeTag(wordArray[index].getData())) {
            return index;
        }
        for (int i = (index + 1) % wordArray.length; i != index; i = (i + 1) % wordArray.length) {
            if (wordArray[i].isValid() && SearchedAddressTag == getFullyAssociativeTag(wordArray[i].getData())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void requestWord(String word) {
        int requestedWordIndex = getRequestedWordIndex(word);
        if (requestedWordIndex != -1) {
            System.out.println("Hit");
            recordUsage(requestedWordIndex);
        } else {
            System.out.println("Miss");
            insertData(word);
        }
    }


    @Override
    protected boolean containsAddress(String searching) {
        return false;
    }

    private long getFullyAssociativeTag(String address) {
        return AddressGenerator.toLong(address.substring(0, address.length() - blockSizeBitCount));
    }

    //Index is not part of FA cache address format
    // In this mapping we're allowed to put data anywhere available in the cache;This index is checked first.
    private int getIndex(String address) {
        return (int) AddressGenerator.toLong(address.substring(address.length() - sizeBitCount, address.length() - blockSizeBitCount));
    }

    public void insertData(String address) {
        int index = getIndex(address);
        if (!wordArray[index].isValid()) {
            wordArray[index].setData(address);
            recordUsage(index);
            return;
        }
        for (int i = (index + 1) % wordArray.length; i != index; i = (i + 1) % wordArray.length) {
            if (!wordArray[i].isValid()) {
                wordArray[i].setData(address);
                recordUsage(i);
                return;
            }
        }
        index = getLeastRecentlyUsedAddressIndex();
        if (!wordArray[index].isValid()) {
            wordArray[index].setData(address);
            recordUsage(index);
            return;
        }
    }

    public int getLeastRecentlyUsedAddressIndex() {
        return requestedIndices[numberOfDistinctRequests - 1];
    }

    public void recordUsage(int requestedWordIndex) {

        int previousNumber = requestedIndices[0];
        requestedIndices[0] = requestedWordIndex;
        for (int i = 1; i < requestedIndices.length; i++) {
            int tmp;
            if (previousNumber == requestedWordIndex) {
                break;
            }
            tmp = requestedIndices[i];

            if (previousNumber != -1) {
                requestedIndices[i] = previousNumber;
                previousNumber = tmp;
            } else {
                break;
            }
        }
    }

}

