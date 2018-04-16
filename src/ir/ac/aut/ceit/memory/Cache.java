package ir.ac.aut.ceit.memory;

public interface Cache {
    boolean requestWord(String word);
    void insertData(String word);
}
