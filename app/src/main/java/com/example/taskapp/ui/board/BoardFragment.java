package com.example.taskapp.ui.board;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.taskapp.R;
import com.example.taskapp.ui.notifications.MainActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class BoardFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout22;
    BoardAdapter adapter;
    Button btn;

    ImageView imageView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);
        btn = view.findViewById(R.id.button_btn);
        imageView2 = view.findViewById(R.id.imageBibi);
        tabLayout22 = view.findViewById(R.id.tab_layout);

        initView();

        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();

                    }
                });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.
                        findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.navigation_home);
            }
        });
        btn.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() !=2) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }else {
                NavController navController = Navigation.
                        findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.navigation_home);
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
              //  Log.e("TAG", "onPageSelected: " + position);
               if (position > 1) {
                    btn.setText("пропустить");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



    }

    private void initView() {
        BoardAdapter adapter = new BoardAdapter();
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout22, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();
    }


}