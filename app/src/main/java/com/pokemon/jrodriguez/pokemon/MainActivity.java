package com.pokemon.jrodriguez.pokemon;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    private String[] pokemons = {"bulbasaur","ivysaur","venasaur","ivysaur","charmander","charmeleon","charizard","squirtle","wartortle","blastoise","caterpie","metapod","butterfree","weedle","kakuna","beedrill","pidgey","pidgeotto","pidgeot","rattata","raticate","spearow","fearow","ekans","arbok","pikachu","raichu","sandshrew","sandslash","nidoran","nidorina","nidoqueen","cloyster","gloom","krabby","magmar","marowak","snorlax","starmie","vulpix"};
    private String[] shadows_pokemons = {"s_bulbasaur","s_ivysaur","s_venasaur","s_ivysaur","s_charmander","s_charmeleon","s_charizard","s_squirtle","s_wartortle","s_blastoise","s_caterpie","s_metapod","s_butterfree","s_weedle","s_kakuna","s_beedrill","s_pidgey","s_pidgeotto","s_pidgeot","s_rattata","s_raticate","s_spearow","s_fearow","s_ekans","s_arbok","s_pikachu","s_raichu","s_sandshrew","s_sandslash","s_nidoran","s_nidorina","s_nidoqueen","s_cloyster","s_gloom","s_krabby","s_magmar","s_marowak","s_snorlax","s_starmie","s_vulpix"};

    private int random_number = 0;

    private Button btn_check;
    private Button btn_refresh;
    private EditText txt_pokemon;
    private ImageView img_pokemon;
    private TextView lb_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_pokemon = (ImageView)findViewById(R.id.imageView);
        txt_pokemon = (EditText)findViewById(R.id.txt_pokemon);
        btn_check = (Button)findViewById(R.id.btn_check);
        btn_refresh = (Button)findViewById(R.id.btn_refresh);
        lb_time = (TextView)findViewById(R.id.lb_time);

        Initial();

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_pokemon = txt_pokemon.getText().toString();

                if (name_pokemon.equals(pokemons[random_number])) {
                    GetPokemon(random_number);
                    btn_check.setEnabled(false);
                    btn_refresh.setEnabled(true);
                }else{
                    Toast.makeText(getApplicationContext(), "Sorry, that's not the Pokemon", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Initial();
                btn_check.setEnabled(true);
            }

        });
    }

    public void Waiting(){

        new CountDownTimer(11000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                lb_time.setText("" + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                lb_time.setText("0");

                GetPokemon(random_number);
                btn_check.setEnabled(false);
                btn_refresh.setEnabled(true);
                txt_pokemon.setText(GetNamePokemon(random_number));

            }
        }.start();
    }

    public void Initial(){
        btn_refresh.setEnabled(false);
        txt_pokemon.setText("");

        RandomPokemon();
        GetShadow(random_number);
        Waiting();

    }
    public void GetPokemon(int number){
        int img_id = getResources().getIdentifier(  pokemons[number], "drawable", getPackageName());
        img_pokemon.setImageResource(img_id);
        btn_check.setEnabled(false);
    }

    public String GetNamePokemon(int id_pokemon){
        return  pokemons[id_pokemon];
    }

    public void GetShadow(int number){
        int img_id = getResources().getIdentifier(shadows_pokemons[number], "drawable", getPackageName());
        img_pokemon.setImageResource(img_id);
    }

    public void RandomPokemon(){
        random_number = (int)(Math.random() * pokemons.length);
    }
}


