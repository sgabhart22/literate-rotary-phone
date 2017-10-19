package com.sgabhart.paddywhack;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * Created by Admin on 10/16/2017.
 */

public class PuzzleButton extends AppCompatButton{
    private Puzzle puzzle;

    public PuzzleButton (Context cx, Puzzle newCandy){
        super(cx);
        puzzle = newCandy;
    }

    public int getId(){
        return puzzle.getId();
    }
}
