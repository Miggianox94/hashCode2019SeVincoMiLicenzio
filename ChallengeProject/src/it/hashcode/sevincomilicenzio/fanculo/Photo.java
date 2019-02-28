package it.hashcode.sevincomilicenzio.fanculo;

import java.util.Set;

public class Photo {

	//0=horizontal; 1=vertical
	private int orientamento;
	private Set<String> tags;
	int id;
	
	public int getOrientamento() {
		return orientamento;
	}
	public void setOrientamento(int orientamento) {
		this.orientamento = orientamento;
	}
	
	
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Photo() {
		super();
	}
	public Photo(int orientamento, Set<String> tags, int id) {
		super();
		if(orientamento != 1 && orientamento != 0) {
			throw new RuntimeException("SUCA STRONZO");
		}
		this.orientamento = orientamento;
		this.tags = tags;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Photo [orientamento=" + orientamento + ", tags=" + tags + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Photo other = (Photo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
