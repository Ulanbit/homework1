package com.example.lesson1.ui.home;



import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1.MainActivity;
import com.example.lesson1.R;
import com.example.lesson1.databinding.ItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private ItemListBinding binding;
    private List<HomeViewModel> list = new ArrayList<>();
    public String[] mColors = {"#3F51B5","#FF9800","#009688","#673AB7"};

    public void title(String text){
        this.list.add(new HomeViewModel(text));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new AdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        binding.txtTitle.setText(list.get(position).getTitle());

        holder.itemView.setBackgroundColor(Color.parseColor(mColors[position % 4]));

        String text = binding.txtTitle.getText().toString();

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
        });




        holder.itemView.setOnLongClickListener(view -> {
            list.remove(holder.getAdapterPosition());
notifyItemRemoved(holder.getAdapterPosition());
            return false;
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding binding;
        public AdapterViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
        }
    }
}