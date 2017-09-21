package com.cryptex.raman.snu_exams2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by raman on 21/7/17.
 */

public class customAdapter2 extends ArrayAdapter<String> {

    public customAdapter2(@NonNull Context context, @LayoutRes String[] years) {
        super(context,R.layout.custom_rows, years);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflator = LayoutInflater.from(getContext());
        View customView = inflator.inflate(R.layout.custom_rows, parent, false);
        String year = getItem(position);
        TextView text = (TextView)customView.findViewById(R.id.textView);
        text.setText(year);
        text.setTextColor(Color.WHITE);

        return customView;

    }
}
