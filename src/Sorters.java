import java.util.Arrays;
import java.util.Scanner;

public class Sorters <T extends Comparable<T>> {
    public static void main(String[] args) throws Exception {
        Comparable[] nonsortarray= {12, 67, 45, 13, 81, 43};
        System.out.println("Please select Bubble sort or Merge sort");
        Scanner scnr = new Scanner(System.in);        
        
        Sorters bubblesorter = new Sorters<>();
        Sorters mergesorter = new Sorters<>();
        
        String inputstring = scnr.nextLine();

        while (!"Exit".equals(inputstring)){
            if ("Bubble".equals(inputstring)){
                bubblesorter.bubblesort(nonsortarray);
                System.out.println(Arrays.toString(nonsortarray));
            }
            
            else if ("Merge".equals(inputstring)){
                mergesorter.mergesort(nonsortarray);
                System.out.println(Arrays.toString(nonsortarray));
            }           
            else {
                System.out.println("Please enter valid option. (Merge or Bubble)");
            }
            System.out.println("Please select Bubble sort or Merge sort or Exit to quit.");
            inputstring = scnr.nextLine();
        }
        System.out.println("Thank you for using my program.");
        
        System.exit(0);
    }



    private void bubblesort(Comparable[] array){
        int arrlength = array.length;

        for (int i = 0; i < arrlength-1; i++){
            for (int j = 0; j < arrlength - i - 1; j++){
                if ((array[j]).compareTo(array[j+1]) > 0){

                    Comparable hold = array[j];
                    array[j] = array[j+1];
                    array[j+1] = hold;
                }
            }
        }
        for (int k = 0; k < arrlength; k++){
            System.out.println(array[k]);
        }
    }

    public static Comparable[] mergesort(Comparable[] array){
        if (array.length <= 1){
            return array;
        }
        Comparable[] left = new Comparable[array.length/2];
        Comparable[] right = new Comparable[array.length - left.length];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);
                
        mergesort(left);
        mergesort(right);

        merge(left, right, array);

        return array;
    }
    private static void merge(Comparable[] left, Comparable[] right, Comparable[] array){
        int firstcounter = 0;
        int secondcounter = 0;
        int thirdcounter = 0;

        while (firstcounter < left.length && secondcounter < right.length){
            if ((left[firstcounter].compareTo(right[secondcounter])) < 0 ){
                array[thirdcounter] = left[firstcounter];
                firstcounter++;
            }
            else{
                array[thirdcounter] = right[secondcounter];
                secondcounter++;
            }
            thirdcounter++;
        }
        
        System.arraycopy(left, firstcounter, array, thirdcounter, left.length-firstcounter);
        System.arraycopy(right, secondcounter, array, thirdcounter, right.length - secondcounter);
    }
}
