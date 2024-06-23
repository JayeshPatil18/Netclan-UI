package com.apps.netclanui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RefineActivity extends AppCompatActivity {

    private EditText editStatus;
    private SeekBar seekBarDistance;
    private TextView tvDistanceValue;
    private Button buttonSaveExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        editStatus = findViewById(R.id.edit_status);
        seekBarDistance = findViewById(R.id.seekbar_distance);
        buttonSaveExplore = findViewById(R.id.button_save_explore);

        // Handle button click
        buttonSaveExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = editStatus.getText().toString();
                int distance = seekBarDistance.getProgress() + 1;
                Toast.makeText(RefineActivity.this, "Status: " + status + "\nDistance: " + distance, Toast.LENGTH_SHORT).show();
            }
        });

        // Handle button selection in GridLayout
        GridLayout gridPurpose = findViewById(R.id.grid_purpose);
        for (int i = 0; i < gridPurpose.getChildCount(); i++) {
            final Button button = (Button) gridPurpose.getChildAt(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setSelected(!v.isSelected());
                }
            });
        }
    }
}