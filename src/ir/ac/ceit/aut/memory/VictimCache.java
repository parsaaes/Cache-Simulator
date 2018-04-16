package ir.ac.ceit.aut.memory;
/*
    Important note:
        void requestWord() must change to String requestWord() which if it was a miss and some word was evicted
        (because they had same indices in direct mapping) returns evicted word's data(address in this project)
         and other wise returns "miss"and returns "hit" in case it's a hit.
        More importantly requestWord should not insert data if missed instantly it should be done by another controller Class
        like MainMemory. (Farda tozih midam)

 */
/*
TODO: Faghat nokte ine ke insertData ro vase Direct map implement kon!
TODO: RequestWord ham felan be in soorat taghir bede(String bargardoone).
 */
public class VictimCache extends FullyAssociativeCache {

    //size is in range(4,8).(it must be small)
    public VictimCache(int sizeBitCount, int blockSizeBitCount) {
        super(sizeBitCount, blockSizeBitCount);
    }

    @Override
    public boolean requestWord(String word) {
        super.requestWord(word);
        //...
        return false;
    }

}
