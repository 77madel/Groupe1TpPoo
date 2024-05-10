public class CompagnieAerienne{
    private int id_comp;
    private String nom_comp;
    private int nbred_avion;
    private String mdp;
    private String siteWeb;
    private int admin_id; // Clé étrangère vers la table Admin

    // Constructeur
    public CompagnieAerienne(int id_comp, String nom_comp, int nbred_avion, String mdp, String siteWeb, int admin_id) {
        this.id_comp = id_comp;
        this.nom_comp = nom_comp;
        this.nbred_avion = nbred_avion;
        this.mdp = mdp;
        this.siteWeb = siteWeb;
        this.admin_id = admin_id;
    }

    // Getters et setters
    public int getId_comp() {
        return id_comp;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public String getNom_comp() {
        return nom_comp;
    }

    public void setNom_comp(String nom_comp) {
        this.nom_comp = nom_comp;
    }

    public int getNbred_avion() {
        return nbred_avion;
    }

    public void setNbred_avion(int nbred_avion) {
        this.nbred_avion = nbred_avion;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getNbre_d_avion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNbre_d_avion'");
    }
}