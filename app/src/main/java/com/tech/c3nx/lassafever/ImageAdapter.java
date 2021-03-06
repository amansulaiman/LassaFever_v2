package com.tech.c3nx.lassafever;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by aman on 2/3/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageVie
    //  for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setPadding(16, 16, 16, 16);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        imageView.setAdjustViewBounds(true);
        //imageView.setImageAlpha(myLabelIds[position]);


        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.about, R.drawable.prevention,
            R.drawable.cure, R.drawable.faq,
            R.drawable.places, R.drawable.help2
    };

    private Integer[] myLabelIds = {
            R.string.action_about, R.string.action_about,
            R.string.action_about, R.string.action_about,
            R.string.action_about, R.string.action_about
    };
}
