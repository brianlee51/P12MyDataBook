package sg.edu.rp.c346.p12_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ArrayAdapterClass extends ArrayAdapter<String> {
    private Context context;
    private String[] value;
    ImageView iv;
    TextView tv;

    public ArrayAdapterClass(Context context, int resource, String[] values) {
        super(context, resource, values);
        value = values;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        iv = rowView.findViewById(R.id.iv);
        tv = rowView.findViewById(R.id.tv);
        tv.setText(value[position]);
        String cat =  value[position];

        if (cat.startsWith("Bio")) {
            iv.setImageResource(R.drawable.ic_info_black);
        } else if (cat.startsWith("Anni")) {
            iv.setImageResource(R.drawable.ic_today_black);
        } else if (cat.startsWith("About")){
            iv.setImageResource(R.drawable.ic_star_black);
        } else {
            iv.setImageResource(R.drawable.ic_edit_black);
        }
        return rowView;
    }
}
