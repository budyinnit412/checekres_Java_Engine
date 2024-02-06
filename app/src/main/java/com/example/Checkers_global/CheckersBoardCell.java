package com.example.Checkers_global;

public class CheckersBoardCell {
    private boolean isWhite;
    private int pieceDrawable;

    public CheckersBoardCell(boolean isWhite) {
        this.isWhite = isWhite;
        this.pieceDrawable = 0; // 0 indicates no piece initially
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setPiece(int drawableResource) {
        this.pieceDrawable = drawableResource;
    }

    public boolean hasPiece() {
        return pieceDrawable != 0;
    }

    public int getPiece() {
        return pieceDrawable;
    }
}
