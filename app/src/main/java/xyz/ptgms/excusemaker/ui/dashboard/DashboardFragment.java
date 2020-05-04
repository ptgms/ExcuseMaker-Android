package xyz.ptgms.excusemaker.ui.dashboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import xyz.ptgms.excusemaker.MainActivity;
import xyz.ptgms.excusemaker.R;
import xyz.ptgms.excusemaker.ui.home.HomeFragment;

public class DashboardFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        MainActivity activity = (MainActivity) getActivity();
        boolean lowercaseState = activity.LoadSetting(0);
        boolean uppercaseState = activity.LoadSetting(1);
        boolean furryState = activity.LoadSetting(2);
        boolean mockeryState = activity.LoadSetting(3);

        final Switch lowercase = view.findViewById(R.id.switch1);
        final Switch uppercase = view.findViewById(R.id.switch2);
        Switch furry = view.findViewById(R.id.switch3);
        final Switch mockery = view.findViewById(R.id.switch4);
        Button source = view.findViewById(R.id.sourceButton);

        lowercase.setChecked(lowercaseState);
        uppercase.setChecked(uppercaseState);
        furry.setChecked(furryState);
        mockery.setChecked(mockeryState);

        lowercase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity activity = (MainActivity) getActivity();
                activity.saveSetting(0, isChecked);
                mockery.setChecked(false);
                if (uppercase.isChecked() && isChecked) {
                    uppercase.setChecked(false);
                    activity.saveSetting(1, false);
                }
                if (mockery.isChecked() && isChecked) {
                    mockery.setChecked(false);
                    activity.saveSetting(3, false);
                }

            }
        });
        uppercase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity activity = (MainActivity) getActivity();
                activity.saveSetting(1, isChecked);
                if (lowercase.isChecked() && isChecked) {
                    lowercase.setChecked(false);
                    activity.saveSetting(0, false);
                }
                if (mockery.isChecked() && isChecked) {
                    mockery.setChecked(false);
                    activity.saveSetting(3, false);
                }

            }
        });
        furry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity activity = (MainActivity) getActivity();
                activity.saveSetting(2, isChecked);

            }
        });
        mockery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity activity = (MainActivity) getActivity();
                activity.saveSetting(3, isChecked);
                if (uppercase.isChecked() && isChecked) {
                    uppercase.setChecked(false);
                    activity.saveSetting(0, false);
                }
                if (lowercase.isChecked() && isChecked) {
                    lowercase.setChecked(false);
                    activity.saveSetting(1, false);
                }

            }
        });
        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/ptgms/ExcuseMaker-Android";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return view;
    }
}
