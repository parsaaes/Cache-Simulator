package ir.ac.ceit.aut.memory;

public interface Cache {
    boolean requestWord(String word);
    void insertData(String word);
}
