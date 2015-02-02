package silent.kuasap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotificationListAdapter extends BaseAdapter {
    private List<NotificationList> mData = new ArrayList<>();
    private LayoutInflater mInflater;

    public static class ViewHolder {
        public TextView title;
        public TextView from;
        public TextView time;
    }


    public NotificationListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setData(List<NotificationList> items) {
        this.mData = items;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public NotificationList getItem(int position) {
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
            convertView = mInflater.inflate(R.layout.notification_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.from = (TextView) convertView.findViewById(R.id.from);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        if (position < mData.size())
        {
            holder.title.setText(mData.get(position).title);
            holder.from.setText(mData.get(position).from);
            holder.time.setText(mData.get(position).time);
        }
        return convertView;
    }
}

