package com.tech.c3nx.lassafever;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MainActivityFragment.CustomAdapter());
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    startLassaDetail();
                }else if(position==1){
                    startPrevention();
                }else if(position==2){
                    startFaq();
                }else if(position==3){
                    startCure();
                }else if(position==4){
                    startCases();
                }else if(position==5){
                    startHelp();
                }
                /*switch (position){
                    case 0 :
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    default:
                }*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_feedback) {
            String[] emails = {
                    "amansulaiman92@gmail.com"
            };

            String subject = "LASSA FEVER FEEDBACK";


            composeEmail(emails, subject);

        }else if (id == R.id.action_about_dev){

            Intent intent = new Intent(this, AboutDevelopers.class);
            startActivity(intent);
        } else if (id ==R.id.action_share){

            String sharemsg = "Hi, install Lassa Fever Application at http://play.google.com to keep yourself updated on Lassa Preventions tips";
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, sharemsg);
            startActivity(shareIntent);
        }

        return super.onOptionsItemSelected(item);
    }


    private void startLassaDetail(){
        Intent intent = new Intent(this, LassaDetail.class);
        startActivity(intent);
    }

    private void startPrevention(){
        Intent intent = new Intent(this, Sign_and_Symptoms.class);
        startActivity(intent);
    }

    private void startCure(){
        Intent intent = new Intent(this, Diagnosis.class);
        startActivity(intent);
    }

    private void startFaq(){
        Intent intent = new Intent(this, Prevention.class);
        startActivity(intent);
    }

    private void startCases(){
        Intent intent = new Intent(this, AffectedArea.class);
        startActivity(intent);
    }

    private void startHelp(){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "#Feedback of LASSA FEVER");
        intent.putExtra(Intent.EXTRA_CC, "ceo@c3nx.com");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
