package nassim.doum.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import nassim.doum.R;
import nassim.doum.models.AppData;
import nassim.doum.models.ElementChariot;

public class DialogActivity extends AppCompatActivity {

    ElementChariot element;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        element = (ElementChariot) getIntent().getSerializableExtra("element");
        NumberPicker quantite = (NumberPicker) findViewById(R.id.quantite);
        quantite.setMaxValue(50);
        quantite.setMinValue(1);
        quantite.setValue(1);

        if (quantite != null) {
            quantite.setValue(element.getQuantite());
        }

    }

    public void ajouterAuChariot(View v){


        NumberPicker quantite = (NumberPicker) findViewById(R.id.quantite);

        int qnt =0;
        if (quantite != null )
            qnt = quantite.getValue();

        element.setQuantite(qnt);
        AppData.chariot.add(element);

        Toast.makeText(this,"Commande ajoutée",Toast.LENGTH_SHORT).show();

        this.finish();
    }
}
