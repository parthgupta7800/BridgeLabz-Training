import java.util.*;
interface MealPlan {
    String mealName="";
}
class VegetarianMeal implements MealPlan {
    String mealName="Vegetarian Meal";
}
class VeganMeal implements MealPlan {
    String mealName="Vegan Meal";
}
class KetoMeal implements MealPlan {
    String mealName="Keto Meal";
}
class Meal {
    public static <T extends MealPlan> void generateMeal(T meal){
        System.out.println("Generated Plan: "+meal.mealName);
    }
}
public class MealPlanner {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Choose meal type(Vegetarian/Vegan/Keto): ");
        String choice=sc.nextLine();
        if(choice.equalsIgnoreCase("Vegetarian")){
            Meal.generateMeal(new VegetarianMeal());
        }else if(choice.equalsIgnoreCase("Vegan")){
            Meal.generateMeal(new VeganMeal());
        }else if(choice.equalsIgnoreCase("Keto")){
            Meal.generateMeal(new KetoMeal());
        }
    }
}
