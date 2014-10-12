
public class Bird {
	
	private String name;
	private String difficulty;
	private String url;
	private String extraInfo;
	private String photoLocation;
	private String photoDate;
	
	public Bird(String name, String difficulty, String url, String extraInfo, String photoLocation, String photoDate){
		this.name = name;
		this.difficulty = difficulty;
		this.url = url;
		this.extraInfo = extraInfo;
		this.photoLocation = photoLocation;
		this.photoDate = photoDate;
	}
	
	public String getName(){
		return name;
	}
	
	public String getURL(){
		return url;
	}
	
	public String getDifficulty(){
		return difficulty;
	}
	
	public String getExtraInfo(){
		return extraInfo;
	}
	
	public String getPhotoLocation(){
		return photoLocation;
	}
	
	public String getPhotoDate(){
		return photoDate;
	}
	

}
