package appcontest.practice.beerforyou5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class TabRecommender extends Fragment {
    Context mContext;
    private Button recommenderBtnCountry;
    private Button recommenderBtnDegree;
    private Button recommenderBtnTaste;


    OnBtnSelectedListener mCallback;
    public interface OnBtnSelectedListener {
        public void onBtnSelected(int position, int type);
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
    }
    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab_recommender, null);
        recommenderBtnCountry = (Button) view.findViewById(R.id.recommenderBtnCountry);
        recommenderBtnDegree = (Button) view.findViewById(R.id.recommenderBtnDegree);
        recommenderBtnTaste = (Button) view.findViewById(R.id.recommenderBtnTaste);

        ////// Implementation of Country Activity of Beer For You  //////
        recommenderBtnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = -1;
                int type = 0;
                mCallback.onBtnSelected(position, type);
            }
        });

        ////// Implementation of Degree Activity of Beer For You  //////
        recommenderBtnDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = -1;
                int type = 1;
                mCallback.onBtnSelected(position, type);
            }
        });

        ////// Implementation of Taste Activity of Beer For You  //////
        recommenderBtnTaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = -1;
                int type = 2;
                mCallback.onBtnSelected(position, type);
            }
        });
        return view;
    }
}