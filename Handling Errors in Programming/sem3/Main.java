import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");

        String input = scanner.nextLine();
        try {
            processInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processInput(String input) throws IOException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            System.out.println("Неверное количество данных. Требуется ввести Фамилия Имя Отчество дата_рождения номер_телефона пол.");
            return;
        }

        String surname = parts[0];
        String name = parts[1];
        String patronymic = parts[2];
        String birthDate = parts[3];
        String phoneNumber = parts[4];
        String gender = parts[5];

        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDateFormatException("Дата рождения должна быть в формате dd.mm.yyyy");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberFormatException("Номер телефона должен быть числом");
        }

        if (!gender.matches("[fm]")) {
            throw new InvalidGenderFormatException("Пол должен быть указан как 'f' или 'm'");
        }

        writeToFile(surname, String.join(" ", parts));
    }

    private static void writeToFile(String surname, String content) throws IOException {
        String fileName = surname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
