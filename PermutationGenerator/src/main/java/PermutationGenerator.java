import java.util.Iterator;

/**
 * Produces a permutation of integers between the specified bounds. The integers can be received in a random
 * order by using the iterator directly or through a for loop.
 */
public class PermutationGenerator implements Iterable<Integer> {

    private int[] values;
    private int size;
    // inclusive
    private int lowerBound;
    // exclusive
    private int upperBound;

    /**
     * PermutationGenerator constructor
     * @param lowerBound (int) the lower bound of the values in the permutation (inclusive)
     * @param upperBound (int) the upper bound of the values in the permutation (exclusive)
     * @throws InvalidBoundsException if lower bound >= upper bound
     */
    public PermutationGenerator(int lowerBound, int upperBound) throws InvalidBoundsException {
        if (lowerBound >= upperBound) {
            throw new InvalidBoundsException("The lower bound " + lowerBound + " is greater than or equal to the upper bound " + upperBound);
        }
        this.size = 0;
        this.values = new int[upperBound - lowerBound];
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        fillValues();
    }

    /**
     * Fills the array with the values between the lower and upper bounds
     */
    private void fillValues() {
        for (int i = lowerBound; i < upperBound; i++) {
            values[size] = i;
            size++;
        }
    }

    /**
     * Returns a RandomIterator to iterate through all values once in a random order
     * @return a RandomIterator
     */
    @Override
    public Iterator iterator() {
        return new RandomIterator();
    }

    /**
     * Goes through values between the lower and upper bounds exactly once in a random order
     */
    private class RandomIterator implements Iterator {

        int current;

        /**
         * RandomIterator constructor
         */
        public RandomIterator() {
            this.current = size;
        }

        /**
         * Determines whether the permutation is complete
         * @return whether the permutation is complete
         */
        @Override
        public boolean hasNext() {
            return this.current > 0;
        }

        /**
         * Returns the randomly chosen integer in the permutation
         * @return (int) next integer
         */
        @Override
        public Integer next() {
            // get random index between 0 and size
            int random = (int) (Math.random() * this.current);
            int temp = values[random];
            values[random] = values[--this.current];
            values[this.current] = temp;
            return temp;
        }
    }
}
