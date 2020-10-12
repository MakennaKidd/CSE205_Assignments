// Assignment #: 10
//         Name: Makenna Kidd
//    StudentID: 1218102912
//  Lab Lecture: T + Th @ 1:30pm
//  Description: A linked list is a sequence of nodes with efficient
//               element insertion and removal. This class contains
//               a subset of the methods of the standard java.util.LinkedList class.

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList
{
    //nested class to represent a node
    private class Node
    {
        public Object data;
        public Node next;
    }

    //only instance variable that points to the first node.
    private Node first;

    // Constructs an empty linked list.
    public LinkedList()
    {
        first = null;
    }


    // Returns the first element in the linked list.
    public Object getFirst()
    {
        if (first == null)
        {
            NoSuchElementException ex
                    = new NoSuchElementException();
            throw ex;
        }
        else
            return first.data;
    }

    // Removes the first element in the linked list.
    public Object removeFirst()
    {
        if (first == null)
        {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
        }
        else
        {
            Object element = first.data;
            first = first.next;  //change the reference since it's removed.
            return element;
        }
    }

    // Adds an element to the front of the linked list.
    public void addFirst(Object element)
    {
        //create a new node
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        //change the first reference to the new node.
        first = newNode;
    }

    // Returns an iterator for iterating through this list.
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    /*********************************************************
     Start of added methods. See all code below v
     *********************************************************/

    //Method to print contents in string
    public String toString()
    {
        //Instantiate iterator and variable
        ListIterator listIterator = listIterator();
        String stringContents = "{";

        //While loop to scan for contents inside this string
        while (listIterator.hasNext())
        {
            //If there are no contents, string prints out empty, if there are contents, string prints those within the brackets
            stringContents = stringContents + " " + listIterator.next();
        }
        stringContents = stringContents + " }\n"; //Closing the string off with the contents inside the brackets
        return stringContents;
    } // End of toString method

    //Method to compute size of list
    public int size()
    {
        //Set list iterator and set variable to initial size
        ListIterator listIterator = new LinkedListIterator();
        int listSize = 0;

        // While loop to scan the list given
        while (listIterator.hasNext()) {
            listIterator.next();
            listSize += 1; //Take the variable before + current value and add 1
        }
        return listSize;
    } // End of size method

    //Method to add an element
    public void addElement(Object element)
    {
        //Instantiate variables
        Node currentValue = new Node();
        currentValue.data = element;

        //If first is null, compute values, and return first
        if (first == null)
        {
            currentValue.next = null;
            first = currentValue;
            return;

            //Comparing the strings alphabetically to put in order
        } else if(element.toString(). compareTo(first.data.toString() ) <0)
        {
            currentValue.next = first;
            first = currentValue;
            } else { //else if current value is greater than data
            //Instantiating variables
            Node node = first.next;
            Node previous = first;

            //While loop to find the position for the new content
            while( node != null )
            {
                //If order is found for content, break the loop
                if((element.toString().compareTo (node.data.toString()) < 0 ))
                {
                    break;
                }
                //Instantiating node values
                previous = node;
                node = node.next;
            }
            //Return with current value
            currentValue.next = previous.next;
            previous.next = currentValue;
        }
    } // End of addElement method


    //Method to remove and element at even indices
    public void removeElementsAtEvenIndices( )
    {
        //Instantiate iterator and variable
        ListIterator listIterator = new LinkedListIterator();
        int element = 0;

        // While loop to traverse the list, iterator moves onto the next element
        while (listIterator.hasNext())
        {
            listIterator.next(); // Iterator scans next element

            if ((element % 2) == 0)  // If the element is even, then iterator removes the element
            {
                listIterator.remove(); // If the statement is true, iterator removes element at the even index
            }
            element += 1; // Take the variable before + current value and add 1
        }
    } // End of removeElementsAtEvenIndices method

    //Method to print how many elements appear before a specified element
    public int howManyAppearBefore(Object element)
    {
        //Instantiating node and variable
        Node currentValue = this.first;
        int amountAppearedBefore = 0;

        //While loop for scanning elements
        while(currentValue != null)
        {
            //If the current value of data equals the element, return the # of previous elements
            if((currentValue.data).equals(element))
            {
                return amountAppearedBefore;
            }
            amountAppearedBefore++; // Increase amount
            currentValue = currentValue.next; // Changing currentValue when amount is increased
        }
        return -1; //Return -1 when amount is not found
    } // End of howManyAppearBefore method

    //Method to print index of last element
    public int indexOfLast(Object element) //Todo Error when ran : Can't figure out // Figured it out after the fact
    {
        //Instantiate variables
        Node currentValue = first;
        int index = -1;
        int parameter = 0;

        if(element instanceof String)
        {
            while( currentValue != null)
            {
                if((currentValue.data).equals(element))
                {
                    index = parameter;
                }
                currentValue = currentValue.next;
                parameter++;
            }
            return index;
        }

        while(currentValue != null)
        {
            if(currentValue.data == element)
            {
                index = parameter;
            }
            currentValue = currentValue.next;
            parameter++;
        }
        return index;
    } // End of indexOfLast method

    //Method to duplicate each element when the option is chosen
    public void duplicateEach( )
    {
        //Instantiating node and array list
        ArrayList linkedList = new ArrayList();
        Node currentValue = first;
        int check = 0;

        //While loop to scan the elements
        while(currentValue != null)
        {
            // For loop to check if the element is present in list
            for(int i = 0; i < linkedList.size(); i++)
            {
                //If the array at i is = to current value, check if the element is present, then break
                if(linkedList.get(i) == currentValue.data)
                {
                    check = 1; // Returning 1
                    break;
                }
            }
            //If the check is equal to 0, proceed to array adding and returning current value of array
            if(check == 0)
            {
                linkedList.add(currentValue.data);
            }
            currentValue = currentValue.next;
        } //End of while loop

        // Constructing new duplicate list
        this.first = null;

        //For Loop to duplicate elements in list
        for(int i = 0; i < linkedList.size(); i++)
        {
            this.addElement(linkedList.get(i));
            this.addElement(linkedList.get(i));
        }
    }// End of duplicateEach method

    //Method to remove an element at a certain index
    public Object removeElementAt(int index)
    {
        //Instantiating node and variable
        Node currentValue = this.first;
        int parameter = 0;

        //While loop to scan values and returning current value, then increment size by 1
        while(currentValue != null)
        {
            currentValue = currentValue.next;
            parameter++;
        }

        // If the size is greater than the index size, out of bounds exception occurs
        if(parameter <= index)
        {
            throw new IndexOutOfBoundsException();
        }

        //If index is = to 0, first element is removed, returns
        if(index == 0)
        {
            Node elementRemoved = this.first;
            this.first = this.first.next;
            return elementRemoved.data;
        }

        //Computing current value after if statements and while loop above
        currentValue = this.first;

        //For loop to compute the current value at certain indices
        for(int i = 0; i < index -1 ; i++)
        {
            currentValue = currentValue.next;
        }

        //Computing that the element was removed and returning the value at the index location
        Node elementRemoved = currentValue.next;
        currentValue.next = currentValue.next.next;
        return elementRemoved.data;
    } // End of removeElementAt method

    /*********************************************************
     End of added methods. See all code above^
     *********************************************************/

    //Nested class to define its iterator
    private class LinkedListIterator implements ListIterator
    {
        private Node position; //current position
        private Node previous; //it is used for remove() method

        // Constructs an iterator that points to the front
        // of the linked list.

        public LinkedListIterator()
        {
            position = null;
            previous = null;
        }

        // Tests if there is an element after the iterator position.
        public boolean hasNext()
        {
            if (position == null) //not traversed yet
            {
                if (first != null)
                    return true;
                else
                    return false;
            } else {
                if (position.next != null)
                    return true;
                else
                    return false;
            }
        }

        // Moves the iterator past the next element, and returns
        // the traversed element's data.
        public Object next()
        {
            if (!hasNext())
            {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            } else {
                previous = position; // Remember for remove

                if (position == null)
                    position = first;
                else
                    position = position.next;
                return position.data;
            }
        }

        // Adds an element after the iterator position
        // and moves the iterator past the inserted element.
        public void add(Object element)
        {
            if (position == null) //never traversed yet
            {
                addFirst(element);
                position = first;
            }
            else
            {
                //making a new node to add
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //change the link to insert the new node
                position.next = newNode;
                //move the position forward to the new node
                position = newNode;
            }
            //this means that we cannot call remove() right after add()
            previous = position;
        }

        // Removes the last traversed element. This method may
        // only be called after a call to the next() method.
        public void remove()
        {
            if (previous == position)  //not after next() is called
            {
                IllegalStateException ex = new IllegalStateException();
                throw ex;
            }
            else
            {
                if (position == first)
                {
                    removeFirst();
                }
                else
                {
                    previous.next = position.next; //removing
                }
                //stepping back
                //this also means that remove() cannot be called twice in a row.
                position = previous;
            }
        }

        // Sets the last traversed element to a different value.
        public void set(Object element)
        {
            if (position == null)
            {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            }
            else
                position.data = element;
        }
    } //end of LinkedListIterator class
} //end of LinkedList class
