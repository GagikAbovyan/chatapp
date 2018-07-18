package vtc.room.a101.mychatapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.activity.MessengerActivity;
import vtc.room.a101.mychatapplication.models.ImagePagerMod;

public class ImagePagerAdapter extends PagerAdapter {

    private final Context context;
    private final List<ImagePagerMod> list;

    public ImagePagerAdapter(final Context context, final List<ImagePagerMod> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
          container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final View view = LayoutInflater.from(context).
                inflate(R.layout.image_pager_item, container, false);
        final ImageView image = (ImageView) view.findViewById(R.id.image_pager);
        final TextView name = (TextView) view.findViewById(R.id.neme_pager_item);
        init(position, image, name);
        container.addView(view);

        final ImageButton closeButton = (ImageButton) view.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, MessengerActivity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }

    private void init(final int position, final ImageView image,
                      final TextView name){
        image.setImageResource(list.get(position).getImageId());
        name.setText(list.get(position).getName());
    }
}
