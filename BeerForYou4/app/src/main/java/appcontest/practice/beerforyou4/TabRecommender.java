package appcontest.practice.beerforyou4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

@SuppressLint("ValidFragment")
public class TabRecommender extends Fragment {
    Context mContext;
    private Button recommenderRandomBtn;
    private Button recommenderBtn;
    private String storedUserRating;

    OnBtnSelectedListener mCallback;
    public interface OnBtnSelectedListener {
        public void onBtnSelected(int position);
    }

    public TabRecommender(Context context) {
        mContext = context;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnBtnSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnBtnSelectedListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Tab Recom", "On Resume ");
        // getting user rating information on resume
        SharedPreferences userRating = getActivity().getSharedPreferences(MainActivity.PREFS_USER, 0);
        //String storedUserRating = userRating.getString(position,"");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("Tab Recom", " On Pause ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d("Tab Recom", "On Create View ");
        View view = inflater.inflate(R.layout.activity_tab_recommender, null);
        Toast.makeText(getActivity().getBaseContext(), "추천검색 화면이 생성되었습니다.", Toast.LENGTH_SHORT).show();

        recommenderRandomBtn = (Button) view.findViewById(R.id.recommenderRandomBtn);
        recommenderBtn = (Button) view.findViewById(R.id.recommenderBtn);


        ////// Implementation of Random Selection of Beer For You  //////
        recommenderRandomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int numOfBeer = DataForTest.name_eng.length;
                int position = rand.nextInt(numOfBeer);
                mCallback.onBtnSelected(position);
            }
        });


        ////// Implementation of Recommender System of Beer For You  /////
        recommenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = 0;

                // TODO //
                // implement Colloborative Filtering


                mCallback.onBtnSelected(position);
            }
        });

        return view;
    }

}