package hw2;
import  edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int nexp;
    private int ngrid;
    private Percolation sys;
    private double[] frac = new double[nexp];
    private double mean;
    private double stddev;
    private double confidenceLow;
    private double confidenceHigh;


    /** Perform T independent experiments on an N-by-N grid. */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        isInputValid(N, T);
        sys = pf.make(20);
        this.nexp = T;
        this.ngrid = N;
        simulator();
    };

    private void isInputValid(int N, int T) {
        if (N <= 0 | T <= 0) {
            throw new IllegalArgumentException();
        }
    }

    /** Simulate n times of experiment on NxN grid,
     * return an array of fraction of sites when the system percolates. */
    private void simulator() {
        for (int i = 0; i < nexp; i++) {
            int r = StdRandom.uniform(ngrid);
            int c = StdRandom.uniform(ngrid);
            if (sys.isOpen(r, c)) {
                i--;
            }
            sys.open(r, c);
            if (sys.percolates()) {
                frac[i] = sys.numberOfOpenSites() / ngrid;
                break;
            }
        }
    }
    /** Sample mean of percolation threshold. */
    public double mean() {
        mean = StdStats.mean(frac);
        return mean;
    }
    /** Sample standard deviation of percolation threshold. */
    public double stddev() {
        stddev = StdStats.stddev(frac);
        return stddev;
    }
    /** Low endpoint of 95% confidence interval. */
    public double confidenceLow() {
        confidenceLow = mean - 1.96 * stddev / (double) Math.sqrt(nexp);
        return confidenceLow;
    }

    /** high endpoint of 95% confidence interval. */
    public double confidenceHigh() {
        confidenceHigh = mean + 1.96 * stddev / (double) Math.sqrt(nexp);
        return confidenceHigh;
    }
}
