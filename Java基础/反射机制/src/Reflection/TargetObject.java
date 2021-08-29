package Reflection;

public class TargetObject {
    public String value;
    public TargetObject(){
        value="Hello World!";
    }
    public void publicMethod(String s){
        System.out.println("["+s+"]");
    }
    private void PrivateMethod(){
        System.out.println("value is"+value);
    }
}
