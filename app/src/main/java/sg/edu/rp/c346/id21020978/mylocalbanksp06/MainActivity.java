package sg.edu.rp.c346.id21020978.mylocalbanksp06;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button tvDBS;
    Button tvOCBC;
    Button tvUOB;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvDBS) {
            wordClicked = "tvDBS";
        } else if (v == tvOCBC) {
            wordClicked = "tvOCBC";
        } else if (v == tvUOB) {
            wordClicked = "tvUOB";
        }
        menu.add(0, 0, 0, "Visit Website");
        menu.add(0, 1, 1, "Call Hotline");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("tvDBS")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800111111));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intent);
            } else if (item.getItemId() == 2) {
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
            }
        }
        if (wordClicked.equalsIgnoreCase("tvOCBC")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800363333));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (item.getItemId() == 2) {
                tvOCBC.setTextColor(Color.parseColor("#FF0000"));
            }
        }
        if (wordClicked.equalsIgnoreCase("tvUOB")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800222212));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            }
        }
        return false;
    }
}