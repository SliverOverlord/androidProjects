import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.turtle.deniofinalproject.InventoryItem;
import com.example.turtle.deniofinalproject.R;


import java.util.List;

public class InventoryAdapter  extends RecyclerView.Adapter<InventoryAdapter.MyViewHolder> {
    private List<InventoryItem> itemList;
    LinearLayout parentLayout;
    private Context IContext;

    Integer[] imageIDs = {
            R.drawable.bread,
            R.drawable.egs,
            R.drawable.milk,
            R.drawable.pasta,
            R.drawable.spices

    };



    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inventory_list_row, parent, false);
        //itemView.setOnClickListener(mOnClickListener);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        InventoryItem newItemP = itemList.get(position);
        holder.icon.setImageResource((imageIDs[position]));
        holder.itemNameLbl.setText(newItemP.getItemName());
        holder.itemOnhandLbl.setText(Integer.toString(newItemP.getQuantityOnHand()));

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemNameLbl, itemOnhandLbl;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.icon);
            itemNameLbl = view.findViewById(R.id.itemNamelbl);
            itemOnhandLbl = view.findViewById(R.id.itemNamelbl);

            parentLayout = view.findViewById(R.id.parent_layout);


        }
    }


}
