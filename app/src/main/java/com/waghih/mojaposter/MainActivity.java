//AHMAD FAROOQ BIN EZHAR
//1226461
//ASSIGNMENT 7

package com.waghih.mojaposter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listView);
        List<Item> itemList = createItems();
        CustomAdapter ca = new CustomAdapter(this, itemList);
        lv.setAdapter(ca);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> aView, View view, int position, long id) {
                // We handle item click event
                TextView pos_Id = (TextView) view.findViewById(R.id.posterID);
                TextView pos_Title = (TextView) view.findViewById(R.id.posterTitle);
                TextView pos_Author = (TextView) view.findViewById(R.id.posterAuthor);
                TextView pos_Email = (TextView) view.findViewById(R.id.posterEmail);
                String idNo = (String) pos_Id.getText();
                String title = pos_Title.getText().toString();
                String author = pos_Author.getText().toString();
                String email = pos_Email.getText().toString();


                Intent intent = new Intent(MainActivity.this, EvaluateActivity.class);
                intent.putExtra("ID",idNo);
                intent.putExtra("Title",title);
                intent.putExtra("Author",author);
                intent.putExtra("Email",email);
                startActivity(intent);
            }
        });
    }

    private List<Item> createItems() {
        List<Item> itemList = new ArrayList<Item>();

        String[] title = {"Facebook","Apple iOs","Windows 10","Android","KICT","Twitter","Maal Hijrah"};
        String[] author = {"Dr. Ahmad","Dr. Abu","Dr. Ali","Dr. Abu","Dr. Ahmad","Dr. Ahmad","Dr. Ali"};
        String[] email= {"alfaruq93@gmail.com","waghih.co@gmail.com","aefl.stdio@gmail.com","waghih.co@gmail.com","alfaruq93@gmail.com","alfaruq93@gmail.com","aefl.stdio@gmail.com"};


        for (int i=0; i < title.length; i++) {
            Item it = new Item();
            it.posterID = Integer.toString(i+1);
            it.posterTitle = title[i];
            it.posterAuthor = author[i];
            it.posterEmail = email[i];
            itemList.add(it);
        }
        return itemList;
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
}
