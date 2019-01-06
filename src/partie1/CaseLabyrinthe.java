package partie1;

public class CaseLabyrinthe {

    private boolean haut;
    private boolean gauche;
    private boolean bas;
    private boolean droite;

    public CaseLabyrinthe() {
        this.haut = true;
        this.gauche = true;
        this.bas = true;
        this.droite = true;
    }

    public CaseLabyrinthe(boolean haut, boolean gauche, boolean bas, boolean droite) {
        this.haut = haut;
        this.gauche = gauche;
        this.bas = bas;
        this.droite = droite;
    }

    public boolean isHaut() {
        return haut;
    }

    public boolean isGauche() {
        return gauche;
    }

    public boolean isBas() {
        return bas;
    }

    public boolean isDroite() {
        return droite;
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

}
