import java.util.*;
public class Taxi {
static int taxicount=0;
int id;
boolean booked;
char currentspot;
int freetime;
int totalearnings;
List <String> trips;
Taxi(){
	booked=false;
	currentspot='A';
	freetime=6;
	totalearnings=0;
	trips=new ArrayList<String>();
	taxicount=taxicount+1;
	id=taxicount;
}
public void setDetails(boolean booked,char currentspot,int freetime,int totalearnings,String tripdetail){
this.booked=booked;
this.currentspot=currentspot;
this.freetime=freetime;
this.totalearnings=totalearnings;
this.trips.add(tripdetail);
}
public void printDetails(){
	System.out.println("Taxi id  "+this.id+"     totalearnings   "+this.totalearnings);
	System.out.println("Taxi id  BookingId  CustomerId  from  to  pickuptime  droptime  amount");
for(String trip:trips){
	System.out.println(id+"                "+trip);
	System.out.println("--------------------------------------------------------------------------------------------");
}
}
public void printTaxiDetails(){
	System.out.println("Taxi_id :"+ this.id+"  "+"totalearnings: "+ this.totalearnings+"  "+"currentspot: "+ this.currentspot+"  "+"freetime: "+ this.freetime);
}
}

