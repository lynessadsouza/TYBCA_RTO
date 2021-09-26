


package com.example.peter.rto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

public class Main_screen extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mainGrid=(GridLayout)findViewById(R.id.mainGrid);

        //set event

        setSingleEvent (mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {

        for (int i=0;i<mainGrid.getChildCount();i++) {

            CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int I=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ( I==0){
                        Intent i = new Intent(Main_screen.this, registration_screen.class);
                        startActivity(i);
                    }
                    else if(I==1){
                        Intent i = new Intent(Main_screen.this,learners_option.class);
                        startActivity(i);
                    }
                    else if(I==2) {
                        Intent i = new Intent(Main_screen.this, emergency_screen.class);
                        startActivity(i);
                    }
                    else if(I==3) {
                        Intent i = new Intent(Main_screen.this, feedback.class);
                        startActivity(i);

                    }

                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu manu)
    {
        getMenuInflater().inflate(R.menu.main,manu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        int id=item.getItemId();
        if(id == R.id.id_profile){
            Intent intentprofile = new Intent(Main_screen.this,profile.class);
            startActivity(intentprofile);
            return true;
        }
        if(id == R.id.id_logout) {
            Intent intentlog = new Intent(Main_screen.this,login_screen.class);
            startActivity(intentlog);
            return true;
        }
        return true;


    }
}

