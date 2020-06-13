package list.recycleview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import list.recycleview.DetailActivity;
import list.recycleview.R;
import list.recycleview.model.Mobo;

public class GridMoboAdapter extends RecyclerView.Adapter<GridMoboAdapter.GridViewHolder> {
    private ArrayList<Mobo> listMobo;
    Context context;

    public GridMoboAdapter(ArrayList<Mobo> list, Context context) {
        this.context = context;
        this.listMobo = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_mobo, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        final Mobo mobo = listMobo.get(position);
        final String photo = mobo.getPhoto();
        final String name = mobo.getName();
        final String from = mobo.getFrom();
        final String price = mobo.getHarga();

        Glide.with(holder.itemView.getContext())
                .load(mobo.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, from, photo, price);
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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.item_name);
            tvFrom = itemView.findViewById(R.id.item_from);
        }
    }
}
