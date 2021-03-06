package it.hashcode.sevincomilicenzio.fanculo;

import java.util.List;

public class MainApp {

	private final static String inputPath = "./input";
	private final static String outputPath = "./output";
	
	public static void main(String[] args) throws Exception {
		
		List<Photo> photos = Util.readFile(inputPath);

		System.out.println("########### READ PHASE FINISHED #############");
		List<Slide> slides = Util.preprocessPhase(photos);
		System.out.println("########### PREPROCESS PHASE FINISHED #############");
		slides = Util.calulatingPhase(slides);
		System.out.println("########### CALCULATING PHASE FINISHED #############");
		Util.writeFile(slides,outputPath);
		System.out.println("########### WRITE PHASE FINISHED #############");
		
		Util.writeFile(slides ,outputPath);
	}
	
}
