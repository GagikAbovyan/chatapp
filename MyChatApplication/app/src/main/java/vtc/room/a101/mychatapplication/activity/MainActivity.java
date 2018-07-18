package vtc.room.a101.mychatapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.adapters.ImagePagerAdapter;
import vtc.room.a101.mychatapplication.models.ImagePagerMod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<ImagePagerMod> list = new ArrayList<>();
        initImages(list);
        final ImagePagerAdapter adapter = new ImagePagerAdapter(this, list);
        final ViewPager pager = (ViewPager) findViewById(R.id.pager_for_image);
        pager.setAdapter(adapter);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemod_red);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_airplanemode);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_airplanemode);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_airplanemode);
        pager.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                tabLayout.getTabAt(pager.getCurrentItem()).setIcon(R.drawable.ic_airplanemod_red);
                switch (pager.getCurrentItem()) {
                    case 0:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_airplanemode);
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_airplanemode);
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_airplanemode);
                        break;
                    case 3:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
                        break;
                    case 4:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_airplanemode);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_airplanemode);
                        break;
                }
            }
        });
    }

    private void initImages(final List<ImagePagerMod> list){
        list.add(new ImagePagerMod(R.drawable.elizabeth, Constants.ELIZABETH));
        list.add(new ImagePagerMod(R.drawable.scarlett, Constants.SCARLETT));
        list.add(new ImagePagerMod(R.drawable.mariam, Constants.MARIAM));
        list.add(new ImagePagerMod(R.drawable.gal, Constants.GAL));
        list.add(new ImagePagerMod(R.drawable.kira, Constants.KIRA));
    }
}
