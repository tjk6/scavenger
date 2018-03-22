package fourloops.scavenger;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Tyler on 3/20/2018.
 */

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.DataListViewHolder> {
    private ArrayList<ListItem> ContentList;

    public static class DataListViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView bodyView;

        public DataListViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.itemTitle);
            bodyView = itemView.findViewById(R.id.itemSubTitle);
        }
    }

    public DataListAdapter(ArrayList<ListItem> list){
        ContentList = list;
    }

    @Override
    public DataListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new DataListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataListViewHolder holder, int position) {
        ListItem currentItem = ContentList.get(position);
        holder.titleView.setText(currentItem.getItemTitle());
        holder.bodyView.setText(currentItem.getItemBody());
    }

    @Override
    public int getItemCount() {
        return ContentList.size();
    }
}
