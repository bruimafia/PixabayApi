package ru.bruimafia.rx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.bruimafia.rx.R;
import ru.bruimafia.rx.pojo.Image;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Image> images;
    private Context context;
    private OnReachEndListener onReachEndListener;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    public void addImages(List<Image> images) {
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public interface OnReachEndListener {
        void onReachEnd();
    }

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        if (images.size() >= 10 && position == images.size() - 3 && onReachEndListener != null)
            onReachEndListener.onReachEnd();

        Image image = images.get(position);

        holder.tvUser.setText(image.getUser());
        holder.tvFavorite.setText(String.valueOf(image.getFavorites()));
        holder.tvLike.setText(String.valueOf(image.getLikes()));

        if (!image.getUserImageURL().equals(""))
            Glide.with(context)
                    .load(image.getUserImageURL())
                    .thumbnail(Glide.with(context).load(R.drawable.loader2))
                    .fitCenter()
                    .into(holder.ivUserImg);

        if (!image.getLargeImageURL().equals(""))
            Glide.with(context)
                    .load(image.getLargeImageURL())
                    .thumbnail(Glide.with(context).load(R.drawable.loader2))
                    .fitCenter()
                    .into(holder.ivPicture);


        NamesAdapter namesAdapter = new NamesAdapter();
        namesAdapter.setNames(new ArrayList<>());
        holder.recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler.setAdapter(namesAdapter);
        namesAdapter.setNames(Arrays.asList(image.getTags().split(", ", -1)));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUser, tvFavorite, tvLike;
        private ImageView ivPicture;
        private CircleImageView ivUserImg;
        private RecyclerView recycler;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            ivPicture = itemView.findViewById(R.id.ivPicture);
            ivUserImg = itemView.findViewById(R.id.ivUserImg);
            tvFavorite = itemView.findViewById(R.id.tvFavorite);
            tvLike = itemView.findViewById(R.id.tvLike);
            recycler = itemView.findViewById(R.id.recycler);
        }

    }

}
