package com.arindam.familylist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] relation;
    private final Integer[] imageId;
    public Firebase myFirebaseRef;
    TextView txtName;
    TextView txtRelation;
    ImageView imageView;
    int pos;

    public CustomList(Activity context, String[] name, String[] relation, Integer[] imageId) {
        super(context, R.layout.list_single, name);
        this.context = context;
        this.relation = relation;
        this.name = name;
        this.imageId = imageId;
        Firebase.setAndroidContext(getContext());
        myFirebaseRef = new Firebase("https://relationalmanac.firebaseio.com/");
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        pos=position;
        TextView txtname = (TextView)rowView.findViewById(R.id.txt1);
        TextView txtrelation = (TextView)rowView.findViewById(R.id.txt2);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.img);

        txtname.setText(name[position]);
        txtrelation.setText(relation[position]);
        imageView.setImageResource(imageId[position]);


        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtName.setText(String.valueOf(dataSnapshot.child("Relations").child(String.valueOf(pos)).child("Name").getValue()));
                txtRelation.setText(String.valueOf(dataSnapshot.child("Relations").child(String.valueOf(pos)).child("Relation").getValue()));
                Picasso.with(getContext()).load(String.valueOf(dataSnapshot.child("Relations").child(String.valueOf(pos)).child("Image").getValue())).into(imageView);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return rowView;
    }


        return rowView;
    }
}