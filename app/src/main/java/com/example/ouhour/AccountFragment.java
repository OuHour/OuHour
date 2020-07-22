package com.example.ouhour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

public class AccountFragment extends Fragment {

    private Object Menu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NavigationView nav = view.findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(navLis);

        getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragment_container, new HomeFragment()).commit();
    }

    private NavigationView.OnNavigationItemSelectedListener navLis = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.menu_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.menu_categories:
                    selectedFragment = new Categories();
                    break;
                case R.id.menu_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.menu_account:
                    selectedFragment = new AccountFragment();
                    break;

                getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragment_container, selectedFragment).commit();

                return true;
        }
    };


}
