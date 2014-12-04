import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Ninja extends Pet implements Showable{
	
	private int Ferocity;
	
	public Ninja(String nameIn){
		super(nameIn);
		this.Ferocity = 1;
	}
	
	public void anger(){
		if (this.Ferocity < 2){
			try{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(InterruptedException e){
				//Will only occur is error with compiler, unlikely
				System.out.println("Your ninja had trouble being more calm");
			}
			System.out.println(this.getName()+" focused and became more calm");
			this.Ferocity = this.Ferocity + 1;
			this.Tiredness = this.Tiredness - 3;
		}
		else{
			System.out.println("Your pet is already an expert");
		}
	}
	
	public int doShow(){
		System.out.println(this.getName()+" is on display for tips");
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch(InterruptedException e){
			//Will only occur is error with compiler, unlikely
			System.out.println("Your pet got bored of waiting");
		}
		Random rnum = new Random();
		this.Hunger = this.Hunger -2;
		int tips = (rnum.nextInt(2)*rnum.nextInt(3)*Ferocity);
		System.out.println("You made £"+tips+" in tips");
		return tips;
	}
}
