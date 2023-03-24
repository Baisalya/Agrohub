package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class addtask extends AppCompatActivity {
    //private ListView listView;
    private TextView emptyView;
   // private ArrayAdapter<String> adapter;
    private RecyclerView remindersRecyclerView;
    private ReminderAdapter reminderAdapter;
    private List<Reminder> reminderList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
      //  RecyclerView recyclerView = findViewById(R.id.tasklist);
        remindersRecyclerView = findViewById(R.id.reminders_recyclerview);
        reminderAdapter = new ReminderAdapter(reminderList);
        remindersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        remindersRecyclerView.setAdapter(reminderAdapter);
  /*      listView = findViewById(R.id.tasklist);
        emptyView=findViewById(R.id.empty_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        if (adapter.getCount() == 0) {
            // Show "No projects available" message
             TextView emptyView = new TextView(this);
            // emptyView.setText("No projects available");
           // emptyView.setText("nothing");
            ((ViewGroup)listView.getParent()).addView(emptyView);
            listView.setEmptyView(emptyView);
            listView.setVisibility(View.INVISIBLE);
        }

        Intent intent = getIntent();
        String projTitle = intent.getStringExtra("projTitle");
        String projDesc = intent.getStringExtra("projDesc");
        if (projTitle != null && projDesc != null) {
            listView.setVisibility(View.VISIBLE);
            String project = projTitle + " " + projDesc;
            adapter.add(project);

            // Remove "No projects available" message if it exists
            if (adapter.getCount() > 0) {
                //emptyView.setVisibility(View.INVISIBLE);
               View emptyView = listView.getEmptyView();
                if (emptyView != null) {
                    ((ViewGroup)listView.getParent()).removeView(emptyView);
                    listView.setEmptyView(null);
                }
            }
        }
*/
    }
}