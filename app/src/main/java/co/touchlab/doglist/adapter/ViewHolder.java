package co.touchlab.doglist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.touchlab.doglist.R;

/**
 * Created by Ankit Garg on 12/21/17.
 */

class ViewHolder extends RecyclerView.ViewHolder {
    TextView nameText;
    ImageView breedImage;

    ViewHolder(View itemView) {
        super(itemView);
        nameText = itemView.findViewById(R.id.name);
        breedImage = itemView.findViewById(R.id.image);
    }
}
