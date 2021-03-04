package creatures;
import huglife.*;

import java.awt.Color;
import java.util.List;
import java.util.Map;

/** A fierce blue-colored predator that snacking on Plips.*/

public class Clorus extends Creature {
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    public Clorus (double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** Cloruses loses 0.03 units of energy on a move action. */
    @Override
    public void move() {
        energy -= 0.03;
    }

    /** Cloruses loses 0.01 units of energy on a stay action. */
    @Override
    public void stay() {
        energy -= 0.01;
    }

    /** Always return red = 34; green = 0; blue = 231. */
    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    /** Clorus attacks anther creature and gains that creature's energy. */
    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    /** Parent clorus keeps 50% energy when replicates. The other 50% goes to its offspring. */
    @Override
    public Clorus replicate() {
        energy = 0.5 * energy;
        Clorus offspring = new Clorus(energy);
        return offspring;
    }

    /** Clorus takes exactly following actions based on Neighbors.
     * 1. If there is no empty square, the Clorus will stay.
     * 2. Otherwise, if there is any Plips nearby, the Clorus will attack one of them nearby.
     * 3. Otherwise, if the Clorus has energy greater than or equal to 1, it will replicate to
     * a random empty space. */
    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors,"plip");
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (plips.size() != 0) {
            Direction attackDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK, attackDir);
        } else if (energy >= 1) {
            Direction replicateDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, replicateDir);
        }
        Direction moveDir = HugLifeUtils.randomEntry((empties));
        return new Action(Action.ActionType.MOVE, moveDir);
    }

}
