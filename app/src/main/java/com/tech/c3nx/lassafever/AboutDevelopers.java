package com.tech.c3nx.lassafever;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AboutDevelopers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listViewDevelopers);

        listView.setAdapter(new About_Dev_Fragment(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    openLinke("https://facebook.com/Amanmikrosoft");
                }else  if(position==1){
                    openLinke("https://www.facebook.com/olushi.lookmorn");
                }else  if(position==2){
                    openLinke("http://www.facebook.com/yusufhk");
                }else  if(position==3){
                    openLinke("http://www.facebook.com/omarabubakar.aladakawi");

                }else  if(position==4){
                    Snackbar.make(view, "No detail available", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else  if(position==5){
                    openLinke("http://www.facebook.com/habeeb.adam.921");

                }else  if(position==6) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_EMAIL, "umardahir@gmail.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Hi Umar Dahiru");
                    intent.putExtra(Intent.EXTRA_TEXT, "#Feedback of LASSA FEVER");
                    intent.putExtra(Intent.EXTRA_CC, "ceo@c3nx.com");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }else  if(position==7){
                    openLinke("http://www.facebook.com/siryusufkyusuf");

                }else  if(position == 8) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_EMAIL, "abdulssalamdanladi@yahoo.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Hi Abdussalam Danladi");
                    intent.putExtra(Intent.EXTRA_TEXT, "#Feedback of LASSA FEVER");
                    intent.putExtra(Intent.EXTRA_CC, "ceo@c3nx.com");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
            }
        });
    }

    public void openLinke(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
