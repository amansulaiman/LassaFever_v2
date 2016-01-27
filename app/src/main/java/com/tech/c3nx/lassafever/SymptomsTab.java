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

        ListView listView = (ListView) rootView.findViewById(R.id.list_item_signs);
        listView.setAdapter(new PreventionsAdapter());

        return rootView;
    }

    public static List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("prevention 1");
        strings.add("prevention 2");
        strings.add("prevention 3");
        strings.add("prevention 4");
        strings.add("prevention 5");
        strings.add("prevention 6");
        strings.add("prevention 7");
        strings.add("prevention 8");
        strings.add("prevention 9");
        strings.add("prevention 10");

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
            if (position % 2 == 1) {
                imageView.setImageResource(R.drawable.places);
            } else {
                imageView.setImageResource(R.drawable.prevention);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.text_item_symptoms);
            textView.setText(mStrings.get(position));

            return convertView;
        }
    }
}
