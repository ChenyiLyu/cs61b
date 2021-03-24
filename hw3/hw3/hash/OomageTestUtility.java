package hw3.hash;

import java.util.*;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        Map buckets = new HashMap();
        for (Oomage o:oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            if (buckets.containsKey(bucketNum)) {
                buckets.put(bucketNum, (int) buckets.get(bucketNum) + 1);
            } else {
                buckets.put(bucketNum, 1);
            }
        }
        int min = (int) Collections.min(buckets.values());
        int max = (int) Collections.max(buckets.values());
        if ((min < N / 50) | (max > N / 2.5)) {
            return false;
        }
        return true;
    }
}
