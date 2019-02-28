package it.hashcode.sevincomilicenzio.fanculo;

import java.util.List;

public class MainApp {

	private final static String inputPath = "./input";
	private final static String outputPath = "./output";
	
	public static void main(String[] args) {
		
		List<Photo> photos = Util.readFile(inputPath);
		photos = Util.preprocessPhase(photos);
		List<Slide> slides = Util.calulatingPhase(photos);
		
		Util.writeFile(slides ,outputPath);
	}
	
}
