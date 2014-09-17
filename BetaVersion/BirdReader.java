import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BirdReader{
	
	private String filename = "resources/starter_birdlist2.csv";
	private ArrayList<Bird> list;
	private BufferedReader br = null;
	private String line = "";
	
	Random rand = new Random();
	int index = rand.nextInt(5);
		
	public BirdReader(){		
		list = new ArrayList<Bird>();
		try{			
			br = new BufferedReader(new FileReader(filename));
			while((line = br.readLine())!=null){
				String[] bird = line.split(",");
				for(int i=0; i<bird.length; i=i+2){
					list.add(new Bird(bird[i],bird[i+1]));
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
	
}	

	