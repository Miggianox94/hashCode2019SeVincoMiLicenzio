package it.hashcode.sevincomilicenzio.fanculo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class Util {

	private static String outputFileName = "E.txt";
	private static final String INPUTFILE = "input_E.txt";
	private static final int intorno = 20;

	public static List<Photo> readFile(String inputpath) throws IOException {
		long start = System.currentTimeMillis();
		List<Photo> toReturn = new ArrayList<>();
		File file = new File(inputpath + File.separatorChar + INPUTFILE);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		boolean firtstLine = true;
		int counter = -1;
		for(String line : lines) {
			Photo singlePhoto = new Photo();
			if(firtstLine) {
				firtstLine = false;
				continue;
			}
			counter++;
			String[] parts = line.split(" ");
			int orientation = parts[0].equals("H")?0:1;
			Set<String> tags = new HashSet<>();
			for(int i = 2; i<parts.length;i++) {
				tags.add(parts[i]);
			}
			singlePhoto.setOrientamento(orientation);
			singlePhoto.setTags(tags);
			singlePhoto.setId(counter);
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
		System.out.println("---------------TIME ELAPSED PREPROCESSING : "+timeElapsed);
		return returnList;
	}

	public static List<Slide> calulatingPhase(List<Slide> slides) {
		long start = System.currentTimeMillis();
		List<Slide> returnList =  new ArrayList<Slide>();
		
		Collections.sort(slides, 
				(o1,o2) -> o1.getTags().size() - o2.getTags().size());
		for(Slide slide : slides) {
			System.out.println("BASTARDO AAAAAAAA");
			if(slide.isTaken()) {
				continue;
			}
			slide.setTaken(true);
			returnList.add(slide);
			Slide bestSlide = calculateBestSlide(slide,slides);
			if(bestSlide == null) {
				break;
			}
			bestSlide.setTaken(true);
			returnList.add(bestSlide);
		}
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED CALCULATING : "+timeElapsed);
		return returnList;
	}
	
	private static Slide calculateBestSlide(Slide slide, List<Slide> slides) {
	int counter = 0;
	Slide bestSlide = null;
	int bestScore = -1;
	while(counter < intorno && counter < slides.size()) {
		Slide current = slides.get(counter);
		if(!current.isTaken()) {
			int score = calculateScore(slide,current);
			if(score > bestScore) {
				bestScore = score;
				bestSlide = current;
			}
		}
			counter++;
		}
		return bestSlide;
	}
	
	private static int calculateScore(Slide slide, Slide secondSlide) {
		Set<String> tags1 = slide.getTags();
		Set<String> tags2 = slide.getTags();
		int lowest = Integer.MAX_VALUE;
		
		//intersection
		Set<String> intersection = new HashSet<String>(tags1);
		intersection.retainAll(tags2);
		int intersectSize = intersection.size();
		if(intersectSize < lowest) {
			lowest = intersectSize;
		}
		
		//1-2
		Set<String> s1minuss2 = new HashSet<String>(tags1);
		s1minuss2.removeAll(tags2);
		int s1minuss2Size = s1minuss2.size();
		if(s1minuss2Size < lowest) {
			lowest = s1minuss2Size;
		}
		
		//2-1
		Set<String> s2minuss1 = new HashSet<String>(tags2);
		s2minuss1.removeAll(tags1);
		int s2minuss1Size = s2minuss1.size();
		if(s2minuss1Size < lowest) {
			lowest = s2minuss1Size;
		}
		
		return lowest;
	}
	
	public static void writeFile(List<Slide> slides, String outputpath) {
		long start = System.currentTimeMillis();

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputpath+'/'+outputFileName)))
		{
			// Stampa numero di slide
			writer.write(slides.size()+"\n");
			
			// Stampa l'id delle foto contenute in ciascuna slide, una slide per riga
			for(int i = 0; i < slides.size(); i++)
			{
				writer.write(slides.get(i).toString()+"\n");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Scoppiato in scrittura: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		
		System.out.println(timeElapsed);
	}

}
