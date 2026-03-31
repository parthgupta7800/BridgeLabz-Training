import org.json.JSONObject;

class Car{
    String brand;
    String model;
    int year;

    Car(String brand,String model,int year){
        this.brand=brand;
        this.model=model;
        this.year=year;
    }
}

public class CarToJSON{
    public static void main(String[]args){
        Car car=new Car("Tesla","Model S",2024);

        JSONObject json=new JSONObject();
        json.put("brand",car.brand);
        json.put("model",car.model);
        json.put("year",car.year);

        System.out.println(json.toString(4));
    }
}
