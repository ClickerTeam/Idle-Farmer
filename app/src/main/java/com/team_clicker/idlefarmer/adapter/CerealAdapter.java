package com.team_clicker.idlefarmer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.team_clicker.idlefarmer.R;
import com.team_clicker.idlefarmer.model.Cereal;

import java.util.List;

/**
 * Created by Melto on 26/05/2017.
 */

public class CerealAdapter extends ArrayAdapter<Cereal> {

    public CerealAdapter(Context context, List<Cereal> cereals){
        super(context, 0, cereals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_element_cereals, parent, false);
        }

        CerealsViewHolder viewHolder  = (CerealsViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new CerealsViewHolder();
            viewHolder.yield = (TextView) convertView.findViewById(R.id.element_list_cereals_value_yield);
            viewHolder.level = (TextView) convertView.findViewById(R.id.element_list_cereals_level);
            viewHolder.name = (TextView) convertView.findViewById(R.id.element_list_cereals_name);
            viewHolder.price = (TextView) convertView.findViewById(R.id.element_list_cereals_price);

            convertView.setTag(viewHolder);
        }

        Cereal cereal = getItem(position);

        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.growthProgress);

        cereal.setProgressBar(progressBar);

        if(cereal.getCurrentPrice() > 999999){
            viewHolder.price.setText(String.format("%.2e",cereal.getCurrentPrice()) +"$");
        } else {
            viewHolder.price.setText(String.format("%.2f",cereal.getCurrentPrice()) +"$");
        }

        viewHolder.level.setText(""+cereal.getLevel());
        viewHolder.name.setText(cereal.getName());

        if(cereal.getCurrentYield() > 999999){
            viewHolder.yield.setText(String.format("%.2e", cereal.getCurrentYield()));
        } else {
            viewHolder.yield.setText(String.format("%.2f", cereal.getCurrentYield()));
        }

        return convertView;
    }


    private class CerealsViewHolder{
        public TextView price;
        public TextView name;
        public TextView level;
        public TextView yield;

    }
}
