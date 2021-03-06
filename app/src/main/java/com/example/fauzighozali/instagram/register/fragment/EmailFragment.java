package com.example.fauzighozali.instagram.register.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fauzighozali.instagram.R;

public class EmailFragment extends Fragment {

    private EditText email;
    private Button next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_email_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        email = view.findViewById(R.id.edit_text_email);
        next = view.findViewById(R.id.button_next);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(email.getText().toString().length() > 0 ) {
                    next.setTextColor(Color.parseColor("#ffffff"));
                    next.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login));
                    next.setEnabled(true);
                }
                else {
                    next.setTextColor(Color.parseColor("#eaf3f2"));
                    next.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login_disable));
                    next.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
