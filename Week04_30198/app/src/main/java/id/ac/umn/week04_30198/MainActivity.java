package id.ac.umn.week04_30198;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse, btnMainButtonChange1, btnMainButtonChange2;
    private TextView tvJawaban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIsian = findViewById(R.id.isian);
        etUrl = findViewById(R.id.url);
        btnBrowse = findViewById(R.id.buttonBrowse);
        btnKirim = findViewById(R.id.buttonKirim);
        tvJawaban = findViewById(R.id.jawaban);
        btnMainButtonChange1 = findViewById(R.id.main_button_change_1);
        btnMainButtonChange2 = findViewById(R.id.main_button_change_2);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlText = etUrl.getText().toString();
                if(urlText.isEmpty()){
                    urlText = "http://www.umn.ac.id/";
                }
                Intent browseIntent = new Intent(Intent.ACTION_VIEW);
                browseIntent.setData(Uri.parse(urlText));
                if(browseIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(browseIntent);
                }
            }
        });

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDua = new Intent(MainActivity.this, ActivityDua.class);
                String isian = etIsian.getText().toString();
                intentDua.putExtra("PesanDariMain",isian);
                startActivityForResult(intentDua, 1);
            }
        });

        btnMainButtonChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(keSecondActivity, 2);
            }
        });

        btnMainButtonChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keThirdActivity = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(keThirdActivity, 3);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String jawaban = data.getStringExtra("Jawaban");
                tvJawaban.setText(jawaban);
            }
        }
    }
}