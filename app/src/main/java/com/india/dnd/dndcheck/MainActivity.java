package com.india.dnd.dndcheck;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.india.dnd.dndcheck.api.request.GetDndRequest;
import com.india.dnd.dndcheck.bean.Dnd;
import com.india.dnd.dndcheck.service.DndService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DndCheck.MainActivity";

    private Toolbar mToolbar;
    private EditText mEditText;
    private Button SubmitBtn;
    private ProgressBar mProgressBar;
    private TextView mTextView;

    private SpiceManager spiceManager = new SpiceManager(DndService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
                showPbar();
            }
        });
    }

    private void findViewsById() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mEditText = (EditText) findViewById(R.id.phone_number_etxt);
        mProgressBar = (ProgressBar) findViewById(R.id.dnd_progressbar);
        mTextView = (TextView) findViewById(R.id.result_txt);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(Color.WHITE);
//        mToolbar.setLogo(R.drawable.dnd_check);
        spiceManager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (spiceManager.isStarted())
            spiceManager.shouldStop();
    }

    private void parseJson(Dnd dnd) {
        String status = null;
        if (dnd.getDndStatus() == null || dnd.getDndStatus().length() == 0){
            status = "Unknown";
        }else {
            status = dnd.getDndStatus();
        }
        mTextView.setText("Dnd for " + dnd.getMobileNumber() + " is " + status);

    }

    private void showPbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hidePbar() {
        mProgressBar.setVisibility(GONE);
    }

    private void showTxt() {
        mTextView.setVisibility(View.VISIBLE);
    }

    private void hideTxt() {
        mTextView.setVisibility(GONE);
    }

    private void sendRequest() {
        GetDndRequest request = new GetDndRequest(mEditText.getText().toString());
        GetDndListener listener = new GetDndListener();
        spiceManager.execute(request, listener);
    }

    private class GetDndListener implements RequestListener<Dnd> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            hidePbar();
            hideTxt();
            Log.e(TAG, "onRequestFailure: " + spiceException.getCause());
            Toast.makeText(MainActivity.this, spiceException.getCause().toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onRequestSuccess(Dnd dnd) {
            hidePbar();
            showTxt();
            parseJson(dnd);
        }
    }
}
