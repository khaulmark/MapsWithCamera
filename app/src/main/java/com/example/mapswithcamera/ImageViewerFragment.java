package com.example.mapswithcamera;
import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ImageViewerFragment extends Fragment {

    String photoPath;
    String markerTitle;

    public ImageViewerFragment(String path, String title) {
        photoPath = path;
        markerTitle = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate (R.layout.image_viewer_fragment, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.mImage);
        TextView title = (TextView) rootView.findViewById(R.id.fragmentTitle);
        Bitmap imageBitmap = BitmapFactory.decodeFile(photoPath);
        image.setImageBitmap(imageBitmap);
        image.setRotation((float) 90.0);
        title.setText(markerTitle);
        return rootView;
    }
    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.option_exit_fragment:
                // do s.th.
                onDestroy();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}