import javax.lang.model.element.NestingKind;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String fileName = "file.txt";
    static  int indexList = 1;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    abstract static class Study_Course{
        String name_course;
        String name_kafedra;
    }
    public static void main(String[] args) {

        Lection lection = new Lection();
        lection.AddNewData();
        lection.EditData();
    }
    public static class Lection extends Study_Course
    {
        String group;
        Date date;
        int quantity_students;
        public void AddNewData() {
            int day, month;
            do {
                System.out.print("Enter number of month: ");
                month = scanner.nextByte();
            } while (month > 12 || month < 1);
            Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, 1);
            do {
                System.out.println("Maximum DAY:" + calendar.getActualMaximum(calendar.DAY_OF_MONTH));
                System.out.print("Enter day: ");
                day = scanner.nextByte();

            } while (day > calendar.getActualMaximum(calendar.DAY_OF_MONTH) || day < 1);
            calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, day);
            date = calendar.getTime();
            try {
                FileOutputStream fos = new FileOutputStream(fileName, true);
                DataOutputStream dos = new DataOutputStream(fos);
                System.out.print("Enter name course: ");
                name_course = scanner.nextLine();
                name_course = scanner.nextLine();
                System.out.print("Enter name kafedra: ");
                name_kafedra = scanner.nextLine();
                System.out.print("Enter count students: ");
                quantity_students = scanner.nextInt();
                dos.writeUTF(name_course);
                dos.writeUTF(name_kafedra);
                dos.writeUTF(new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).format(date.getTime()));
                dos.write(quantity_students);
                dos.close();
                //concertInfo.add(this);
                scanner.nextLine();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }

        public void EditData() {
            byte lineIndex;
            do {
                do {
                    System.out.print("Choose line to edit\n(1.Group | 2.Date | 4.Quantity_Students | 5.Name_course | 6.Name_Kafedra |)\nEnter index:");
                    lineIndex = scanner.nextByte();
                } while (lineIndex < 1 || lineIndex > 7);
                switch (lineIndex) {
                    case 1: {
                        System.out.print("Enter Group: ");
                        group = scanner.nextLine();
                        group = scanner.nextLine();
                    }


                    case 2: {
                        byte day;
                        byte month;
                        do {
                            System.out.print("Enter number of month: ");
                            month = scanner.nextByte();
                        } while (month > 12 || month < 1);
                        Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, 1);
                        do {
                            System.out.println("Maximum DAY:" + calendar.getActualMaximum(calendar.DAY_OF_MONTH));
                            System.out.print("Enter day: ");
                            day = scanner.nextByte();

                        } while (day > calendar.getActualMaximum(calendar.DAY_OF_MONTH) || day < 1);
                        calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, day);
                        date = calendar.getTime();
                    }

                    break;
                    case 4: {
                        System.out.print("Enter count students: ");
                        quantity_students = scanner.nextInt();
                    }

                    break;
                    case 5: {
                        System.out.print(" Enter name course: ");

                        name_course = scanner.nextLine();
                        name_course = scanner.nextLine();
                    }
                    break;
                    case 6: {
                        System.out.print(" Enter name kafedra: ");

                        name_kafedra = scanner.nextLine();

                        name_kafedra = scanner.nextLine();
                    }
                }
            } while (lineIndex != 7);
        }

    }


}