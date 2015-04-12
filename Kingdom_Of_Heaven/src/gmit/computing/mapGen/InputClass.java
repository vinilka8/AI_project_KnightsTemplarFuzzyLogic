package gmit.computing.mapGen;

import gmit.computing.people.MyHero;

import java.util.Scanner;


public class InputClass {
	static String input;        
	static Direction direction;
	static Actions actions;
	
	public void EnumTest(Actions actions) {
        this.actions = actions;
    }
	
	
	public static String start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("choose action : " + actions.MOVE + " " + actions.LOOK + " " + actions.TAKE + " " + actions.INBAG +
				" " + actions.FIGHT + " " +actions.EAT + " " + actions.TELL + " " + actions.EXIT);
		return getCommand();
	}

	public static String getCommand() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}

	@SuppressWarnings("resource")
	public static String getInput() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		//System.out.println("command : " + input);
		//scanner close();
		return input;
	}
}