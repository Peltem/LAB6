package com.nlp.tic_tac_poe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.databinding.FragmentStudyListBinding;
import com.nlp.tic_tac_poe.dialogs.StudyInfoDialog;

import java.util.ArrayList;
import java.util.List;

public class StudyListFragments extends Fragment {
    public StudyAdapter studyAdapter;
    public static List<Study> studyList = new ArrayList<>();
    private FragmentStudyListBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStudyListBinding.inflate(inflater, container, false);
        return binding.getRoot();}
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        studyListInit();
        addStudyBtnInit();
        taskBtn();
    }
    private void studyListInit(){
        if (studyAdapter == null) {
            studyAdapter = new StudyAdapter(
                    getContext(),
                    R.layout.list_item,
                    studyList);
        }
        binding.studyList.setAdapter(studyAdapter);
        binding.studyList.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
//            requireActivity().getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.main_fragment, StudyInfoDialog.getInstance(studyAdapter.getItem(i)))
//                    .addToBackStack("info_dialog")
//                    .commit();
            StudyInfoDialog dialog = StudyInfoDialog.getInstance(studyAdapter.getItem(i), studyAdapter);
            dialog.show(getChildFragmentManager(), "study_info");
        });}
    private void addStudyBtnInit(){
        binding.addStudyBtn.setOnClickListener((view)->{

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new AddStudyFragments(),"add_study")
                    .addToBackStack(null)
                    .commit();
        });

    }
    private void taskBtn(){
        binding.taskBtn.setOnClickListener((view)->{

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, TaskFragment.getInstance(studyList),"task")
                    .addToBackStack("task")
                    .commit();
        });
}
    }
