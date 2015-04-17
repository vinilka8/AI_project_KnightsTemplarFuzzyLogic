package gmit.computing.people;

import gmit.computing.mapGen.GameMap;
import gmit.computing.mapGen.InputClass;
import gmit.computing.mapGen.Location;
import gmit.computing.things.Consumable;
import gmit.computing.things.Items;
import gmit.computing.things.QuestItem;
import gmit.computing.things.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

//MOVE need to fix
//USE need to fix

public class MyHero implements GameCharacter {
	private String name;
	private float hp = 50;
	private Location location;
	private int Strenght;
	private String descriptionchar;
	private List<Items> items = new ArrayList<Items>();
	private List<GameCharacter> gc = new ArrayList<GameCharacter>();

	public void setDescriptionChar(String descriptionchar) {
		this.descriptionchar = descriptionchar;
	}

	public String getDescriptionChar() {
		return this.descriptionchar;
	}

	public MyHero() {
		super();
		loadFuzzyFile();
		//loadFuzzyFileFood();
	}

	FIS fis;

	public void loadFuzzyFile() {
		String fileName = "conf/rules.fcl";// contains all fuzzy sets
		fis = FIS.load(fileName, true); // Load and parse the FCL
		// Error while loading?
		if (fis == null) {
			System.err.println("Can't load file: '" + fileName + "'");
			return;
		}
	}
	
	/*public void loadFuzzyFileFood(){
		String fileName = "conf/foodRules.fcl";// contains all fuzzy sets
		fis = FIS.load(fileName, true); // Load and parse the FCL
		// Error while loading?
		if (fis == null) {
			System.err.println("Can't load file: '" + fileName + "'");
			return;
		}
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItem(List<Items> item) {
		this.items = item;
	}

	public List<Items> getitems() {
		return items;
	}

	public void setitems(List<Items> itemsos) {
		this.items = itemsos;
	}

	public float getHp() {
		return hp;

	}

	public void setHp(float hp) {
		this.hp = hp;

	}

	@Override
	public void take(String itemsos) {
		// TODO Auto-generated method stub
		for (Items i : location.getItems()) {
			// System.out.println(" from for " + itemsos);
			if (i.getName().equalsIgnoreCase(itemsos))// otherwise use item
			{
				System.out.println("You choose to take a " + i.getName() + " - with the strengh - " + i.getStrennght());
				items.add(i);
				location.getItems().remove(i);
				System.out.println("The " + i.getName() + " is in your bag");
				break;
			}
		}
	}

	@Override
	public void eat(String itemsos) {
		// TODO Auto-generated method stub
		
		
		
		for (Items u : items) {
//			fis.setVariable("food", u.getStrennght());// weapon.getDamage()
//			fis.setVariable("health", hp);// ec.getStrength()
//			fis.evaluate();
//			JFuzzyChart.get().chart(fis);	
//			float testing = (float) fis.getVariable("testing").getValue();
			
			if (u.getName().equalsIgnoreCase(itemsos)) {
				if (hp < 100) {
					if(u.getClass() == Consumable.class){
					//if (u.getName() == Consumable.class.getName()) {
						System.out.println("Your current heath is " + hp
								+ " HP");
						int s = u.getStrennght();
						hp += s;
						items.remove(u);
						System.out.println("You have used : " + u.getName()
								+ " : and it gives you : " + u.getStrennght()
								+ " HP" + "\nYour health now is : " + hp
								+ " HP");
						//System.out.println(testing + "----- nice !!! ----- ");
					
					} else {
						System.out.println("Wrong item to use");
					}
				} else {
					System.out.println("Your healt is full and you cannot use it");
				}
				break;
			}
		}
	}

	private Weapon useWeapon(String weapon) {
		// TODO Auto-generated method stub
		for (Items u : items) {
			if (u.getName().equalsIgnoreCase(weapon)) {
				System.out.println("You have used " + u.getName()
						+ " : it give you : " + u.getStrennght());
				return (Weapon) u;
			} else {
				System.out.println(" wrong ");
			}
			break;
		}
		return null;
	}

	/*
	 * private EnemyCharacters choosingEnemy(String ec) { // TODO Auto-generated
	 * method stub for(GameCharacter c : gc) {
	 * if(c.getName().equalsIgnoreCase(ec) & (c.getClass() ==
	 * gmit.computing.people.EnemyCharacters.class)){
	 * System.out.println("you have pick " + c.getName() + " with strenght " +
	 * c.getStrength()); return (EnemyCharacters) c; } break; }
	 * 
	 * //enemy.health = (int) (enemy.helth.victory) /* if (enemy.health < 0 ||
	 * enemy.health = 0){ location.getObesrvers().remove(enemy); enemy }
	 * 
	 * return null; }
	 */

	public Weapon getItemFoundInPack(String weapon) {
		for (Items i : items) {
			if (i.getName().equalsIgnoreCase(weapon)) {
				return (Weapon) i;

			}
		}
		return null;
	}

	public void dropItem(String itemsos) {
		for (Items d : items) {
			if (d.getName().equalsIgnoreCase(itemsos)) {
				items.remove(d);
				location.getItems().add(d);
				System.out.println("You just droped an : " + d.getName()
						+ " in location : " + location.getName());
				break;
			}
		}
	}

	// ------------ Cur location Get/Set--------------
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	// --------------------------------------------------
	// ----------------------- Items -------------------
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	// -----------------------------------------------

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fight(Weapon weapon, EnemyCharacters ec) {
		// TODO Auto-generated method stub
		// Load from 'FCL' file to FIS (fuzzy inference system)
		// emneme.gethealth wepon.getpowe
		fis.setVariable("weapon", weapon.getStrennght());// weapon.getDamage()
		fis.setVariable("enemy", ec.getHealth());// ec.getStrength()
		fis.evaluate();
		JFuzzyChart.get().chart(fis);	


		float victory = (float) fis.getVariable("victory").getValue();
		System.out.println("Enemy Health " + ec.getHealth() +" HP");
		while(ec.getHealth() > 0) {
			ec.setHealth((ec.getHealth() - weapon.getStrennght()));// or Health is public
			if (ec.getHealth() < 0) {

				location.getObservers().remove(ec);
			}
			System.out.println("You hit Enemy with " + weapon.getStrennght() + " : New Enemy health :" + ec.getHealth() + "HP");
			System.out.println();
		}
		System.out.println(victory + "----- VICTORY !!! ----- ");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		direction = direction.toUpperCase();
		Location l = location;
		for (Entry<Location, String> entry : location.getChildren().entrySet()) {
			String dir = entry.getValue();
			Location loc = entry.getKey();
			if (dir.equalsIgnoreCase(direction)) {
				location = GameMap.getLocation(loc);
				System.out.println("Your HERO arived into :\t"
						+ location.getName());
				System.out.println("About this town :\t"
						+ location.getDescription());
				System.out.println("Characters in this location :\t");
				
				
				
				if(loc.getName().equalsIgnoreCase("Cyprus")){
					win();
				}
				// String enemyName = InputClass.getInput();
				// EnemyCharacters ec = location.getEnemy(enemyName);
				// if(ec != null){
				// System.out.println("Ennnnneeeemyyyy");
				// }
				/*
				 * for(GameCharacter gc : location.getObservers()){
				 * System.out.println("\t\t\t"+ gc.getName());
				 * /*if(l.getEnemy("Saracen") != null){
				 * System.out.println("ENEEEMYYYYY"); } }
				 */
				// break;
			}
		}
		if (l.equals(location)) {
			System.out.println("no location ther, just empty fields with sand");
		}
	}
	

	private void go(String direction) {
		// TODO Auto-generated method stub
		direction = direction.toUpperCase();
		Location l = location;
		for (Entry<Location, String> entry : location.getChildren().entrySet()) {			
			String dir = entry.getValue();
			Location loc = entry.getKey();
			
			if (dir.equalsIgnoreCase(direction)) {
				location = GameMap.getLocation(loc);
				System.out.println("Your HERO arived into :\t"
						+ location.getName());
				System.out.println("About this town :\t"
						+ location.getDescription());
				System.out.println("Characters in this location :\t");
			}
		}
		if (l.equals(location)) {
			System.out.println("no location ther, just empty fields with sand");
		}
	}

	private void win() {
		// TODO Auto-generated method stub
		for(Items i : items)
		{
			if(i.getName().equalsIgnoreCase("Holy Grail")){
				System.out.println("_________Well Done_________");
				System.out.println("________YOU COMPLETE_______");
				System.out.println("__________The Game_________");
			}
		}
	}

	@Override
	public void look(Location l) {
		// TODO Auto-generated method stub
		System.out.println("You look at : " + l.getName() + " town : "
				+ "and you see o_O.....");
		System.out.println("----------------------------------------");
		System.out.println("Next locations & directions to them : ");
		for (Location exit : l.getExits()) {
			System.out.println("\t\t\t" + exit.getName() + " -->> "
					+ exit.getDirect());
		}
		System.out.println("----------------------------------------");
		System.out.println("People are in this current location : ");
		for (GameCharacter gc : l.getObservers()) {
			System.out.println("\t\t\t" + gc.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Items are available in the location : ");
		for (Items items : l.getItems()) {
			System.out.println("\t\t\t" + items.getName() + " -->> " + items.getStrennght());
		}
	}

	@Override
	public void tell(String what, FriendlyCharacters fc) {
		// TODO Auto-generated method stub
		//do{what != "no"
		//boolean loop = true;
		//while(loop){
		switch (what) {
			case "power":
				System.out.println("What is you power?");
				System.out.println("------------------");
				System.out.println("At a moment we have about " + fc.getArmy()
						+ " troops that are ready to fight");
				break;
			case "healt":
				System.out.println("What is you healt?");
				System.out.println("------------------");
				if(fc.getHealth() > 90.0){
					System.out.println("For now my current health is " + fc.getHealth()
							+ " and i feel very strong, ready to kill those Enemys");
				}else if(fc.getHealth() > 60.0){
					System.out.println("For now my current health is " + fc.getHealth()
							+ ", but i am not feel so strong, it will be hard to win next battle");
				}else if(fc.getHealth() > 30.0){
					System.out.println("For now my current health is " + fc.getHealth()
							+ ", i need a healer as soon as posible");
				}
				break;
			case "about":
				System.out.println("Tell me about your self?");
				System.out.println("------------------------");
				System.out.println(fc.getDescriptionChar());
				break;
			case "go":
				System.out.println("I want you to move to location");
				System.out.println("Please tell me where i have to go my milord");
				String g = InputClass.getCommand().toUpperCase();
				System.out.println("Please move to " + location.getName());
				go(g);//direction
			}
			//what = InputClass.getInput();
			
			/*if(what == "no") 
            {
				loop = false;
            }*/
		
			/*System.out.println("Would you like to ask me more?");
			what = InputClass.getInput();
		}while (what != "Quit"); */
		
	}

	/*
	 * private void chatting(FriendlyCharacters fc) { // TODO Auto-generated
	 * method stub String temp = ""; switch (temp) { case "hello":
	 * System.out.println("Hello the my frined"); break;
	 * 
	 * default: break; }
	 * 
	 * }
	 */

	public void executeAction(String command) {
		switch (command) {
		case "move":
			String direction = InputClass.getCommand().toUpperCase();
			move(direction);
			break;
		case "look":
			look(location);
			break;
		case "take":
			System.out.println("select item");
			String itemT = InputClass.getInput();
			take(itemT);
			break;
		case "inbag":
			itemInBag();
			break;
		case "tell":
			System.out.println("Choose to who you want to tell");
			String cho = InputClass.getInput();
			FriendlyCharacters fc = location.getFriend(cho); 
			if (fc != null) {
				try{
					System.out.println("what would you like to ask me?");// few out put
					System.out.println("Power, Healt, About");// choose out put
					String what = InputClass.getInput();
					tell(what, fc);
				}catch (Exception e) {
					System.out.println("Write a correct name");
					e.printStackTrace();
				}
			}else{
				System.out.println("No such name of friend in this location");
				System.out.println("Please write a correct name");
			}
			break;
		case "drop":
			System.out.println("select item");
			String itemD = InputClass.getInput();
			dropItem(itemD);
			break;
		case "eat":
			System.out.println("select item to use");
			String itemU = InputClass.getInput();
			System.out.println("item to use : " + itemU);
			eat(itemU);
			break;
		case "fight":
			System.out.println("Choose enemy to attack");
			String enemyName = InputClass.getInput();
			EnemyCharacters ec = location.getEnemy(enemyName);
			if (ec != null) {
				//EnemyCharacters.a = true;
				try{
					System.out.println("Choose weapon : ");
					String weapon = InputClass.getInput();
					Weapon w = (Weapon) useWeapon(weapon);
					fight(w, ec);
				}catch (Exception e) {
					System.out.println("please write correct weapon");
					e.printStackTrace();
				}
			} else {
				System.out.println(" you can't fight your Friend and Neutral army ");
			}
			break;
		case "exit":
			System.exit(0);
			break;
		default:
			break;
		}
	}

	@Override
	public void itemInBag() {
		// TODO Auto-generated method stub
		System.out.println("---------------------");
		for (Items items : items) {
			System.out.println("-> " + items.getName() + " - with strenght - " + items.getStrennght());
		}
		System.out.println("---------------------");
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return Strenght;
		
	}
	@Override
	public void setStrength(int strength) {
		// TODO Auto-generated method stub
		this.Strenght = strength;
	}
	@Override
	public void setHealth(float health) {
		// TODO Auto-generated method stub
		this.hp = health;

	}

	@Override
	public void setCharacterLocation(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fight(Weapon weapon, MyHero mh) {
		// TODO Auto-generated method stub
		
	}
}