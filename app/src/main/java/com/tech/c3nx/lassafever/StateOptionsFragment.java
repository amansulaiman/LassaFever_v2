package com.tech.c3nx.lassafever;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by aman on 1/28/16.
 */
public class StateOptionsFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.select_state)
                .setItems(R.array.state_options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            callHelp("+2348050595019");
                        } else if (which == 1) {
                            callHelp("+2348176662118");
                        } else if (which == 2) {
                            callHelp("+2348176671730");
                        } else {
                            callHelp("+2348176671730");
                        }
                    }
                })
                .setIcon(R.drawable.help2)
        ;

        return builder.create();
    }

    public void callHelp (String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
