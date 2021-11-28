package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {
    Button btn_push, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btn_push = findViewById(R.id.btn_push);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int icon = R.drawable.ic_baseline_notifications_24;
                String ticket = "this is the ticket message";
                long when = System.currentTimeMillis();
                String title = "title";
                String ticker = "ticker";
                String text = "text";

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("key", "i want a burekas");
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

                Notification notification = builder.setContentIntent(pendingIntent)
                        .setSmallIcon(icon)
                        .setTicker(ticker)
                        .setWhen(when)
                        .setAutoCancel(true)
                        .setContentTitle(title)
                        .setContentText(text).build();
                notificationManager.notify(1, notification);
            }
        });
    }
}