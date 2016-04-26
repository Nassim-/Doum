package nassim.doum.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nassim.doum.R;
import nassim.doum.activities.ChariotActivity;
import nassim.doum.activities.DialogActivity;
import nassim.doum.models.AppData;
import nassim.doum.models.ElementChariot;

/**
 * Created by tread on 18/04/2016.
 */

public class CustomAdapterChariot extends BaseAdapter {
    private Context context;
    private List<ElementChariot> produitList;

    public CustomAdapterChariot(Context context, List<ElementChariot> produitList) {
        this.context = context;
        this.produitList = produitList;
    }

    @Override
    public int getCount() {
        return produitList.size();
    }

    @Override
    public Object getItem(int position) {
        return produitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // mettre le layout une seule fois lorsque convertView est null
        if (convertView == null) {
            convertView = parent.inflate(context, R.layout.element_item, null);
        }
        ImageView coverIcon = (ImageView) convertView.findViewById(R.id.imageProduitChariot);
        TextView textNom = (TextView) convertView.findViewById(R.id.nomProduitChariot);
        TextView textPrix = (TextView) convertView.findViewById(R.id.prixProduitChariot);
        TextView textQuantite = (TextView) convertView.findViewById(R.id.quantiteProduitChariot);
        coverIcon.setImageResource(produitList.get(position).getProduit().getIconProduit());
        textNom.setText(produitList.get(position).getProduit().getNomProduit());
        textQuantite.setText(produitList.get(position).getQuantite()+"");
        textPrix.setText(produitList.get(position).getProduit().getPrixProduit()+" DA");

        ImageButton btn = (ImageButton) convertView.findViewById(R.id.buttonChariot);

        btn.setFocusable(false);
        btn.setFocusableInTouchMode(false);
        btn.setClickable(true);

        ImageButton btn2 = (ImageButton) convertView.findViewById(R.id.supprimer);

        btn.setFocusable(false);
        btn.setFocusableInTouchMode(false);
        btn.setClickable(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DialogActivity.class);
                intent.putExtra("element", produitList.get(position));
                context.startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AppData.chariot.remove(produitList.get(position));
                Intent intent = new Intent(context, ChariotActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
