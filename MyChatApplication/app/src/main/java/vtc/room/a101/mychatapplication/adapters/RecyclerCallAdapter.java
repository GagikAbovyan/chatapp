package vtc.room.a101.mychatapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.activity.LastActivity;
import vtc.room.a101.mychatapplication.activity.MessengerActivity;
import vtc.room.a101.mychatapplication.models.User;


public class RecyclerCallAdapter extends RecyclerView.Adapter<
        RecyclerCallAdapter.MyViewHolder> {

    private final Context context;


    public RecyclerCallAdapter(final Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_recycler_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        initMetaData(position, holder.imageView, holder.name, holder.status);
        holder.status.setTextColor(isColor(holder.status));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, LastActivity.class);
                MessengerActivity.flag = true;
                intent.putExtra(Constants.MY_KEY, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MessengerActivity.list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView name;
        TextView status;
        ImageButton call;
        MyViewHolder(View itemView) {
            super(itemView);
            imageView = (CircleImageView) itemView.findViewById(R.id.circle_image_item);
            name = (TextView) itemView.findViewById(R.id.name_item);
            status = (TextView) itemView.findViewById(R.id.status_item);
            call = (ImageButton) itemView.findViewById(R.id.call_button);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(Constants.MY_NUMBER));
                    context.startActivity(intent);
                }
            });

        }
    }

    private void initMetaData(final int position, final CircleImageView image, final TextView name,
                              final TextView status){
        User user = MessengerActivity.list.get(position);
        image.setImageResource(user.getImageId());
        name.setText(user.getName());
        status.setText(user.getStatus());
    }

    private int isColor(final TextView status){
        if (status.getText().toString().equals(Constants.IN_SEARCH)){
            return context.getResources().getColor(R.color.in_search_color);
        }
        if (status.getText().toString().equals(Constants.BELOVED)){
            return context.getResources().getColor(R.color.beloved_color);
        }
            return context.getResources().getColor(R.color.married_color);

    }

}
