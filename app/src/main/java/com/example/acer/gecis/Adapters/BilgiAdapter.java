package com.example.acer.gecis.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.gecis.Main2Activity;
import com.example.acer.gecis.Models.Bilgi;
import com.example.acer.gecis.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter{
    List<Bilgi> bilgiList;
    Context context;
    Activity activity;

    public BilgiAdapter(List<Bilgi> bilgiList, Context context,Activity activity) {
        this.bilgiList = bilgiList;
        this.context = context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView PostId=convertView.findViewById(R.id.postId);
        TextView Id=convertView.findViewById(R.id.id);
        TextView Name=convertView.findViewById(R.id.name);
        TextView Email=convertView.findViewById(R.id.eMail);
        TextView Body=convertView.findViewById(R.id.body);
        LinearLayout layoutList=convertView.findViewById(R.id.layoutList);
        PostId.setText(""+bilgiList.get(position).getPostId());
        Id.setText(""+bilgiList.get(position).getId());
        Name.setText(bilgiList.get(position).getName());
        Email.setText(bilgiList.get(position).getEmail());
        Body.setText(bilgiList.get(position).getBody());
        final String post=""+bilgiList.get(position).getPostId();
        final String idm=""+bilgiList.get(position).getId();

        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Main2Activity.class);
                intent.putExtra("post_id",post);
                intent.putExtra("id",idm);
                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
