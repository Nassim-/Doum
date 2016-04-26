package nassim.doum.models;

import java.io.Serializable;

public class Produit implements Serializable {

    private String nomProduit;
    private String detailProduit;
    private String categorieProduit;
    private String typeProduit;
    private float prixProduit;
    private int photoProduit;
    private int iconProduit;

    public Produit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDetailProduit() {
        return detailProduit;
    }

    public void setDetailProduit(String detailProduit) {
        this.detailProduit = detailProduit;
    }

    public float getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(String categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public int getIconProduit() {
        return iconProduit;
    }

    public void setIconProduit(int iconProduit) {
        this.iconProduit = iconProduit;
    }

    public int getPhotoProduit() {
        return photoProduit;
    }

    public void setPhotoProduit(int photoProduit) {
        this.photoProduit = photoProduit;
    }
}
