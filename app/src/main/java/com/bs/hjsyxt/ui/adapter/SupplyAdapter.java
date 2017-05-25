package com.bs.hjsyxt.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bs.hjsyxt.R;
import com.bs.hjsyxt.app.HjsApplication;
import com.bs.hjsyxt.bean.Supply;

import java.util.List;

/**
 * Created by wf on 2017/5/25.
 */

public class SupplyAdapter extends BaseAdapter{

    List<Supply> dataList;
    private LayoutInflater inflater;
    public SupplyAdapter(List<Supply> dataList,Context context ) {
        this.dataList = dataList;
        this.inflater=LayoutInflater.from(context);
    }

    public void setData(List<Supply> dataList){
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView ==null) {
            convertView=inflater.inflate(R.layout.item_supply_list,null);
        }
       TextView name =  (TextView)convertView.findViewById(R.id.item_tv_name);
        name.setText(dataList.get(position).name);
        return convertView;
    }
}
