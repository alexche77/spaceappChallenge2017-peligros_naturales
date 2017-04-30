package spaceapps.alvaro.caringfornature;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;
import universum.studios.android.font.Font;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2500)
                .withBackgroundColor(Color.WHITE)
                .withAfterLogoText("SpaceAppsChallenge 2017")
                .withLogo(R.drawable.logo_app);
        //add custom font
        final Font fuente = Font.create("CaviarDreams.ttf");
        config.getAfterLogoTextView().setTypeface(fuente.getTypeface(getApplicationContext()));

        config.getAfterLogoTextView().setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
        config.getAfterLogoTextView().setGravity(Gravity.CENTER_HORIZONTAL);
        config.getAfterLogoTextView().setTextSize(20);
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}

