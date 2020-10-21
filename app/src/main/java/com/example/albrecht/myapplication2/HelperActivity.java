package com.example.albrecht.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HelperActivity extends Activity implements View.OnClickListener{

    private Button button1;
    private TextView textfeld1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meinehelperactivity);

        // Button2:
        button1 =  (Button) this.findViewById(R.id.button);
        button1.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("Name");
        // Name in einem Textfeld ausgeben:
        textfeld1 = (TextView) this.findViewById(R.id.textView_name);
        Toast.makeText(this,"name " + name, Toast.LENGTH_LONG).show();
        textfeld1.setText(name);
    }

    public void onClick(View v)
    {
        // ----------------------------------------------
        Intent data = new Intent();
        data.putExtra("Rueckgabewert", "Alles zurueck!");
        // Beendet sich eine Unter-Aktivität, sollte zuvor mit der Methode
        // setResult() der Klasse Activity der Rückgabecode gesetzt werden
        // und über den 2ten Parameter die Rückgabedaten
        // Der Rückgabecode sollte im Normalfall Activity.RESULT:OK oder im
        // FAlle eines Abbruchs Activity.RESULT.CANCEL sein
        // man kann auch einen eigenen Rückgabewert (int) setzen
        setResult(RESULT_OK,data);
        super.finish();
        // Nun wird in der Mutteraktivität die Callbackmethode anActivityResult() aufgerufen.
    }

}
