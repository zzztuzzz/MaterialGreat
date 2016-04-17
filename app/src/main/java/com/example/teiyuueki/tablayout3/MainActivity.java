package com.example.teiyuueki.tablayout3;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.teiyuueki.tablayout3.fragment.ListViewFragmentOne;
import com.example.teiyuueki.tablayout3.fragment.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static MainActivity instance;
    private ViewPagerAdapter adapter;
    private ListViewFragmentOne fragmentOne;
    private ListViewFragmentOne fragmentTwo;
    private ListViewFragmentOne fragmentThree;
    private ListViewFragmentOne fragmentFour
            ;
//    private FragmentTwo fragmentTwo;

    private ViewPager viewPager;
    private TabLayout allTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        //mainActivity make instance to inflater gridview
        instance = this;

        //add  viewpager
//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
//
//        setSupportActionBar(mToolbar);
//        setupViewPager(mViewPager);
//        mTabLayout.setupWithViewPager(mViewPager);

        //new viewpager by   easy-way-to-create-tab-layout-in-android-with-viewpager-master-1

        getAllWidgets();
        setupViewPager();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.add(getResources().getString(R.string.first), getResources().getColor(R.color.whiteee));
//        adapter.add(getResources().getString(R.string.second), getResources().getColor(R.color.whiteee));
//        adapter.add(getResources().getString(R.string.third), getResources().getColor(R.color.whiteee));
//        adapter.add(getResources().getString(R.string.forth), getResources().getColor(R.color.whiteee));
//        viewPager.setAdapter(adapter);
//    }

    public static Context getInstance() {
        return instance;
    }

    public void getAllWidgets() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        allTabs = (TabLayout) findViewById(R.id.tabLayout);
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentOne = new ListViewFragmentOne();
        fragmentTwo = new ListViewFragmentOne();
        fragmentThree = new ListViewFragmentOne();
        fragmentFour = new ListViewFragmentOne();
//        fragmentTwo = new FragmentTwo();
        adapter.addFragment(fragmentOne, "Top");
        adapter.addFragment(fragmentTwo, "New");
        adapter.addFragment(fragmentThree, "Active");
        adapter.addFragment(fragmentFour, "Near");
        setViewPageAdapter();
    }

    private void setViewPageAdapter() {
        viewPager.setAdapter(adapter);
        allTabs.setupWithViewPager(viewPager);
    }

}
