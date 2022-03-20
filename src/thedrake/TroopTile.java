package thedrake;

public class TroopTile implements Tile {

    private final Troop troop;
    private final PlayingSide side;
    private final TroopFace face;

    public TroopTile(Troop troop, PlayingSide side, TroopFace face) {
        this.troop = troop;
        this.side = side;
        this.face = face;
    }

    // Vrací True, pokud je tato dlaždice volná a lze na ni vstoupit
    @Override
    public boolean canStepOn() {
        return true;
    }

    // Vrací True, pokud tato dlaždice obsahuje jednotku
    @Override
    public boolean hasTroop() {
        return true;
    }

    // Vrací barvu, za kterou hraje jednotka na této dlaždici
    public PlayingSide side() { // face neporovnatelne s barvami
            return side;
    }

    // Vrací stranu, na kterou je jednotka otočena // getter
    public TroopFace face() {
        return face;
    }

    // Jednotka, která stojí na této dlaždici
    public Troop troop() {
        return troop;
    }

    // Vytvoří novou dlaždici, s jednotkou otočenou na opačnou stranu
// (z rubu na líc nebo z líce na rub)
    public TroopTile flipped() {
        if (face == TroopFace.AVERS) {
            return new TroopTile(troop, side, TroopFace.REVERS);
        } return new TroopTile(troop, side, TroopFace.AVERS);
    }
}
