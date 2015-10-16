import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberList implements java.util.Collection {

    private Long[] arr;
    private int count;

    /** Constructs an empty number list. */
    public NumberList(){
        this.arr = new Long[10];
        this.count = 0;
    }


    /** Constructs a number list from an array of Longs. */
    public NumberList(Long[] l){
        int length = 10;
        this.count = 0;
        for (int i = 0; l.length > length; i++) {
            length = 10 * (int) (Math.pow(2, i));
        }
        this.arr = new Long[length];
        for (int i = 0; i < l.length; i++) {
            this.arr[i] = l[i];
            this.count += 1;
        }
        this.finalizeArray();
        this.count = this.arr.length;
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add (Object obj) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            Long addend = (Long) obj; //Long.parseLong(obj.toString());
            Long[] sum = new Long[0];
            if (this.count < this.arr.length) {
                this.arr[count] = addend;
            } else {
                sum = new Long[this.arr.length * 2];
                for (int i = 0; i < this.arr.length; i++) {
                    sum[i] = this.arr[i];
                }
                sum[this.arr.length] = addend;
                this.arr = sum;
            }
            this.count += 1;
            //System.out.println("Array: " + Arrays.toString(this.arr));
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
    

    /** Adds all of the elements of the given number list to this one. */
    public boolean addAll (java.util.Collection c) {
        try {
            if (!(c instanceof NumberList)) {
                throw new IllegalArgumentException();
            }
            NumberList cNL = (NumberList) c;
            for (int i = 0; i < cNL.sizeIncludingDuplicates(); i++) {
                this.add(cNL.toArray()[i]);
            }
            this.finalizeArray();
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }


    /** Removes all of the elements from this collection. */
    public void clear () {
        this.arr = new Long[0];
        this.count = 0;
    }


    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            Long comparison = (Long) obj;
            for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
                if (this.arr[i].equals(comparison)) {
                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }



    /** Returns true iff this number list contains at least one instance of each element 
    in the specified list. Multiple copies of some element in the argument do not
    require multiple copies in this number list. */
    public boolean containsAll ( java.util.Collection c ) {
        try {
            if (!(c instanceof NumberList)) {
                throw new IllegalArgumentException();
            }
            NumberList cNL = (NumberList) c;
            for (int i = 0; i < cNL.sizeIncludingDuplicates(); i++) {
                if (!this.contains(cNL.toArray()[i])) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }




    /** Compares the specified object with this collection for equality. */
    public boolean equals (Object obj) {
        try {
            if (!(obj instanceof NumberList)) {
                throw new IllegalArgumentException();
            }
            NumberList objNL = (NumberList) obj;
            if (this.sizeIncludingDuplicates() != objNL.sizeIncludingDuplicates()) {
                return false;
            }
            for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
                if (!this.arr[i].equals(objNL.toArray()[i])) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }




    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException(); 
    }



    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
        return (this.count == 0);
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
    be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Removes a single instance of the specified element from 
    this collection, if it is present. */
    public boolean remove ( Object obj ) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            Long objNL = (Long) obj;
            boolean found = false;
            if (this.contains(objNL)) {
                Long[] newArray = new Long[this.sizeIncludingDuplicates() - 1];
                for (int i = 0; i < newArray.length; i++) {
                    if (this.arr[i].equals(objNL) && !found) {
                        found = true;
                    }
                    if (!found) {
                        newArray[i] = this.arr[i];
                    } else {
                        newArray[i] = this.arr[i + 1];
                    }
                }
                this.arr = newArray;
            }
            this.finalizeArray();
            return found;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }



    /** Removes all of this collection's elements that are also contained 
    in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        try {
            if (!(c instanceof NumberList)) {
                throw new IllegalArgumentException();
            }
            NumberList cNL = (NumberList) c;
            for (int i = 0; i < cNL.sizeIncludingDuplicates(); i++) {
                while (this.contains(cNL.toArray()[i])) {
                    this.remove(cNL.toArray()[i]);
                }
            }
            this.finalizeArray();
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }




	/** Retains only the elements in this collection that are contained in the specified collection. 
	In other words, removes from this collection all of its elements that are not contained in the 
	specified collection. */
    public boolean retainAll ( java.util.Collection c ) {
        try {
            if (!(c instanceof NumberList)) {
                throw new IllegalArgumentException();
            }
            NumberList cNL = (NumberList) c;
            while (!this.equals(cNL)) {
            for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
                if (!cNL.contains(this.arr[i])) {
                    while (this.contains(this.arr[i])) {
                        this.remove(new Long(this.arr[i]));
                    }
                }
            }
        }
            this.finalizeArray();
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        int counter = 0;
        for (int i = 0; i < this.arr.length && this.arr[i] != null; i++) {
            counter += 1;
        }
        return counter;
    }



    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        return this.arr;
    }



    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
        NumberList used = new NumberList();
        for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
            System.out.println("i: " + i);
            System.out.println("Contains: " + used.contains(this.toArray()[i]));
            if (!used.contains(this.toArray()[i])) {
                System.out.println("In if");
                used.add(this.toArray()[i]);
                //System.out.println("Used: " + Arrays.toString(used.toArray()));
            }
        }
        System.out.println("Used: " + Arrays.toString(used.toArray()));
        return used.sizeIncludingDuplicates();
    }




    /** Returns the number of instances of the given element in this number list. */
    public int count ( Object obj ) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            Long objNL = (Long) obj;
            if (!this.contains(objNL)) {
                return 0;
            }
            int counter = 0;
            for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
                counter += (this.arr[i].equals(objNL)) ? 1 : 0;
            }
            return counter;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }




    /** This returns a stringy version of this number list. */
    public String toString () { // overrides Object.toString()
        return Arrays.toString(this.arr);
    }

    public void finalizeArray() {
        Long[] finalArray = new Long[this.sizeIncludingDuplicates()];
        for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
            finalArray[i] = this.arr[i];
        }
        this.arr = finalArray;
    }




    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
    Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {
        NumberList numL = new NumberList();
        for (int i = 0; i < l.length; i++) {
            numL.add(new Long(l[i]));
        }
        return numL;
    }

    
    /** This main method is just a comprehensive test program for the class. */
    public static void main ( String[] args ) {
        NumberListTestHarness nLTH = new NumberListTestHarness();
        nLTH.main(new String[0]);








        NumberList nL = new NumberList(new Long[]{new Long(1), new Long(2), new Long(3), new Long(4), new Long(5)});

        NumberList nL2 = new NumberList(new Long[]{new Long(1), new Long(2), new Long(3)});

        System.out.println(nL.toString());

        nL.retainAll(nL2);

        System.out.println(nL.toString());        
    }
    
}