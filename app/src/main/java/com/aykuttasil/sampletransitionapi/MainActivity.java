package com.aykuttasil.sampletransitionapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.transitionseverywhere.ChangeClipBounds;
import com.transitionseverywhere.ChangeScroll;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup container = (FrameLayout) findViewById(R.id.Container);

        final Scene scene1 = Scene.getSceneForLayout(container, R.layout.transition_1, this);
        final Scene scene2 = Scene.getSceneForLayout(container, R.layout.transition_2, this);
        final Scene scene3 = Scene.getSceneForLayout(container, R.layout.transition_3, this);

        Button buttonDegistir = (Button) findViewById(R.id.ButtonDegistir);
        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transition transition;
                if (sayac % 3 == 0) {
                    transition = new Slide(Gravity.END);
                    transition.setDuration(1000);

                    TransitionManager.go(scene1, transition);
                } else if (sayac % 3 == 1) {
                    transition = new Fade();
                    transition.setDuration(1000);
                    TransitionManager.go(scene2, transition);
                } else {
                    transition = new Slide(Gravity.START);
                    transition.setDuration(1000);
                    TransitionManager.go(scene3, transition);
                }
                sayac++;
            }
        });
    }
}
