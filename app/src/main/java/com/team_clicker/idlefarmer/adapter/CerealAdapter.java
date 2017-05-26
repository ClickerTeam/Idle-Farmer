package com.team_clicker.idlefarmer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
            viewHolder.yield = (TextView) convertView.findViewById(R.id.element_liste_cereals_value_yield);
            viewHolder.level = (TextView) convertView.findViewById(R.id.element_liste_cereals_level);
            viewHolder.name = (TextView) convertView.findViewById(R.id.element_liste_cereals_name);
            viewHolder.price = (TextView) convertView.findViewById(R.id.element_liste_cereals_price);
            convertView.setTag(viewHolder);
        }

        Cereal cereal = getItem(position);

        viewHolder.price.setText(cereal.getCurrentPrice()+"$");
        viewHolder.level.setText(""+cereal.getLevel());
        viewHolder.name.setText(cereal.getName());
        viewHolder.yield.setText(""+cereal.getCurrentYield());

        return convertView;
    }


    private class CerealsViewHolder{
        public TextView price;
        public TextView name;
        public TextView level;
        public TextView yield;
    }
}
