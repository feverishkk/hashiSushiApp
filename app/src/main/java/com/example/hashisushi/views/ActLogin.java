package com.example.hashisushi.views;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hashisushi.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActLogin extends AppCompatActivity implements View.OnClickListener {

    private Button btnEntrar;
    private Button btnCadastrar;
    private TextView txtLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.act_login);

        //Travæ rotaçãø da tela
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtLogo = findViewById(R.id.txtLogo);
        //Chama metudo que altera fonte logo
        fontLogo();

        btnCadastrar.setOnClickListener( this );
        btnEntrar.setOnClickListener( this );

    }
    /*
     * Para que a nova fonte seja exibida na tela,
     * precisamos chamar um método na Activity que sobrescreva
     * o contexto base com um Wrapper da biblioteca.
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //Altera fonte do txtLogo
    private void fontLogo(){

        Typeface font = Typeface.createFromAsset(getAssets(), "RagingRedLotusBB.ttf");
        txtLogo.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.btnEntrar )
        {
            startVibrate(90);
            Intent it = new Intent(this, ActPromotion.class);
            startActivity(it);
        }
        else if ( v.getId() == R.id.btnCadastrar )
        {
           startVibrate(90);
            Intent it = new Intent(this, ActSignup.class);
            startActivity(it);
        }
    }

    //Metudo que ativa vibração
    public void startVibrate(long time) {
        // cria um obj atvib que recebe seu valor de context
        Vibrator atvib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        atvib.vibrate(time);
    }

}