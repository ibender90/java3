package testing;

public class ArrayHasOneAndFour {
    public boolean hasOneAndFour(Integer[] input){
        boolean oneIsFound = false;
        boolean fourIsFound = false;

        for (int i = 0; i < input.length; i++) {
            if (input[i]==1){
                oneIsFound = true;
            }
            if (input[i]==4){
                fourIsFound = true;
            }
        }
        return oneIsFound && fourIsFound;
    }
}
