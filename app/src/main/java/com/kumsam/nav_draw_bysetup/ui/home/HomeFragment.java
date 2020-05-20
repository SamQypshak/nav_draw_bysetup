package com.kumsam.nav_draw_bysetup.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.kumsam.nav_draw_bysetup.DetailActivity;
import com.kumsam.nav_draw_bysetup.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    String[]  countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
    ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        listView=root.findViewById(R.id.listv);
        // набор данных, которые свяжем со списком


            // создаем адаптер
          ArrayAdapter<String> adapter = new ArrayAdapter(getContext(),
                    android.R.layout.simple_list_item_1, countries);
          listView.setAdapter(adapter);
          homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String country=  countries[position];
              Intent intent=new Intent(getContext(), DetailActivity.class);
              intent.putExtra("country",country);
              getContext().startActivity(intent);

            }
        });
        return root;
    }
}
