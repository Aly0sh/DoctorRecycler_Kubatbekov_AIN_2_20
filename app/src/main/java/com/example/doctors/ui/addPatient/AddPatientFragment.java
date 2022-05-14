package com.example.doctors.ui.addPatient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.doctors.databinding.FragmentAddPatientBinding;
import com.example.doctors.ui.doctors.DoctorsViewModel;


public class AddPatientFragment extends Fragment {

    private FragmentAddPatientBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DoctorsViewModel doctorsViewModel =
                new ViewModelProvider(this).get(DoctorsViewModel.class);

        binding = FragmentAddPatientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}