package com.example.Checkers_global;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CheckersBoardAdapter extends BaseAdapter {
    private Context context;
    private List<CheckersBoardCell> checkersBoard;

    public CheckersBoardAdapter(Context context) {
        this.context = context;
        this.checkersBoard = initializeCheckersBoard();
        initializePieces(); // Add this line to initialize the pieces on the board
    }

    private List<CheckersBoardCell> initializeCheckersBoard() {
        List<CheckersBoardCell> cells = new ArrayList<>();
        boolean isWhite = true;

        for (int i = 0; i < 64; i++) {
            cells.add(new CheckersBoardCell(isWhite));
            isWhite = !isWhite && (i % 8 != 7); // Switch color on each row
        }

        return cells;
    }

    // Method to initialize the pieces on the board
    private void initializePieces() {
        // Set pieces at specific positions, assuming you have a method to get the piece color
        setPieceDrawable(3, 0, R.drawable.dark_piece_highlighted); // Example: Set a white piece at position (3, 0)
        setPieceDrawable(4, 7, R.drawable.dark_king_highlighted); // Example: Set a black piece at position (4, 7)
        setPieceDrawable(5, 6, R.drawable.light_king_piece); // Example: Set a white piece at position (5, 6)
        // Add more pieces as needed
    }

    private void setPieceDrawable(int x, int y, int drawableResource) {
        int position = y * 8 + x;
        CheckersBoardCell cell = checkersBoard.get(position);
        cell.setPiece(drawableResource);
    }

    @Override
    public int getCount() {
        return checkersBoard.size();
    }

    @Override
    public Object getItem(int position) {
        return checkersBoard.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        CheckersBoardCell cell = checkersBoard.get(position);

        // Check if there's a piece on the cell and set the drawable
        if (cell.hasPiece()) {
            imageView.setImageResource(cell.getPiece());
        } else {
            imageView.setImageDrawable(null); // Clear the image if there's no piece
        }

        return imageView;
    }
}
