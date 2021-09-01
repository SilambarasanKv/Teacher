package com.ahaguru.teacherahaguru.Fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ahaguru.teacherahaguru.R;

public class InviteFragment extends Fragment {

    TextView code;
    ImageView copy, share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_invite, container, false);

        code = v.findViewById(R.id.tvCode);

        copy = v.findViewById(R.id.ivCopy);
        share = v.findViewById(R.id.ivShare);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = (ClipData) ClipData.newPlainText("TextView", code.getText().toString());
                clipboard.setPrimaryClip(clip);

                clip.getDescription();

                Toast.makeText(getContext(), "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = code.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Your teacher code is " + s);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title");
                startActivity(Intent.createChooser(shareIntent, "Share..."));

            }
        });

        return v;
    }

}
