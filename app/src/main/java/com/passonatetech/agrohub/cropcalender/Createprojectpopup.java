package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.passonatetech.agrohub.R;

public class Createprojectpopup{

    public static void showAlert(Context context, String message, Intent createproject,Intent selectexist) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View alertView = inflater.inflate(R.layout.activity_createprojectpopup, null);
        TextView messageText = alertView.findViewById(R.id.message_text);
        Button createprojectButton = alertView.findViewById(R.id.createnew_btn);
        Button selectExistingButton = alertView.findViewById(R.id.selectexisting_btn);
        Button cancelButton = alertView.findViewById(R.id.cancel_buttonn);
        messageText.setText(message);
        createprojectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(createproject);
            }
        });
        selectExistingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(selectexist);
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