import java.util.ArrayList;
class Vehicle{
	private String driverName;
	private double maxAcceleration;
	private double topSpeed;
	private double currentSpeed;
	private double currentTime;
	private double currentPosition;
		public Vehicle(String Dname,double Macc,double Tspeed){
		driverName=Dname;
		maxAcceleration=Macc;
		topSpeed=Tspeed;
		currentSpeed=0.00;
		currentTime=0.00;
		currentPosition=0.00;
		}
		
		public String getdriverName(){
			return driverName;
		}
		
		public double getTime(){
			return currentTime;
		}
		public double update(){
		this.currentSpeed=this.currentSpeed+Math.random()*this.maxAcceleration;
		if(this.currentSpeed>this.topSpeed){
			this.currentSpeed=this.topSpeed;
		}
		
		this.currentTime=currentTime+1;
		this.currentPosition+=this.currentSpeed;
		return this.currentPosition;
		}
}

class Race{
	private ArrayList<Vehicle>VehicleList=new ArrayList<>();
	private double raceDistance;
		public Race(ArrayList<Vehicle>vList,double rDistance){
			VehicleList=vList;
			raceDistance=rDistance;
		}

	public void runRace(){
		boolean winner=false;
		
		while(!winner){
			for(Vehicle newvehicle:this.VehicleList){
			
			double distance=newvehicle.update();
			if(distance>this.raceDistance){
				
				System.out.println("The winner is  " + newvehicle.getdriverName() + 
						" with time  "+ newvehicle.getTime()   + " seconds");

				winner=true;
				break;
				}
			}
		}
	}	
}

public class Racing{
	public static void main(String[] args){
		Vehicle car1=new Vehicle("nayan",15,60);
		Vehicle car2=new Vehicle("akash",20,55);
		ArrayList<Vehicle>carRacers=new ArrayList<Vehicle>();
		carRacers.add(car1);
		carRacers.add(car2);
		
		Race Race1=new Race(carRacers,500);
		Race1.runRace();
	}
}