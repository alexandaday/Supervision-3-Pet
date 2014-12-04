import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Cat extends Pet implements Contestable{
	private int Obedience;
	
	public Cat(String nameIn){
		super(nameIn);
		this.Obedience = 1;
	}
	
	public int getObedience(){
		return Obedience;
	}
	
	public void setObdience(int obIn){
		this.Obedience = obIn;
	}
	
	public void train(){
		if (this.Obedience < 5){
			try{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(InterruptedException e){
				//Will only occur is error with compiler, unlikely
				System.out.println("Your pet had trouble training");
			}
			System.out.println(this.getName()+" learnt to be more obedient");
			this.Obedience = this.Obedience + 1;
			this.Boredom = this.Boredom - 3;
		}
		else{
			System.out.println("Your cat is already an fully obedient");
		}
	}
	
	public int entercontest(){
		System.out.println(this.getName()+" is trying to show obedience");
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch(InterruptedException e){
			//Will only occur is error with compiler, unlikely
			System.out.println("Your pet got bored of waiting");
		}
		Random rnum = new Random();
		this.Boredom = this.Boredom -2;
		if (this.Obedience > rnum.nextInt(6)){
			System.out.println("Congratulations you won the contest and earnt £1");
			return 1;
		}
		else{
			System.out.println("Better luck next time");
			return 0;
		}
	}
}
