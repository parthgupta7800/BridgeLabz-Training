import java.util.*;
public class AmarAkbarAnthony {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int amar_age=ob.nextInt();
        int amar_height=ob.nextInt();
        int akbar_age=ob.nextInt();
        int akbar_height=ob.nextInt();
        int anthony_age=ob.nextInt();
        int anthony_height=ob.nextInt();
        if(amar_age<akbar_age&&amar_age<anthony_age)
            System.out.println("Amar is Youngest");
        if(amar_age>akbar_age&&akbar_age<anthony_age)
            System.out.println("Akbar is Youngest");
        else
            System.out.println("Anthony is Youngest");
        if(amar_height<akbar_height&&amar_height<anthony_height)
            System.out.println("Amar is Tallest");
        if(amar_height>akbar_height&&akbar_height<anthony_height)
            System.out.println("Akbar is Tallest");
        else
            System.out.println("Anthony is Tallest");
    }
}
