package noeud;


/**
 * 
 */
public class AdresseIP {

    private int adresse[4];

    /**AdresseIp
     * Constructeur à partir des valeurs des quatre octets
     * @param o0 - int : Premier octet de l'adresse ip
     * @param o1 - int : Deuxième octet de l'adresse ip
     * @param o2 - int : Troisième octet de l'adresse ip
     * @param o3 - int : Quatrième octet de l'adresse ip
     */
    public AdresseIP(int o0, int o1, int o2, int o3) {
        adresse[0] = o0;
        adresse[1] = o1;
        adresse[2] = o2;
        adresse[3] = o3;
    }

    public int[] getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        String ip;
        for (int i = 0; i < 4; i++) {
            ip += adresse[i];
            ip += ".";
        }
        ip = ip.substring(0, ip.length()-1);
        return ip;
    }
}