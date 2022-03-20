package com.example.lesson1.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson1.R;
import com.example.lesson1.databinding.FragmentAddBinding;


public class Add extends Fragment {

  private FragmentAddBinding binding;
private NavController controller;
    public Add() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initKeep();
    }
    private void initKeep() {
        binding.btnKeep.setOnClickListener(v->{
            String add =  binding.etAdd.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("add",add);
            getActivity().getSupportFragmentManager().setFragmentResult("add",bundle);
//            getActivity().getSupportFragmentManager().popBackStack();
            controller = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_activity_main);
            controller.navigateUp();
        });

    }
}