package nassim.doum.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nassim.doum.R;
import nassim.doum.models.Produit;

/**
 * Created by tread on 07/04/2016.
 */
public class FragmentDetail extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail,null);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Produit p = (Produit) bundle.getSerializable("produit");
            ImageView coverImage = (ImageView) v.findViewById(R.id.ImageDeProduit);
            TextView textNom = (TextView) v.findViewById(R.id.nomDeProduit);
            TextView textDetail = (TextView) v.findViewById(R.id.detailDeProduit);
            TextView textPrix = (TextView) v.findViewById(R.id.prixDeProduit);

            (v.findViewById(R.id.detailDeProduit)).setVisibility(v.VISIBLE);

            coverImage.setImageResource(p.getPhotoProduit());
            textNom.setText("Produit : "+p.getNomProduit());
            textDetail.setText("Détail : "+p.getDetailProduit());
            textPrix.setText("Prix : "+p.getPrixProduit());
        }
        return v;
    }
}

