package gmit.computing.mapGen;

import gmit.computing.people.FriendlyCharacters;
import gmit.computing.people.GameCharacter;
import gmit.computing.people.MyHero;
import gmit.computing.things.Items;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Runner extends Applet{
	public static List<Location> locations;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		p.nazovikakhochew();
		locations = p.getLocation();
		GameMap gm = new GameMap();		
		MyHero myHero = new MyHero();
		FriendlyCharacters fc = new FriendlyCharacters();
		
		
		/*File sourceimage = new File("c:\\aleppo.png");
		try {
			Image image = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Image image = null;
        try {
        	
            URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
      
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
		*/
		for(Location loc : gm.getLocation()){
			if(loc.getName().equalsIgnoreCase("Antioch")){
				myHero.setLocation(loc);
				System.out.println("Your hero start in : \t" + myHero.getLocation().getName());
				System.out.println("About town :\t\t" + myHero.getLocation().getDescription());
				break;	
			}
		}
		
		System.out.println("--------------------");
		System.out.println("Exits : ");
		for (Location loc:myHero.getLocation().getExits())
		{
			System.out.println("\t\t\t" + loc.getName()  + " -->> " + loc.getDirect());
		}
		System.out.println("--------------------");
		System.out.println("People in here : \t");
		for(GameCharacter gc : myHero.getLocation().getObservers())
		{
			System.out.println("\t\t\t" + gc.getName());
		}
		System.out.println("--------------------");
		
		
		for(Location loc : gm.getLocation()){
			if(loc.getName().equalsIgnoreCase("Antioch")){
				myHero.setLocation(loc);
				System.out.println("Items in : " + myHero.getLocation().getName());
				for(Items it :  myHero.getLocation().getItems())
				{
					System.out.print("\t\t\t" + it.getName() + " -> with stenght of -> " + it.getStrennght());
					System.out.println();
				}
				break;
			}
		}
		 
		
		/*try{
	          BufferedImage image = ImageIO.read(new File("/img/aleppo.png"));

	         // image.getGraphics().drawLine(1, 1, image.getWidth()-1, image.getHeight()-1);
	         // image.getGraphics().drawLine(1, image.getHeight()-1, image.getWidth()-1, 1);

	         // ImageIO.write(image, "png", new File("/img/aleppo.png"));
	     }
	     catch (IOException e){
	         e.printStackTrace();
	     }*/
		
		String temp = "";
		while(temp != "exit"){
			temp = InputClass.start();
			if(temp != "exit"){
				myHero.executeAction(temp);
			}
		};
	}
}
