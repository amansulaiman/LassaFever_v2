package com.tech.c3nx.lassafever;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getSimpleName();
    private static Map<Integer, String> menu_items;

    public MainActivityFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpMenuItems();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }

    public static List<Integer> getkeys(Map<Integer, String> map) {
        List<Integer> list = new ArrayList<>();
        for (Integer id : map.keySet()) {
            list.add(id);
        }
        return list;
    }



    public void setUpMenuItems() {
        menu_items = new LinkedHashMap<>();
        menu_items.put(R.drawable.about, "ABOUT LASSA");
        menu_items.put(R.drawable.sign, "SIGN & SYMPTOMS");
        menu_items.put(R.drawable.prevention, "PREVENTION");
        menu_items.put(R.drawable.cure, "DIAGNOSIS");
        menu_items.put(R.drawable.places, "AFFECTED AREA");
        menu_items.put(R.drawable.help2, "HELP");
    }

    public static class CustomAdapter extends BaseAdapter {
        Map<Integer, String> data = menu_items;
        List<Integer> keys = getkeys(data);

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                convertView = inflater.inflate(R.layout.list_item, parent, false);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.menu_icon);
            TextView textView = (TextView) convertView.findViewById(R.id.menu_text);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            imageView.setImageResource(keys.get(position));

            textView.setText(data.get(keys.get(position)));

            return convertView;
        }
    }
}
