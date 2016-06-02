package noeud;

public class AdresseIP {

    private int adresse[];

    /**AdresseIp
     * Constructeur à partir des valeurs des quatre octets
     * @param o0 - int : Premier octet de l'adresse ip
     * @param o1 - int : Deuxième octet de l'adresse ip
     * @param o2 - int : Troisième octet de l'adresse ip
     * @param o3 - int : Quatrième octet de l'adresse ip
     * Précondition : 0 <= param <= 255 
     */
    public AdresseIP(int o0, int o1, int o2, int o3) {
    	this.adresse = new int[4];
        adresse[0] = o0;
        adresse[1] = o1;
        adresse[2] = o2;
        adresse[3] = o3;
    }

    /**
     * Retourne l'adresse IP
     * @return int []
     */
    public int[] getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        String ip = new String();
        for (int i = 0; i < 4; i++) {
            ip += adresse[i];
            ip += ".";
        }
        ip = ip.substring(0, ip.length()-1);
        return ip;
    }
    
    public boolean equals(AdresseIP ip){
    	return this.adresse[0]==ip.adresse[0] 
    			&& this.adresse[1]==ip.adresse[1] 
    			&& this.adresse[2]==ip.adresse[2]
    			&& this.adresse[3]==ip.adresse[3];
    }
    
}