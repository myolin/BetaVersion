import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BirdReader{
	
	private final String filename = "resources/full_birdlist.csv";
	private ArrayList<Bird> list;
	String[] bird;
			
	public BirdReader(){		
		list = new ArrayList<Bird>();
		BufferedReader br = null;
		String line = "";
		try{			
			br = new BufferedReader(new FileReader(filename));
			while((line = br.readLine())!=null){
				bird = line.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
				for(int i=0; i<bird.length; i=i+6){
					list.add(new Bird(bird[i], bird[i+1], bird[i+2], bird[i+3], bird[i+4], bird[i+5]));
				}
			}		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public ArrayList<Bird> getBirdArray(){
		return list;
	}		
	
	public String[] getBird(){
		return bird;
	}
	
	public static void main(String[] args){
		BirdReader reader = new BirdReader();
		String[] bird = reader.getBird();
		for(String s: bird){
			System.out.println(s);
		}
	}
}	

	