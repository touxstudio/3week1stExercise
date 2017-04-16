package org.coursera.view;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import org.coursera.adapter.PetAdapter;
import org.coursera.mypentagram.R;
import org.coursera.pojo.Pets;
import org.coursera.pojo.SharedPrefsUsers;
import org.coursera.pojo.Users;
import org.coursera.presentator.IRecyclerViewFragmentPresenter;
import org.coursera.presentator.RecyclerViewRecyclerViewFragmentPresenterPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragmentView extends Fragment implements IRecyclerViewFragmentView {


    ArrayList<Pets> pets;
    private RecyclerView petList;
    private ImageView profile;
    private IRecyclerViewFragmentPresenter presenter;
    private TextView tvName;
    public FavFragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPrefsUsers sharedPrefsUsers = new SharedPrefsUsers();
        String Id = sharedPrefsUsers.getSharedSingleParam(this.getResources().getString(R.string.KEY_USERID_NUMERIC));
        String userName = sharedPrefsUsers.getSharedSingleParam(this.getResources().getString(R.string.KEY_USERID_USERNAME));
        String profilePicture = sharedPrefsUsers.getSharedSingleParam(this.getResources().getString(R.string.KEY_USER_PROFILE_PICTURE));


        View v = inflater.inflate(R.layout.fragment_fav, container, false);


        petList = (RecyclerView) v.findViewById(R.id.rvFavPets);
        presenter = new RecyclerViewRecyclerViewFragmentPresenterPresenter(this, getContext());

        RecyclerViewHeader header = (RecyclerViewHeader) v.findViewById(R.id.header);
        tvName = (TextView) v.findViewById(R.id.tvNameHeader);
        tvName.setText(userName);

        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.circularImageView);
        Picasso.with(getActivity()).load(profilePicture)
                .placeholder(R.drawable.image1)
                .into(circularImageView);

        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);
        header.attachTo(petList);

        arrayInit();
        adapterInit();


        // Inflate the layout for this fragment
        return v;
    }


    public void adapterInit() {
        PetAdapter adapter = new PetAdapter(pets, getActivity());
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

    @Override
    public void generateLinearLayoutVertical() {

    }

    @Override
    public void generateGridLayoutVertical() {

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
}
