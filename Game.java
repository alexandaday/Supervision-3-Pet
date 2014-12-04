import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	private int cash;
	
	private static boolean exit;
	
	public Game(){
		this.cash = 2;
	}
	
	public static void main(String[] args){
		System.out.println("---Cyber Pet 2014---\n");
		
		while (Game.exit == false){

			Game thisgame = new Game();
			
			System.out.println("What type of pet would you like?");
			System.out.println("1 - Dog");
			System.out.println("2 - Cat");
			System.out.println("3 - Fish");
			System.out.println("4 - Ninja");
			Scanner userIn = new Scanner(System.in);
			String choice = userIn.nextLine();
			System.out.println("\nWhat would you like to call it?");
			String nameIn = userIn.nextLine();
			
			System.out.println("\nHere's how to look after your pet");
			System.out.println("1 - Check up on it");
			System.out.println("2 - Feed it");
			System.out.println("3 - Play with it");
			System.out.println("4 - Put to bed");
			System.out.println("5 - Give it a wash");
			
			Pet mypet = null;
			
			if (choice.equals("1")){
				mypet = new Dog(nameIn);
				System.out.println("6 - Teach to do tricks");
				System.out.println("7 - Enter a contest");
			}
			else if (choice.equals("2")){
				mypet = new Cat(nameIn);
				System.out.println("6 - Teach to be more obedient");
				System.out.println("7 - Enter a beauty contest");
			}
			else if (choice.equals("3")){
				mypet = new Fish(nameIn);
				System.out.println("6 - Admire Fish");
				System.out.println("7 - Put on display for cash");
			}
			else if (choice.equals("4")){
				mypet = new Ninja(nameIn);
				System.out.println("6 - Teach to stay calm");
				System.out.println("7 - Put on a display show for cash");
			}
			
			System.out.println("8 - Show options");
			System.out.println("9 - Leave pet forever");
			
			while (true){
				if (thisgame.getScore(mypet) <= 0){
					System.out.println("\nYour pet has been taken away from you for its own good");
					System.out.println("Fortunately this is not a real animal so you can just try again\n\n");
					break;
				}
				String response = userIn.nextLine();
				
				if ((thisgame.getScore(mypet)) <= 20) {
					System.out.println(mypet.getName()+" needs attention\n");
				}
				else if ((thisgame.getScore(mypet)) <= 10) {
					System.out.println("Careful your pet may been taken away by authorities\n");
				}
				
				System.out.println("");
				
				if (response.equals("1")){
					
					if ((thisgame.getScore(mypet)) > 30) {
						System.out.println(mypet.getName()+" is happy\n");
					}
					else if ((thisgame.getScore(mypet)) > 20) {
						System.out.println(mypet.getName()+" seems to want some attention\n");
					}
					else if ((thisgame.getScore(mypet)) > 10) {
						System.out.println(mypet.getName()+" needs attention\n");
					}
					else{
						System.out.println("Careful your pet may been taken away by authorities\n");
					}
					
					if (mypet.getInfo(1) <= 5) {
						System.out.println(mypet.getName()+" is hungry");
					}
					else if (mypet.getInfo(1) <= 7) {
						System.out.println(mypet.getName()+" is feeling a little peckish");
					}
					
					if (mypet.getInfo(2) <= 5) {
						System.out.println(mypet.getName()+" is bored");
					}
					else if (mypet.getInfo(2) <= 7) {
						System.out.println(mypet.getName()+" wants something to do");
					} 
					
					if (mypet.getInfo(3) <= 5) {
						System.out.println(mypet.getName()+" wants a rest");
					}
					else if (mypet.getInfo(3) <= 7) {
						System.out.println(mypet.getName()+" is a tad drowsy");
					}
					
					if (mypet.getInfo(4) <= 5) {
						System.out.println(mypet.getName()+" needs a clean");
					}
					
					System.out.println("Your pet has a hunger of " + mypet.getInfo(1));
					System.out.println("Your pet has a boredom of " + mypet.getInfo(2));
					System.out.println("Your pet has a tiredness of " + mypet.getInfo(3));
					System.out.println("Your pet has a cleanliness of " + mypet.getInfo(4));
					
				}
				if (response.equals("2")){
					int curCash = thisgame.getCash();
					if (curCash > 0){
						System.out.println(mypet.getName()+" had a nice meal\n");
						System.out.println("Cost you £1");
						thisgame.setCash(curCash-1);
						System.out.println("You have £"+thisgame.getCash()+" left\n");
						mypet.setInfo(10,1);
					}
					else{
						System.out.println("You need to earn more money");
						System.out.println("You have £"+thisgame.getCash()+"\n");
					}
				}
				if (response.equals("3")){
					try{
						TimeUnit.SECONDS.sleep(1);
					}
					catch(InterruptedException e){
						//Will only occur is error with compiler, unlikely
						System.out.println("Your pet had trouble keeping up");
					}
					System.out.println(mypet.getName()+" enjoyed playing with you\n");
					mypet.setInfo(10,2);
				}
				if (response.equals("4")){
					try{
						TimeUnit.SECONDS.sleep(3);
					}
					catch(InterruptedException e){
						//Will only occur is error with compiler, unlikely
						System.out.println("Your pet had trouble sleeping");
					}
					System.out.println(mypet.getName()+" feels refreshed");
					mypet.setInfo(10,3);
				}
				if (response.equals("5")){
					if (mypet instanceof Fish){
						System.out.println(mypet.getName()+" is already in water!");
					}
					else{
						System.out.println(mypet.getName()+" is clean again");
						mypet.setInfo(10,4);
					}
				}
				if (response.equals("6")){
					if (mypet instanceof Dog){
						((Dog) mypet).teach();
					}
					if (mypet instanceof Cat){
						((Cat) mypet).train();
					}
					if (mypet instanceof Ninja){
						((Ninja) mypet).anger();
					}
					if (mypet instanceof Fish){
						((Fish) mypet).admire();
					}
				}
				if (response.equals("7")){
					if (mypet instanceof Dog){
						thisgame.setCash(thisgame.getCash() + ((Dog) mypet).entercontest());
					}
					if (mypet instanceof Cat){
						thisgame.setCash(thisgame.getCash() + ((Cat) mypet).entercontest());
					}
					if (mypet instanceof Ninja){
						thisgame.setCash(thisgame.getCash() + ((Ninja) mypet).doShow());
					}
					if (mypet instanceof Fish){
						thisgame.setCash(thisgame.getCash() + ((Fish) mypet).doShow());
					}
				}
				if (response.equals("8")){
					System.out.println("1 - Check up on it");
					System.out.println("2 - Feed it");
					System.out.println("3 - Play with it");
					System.out.println("4 - Put to bed");
					System.out.println("5 - Give it a wash");
					if (mypet instanceof Dog){
						System.out.println("6 - Teach to do tricks");
						System.out.println("7 - Enter a contest");
					}
					if (mypet instanceof Cat){
						System.out.println("6 - Teach to be more obedient");
						System.out.println("7 - Enter a beauty contest");
					}
					if (mypet instanceof Fish){
						System.out.println("6 - Admire Fish");
						System.out.println("7 - Put on display for cash");
					}
					if (mypet instanceof Ninja){
						System.out.println("6 - Teach to stay calm");
						System.out.println("7 - Put on a display show for cash");
					}
					System.out.println("8 - Show options");
					System.out.println("9 - Leave pet forever");
				}
				if (response.equals("9")){
					Game.exit = true;
					break;
				}
				
				mypet.updatePet();
			}
			
		}
		System.exit(0);
		
	}
	
	public int getScore(Pet p){
		return p.getInfo(1) + p.getInfo(2) + p.getInfo(3) + p.getInfo(4);
	}
	
	public int getCash(){
		return this.cash;
	}
	
	public void setCash(int cashIn){
		this.cash = cashIn;
	}
}

interface Contestable{
	public int entercontest();
}

interface Showable{
	public int doShow();
}
