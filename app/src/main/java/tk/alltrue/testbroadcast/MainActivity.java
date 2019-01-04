package tk.alltrue.testbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String WHERE_MY_CAT_ACTION = "tk.alltrue.testbroadcast.CAT";
    public static final String ALARM_MESSAGE = "Android is shit!";
    private TimeBroadcastReceiver mTimeBroadCastReceiver = new TimeBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent();
        intent.setAction(WHERE_MY_CAT_ACTION);
        intent.putExtra("tk.alltrue.testbroadcast.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void registerBroadcastReceiver(View view) {
        this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter("android.intent.action.TIME_TICK"));
        Toast.makeText(getApplicationContext(), "Receiver turned on",
                Toast.LENGTH_LONG).show();
    }

    public void unregisterBroadcastReceiver(View view) {
        this.unregisterReceiver(mTimeBroadCastReceiver);
        Toast.makeText(getApplicationContext(),"Receiver tuned off", Toast.LENGTH_LONG).show();
    }
}
