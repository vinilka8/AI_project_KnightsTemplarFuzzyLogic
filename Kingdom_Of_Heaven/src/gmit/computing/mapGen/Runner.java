package gmit.computing.mapGen;

import gmit.computing.people.FriendlyCharacters;
import gmit.computing.people.GameCharacter;
import gmit.computing.people.MyHero;
import gmit.computing.things.Items;

import java.util.List;

public class Runner{
	public static List<Location> locations;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		p.nazovikakhochew();
		locations = p.getLocation();
		GameMap gm = new GameMap();		
		MyHero myHero = new MyHero();
		FriendlyCharacters fc = new FriendlyCharacters();
		
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
		
		String temp = "";
		while(temp != "exit"){
			temp = InputClass.start();
			if(temp != "exit"){
				myHero.executeAction(temp);
			}
		};
	}
}
