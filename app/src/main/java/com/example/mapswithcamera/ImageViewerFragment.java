package com.example.mapswithcamera;

import android.content.Context;
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



public class ImageViewerFragment extends Fragment {

    private String photoPath;
    private String ID;
    private String markerTitle;

    private OnMarkerDeleteListener listener;


    public ImageViewerFragment(String path, String name, String dbID) {
        photoPath = path;
        markerTitle = name;
        ID = dbID;
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

    public interface OnMarkerDeleteListener {
        public void onMarkerToBeDeleted(String markerName, String dbID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMarkerDeleteListener) {
            listener = (OnMarkerDeleteListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement ImageViewerFragment.OnMarkerDeleteListener");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.option_delete_fragment:
                //Delete the note
                listener.onMarkerToBeDeleted(markerTitle, ID);
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}