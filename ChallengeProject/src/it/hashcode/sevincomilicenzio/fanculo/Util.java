package it.hashcode.sevincomilicenzio.fanculo;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
=======
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
>>>>>>> branch 'master' of https://github.com/Miggianox94/hashCode2019SeVincoMiLicenzio.git
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.io.FileUtils;

public class Util {

	private static final String INPUTFILE = "input_A.txt";

	public static List<Photo> readFile(String inputpath) throws IOException {
		long start = System.currentTimeMillis();
		List<Photo> toReturn = new ArrayList<>();
		File file = new File(inputpath + File.separatorChar + INPUTFILE);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		boolean firtstLine = true;
		for(String line : lines) {
			Photo singlePhoto = new Photo();
			if(firtstLine) {
				firtstLine = false;
				continue;
			}
			String[] parts = line.split(" ");
			int orientation = parts[0].equals("H")?0:1;
			Set<String> tags = new HashSet<>();
			for(int i = 2; i<parts.length;i++) {
				tags.add(parts[i]);
			}
			singlePhoto.setOrientamento(orientation);
			singlePhoto.setTags(tags);
			toReturn.add(singlePhoto);
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toReturn;

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
