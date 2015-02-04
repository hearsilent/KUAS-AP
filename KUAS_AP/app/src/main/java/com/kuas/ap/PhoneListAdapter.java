package com.kuas.ap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneListAdapter extends BaseAdapter {
    private List<PhoneList> mData = new ArrayList<>();
    private LayoutInflater mInflater;

    public static class ViewHolder {
        public TextView title;
        public TextView number;
        public TextView time;
    }


    public PhoneListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setData(List<PhoneList> items) {
        this.mData = items;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public PhoneList getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.phone_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.number = (TextView) convertView.findViewById(R.id.number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.title.setText(mData.get(position).title);
        holder.number.setText(mData.get(position).number);
        return convertView;
    }
}

