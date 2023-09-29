package com.nlp.tic_tac_poe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.nlp.tic_tac_poe.Study;

import java.io.Serializable;
import java.util.List;

public class TaskFragment extends Fragment {
    private static final String ARG_TASKS = "tasks";
    private List<Study> tasks;
    public static TaskFragment getInstance(List<Study> tasks){
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASKS, (Serializable) tasks);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
        {
            tasks = (List<Study>) getArguments().getSerializable(ARG_TASKS);

        }
    }
}
