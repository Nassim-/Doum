package nassim.doum.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nassim.doum.R;
import nassim.doum.adapters.CustomAdapterChariot;
import nassim.doum.models.AppData;
import nassim.doum.models.ElementChariot;

/**
 * Created by tread on 08/04/2016.
 */
public class ChariotActivity extends AppCompatActivity {

    CustomAdapterChariot customAdapterChariot ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chariot);
        ListView listView = (ListView) findViewById(R.id.listProduitChariot);
        if (getProduitList().size()>0)
        {
            customAdapterChariot = new CustomAdapterChariot(this,getProduitList());
            listView.setAdapter(customAdapterChariot);
            ImageButton btn = (ImageButton) findViewById(R.id.Valider);
            btn.setVisibility(View.VISIBLE);
        }else{
            TextView tv = (TextView) findViewById(R.id.chariotVideText);
            tv.setVisibility(View.VISIBLE);
        }
    }

    public List<ElementChariot> getProduitList()
    {
        List<ElementChariot> produitList = new ArrayList<>();

        for (int i=0;i< AppData.chariot.getProduitsChariot().size();i++){
            produitList.add(AppData.chariot.getProduitsChariot().get(i));
        }
        return produitList;
    }

    public void valider(View v){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}
