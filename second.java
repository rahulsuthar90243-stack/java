public class Car{
    String color;
    int price;

    Car(){
        System.out.println("Drive car");
    }

    public static void main(String[] args){
        Car car = new Car();
        car.color = "red";
        car.price = 20000;

        System.out.println("car color: " + car.color);
        System.out.println("car price: " + car.price);
    }
}