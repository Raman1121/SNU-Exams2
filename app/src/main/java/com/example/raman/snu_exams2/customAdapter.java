package com.example.raman.snu_exams2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import static android.R.attr.resource;

/**
 * Created by raman on 7/7/17.
 */

public class customAdapter extends ArrayAdapter<String>{
    public customAdapter(@NonNull Context context, String[] EngCourses) {
        super(context,R.layout.custom_rows, EngCourses);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflator = LayoutInflater.from(getContext());
        View customView = inflator.inflate(R.layout.custom_rows, parent, false);

        String singleCourse = getItem(position);
        TextView text = (TextView)customView.findViewById(R.id.textView);
        text.setTextColor(Color.WHITE);
        text.setText(singleCourse);

        return customView;

    }
}
