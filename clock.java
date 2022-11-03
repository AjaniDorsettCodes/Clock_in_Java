import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;
import javax.sound.sampled.*;

public class clock {

    public static void timer() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("C:\\Users\\Dorsett\\IdeaProjects\\Clock_in_Java\\src\\ALARM.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);

        Scanner scanner = new Scanner(System.in);
        int hours;
        int minutes;
        int seconds;
        int hours2;
        int minutes2;
        int seconds2;
        int checknumber = 0;

        System.out.println("------------------Timer------------------");
        System.out.println("How long do you want the timer to be?");
        System.out.print("Hours: ");
        hours = scanner.nextInt();
        System.out.print("Minutes: ");
        minutes = scanner.nextInt();
        System.out.print("Seconds: ");
        seconds = scanner.nextInt();
        hours2 = hours;
        minutes2 = minutes;
        seconds2 = seconds;

        while (!(seconds2 == 0 && minutes2 == 0 && hours2 == 0)) {
            if (hours2 > 0 && minutes2 == 0 && seconds2 == 0) {
                hours2 = hours2 - 1;
                minutes2 = 60;

            }

            if (seconds2 >= 60) {
                seconds2 = seconds2 - 60;
                minutes2 = minutes2 + 1;
            }

            if (seconds2 == 0 && minutes2 > 0) {
                seconds2 = seconds2 + 60;
                minutes2 = minutes2 - 1;

            }
            if (seconds == 0 && minutes2 == 0 && hours2 > 0) {
                seconds2 = seconds2 + 60;
                minutes2 = minutes2 - 1;
            }

            if (minutes2 >= 60) {
                minutes2 = minutes2 - 60;
                hours2 = hours2 + 1;
            }

            if (minutes2 < 60 && seconds2 < 60) {
                checknumber = 1;

            }
            seconds2--;

            if (checknumber == 1) {
                System.out.println("Hours: " + hours2);
                System.out.println("Minutes: " + minutes2);
                System.out.println("Seconds: " + seconds2);
                System.out.println(" ");
                Thread.sleep(1000);
            }
        }
        System.out.println("------------------Timer is done------------------");
        clip.start();
        Thread.sleep(8000);
    }

    public static void clockMethod() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String choice;
        System.out.println("------------------Clock------------------");
        System.out.println("This will show you the time until you exit, Are you okay with that?");
        System.out.print("Enter yes or no: ");
        choice = scanner.nextLine();

        while (Objects.equals(choice, "yes") || Objects.equals(choice, "Yes")) {

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String formattedtime = time.format(formatter);
            System.out.println(time.format(formatter));
            Thread.sleep(1000);
        }
    }

    public static void alarm() throws ParseException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        int loop = 0;

        File file = new File("C:\\Users\\Dorsett\\IdeaProjects\\Clock_in_Java\\src\\ALARM.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the alarm time (hh:mm ss): ");
        String time = input.nextLine();
        System.out.println();
        DateFormat sdf = new SimpleDateFormat("hh:mm ss");
        String time3 = time.format(String.valueOf(sdf));
        System.out.println();
        LocalDateTime date = LocalDateTime.now();

        while (loop == 0) {
            date = LocalDateTime.now();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm ss");
            String formattedtime = date.format(formatter2);
            System.out.println(formattedtime);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            if (Objects.equals(time, formattedtime)) {
                System.out.println("------------------ALARM------------------");
                clip.start();
                Thread.sleep(8000);
                loop = 1;
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException, ParseException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String formattedtime = time.format(formatter);
        System.out.println("Hello, the time is currently: " + formattedtime);
        System.out.println("Do you want a clock, a timer, or an alarm?");
        String choice = scanner.nextLine();

        while (!(Objects.equals(choice, "clock") || Objects.equals(choice, "timer") || Objects.equals(choice, "alarm"))) {
            System.out.println("You must not understand, enter either \" clock\" \"timer \" or \" alarm \"");
            choice = scanner.nextLine();
        }
        if (choice.equals("timer")) {
            timer();
        }

        if (choice.equals("clock")) {
            clockMethod();
        }
        if (choice.equals("alarm")) {
            alarm();
        }

    }
}
