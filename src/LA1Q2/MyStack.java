/*
 * Author: Ahmad Sami Abu Shawarib & Kevin Abdo
 * Student #: 251149713  &  251171763
 * Date:  Oct. 10, 2021
 * Description: The MyStack class uses the push, pop, & peak concepts of a stack to manipulate an array to act like a stack object
 */

package LA1Q2;


import java.util.Arrays;

public class MyStack <E> {
    private Object[] objectArray;//the array to house the stack
    private int length;//the starting length of the array


    //constructor with int length param; creates a new object array with  the specified param length
    public MyStack(int length) {
        this.length = length;
        objectArray = new Object[this.length];
    }

    //boolean method; determines if array is empty
    public boolean empty() {
        return objectArray.length == 0;
    }

    //E type method; looks at the top-most element in the array
    public E peak() {
        return (E) ("The Value At The Top Is: " + objectArray[objectArray.length-1]);
    }

    //E type method to look at and remove the top-most element in the array
    public E pop() {
        //the element at the top-most spot of the stack; to be returned
        E prevStackTop = (E) objectArray.clone()[objectArray.length-1];

        //store the previous elements of the array in a temp array
        Object[] prevObjectArray = objectArray.clone();

        //creates a new array with the new decreased length
        objectArray = new Object[prevObjectArray.length-1];

        //copies the previous elements into the new array without the top-most spot of the previous stack
        System.arraycopy(prevObjectArray, 0, objectArray, 0, objectArray.length);
        return prevStackTop;
    }

    //E type method with E type param; adds a new element and spot to the stack array and places it on the top-most spot in the stack
    public E push(E anyName) {
        //adds 1 to the array's current length
        this.length = objectArray.length;
        this.length ++;

        //store the previous elements of the array in a temp array
        Object[] prevObjectArray = objectArray.clone();

        //creates a new array with the new increased length
        objectArray = new Object[this.length];

        //adds the newest element to the top-most spot in the stack
        objectArray[objectArray.length-1] = anyName;

        //copies all the previous elements into the new array
        System.arraycopy(prevObjectArray, 0, objectArray, 0, prevObjectArray.length);
        return anyName;
    }

    //int method with Object param; searches the stack for an object
    public int search(Object toBeSearched){
        int index;
        for (index =objectArray.length-1; index>0; index--)//checks all the array elements starting from the top-most spot in the stack
            if (objectArray[index].toString().equals(toBeSearched.toString()))
                break;

        if (!objectArray[index].toString().equals(toBeSearched.toString()))
            return -1;//if element was not found
        else
            return objectArray.length-index; // if element was found, returns the index that it was found at then calculates the index relative to the top-most spot of the stack
    }

    //String method overrides toString in the Object class; prints out the elements of the array stack
    public String toString(){
        if (!this.empty())//prints the stack normally
            return "The Stack: " + Arrays.toString(objectArray);
        else//declares the stack is empty
            return "The Stack Is Empty! The Stack: " + Arrays.toString(objectArray);
    }
}