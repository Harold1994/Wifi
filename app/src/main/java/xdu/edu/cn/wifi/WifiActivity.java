package xdu.edu.cn.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private Button check;
    private WifiManager wifiManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        start = (Button) this.findViewById(R.id.start);
        stop = (Button) this.findViewById(R.id.stop);
        check = (Button) this.findViewById(R.id.check);
        start.setOnClickListener(new StartWifiListener());
        check.setOnClickListener(new CheckWifiListener());
        stop.setOnClickListener(new StopWifiListener());

    }

    private class StartWifiListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            wifiManager = (WifiManager) WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);
            System.out.println("wifi state --->" + wifiManager.getWifiState());
            Toast.makeText(WifiActivity.this,"当前WIFI网卡状态为"+wifiManager.getWifiState(),Toast.LENGTH_LONG).show();
        }
    }

    private class CheckWifiListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            wifiManager = (WifiManager) WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
            System.out.println("wifi state --->" + wifiManager.getWifiState());
            Toast.makeText(WifiActivity.this,"当前WIFI网卡状态为"+wifiManager.getWifiState(),Toast.LENGTH_LONG).show();
        }
    }

    private class StopWifiListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            wifiManager = (WifiManager) WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(false);
            System.out.println("wifi state --->" + wifiManager.getWifiState());
            Toast.makeText(WifiActivity.this,"当前WIFI网卡状态为"+wifiManager.getWifiState(),Toast.LENGTH_LONG).show();
        }
    }
}
