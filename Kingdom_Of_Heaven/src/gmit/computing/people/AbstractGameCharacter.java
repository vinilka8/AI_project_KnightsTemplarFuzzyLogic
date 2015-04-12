package gmit.computing.people;


/*
 * An abstract class is 
 * a class that can't be instantiated.
 * It's only purpose is for other 
 * classes to extend. 
 * Abstract methods are methods 
 * in the abstract class 
 * (have to be declared abstract) 
 * which means the extending concrete 
 * class must override them as they have 
 * no body.
 */

public abstract class AbstractGameCharacter implements GameCharacter{
	/*
	 * implementation describes the interactions of 
	 * elements in programming languages. In java, 
	 * where the word is frequently used, to implement is 
	 * to recognize and use an element of code or a programming
	 * resource that is written into the program.
	 */
	private String name;
	private float lifeForce = 100.00f;
	//life force here
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getLifeForce(){
		return lifeForce;
	}
	public void setLifeForce(float lifeForce){
		this.lifeForce = lifeForce;
	}
}
