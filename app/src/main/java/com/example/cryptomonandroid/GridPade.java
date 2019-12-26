package com.example.cryptomonandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Vector;


public abstract class GridPade extends Fragment {
    protected View root;
    protected TableLayout table;
    protected Vector<TableRow> rows;

    public GridPade(){
        rows = new Vector<TableRow>();
    }


    protected abstract void show_content();
    /*{
        table = root.findViewById(R.id.table_costs);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.leftMargin = 10;
        params.topMargin = 10;

        rows.clear();
        for(int i = 0; i < 10; i++){
            rows.add(new TableRow(this.table.getContext()));
            rows.elementAt(i).layout(10,5,3,5);
            //rows.elementAt(i)

            String s = "cell err er ert re ";

            TextView t = new TextView(this.rows.elementAt(i).getContext());
            t.setText( s + 2 * i);

            TextView tt = new TextView(this.rows.elementAt(i).getContext());
            tt.setText( s + (2 * i + 1));

            rows.elementAt(i).addView(t, params);
            rows.elementAt(i).addView(tt,params);

            table.addView(rows.elementAt(i));
        }

    }
     */
}


