package edu.mnstate.rm8834yy.denioa5navview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (FrameLayout) findViewById(R.id.content);

        BottomNavigationView nav = (BottomNavigationView)
                findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, (new HomeFragment()), "fragment_home")
                .commit();
    }
    private BottomNavigationView
    .OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,
                                    (new HomeFragment()), "fragment_home")
                            .commit();
                    return true;
                case R.id.navigation_info:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,
                                    (new InfoFragment()), "fragment_info")
                            .commit();
                    return true;
                case R.id.navigation_internet:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,
                                    (new WebFragment()), "fragment_web")
                            .commit();
                    return true;
                case R.id.navigation_movies:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,
                                    (new MoviesFragment()), "fragment_movies")
                            .commit();
                    return true;
                case R.id.navigation_loan:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,
                                    (new LoanFragment()), "fragment_loan")
                            .commit();
                    return true;
            }

            return false;
        }
    };
}
