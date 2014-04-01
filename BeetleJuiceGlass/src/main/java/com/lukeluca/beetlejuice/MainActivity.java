package com.lukeluca.beetlejuice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new BeetleJuiceFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class BeetleJuiceFragment extends Fragment {

        public BeetleJuiceFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Create a card with a full-screen background image.
            Card card2 = new Card(inflater.getContext());
            card2.setFootnote(getRandomQuote());
            card2.setImageLayout(Card.ImageLayout.FULL);
            card2.addImage(R.drawable.beetlejuice);
            // Don't call this if you're using TimelineManager
            View rootView = card2.toView();

            return rootView;
        }

        private String getRandomQuote() {
            String[] quotes = getResources().getStringArray(R.array.quotes);
            int randomIndex = new Random().nextInt(quotes.length);
            return quotes[randomIndex];
        }
    }
}
