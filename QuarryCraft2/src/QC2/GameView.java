package QC2;

import java.util.ArrayList;
import java.util.Random;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class GameView extends GContainer{
	public GameView(){
	setSize(1000, 600);
	GSprite bg1 = ImageCache.getSprite("qc2_bg1.png");
	bg1.setAnchorCenter(); 
	 addAtCenter(bg1);
 for (int i = 0; i<=20;i++){
		randomArray.get(i);
	 }
	}
	 public static ArrayList<Integer> RandomArray(int n)   {
		 
		    ArrayList<Integer> randomArray = new ArrayList<Integer>(n);         
		    Random randNumGenerator = new Random();                            
		    for (int i = 0; i < n; i++){                                       
		        randomArray.add(new Integer(randNumGenerator.nextInt(20)));    
		    }
		    return randomArray;                                                

		}
	
}
	 
