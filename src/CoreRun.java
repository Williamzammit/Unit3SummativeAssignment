// WJZU3A1 File Scanner and Processer
// 04/12/2024
/*Reads the file and counts up the number of hits for each year
* Then outputs which year was the most dangerous and states whether it was 2020 or not.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoreRun {

    File myFile = new File("animalData.csv");
    

    public CoreRun(){
        runTask6();

    }

    public void runTask1(){
        try {
            Scanner input = new Scanner(myFile);
            input.nextLine();
            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public void runTask6(){
        try{

            Scanner input = new Scanner(myFile);
            input.nextLine();
            int[] yearCounts = new int[14];
            for(int i = 0; i < yearCounts.length; i++){
                yearCounts[i] = 0;
            }

            while(input.hasNextLine()){
                String data = input.nextLine();
                data+=",0";
                String[] splitData = new String[17];
                splitData = data.split(",");

                for(int i = 4; i <= 17; i++){
                    if(splitData[i] == ""){
                        splitData[i] = "0";
                    }
                    yearCounts[i-4] += Integer.parseInt(splitData[i]);
                    
                }
                
            }
            int j = 0;
            for(int i = 0; i < yearCounts.length; i++){
                if(yearCounts[i] > yearCounts[j]){
                    j = i;
                }
            }
            System.out.println("Most dangerous year was:");
            System.out.println(2010 + j);
            if(j == 10){
                System.out.println("2020 was the most dangerous year");
            } else {
                System.out.println("2020 was not the most dangerous year");
            }
            

            input.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


}
