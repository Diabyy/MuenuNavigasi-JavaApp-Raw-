package com.example.muenunavigasi;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import androidx.appcompat.widget.SearchView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private ArrayList<String> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        // Setup Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                R.string.open, R.string.close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Load HomeFragment sebagai tampilan default
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
            setTitle("Home");
        }

        // Setup NavigationView listener
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                loadFragment(new HomeFragment());
                setTitle("Home");
                drawerLayout.closeDrawers();
                return true;
            }

            if (id == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
                setTitle("Profile");
                drawerLayout.closeDrawers();
                return true;
            }

            if (id == R.id.nav_keluar) {
                drawerLayout.closeDrawers();
                new androidx.appcompat.app.AlertDialog.Builder(this)
                        .setTitle("Keluar")
                        .setMessage("Apakah kamu yakin ingin keluar?")
                        .setPositiveButton("Ya", (dialog, which) -> finishAffinity())
                        .setNegativeButton("Batal", null)
                        .show();
                return true;
            }

            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        if (searchItem != null) {
            SearchView searchView = (SearchView) searchItem.getActionView();
            if (searchView != null) {
                searchView.setQueryHint("Cari Sesuatu");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Toast.makeText(MainActivity.this,
                                "Mencari: " + query, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) return true;

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            showSettingsDialog();
            return true;
        }

        if (id == R.id.action_love) {
            String text = "AMBASUKKIIII";
            if (!favoriteList.contains(text)) {
                favoriteList.add(text);
                Toast.makeText(this, "Ditambahkan ke Favorites", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sudah ada di Favorites", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        if (id == R.id.action_info) {
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Tentang Aplikasi")
                    .setMessage("Aplikasi buatan anak jomok")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSettingsDialog() {
        String[] options = {"Light Mode", "Dark Mode"};
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Pilih Tema")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) {
                        androidx.appcompat.app.AppCompatDelegate
                                .setDefaultNightMode(androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO);
                    } else {
                        androidx.appcompat.app.AppCompatDelegate
                                .setDefaultNightMode(androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES);
                    }
                })
                .show();
    }
}