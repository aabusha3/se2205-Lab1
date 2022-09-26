/*
 * Author: Ahmad Sami Abu Shawarib & Kevin Abdo
 * Student #: 251149713  &  251171763
 * Date:  Oct. 10, 2021
 * Description: This Code Uses The Concepts Of The Stack from the MyStack class To Populate An Array
 * And Print Out The Team Member's Information
 */

package LA1Q2;

public class StackDemo0 {
    public static void main(String[] args) {
        //header intro
        header();


        //creates a blank stack
        System.out.println("\n\nRevisiting the concept of Stack.....");
        MyStack<String> stringStackTest = new MyStack<>(0);
        System.out.println(stringStackTest);

        //fills the stack with new 6 elements
        String[] names = new String[]{"251171763", "Abdo", "Kevin", "251149713", "Abu Shawarib", "Ahmad"};
        for (String name : names)
            stringStackTest.push(name);
        System.out.println(stringStackTest);

        //peaks at the top-most spot of the stack
        System.out.println(stringStackTest.peak());

        //searches for an elements/object
        String toBeSearched = "251171763";//the string/object to search for
        int searchIndex = stringStackTest.search(toBeSearched);//the index the string/object above was found at
        System.out.println("\nSearching for \"" + toBeSearched + "\"....");

        if (searchIndex > -1) {//if the string/object was found
            System.out.println("The Item Has Been Found In Distance " + searchIndex + " With Reference To The Top");

            //the first and last digits of a student number and their average
            int firstDigit = Integer.parseInt(names[names.length - searchIndex].substring(0, 1));
            System.out.println("The First Number In The Student ID Is " + firstDigit);

            int lastDigit = Integer.parseInt(names[names.length - searchIndex].substring(names[names.length - searchIndex].length() - 1));
            System.out.println("The Last Number In The Student ID Is " + lastDigit);

            System.out.printf("The Average Of These Two Numbers Is: %.3f%n", (firstDigit + lastDigit) / 2.0);
        }
        else//if the string/object was not found
            System.out.println("The Item \"" + toBeSearched + "\" Was Not Found In The Stack");


        //footer conclusion
        footer(stringStackTest);
    }

    public static void header() {//printHeader;  prints a header
        int n = 81;
        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks

        System.out.print("""
                        
                Names : Kevin and Ahmad
                Student Numbers: 251171763 and 251149713
                This Code Uses The Concepts Of The Stack To Populate An Array
                And Print Out The Team Member's Information
                """);

        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks
    }

    public static void footer(MyStack<String> stack) {//void function with MyStack<String> type param; pops all the elements of the stack and prints them out in a formatted presentation
        System.out.println(
                "\nTeam Member 1 Info..... "
                        + "\n\tFirst Name: " + stack.pop()
                        + "\n\tLast Name: " + stack.pop()
                        + "\n\tStudent Number: " + stack.pop()

                        + "\nTeam Member 2 Info..... "
                        + "\n\tFirst Name: " + stack.pop()
                        + "\n\tLast Name: " + stack.pop()
                        + "\n\tStudent Number: " + stack.pop());

        System.out.println("\nHere Is The Status Of The Stack...\n" + stack + "\nGoodbye!");
    }
}
