package e.apple.cue;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RemainderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);
    }

    public void Click(View view){

        Intent intent = new Intent(RemainderActivity.this, Reminders.class);
        startActivity(intent);

    }
}
