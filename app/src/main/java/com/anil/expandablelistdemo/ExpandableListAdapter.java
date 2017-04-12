package com.anandbose.expandablelistdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandbose on 09/06/15.
 */
public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;
    private static final String TAG = "Expand";

    private List<Item> data;
    private int prevPosition=-1;
    //    private int prevRemovedCount;
//    private int positionPosition;
    private int prevExpandadCount;
    private ListHeaderViewHolder preListViewHolder;
    //    private int prevdataSize;
//    private int clickedPosition;
    private Context context;

    public ExpandableListAdapter(List<Item> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView) {
                };
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Item item = data.get(position);
        Log.d("position", "" + position);
//        saveToPref(context,item);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
//                ((ListHeaderViewHolder) holder).headermain.setVisibility(View.GONE);
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);

                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }

                itemController.headermain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("position", "on click: " + position);
                        if(prevPosition!=-1 && !item.text.equalsIgnoreCase(data.get(prevPosition).text)) {
                            Item prevItem = data.get(prevPosition);
                            if (prevItem.invisibleChildren== null) {
                                prevItem.invisibleChildren = new ArrayList<Item>();
                                for (int k=0;k<prevExpandadCount;k++){
                                    prevItem.invisibleChildren.add(data.remove(prevPosition + 1));
                                }
                                Log.d("position", "data size before notifyItemRangeRemoved: " + data.size());

                                notifyItemRangeRemoved(prevPosition + 1, prevExpandadCount);
                                Log.d("position", "after notifyItemRangeRemoved: " + position);
                                Log.d("position", "data size after notifyItemRangeRemoved: " + data.size());

                                preListViewHolder.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                            }

                        }

//                        int pos = itemController.getAdapterPosition();
                        Item itemnew=data.get(itemController.getAdapterPosition());

//                        Item itemnew=getFromPref(context);
                        itemController.refferalItem = itemnew;
                        if (itemnew.invisibleChildren == null) {
                            itemnew.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                          int pos = data.indexOf(itemController.refferalItem);
//                            int pos =indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                itemnew.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
//                            int pos = data.indexOf(itemController.refferalItem);

//                            int pos = itemController.getAdapterPosition();

                            int pos =indexOf(itemController.refferalItem);

                            int index = pos + 1;
                            int count = 0;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                Log.d("position", "data size on adding item: " + data.size());

                                index++;
                                count++;
                            }
                            prevExpandadCount=count;
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                            prevPosition = pos;
                            preListViewHolder=itemController;

                        }



                    }
                });
                break;
            case CHILD:
                TextView itemTextView = (TextView) holder.itemView;
                itemTextView.setText(data.get(position).text);
                itemTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Hi, I am "+data.get(position).text, Toast.LENGTH_SHORT).show();
                    }
                });

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferalItem;
        public ViewGroup headermain;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            headermain = (ViewGroup) itemView.findViewById(R.id.headermain);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }

    public static class Item implements Serializable{
        public int type;
        public String text;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }
    }

    public int indexOf(Item refferalItem){

        for (int i = 0; i < data.size(); i++) {
            Item item = data.get(i);
            if(item.text.equalsIgnoreCase(refferalItem.text)) {
                return i;
            }


        }
        return 0;
    }

    private void saveToPref(Context mContext,Item item){
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);

        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(item); // myObject - instance of MyObject
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();
    }

    private Item getFromPref(Context mContext){
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);

        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Item obj = gson.fromJson(json, Item.class);
        return obj;
    }
}
