package nassim.doum.models;

import java.io.Serializable;

/**
 * Created by tread on 18/04/2016.
 */
public class ElementChariot implements Serializable {

    private Produit produit;
    private int quantite;

    public ElementChariot() {
    }

    public ElementChariot(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
