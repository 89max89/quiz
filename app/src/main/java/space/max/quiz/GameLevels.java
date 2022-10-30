package space.max.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);
/*растянуть на весь экран*/
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /*нопка назад*/
        Button buttonback=(Button)findViewById(R.id.RelativeLayout);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*команда для кнопки*/
                try {
                    /*намерение*/
                    Intent intent=new Intent(GameLevels.this,MainActivity.class);
                    /*активацмя наиериния*/
                    startActivity(intent);
                    /*закрываем окно*/
                    finish();

                }catch (Exception e){

                };


            }
        });
        /*кнопка для перехода на первый уровень начало*/
        TextView textView1=(TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{Intent intent=new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);finish();

                }catch (Exception t){};

            }
        });
        /*кнопка для перехода на первый уровень началоконец*/

        /*кнопка для перехода на второй уровень начало*/
        TextView textView2=(TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{Intent intent=new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);finish();

                }catch (Exception t){};

            }
        });
        /*кнопка для перехода на второй уровень началоконец*/
    }
    /*ситемная кнопка назад начало*/
    @Override
    public void onBackPressed(){
        /*команда для кнопки*/
        try {
            /*намерение*/
            Intent intent=new Intent(GameLevels.this,MainActivity.class);
            /*активацмя наиериния*/
            startActivity(intent);
            /*закрываем окно*/
            finish();

        }catch (Exception e){

        };

    }
    /*системная кнопка назад конец*/
}