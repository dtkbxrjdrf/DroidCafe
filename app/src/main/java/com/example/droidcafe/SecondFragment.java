package com.example.droidcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.droidcafe.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show(view);
            }
        });

        binding.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }

    public void showDatePicker() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getChildFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        Toast.makeText(getActivity(), "Date: " + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void displayToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Show(View view){
        StringBuilder message = new StringBuilder();
        if (binding.checkBox.isChecked()){
            message.append(binding.checkBox.getText()).append(", ");
        }
        if (binding.checkBox2.isChecked()){
            message.append(binding.checkBox2.getText()).append(", ");
        }
        if (binding.checkBox3.isChecked()){
            message.append(binding.checkBox3.getText()).append(", ");
        }
        if (binding.checkBox4.isChecked()){
            message.append(binding.checkBox4.getText()).append(", ");
        }
        if (binding.checkBox5.isChecked()){
            message.append(binding.checkBox5.getText()).append(", ");
        }
        if (message.toString().endsWith(", ")) {
            message.setLength(message.length() - 2);
            message.append(".");
        }
        displayToast(message.toString());
    }
}