import java.util.*;

class Items implements Comparable<Items> {
    private int id;
    private String itemName;
    private double itemPrice;
    private String itemCreated;
    private String itemUpdated;


    public Items(int id, String itemName, double itemPrice, String itemCreated, String itemUpdated){
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCreated = itemCreated;
        this.itemUpdated = itemUpdated;
    }

    public int getID(){
        return id;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public double getItemPrice(){
        return itemPrice;
    }

    public String getItemCreated(){
        return itemCreated;
    }

    public String getItemUpdated(){
        return itemUpdated;
    }
    public String toString(){
        return id+" "+itemName+" "+itemPrice+" "+" "+itemCreated+" "+itemUpdated;
    }

    public int compareTo(Items s){
        if(s.getID() < this.getID()){
            return -1;
        }
        else if(s.getID() == this.getID()){
            return 0;
        }
        return 1;
    }
}
