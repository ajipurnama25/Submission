package list.recycleview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import list.recycleview.DetailActivity;
import list.recycleview.model.Mobo;
import list.recycleview.R;

public class ListMoboAdapter extends RecyclerView.Adapter<ListMoboAdapter.ListViewHolder> {
    private ArrayList<Mobo> listMobo;
    private Context context;

    public ListMoboAdapter(ArrayList<Mobo> list, Context context) {
        this.context = context;
        this.listMobo = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_mobo, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Mobo mobo = listMobo.get(position);
        final String photo = mobo.getPhoto();
        final String name = mobo.getName();
        final String from = mobo.getFrom();
        final String price = mobo.getHarga();

        Glide.with(holder.itemView.getContext())
                .load(mobo.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(mobo.getName());
        holder.tvFrom.setText(mobo.getFrom());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, from, photo, price);
                Toast.makeText(holder.itemView.getContext(), listMobo.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void openDetailActivity(String... details) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("NAMES_KEY", details[0]);
        intent.putExtra("DES_KEY", details[1]);
        intent.putExtra("IMAGES_KEY", details[2]);
        intent.putExtra("PRICE_KEY", details[3]);

        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return listMobo.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;


        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.item_name);
            tvFrom = itemView.findViewById(R.id.item_from);
        }

    }


}
