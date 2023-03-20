package com.passonatetech.agrohub.widgets;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.passonatetech.agrohub.R;

public class AlertBox {
    public static void showAlert(Context context, String message, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View alertView = inflater.inflate(R.layout.activity_alert_box, null);
        TextView messageText = alertView.findViewById(R.id.message_text);
        Button submitButton = alertView.findViewById(R.id.submit_button);
        Button cancelButton = alertView.findViewById(R.id.cancel_buttonn);
        messageText.setText(message);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);

            }
        });

        builder.setView(alertView);

        AlertDialog alertDialog = builder.create();
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
