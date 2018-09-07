package com.deonico.prkedelapan;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final TextView namamenu = findViewById(R.id.tvMenuResult);
        final ListView daftarmenu = findViewById(R.id.lvMenu);

        final String menu = getIntent().getStringExtra("menu");

        namamenu.setText("Radio "+menu);

        final String[] strBerita = {
                "Radio Online Berita 1",
                "Radio Online Berita 2"
        };

        final String[] strPop = {
                "Radio Online Pop 1",
                "Radio Online Pop 2"
        };

        final String[] strBeritaLink = {
                "https://d1u5p3l4wpay3k.cloudfront.net/dota2_gamepedia/c/c6/Meepo_spawn_01.mp3",
                "https://d1u5p3l4wpay3k.cloudfront.net/dota2_gamepedia/1/1c/Meepo_spawn_02.mp3"
        };

        final String[] strPopLink = {
                "https://d1u5p3l4wpay3k.cloudfront.net/dota2_gamepedia/4/41/Invo_spawn_02.mp3",
                "https://d1u5p3l4wpay3k.cloudfront.net/dota2_gamepedia/e/e3/Invo_spawn_03.mp3"
        };

        if(menu.equals("Berita")){
            ArrayAdapter adptrBerita = new ArrayAdapter(ResultActivity.this,
                    android.R.layout.simple_list_item_1,
                    strBerita);
            daftarmenu.setAdapter(adptrBerita);
        }else if (menu.equals("Pop")){
            ArrayAdapter adptrPop = new ArrayAdapter(ResultActivity.this,
                    android.R.layout.simple_list_item_1,
                    strPop);
            daftarmenu.setAdapter(adptrPop);
        }

        class CustomListAdapter extends BaseAdapter{

            @Override
            public int getCount() {
                return  strBerita.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                view = getLayoutInflater().inflate(R.layout.list_item, null);
                final TextView textListnya = view.findViewById(R.id.tvListnya);

                if(menu.equals("Berita")){
                    textListnya.setText(strBerita[i]);
                    daftarmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            try {
                                final MediaPlayer media = new MediaPlayer();
                                //media.setAudioStreamType(AudioManager.USE_DEFAULT_STREAM_TYPE);
                                media.setDataSource(strBeritaLink[i]);
                                media.prepareAsync();
                                //media.start();
                                media.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        media.start();
                                        Toast.makeText(ResultActivity.this, "Stream Cuy Berita", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                Toast.makeText(ResultActivity.this, "Bagooos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else if (menu.equals("Pop")){
                    textListnya.setText(strPop[i]);
                    daftarmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            try {
                                final MediaPlayer media = new MediaPlayer();
                                //media.setAudioStreamType(AudioManager.USE_DEFAULT_STREAM_TYPE);
                                media.setDataSource(strPopLink[i]);
                                media.prepareAsync();
                                //media.start();
                                media.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        media.start();
                                        Toast.makeText(ResultActivity.this, "Stream Cuy Pop", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                Toast.makeText(ResultActivity.this, "Bagooos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                return view;
            }
        }

        CustomListAdapter arrayList = new CustomListAdapter();
        daftarmenu.setAdapter(arrayList);

    }
}
