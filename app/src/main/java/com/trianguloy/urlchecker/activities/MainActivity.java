package com.trianguloy.urlchecker.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.trianguloy.urlchecker.R;
import com.trianguloy.urlchecker.utilities.AndroidUtils;
import com.trianguloy.urlchecker.utilities.PackageUtilities;

/**
 * The activity to show when clicking the desktop shortcut (when 'opening' the app)
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * ButtonClick
     *
     * @param view which button
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modules:
                // open setup
                PackageUtilities.startActivity(new Intent(this, ConfigActivity.class), R.string.toast_noApp, this);
                break;
            // TODO: add setup activity
            case R.id.about:
                // open about
                PackageUtilities.startActivity(new Intent(this, AboutActivity.class), R.string.toast_noApp, this);
                break;
            case R.id.txt_sample:
                // click on the google url
                String label = ((TextView) view).getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(label));
                i.setPackage(getPackageName());
                PackageUtilities.startActivity(i, R.string.toast_noApp, this);
                break;
            case R.id.m_img_icon:
                // click on the app icon
                Toast.makeText(this, getString(R.string.app_name) + ", by TrianguloY", Toast.LENGTH_SHORT).show();
                break;
            default:
                AndroidUtils.assertError("Unknown view: " + view);
        }
    }

}
