package creatures;
import huglife.*;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/** Test each method in Clorus class. */
public class TestClorus {
    private final static double e = 2;

    @Test
    public void testMove() {
        Clorus c = new Clorus(e);
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
    }

    @Test
    public void testAttack() {
        Clorus c = new Clorus(e);
        Plip p = new Plip(e);
        c.attack(p);
        assertEquals(4.0, c.energy(), 0.1);
    }

    @Test
    public void testStay() {
        Clorus c = new Clorus(e);
        c.stay();
        assertEquals(1.99, c.energy(), 0.01);
    }

    @Test
    public void testColor() {
        Clorus c = new Clorus(e);
        Color color = new Color(34, 0, 231);
        assertEquals(color, c.color());
    }

    @Test
    public void testChooseActionStay() {
        Clorus c = new Clorus(e);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());

        Action expected = new Action(Action.ActionType.STAY);
        Action actual = c.chooseAction(surrounded);
        assertEquals(expected, actual);
    }

    @Test
    public void testChooseActionAttack() {
        Clorus c = new Clorus(e);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());
        surrounded.put(Direction.BOTTOM, new Plip(2));

        Action expected = new Action(Action.ActionType.ATTACK, Direction.BOTTOM);
        Action actual = c.chooseAction(surrounded);
        assertEquals(expected, actual);
    }

    @Test
    public void testChooseActionReplicate() {
        Clorus c = new Clorus(e);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        surrounded.put(Direction.BOTTOM, new Empty());

        Action expected = new Action(Action.ActionType.REPLICATE, Direction.BOTTOM);
        Action actual = c.chooseAction(surrounded);
        assertEquals(expected, actual);
    }

    @Test
    public void testChooseActionMove() {
        Clorus c = new Clorus(0.5);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        surrounded.put(Direction.BOTTOM, new Empty());

        Action expected = new Action(Action.ActionType.MOVE, Direction.BOTTOM);
        Action actual = c.chooseAction(surrounded);
        assertEquals(expected, actual);
    }

}
