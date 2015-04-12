package gmit.computing.people;

import gmit.computing.mapGen.GameMap;
import gmit.computing.mapGen.InputClass;
import gmit.computing.mapGen.Location;
import gmit.computing.things.Consumable;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.sourceforge.jFuzzyLogic.FIS;

//MOVE need to fix
//USE need to fix

public class MyHero implements GameCharacter {
	private String name;
	private static double hp = 50;
	private Location location;
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

	public double getHp() {
		return hp;

	}

	public void setHp(double hp) {
		this.hp = hp;

	}

	@Override
	public void take(String itemsos) {
		// TODO Auto-generated method stub
		for (Items i : location.getItems()) {
			// System.out.println(" from for " + itemsos);
			if (i.getName().equalsIgnoreCase(itemsos))// otherwise use item
			{
				System.out.println("You choose to take a " + i.getName());
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
			if (u.getName().equalsIgnoreCase(itemsos)) {
				if (hp < 100) {
					//if(itemsos == Consumable.class.getName()){
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
					
//					} else {
//						System.out.println("Wrong item to use");
//					}
				} else {
					System.out
							.println("Your healt is full and you cannot use it");
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
		float victory = (float) fis.getVariable("victory").getValue();
		System.out.println(victory + "----- VICTORY !!! ----- ");
		
		System.out.println("Enemy Health " + ec.getHealth() +"HP");
		ec.setHealth((ec.getHealth() - victory));// or Health is public
		if (ec.getHealth() < 0) {

			location.getObservers().remove(ec);
		}
		System.out.println("You hit Enemy with " + weapon.getStrennght());
		System.out.println("New Enemy health " + ec.getHealth());
	
		
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

				// neeeeed to fix it

				System.out.println("Characters in this location :\t");
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
			System.out.println("\t\t\t" + items.getName());
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
			//NeutralCharacters nc = location.getNeutral(cho);
//			if(cho == fc.getName().toString()){
				System.out.println("what would you like to ask me?");// few out put
				System.out.println("Power, Healt, About");// choose out put
				//System.out.println(fc.getName());
				//System.out.println(nc.getName());
				String what = InputClass.getInput();
				tell(what, fc);
	//		}
			
			//String friendName = InputClass.getInput();
			
			//String neutralName = InputClass.getInput();
			
			

			// String neutralName = InputClass.getInput();
			// NeutralCharacters nc = location.getNeutral(neutralName);
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
				System.out.println("Choose weapon : ");
				String weapon = InputClass.getInput();
				Weapon w = (Weapon) useWeapon(weapon);
				fight(w, ec);
			} else {
				System.out.println(" you can't fight your Friend and Neutral army ");
			}

			/*
			 * System.out.println("what weapon you want to choose : "); String
			 * weapon = InputClass.getInput(); //useWeapon(weapon);
			 * System.out.println("weapon : "+ weapon + " power of :" +
			 * getStrength());
			 * System.out.println("who you would like to attack : "); String ec
			 * = InputClass.getInput(); //choosingEnemy(ec);
			 * fight(useWeapon(weapon), choosingEnemy(ec));
			 */
		default:
			break;
		}
	}

	@Override
	public void itemInBag() {
		// TODO Auto-generated method stub
		for (Items items : items) {
			System.out.println(items.getName());
		}
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
	public double getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealth(float health) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterLocation(Location location) {
		// TODO Auto-generated method stub

	}
}