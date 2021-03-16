package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPercolation {

    @Test
    public void testOpenFullPercolates(){
        Percolation sys3x3 = new Percolation(3);
        sys3x3.open(1, 1);
        assertTrue(sys3x3.isOpen(1, 1));

        sys3x3.open(0, 1);
        assertTrue(sys3x3.isFull(1, 1));

        sys3x3.open(2, 1);
        assertTrue(sys3x3.percolates());
    }

    @Test
    public void testUpdateNeighborSites1(){
        Percolation sys3x3 = new Percolation(3);
        sys3x3.open(0, 1);
        sys3x3.open(2, 1);
        assertFalse(sys3x3.percolates());

        sys3x3.open(1, 1);
        assertTrue(sys3x3.isFull(1, 1));
        assertTrue(sys3x3.percolates());
    }


    @Test
    public void updateBackWash(){
        Percolation sys3x3 = new Percolation(3);
        sys3x3.open(0, 0);
        sys3x3.open(2, 0);
        sys3x3.open(1, 0);
        sys3x3.open(2, 2);
        sys3x3.open(1, 2);

        assertFalse(sys3x3.isFull(1, 2));
        assertFalse(sys3x3.isFull(2, 2));
        assertTrue(sys3x3.percolates());
    }

}
