package com.example.albrecht.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener
{

    static final int REQUEST_CODE = 1;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meinehauptactivity);
        // Button1:
        button1 = (Button) this.findViewById(R.id.button);
        button1.setOnClickListener(this);


        // implicite Intent
      /* Uri webpage = Uri.parse("http://www.google.de");
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        startActivity(webIntent);*/
    }

    public void onClick(View v)
    {
        Toast.makeText(this, "onClick MainActivity", Toast.LENGTH_LONG).show();
        Log.e("log_tag", "Onclick 1 erfolgt");
        Intent i = new Intent(this, HelperActivity.class);
        // Daten werden an den Intent übergeben:
        i.putExtra("Name", "Schmidt");
        i.putExtra("Vorname", "Arnold");
        //  startActivity(i);
        //  Falls die aufrufende Aktivität Informationen zurückerhalten will,
        //  erfolgt der Aufruf der sub-activity mit "startActivityForResult":

        // der erste Parameter wird als Intent übergeben
        // der zweite Parameter sollte eine nicht negative Zahl sein und ist
        // der Anfragecode der Unteraktivität --> über diesen Code
        // kann der Callback identifiziert werden

        startActivityForResult(i, REQUEST_CODE);
        Toast.makeText(this, "Zweite Activity gestartet", Toast.LENGTH_LONG).show();

    }

    // die Android-Laufzeitumgebung  ruft diese Methode nach Beendigung der
    // aufgerufenen Aktivität auf und gibt den request code, mit dem die entsprechende
    // Activity gestartet wurde, zurück
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode, data);
        // der Wert für resultcodelautet:   RESULT_CANCELED / RESULT_OK
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE)
        {
            if (data.hasExtra("Rueckgabewert"))
            {
                Toast.makeText(this, data.getExtras().getString("Rueckgabewert"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
