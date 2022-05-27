import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.IOException;


public class App {
    public static void main(String[] args)throws Exception{
        List<Items> ite = new ArrayList<Items>();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        clearScreen();
        int ch;
        do{
            System.out.println("0: Exit ");
            System.out.println("1: Add Item/s ");
            System.out.println("2: Display All Items");
            System.out.println("3: Search item");
            System.out.println("4: Delete Item");
            System.out.println("5: Update Item");
            System.out.println("6: Display Descending");
            System.out.println("7: Display Ascending");
            System.out.print("Choice :: ");
            ch = sc.nextInt();
            if(ch > 7){
                System.out.println("Invalid choice!");
                System.exit(0);
            }
            switch(ch){
            case 1:
                clearScreen();
                int itemID = ThreadLocalRandom.current().nextInt(100000, 999999);
                DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
                Date date = new Date();
                String dateString = dateformat.format(date);
                System.out.print("Enter Item Name: ");
                String item = sc1.nextLine();
                System.out.print("Enter Price: ");
                double iprice = sc.nextDouble();
                ite.add(new Items(itemID, item, iprice, dateString, dateString));
                clearScreen();
                

            break;

            case 2:
                clearScreen();
                System.out.println("--------------------------------------------------");
                Iterator<Items> it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    System.out.println(i);
                    System.out.println("--------------------------------------------------");
                }
            break;

            case 3:
                clearScreen();
                System.out.println("--------------------------------------------------");
                it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    System.out.println(i);
                    System.out.println("--------------------------------------------------");
                }
                boolean found = false;
                System.out.print("Enter Item Number to find :: ");
                int iNumb = sc.nextInt();
                System.out.println("--------------------------------------------------");
                it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    if(i.getID() == iNumb){
                        System.out.println(i);
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Item number not found!");
                }
                System.out.println("--------------------------------------------------");
            break;
            case 4:
                clearScreen();
                System.out.println("--------------------------------------------------");
                it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    System.out.println(i);
                    System.out.println("--------------------------------------------------");
                }
                found = false;
                System.out.print("Enter Item Number to DELETE :: ");
                iNumb = sc.nextInt();
                System.out.println("--------------------------------------------------");
                it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    if(i.getID() == iNumb){
                        it.remove();
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Item number not found!");
                }
                else{
                    System.out.println("Item Successfully DELETED");
                }
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                clearScreen();
                System.out.println("--------------------------------------------------");
                it = ite.iterator();
                while(it.hasNext()){
                    Items i = it.next();
                    System.out.println(i);
                    System.out.println("--------------------------------------------------");
                }
                found = false;
                System.out.print("Enter Item Number to UPDATE :: ");
                iNumb = sc.nextInt();
                System.out.println("--------------------------------------------------");
                ListIterator<Items> li = ite.listIterator();
                while(li.hasNext()){
                    Items i = li.next();
                    if(i.getID() == iNumb){
                        dateformat = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
                        date = new Date();
                        String newdateString = dateformat.format(date);
                        System.out.print("Enter Item Name: ");
                        item = sc1.nextLine();
                        System.out.print("Enter Price: ");
                        iprice = sc.nextDouble();
                        li.set(new Items(iNumb, item, iprice, i.getItemCreated(), newdateString));
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Item number not found!");
                }
                else{
                    clearScreen();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Item Successfully UPDATED");
                }
                System.out.println("--------------------------------------------------");
            break;
            case 6:
                clearScreen();
                Collections.sort(ite);
                for(int count = 0; count < ite.size();count++){
                    System.out.println("--------------------------------------------------");
                    System.out.println(ite.get(count).getID()+" "+ite.get(count).getItemName()+" "+ite.get(count).getItemPrice()+" "+ite.get(count).getItemCreated()+" "+ite.get(count).getItemUpdated());
                }
                System.out.println("--------------------------------------------------");
            break;
            case 7:
                clearScreen();
                Collections.sort(ite, new Comparator<Items>(){
                    public int compare(Items i1, Items i2){
                        return Integer.valueOf(i1.getID()).compareTo(i2.getID());
                    }
                });
                for(int count = 0; count < ite.size();count++){
                    System.out.println("--------------------------------------------------");
                    System.out.println(ite.get(count).getID()+" "+ite.get(count).getItemName()+" "+ite.get(count).getItemPrice()+" "+ite.get(count).getItemCreated()+" "+ite.get(count).getItemUpdated());
                }
                System.out.println("--------------------------------------------------");
            break;
            default:
                System.out.println("INVALID!");
            break;
            }
            
        }while(ch!=0);
    }

    public static void clearScreen() throws IOException, InterruptedException {  
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
    }  
    
}
