//AHMAD FAROOQ BIN EZHAR
//1226461
//ASSIGNMENT 7
package com.waghih.mojaposter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    public String mail;
    public String idNo;
    public String title;
    public String author;
    public String totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle intent = getIntent().getExtras();
        totalScore = intent.getString("Score")+"/100";
        mail = intent.getString("Email");
        idNo = intent.getString("ID");
        title = intent.getString("Title");
        author = intent.getString("Author");
        TextView rv = (TextView) findViewById(R.id.resultView);
        rv.setText(totalScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submitScore(View v){
        String subject = "Poster Scores";
        String message = "Poster ID: "+idNo+"\n"+"Title: "+title+"\n"+"Author: "+author+"\n"+"Overall Score: "+totalScore+"\n";
        Intent email = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        email.setType("message/rfc822");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(email, 0);
        boolean isIntentSafe = activities.size() > 0;
        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(email);
        }
    }
}
