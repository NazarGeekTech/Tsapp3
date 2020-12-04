package com.example.taskapp.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.taskapp.R;

import java.util.ArrayList;

public class BoardAdapter extends  RecyclerView.Adapter<BoardAdapter.ViewHolder>{

    private ArrayList<String> Timati = new ArrayList<>();
    private ArrayList<String> Doni = new ArrayList<>();
    private ArrayList<Integer> image = new ArrayList<>();
    private static final String ARG_PARAM1 = "PARAM1";
    private static final String ARG_PARAM2 = "PARAM2";

    public BoardAdapter() {
        Timati.add("через WI-FI");
        Timati.add("бесплатные подарки");
        Timati.add("Активный Веб Приложение ");

        Doni.add("приложение работает через WI-FI");
        Doni.add("приложение дарить подарки для пользователей ");
        Doni.add("хорошо провести время с друзьями");

        image.add(R.drawable.wifi);
        image.add(R.drawable.istockphoto);
        image.add(R.drawable.fit);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return Timati.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textDesc;
        private ImageView imageView;
        public ViewPager viewPager;
        public Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTimati);
            textDesc = itemView.findViewById(R.id.textDoni);
            imageView = itemView.findViewById(R.id.image1);
            viewPager = itemView.findViewById(R.id.viewPager);
            button = itemView.findViewById(R.id.button_btn);
        }

        public void bind(int position) {
            textTitle.setText(Timati.get(position));
            textDesc.setText(Doni.get(position));
            imageView.setImageResource(image.get(position));
        }
    }


}
