package testing;

public class ArrayAfterFour {

    public Integer[] getArrayAfterLastFour(Integer[] input){
        boolean arrayIncludesFour = false;
        if(input.length != 0){
            int outputArraySizeCounter = 0;
            for (int i = input.length-1; i >= 0; i--) {
                //самая последняя четвёрка игнорируется, так как после неё нечего копировать
                if(input[i] == 4){
                    arrayIncludesFour = true; //чтобы не выбросить исключение
                }
                if(input[i] == 4 && i == input.length-1){
                    return null; //четвёрка есть, но она на последнем месте, в задании не сказано что возвращать в таком случае
                }
                if(input[i] == 4 && outputArraySizeCounter > 0){
                    Integer[] output = new Integer[outputArraySizeCounter];
                    for (int j = 0; j < outputArraySizeCounter; j++) {
                        output[j] = input[i+1];
                        i++;
                    }
                    return output;
                }
                outputArraySizeCounter ++;
            }
            if(!arrayIncludesFour){
                throw new RuntimeException();
            }
        }
        return null;
    }
}
