package com.example.taskapp.ui.form;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.taskapp.R;
import com.example.taskapp.ui.notifications.MainActivity;

import java.util.ArrayList;


public class FormFragment extends Fragment {

    private EditText editText;
    private Button button;


    public FormFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText !=null) {
                    save();
                }
            }
        });
    }
    private void save() {
        String text = editText.getText().toString();
       Toast.makeText(getContext(),"операция успешно добавлена ",Toast.LENGTH_LONG).show();
       Bundle bundle = new Bundle();
        bundle.putString("text", text);
        getParentFragmentManager().setFragmentResult("rk_task",bundle);
        ((MainActivity) requireActivity()).closeFragment();
    }
}