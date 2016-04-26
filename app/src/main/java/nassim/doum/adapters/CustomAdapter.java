package nassim.doum.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nassim.doum.R;
import nassim.doum.activities.DialogActivity;
import nassim.doum.models.ElementChariot;
import nassim.doum.models.Produit;


public class CustomAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private List<Produit> produitList;
    // Pour le fitre
    private ValueFilter  valueFilter;
    private List<Produit> mFilterList;

    public CustomAdapter(Context context, List<Produit> produitList) {
        this.context = context;
        this.produitList = produitList;
        this.mFilterList = produitList;
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
            convertView = parent.inflate(context, R.layout.produit_item, null);
        }
        ImageView coverIcon = (ImageView) convertView.findViewById(R.id.imageProduit);
        TextView textNom = (TextView) convertView.findViewById(R.id.nomProduit);
        TextView textPrix = (TextView) convertView.findViewById(R.id.prixProduit);
        coverIcon.setImageResource(produitList.get(position).getIconProduit());
        textNom.setText(produitList.get(position).getNomProduit());
        textPrix.setText(produitList.get(position).getPrixProduit()+" DA");
        ImageButton btn = (ImageButton) convertView.findViewById(R.id.button);

        btn.setFocusable(false);
        btn.setFocusableInTouchMode(false);
        btn.setClickable(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DialogActivity.class);
                intent.putExtra("element", new ElementChariot(produitList.get(position),0));
                context.startActivity(intent);

            }
        });

        return convertView;
    }

    /* Implementation du filtre
       On doit redéfinir la méthode getFilter()
    */
    @Override
    public Filter getFilter() {
        // La méthode retourne un objet de type Filter
        if(valueFilter==null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    // Une nouvelle classe de type Filter est définie
    // Quand on va instancier ValueFilter, deux méthodes sont appelées :  : performFiltering et publishResults

    private class ValueFilter extends Filter {

        // cette méthode effecute le filtre sur la liste des produits
        // une copie de cette liste mFilterList est utilisée

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Produit p;
            List<Produit> listFilter = new ArrayList<Produit>();
            FilterResults filterResults = new FilterResults();
            // véirifer si le texte n'est pas vide
            if (constraint != null && constraint.length() > 0) {
                for (int i = 0; i < mFilterList.size(); i++) {
                    p = mFilterList.get(i);
                    // Utiliser la catégorie comme filtre
                    if ((p.getTypeProduit().toUpperCase().contains(constraint.toString().toUpperCase()))) {
                        listFilter.add(p);
                    }
                }
                filterResults.count = listFilter.size();
                filterResults.values = listFilter;
            } else {
                filterResults.count = mFilterList.size();
                filterResults.values = mFilterList;
            }
            return filterResults;
        }

        // Cette méthode permet d'afficher la nouvelle listView en appelant notifyDataSetChanged()
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            produitList = (List<Produit>) results.values;
            notifyDataSetChanged();
        }
    }

}
