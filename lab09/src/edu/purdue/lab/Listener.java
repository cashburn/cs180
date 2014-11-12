package edu.purdue.lab;

import android.view.View.*;
import android.view.View;
import java.util.*;
import android.os.*;
import android.widget.*;

public class Listener implements OnClickListener {
    public void onClick(View arg) {
        
        Button button = (Button) arg;
        String string = button.getText().toString();
        if (string.equals("Reset"))
            StartActivity.logIt("You done messed up!");
        if (string.equals("Time"))
            StartActivity.logIt("Time does not exist.");
        if (string.equals("Serial"))
            StartActivity.logIt("42");
    }
}
        