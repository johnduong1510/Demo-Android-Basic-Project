package com.duongvyluan.newnote.Schedule.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.duongvyluan.newnote.R;
import com.duongvyluan.newnote.Schedule.presenter.PresenterSchedule;

/**
 * Created by JohnDuong on 28-Aug-17.
 */

public class ScheduleFragment extends android.support.v4.app.Fragment implements ViewSchedule {

    RecyclerView recyclerView;
    PresenterSchedule presenterSchedule;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View Root=inflater.inflate(R.layout.fragment_schedule,container,false);
        recyclerView=(RecyclerView)Root.findViewById(R.id.recyclerview_fragment_schedule);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return Root;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenterSchedule=new PresenterSchedule(this);
    }

    @Override
    public void onInsertDataSuccess() {

    }

    @Override
    public void onInsertDataFailure() {

    }

    @Override
    public void LoadSchedules() {

    }
}
