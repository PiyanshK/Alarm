import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class alarm {

    static Scanner scanner = new Scanner(System.in);
    static String SoundPath = "C:\\Users\\panky\\OneDrive\\Desktop\\JavaFolder\\Alarm\\src\\Audio.wav";

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        System.out.println("How long would you like to set your alarm for (Only Write Amount):");
        int Amount = scanner.nextInt();
        System.out.println("What Time Unit Would You Like To Use.");
        System.out.println("1 = Hours, 2 = Days: 3 = Minutes:");
        int TimeUnit = scanner.nextInt();
        String Formatter = "--";
        String Time = Amount + Formatter + TimeUnit ;
        setAlarm(Time);

    }

    static void setAlarm(String Time) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {


        System.out.println("Alarm Set");

        String correctFormat = "Time--Unit";

        int TimeInSeconds = 0;

        try{

            String[] TimeandUnit  = Time.split("--");
            String Amount = TimeandUnit[0];
            int NewAmount = Integer.parseInt(Amount);
            String Unit = TimeandUnit[1];


            if (Unit.equals("1")){

                TimeInSeconds = NewAmount * 3600;

            }

            else if (Unit.equals("2")){

                TimeInSeconds = NewAmount * 24 * 3600;

            }

            else {

                TimeInSeconds  = NewAmount * 60;

            }


        }

        catch(Exception Exception){

            System.out.println("Time In incorrect format");
            System.out.println("Correct Format is: " + correctFormat);

        }

        System.out.println("Waiting...");
        TimeUnit.SECONDS.sleep(TimeInSeconds);
        playSound(SoundPath);
        System.out.println("Done");

    }


    public static void playSound(String FilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        File MusicPath = new File(FilePath);
        if (MusicPath.exists()){

            AudioInputStream InputStream = AudioSystem.getAudioInputStream(MusicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(InputStream);
            clip.start();
            JOptionPane.showMessageDialog(null, "Press OK To Stop");
            clip.close();


        }
        else {

            System.out.println("File Does Not Exist");

        }

    }



}

