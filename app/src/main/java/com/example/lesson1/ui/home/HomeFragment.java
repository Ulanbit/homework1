package com.example.lesson1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1.R;
import com.example.lesson1.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private Adapter adapter = new Adapter();
    private NavController controller;
    private FragmentHomeBinding binding;
    private List<HomeViewModel> list = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        initList();
    }





    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){



        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();return root;}

    private void initList() {
        List<HomeViewModel> list = new ArrayList<>();
        binding.btnAdd.setOnClickListener(view -> {

            controller.navigate(R.id.add);

        });


getActivity().getSupportFragmentManager().setFragmentResultListener("add", this, new FragmentResultListener() {
    @Override
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
          String text = result.getString("add");
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show();
      adapter.title(text)
      ;}




});
        binding.rvList.setAdapter(adapter);

    }


    @Override
    public void onDestroyView(){super.onDestroyView();binding = null;}}