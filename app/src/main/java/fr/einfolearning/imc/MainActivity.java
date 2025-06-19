package fr.einfolearning.imc;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import fr.einfolearning.imc.parcelable_imc.FicheIMC;

public class MainActivity extends AppCompatActivity {

    private EditText nomEditText, poidsEditText;
    private RadioGroup groupRadio;
    private TextView imcTextView;
    private Button calculButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomEditText = findViewById(R.id.nom);
        poidsEditText = findViewById(R.id.poids);
        groupRadio = findViewById(R.id.group);
        imcTextView = findViewById(R.id.tv_imc);
        calculButton = findViewById(R.id.calcul);

        calculButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String poidsStr = poidsEditText.getText().toString();

                try {
                    float poids = Float.parseFloat(poidsStr);
                    float taille = 1.75f; // Valeur simulée

                    CalculIMC calcul = new CalculIMC(poids, taille);
                    float imc = calcul.calculer();
                    String interpretation = calcul.interpreter();

                    FicheIMC fiche = new FicheIMC(imc, interpretation);
                    imcTextView.setText("IMC: " + imc + "\n" + interpretation);

                } catch (Exception e) {
                    imcTextView.setText(getString(R.string.input_problem));
                }
            }
        });
    }
}
