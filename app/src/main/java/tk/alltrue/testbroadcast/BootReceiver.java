package tk.alltrue.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    Context mContext;
    private final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        String action = intent.getAction();
        if (action.equalsIgnoreCase(BOOT_ACTION)) {
            // здесь ваш код
            // например, запускаем уведомление
            //Intent intent = new Intent(context, intent);
            //context.startService(intent);
            // в общем виде
            //для Activity
            Intent activityIntent = new Intent(context, MainActivity.class);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);

            //для Service
            /*Intent serviceIntent = new Intent(context, MyService.class);
            context.startService(serviceIntent);*/
        }
    }
}
