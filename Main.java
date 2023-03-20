
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class main2 {
    static String calcBirthdate(int yearsOld, String birthSeason) {

        int year = 2023 - yearsOld;
        String monthDay;
        String newDate;

        switch (birthSeason) {
            case "spring,":
                monthDay = "03-21";
                break;
            case "summer,":
                monthDay = "06-21";
                break;
            case "fall,":
                monthDay = "09-21";
                break;
            case "winter,":
                monthDay = "12-21";
                break;
            default:
                monthDay = "01-01";
                break;
        }
        newDate =  Integer.toString(year) + "-" + monthDay;

        return newDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        String uniqueID;

        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy0" + Integer.toString(numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li0" +  Integer.toString(numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti0" +  Integer.toString(numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be0" +  Integer.toString(numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        return uniqueID;
    }

    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Dennis's Zoo program!\n\n");
        int numOfHyenas = 0;
        int numOfLions = 0;
        int numOfTigers = 0;
        int numOfBears = 0;

        String hyenas[] = new String[4];
        hyenas[0] = "the first hyena";
        System.out.println("hyenas[0] is: " + hyenas[0]);
        String lions[] = new String[4];
        lions[0] = "the first lion";
        System.out.println("lions[0] is: " + lions[0]);
        String tigers[] = new String[4];;
        String bears[] = new String[4];;
        String arrivingAnimals[] = new String[16];

        try {
            File myAnimalsFile = new File("C:/Users/mj380/Downloads/arrivingAnimals.txt");
            Scanner scanner = new Scanner(myAnimalsFile);
            System.out.println("\n The arrivingAnimals.txt file...\n");

            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                arrivingAnimals[lineNum] = line;
                lineNum++;
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n A file error occured...");
            e.printStackTrace();
        }


        System.out.println("\n The array...\n");
        for (String line:arrivingAnimals) {
            System.out.println(line);
        }

        int position = 0;
        int years = 0;
        String season;
        String sex;
        String species;
        String birthdate;
        String color;
        String origin;
        String weight;
        String name;
        String uniqueID = "xyz";
        String arrived;

        String hyenaNames[] = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
        String lionNames[] = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
        String bearNames[] = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
        String tigerNames[] = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};


        for (int i = 0; i < 16; i++) {

            String splitStr[] = arrivingAnimals[i].split(" ", 0);


            for (String s : splitStr) {
                System.out.println(s);
            }
            birthdate = calcBirthdate(Integer.parseInt(splitStr[0]), splitStr[7]);
            System.out.println("birthDate is: " + birthdate);

            sex = splitStr[3];
            System.out.println("sex is: " + sex);

            species = splitStr[4];
            System.out.println("species is: " + species);

            position = species.indexOf(",");
            System.out.println("position of comma is: " + position);

            species = species.substring(0, position);
            System.out.println("species is now: " + species);


            if (species.equals("hyena")) {
                numOfHyenas++;
                uniqueID = genUniqueID(species, numOfHyenas);
            } else if (species.equals("lion")) {
                numOfLions++;
                uniqueID = genUniqueID(species, numOfLions);
            } else if (species.equals("tiger")) {
                numOfTigers++;
                uniqueID = genUniqueID(species, numOfTigers);
            } else if (species.equals("bear")) {
                numOfBears++;
                uniqueID = genUniqueID(species, numOfBears);
            } else {
                System.out.println("Error tabulating number of species");
            }

            System.out.println("numOfHyenas = " + numOfHyenas);
            System.out.println("numOfLions = " + numOfLions);
            System.out.println("numOfTigers = " + numOfTigers);
            System.out.println("numOfBears = " + numOfBears);
            System.out.println("uniqueID = " + uniqueID);

            String splitStrComma[] = arrivingAnimals[i].split(",", 0);

            for (String s : splitStrComma) {
                System.out.println(s);
            }

            color = splitStrComma[2];
            System.out.println("color = " + color);
            weight = splitStrComma[3];
            origin = splitStrComma[4] + "," + splitStrComma[5];
            System.out.println("weight = " + weight);
            System.out.println("origin = " + origin);

            String uniqueIDPrefix = uniqueID.substring(0, 2);
            System.out.println("uniqueIDPrefix = " + uniqueIDPrefix);
            String uniqueIDSuffix = uniqueID.substring(2);
            System.out.println("uniqueIDSuffix = " + uniqueIDSuffix);
            int suffixAsInt = Integer.parseInt(uniqueIDSuffix);
            System.out.println("suffixAsInt = " + suffixAsInt);


            switch (uniqueIDPrefix) {
                case "Hy":
                    name = hyenaNames[suffixAsInt];
                    break;
                case "Li":
                    name = lionNames[suffixAsInt];
                    break;
                case "Ti":
                    name = tigerNames[suffixAsInt];
                    break;
                case "Be":
                    name = bearNames[suffixAsInt];
                    break;
                default:
                    name = "error in name switch statement";
                    break;
            }

            System.out.println("name is: " + name);
            String arrivalDate;
            LocalDate curDate = LocalDate.now();
            arrivalDate = curDate.toString();
            System.out.println("arrivalDate: " + arrivalDate);
            LocalDate bDate = LocalDate.parse(birthdate);


            int animalAge = Period.between(bDate, curDate).getYears();
            System.out.println(" Age is: " + animalAge);
            String outputLine;
            outputLine = uniqueID + "; " +
                    name + "; " +
                    animalAge + " years old" + "; " +
                    "birth date " + birthdate + ";" +
                    color + "; " +
                    sex + ";" +
                    weight + ";" +
                    origin + ";" +
                    " arrived " + arrivalDate;

            System.out.println("\n\n" + outputLine + "\n\n");


            if (species.equals("hyena")) {
                hyenas[numOfHyenas-1] = outputLine;
            } else if (species.equals("lion")) {
                lions[numOfLions-1] = outputLine;
            } else if (species.equals("tiger")) {
                tigers[numOfTigers-1] = outputLine;
            } else if (species.equals("bear"))  {
                bears[numOfBears-1] = outputLine;
            }
        }


        System.out.println("\nHyena Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(hyenas[i]);
        }
        System.out.println("\nLion Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(lions[i]);
        }
        System.out.println("\nTiger Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(tigers[i]);
        }
        System.out.println("\nBear Habitat:\n");
        for (int i=0; i<4; i++) {
            System.out.println(bears[i]);
        }

        try {
            FileWriter file = new FileWriter("C:/2023spring/midtermProgram/javaOutputFile.txt");
            BufferedWriter output = new BufferedWriter(file);
            output.write("Hyena Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(hyenas[i]+"\n");
            }
            output.write("\nLion Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(lions[i]+"\n");
            }
            output.write("\nTiger Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(tigers[i]+"\n");
            }
            output.write("\nBear Habitat:\n\n");
            for (int i = 0; i < 4; i++) {
                output.write(bears[i]+"\n");
            }
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }
}
