package com.nlp.tic_tac_poe;


import androidx.lifecycle.ViewModel;

import com.nlp.tic_tac_poe.adapters.StudyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {

    public StudyAdapter studyAdapter;
    private MyViewModel binding;


    public List<Study> studyList = new ArrayList<>();
    public MyViewModel(){
        setStudyList(studyList);
    }

    public void setStudyList(List<Study> list) {
        studyList = list;
    }
}



