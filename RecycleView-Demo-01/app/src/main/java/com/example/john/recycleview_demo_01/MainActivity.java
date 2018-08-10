package com.example.john.recycleview_demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewSong;
    private List<Song> mSongs;
    private SongAdapter Adapter;
    private EditText editText;
    private Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewSong=(RecyclerView)findViewById(R.id.recyclerViewSong);
        editText=(EditText)findViewById(R.id.edtName);
        btAdd=(Button)findViewById(R.id.btnAdd);

        //create Song datas
        mSongs = new ArrayList<>();
        mSongs.add(new Song("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu một tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("60701", "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60685", "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song("60752", "TÌNH YÊU CHẮP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new Song("60608", "CHỜ NGÀY MƯA TAN", "Một ngày mưa và em khuất xa nơi anh bóng dáng cứ", "Trung Đức"));
        mSongs.add(new Song("60603", "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em một lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new Song("60720", "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new Song("60856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đâu Cần thêm", "Thiện Ngôn"));


        //create Adapter
        Adapter=new SongAdapter(MainActivity.this,mSongs);
        recyclerViewSong.setAdapter(Adapter);//set Adapter

        //recyclerView scroll vertical
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerViewSong.setLayoutManager(linearLayoutManager);

        //Scroll Horizental
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerViewSong.setLayoutManager(linearLayoutManager);

        //add divider
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(MainActivity.this,linearLayoutManager.getOrientation());
        recyclerViewSong.addItemDecoration(dividerItemDecoration);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adapter.addItem(mSongs.size(),editText.getText().toString());
            }
        });
    }
}
