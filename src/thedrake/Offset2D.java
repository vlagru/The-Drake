package thedrake;

public class Offset2D {

    public final int x, y;

    public Offset2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // u booleanu zjednodusene if
    public boolean equalsTo(int x, int y) {
        return this.x == x && this.y == y; // u primitivnich datovych typu '==', objekty '.equalsTo()'
    }

    public Offset2D yFlipped() {
        return new Offset2D(x,-y);
    }
}
