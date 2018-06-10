package in.effcode.App.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.effcode.in.themes.R;

import java.util.List;

/**
 * Created by Radhey on 29/5/18.
 * Author Radhey
 */

public class PeoplesPhotosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface Callback {
        void onNextPageRequest();

        void onItemClick(Object object);
    }

    private static final int PHOTOS = 101;
    private static final int LOADER = 100;

    private List<Object> list;
    private Callback callback;

    public PeoplesPhotosAdapter(List<Object> objects, Callback callback) {
        this.list = objects;
        this.callback = callback;
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof String) {
            return PHOTOS;
        } else if (list.get(position) instanceof String) {
            return LOADER;
        }
        return -1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PHOTOS:
                viewHolder = new ViewHolderPeoplesPhotos(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false));
                break;
            case LOADER:
                viewHolder = new ViewHolderLoader(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_login, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.size() >= 10) {
            if (position == list.size() - 2) {
                callback.onNextPageRequest();
            }
        }

        switch (holder.getItemViewType()){
            case PHOTOS:
                try {
                    
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ViewHolderPeoplesPhotos extends RecyclerView.ViewHolder {
        public ViewHolderPeoplesPhotos(View view) {
            super(view);
        }

    }

    private class ViewHolderLoader extends RecyclerView.ViewHolder {
        View vloader;
        public ViewHolderLoader(View view) {
            super(view);
//            vloader = ButterKnife(R.id.btnLoginViaFacebook);
        }
    }
}
