import java.util.*;

public class Question {
	
	private String correctBirdName;
	private String correctBirdUrl;
	private ArrayList<String> incorrectBirdNames = new ArrayList<String>();
	
	private Random rand = new Random();
	
		
	public Question(ArrayList<Bird> birdArray, int numChoices)
	{
		int index = rand.nextInt(birdArray.size());
		correctBirdName = birdArray.get(index).getName();
		correctBirdUrl = birdArray.get(index).getURL();
		
		while (incorrectBirdNames.size() < numChoices - 1)
		{
			int newIndex = rand.nextInt(birdArray.size());
			String possibleBirdName = birdArray.get(newIndex).getName();
			if (!possibleBirdName.equals(correctBirdName) && !incorrectBirdNames.contains(possibleBirdName))
			{
				incorrectBirdNames.add(possibleBirdName);
			}
		}
	}
	
	/*public void printQuestion()
	{
		System.out.print("Question correct="+correctBirdName + " incorrect={");
	
		for (String name : incorrectBirdNames)
		{
			System.out.print(name + ","); 
		}
		System.out.println("}");

	}*/
	
	public String getCorrectBirdName(){
		return correctBirdName;
	}
	
	public ArrayList<String> getInocrrectBirdNames(){
		return incorrectBirdNames;
	}
	
	public String getCorrectBirdUrl(){
		return correctBirdUrl;
	}
	
	
		
	// this is just for testing the Question class.  (Not production code)
	/*public static void main(String[] args){
		BirdReader reader = new BirdReader();
		ArrayList<Bird> birdArray = reader.getBirdArray();
		
		Question q = new Question(birdArray, 3);
		Question q2 = new Question(birdArray, 3);
		
		q.printQuestion();
		q2.printQuestion();
		//System.out.print(q.correctBird + " " + q.incorrectBird1);
		//System.out.print(q2.birdArray.get(0).getName());
		
	}*/

}
