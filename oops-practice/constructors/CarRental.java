class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500;
    CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
    }
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }
    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Parth", "SUV", 7);
        r1.display();
        r2.display();
    }
}
