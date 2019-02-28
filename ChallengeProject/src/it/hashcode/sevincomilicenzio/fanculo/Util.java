package it.hashcode.sevincomilicenzio.fanculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Util {

	private static String outputFileName = "a.txt";
	
	public static List<Photo> readFile(String inputpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Photo> preprocessPhase(List<Photo> photos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Slide> calulatingPhase(List<Photo> photos) {
		// TODO Auto-generated method stub
		return null;
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
			System.out.println(ex.getStackTrace());
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		
		System.out.println(timeElapsed);
	}

}
