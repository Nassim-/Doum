package nassim.doum.fragments;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import nassim.doum.R;
import nassim.doum.activities.DetailActivity;
import nassim.doum.adapters.CustomAdapter;
import nassim.doum.models.Produit;

/**
 * Created by tread on 07/04/2016.
 */
public class FragmentProduit extends Fragment {

    CustomAdapter customAdapter ;
    List<Produit> listeAffichage;
    Spinner spinner;
    ListView listView;
    int positionFragment;
    String[] adabtervalues ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, null);
        listView = (ListView) v.findViewById(R.id.listProduit);

        Bundle bundle = getArguments();
        positionFragment = bundle.getInt("pos");

        if (positionFragment==0)
            adabtervalues = getResources().getStringArray(R.array.categories_homme);
        else if (positionFragment==1)
            adabtervalues = getResources().getStringArray(R.array.categories_femme);
        else
            adabtervalues = getResources().getStringArray(R.array.categories_enfant);

        Adapter adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,adabtervalues);
        spinner = (Spinner) v.findViewById(R.id.categorie);
        spinner.setAdapter((SpinnerAdapter) adapter);

        // spinner categories
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                listeAffichage = getProduitListParCategorie(spinner.getSelectedItem().toString());
                customAdapter = new CustomAdapter(getActivity(),listeAffichage);

                if (positionFragment==0)
                    customAdapter.getFilter().filter("Homme");
                else if (positionFragment==1)
                    customAdapter.getFilter().filter("Femme");
                else
                    customAdapter.getFilter().filter("Enfant");

                listView.setAdapter(customAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showView((Produit) customAdapter.getItem(position));

            }
        });

        return v;
    }

    public List<Produit> getProduitList()   {
        List<Produit> produitList = new ArrayList<>();

        Produit p = new Produit("Lujia");
        p.setPrixProduit(1500);
        p.setIconProduit(R.drawable.ic_chaussureenfant1);
        p.setPhotoProduit(R.drawable.ic_chaussureenfant1);
        p.setTypeProduit("Enfant");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Cette chaussure Lujia est une chaussre comfortable pour vos petits enfants de 4-8 ans");
        produitList.add(p);

        p = new Produit("Kickers");
        p.setPrixProduit(2500);
        p.setIconProduit(R.drawable.ic_chaussureenfant2);
        p.setPhotoProduit(R.drawable.ic_chaussureenfant2);
        p.setTypeProduit("Enfant");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Chaussure Kickers est une chaussre solide enfants de 6-12 ans");
        produitList.add(p);

        p = new Produit("Pull and Bear");
        p.setPrixProduit(2500);
        p.setIconProduit(R.drawable.ic_chaussureenfant3);
        p.setPhotoProduit(R.drawable.ic_chaussureenfant3);
        p.setTypeProduit("Enfant");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Chaussure Pull and Bear , nouvelle tendance pour enfants de 8-12 ans");
        produitList.add(p);

        p = new Produit("Pull and Bear");
        p.setPrixProduit(1400);
        p.setIconProduit(R.drawable.ic_chaussureenfant4);
        p.setPhotoProduit(R.drawable.ic_chaussureenfant4);
        p.setTypeProduit("Enfant");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("DP , trés belles chaussures pour vos enfants de la marque prestigieuse DP");
        produitList.add(p);

        p = new Produit("Heels");
        p.setPrixProduit(2200);
        p.setIconProduit(R.drawable.ic_chaussureenfant5);
        p.setPhotoProduit(R.drawable.ic_chaussureenfant5);
        p.setTypeProduit("Enfant");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Heels propose des chaussures running de trés bonne qualité ,pour enfants");
        produitList.add(p);

        p = new Produit("Prada");
        p.setPrixProduit(2300);
        p.setIconProduit(R.drawable.ic_chaussurefemme1);
        p.setPhotoProduit(R.drawable.ic_chaussurefemme1);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Chaussure pour femmes , à talons proposée par PRADA");
        produitList.add(p);

        p = new Produit("Clarks");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_chaussurefemme2);
        p.setPhotoProduit(R.drawable.ic_chaussurefemme2);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Chaussure à talons proposée par Clarks,trés élégante pour femme");
        produitList.add(p);

        p = new Produit("H&M");
        p.setPrixProduit(3800);
        p.setIconProduit(R.drawable.ic_chaussurefemme3);
        p.setPhotoProduit(R.drawable.ic_chaussurefemme3);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("H&M revient cette fois ci avec de nouvelles chaussures classes pour femme");
        produitList.add(p);

        p = new Produit("Tomy");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_chaussurefemme4);
        p.setPhotoProduit(R.drawable.ic_chaussurefemme4);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Tomy vous impressionne encore une fois avec ces chaussures pour femme");
        produitList.add(p);

        p = new Produit("Kalvin Klein");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_chaussurefemme5);
        p.setPhotoProduit(R.drawable.ic_chaussurefemme5);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Kalvin Klein et ces chaussures pour femme,une nouvelle ére est annoncée");
        produitList.add(p);

        p = new Produit("Dolce & Gabanna");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_chaussurehomme1);
        p.setPhotoProduit(R.drawable.ic_chaussurehomme1);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Dolce & Gabanna et ces chaussures pour homme,une nouvelle ére est annoncée");
        produitList.add(p);

        p = new Produit("Air Jordan");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_chaussurehomme2);
        p.setPhotoProduit(R.drawable.ic_chaussurehomme2);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("Air Jordan et ces nouvelles chaussures");
        produitList.add(p);

        p = new Produit("Gucci");
        p.setPrixProduit(12000);
        p.setIconProduit(R.drawable.ic_chaussurehomme3);
        p.setPhotoProduit(R.drawable.ic_chaussurehomme3);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("les nouvelles chaussures classes proposées par la marque mondiale Gucci");
        produitList.add(p);

        p = new Produit("DG");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_chaussurehomme4);
        p.setPhotoProduit(R.drawable.ic_chaussurehomme4);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("chaussure montantes de Gucci, exeptionnelles en matiéres de comfort");
        produitList.add(p);

        p = new Produit("Clarks");
        p.setPrixProduit(8400);
        p.setIconProduit(R.drawable.ic_chaussurehomme5);
        p.setPhotoProduit(R.drawable.ic_chaussurehomme5);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Chaussure");
        p.setDetailProduit("chaussure montantes Clarks, exeptionnelles en matiéres de comfort");
        produitList.add(p);

        p = new Produit("Adidas");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_ensembleenfant1);
        p.setPhotoProduit(R.drawable.ic_ensembleenfant1);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvel ensemble d'Adidas pour enfants");
        produitList.add(p);

        p = new Produit("Pirate");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_ensembleenfant2);
        p.setPhotoProduit(R.drawable.ic_ensembleenfant2);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvel ensemble de Pirate pour enfants");
        produitList.add(p);

        p = new Produit("Hello Ketty");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_ensembleenfant3);
        p.setPhotoProduit(R.drawable.ic_ensembleenfant3);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Hello Kety revient avec un nouvel ensemble pour vos petites filles");
        produitList.add(p);

        p = new Produit("Mimie");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_ensembleenfant4);
        p.setPhotoProduit(R.drawable.ic_ensembleenfant4);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Mimie propose de nouveaux ensemble pour les filles de 6-12 ans");
        produitList.add(p);

        p = new Produit("Adidas");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_ensembleenfant5);
        p.setPhotoProduit(R.drawable.ic_ensembleenfant5);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvel ensemble d'Adidas pour enfants");
        produitList.add(p);

        p = new Produit("Adidas");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_ensemblefemme1);
        p.setPhotoProduit(R.drawable.ic_ensemblefemme1);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements d'Adidas pour Femme");
        produitList.add(p);

        p = new Produit("Polo");
        p.setPrixProduit(7800);
        p.setIconProduit(R.drawable.ic_ensemblefemme2);
        p.setPhotoProduit(R.drawable.ic_ensemblefemme2);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements Polo pour Femme");
        produitList.add(p);

        p = new Produit("Gucci");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_ensemblefemme3);
        p.setPhotoProduit(R.drawable.ic_ensemblefemme3);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Polo revient avec de nouvelles survétements , nouvelle tendance");
        produitList.add(p);

        p = new Produit("Polo");
        p.setPrixProduit(8400);
        p.setIconProduit(R.drawable.ic_ensemblefemme4);
        p.setPhotoProduit(R.drawable.ic_ensemblefemme4);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("survétements pour femme , proposée par Polo dans sa nouvelle collection");
        produitList.add(p);

        p = new Produit("H&M");
        p.setPrixProduit(6900);
        p.setIconProduit(R.drawable.ic_ensemblefemme5);
        p.setPhotoProduit(R.drawable.ic_ensemblefemme5);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements H&M pour Femme");
        produitList.add(p);

        p = new Produit("Nike");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_ensemblehomme1);
        p.setPhotoProduit(R.drawable.ic_ensemblehomme1);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements Nike pour Hemme");
        produitList.add(p);

        p = new Produit("Sportica Jeans");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_ensemblehomme2);
        p.setPhotoProduit(R.drawable.ic_ensemblehomme2);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements Sportiva Jeans pour Hemme");
        produitList.add(p);

        p = new Produit("Sportica Jeans");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_ensemblehomme3);
        p.setPhotoProduit(R.drawable.ic_ensemblehomme3);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements Sportiva Jeans pour Hemme");
        produitList.add(p);

        p = new Produit("Lacoste");
        p.setPrixProduit(7600);
        p.setIconProduit(R.drawable.ic_ensemblehomme4);
        p.setPhotoProduit(R.drawable.ic_ensemblehomme4);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements Lacoste pour Hemme");
        produitList.add(p);

        p = new Produit("FRA");
        p.setPrixProduit(8400);
        p.setIconProduit(R.drawable.ic_ensemblehomme5);
        p.setPhotoProduit(R.drawable.ic_ensemblehomme5);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Ensemble");
        p.setDetailProduit("Nouvelles survétements FRA pour Hemme");
        produitList.add(p);
/* -------------------------------------------------------------------------------  */
        p = new Produit("Bboy");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_pantalonenfant1);
        p.setPhotoProduit(R.drawable.ic_pantalonenfant1);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Nouvelles survétements Bboy pour Enfants");
        produitList.add(p);

        p = new Produit("Smartboy");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_pantalonenfant2);
        p.setPhotoProduit(R.drawable.ic_pantalonenfant2);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("SmartBoy fait sortir son nouveau paltalon pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Stboy");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_pantalonenfant3);
        p.setPhotoProduit(R.drawable.ic_pantalonenfant3);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("StBoy fait sortir son nouveau paltalon pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Kikid");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_pantalonenfant4);
        p.setPhotoProduit(R.drawable.ic_pantalonenfant4);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Kikid fait sortir son nouveau paltalon pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Basic");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_pantalonenfant5);
        p.setPhotoProduit(R.drawable.ic_pantalonenfant5);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Basic fait sortir son nouveau paltalon pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Prada");
        p.setPrixProduit(4400);
        p.setIconProduit(R.drawable.ic_pantalonfemme1);
        p.setPhotoProduit(R.drawable.ic_pantalonfemme1);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Prada fait sortir son nouveau paltalon pour femme");
        produitList.add(p);

        p = new Produit("Klein");
        p.setPrixProduit(4200);
        p.setIconProduit(R.drawable.ic_pantalonfemme2);
        p.setPhotoProduit(R.drawable.ic_pantalonfemme2);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Klein fait sortir son nouveau paltalon pour femme");
        produitList.add(p);

        p = new Produit("Gstar");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_pantalonfemme3);
        p.setPhotoProduit(R.drawable.ic_pantalonfemme3);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Gstar et le nouveau pantalon trés à la mode pour femme");
        produitList.add(p);

        p = new Produit("Jeans");
        p.setPrixProduit(8400);
        p.setIconProduit(R.drawable.ic_pantalonfemme4);
        p.setPhotoProduit(R.drawable.ic_pantalonfemme4);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Jeans présente le nouveau pantalon pour femme , trés élégant");
        produitList.add(p);

        p = new Produit("Gstar");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_pantalonfemme5);
        p.setPhotoProduit(R.drawable.ic_pantalonfemme5);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Gstar et le nouveau pantalon trés à la mode pour femme");
        produitList.add(p);

        p = new Produit("Gstar");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_pantalonhomme1);
        p.setPhotoProduit(R.drawable.ic_pantalonhomme1);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Gstar et le nouveau pantalon trés à la mode pour Homme");
        produitList.add(p);


        p = new Produit("Pull and Bear");
        p.setPrixProduit(8400);
        p.setIconProduit(R.drawable.ic_pantalonhomme2);
        p.setPhotoProduit(R.drawable.ic_pantalonhomme2);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("pantalon pour Homme , Pull and Bear , nouveau modéle disponible");
        produitList.add(p);


        p = new Produit("Jeans");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_pantalonhomme3);
        p.setPhotoProduit(R.drawable.ic_pantalonhomme3);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("Jeans et le nouveau pantalon trés à la mode pour Homme");
        produitList.add(p);


        p = new Produit("SuperStar");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_pantalonhomme4);
        p.setPhotoProduit(R.drawable.ic_pantalonhomme4);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("pantalon pour Homme , SuperStar , nouveau modéle disponible");
        produitList.add(p);

        p = new Produit("Grow");
        p.setPrixProduit(7700);
        p.setIconProduit(R.drawable.ic_pantalonhomme5);
        p.setPhotoProduit(R.drawable.ic_pantalonhomme5);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Pantalon");
        p.setDetailProduit("pantalon pour Homme , Grow , nouveau modéle disponible");
        produitList.add(p);

        p = new Produit("Addict");
        p.setPrixProduit(1400);
        p.setIconProduit(R.drawable.ic_tshirtenfant1);
        p.setPhotoProduit(R.drawable.ic_tshirtenfant1);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour enfants");
        produitList.add(p);

        p = new Produit("Attorney");
        p.setPrixProduit(4000);
        p.setIconProduit(R.drawable.ic_tshirtenfant2);
        p.setPhotoProduit(R.drawable.ic_tshirtenfant2);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour enfants");
        produitList.add(p);

        p = new Produit("Addict");
        p.setPrixProduit(1400);
        p.setIconProduit(R.drawable.ic_tshirtenfant3);
        p.setPhotoProduit(R.drawable.ic_tshirtenfant3);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour enfants");
        produitList.add(p);

        p = new Produit("SuperTeam");
        p.setPrixProduit(1400);
        p.setIconProduit(R.drawable.ic_tshirtenfant4);
        p.setPhotoProduit(R.drawable.ic_tshirtenfant4);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour enfants");
        produitList.add(p);

        p = new Produit("American Standard");
        p.setPrixProduit(1400);
        p.setIconProduit(R.drawable.ic_tshirtenfant5);
        p.setPhotoProduit(R.drawable.ic_tshirtenfant5);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour enfants");
        produitList.add(p);




        p = new Produit("Boss");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_tshirtfemme1);
        p.setPhotoProduit(R.drawable.ic_tshirtfemme1);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour Femme");
        produitList.add(p);

        p = new Produit("Klein");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_tshirtfemme2);
        p.setPhotoProduit(R.drawable.ic_tshirtfemme2);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour Femme");
        produitList.add(p);

        p = new Produit("Guess");
        p.setPrixProduit(2700);
        p.setIconProduit(R.drawable.ic_tshirtfemme3);
        p.setPhotoProduit(R.drawable.ic_tshirtfemme3);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour Femme");
        produitList.add(p);

        p = new Produit("Diapora");
        p.setPrixProduit(3500);
        p.setIconProduit(R.drawable.ic_tshirtfemme4);
        p.setPhotoProduit(R.drawable.ic_tshirtfemme4);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour Femme");
        produitList.add(p);

        p = new Produit("Clarex");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_tshirtfemme5);
        p.setPhotoProduit(R.drawable.ic_tshirtfemme5);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour Femme");
        produitList.add(p);



        p = new Produit("GBoss");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_tshirthomme1);
        p.setPhotoProduit(R.drawable.ic_tshirthomme1);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour homme");
        produitList.add(p);

        p = new Produit("FreeMan");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_tshirthomme2);
        p.setPhotoProduit(R.drawable.ic_tshirthomme2);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour homme");
        produitList.add(p);

        p = new Produit("Calvin");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_tshirthomme3);
        p.setPhotoProduit(R.drawable.ic_tshirthomme3);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour homme");
        produitList.add(p);

        p = new Produit("NYC");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_tshirthomme4);
        p.setPhotoProduit(R.drawable.ic_tshirthomme4);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour homme");
        produitList.add(p);

        p = new Produit("Gstar");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_tshirthomme5);
        p.setPhotoProduit(R.drawable.ic_tshirthomme5);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Tshirt");
        p.setDetailProduit("Tshirt à la mode , trés comfortable pour homme");
        produitList.add(p);







        p = new Produit("J&J");
        p.setPrixProduit(5400);
        p.setIconProduit(R.drawable.ic_vesteenfant1);
        p.setPhotoProduit(R.drawable.ic_vesteenfant1);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Veste trés jolie pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Hengtong");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_vesteenfant2);
        p.setPhotoProduit(R.drawable.ic_vesteenfant2);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Veste trés jolie pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("kLa");
        p.setPrixProduit(8700);
        p.setIconProduit(R.drawable.ic_vesteenfant3);
        p.setPhotoProduit(R.drawable.ic_vesteenfant3);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Veste trés jolie pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("TheBoy");
        p.setPrixProduit(6200);
        p.setIconProduit(R.drawable.ic_vesteenfant4);
        p.setPhotoProduit(R.drawable.ic_vesteenfant4);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Veste trés jolie pour enfants 4-12 ans");
        produitList.add(p);

        p = new Produit("Glove");
        p.setPrixProduit(4200);
        p.setIconProduit(R.drawable.ic_vesteenfant5);
        p.setPhotoProduit(R.drawable.ic_vesteenfant5);
        p.setTypeProduit("Enfants");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Veste trés jolie pour enfants 4-12 ans");
        produitList.add(p);


        p = new Produit("D&J");
        p.setPrixProduit(7400);
        p.setIconProduit(R.drawable.ic_vestefemme1);
        p.setPhotoProduit(R.drawable.ic_vestefemme1);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par la marque D&J");
        produitList.add(p);

        p = new Produit("Nike");
        p.setPrixProduit(3400);
        p.setIconProduit(R.drawable.ic_vestefemme2);
        p.setPhotoProduit(R.drawable.ic_vestefemme2);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("Nike revient avec la nouvelle collection de veste pour femme");
        produitList.add(p);

        p = new Produit("D&J");
        p.setPrixProduit(2400);
        p.setIconProduit(R.drawable.ic_vestefemme3);
        p.setPhotoProduit(R.drawable.ic_vestefemme3);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par la marque D&J");
        produitList.add(p);

        p = new Produit("D&J");
        p.setPrixProduit(6400);
        p.setIconProduit(R.drawable.ic_vestefemme4);
        p.setPhotoProduit(R.drawable.ic_vestefemme4);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par la marque D&J");
        produitList.add(p);

        p = new Produit("Unkut");
        p.setPrixProduit(9800);
        p.setIconProduit(R.drawable.ic_vestefemme5);
        p.setPhotoProduit(R.drawable.ic_vestefemme5);
        p.setTypeProduit("Femme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Unkut");
        produitList.add(p);



        p = new Produit("Lacoste");
        p.setPrixProduit(19800);
        p.setIconProduit(R.drawable.ic_vestehomme1);
        p.setPhotoProduit(R.drawable.ic_vestehomme1);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Lacsote pour Homme");
        produitList.add(p);

        p = new Produit("Awhite");
        p.setPrixProduit(7600);
        p.setIconProduit(R.drawable.ic_vestehomme2);
        p.setPhotoProduit(R.drawable.ic_vestehomme2);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Awhite pour Homme");
        produitList.add(p);

        p = new Produit("Clarks");
        p.setPrixProduit(8600);
        p.setIconProduit(R.drawable.ic_vestehomme3);
        p.setPhotoProduit(R.drawable.ic_vestehomme3);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Clarks pour Homme");
        produitList.add(p);

        p = new Produit("Awhite");
        p.setPrixProduit(8200);
        p.setIconProduit(R.drawable.ic_vestehomme4);
        p.setPhotoProduit(R.drawable.ic_vestehomme4);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Awhite pour Homme");
        produitList.add(p);

        p = new Produit("Nike");
        p.setPrixProduit(5300);
        p.setIconProduit(R.drawable.ic_vestehomme5);
        p.setPhotoProduit(R.drawable.ic_vestehomme5);
        p.setTypeProduit("Homme");
        p.setCategorieProduit("Veste");
        p.setDetailProduit("de trés belles veste sont proposées par Nike pour Homme");
        produitList.add(p);

        return produitList;
    }

    public List<Produit> getProduitListParCategorie(String newCategorie){
        List<Produit> listeP = new ArrayList<>();

        if(newCategorie.equals("Tous")){
            listeP = getProduitList();
        }else
        {
            for (int i=0;i<getProduitList().size();i++){
                if ((getProduitList().get(i).getCategorieProduit().toUpperCase().equals(newCategorie.toUpperCase()))){
                    listeP.add(getProduitList().get(i));
                }
            }
        }

        return listeP;
    }

    public boolean isTwoPane() {

        View v  = getActivity().findViewById(R.id.frameLayout);
        return (v!=null);

    }

    public void showView (Produit p) {
        if (isTwoPane()) {
            FragmentDetail detailFragment = new FragmentDetail();
            Bundle bundle = new Bundle();
            bundle.putSerializable("produit", p);
            detailFragment.setArguments(bundle);
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, detailFragment);

            ft.commit();

        } else {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("produit", p);
            startActivity(intent);
        }

    }
}
