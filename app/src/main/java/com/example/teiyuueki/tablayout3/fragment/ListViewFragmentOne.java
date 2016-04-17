package com.example.teiyuueki.tablayout3.fragment;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.teiyuueki.tablayout3.MainActivity;
import com.example.teiyuueki.tablayout3.R;

import java.util.ArrayList;

/**
 * Created by teiyuueki on 2016/04/17.
 */
public class ListViewFragmentOne extends Fragment {

    private GridView gridView;
    ArrayList<Drawable> allDrawableImages = new ArrayList<>();
    private TypedArray allImages;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.listview_fragment_one, null);
        getAllWidgets(rootView);
        setAdapter();
        return rootView;
    }

    private void getAllWidgets(View view) {
        gridView = (GridView) view.findViewById(R.id.gridViewFragmentOne);
        allImages = getResources().obtainTypedArray(R.array.all_images);
    }

    private void setAdapter()
    {
        for (int i = 0; i < allImages.length(); i++) {
            allDrawableImages.add(allImages.getDrawable(i));
        }

        GridViewAdapter gridViewAdapter = new GridViewAdapter(MainActivity.getInstance(), allDrawableImages);
        gridView.setAdapter(gridViewAdapter);
    }
}
