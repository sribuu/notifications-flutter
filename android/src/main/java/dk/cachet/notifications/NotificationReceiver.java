package dk.cachet.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import android.util.Log;
import io.flutter.plugin.common.EventChannel.EventSink;
import java.util.HashMap;

/**
 * Receives events from @NotificationListener
 * */

public class NotificationReceiver extends BroadcastReceiver {

  private EventSink eventSink;

  public NotificationReceiver(EventSink eventSink) {
    this.eventSink = eventSink;
  }

  @RequiresApi(api = VERSION_CODES.JELLY_BEAN_MR2)
  @Override
  public void onReceive(Context context, Intent intent) {
    // /// Unpack intent contents
    String packageName = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_NAME);
    String title = intent.getStringExtra(NotificationListener.NOTIFICATION_TITLE);
    String message = intent.getStringExtra(NotificationListener.NOTIFICATION_MESSAGE);
    // String packageExtra = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_EXTRA);

    /// Send data back via the Event Sink
    HashMap<String, Object> data = new HashMap<>();
    data.put("packageName", packageName);
    data.put("title", title);
    data.put("message", message);
    eventSink.success(data);
    // val packageName = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_NAME);
    // val packageMessage = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_MESSAGE);
    // val packageText = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_TEXT);
    // val packageExtra = intent.getStringExtra(NotificationListener.NOTIFICATION_PACKAGE_EXTRA);
    // val map = new HashMap<String, Any>();
    // map["packageName"] = packageName;
    // map["packageMessage"] = packageMessage;
    // map["packageText"] = packageText;
    // map["packageExtra"] =packageExtra;
    // eventSink.success(map);
  }
}
