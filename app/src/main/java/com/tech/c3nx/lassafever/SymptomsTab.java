package com.tech.c3nx.lassafever;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OlushiLuqman on 1/23/16.
 */

public class SymptomsTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.symptoms, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item_symptoms);
        listView.setAdapter(new PreventionsAdapter());

        return rootView;
    }

    public static final List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("Nausea");
        strings.add("Constipation");
        strings.add("Hepatitis");
        strings.add("Pericarditis");
        strings.add("Hypertension");
        strings.add("Hypotension");
        strings.add("Tachycardia");
        strings.add("Dyspnoea");
        strings.add("Pharyngitis");
        strings.add("Pleuritis");
        strings.add("Encephalitis");
        strings.add("Meningitis");
        strings.add("Seizures");

        return strings;
    }

    public class PreventionsAdapter extends BaseAdapter {
        List<String> mStrings = getStrings();

        @Override
        public int getCount() {
            return mStrings.size();
        }

        @Override
        public Object getItem(int position) {
            return mStrings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.list_item_symptoms, parent, false);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_item_symptoms);

            /*strings.add("Nausea");
            strings.add("Constipation");
            strings.add("Hepatitis");
            strings.add("Pericarditis");
            strings.add("Hypertension");
            strings.add("Hypotension");
            strings.add("Tachycardia");
            strings.add("Dyspnoea");
            strings.add("Pharyngitis");
            strings.add("Pleuritis");
            strings.add("Encephalitis");
            strings.add("Meningitis");
            strings.add("Seizures");*/

            if (position == 0) {
                imageView.setImageResource(R.drawable.nausea);
            } else if (position == 1){
                imageView.setImageResource(R.drawable.constipation);
            }else if (position == 2){
                imageView.setImageResource(R.drawable.hepatitis2);
            }else if (position == 3){
                imageView.setImageResource(R.drawable.pericarditis);
            }else if (position == 4){
                imageView.setImageResource(R.drawable.hypertension);
            }else if (position == 5){
                imageView.setImageResource(R.drawable.hypotension);
            }else if (position == 6){
                imageView.setImageResource(R.drawable.tachycardia);
            }else if (position == 7){
                imageView.setImageResource(R.drawable.dyspnoea);
            }else if (position == 8){
                imageView.setImageResource(R.drawable.pharyngitis);
            }else if (position == 9){
                imageView.setImageResource(R.drawable.pleuritis);
            }else if (position ==10){
                imageView.setImageResource(R.drawable.encephalitis);
            }else if (position ==11){
                imageView.setImageResource(R.drawable.meningitis);
            }else if (position ==12){
                imageView.setImageResource(R.drawable.seizures);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.text_item_symptoms);
            textView.setText(mStrings.get(position));

            return convertView;
        }
    }
}
