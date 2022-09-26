/*
 * Author: Ahmad Sami Abu Shawarib & Kevin Abdo
 * Student #: 251149713  &  251171763
 * Date:  Oct. 10, 2021
 * Description: This Code Uses The Generic Type Pair class To Accept And Pair Integers With Strings
 * To Print Out Student Leaders Names Corresponding To The Year Chosen By The User
 */

package LA1Q1;

import java.util.*;

public class Student_Leader_List {

    public static void main(String[] args) {
        //header intro
        myHeader();


        //creates 2 arraylists to temporarily store the initial values
        ArrayList<Integer> keys = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> values = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        //creates a null object array of class type Pair with the size of the arraylists above
        Pair[] pairing = new Pair[keys.size()];

        //initializes the objects in the array using the constructor
        for (int index = 0; index < pairing.length; index++)
            pairing[index] = new Pair<>(keys.get(index), values.get(index));


        do {
            System.out.println("\n");
            //asks for a year the user would like to search
            int yearKey = intInputAndValidation("From which year you are looking for the names of the student leaders: ");

            //creates an arraylist that stores the indices of the objects that are equal to the int above
            ArrayList<Integer> indexCount = new ArrayList<>();
            for (int index = 0; index < pairing.length; index++)
                if (pairing[index].getKey().equals(yearKey))
                    indexCount.add(index);

            //prints the count of the indices store that match the search above
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ahmad And Kevin Found " + indexCount.size());
            if (indexCount.size() != 1)//correct spelling for plural
                System.out.print(" Student Leaders");
            else//correct spelling for singular
                System.out.print(" Student Leader");
            System.out.print(" From Year " + yearKey + " And They Are:\n");

            //prints out the objects' value that match the indices from the arraylist "indexCount" above
            for (Integer integer : indexCount)
                System.out.println("\u2022  " + pairing[integer].getValue());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        } while (!quit("Do you want to continue? [y or n]: "));//asks the user if they want to continue

        //prints out the student reps (1 per year)
        System.out.println("\nHere is the list of the class-reps.....");
        pairing = getRep_AhmadKevin(pairing);
        for (Pair pair : pairing)
            System.out.println(pair.getKey() + " - " + pair.getValue());
        System.out.println();


        //footer conclusion
        myFooter();
    }


    //Y, N type object array of class Pair function with object array of class Pair param; returns a sorted & appended array of the student reps (1 per year)
    public static Pair[] getRep_AhmadKevin(Pair[] pa) {

        ///////////    filtering the array     ///////////
        //creates 2 arraylists to store the first instance of a unique student's year and the corresponding unique name for all years
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        //extracts the relevant unique year and the corresponding name
        for (Pair pair : pa)
            if (!keys.contains(pair.getKey())) {
                keys.add((Integer) pair.getKey());
                values.add((String) pair.getValue());
            }
        ///////////    filtering the array     ///////////


        ///////////    sorting the array     ///////////
        //creates arraylist to store the indices of the unsorted years of the old array
        ArrayList<Integer> indices = new ArrayList<>();

        //creates 2 arraylists to store the new sorted values
        ArrayList<String> sortedValues = new ArrayList<>();
        ArrayList<Integer> sortedKeys = (ArrayList<Integer>) keys.clone();

        //sorts the years in ascending order
        Collections.sort(sortedKeys);

        //puts the old arraylist indices in the correct order relative to the new arraylist
        for (Integer sortedInteger : sortedKeys)
            for (Integer integer : keys)
                if (sortedInteger.equals(integer)) {
                    indices.add(keys.indexOf(integer));
                    break;
                }

        //sorts the students' names relative to the order of their sorted years
        for (Integer index : indices)
            sortedValues.add(values.get(index));

        //creates a new object array of class Pair with a reduced size; to be returned
        Pair[] appendedPA = new Pair[keys.size()];

        //initializes the above array with the sorted values
        for (int index = 0; index < appendedPA.length; index++)
            appendedPA[index] = new Pair<>(sortedKeys.get(index), sortedValues.get(index));
        ///////////    sorting the array     ///////////


        return appendedPA;
    }


    //boolean function with String param; asks the user if they want to continue
    public static boolean quit(String inputMessage) {

        //the value corresponding to the user's answer; to be returned
        boolean quit = false;

        System.out.print(inputMessage);//asks the user to continue
        String response = keyBoard.next().toLowerCase();//takes the user's response

        switch (response) {
            case "y" -> {
            }//if user wants to continue, then return false (gets negated to true on return)

            case "n" -> quit = true;//if user wants to quit, then return true (gets negated to false on return)

            default -> { //if user doesn't enter in 'y' or 'n'
                System.out.println("Invalid entry! Enter \"y\" or \"n\" Only");
                quit(inputMessage);//runs quit() infinitely
            }
        }
        return quit;
    }


    public static Scanner keyBoard = new Scanner(System.in);//the input method for the user

    //asks for and returns an integers; gives error message if non-integer is entered
    public static int intInputAndValidation(String inputMessage) {

        //the value corresponding to the user's answer; to be returned
        int _int;

        System.out.print(inputMessage);//asks the user for a specific  int
        while (true) {//runs infinitely

            try {//tries for integers
                _int = keyBoard.nextInt();//takes the user's response

                if (_int != 2 && _int != 3 && _int != 4)//checks if the input is either 2, 3, or 4
                    throw new RuntimeException();//to be caught

                break;  //the only way out of the infinite loop

            } catch (RuntimeException e) {//catches non-integers, and not 2, 3, or 4; gives a "what went wrong" message and loops
                System.out.print("Invalid entry! Enter A Positive Integer Between 2 And 4: ");
                keyBoard.nextLine();//clears the Scanner
            }
        }
        return _int;
    }

    public static void myHeader() {//printHeader;  prints a header
        int n = 81;
        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks

        System.out.print("""
                                
                Names : Kevin and Ahmad
                Student Numbers: 251171763 and 251149713
                This Code Uses The Generic Type To Accept And Pair Integers With Strings
                To Print Out Student Leaders Names Corresponding To The Year Chosen By The User
                """);

        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks
    }


    public static void myFooter() {//printFooter;  prints a footer
        int n = 81;
        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks

        //hard coded date and time
        System.out.print("""
                         
                This Is 11:00:00 pm On October 10, 2021.
                Completion Of Lab Assignment 1 Is Successful!
                Good bye! Ahmad Abu Shawarib And Kevin Abdo.
                """);

        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks
    }
}
