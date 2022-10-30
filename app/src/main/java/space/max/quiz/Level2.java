package space.max.quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int num_left;
    public int num_right;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //создаем переменную текст левел
        TextView text_levels = findViewById(R.id.text_level);
        text_levels.setText(R.string.level_1);//устоновили текст

        // скругленик углов на прозрачной левой картинки
        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        // скругленик углов на прозрачной правой картинки
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_left.setClipToOutline(true);

        //путь к левой текст вью
        final TextView text_left = findViewById(R.id.text_left);
        //путь к левой текст вью
        final TextView text_right = findViewById(R.id.text_right);

        /* азвернуть игру на весь экран начало*/
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* азвернуть игру на весь экран конец*/

        /*вызов диалогового окна в начале игры*/
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog);//путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
        //станавливаем картинку в диалоговое окно начало
        ImageView previewimg=(ImageView)dialog.findViewById(R.id.previewamg);
        previewimg.setImageResource(R.drawable.preview_img_two);
        //станавливаем картинку в диалоговое окно конец

        //Описание задание начало
        TextView textdecription=(TextView)dialog.findViewById(R.id.text_description);
        textdecription.setText(R.string.level2);
        //Описание задание начало

        //кнопка которая закрывает диологовое окно начало
        TextView btn_close = (TextView) dialog.findViewById(R.id.button_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);//старт намерения
                    finish();
                    //вернуться назад к выбору уровня конец

                } catch (Exception ignored) {
                    System.out.println("ERROR");
                }
                dialog.dismiss();//закрываем диалоговое окно
                //обрабатываем нажатие кнопки конец


            }
        });
        //кнопка продолжить начало
        Button btn_continue = (Button) dialog.findViewById(R.id.button_comtinue);
        btn_continue.setOnClickListener(v -> {
            dialog.dismiss();//закрываем дталоговое окно через кнопку
            //кнопка продолжить конец
        });

        dialog.show();

        //__________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end);//путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой назад
        
        //кнопка которая закрывает диологовое окно начало
        TextView btn_close_end = (TextView) dialogEnd.findViewById(R.id.button_close_end);
        btn_close_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);//старт намерения
                    finish();
                    //вернуться назад к выбору уровня конец

                } catch (Exception e) {

                }
                dialogEnd.dismiss();//закрываем диалоговое окно
                //обрабатываем нажатие кнопки конец


            }
        });
//        кнопка продолжить начало
        Button btn_continue_end = (Button) dialogEnd.findViewById(R.id.button_comtinue_end);
        btn_continue_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent= new Intent(Level2.this, Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception ignored){
                };
                dialogEnd.dismiss();//закрываем дталоговое окно через кнопку
                //кнопка продолжить конец
            }
        });
        //__________________________


        //кнопка назад начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception ignored) {

                }
            }
        });
        //кнопка назад конец

        //масив прогресса игры
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7,
                R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14,
                R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20
        };

        //подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        //ВЫБОР КАРТИНКИ РАНДОМ
        num_left = random.nextInt(10);
        img_left.setImageResource(array.images2[num_left]);//достаем из массива картинку
        text_left.setText(array.texts2[num_left]);//достаем из массива текст

        System.out.println("OYEEE");
        num_right = random.nextInt(10);
        //цикл с условием на равенство
        while (num_right == num_left) {
            num_right = random.nextInt(10);
        }
        img_right.setImageResource(array.images2[num_right]);//достаем из массива картинку
        text_right.setText(array.texts2[num_right]);//достаем из массива текст

        //нажатие на левую картинку
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("ENTER2");
                //палец прикоснулся
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    //если коснулся картинки
                    //img_left
                    img_right.setEnabled(false);//локируем правую картинку
                    if (num_left > num_right) {

                        img_left.setImageResource(R.drawable.img_true);

                    } else {
                        img_left.setImageResource(R.drawable.img_folse);
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    //если отпустил палец
                    if (num_left > num_right) {
                        if (count < 20) {
                            count = count + 1;
                        }
                        //закрашиввем прогресс серым цветом
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрышиваем правильные ответы зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //если левая картинка меньше
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //закрашиввем прогресс серым цветом
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрышиваем правильные ответы зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }//если отпустил палец конец
                    if (count == 20) {
                        //выход из уровня
                        dialogEnd.show();
                    } else {
                        //ВЫБОР КАРТИНКИ РАНДОМ
                        num_left = random.nextInt(10);
                        img_left.setImageResource(array.images2[num_left]);//достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[num_left]);//достаем из массива текст

                        num_right = random.nextInt(10);
                        //цикл с условием на равенство
                        while (num_right == num_left) {
                            num_right = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images2[num_right]);//достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[num_right]);//достаем из массива текст
                        img_right.setEnabled(true);//вкл правую картинку


                    }

                }

                return true;
            }
        });//нажатик на левую картинку конец


        //нажатие на правую картинку
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("ENTER");
                //палец прикоснулся
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки
                    img_left.setEnabled(false);//локируем левую картинку
                    if (num_left < num_right) {
                        img_right.setImageResource(R.drawable.img_true);

                    } else {
                        img_right.setImageResource(R.drawable.img_folse);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец
                    if (num_left < num_right) {
                        //если правая картинка больше
                        if (count < 20) {
                            count = count + 1;
                        }
                        //закрашиввем прогресс серым цветом
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрышиваем правильные ответы зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //если правая картинка меньше
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //закрашиввем прогресс серым цветом
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрышиваем правильные ответы зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }//если отпустил палец конец
                    if (count == 20) {
                        //выход из уровня
                        dialogEnd.show();
                    } else {
                        //ВЫБОР КАРТИНКИ РАНДОМ
                        num_left = random.nextInt(10);
                        img_left.setImageResource(array.images2[num_left]);//достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[num_left]);//достаем из массива текст

                        num_right = random.nextInt(10);
                        //цикл с условием на равенство
                        while (num_right == num_left) {
                            num_right = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images2[num_right]);//достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[num_right]);//достаем из массива текст
                        img_left.setEnabled(true);//вкл левую картинку

                    }

                }

                return true;
            }
        });//правая кнорка конец


    }

    //системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);
            finish();

        } catch (Exception ignored) {

        }

    }
    // //системная кнопка конец
}