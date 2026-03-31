import java.util.*;

abstract class Music{

    String name;
    String location;
    String date;
    String headliner;
    String musicGenre;
    int ticketPrice;

    public Music(String name,String location,String date,String headliner,String musicGenre,int ticketPrice){
        this.name=name;
        this.location=location;
        this.date=date;
        this.headliner=headliner;
        this.musicGenre=musicGenre;
        this.ticketPrice=ticketPrice;
    }

    abstract void displayDetails();
}

abstract class Food{

    String name;
    String location;
    String date;
    String cuisine;
    int numStalls;
    int entryFee;

    public Food(String name,String location,String date,String cuisine,int numStalls,int entryFee){
        this.name=name;
        this.location=location;
        this.date=date;
        this.cuisine=cuisine;
        this.numStalls=numStalls;
        this.entryFee=entryFee;
    }

    abstract void displayDetails();
}

abstract class Art{

    String name;
    String location;
    String date;
    String artType;
    int numArtists;
    int exhibitionFee;

    public Art(String name,String location,String date,String artType,int numArtists,int exhibitionFee){
        this.name=name;
        this.location=location;
        this.date=date;
        this.artType=artType;
        this.numArtists=numArtists;
        this.exhibitionFee=exhibitionFee;
    }

    abstract void displayDetails();
}

class MusicFestival extends Music{

    public MusicFestival(String name,String location,String date,String headliner,String musicGenre,int ticketPrice){
        super(name,location,date,headliner,musicGenre,ticketPrice);
    }

    void displayDetails(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Headliner: "+headliner);
        System.out.println("Music Genre: "+musicGenre);
        System.out.println("Ticket Price: "+ticketPrice);
    }
}

class FoodFestival extends Food{

    public FoodFestival(String name,String location,String date,String cuisine,int numStalls,int entryFee){
        super(name,location,date,cuisine,numStalls,entryFee);
    }

    void displayDetails(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Cuisine: "+cuisine);
        System.out.println("Number of Stalls: "+numStalls);
        System.out.println("Entry Fee: "+entryFee);
    }
}

class ArtFestival extends Art{

    public ArtFestival(String name,String location,String date,String artType,int numArtists,int exhibitionFee){
        super(name,location,date,artType,numArtists,exhibitionFee);
    }

    void displayDetails(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Art Type: "+artType);
        System.out.println("Number of Artists: "+numArtists);
        System.out.println("Exhibition Fee: "+exhibitionFee);
    }
}

public class FestivalManager{

    static List<Object> festivals=new ArrayList<>();

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        while(true){

            String input=sc.nextLine();
            String parts[]=input.split(" ");

            if(parts[0].equals("EXIT")){
                break;
            }

            if(parts[0].equals("ADD_FESTIVAL")){

                if(parts[1].equals("MUSIC")){

                    MusicFestival m=new MusicFestival(
                            parts[2],parts[3],parts[4],
                            parts[5],parts[6],
                            Integer.parseInt(parts[7])
                    );

                    festivals.add(m);
                }

                else if(parts[1].equals("FOOD")){

                    FoodFestival f=new FoodFestival(
                            parts[2],parts[3],parts[4],
                            parts[5],
                            Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[7])
                    );

                    festivals.add(f);
                }

                else if(parts[1].equals("ART")){

                    ArtFestival a=new ArtFestival(
                            parts[2],parts[3],parts[4],
                            parts[5],
                            Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[7])
                    );

                    festivals.add(a);
                }
            }

            else if(parts[0].equals("DISPLAY_DETAILS")){

                String festivalName=parts[1];

                for(Object obj:festivals){

                    if(obj instanceof MusicFestival){
                        MusicFestival m=(MusicFestival)obj;
                        if(m.name.equals(festivalName)){
                            m.displayDetails();
                            break;
                        }
                    }

                    else if(obj instanceof FoodFestival){
                        FoodFestival f=(FoodFestival)obj;
                        if(f.name.equals(festivalName)){
                            f.displayDetails();
                            break;
                        }
                    }

                    else if(obj instanceof ArtFestival){
                        ArtFestival a=(ArtFestival)obj;
                        if(a.name.equals(festivalName)){
                            a.displayDetails();
                            break;
                        }
                    }
                }
            }
        }
    }
}