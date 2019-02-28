package it.hashcode.sevincomilicenzio.fanculo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Util {

	public static List<Photo> readFile(String inputpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Slide> preprocessPhase(List<Photo> photos) {
		long start = System.currentTimeMillis();
		Collections.shuffle(photos);
		
		List<Slide> returnList = new ArrayList<Slide>();

		Photo tmpPhoto1 = new Photo();
		Photo tmpPhoto2 = new Photo();
		boolean isFirstPhoto = true;
		for(Photo p : photos) {
			
			if(p.getOrientamento() == 1) {
				if(isFirstPhoto) {
					tmpPhoto1 = p;
					isFirstPhoto = false;
				} else {
					tmpPhoto2 = p;
					Slide tmpSlide = new Slide(tmpPhoto1, tmpPhoto2);
					returnList.add(tmpSlide);
					tmpPhoto1 = new Photo();
					tmpPhoto2 = new Photo();
					isFirstPhoto = true;
				}
			} else {
				returnList.add(new Slide(p, null));
			}
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		return returnList;
	}

	public static List<Slide> calulatingPhase(List<Slide> slides) {
		long start = System.currentTimeMillis();
		List<Slide> returnList =  new ArrayList<Slide>();
		
		returnList.sort(c);
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		return returnList;
	}

	public static void writeFile(List<Slide> slides, String outputpath) {
		// TODO Auto-generated method stub
		
	}

}
