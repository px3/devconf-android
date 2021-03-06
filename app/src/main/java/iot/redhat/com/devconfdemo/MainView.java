package iot.redhat.com.devconfdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuInflater;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

import pl.brightinventions.slf4android.FileLogHandlerConfiguration;
import pl.brightinventions.slf4android.LoggerConfiguration;

public class MainView extends AppCompatActivity {

    private static final String ACTION1_PATH = "/posts/1";
    private static final String ACTION2_PATH = "/posts";
    private static final Logger LOG = LoggerFactory.getLogger(MainView.class.getSimpleName());

    private Broker broker;
    private HTTPInvoker service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FileLogHandlerConfiguration fileHandler = LoggerConfiguration.fileLogHandler(this);
        LoggerConfiguration.configuration().addHandlerToRootLogger(fileHandler);
        String logFileName = fileHandler.getCurrentFileName();
        LOG.info("Logging to file {}", logFileName);
        setContentView(R.layout.activity_main_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        broker = new Broker(this);
        broker.reconnect(sharedPref.getString(SettingsActivity.MQTT_BROKER_URL, ""));
        service = new HTTPInvoker(sharedPref.getString(SettingsActivity.JSON_SERVICE_URL, ""));
    }

    @Override
    protected void onDestroy() {
        try {
            broker.close();
            super.onDestroy();
        } catch (Exception e) {
            LOG.error("Error during cleanup", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAction1(View v) {
        service.get("/mobile?button=1");
    }

    public void onAction2(View v) {
        service.get("/mobile?button=2");
        /*service.post(ACTION2_PATH, "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1000,\n" +
                "  \"title\": \"mytitle\",\n" +
                "  \"body\": \"mybody\"" +
                "}");*/
    }

    public void updateButton(final String buttonName, final int backgroundColor, final String newLabel) {
        try {
            final int buttonId = R.id.class.getDeclaredField(buttonName).getInt(null);
            runOnUiThread(new Runnable() {
                public void run() {
                    Button button = (Button) findViewById(buttonId);
                    button.setBackgroundColor(0x7F << 24 | backgroundColor);
                    if (newLabel != null) {
                        button.setText(newLabel);
                    }
                }
            });
        } catch (Exception e) {
            LOG.error("Error while setting button color", e);
        }
    }

    public void onAction3(View v) {
        service.get("/mobile?button=3");
    }

    public void onAction4(View v) {
        service.get("/mobile?button=4");
    }

    public void onAction5(View v) {
        service.get("/mobile?button=5");
    }

    public void onAction6(View v) {
        service.get("/mobile?button=6");
    }

    public void onAction7(View v) {
        service.get("/mobile?button=7");
    }

    public void onAction8(View v) {
        service.get("/mobile?button=8");
    }

    public void onAction9(View v) {
        service.get("/mobile?button=9");
    }

    public void onAction10(View v) {
        service.get("/mobile?button=10");
    }

    public void onAction11(View v) {
        service.get("/mobile?button=11");
    }

    public void onAction12(View v) {
        service.get("/mobile?button=12");
    }

    public void onAction13(View v) {
        service.get("/mobile?button=13");
    }

    public void onAction14(View v) {
        service.get("/mobile?button=14");
    }

    public void onAction15(View v) {
        service.get("/mobile?button=15");
    }

    public void onAction16(View v) {
        service.get("/mobile?button=16");
    }

    public void onAction17(View v) {
        service.get("/mobile?button=17");
    }

    public void onAction18(View v) {
        service.get("/mobile?button=18");
    }


}
