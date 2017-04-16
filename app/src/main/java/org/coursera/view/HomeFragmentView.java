package org.coursera.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.coursera.adapter.PetFavAdapter;
import org.coursera.pojo.Pets;
import org.coursera.adapter.PetAdapter;
import org.coursera.mypentagram.R;
import org.coursera.pojo.Users;
import org.coursera.presentator.IRecyclerViewFragmentPresenter;
import org.coursera.presentator.RecyclerViewRecyclerViewFragmentPresenterPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragmentView extends Fragment implements IRecyclerViewFragmentView {

    private Context context;
    private ArrayList<Pets> pets;
    private ArrayList<Users> user;
    private RecyclerView petList;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        petList = (RecyclerView) v.findViewById(R.id.rvPets);

        presenter = new RecyclerViewRecyclerViewFragmentPresenterPresenter(this, getContext());
        arrayInit();
        return v;

    }



    @Override
    public void generateLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);
    }

    @Override
    public void generateGridLayoutVertical() {
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager llmGrid = new GridLayoutManager(getActivity(), 2);
        petList.setLayoutManager(llmGrid);
    }

    @Override
    public PetAdapter createAdapter(ArrayList<Pets> pets) {

        PetAdapter adapter = new PetAdapter(pets, getActivity());

        return adapter;

    }


    @Override
    public void initAdapter(PetAdapter adapter) {

        petList.setAdapter(adapter);

    }


    public void arrayInit() {

        pets = new ArrayList<Pets>();

        pets.add(new Pets("Tuka", "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/77/0f25406e2711e6b5ae85b51433cf6f/unam.png", 9));
        pets.add(new Pets("Bilma", "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/77/0f25406e2711e6b5ae85b51433cf6f/unam.png", 7));
        pets.add(new Pets("Urkia", "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/77/0f25406e2711e6b5ae85b51433cf6f/unam.png", 5));
        pets.add(new Pets("Yako", "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/77/0f25406e2711e6b5ae85b51433cf6f/unam.png", 4));
        pets.add(new Pets("Flow", "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/77/0f25406e2711e6b5ae85b51433cf6f/unam.png", 3));

    }

}
