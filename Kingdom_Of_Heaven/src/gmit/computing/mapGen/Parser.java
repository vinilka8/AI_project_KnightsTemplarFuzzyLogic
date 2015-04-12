package gmit.computing.mapGen;

import gmit.computing.people.GameCharacter;
import gmit.computing.things.Consumable;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler{
	private static final String GAME_FILE = "LocInfo.xml";
	
	//You should have a boolean switch for each XML element, but not attribute
	boolean locations = false;
	boolean exit = false;
	boolean description = false;
	boolean descriptionchar = false;
	boolean item = false;
	boolean gameCharacter = false;
	boolean searchAlgorithm = false;
	boolean location = false;
	
	private static List<Location> locs = new ArrayList<Location>(); // location list
	private static List<Items> items = new ArrayList<Items>();
	//private Map<Location, String> exitsfromxml = new HashMap<Location, String>();
	
	GameCharacter observers = null;
	Location loc = null;
	Location ex = null;
	Items it = null;
	
	public List<Location> getLocation() {
		return locs;
	}
	public List<Items> getItems(){
		return items;	
	}

	//Read in the XML file game.xml and use the current object as the SAX event handler
	public void parse() throws ParserConfigurationException, SAXException, IOException{
		XMLReader xmlReader = null;
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		spfactory.setValidating(false);
		SAXParser saxParser = spfactory.newSAXParser();
		xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(this);
		InputSource source = new InputSource(GAME_FILE);
		xmlReader.parse(source);
		xmlReader.setErrorHandler(this);
	}
	
	//Called by SAX when it reaches the starting root element <game-graph>
	public void startDocument() throws SAXException {
		//System.out.println("At start of document...");
		//System.out.println("______________________________________________________");
	}
	
	//Called by SAX when it reaches the closing root element </game-graph>
	public void endDocument(){
		//System.out.println("At end of document...");
		//System.out.println("______________________________________________________");
	}
	

	
	/*
	 * Use the characters() method to extract the PCDATA contained by an XML element, e.g. the text You are in hot dreary desert, with sand dunes and ......
	 * contained by the element <description> in the sample XML files. Read attribute data in startElement(). See the Location example below.
	 */
	public void characters(char[] ch,int start, int length) throws SAXException{
		if (description){
			
			String locationDesc = new String(ch, start, length);
			loc.setDescriprion(new String(ch, start, length));
			//System.out.println(locationDesc);
			description = false;			
		}else if (item){
			
		}else if(descriptionchar){
			
		}else if (gameCharacter){
			
		}else if (searchAlgorithm){
			
		}
	}
	
	
	
	/*
	 * 	This call-back method in executed by SAX when a new starting element is encountered in the XML document. The PCDATA (parseable character data), i.e.
		the data contained between the opening and closing XML element (e.g. <description>) is not read here, but in the characters() method above. Unless you
		are reading attribute values, startElement() is only used to switch on the boolean instance variables for each element.
	*/
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equalsIgnoreCase("location")){
				locations = true;
				//System.out.println("Found Location");
				//System.out.println("-----------------------");
				try {
				//Read in the values for the attributes of the element <location>
					int locationID = Integer.parseInt(atts.getValue("id"));
					String locationName = atts.getValue("name");
					//Generate a new instance of Location on-the-fly using reflection. The statement Class.forName("gmit.Location").newInstance(); invokes the 
					//Java Class Loader and the calls the null (default) constructor of Location.
					loc = (Location) Class.forName("gmit.computing.mapGen.Location").newInstance();
					loc.setId(locationID); //Now configure the Location object with an ID, Name, Description etc...
					loc.setName(locationName);
					//System.out.println(locationName);		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}else if(qName.equalsIgnoreCase("exit")){
			
			exit = true;
			try{
				String nLoc = atts.getValue("to");//Exit to the next location
				String wLoc = atts.getValue("direction"); // Direction to the next location
				
				ex = (Location) Class.forName("gmit.computing.mapGen.Location").newInstance();
				loc.addLocation(ex);
				ex.setDirect(wLoc);
				ex.setName(nLoc);
				ex.getExits().add(loc);
				ex.addLocation(loc);
				//System.out.println("   :   " + nLoc + " -> " + wLoc);
			}catch (Exception e){
				e.printStackTrace();
			}
		}else if (qName.equalsIgnoreCase("description")){
			description = true;			
		}else if (qName.equalsIgnoreCase("item")){
			item = true;
			try{
				String itemName = atts.getValue("name");
				String itemType = atts.getValue("type");
				int itemStrenght = Integer.parseInt(atts.getValue("stenght"));
				it =  (Items) Class.forName(itemType).newInstance();
				it.setType(itemType);
				it.setName(itemName);
				it.setStrennght(itemStrenght);
				//System.out.println("items : " + itemName + " ster " + itemStrenght);
				//require a switch statement, 
				//because we have 2 different types of items in XML file
				switch (itemType) {
				case "gmit.computing.things.Consumable":
					try{
						it = (Consumable) Class.forName("gmit.computing.things.Consumable").newInstance();
						it.setName(itemName);
						it.setStrennght(itemStrenght);
						//loc.getItems().add(c);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "gmit.computing.things.Weapon":
					try {
						it = (Weapon) Class.forName("gmit.computing.things.Weapon").newInstance();
						it.setName(itemName);
						it.setStrennght(itemStrenght);
						//loc.getItems().add(w);			
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "gmit.computing.things.QuestItem":
					try{
						it = (Consumable) Class.forName("gmit.computing.things.QuestItem").newInstance();
						it.setName(itemName);
						//loc.getItems().add(c);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if (qName.equalsIgnoreCase("game-character")){
			gameCharacter = true;
			try {
				String charName = atts.getValue("name");
				String charType = atts.getValue("type");
				String charDesc = atts.getValue("descriptiontype");
				String charDamage = atts.getValue("descriptiontype");
				float health = Float.parseFloat(atts.getValue("health"));
			
				//private map location integer -> exit list 
				observers = (GameCharacter) Class.forName(charType).newInstance();
				observers.setName(charName);
				observers.setHealth(health);
				
				observers.setDescriptionChar(charDesc);
				observers.setCharacterLocation(loc);
			//	System.out.println("character in this location : " + charName);
				//System.out.println("description " + charDesc);
				loc.getObservers().add(observers);
				/*switch (charType) {
				case "gmit.computing.people.MyHero":
					try{
						//obeserver mc = (GameCharacter) Class.forName("gmit.computing.people.MyHero").newInstance();
						obeserver.setName(charName);
						loc.getObservers().add(obeserver);
					}catch (Exception e) {
						// TODO: handle exception
					}
					break;
				case "gmit.computing.people.FriendlyCharacters":
					//FriendlyCharacters fc = (FriendlyCharacters) Class.forName("gmit.computing.people.FriendlyCharacters").newInstance();
					obeserver.setName(charName);
					loc.getObservers().add(obeserver);
					break;
				case "gmit.computing.people.NeutralCharacters":
					try{
						//NeutralCharacters nc = (NeutralCharacters) Class.forName("gmit.computing.people.NeutralCharacters").newInstance();
						obeserver.setName(charName);
						loc.getObservers().add(obeserver);
					}catch (Exception e) {
						// TODO: handle exception
					}
					break;
				case "gmit.computing.people.EnemyCharacters":
					//EnemyCharacters ec = (EnemyCharacters) Class.forName("gmit.computing.people.EnemyCharacters").newInstance();
					obeserver.setName(charName);
					loc.getObservers().add(obeserver);
					break;

				default:
					break;
				}*/
			} catch (Exception e) {
				// TODO: handle exception
			}			
		}else if (qName.equals("search-algorithm")){
			searchAlgorithm = true;
		}
	}
	
	/*
	 * This method is called when the SAX parser encounters a closing element, e.g. </location> and is used to switch off any boolean flags
	 * currently set to true.
	 */
	public void endElement(String namespaceURI,String localName, String qName) throws SAXException{
		if (qName.equals("location")){
			locations = false;
			locs.add(loc);
			//System.out.println("End of location...\n");		
		}else if (qName.equals("exit")){
			exit = false;
		}else if (qName.equals("description")){
			description = false;
		}else if (qName.equals("item")){
			item = false;
			
			if(gameCharacter){
				//System.out.println(observers.getName());
				observers.getItems().add(it);
			}else{
				loc.getItems().add(it);
			}
			
		}else if (qName.equals("game-character")){
			gameCharacter = false;
		}else if (qName.equals("search-algorithm")){
			searchAlgorithm = false;
		}
	}
	
	//Hopefully, you won't have to worry about this...
   	public void error(SAXParseException e) {
   		System.out.println("[ERROR] " + "Yikes....:" + e.getMessage());
   		System.exit(0);
   	}

   	//Or this either...
   	public void warning(SAXParseException e) {
   		System.out.println("[ERROR] " + "Warning....:" + e.getMessage());
   	}

   	//You definitely do not want this method executing... 
   	public void fatalError(SAXParseException e) {
   		System.out.println("[ERROR] " + "Fatal....:" + e.getMessage());
   		System.exit(0);
   	}
   	
   	public void nazovikakhochew()
   	{
	   	try {
			Parser p = new Parser();
			p.parse();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
   	}
}
