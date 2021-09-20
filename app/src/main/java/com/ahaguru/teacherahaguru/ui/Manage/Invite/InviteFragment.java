package com.ahaguru.teacherahaguru.ui.Manage.Invite;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentInviteBinding;

public class InviteFragment extends Fragment {

    FragmentInviteBinding binding;
    NavController navController;
    ImageView copy, share;
    InviteViewModel inviteViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_invite, container, false);
        binding = FragmentInviteBinding.bind(v);

        inviteViewModel = new ViewModelProvider(getActivity()).get(InviteViewModel.class);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        copy = binding.ivCopy;
        share = binding.ivShare;

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = (ClipData) ClipData.newPlainText("TextView", binding.tvCode.getText().toString());
                clipboard.setPrimaryClip(clip);

                clip.getDescription();

                Toast.makeText(getContext(), "Copied", Toast.LENGTH_SHORT).show();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = binding.tvCode.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Your teacher code is " + s);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title");
                startActivity(Intent.createChooser(shareIntent, "Share..."));

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
