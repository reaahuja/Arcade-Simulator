import java.util.*;

/*
Pre: N/A
Description: The MagicSort class is a mini-game in the store section of the arcade, thereby it inherits the store class.
Additionally, this method allows the user to input any type of numbers, and it will sort it.
Post: N/A
 */
public class MagicSort extends Store{
    /*
    Pre: N/A
    Description:  This method provides the instructions for the Millionaire game to the user
    Post: N/A
     */
    void instructions() {
        System.out.println("In this game you can input a list of numbers and the program will magically sort it!");
        System.out.println("You can choose between 2 sorting algorithms to sort your list of numbers");
        System.out.println("Note: You will not receive any points for playing this game");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    void menu() {
        Scanner input = new Scanner(System.in);
        //array of numbers is created by user
        int[] array = createArray();

        //user is asked which sorting method they would like to use
        System.out.println("To sort the array using selection sort enter 1");
        System.out.println("To sort the array using quick sort enter 2");
        int option = input.nextInt();

        //program will enter following conditional statement if selection sort is chosen
        if (option == 1){
            System.out.println("Running selection sort...\n");

            selectionSort(array, 0, array.length);

        //program will enter following conditional statement if quick sort is chosen
        }else {
            System.out.println("Running quick sort...\n");

            int highestSearch = array.length - 1;
            quickSorts(array, 0, highestSearch, 0);
        }

        //sorted list is displayed
        System.out.println("\nSorted list: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    /*
    Pre: N/A
    Description: This method allows the user to create an array with the numbers they would like to sort
    Post: This method returns the array created by the user
     */
    public static int[] createArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers would you like to input? ");
        int length = input.nextInt();

        int[] array = new int[length];

        for (int i = 0; i < length; i++){
            System.out.println("Input a number: ");
            array[i] = input.nextInt();
        }

        return array;
    }

    //Selection Sort Methods:

    /*
    Pre: This method takes the array created by the user, a variable i which is equal to 0 and the length of the array
    as parameters
    Description: This recursive method alongside the assistance of the swap method performs selectionSort
    Post: N/A
     */
    public static void selectionSort(int[] array, int i, int length){
        //minimum value is found
        int min = i;
        for (int j = i + 1; j < length; j++){
            //if array[j] is less than array[min] than the values are swapped
            if (array[j] < array[min]){
                min = j;
                System.out.println("Swapping " + array[j] + " & " + array[min]);
            }
        }

        //values are swapped
        swap(array, min, i);


        if ((i + 1) < length){
            selectionSort(array, i + 1, length);
        }
    }

    /*
    Pre: This method takes the array, the value of min and i as parameters
    Description: This method swaps the values passed to it
    Post: N/A
     */
    public static void swap (int[] array, int min, int i){
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }

    //Quick Sort methods:

    /*
    Pre: This method takes the array, the value of the lowestSearch, the value of the highestSearch and j as parameters
    Description: This method organizes the calls on the sorting method.
    Post: N/A
     */
    public static void quickSorts(int[] array, int lowestSearch, int highestSearch, int j) {
        //array is printed along sorting process
        if (lowestSearch < highestSearch){
            for (int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println("");

            int value = sorting(array, lowestSearch, highestSearch, lowestSearch);
            //value is used to change the range of the array being searched
            quickSorts(array, lowestSearch, value-1, lowestSearch);
            quickSorts(array, value +1, highestSearch, value + 1);
        }
    }

    /*
    Pre: This method takes the array, the value of the lowestSearch, the value of the highestSearch and the value of j
    as parameters
    Description: This method performs quick sort.
    Post: The index of the last comparison is returned.
     */
    public static int sorting(int[] array, int lowestSearch, int highestSearch, int j) {
        if(lowestSearch < highestSearch){
            if ( array[lowestSearch] < array[highestSearch]){
                //if array[lowestSearch] is less than array[highestSearch] values are swapped
                int temp = array[lowestSearch];
                array[lowestSearch] = array[j];
                array[j] = temp;
                return sorting(array, lowestSearch + 1, highestSearch, j + 1);
            }else{
                //if array[lowestSearch] is not less than array[highestSearch] values then the value of lowestSearch is increased
                return sorting(array, lowestSearch +1, highestSearch, j);
            }
        }

        //pivot is swapped with the element in the last comparison
        int temp = array[highestSearch];
        array[highestSearch] = array[j];
        array[j] = temp;
        return j;
    }

}
