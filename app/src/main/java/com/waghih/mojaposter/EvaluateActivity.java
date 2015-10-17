//AHMAD FAROOQ BIN EZHAR
//1226461
//ASSIGNMENT 7

package com.waghih.mojaposter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class EvaluateActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private int progress1,progress2,progress3,progress4;
    private int extraMarks = 0;
    private SeekBar s1;
    private SeekBar s2;
    private SeekBar s3;
    private SeekBar s4;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        Bundle intent = getIntent().getExtras();

        String idNo = intent.getString("ID");
        String title = intent.getString("Title");
        String author = intent.getString("Author");

        TextView pId = (TextView) findViewById(R.id.posterI);
        TextView pTitle = (TextView) findViewById(R.id.posterT);
        TextView pAuthor = (TextView) findViewById(R.id.posterA);

        pId.setText("Poster ID: "+idNo);
        pTitle.setText("Title: "+title);
        pAuthor.setText("Author: "+author);

        s1 = (SeekBar) findViewById(R.id.presentBar);
        s2 = (SeekBar) findViewById(R.id.contentBar);
        s3 = (SeekBar) findViewById(R.id.contributionBar);
        s4 = (SeekBar) findViewById(R.id.rSignificanceBar);

        s1.setOnSeekBarChangeListener(this);
        s2.setOnSeekBarChangeListener(this);
        s3.setOnSeekBarChangeListener(this);
        s4.setOnSeekBarChangeListener(this);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch(seekBar.getId())
        {
            case R.id.presentBar:
                TextView marks1 = (TextView)findViewById(R.id.marksPresent);
                marks1.setText(Integer.toString(progress));
                progress1 = progress;
                break;
            case R.id.contentBar:
                TextView marks2 = (TextView)findViewById(R.id.marksContent);
                marks2.setText(Integer.toString(progress));
                progress2 = progress;
                break;
            case R.id.contributionBar:
                TextView marks3 = (TextView)findViewById(R.id.marksRcontribute);
                marks3.setText(Integer.toString(progress));
                progress3 = progress;
                break;
            case R.id.rSignificanceBar:
                TextView marks4 = (TextView)findViewById(R.id.marksRsignificance);
                marks4.setText(Integer.toString(progress));
                progress4 = progress;
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar){}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_evaluate, menu);
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

    public void onRadioSelected(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.radio1:
                if(checked)
                    extraMarks=5;
                break;
            case R.id.radio2:
                if(checked)
                    extraMarks=10;
                break;
            case R.id.radio3:
                if(checked)
                    extraMarks=15;
                break;
            case R.id.radio4:
                if(checked)
                    extraMarks=20;
                break;
        }
    }

    public void calculateMarks(View v){
        total = progress1 + progress2 + progress3 + progress4 + extraMarks;
        System.out.println(total);
        String totalMarks = Integer.toString(total);
        Intent in = new Intent(EvaluateActivity.this, ResultActivity.class);
        in.putExtra("Score",totalMarks);
        in.putExtra("Email",getIntent().getStringExtra("Email"));
        in.putExtra("ID",getIntent().getStringExtra("ID"));
        in.putExtra("Title",getIntent().getStringExtra("Title"));
        in.putExtra("Author",getIntent().getStringExtra("Author"));
        startActivity(in);
    }
}
