package nassim.doum.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import nassim.doum.R;

/**
 * Created by tread on 08/04/2016.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view)
    {
        Toast.makeText(this,"connected",Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
