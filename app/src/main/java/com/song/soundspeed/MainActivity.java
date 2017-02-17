package com.song.soundspeed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import nobleworks.libmpg.MP3Decoder;

public class MainActivity extends AppCompatActivity {

    private Button btnConveter;
    private String mp3file;
    private ShortBuffer samples = ShortBuffer.allocate(1024);
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();

        
    }

    private void initView() {

        btnConveter = (Button) findViewById(R.id.btn_conveter);
        btnConveter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MP3Decoder decoder = new MP3Decoder("/sdcard/old.mp3");
                FileOutputStream outputStream= null;
                FileChannel fileChannel = null;
                try {
                    File newFile = new File("/sdcard/ori.pcm");
                    if(!newFile.exists()){
                        newFile.createNewFile();
                    }
                    outputStream = new FileOutputStream(newFile);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    fileChannel =outputStream.getChannel();
                    while((num = decoder.readSamples(byteBuffer.asShortBuffer()))>0){
                        decoder.skipSamples(num);
                        byteBuffer.flip();
                        while(byteBuffer.hasRemaining()){
                            fileChannel.write(byteBuffer);
                        }
                    };
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fileChannel.close();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
