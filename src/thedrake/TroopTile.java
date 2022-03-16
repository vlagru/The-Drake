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
        if (troop) {
            return true;
        } return false;
    }

    // Vrací True, pokud tato dlaždice obsahuje jednotku
    @Override
    public boolean hasTroop() {
        if (!troop.equals(null)) {
            return true;
        } return false;
    }
    // Vrací barvu, za kterou hraje jednotka na této dlaždici
    public PlayingSide side() {
        if (face.equals(PlayingSide.BLUE)) { // face neporovnatelne s barvami
            return PlayingSide.BLUE;
        } else return PlayingSide.ORANGE;
    }

    // Vrací stranu, na kterou je jednotka otočena // getter
    public TroopFace face() {
        if (TroopFace.AVERS.equals(troop)) { // blbost, neporovnatelne
            return TroopFace.AVERS;
        } return TroopFace.REVERS;
    }

    // Jednotka, která stojí na této dlaždici
    public Troop troop()

    // Vytvoří novou dlaždici, s jednotkou otočenou na opačnou stranu
// (z rubu na líc nebo z líce na rub)
    public TroopTile flipped() {
        if (face.equals(TroopFace.AVERS))
            return new TroopTile(troop, side, TroopFace.REVERS);
    }
}