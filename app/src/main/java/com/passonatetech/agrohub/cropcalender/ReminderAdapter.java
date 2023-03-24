package com.passonatetech.agrohub.cropcalender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.model.Reminder;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    private List<Reminder> reminderList;

    public ReminderAdapter(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_item, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminder = reminderList.get(position);
        holder.nameTextView.setText(reminder.getName());
        holder.dateTextView.setText(reminder.getDate().toString());
        holder.timeTextView.setText(reminder.getTime().toString());
    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }

    public static class ReminderViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView timeTextView;

        public ReminderViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.reminder_name_textview);
            dateTextView = view.findViewById(R.id.reminder_date_textview);
            timeTextView = view.findViewById(R.id.reminder_time_textview);
        }
    }
}
