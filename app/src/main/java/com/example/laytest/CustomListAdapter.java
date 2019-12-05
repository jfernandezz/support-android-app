package com.example.laytest;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import entity.Company;

public class CustomListAdapter extends ArrayAdapter{

    private List<Company> dataList;
    private Context mContext;
    private int layoutResourceId;

    private ListFilter listFilter = new ListFilter();
    private List<Company> dataListAllItems;



    public CustomListAdapter(Context context, int layoutResourceId, List<Company> storeDataLst) {
        super(context, layoutResourceId, storeDataLst);
        dataList = storeDataLst;
        mContext = context;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Company getItem(int position) {
        Log.d("CustomListAdapter", dataList.get(position).getCompanyName());
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        try{

            /*
             * The convertView argument is essentially a "ScrapView" as described is Lucas post
             * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
             * It will have a non-null value when ListView is asking you recycle the row layout.
             * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
             */
            if(convertView==null){
                // inflate the layout
               // LayoutInflater inflater = ((TicketCreationActivity) mContext).getLayoutInflater();
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(layoutResourceId, parent, false);
            }

            // object item based on the position
            Company objectItem = getItem(position);

            // get the TextView and then set the text (item name) and tag (item ID) values
            TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
            textViewItem.setText(objectItem.getCompanyName());

            // in case you want to add some style, you can do something like:
           // textViewItem.setBackgroundColor(Color.CYAN);

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;

    }

    @NonNull
    @Override
    public Filter getFilter() {
        return listFilter;
    }

    public class ListFilter extends Filter {
        private Object lock = new Object();

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Company)resultValue).getCompanyName().toString();
        }

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();
            if (dataListAllItems == null) {
                synchronized (lock) {
                    dataListAllItems = new ArrayList<Company>(dataList);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                synchronized (lock) {
                    results.values = dataListAllItems;
                    results.count = dataListAllItems.size();
                }
            } else {
                final String searchStrLowerCase = prefix.toString().toLowerCase();

                List<Company> matchValues = new ArrayList<Company>();

                for (Company dataItem : dataListAllItems) {
                    if (dataItem.getCompanyName().toLowerCase().contains(searchStrLowerCase)) {
                        matchValues.add(dataItem);
                    }
                }

                results.values = matchValues;
                results.count = matchValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.values != null) {
                dataList = (ArrayList<Company>)results.values;
            } else {
                dataList = null;
            }
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

    }
}