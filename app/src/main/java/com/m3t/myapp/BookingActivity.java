package com.m3t.myapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingActivity extends AppCompatActivity {
    @BindView(R.id.spnStartPoint)
    Spinner spnStartPoint;
    @BindView(R.id.spnEndPoint)
    Spinner spnEndPoint;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.etTime)
    EditText etTime;
    @BindView(R.id.etStop)
    EditText etStop;
    private int numberOfStop = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ButterKnife.bind(this);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.pointArray, R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.pointArray, R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spnStartPoint.setAdapter(adapter1);
        spnEndPoint.setAdapter(adapter2);
    }

    @OnClick({R.id.etDate, R.id.etTime, R.id.etStop})
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance(); /** get the time */
        switch (view.getId()) {
            case R.id.etDate:
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                /** Launch Date picker dialog */
                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                etDate.setText(dayOfMonth + " tháng " + (monthOfYear + 1) + " " + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.etTime:

                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

                /** Launch Time Picker Dialog */
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                String AM_PM;
                                if (hourOfDay < 12) {
                                    AM_PM = "Sáng";
                                } else {
                                    AM_PM = "Chiều";
                                    if (hourOfDay != 12) hourOfDay -= 12;
                                }
                                etTime.setText(hourOfDay + ":" + minute + " " + AM_PM);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
                TimePicker timePicker = new TimePicker(this.getApplicationContext());
                timePicker.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    @Override
                    public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                        return null;
                    }
                });
                break;
            case R.id.etStop:

                etStop.setText("");
                if (etStop.getText().toString() != "")
                    numberOfStop = Integer.parseInt(etStop.getText().toString());
                etStop.setText(numberOfStop + "");
        }
    }
}
