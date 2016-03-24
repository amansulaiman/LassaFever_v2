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


public class SignsTab extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.signs, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_item_signs);

        listView.setAdapter(new SymptomsAdapter());

        return rootView;
    }

    public static final List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("Fever");
        strings.add("Pain behind the chest wall");
        strings.add("Sore throat");
        strings.add("Diarrhoea");
        strings.add("Pink eye ");
        strings.add("Back pain");
        strings.add("Swelling of the face");
        strings.add("Protein in the urine");
        strings.add("Mucosal bleeding ");
        strings.add("Cough");
        strings.add("Stomach pain");
        strings.add("Vomiting");
        strings.add("Hearing loss");
        strings.add("Tremors");
        strings.add("Inflammation of the brain");

        return strings;
    }

    public class SymptomsAdapter extends BaseAdapter {
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
                convertView = inflater.inflate(R.layout.list_item_signs, parent, false);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_item_signs);

            if (position == 0) {
                imageView.setImageResource(R.drawable.fever);
            } else if (position == 1){
                imageView.setImageResource(R.drawable.painchest);
            }else if (position == 2){
                imageView.setImageResource(R.drawable.throat);
            }else if (position == 3){
                imageView.setImageResource(R.drawable.diarrhea);
            }else if (position == 4){
                imageView.setImageResource(R.drawable.conjunctivitis);
            }else if (position == 5){
                imageView.setImageResource(R.drawable.backpain);
            }else if (position == 6){
                imageView.setImageResource(R.drawable.swelling_face);
            }else if (position == 7){
                imageView.setImageResource(R.drawable.p_urine);
            }else if (position == 8){
                imageView.setImageResource(R.drawable.bleeding);
            }else if (position == 9){
                imageView.setImageResource(R.drawable.cough);
            }else if (position ==10){
                imageView.setImageResource(R.drawable.stomach_pain);
            }else if (position ==11){
                imageView.setImageResource(R.drawable.nausea);
            }else if (position ==12){
                imageView.setImageResource(R.drawable.hearing_loss);
            }else if (position ==13){
                imageView.setImageResource(R.drawable.tremors);
            }else if (position ==14){
                imageView.setImageResource(R.drawable.encephalitis);
            }
            /*strings.add("Fever");
            strings.add("Pain behind the chest wall");
            strings.add("Sore throat");
            strings.add("Diarrhea");
            strings.add("Pink eye ");
            strings.add("Back pain");
            strings.add("Swelling of the face");
            strings.add("Protein in the urine");
            strings.add("Mucosal bleeding ");
            strings.add("Cough");
            strings.add("Stomach pain");
            strings.add("Vomiting");
            strings.add("Hearing loss");
            strings.add("Tremors");
            strings.add("Inflammation of the brain)");*/

            TextView textView = (TextView) convertView.findViewById(R.id.text_item_signs);
            textView.setText(mStrings.get(position));

            return convertView;
        }
    }
}
