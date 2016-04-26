package nassim.doum.models;

/**
 * Created by tread on 07/04/2016.
 */
public class Utilisateur {
    public String loginUtilisateur;
    public String mdpUtilisateur;
    public String nomUtilisateur;
    public int avatarUtilisateur;


    public Utilisateur(String loginUtilisateur, String mdpUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
        this.mdpUtilisateur = mdpUtilisateur;
    }

    public String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
    }

    public String getMdpUtilisateur() {
        return mdpUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur) {
        this.mdpUtilisateur = mdpUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public int getAvatarUtilisateur() {
        return avatarUtilisateur;
    }

    public void setAvatarUtilisateur(int avatarUtilisateur) {
        this.avatarUtilisateur = avatarUtilisateur;
    }
}
