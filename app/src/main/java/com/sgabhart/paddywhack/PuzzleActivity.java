package com.sgabhart.paddywhack;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import java.util.List;

public class PuzzleActivity extends AppCompatActivity {

    private Puzzle mPuzzle;
    private TextView mWord1, mWord2, mWord3, mWord4;
    private EditText mAnswer1, mAnswer2, mAnswer3, mAnswer4;
    private ImageView mImage;
    private PuzzleDbHelper dbHelper;
    private List<String> words, answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        // Determine which Puzzle was selected from the list
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        // Get it from the db
        dbHelper = new PuzzleDbHelper(this);
        mPuzzle = dbHelper.selectById(id);

        // Assign db data to View elements
        mWord1 = (TextView) (findViewById(R.id.wordLabel1));
        mWord2 = (TextView) (findViewById(R.id.wordLabel2));
        mWord3 = (TextView) (findViewById(R.id.wordLabel3));
        mWord4 = (TextView) (findViewById(R.id.wordLabel4));

        mAnswer1 = (EditText)(findViewById(R.id.wordInput1));
        mAnswer2 = (EditText)(findViewById(R.id.wordInput2));
        mAnswer3 = (EditText)(findViewById(R.id.wordInput3));
        mAnswer4 = (EditText)(findViewById(R.id.wordInput4));

        mImage = (ImageView) (findViewById(R.id.cartoonView));

        words = mPuzzle.getWords();
        answers = mPuzzle.getAnswers();

        mWord1.setText(words.get(0));
        mWord2.setText(words.get(1));
        mWord3.setText(words.get(2));
        mWord4.setText(words.get(3));

        byte[] image = mPuzzle.getImage();
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        mImage.setImageBitmap(bmp);

        TextChangeHandler tch = new TextChangeHandler();
        mAnswer1.addTextChangedListener(tch);
        mAnswer2.addTextChangedListener(tch);
        mAnswer3.addTextChangedListener(tch);
        mAnswer4.addTextChangedListener(tch);
    }

    protected boolean checkAnswer(Editable e){
        String guess = e.toString().toLowerCase();

        if(answers.contains(guess)){
            switch(answers.indexOf(guess)){
                case 0:
                    mAnswer1.setFocusable(false);
                    mAnswer1.setBackgroundColor(getResources().getColor(R.color.correct));
                    return true;
                case 1:
                    mAnswer2.setFocusable(false);
                    mAnswer2.setBackgroundColor(getResources().getColor(R.color.correct));
                    return true;
                case 2:
                    mAnswer3.setFocusable(false);
                    mAnswer3.setBackgroundColor(getResources().getColor(R.color.correct));
                    return true;
                case 3:
                    mAnswer4.setFocusable(false);
                    mAnswer4.setBackgroundColor(getResources().getColor(R.color.correct));
                    return true;
            }
        }

        return false;
    }

    private class TextChangeHandler implements TextWatcher{
        public void afterTextChanged(Editable e){
            checkAnswer(e);
        }

        public void beforeTextChanged(CharSequence cs, int start, int count, int after){}

        public void onTextChanged(CharSequence cs, int start, int count, int after){}
    }
}
