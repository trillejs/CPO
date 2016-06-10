package noeud;

public class AdresseIP implements Comparable<AdresseIP>{

	/** Tableau d'entiers qui stocke les 4 nombres entiers formant l'adresse IP */
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
            ip += Integer.toString(adresse[i]);
            ip += ".";
        }
        ip = ip.substring(0, ip.length()-1);
        return ip;
    }
    
    /**
     * Compare deux adresses IP
     * @param ip adresse a comparer
     * Precondition : ip != null
     * @return vrai si les adresses sont egales, faux sinon
     */
    @Override
    public boolean equals(Object  obj){
    	if(obj == null) {
            return false;
        }
        if(!(obj instanceof AdresseIP)) {
            return false;
        }
    	AdresseIP ip = (AdresseIP) obj;
    	return this.adresse[0]==ip.adresse[0] 
    			&& this.adresse[1]==ip.adresse[1] 
    			&& this.adresse[2]==ip.adresse[2]
    			&& this.adresse[3]==ip.adresse[3];
    }

    public int compareTo(AdresseIP adresse2)
    {
    	int result = -2;
    	if(this.equals(adresse2))
    	{
    		result = 0;
    	}
    	else if(this.inferior(adresse2))
    	{
    		result = -1;
    	}
    	else if(this.superior(adresse2))
    	{
    		result = 1;
    	}
    	return result;
    }
    
    public boolean inferior(AdresseIP adresse2)
    {
    	boolean inferior = true;
    	int i =0;
    	while(i < this.adresse.length && inferior)
    	{
    		if(this.adresse[i] > adresse2.adresse[i])
    		{
    			inferior = false;
    		}   		
    		i++;
    	}
    	//On a parcouru toute la liste ou this est supérieur
    	return inferior;
    }
    
    public boolean superior(AdresseIP adresse2)
    {
    	boolean superior = true;
    	int i =0;
    	while(i < this.adresse.length && superior)
    	{
    		if(this.adresse[i] < adresse2.adresse[i])
    		{
    			superior = false;
    		}   		
    		i++;
    	}
    	//On a parcouru toute la liste ou this est inférieur
    	return superior;
    }
    
    /**
     * Retourne la taille de l'adresse IP
     * @return taille de l'adresse IP
     */
    public int getTaille()
    {
    	return this.adresse.length;
    }
    
    /** Surcharge de la méthode HashCode pour la comparaison dans les hashmap utilisant une AdresseIP
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode(){
    	String temp = ""+this.adresse[0]+this.adresse[1]+this.adresse[2]+this.adresse[3];
		return Integer.parseInt(temp);
    	
    }
    
}