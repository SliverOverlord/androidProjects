package com.example.turtle.deniofinalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout content_frame;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private SQLiteDatabase inventoryDb;
    private SQLiteDatabase shoppingListDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        content_frame = (FrameLayout) findViewById(R.id.content_frame);
        NavigationView nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onOptionsItemSelected(MenuItem item ) {
       if(toggle.onOptionsItemSelected(item)){
           return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private NavigationView
            .OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new HomeFragment()), "fragment_home")
                                .commit();
                    return true;
                case R.id.navigation_cookBook:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new CookBookFragment()), "fragment_cook_book")
                            .commit();
                    return true;
                case R.id.navigation_inventory:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new InventoryFragment()), "fragment_inventory")
                            .commit();
                    return true;
                case R.id.navigation_shoppingList:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new ShoppingListFragment()), "fragment_shopping_list")
                            .commit();
                    return true;
                case R.id.navigation_map:
                    //final Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?" + "saddr="+ latitude + "," + longitude + "&daddr=" + latitude + "," + longitude));
                    //intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
                    //startActivity(intent);

                    Intent map = new Intent(getApplicationContext(),MapsActivity.class);
                    startActivity(map);
                    return true;


            }

            return false;
        }
    };
}

