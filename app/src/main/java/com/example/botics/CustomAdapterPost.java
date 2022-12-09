package com.example.botics;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Entity.Post;


public class CustomAdapterPost extends BaseAdapter {
    private ArrayList<Post> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomAdapterPost(Context aContext, ArrayList<Post> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.design_list_post, null);
            holder = new ViewHolder();
            holder.first_name = (TextView) convertView.findViewById(R.id.textFirstName);
            holder.last_name = (TextView) convertView.findViewById(R.id.textLastName);
            holder.pseudo = (TextView) convertView.findViewById(R.id.textPseudo);
            holder.description = (TextView) convertView.findViewById(R.id.textDescription);
            holder.count_like = (TextView) convertView.findViewById(R.id.text_count_like);
            holder.count_comment = (TextView) convertView.findViewById(R.id.text_count_comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.v("position",""+position);
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(150,245,170));
        }

        Post post = this.listData.get(position);
        holder.first_name.setText(post.getFirst_name());
        holder.last_name.setText(post.getLast_name());
        holder.pseudo.setText(post.getPseudo());
        holder.description.setText(""+post.getDescription());
        holder.count_like.setText(""+post.getCount_like());
        holder.count_comment.setText(""+post.getCount_comment());

        return convertView;
    }

    static class ViewHolder {
        TextView first_name;
        TextView last_name;
        TextView pseudo;
        TextView description;
        TextView count_like;
        TextView count_comment;
    }

    public int getCount() {
        return (listData!=null)?listData.size():0;
    }
    public Object getItem(int position) {
        return listData.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}
