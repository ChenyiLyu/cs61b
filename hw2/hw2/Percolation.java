package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.ArrayList;
import java.util.List;


public class Percolation extends WeightedQuickUnionUF {
    /** Create N-by-N grid, with all sites initially blocked.
     * @rule
     * 1. Constructor should take time proportional to N**2.
     * 2. All methods should take constant time plus a constant# of
     * calls.*/

    /** N-by-N grid. */
    private int N;
    /** Keep track of site status. */
    private int[] sites;
    /** Number of opening sites. */
    private int counts = 0;
    /** 0 if the system percolates, 1 if not. */
    private int percolateFlag = 0;
    private int sentinelSite;

    public Percolation(int N) {
        super(N * N + 1);
        this.N = N;
        sentinelSite = N * N;
        sites = new int[N * N];
    }


    /** Convert 2D coordinate into unique position#. */
    private int xyTo1D(int r, int c) {
        return r * N + c;
    }

    /** Throw IndexOutOfBoundsException if inputs are out of grid area. */
    private void checkBoundsException(int row, int col) {
        if (row < 0 | col < 0 | row >= N | col >= N) {
            throw new IndexOutOfBoundsException();
        }
    }

    /** Open the site if it is not open already. */
    public void open(int row, int col) {
        checkBoundsException(row, col);
        int site = xyTo1D(row, col);

        /** Do nothing if the site is already open. */
        if (isOpen(row, col)) {
            return;
        }
        /** Open the site as 1 if the site is not open already. */
        sites[site] = 1;
        counts += 1;

        /** Fill the site if it is next to the ground or a full site. */
        if (row == 0) {
            union(sentinelSite, site);
        } else if (isNextToFullSite(row, col)) {
            union(sentinelSite, site);
        }

        /** For a newly filled site, if the site is located at the bottom,
         * label the system as percolation.*/
        if (row == N - 1 && isFull(row, col)) {
            percolateFlag  = 1;
        }

        /** For a newly filled site, update the neighbor sites if the neighbor site is opening. */
        if (isFull(row, col)) {
            updateNeighborSites(row, col);
        }
    }

    /** Return true if the site is next to a full site. */
    private boolean isNextToFullSite(int row, int col) {
        List<Neighbor> neighbors = neighborSites(row, col);
        if (neighbors.isEmpty()) {
            return false;
        }
        for (Neighbor e : neighbors) {
            int r = e.r;
            int c = e.c;
            if (isFull(r, c)) {
                return true;
            }
        }
        return false;
    }

    /** Update the "full" status for the system when one site "full" status is changed. */
    private void updateNeighborSites(int row, int col) {
        List<Neighbor> neighbors = neighborSites(row, col);
        if (neighbors.isEmpty()) {
            return;
        }
        for (Neighbor e : neighbors) {
            int r = e.r;
            int c = e.c;
            if (isOpen(r, c) && !isFull(r, c)) {
                union(sentinelSite, xyTo1D(r, c));
                if (r == N - 1) {
                    percolateFlag  = 1;
                }
                updateNeighborSites(r, c);
            }
        }
    }

    /** Return a list of valid neighbor sites. */
    private List neighborSites(int row, int col) {
        List<Neighbor> neighbors = new ArrayList<Neighbor>();
        if (isValidSite(row - 1, col)) {
            Neighbor down = new Neighbor(row - 1, col);
            neighbors.add(down);
        }
        if (isValidSite(row + 1, col)) {
            Neighbor up = new Neighbor(row + 1, col);
            neighbors.add(up);
        }
        if (isValidSite(row, col - 1)) {
            Neighbor left = new Neighbor(row, col  - 1);
            neighbors.add(left);
        }
        if (isValidSite(row, col + 1)) {
            Neighbor right = new Neighbor(row, col + 1);
            neighbors.add(right);
        }
        return neighbors;
    }

    /** neighbor contains its rxc position. */
    private class Neighbor {
        int r;
        int c;
        Neighbor(int nr, int nc) {
            r = nr;
            c = nc;
        }
    }

    /** Return true if the site is in the grid boundary. */
    private boolean isValidSite(int row, int col) {
        return (row >= 0 && col >= 0 && row < N && col < N);
    }

    /** Is the site(row, col) open? */
    public boolean isOpen(int row, int col) {
        checkBoundsException(row, col);
        int site = xyTo1D(row, col);
        return sites[site] == 1;
    }

    /** Is the site(row, col) full? */
    public boolean isFull(int row, int col) {
        checkBoundsException(row, col);
        int site = xyTo1D(row, col);
        return connected(sentinelSite, site);
    }

    /** number of open sites. */
    public int numberOfOpenSites() {
        return counts;
    }

    /** Does the system percolate? */
    public boolean percolates() {
        return percolateFlag == 1;
    }

    /** Use for unit testing. */
    public static void main(String[] args) {
    }
}
