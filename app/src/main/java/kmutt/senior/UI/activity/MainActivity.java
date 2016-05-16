package kmutt.senior.UI.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import kmutt.senior.pet.R;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    private String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY"};

    private ListView monthsListView;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();
        TabHost.TabSpec spec1= host.newTabSpec("Tab 1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Tab 1", getResources().getDrawable(R.drawable.circle_bg3));
        host.addTab(spec1);

        TabHost.TabSpec spec2= host.newTabSpec("Tab 2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Tab 2", getResources().getDrawable(R.drawable.circle_bg3));
        host.addTab(spec2);

        TabHost.TabSpec spec3= host.newTabSpec("Tab 3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Tab 3", getResources().getDrawable(R.drawable.circle_bg3));
        host.addTab(spec3);
        ListView lisView1 = (ListView)findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthsArray);
        lisView1.setAdapter(arrayAdapter);


    }

    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);


        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this
                , drawerLayout
                , R.string.hello_world
                , R.string.hello_world
        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }


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
