public class Sound {



    /**
     * the array of values in this sound; guaranteed not to be null
     */
    private int[] samples =
            {
                    0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0
            };

    public int[] getSamples() { return samples; };
            
    /**
     * Removes all silence from the beginning of this sound. Silence is represented
     * by a value of 0.
     * Precondition: samples contains at least one nonzero value
     * Postcondition: the length of samples reflects the removal of starting
     * silence
     */
    public void trimSilenceFromBeginning() {
        // assume new array will be same size as original until proven otherwise.
        int n = samples.length;
        int idxFirstNonZero = 0;
        for (int i = 0; i < samples.length; i++) {
            // keep track of where the first non-zero value was found
            if (samples[i] != 0) {
                idxFirstNonZero = i;
                break;
            }
            // reduce future size of new array by one due to leading zero prescence
            n--;
        }

        // create replacement array the correct (smaller) size.
        int[] temp = new int[n];
        // copy from old array to new array
        int idx = 0;
        for (int i = idxFirstNonZero; i < samples.length; i++) {
            temp[idx++] = samples[i];
        }
        // switch original array reference pointer to the replacement array.
        samples = temp;
    }


    /**
     * Changes those values in this sound that have an amplitude greater than limit
     * Values greater than limit are changed to limit.
     *
     * @param limit the amplitude limit Precondition: limit >= 0
     * @return the number of values in this sound that this method changed
     */
    public int limitAmplitude(int limit) {
        // Complete this method
        int n = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                n++;
            } else if (samples[i] < -limit) {
                samples[i] = -limit;
                n++;
            }
        }
        return n;
    }
}
