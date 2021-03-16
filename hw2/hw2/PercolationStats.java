package hw2;
import  edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int nexp;
    private int ngrid;
    private Percolation sys;
    private PercolationFactory pf;
    private double[] frac;
    private double mean;
    private double stddev;
    private double confidenceLow;
    private double confidenceHigh;

    /** Perform T independent experiments on an N-by-N grid. */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        isInputValid(N, T);
        this.pf = pf;
        this.nexp = T;
        this.ngrid = N;
        this.frac = new double[T];
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
            sys = pf.make(ngrid);
            while (!sys.percolates()) {
                int r = StdRandom.uniform(ngrid);
                int c = StdRandom.uniform(ngrid);
                sys.open(r, c);
                if (sys.numberOfOpenSites() == Math.pow(ngrid, 2)) {
                    break;
                }
            }
            frac[i] = (double) sys.numberOfOpenSites() / (double) Math.pow(ngrid, 2);
        }
        mean = mean();
        stddev = stddev();
        confidenceHigh = confidenceHigh();
        confidenceLow = confidenceLow();
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
