package it.hashcode.sevincomilicenzio.fanculo;

import java.util.HashSet;
import java.util.Set;

public class Slide {

	private Photo photo1;
	private Photo photo2;
	private Set<String> tags;
	private boolean taken;

	public Slide(Photo photo1, Photo photo2) {
		super();
		this.photo1 = photo1;
		this.photo2 = photo2;
		tags = new HashSet<>();
		tags.addAll(photo1.getTags());

		if (photo2 != null)
			tags.addAll(photo2.getTags());
		taken = false;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public Photo getPhoto1() {
		return photo1;
	}

	public void setPhoto1(Photo photo1) {
		this.photo1 = photo1;
	}

	public Photo getPhoto2() {
		return photo2;
	}

	public void setPhoto2(Photo photo2) {
		this.photo2 = photo2;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		if (photo2 == null)
			return String.valueOf(photo1.getId());
		else
			return String.valueOf(photo1.getId() + " " + photo2.getId());
	}

}
