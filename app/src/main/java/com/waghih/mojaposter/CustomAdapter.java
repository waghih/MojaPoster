//AHMAD FAROOQ BIN EZHAR
//1226461
//ASSIGNMENT 7

package com.waghih.mojaposter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by farooq on 5/10/2015.
 */
public class CustomAdapter extends BaseAdapter {
    public Context ctx;
    public List<Item> itemList;
    public CustomAdapter(Context ctx, List<Item> itemList) {
            this.ctx = ctx;
            this.itemList = itemList;
        }
        @Override
        public int getCount() {
            return itemList == null ? 0 : itemList.size();
        }
        @Override
        public Object getItem(int pos) {
            return itemList == null ? null : itemList.get(pos);
        }
        @Override
        public long getItemId(int pos) {
            return itemList == null ? 0 : itemList.get(pos).hashCode();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            TextHolder th = null;
            if (v == null) {
                LayoutInflater lInf = (LayoutInflater)
                        ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = lInf.inflate(R.layout.item_layout, null);
                TextView id_View = (TextView) v.findViewById(R.id.posterID);
                TextView title_View = (TextView) v.findViewById(R.id.posterTitle);
                TextView author_View = (TextView) v.findViewById(R.id.posterAuthor);
                TextView email_View = (TextView) v.findViewById(R.id.posterEmail);
                th = new TextHolder();
                th.id_View = id_View;
                th.title_View = title_View;
                th.author_View = author_View;
                th.email_View = email_View;
                v.setTag(th);
            }
            else
                th = (TextHolder) v.getTag();
                th.id_View.setText(itemList.get(position).posterID);
                th.title_View.setText(itemList.get(position).posterTitle);
                th.author_View.setText(itemList.get(position).posterAuthor);
                th.email_View.setText(itemList.get(position).posterEmail);
        return v;
    }
    static class TextHolder {
        TextView id_View;
        TextView title_View;
        TextView author_View;
        TextView email_View;
    }
}
