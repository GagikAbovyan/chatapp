package vtc.room.a101.mychatapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.activity.MessengerActivity;
import vtc.room.a101.mychatapplication.models.Message;
import vtc.room.a101.mychatapplication.models.User;


public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final List<Message> list;

    public MessageAdapter(Context context, List<Message> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater =
                (android.view.LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (viewType == 0){
            view = inflater.inflate(R.layout.chat_my_item, parent, false);
            return new MyMessageViewHolder(view);
        }
        view = inflater.inflate(R.layout.chat_bot_item, parent, false);
        return new BotMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Message message = MessengerActivity.list.get(Constants.position).getMessage(position);
        if (message.isMy()){
            ((MyMessageViewHolder)holder).initMessage(message, MessengerActivity.list.get(Constants.position));
        }else {
            ((BotMessageViewHolder)holder).initMessage(message, MessengerActivity.list.get(Constants.position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        final Message message = MessengerActivity.list.get(Constants.position).getMessage(position);
        if (message.isMy()){
            return 0;
        }
        return 1;
    }

    class MyMessageViewHolder extends RecyclerView.ViewHolder{


        TextView myText;
        public MyMessageViewHolder(View itemView) {
            super(itemView);
            myText = (TextView) itemView.findViewById(R.id.my_message);
        }

        void initMessage(final Message message, final User user){
            myText.setText(message.getMessage());
        }

    }

    class BotMessageViewHolder extends RecyclerView.ViewHolder{

        TextView botText;
        CircleImageView userImage;

        public BotMessageViewHolder(View itemView) {
            super(itemView);
            botText = (TextView) itemView.findViewById(R.id.bot_message);
            userImage = (CircleImageView) itemView.findViewById(R.id.bot_image);
        }

        void initMessage(final Message message, final User user){
            userImage.setImageResource(user.getImageId());
            botText.setText(message.getMessage());
        }
    }

}
