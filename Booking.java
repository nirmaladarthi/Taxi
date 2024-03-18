import java.util.*;
public class Booking {

	public static void booktaxi(int customerId,char pickuppoint,char droppoint,int pickuptime,List <Taxi>freetaxis)
	{
		int min=999;
		int distancebetweenpickupanddrop=0;
		int nextfreetime=0;
		int earnings=0;
		char nextspot='Z';
		Taxi bookedtaxi=null;
		String tripdetail="";
	for(Taxi t:freetaxis){
		int distancebetweencutomerandtaxi=Math.abs((t.currentspot-'0')-(pickuppoint-'0'))*15;
		if(distancebetweencutomerandtaxi<min){
			bookedtaxi=t;
			distancebetweenpickupanddrop=Math.abs((droppoint-'0')-(pickuppoint-'0'))*15;
			earnings=((distancebetweenpickupanddrop-5)*10)+100;
			int droptime=pickuptime+(distancebetweenpickupanddrop/15);
			nextspot=droppoint;
			nextfreetime=droptime;
			tripdetail=tripdetail+customerId+"  "+customerId+"  "+pickuppoint+"  "+droppoint+"  "+pickuptime+"  "+droptime+"  "+earnings;
		min=distancebetweencutomerandtaxi;
		}
	}
	bookedtaxi.setDetails(true, nextspot, nextfreetime, bookedtaxi.totalearnings+earnings, tripdetail);
	 System.out.println("Taxi " + bookedtaxi.id + " booked");
	 System.out.println("enter 1 for booking details");
	}
	public static List<Taxi> createtaxi(int n){
		List<Taxi> taxis=new ArrayList<Taxi>();
		for(int i=0;i<n;i++){
		Taxi t=new Taxi();
		taxis.add(t);
	}
	return taxis;
	}
		public static List<Taxi> getfreetaxis(List<Taxi> taxis,int pickuptime,char pickuppoint)
		{
			List <Taxi> freetaxis=new ArrayList<Taxi>();
			for(Taxi t:taxis){
				if(t.freetime<=pickuptime && (Math.abs((t.currentspot-'0')-(pickuppoint-'0'))<= pickuptime-t.freetime))
					freetaxis.add(t);
			}
				return freetaxis;
		}
	public static void main(String[] args) {
		List <Taxi> taxis=createtaxi(4);
		Scanner s= new Scanner(System.in);
		int id=1;
		//while(true){
		System.out.println("0-For booking");
		System.out.println("1-For taxi deatils");
		int choice=s.nextInt();
		switch(choice){
		case 0:
		{
			int customerId=id;
			System.out.println("enter pickuppoint(A-F):");
			char pickuppoint=s.next().charAt(0);
			System.out.println("enter droppoint(A-F):");
			char droppoint=s.next().charAt(0);
			System.out.println("enter pickuptime(from 6):");
			int pickuptime=s.nextInt();
	if(pickuppoint<'A'||droppoint>'F'||pickuppoint>'F'||droppoint<'A')
		System.out.println("Enter valid points as A,B,C,D,E,F");
	List <Taxi> freetaxis=getfreetaxis(taxis,pickuptime,pickuppoint);
	if(freetaxis.size()==0){
			System.out.println("can't be alloted");
			return;
		}
		//Collections.sort(freetaxis,(a,b)->a.totalearnings - b.totalearnings);
		booktaxi(id,pickuppoint,droppoint,pickuptime,freetaxis);
		id++;
		break;
	}
	case 1:
	{
		for(Taxi t:taxis)
			t.printDetails();
		for(Taxi t:taxis)
			t.printTaxiDetails();
		break;
	}
default:
	return;
}
 int aa=s.nextInt();
 switch(aa){
 case 1:
 {
		for(Taxi t:taxis)
			t.printDetails();
		for(Taxi t:taxis)
			t.printTaxiDetails();
		break;
	}
 }
}
}
//}