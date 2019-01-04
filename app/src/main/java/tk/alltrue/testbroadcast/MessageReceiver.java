package tk.alltrue.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("tk.alltrue.testbroadcast.Message"),
                Toast.LENGTH_LONG).show();


        if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            String message = "Обнаружено сообщение "
                    + intent.getAction();

            Toast.makeText(context, message,
                    Toast.LENGTH_LONG).show();
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
