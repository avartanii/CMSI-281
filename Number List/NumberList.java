import java.lang.reflect.Array;

public class NumberList implements java.util.Collection {

    public long[] arr;
    public int count;

    /** Constructs an empty number list. */
    public NumberList(){
        this.arr = new long[10];
        this.count = 0;
    }


    /** Constructs a number list from an array of Longs. */
    public NumberList(Long[] l){
        int length = 10;
        for (int i = 0; l.length > length; i++) {
            length = 10 * (int) (Math.pow(2, i));
        }
        this.arr = new long[length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = l[i];
        }
        this.count = 0;
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add (Object obj) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            long addend = (long) obj; //Long.parseLong(obj.toString());
            long[] sum = new long[0];
            if (this.count < this.arr.length) {
                this.arr[count] = addend;
            } else {
                sum = new long[this.arr.length * 2];
                for (int i = 0; i < this.arr.length; i++) {
                    sum[i] = this.arr[i];
                }
                sum[this.arr.length] = addend;
            }
            this.arr = sum;
            this.count += 1;
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
            this.count = 0;
            int newLength = ((this.arr.length > cNL.sizeIncludingDuplicates()) ? this.arr.length * 2 : cNL.sizeIncludingDuplicates() * 2);
            long[] sum = new long[newLength];
            for (int i = 0; i < this.arr.length; i++) {
                sum[i] = this.arr[i];
                count += 1;
            }
            for (int j = this.arr.length; j < sum.length; j++) {
                sum[j] = Array.getLong(c.toArray(), j - this.arr.length);
                count =+ 1;
            }
            this.arr = sum;
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }


    /** Removes all of the elements from this collection. */
    public void clear () {
        this.arr = new long[0];
        this.count = 0;
    }


    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        try {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException();
            }
            long comparison = Long.parseLong(obj.toString());
            for (int i = 0; i < this.arr.length; i++) {
                if (this.arr[i] == comparison) {
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
            boolean found;
            for (int i = 0; i < cNL.sizeIncludingDuplicates(); i++) {
                found = false;
                for (int j = 0; j < this.arr.length; j++) {
                    found = (Array.getLong(cNL.toArray(), i) == this.arr[j]) ? true : false;
                }
                if (!found) {
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
            if (this.count != objNL.sizeIncludingDuplicates()) {
                return false;
            }
            for (int i = 0; i < this.arr.length; i++) {
                if (this.arr[i] != Array.getLong(objNL.toArray(), i)) {
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
            long objNL = (long) obj;
            boolean found = false;
            if (this.contains(objNL)) {
                long[] newArray = new long[this.arr.length - 1];
                for (int i = 0; i < newArray.length; i++) {
                    if (this.arr[i] == objNL) {
                        found = true;
                    }
                    if (!found) {
                        newArray[i] = this.arr[i];
                    } else {
                        newArray[i] = this.arr[i + 1];
                    }
                }
            }
            return found;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }



    /** Removes all of this collection's elements that are also contained 
    in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




	/** Retains only the elements in this collection that are contained in the specified collection. 
	In other words, removes from this collection all of its elements that are not contained in the 
	specified collection. */
    public boolean retainAll ( java.util.Collection c ) {
        throw new UnsupportedOperationException();
    }


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        return this.count;
    }



    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




    /** Returns the number of instances of the given element in this number list. */
    public int count ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




    /** This returns a stringy version of this number list. */
    public String toString () { // overrides Object.toString()
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
    Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }

    
    /** This main method is just a comprehensive test program for the class. */
    public static void main ( String[] args ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
    
}