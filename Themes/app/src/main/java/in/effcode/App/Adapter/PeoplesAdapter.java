package in.effcode.App.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.effcode.in.themes.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import in.effcode.App.Model.Peoples;

/**
 * Created by Radhey on 29/5/18.
 * Author Radhey
 */

public class PeoplesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "PeoplesAdapter";

    public interface Callback {
        void onNextPageRequest();

        void onItemClick(Object object);
    }

    private static final int PEOPLES = 101;
    private static final int LOADER = 100;

    private List<Object> list;
    private Callback callback;
    private Context mContext;

    public PeoplesAdapter(Context context, List<Object> objects, Callback callback) {
        Log.d(TAG, "Come on peoples adapter" + "on create adapter ");
        mContext = context;
        this.list = objects;
        this.callback = callback;
    }


    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "Come on peoples adapter" + "get item called" + position);
        if (list.get(position) instanceof Peoples) {
            Log.d(TAG, "Come on peoples adapter" + "get item called" + PEOPLES);
            return PEOPLES;
        } else if (list.get(position) instanceof String) {
            Log.d(TAG, "Come on peoples adapter" + "get item called" + LOADER);
            return LOADER;
        }
        return -1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Come on peoples adapter" + "get item called" + PEOPLES);
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case PEOPLES:
                viewHolder = new ViewHolderPeoples(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_peoples, parent, false));
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

        Log.d(TAG, "Come on peoples adapter");
        switch (holder.getItemViewType()) {
            case PEOPLES:
                try {
                    final ViewHolderPeoples viewHolder = (ViewHolderPeoples) holder;
                    Peoples dto = (Peoples) list.get(position);

//                    Glide.clear(viewHolder.circleImageView);
//                    viewHolder.circleImageView.setImageResource(dto.getProfilePhoto());
                    viewHolder.tvName.setText(dto.getName());
                    if (dto.isFollowStatus()) {
                        viewHolder.ivStatusFollow.setImageResource(R.drawable.ic_circle_right_light_black);
                    } else {
                        viewHolder.ivStatusFollow.setImageResource(R.drawable.ic_circle_add_light_dark);
                    }
                    viewHolder.tvStatusFollow.setText("Follow");

//                    Glide.with(mContext).load(dto.getProfilePhoto()).clear(viewHolder.circleImageView)
                    Glide.with(mContext)
                            .load(dto.getProfilePhoto())
                            .override(200,200)
                            .centerCrop()
                            .into(viewHolder.circleImageView);

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderPeoples extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvFollowStatus)
        TextView tvStatusFollow;
        @BindView(R.id.ivFollowStatus)
        ImageView ivStatusFollow;
        @BindView(R.id.cImageViewProfile)
        CircleImageView circleImageView;

        public ViewHolderPeoples(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
