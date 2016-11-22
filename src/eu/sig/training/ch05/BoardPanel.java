package eu.sig.training.ch05;

import java.awt.Graphics;
import java.util.List;

public class BoardPanel {
    @SuppressWarnings("unused")
    // tag::render[]
    /**
     * Renders a single square on the given graphics context on the specified
     * rectangle.
     * 
     * @param square
     *            The square to render.
     * @param g
     *            The graphics context to draw on.
     * @param x
     *            The x position to start drawing.
     * @param y
     *            The y position to start drawing.
     * @param w
     *            The width of this square (in pixels).
     * @param h
     *            The height of this square (in pixels).
     */
    private void render(Square square, Graphics g, Dimentions dimentions) {
        square.getSprite().draw(g, dimentions.getX(), dimentions.getY(), dimentions.getW(), dimentions.getH());
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(g, dimentions.getX(), dimentions.getY(), dimentions.getW(), dimentions.getH());
        }
    }
    // end::render[]

    private class Sprite {
        @SuppressWarnings("unused")
        public void draw(Graphics g, Dimentions dimentions) {

        }
    }

    private class Unit {
        public Sprite getSprite() {
            return null;
        }
    }

    private class Square extends Unit {

        public List<Unit> getOccupants() {
            return null;
        }

    }

    private static class Dimentions {
        private final int x;
        private final int y;
        private final int w;
        private final int h;

        private Dimentions(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getW() {
            return w;
        }

        public int getH() {
            return h;
        }
    }
}
