package com.example.doctors.ui.addDoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.doctors.databinding.FragmentAddDoctorBinding;
import com.example.doctors.models.Person;
import com.example.doctors.ui.doctors.DoctorsViewModel;

import java.util.ArrayList;

public class AddDoctorFragment extends Fragment {

    private FragmentAddDoctorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DoctorsViewModel doctorsViewModel =
                new ViewModelProvider(this).get(DoctorsViewModel.class);

        binding = FragmentAddDoctorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        doctorsViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Person>>() {
            @Override
            public void onChanged(ArrayList<Person> people) {
                doctorsViewModel.setList(people);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}