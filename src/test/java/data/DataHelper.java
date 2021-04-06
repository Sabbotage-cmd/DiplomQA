package data;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.util.*;

public class DataHelper {
    static LocalDate now = LocalDate.now();
    static LocalDate earlier = now.minusMonths(1);

    static Faker RUFaker = new Faker(new Locale("ru"));
    static String RUFullName = RUFaker.name().firstName() + " " + RUFaker.name().lastName();
    static Faker faker = new Faker(new Locale("en"));
    static String fullName = faker.name().firstName() + " " + faker.name().lastName();
    static String firstName = faker.name().firstName();
    static Random r = new Random();
    static int randomCorrectMonth = r.nextInt(12) + 1;
    static int pastMonth = earlier.getMonth().getValue();
    static int yearOfPastDate = earlier.getYear();
    static int wrongBigMonth = r.nextInt(87) + 13;
    static int wrongFormatMonth = r.nextInt(10);
    static int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
    static int randomCorrectYear = r.nextInt(5) + currentYear + 1;
    static int randomOldYear = r.nextInt(currentYear);
    static int wrongFormatYear = r.nextInt(10);
    static int randomCorrectCVV = r.nextInt(1000);
    static int wrongFormatCVV = r.nextInt(100);
    static final String VALID_CARD_NUMBER = "4444 4444 4444 4441";
    static final String INVALID_CARD_NUMBER = "4444 4444 4444 4442";
    public static final String APPROVED_STATUS = "APPROVED";

    public static FieldsData dataWithValidCard = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithInvalidCard = new FieldsData(INVALID_CARD_NUMBER, randomCorrectMonth(), randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithRandomInvalidCard = new FieldsData(RandomCardNumber(), randomCorrectMonth(), randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithWrongBigMonth = new FieldsData(VALID_CARD_NUMBER, wrongBigMonth(), randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithWrongFormatMonth = new FieldsData(VALID_CARD_NUMBER, wrongFormatMonth(), randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithZeroMonth = new FieldsData(VALID_CARD_NUMBER, "00", randomCorrectYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithPastMonth = new FieldsData(VALID_CARD_NUMBER, pastMonth(), yearOfPastDate(), fullName, randomCorrectCVV());
    public static FieldsData dataWithOldYear = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), randomOldYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithWrongFormatYear = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), wrongFormatYear(), fullName, randomCorrectCVV());
    public static FieldsData dataWithWrongFormatCVV = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), randomCorrectYear(), fullName, wrongFormatCVV());
    public static FieldsData dataWithRussianName = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), randomCorrectYear(), RUFullName, randomCorrectCVV());
    public static FieldsData dataWithFirstNameOnly = new FieldsData(VALID_CARD_NUMBER, randomCorrectMonth(), randomCorrectYear(), firstName, randomCorrectCVV());

    public static String wrongFormatMonth() {
        return Integer.toString(wrongFormatMonth);
    }

    public static String wrongBigMonth() {
        return String.format("%02d", wrongBigMonth);
    }

    public static String pastMonth() {
        return String.format("%02d", pastMonth);
    }

    public static String randomOldYear() {
        return String.format("%02d", randomOldYear);
    }

    public static String yearOfPastDate() {
        return String.format("%02d", yearOfPastDate);
    }

    public static String wrongFormatYear() {
        return Integer.toString(wrongFormatYear);
    }

    public static String wrongFormatCVV() {
        return Integer.toString(wrongFormatCVV);
    }

    public static String randomCorrectMonth() { return String.format("%02d", randomCorrectMonth); }

    public static String randomCorrectYear() {
        return Integer.toString(randomCorrectYear);
    }

    public static String randomCorrectCVV() {
        return String.format("%03d", randomCorrectCVV);
    }

    public static String RandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        int num;
        for (int i = 0; i < 16; i++) {
            num = r.nextInt(10);
            cardNumber.append(Integer.toString(num));
        }
        return cardNumber.toString();
    }

}