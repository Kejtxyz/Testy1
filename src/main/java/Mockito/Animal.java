package Mockito;

public class Animal {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return 0;
    }
    public boolean isHungry(){
        return false;
    }
    public void goForWalk(String home){

    }
}
