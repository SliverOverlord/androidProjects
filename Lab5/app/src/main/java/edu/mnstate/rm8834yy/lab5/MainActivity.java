package edu.mnstate.rm8834yy.lab5;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent contactsIntent = new Intent();
        contactsIntent.setAction(
                android.content.Intent.ACTION_VIEW);
        contactsIntent.setData(
                ContactsContract.Contacts.CONTENT_URI);
        startActivity(contactsIntent);

        Intent phoneIntent = new Intent();
        phoneIntent.setAction(
                android.content.Intent.ACTION_VIEW);
        phoneIntent.setData(
                Uri.parse("tel:7012223333")
        );
        startActivity(phoneIntent);

        Intent srchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        srchIntent.putExtra(SearchManager.QUERY,"Android");
        startActivity(srchIntent);

        String url = "www.mnstate.edu";
        if (!url.startsWith("https://") && !url.startsWith("https://"))
            url = "http://"+ url;

        Intent displaySiteIntent = new Intent();
        displaySiteIntent.setAction(
                android.content.Intent.ACTION_VIEW);
        displaySiteIntent.setData(Uri.parse(url));
        try{
            startActivity(displaySiteIntent);
        }
        catch(android.content.ActivityNotFoundException e)
        {
            Toast.makeText(getApplicationContext(),
                    "URL cannot be blank",
                    Toast.LENGTH_SHORT).show();
        }

        Intent voiceIntent = new Intent(Intent.ACTION_VOICE_COMMAND);
        startActivity(voiceIntent);




    }
}
