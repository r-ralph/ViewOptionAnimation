package hiroki11x.viewoptionanimation.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import hiroki11x.viewoptionanimation.OptionView;

public class MainActivity extends AppCompatActivity {

    public OptionView optionView;
    public View.OnClickListener listeners[] = new View.OnClickListener[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeners[0] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
            }
        };

        listeners[1] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "View Detail", Toast.LENGTH_SHORT).show();
            }
        };

        listeners[2] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Copy Link", Toast.LENGTH_SHORT).show();
            }
        };

        optionView = (OptionView) findViewById(R.id.optionView);

        //以下のようなセットの仕方が可能(推奨)
        //一応XMLからもできる
        optionView.setSrcImageResource(R.drawable.sample_image);

        optionView.addOption()
                .resId(R.drawable.share_symbol_white)
                .listener(listeners[0])
                .text("Share")
                .build();

        //XMLのattributeからセットすることも可能
        optionView.addOption()
                .listener(listeners[1])
                .build();

        optionView.addOption()
                .resId(R.drawable.copy_link_white)
                .listener(listeners[2])
                .text("Copy Link")
                .build();
    }
}
