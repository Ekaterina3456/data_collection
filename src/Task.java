import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Task {
    public static final int amountOfData = 6;

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        String userdata;

        System.out.println("Введите через пробел фамилию, имя, отчество, дату рождения в формате dd.mm.yyyy, номер телефона, пол(f/m)");
        userdata = scanner.nextLine();
        scanner.close();
        String[] user = userdata.split(" ");
        String[] data = user[3].split("\\.");
        if (user.length != amountOfData){
            throw new syzeArrayException();
        } else if (data.length!=3 || data[0].length()!=2 || data[1].length()!=2 || data[2].length()!=4) {
            throw new dataFormatException();
        } else if (user[5].length() != 1 || (!user[5].equals("m") && !user[5].equals("f"))) {
            throw new genderFormatException();
        } else {
            try {
                Integer.parseInt(user[4]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("неверный формат номера телефона");
            }
        }
        WriteFile(user[0], user);
    }

    public static void WriteFile(String string, String[] arr) throws IOException {
        File file = new File(string+".txt");
        try (PrintWriter writer = new PrintWriter(file)){
            for (String e:arr) {
                writer.write(e+" ");
            }
            writer.println();
            System.out.println("файл успешно сохранён");
        } catch (IOException e){
            System.out.println("не удалось сохранить данные");
        }
    }
}
class syzeArrayException extends Exception {
    public syzeArrayException() {
        super("неверное количество данных");
    };
}
class dataFormatException extends Exception{
    public dataFormatException(){
        super("неверный формат даты");
    }
}
class numberFormatException extends Exception{
    public numberFormatException(){
        super("в номере телефона должны быть только цифры");
    }
}
class genderFormatException extends Exception{
    public genderFormatException(){
        super ("пол должен состоять из одного символа: f или m");
    }
}