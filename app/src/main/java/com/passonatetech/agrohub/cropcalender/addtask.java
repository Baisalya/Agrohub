package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.passonatetech.agrohub.R;

public class addtask extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
        listView = findViewById(R.id.tasklist);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        if (adapter.getCount() == 0) {
            // Show "No projects available" message
            TextView emptyView = new TextView(this);
            emptyView.setText("No projects available");
            ((ViewGroup)listView.getParent()).addView(emptyView);
            listView.setEmptyView(emptyView);
        }

        Intent intent = getIntent();
        String projTitle = intent.getStringExtra("projTitle");
        String projDesc = intent.getStringExtra("projDesc");
        if (projTitle != null && projDesc != null) {
            String project = projTitle + " " + projDesc;
            adapter.add(project);

            // Remove "No projects available" message if it exists
            if (adapter.getCount() > 0) {
                View emptyView = listView.getEmptyView();
                if (emptyView != null) {
                    ((ViewGroup)listView.getParent()).removeView(emptyView);
                    listView.setEmptyView(null);
                }
            }
        }

    }
}