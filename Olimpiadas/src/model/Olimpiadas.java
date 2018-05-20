package model;



public class Olimpiadas {
	private int ouro;
	private int prata;
	private int bronze;
	public Olimpiadas(int ouro, int prata, int bronze) {
		
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
	}
	public Olimpiadas() {
		
	}
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	@Override
	public String toString() {
		return "Olimpiadas [ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bronze;
		result = prime * result + ouro;
		result = prime * result + prata;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiadas other = (Olimpiadas) obj;
		if (bronze != other.bronze)
			return false;
		if (ouro != other.ouro)
			return false;
		if (prata != other.prata)
			return false;
		return true;
	}
	
	
	

}
