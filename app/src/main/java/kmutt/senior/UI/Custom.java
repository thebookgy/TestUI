package kmutt.senior.UI;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kmutt.senior.UI.MyCustomView;
import kmutt.senior.pet.R;

public class Custom extends AppCompatActivity {
    private MyCustomView myView,myView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        myView = (MyCustomView) findViewById(R.id.customView);
        myView.setCircleColor(Color.BLUE);
        myView.setCircleTextColor(Color.RED);
        myView.setCircleText("a");

        myView1 = (MyCustomView) findViewById(R.id.customView1);
        myView1.setCircleColor(Color.RED);
        myView1.setCircleTextColor(Color.BLACK);
        myView1.setCircleText("b");
    }
}
