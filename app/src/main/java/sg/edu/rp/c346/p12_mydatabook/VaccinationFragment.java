package sg.edu.rp.c346.p12_mydatabook;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class VaccinationFragment extends Fragment {

    Button btnEdit;
    TextView tv;
    EditText et;
    String text = "";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);
        btnEdit = view.findViewById(R.id.btnEdit);
        tv = view.findViewById(R.id.tv);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View layoutView = inflater.inflate(R.layout.dialog_layout, null);
                et = layoutView.findViewById(R.id.et);
                et.setText(tv.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(layoutView).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text = et.getText().toString();
                                tv.setText(text);
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("Vac", text);
                                editor.commit();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String text = prefs.getString("Vac", "");
        tv.setText(text);
    }
}

