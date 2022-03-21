package thedrake;

public class Board {

	private final int dimension;
	private final BoardTile[][] boardTiles;


	// Konstruktor. Vytvoří čtvercovou hrací desku zadaného rozměru, kde všechny dlaždice jsou prázdné, tedy BoardTile.EMPTY
	public Board(int dimension) {
		this.dimension = dimension;
		this.boardTiles = new BoardTile[dimension][dimension]; // nacpat prvky na kazdy element
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				boardTiles[i][j] = BoardTile.EMPTY;
			}
		}

	}

	public Board(BoardTile[][] boardTiles2) {
		this.boardTiles = boardTiles2;
		this.dimension = boardTiles2.length; // rozmer pole
	}


	// Rozměr hrací desky
	public int dimension() {
		return dimension;
	}

	// Vrací dlaždici na zvolené pozici.
	public BoardTile at(TilePos pos) {
		return boardTiles[pos.i()][pos.j()]; // z BoardTile
	}

	// Vytváří novou hrací desku s novými dlaždicemi. Všechny ostatní dlaždice zůstávají stejné
	public Board withTiles(TileAt ...ats) { // prijde pole, TileAt[] ats, TODO podivat se - .clone()
		BoardTile[][] boardTiles2 = new BoardTile[dimension][dimension]; // toto je kopie, kde je navic nekoli prvku zmenenych --- tile at
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) { // nestaci foreach, zde se musi prirazovat do POLE, nebo meneni pole
				boardTiles2[i][j] = boardTiles[i][j];
			}
		}
		for (int i = 0; i < ats.length; i++) { //TODO pouziti for each cyklu ZDE
			boardTiles2[ats[i].pos.i()][ats[i].pos.j()] = ats[i].tile; // pos : pozice, tile : tile
		}
		return new Board(boardTiles2);
	}

	// Vytvoří instanci PositionFactory pro výrobu pozic na tomto hracím plánu
	public PositionFactory positionFactory() {
		return new PositionFactory(dimension);
	}
	
	public static class TileAt {
		public final BoardPos pos;
		public final BoardTile tile;
		
		public TileAt(BoardPos pos, BoardTile tile) {
			this.pos = pos;
			this.tile = tile;
		}
	}
}

