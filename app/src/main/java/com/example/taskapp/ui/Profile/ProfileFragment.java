package com.example.taskapp.ui.Profile;


import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.taskapp.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    private CircleImageView image;


    public ProfileFragment() {

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.Profile);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLaunch.launch("image/*");


            }
        });
    }
    public ActivityResultLauncher<String >
    activityLaunch = registerForActivityResult(new
            ActivityResultContracts.GetContent(),
            result -> Glide.with(getContext()).load(result).into(image));
}