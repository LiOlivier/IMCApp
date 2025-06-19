package fr.einfolearning.imc;

public class CalculIMC {
    private float poids;
    private float taille;

    public CalculIMC(float poids, float taille) {
        this.poids = poids;
        this.taille = taille;
    }

    public float calculer() throws Exception {
        if (taille <= 0 || poids <= 0) {
            throw new Exception("Taille ou poids invalide !");
        }
        return poids / (taille * taille);
    }

    public String interpreter() throws Exception {
        float imc = calculer();
        if (imc < 18.5) return "Maigreur";
        else if (imc < 25) return "Poids normal";
        else if (imc < 30) return "Surpoids";
        else return "Obésité";
    }
}
