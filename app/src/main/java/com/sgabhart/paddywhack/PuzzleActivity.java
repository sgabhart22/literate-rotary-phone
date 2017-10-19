package com.sgabhart.paddywhack;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleActivity extends AppCompatActivity {

    private Puzzle mPuzzle;
    private TextView mWord1, mWord2, mWord3, mWord4;
    private EditText mAnswer1, mAnswer2, mAnswer3, mAnswer4;
    private ImageView mImage;
    private PuzzleDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new PuzzleDbHelper(this);
        setContentView(R.layout.activity_puzzle);

        mWord1 = (TextView) (findViewById(R.id.wordLabel1));
        mWord2 = (TextView) (findViewById(R.id.wordLabel2));
        mWord3 = (TextView) (findViewById(R.id.wordLabel3));
        mWord4 = (TextView) (findViewById(R.id.wordLabel4));

        mAnswer1 = (EditText)(findViewById(R.id.wordInput1));
        mAnswer2 = (EditText)(findViewById(R.id.wordInput2));
        mAnswer3 = (EditText)(findViewById(R.id.wordInput3));
        mAnswer4 = (EditText)(findViewById(R.id.wordInput4));

    }
}
