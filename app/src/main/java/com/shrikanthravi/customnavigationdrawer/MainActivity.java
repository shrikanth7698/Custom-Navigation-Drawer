package com.shrikanthravi.customnavigationdrawer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView menuIV;
    CardView containerCV;
    RelativeLayout rootLayout;
    List<MenuItem> menuItemList;
    boolean navOpen=false;
    LinearLayout menuLL;
    int currentPos=0;
    TextView appBarTitleTV;
    RelativeLayout appBarRL;
    float centerX,centerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        menuIV = findViewById(R.id.menuIV);
        containerCV = findViewById(R.id.containerCV);
        rootLayout = findViewById(R.id.rootLayout);
        menuItemList = new ArrayList<>();
        menuLL = findViewById(R.id.menuLL);
        appBarTitleTV = findViewById(R.id.appBarTitleTV);
        appBarRL = findViewById(R.id.appBarRL);
        centerX = appBarTitleTV.getTranslationX();
        centerY = appBarTitleTV.getTranslationY();

        appBarTitleTV.setText("News");

        menuItemList.add(new MenuItem("News",R.drawable.news_bg,true));
        menuItemList.add(new MenuItem("Feed",R.drawable.feed_bg,false));
        menuItemList.add(new MenuItem("Messages",R.drawable.message_bg,false));
        menuItemList.add(new MenuItem("Music",R.drawable.music_bg,false));


        for(int i=0;i<menuItemList.size();i++){
            View view = LayoutInflater.from(this).inflate(R.layout.menu_row_item,null);

            TextView titleTV = view.findViewById(R.id.titleTV);
            TextView titleTV1 = view.findViewById(R.id.titleTV1);
            ImageView backgroundIV = view.findViewById(R.id.backgroundIV);
            CardView backgroundCV = view.findViewById(R.id.backgroundCV);
            final RelativeLayout rootRL = view.findViewById(R.id.rootRL);
            backgroundCV.setTag("cv"+i);
            System.out.println("Testing "+backgroundCV.getTag());
            titleTV.setTag("tv"+i);
            if(i>=1){
                backgroundCV.setVisibility(View.GONE);
                backgroundCV.animate().translationX(rootRL.getX()-backgroundCV.getWidth()).setDuration(1).start();
                titleTV.setVisibility(View.VISIBLE);
            }
            rootRL.setTag(i);
            rootRL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentPos!=Integer.valueOf(view.getTag().toString())){

                        //System.out.println("Testing 2 "+("cv"+currentPos));
                        final CardView backCV1 = (CardView) menuLL.findViewWithTag("cv"+currentPos);
                        final TextView title1 = (TextView) menuLL.findViewWithTag("tv"+currentPos);
                        backCV1.animate().translationX(rootRL.getX()-backCV1.getWidth()).setDuration(300).start();

                        currentPos=Integer.valueOf(view.getTag().toString());

                        appBarTitleTV.setText(menuItemList.get(currentPos).getTitle());

                        final CardView backCV = (CardView) menuLL.findViewWithTag("cv"+currentPos);
                        final TextView title = (TextView) menuLL.findViewWithTag("tv"+currentPos);
                        backCV.setVisibility(View.INVISIBLE);
                        System.out.println("Drawer Testing "+backCV.getTag());
                        backCV.animate().translationX(rootRL.getX()-backCV.getWidth()).setDuration(1).start();
                        backCV.animate().translationX(rootRL.getX()).setDuration(300).start();
                        backCV.setVisibility(View.VISIBLE);
                        title.setVisibility(View.GONE);

                        final Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                backCV1.setVisibility(View.GONE);
                                title1.setVisibility(View.VISIBLE);
                            }
                        },300);
                        //Close Navigation Drawer
                        appBarTitleTV.animate().translationX(centerX).start();

                        navOpen=false;
                        final int[] stateSet = {android.R.attr.state_checked * (navOpen ? 1 : -1)};
                        menuIV.setImageState(stateSet,true);
                        containerCV.animate().translationX(rootLayout.getX()).translationY(rootLayout.getY()).setDuration(500).start();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                containerCV.setCardElevation((float) 0);
                                containerCV.setRadius((float)0);
                            }
                        },500);
                    }
                    else{
                        //Close Navigation Drawer
                        appBarTitleTV.animate().translationX(centerX).start();
                        navOpen=false;
                        final int[] stateSet = {android.R.attr.state_checked * (navOpen ? 1 : -1)};
                        menuIV.setImageState(stateSet,true);
                        containerCV.animate().translationX(rootLayout.getX()).translationY(rootLayout.getY()).setDuration(500).start();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                containerCV.setCardElevation((float) 0);
                                containerCV.setRadius((float)0);
                            }
                        },500);
                    }
                }
            });
            backgroundIV.setImageDrawable(getDrawable(menuItemList.get(i).getImageId()));
            titleTV.setText(menuItemList.get(i).getTitle());
            titleTV1.setText(menuItemList.get(i).getTitle());
            menuLL.addView(view);
        }





        menuIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(navOpen){

                    navOpen=false;
                    final int[] stateSet = {android.R.attr.state_checked * (navOpen ? 1 : -1)};
                    menuIV.setImageState(stateSet,true);
                    appBarTitleTV.animate().translationX(centerX).start();
                    containerCV.animate().translationX(rootLayout.getX()).translationY(rootLayout.getY()).setDuration(500).start();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            containerCV.setCardElevation((float) 0);
                            containerCV.setRadius((float)0);
                        }
                    },500);
                }
                else {

                    navOpen=true;
                    final int[] stateSet = {android.R.attr.state_checked * (navOpen ? 1 : -1)};
                    menuIV.setImageState(stateSet,true);
                    containerCV.setCardElevation((float) 100.0);
                    containerCV.setRadius((float)60.0);
                    appBarTitleTV.animate().translationX(centerX+menuIV.getWidth()*2-appBarRL.getWidth()/2).start();
                    containerCV.animate().translationX(rootLayout.getX() +(rootLayout.getWidth() / 8)+ (rootLayout.getWidth() / 2) ).translationY(250).setDuration(500).start();
                }
            }
        });

    }
}
