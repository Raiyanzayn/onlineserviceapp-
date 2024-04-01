package demo;
import java.util.*;

// i am using access modifier(private) for name,email, password , so it should be private

class User {
  private int userId;   
  private String name;
  private String email;
  private String password;
// i am using get funtion then only , i can access this private access specifier
  
  public String getEmail() {
  	return email ;
  }
  public String getPassword() {
  	return password ;
  }
  

  public User(int userId, String name, String email, String password) {
      this.userId = userId;
      this.name = name;
      this.email = email;
      this.password = password;
  }
}

// here for every class , i am using encapsulation (OOPS)




class Service {
  int id ;
  String service;
  String name ;
  String descreption;
  String cost ;
	
  public Service(int id ,String service, String name , String  descreption , String cost ) {
	  this.id = id ;
	  this.service=service;
	  this.name= name ;
	  this.descreption=descreption;
	  this.cost=cost ;
	  
  }	
}
class CartItem {
int cartId;
int id ;
String service;
String name ;

public CartItem (int cartId,int id ,String service, String name ) {
  this.cartId = cartId;
  this.id = id ;
  this.service=service;
  this.name= name ;
}
}

class Offer {
	String coupon ;
	
	
	public Offer(String coupon){
		this.coupon=coupon;
	}
}
// here  i am using arraylist(DS) , so that i can easily add the data 

public class onlineservice {
 List<User> users;
 List<Service> service;
List<Offer> offer ;
List<CartItem> cartitem;
public  onlineservice() {
  this.users = new ArrayList<>();
  this.service= new ArrayList<>();
  this.offer= new ArrayList<>(); 
  this.cartitem = new ArrayList<>();
}
public void addservices(Service services) {
	service.add(services);
}
public void addoffer(Offer offers) {
	offer.add(offers);
}
public void addcart(CartItem cartitems) {
	cartitem.add(cartitems);
}


public void run() {
Scanner scanner = new Scanner(System.in);
boolean isRunning = true;

while (isRunning) {
	System.out.println(" ");
  System.out.println("Welcome to the online service App");
  System.out.println("1. Register");
  System.out.println("2. Login");
  System.out.println("3. Service");
  System.out.println("4. Add Available Service");
  System.out.println("5. see cart");
  System.out.println("6.feeback");
  System.out.println("7.suggestion");
  System.out.println("8. Offer");
  System.out.println("9. Exit");
  System.out.print("Enter your choice: ");
  int choice = scanner.nextInt();

  switch (choice) {
      case 1:
          System.out.println("Registration");
          int id = scanner.nextInt();
          System.out.print("Enter your name: ");
          String name = scanner.next();
          System.out.print("Enter your email: ");
          String email = scanner.next();
          System.out.print("Enter your password: ");
          String password = scanner.next();
          User newUser = new User(id,name, email, password);
          users.add(newUser);
          System.out.println("Registration successful!");
          break;
      case 2:
        
          System.out.println("Login");
          System.out.print("Enter your email: ");
          String loginEmail = scanner.next();
          System.out.print("Enter your password: ");
          String loginPassword = scanner.next();

          
          boolean isLoggedIn = false;
          User loggedInUser = null;
          for (User user : users) {
              if (user.getEmail().equals(loginEmail) && user.getPassword().equals(loginPassword)) {
                  isLoggedIn = true;
                  loggedInUser = user;
                  break;
              }
          }

          if (isLoggedIn) {
              System.out.println("Login successful!");
            
          } else {
              System.out.println("Invalid email or password. Please try again.");
          }
          break;
   
      case 3: 
    	  System.out.println(" Avaialable Services:");
        for (Service services : service) {
            System.out.println("service ID:" + services.id);
            System.out.println("Service   : " + services .service);
            System.out.println("Name     :"+ services.name);
            System.out.println("Description: " + services .descreption);
            System.out.println("Cost       : " + services.cost);
            System.out.println("-------------------------");
        }
          break ;
          
      case 4 : 
    	  System.out.println("Add  Avaialable Services:");
    	  System.out.print("CartId ");
          int cartID= scanner.nextInt();
          System.out.print("Service ID ");
          int serviceid= scanner.nextInt();
          System.out.print("Service  ");
          String service= scanner.next();
          System.out.print("Service name ");
          String servicename= scanner.next();
           
          CartItem cartItem = new CartItem( cartID,serviceid, service,servicename);
          addcart( cartItem) ;
      System.out.println("Item added to cart successfully!");
      break;
      case 5 :
    	  System.out.println("Cart Items:");
        for (CartItem cart : cartitem) {
            //if (cart.userId == currentUser.userID) {
                System.out.println("Cart ID: " + cart.cartId);
                System.out.println("Service ID: " + cart.id);
                System.out.println("Service: " + cart.service);
                System.out.println(" Service name: " + cart.name);
                System.out.println("-------------------------");
                System.out.print("Services will arrive soon in 10 minutes also check if there is offer available for this services ");
            }
        
        break;
          
          
    
      case 6:
    	  System.out.println(" Give a feedback for services");
          String feedback= scanner.next();
          break ;
      case 7:
    	  System.out.println(" Give a Suggestion for services");
          String suggestion= scanner.next();
          break ;
      case 8:
    	  System.out.println(" Offers / coupon");
          //String offer= scanner.next();
         for (Offer offers:offer ) {
              System.out.println("Offers:" + offers.coupon);
         }
          
          break ;
          
          
      case 9:
          
          isRunning = false;
          break;
      default:
          System.out.println("Invalid choice. Please try again.");
          break;
  }
}
}
    public static void main(String args[]) {
    	onlineservice app = new onlineservice();
    	Service electrical = new Service(1,"electrical","raj","i am 5years of exprience" ,"100perhour");
    	Service plumbing = new Service(2,"plumbing","rahul","i am 2years of exprience" ,"150perhour");
    	Service carpenter = new Service(3,"carpenter","raju","i am 3years of exprience" ,"300perhour");
    	Service beauty = new Service(4,"Beauty service","kamal","i am 1years of exprience" ,"400perhour");
    	Service cleaning = new Service(1,"Cleaning","rohan","i am 2years of exprience" ,"450perhour");
    	app.addservices(electrical);
    	app.addservices(plumbing);
    	app.addservices(carpenter);
    	app.addservices(beauty);
    	app.addservices(cleaning);
    	
    	Offer electricals = new Offer("50% for electrical service use coupon RAIYAN");
    	Offer  plumbings = new Offer("20% for plumbing service use coupon DAIYAN");
    	Offer carpenters = new Offer("10% for carpent service use coupon RJIYAN");
    	Offer beautys = new Offer("60% for  beauty service use coupon RAIYHN");
    	Offer cleanings = new Offer("70% for cleaning service use coupon RAUYAN");
    	app.addoffer(electricals);
    	app.addoffer(plumbings);
    	app.addoffer(carpenters);
    	app.addoffer(beautys);
    	app.addoffer(cleanings);
    	
           app.run();
           
           
           
    }
    
}




