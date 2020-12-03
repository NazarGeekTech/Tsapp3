package com.example.taskapp.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;

public class BoardAdapter {

    public class ViewHolder extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

        @NonNull
        @Override
        public BoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(position);

        }


        @Override
        public int getItemCount() {
            return titles.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
             private TextView textTitle;
             private TextView textDesc;


         public ViewHolder (@NonNull View itemView)   {
             super(itemView);
             textTitle = itemView.findViewById(R.id.textView);
             textDesc = itemView.findViewById(R.id.textView);
         }

            private void bind(int position) {
             textTitle.setText(titles.get(position));

            }



        }




    }
}
