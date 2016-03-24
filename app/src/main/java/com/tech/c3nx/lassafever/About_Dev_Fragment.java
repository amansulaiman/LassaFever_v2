package com.tech.c3nx.lassafever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 1/28/16.
 */
public class About_Dev_Fragment extends BaseAdapter {
    private Context mContext;
    public static final List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("Abdulrahman Sulaiman");
        strings.add("Luqman Olushi");
        strings.add("Yusuf Hassan");
        strings.add("Umar Abubakar Adakawa");
        strings.add("Atika Halliru Bashir");
        strings.add("Habeeb Adamu");
        strings.add("Umar Dahiru");
        strings.add("Yusuf Kabir Yusuf");
        strings.add("Abdussalam Muhammad");

        return strings;
    }

    public static final List<String> getRole() {
        List<String> strings = new ArrayList<>();
        strings.add("Developer I");
        strings.add("Developer II");
        strings.add("System Analyst I");
        strings.add("System Analyst II");
        strings.add("Researcher");
        strings.add("UI Designer I");
        strings.add("UI Designer II");
        strings.add("Observer I");
        strings.add("Observer II");

        return strings;
    }

    public About_Dev_Fragment(Context c) {
        mContext = c;
    }

        List<String> mStrings = getStrings();
        List<String> mroles = getRole();

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
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.list_developer, parent, false);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.dev_image);


            if (position == 0) {
                imageView.setImageResource(R.drawable.abu_abdallah);
            } else if (position == 1){
                imageView.setImageResource(R.drawable.luqman);
            }else if (position == 2){
                imageView.setImageResource(R.drawable.yusuf);
            }else if (position == 3){
                imageView.setImageResource(R.drawable.faruq);
            }else if (position == 4){
                imageView.setImageResource(R.drawable.ummu_abdallah);
            }else if (position == 5){
                imageView.setImageResource(R.drawable.habeeb);
            }else if (position == 6){
                imageView.setImageResource(R.drawable.engr);
            }else if (position == 7){
                imageView.setImageResource(R.drawable.junior);
            }else if (position == 8){
                imageView.setImageResource(R.drawable.tavez);
            }
            /*strings.add("Abdulrahman Sulaiman");

            https://www.facebook.com/olushi.lookmorn

            strings.add("Lukman Olisha");
            strings.add("Yusuf Hassan");
            strings.add("Umar Abubakar Adakawa");
            strings.add("Atika Halliru Bashir");
            strings.add("Habeeb Adamu");
            strings.add("Umar Dahiru");
            strings.add("Yusuf Kabir Yusuf");
            strings.add("Abdussalam Muhammad");*/

            TextView textView = (TextView) convertView.findViewById(R.id.dev_name);
            textView.setText(mStrings.get(position));

            TextView textView2 = (TextView) convertView.findViewById(R.id.dev_role);
            textView2.setText(mroles.get(position));

            return convertView;
        }


}
