package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;


/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final long SEED = 100;
    private static Random RANDOM = new Random(SEED);

    /** Add a hexagon onto the world.
     *  p is the point of left upper corner.
     *  s is the size of added hexagon. */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

        ArrayList<Position> area = hexRegion(p, s);
        for (Position tile:area) {
            TETile colorfulTile = TETile.colorVariant(t, 32,32,32, RANDOM);
            world[tile.x][tile.y] = colorfulTile;
        }
    }


    /** For the given hexagon, return tilt positions that need to be filled. */
    private static ArrayList<Position> hexRegion(Position p, int s) {
        ArrayList<Position> area = new ArrayList<Position>();
        int hX = p.x;
        int hY = p.y;

        /** top half part. */
        for (int i = 0; i < s; i++) {
            int tY = hY - i;
            for (int tX = hX - i; tX < hX + s + i; tX++) {
                area.add(new Position(tX, tY));
            }
        }

        /** bottom half part. */
        for (int i = 0; i < s; i++) {
            int tY = hY - 2 * s + 1 + i;
            for (int tX = hX - i; tX < hX + s + i; tX++) {
                area.add(new Position(tX, tY));
            }
        }
        return area;
    }

    /** draw tesselations of hexagons using the selected position as the left upper corner position*/
    public static void addTesselation(TETile[][] world, Position p, int s) {
        ArrayList<Position> hexagons = tesselationHelperGetPos(p, s);
        for (Position hexagon:hexagons) {
            addHexagon(world, hexagon, s, randomTile());
        }
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.WATER;
            case 4: return Tileset.SAND;
            case 5: return Tileset.PLAYER;
            default: return Tileset.NOTHING;
        }
    }


    /** Return a list of the left upper corner position of the low-level hexagon. */
    private static ArrayList<Position> tesselationHelperGetPos(Position p, int s) {
        ArrayList<Position> upLeftPosOfHex = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int getX = p.x + (2 * s - 1) * i;
            int n = i + 3;
            for (int j = 0; j < n; j++) {
                int getY = p.y - 2 * j * s + i * s;
                upLeftPosOfHex.add(new Position(getX, getY));
            }
        }

        for (int i = 4; i < 6; i++) {
            int getX = p.x + (s * 2 - 1) * (i - 1);
            int n = - i + 8;
            for (int j = 0; j < n; j++) {
                int getY = p.y - 2 * j * s + s * (5 - i);
                upLeftPosOfHex.add(new Position(getX, getY));
            }
        }
        return upLeftPosOfHex;
    }


    private static Position addHexHere(int x, int y) {
        return new Position(x, y);
    }


    private static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] hexW = new TETile[WIDTH][HEIGHT];

        /** Initialize the world. */
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                hexW[x][y] = Tileset.NOTHING;
            }
        }

        Position p = addHexHere(5, 50);
//        addHexagon(hexW, p, 5, Tileset.FLOWER);
        addTesselation(hexW, p, 3);
        ter.renderFrame(hexW);
    }

}
