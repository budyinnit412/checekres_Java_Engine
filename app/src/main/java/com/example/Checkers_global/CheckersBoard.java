package com.example.Checkers_global;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class CheckersBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkers_board);

        GridView checkersBoardGridView = findViewById(R.id.checkersBoardGridView);
        CheckersBoardAdapter checkersBoardAdapter = new CheckersBoardAdapter(this);
        checkersBoardGridView.setAdapter(checkersBoardAdapter);
    }
}

}