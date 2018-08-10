package com.example.admin.custombutton_autolink_wifimanager_luuvitriscrollview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    Button btTang,btGiam;
    float size;
    TextView tv;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton) ;
        btTang=(Button)findViewById(R.id.button2);
        btGiam=(Button)findViewById(R.id.button3);
        tv=(TextView)findViewById(R.id.textView) ;
        SharedPreferences data=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=data.edit();

        editor.putString("noidung","BÔNG HỒNG BÉ NGOAN!\n" +
                "Nghe thì hơi phũ chứ nói trắng ra suốt thời đi học chỉ để thi, thi và thi.\n" +
                "Lớn có kỳ thi của lớn, nhỏ có cái thi của nhỏ, nói đâu xa, từ cái hồi nước mắt còn lẫn với nước mũi xụt xịt là đã phải cùng bao nhiêu cô cậu bé ngày đó lao đầu vào các kỳ thi của lớp mẫu giáo rồi, 1 trong số đó nhàm chán và tẻ nhạt nhất là thi lấy “Phiếu hoa hồng” dán vào sổ liên lạc hàng tuần.\n" +
                "Chả định nghĩa được đường lối giáo dục có mục đích gì khi mà bao nhiêu đấng nam nhi lại bán cả đạo đức và nhân cách chỉ để theo đuổi những thứ vớ vẩn đã được sắp đặt là biểu tượng của mấy đứa con gái như thế, sao ko phải là hình trái bóng, hình đôi giày, hay cái vớ vẩn gì đại loại thế mà nó bớt nữ tính 1 chút.\n" +
                "Cái dòng “Ý kiến phụ huynh” luôn là cái dòng rất cảm xúc và ý nghĩa, tự nhiên ngẫm lại ko biết có bao giờ ngày đó mẹ mình từng điền câu nào đại loại như:\n" +
                "-“Gia đình đã cho cháu úp đít lên giường vào tối hôm qua, cảm ơn cô!”.\n" +
                "Nhưng nếu phải lựa chọn giữa bảo vệ quan điểm nam nhi, nói ko với bông hồng nữ tính và việc về nhà hàng tuần mẹ bảo đâu đưa phiếu liên lạc coi, giời ơi là giời sao mà được có 1 phiếu, lại đây, úp đít lên giường, gấp……thì mình thề rằng mình đã phí 3 năm mẫu giáo chỉ để luôn nghĩ trong đầu rằng:\n" +
                "-“Sống vì bông hồng, sống vì bông hồng!”.\n" +
                "Lễ phép với thầy cô, ko chọc phá bạn, ko nói chuyện, giờ ngủ trưa phải nằm ngủ dù rằng ko muốn ngủ……ko biết từ lúc nào thế giới tuổi thơ chỉ quanh quẩn đâu đó trong những nội quy nhàm chán, con người ta tự sống trong lớp vỏ giả tạo mà nền giáo dục thành tích đặt ra.\n" +
                "Chỉ có đúng 1 lần mình dám tự đứng lên vượt qua nó đó là giờ ra chơi hồi nào ko nhớ, nói cô Thanh – 1 trong 3 cô phụ trách lớp mẫu giáo nhìn tròn tròn như Trư Bát Giới.\n" +
                "Đó là 1 lời nhận xét trắng ra trắng, đen ra đen của 1 cậu bé ngây thơ trong sáng, ko hàm ý, ko ẩn dụ, nghe sao hiểu vậy và nó sẽ luôn là 1 cái gì đó đúng nếu ko bỗng tụi nó cười phá lên xong rồi cô Thanh lại hỏi:\n" +
                "-“Có gì zui zậy, kể cho cô nghe zới!”.\n" +
                "Kết quả sau đó cũng chả cần phải kể, lũ bạn rất là thật thà, vâng thật thà tới từng chi tiết, thậm chí tụi nó còn nhấn mạnh rõ ràng là GIỐNG Y CHANG TRƯ BÁT GIỚI thì mới chịu, bởi, con nít thật thà, giờ lớn rồi ko trách được.");
        editor.commit();

        //set noi dung cho TextView
        tv.setText(data.getString("noidung",""));
        //

        //set Font cho TextView
        Typeface font=Typeface.createFromAsset(this.getAssets(),"Blazed.ttf");
        tv.setTypeface(font);
        //


        //Lay vi tri ScrollView nap lai
        final int vitri=data.getInt("vitri",0);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.setScrollY(vitri);
            }
        });
        //
        //kiem tra co wifi va bat/tat toggleButton
        boolean cowifi=kiemtrainternet(MainActivity.this);
        if(cowifi) {toggleButton.setChecked(true);
        Toast.makeText(MainActivity.this,"Co wifi",Toast.LENGTH_SHORT).show();}
        else {toggleButton.setChecked(false); Toast.makeText(MainActivity.this,"Khong co wifi",Toast.LENGTH_SHORT).show();}
        //

        //su dung toogleButton de bat/tat WIFI
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                WifiManager wifiManager=(WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE);
                if(isChecked) wifiManager.setWifiEnabled(true);
                else wifiManager.setWifiEnabled(false);
            }
        });
        //

        //btTang de tang SIZE
        btTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size=tv.getTextSize();
                size+=3;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
            }
        });
        //btGiam
        btGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size=tv.getTextSize();
                size-=3;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
            }
        });


        //


    }
    //nhan Back thoat ra thi nho vi tri cua ScrollView
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences data=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=data.edit();
        editor.putInt("vitri",scrollView.getScrollY());
        editor.commit();
        Toast.makeText(MainActivity.this,"Da luu vi tri: "+scrollView.getScrollY(),Toast.LENGTH_SHORT).show();
    }

    public boolean kiemtrainternet(Context context)
    {
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork!=null && wifiNetwork.isConnected()) return  true;

        NetworkInfo mobileNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(mobileNetwork!=null && mobileNetwork.isConnected()) return true;

        NetworkInfo activeNetwork=cm.getActiveNetworkInfo();
        if(activeNetwork!=null && activeNetwork.isConnected()) return true;

        return false;
    }
}
