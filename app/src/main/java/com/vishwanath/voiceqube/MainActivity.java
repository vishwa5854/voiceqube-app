package com.vishwanath.voiceqube;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){
            System.out.println("Couldn't hide");
        }
        setContentView(R.layout.activity_main);
        final View view = this.getWindow().getDecorView();
        ImageView alexa = findViewById(R.id.imageView3);
        final ImageView disable = findViewById(R.id.imageView2);
        alexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.layout_bottom_sheet,
                                (LinearLayout) findViewById(R.id.bottomSheetContainer)
                        );
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
        disable.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(Data.disableStatus){
                    disable.setImageResource(R.drawable.red);
                    Data.disableStatus = false;
                }
                else {
                    disable.setImageResource(R.drawable.two);
                    Data.disableStatus = true;
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(getResources().getColor(R.color.black));
                v.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        TextView time = findViewById(R.id.time);
        Format f = new SimpleDateFormat("HH.mm");
        String strResult = f.format(new Date());
        time.setText(strResult);
    }

}