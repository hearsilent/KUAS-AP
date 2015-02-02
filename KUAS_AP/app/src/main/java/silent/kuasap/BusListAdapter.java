package silent.kuasap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BusListAdapter extends BaseAdapter {
    private List<BusList> mData = new ArrayList<>();
    private LayoutInflater mInflater;

    public static class ViewHolder {
        public TextView location;
        public TextView time;
        public TextView count;
    }

    public BusListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<BusList> items) {
        this.mData = items;
    }

    @Override
    public BusList getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
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
            convertView = mInflater.inflate(R.layout.bus_item, null);
            holder.location = (TextView) convertView.findViewById(R.id.location);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        if (mData.get(position).isReserve == -1)
            holder.location.setText("到" + mData.get(position).endStation + "，發車：");
        else
            holder.location.setText("√ 到" + mData.get(position).endStation + "，發車：");
        holder.time.setText(mData.get(position).runDateTime.split(" ")[1]);
        holder.count.setText("(" + mData.get(position).reserveCount + "/" + mData.get(position).limitCount + ")");
        return convertView;
    }
}

