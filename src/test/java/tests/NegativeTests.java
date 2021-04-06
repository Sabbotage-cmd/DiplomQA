package tests;

import data.DataHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BuyTripPage;

public class NegativeTests {
    BuyTripPage page = new BuyTripPage();

    @Test
    @DisplayName("Getting error message after sending data with card's random number")
    void shouldDeclinePaymentWithInvalidRandomCard() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithRandomInvalidCard);
        page.checkErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data for credit with default invalid card's number")
    void shouldDeclineCreditWithInvalidRandomCard() {
        page.openSUT();
        page.buyByCreditCard();
        page.fillTheFields(DataHelper.dataWithRandomInvalidCard);
        page.checkErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with month's big value")
    void shouldNotAcceptBigMonth() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithWrongBigMonth);
        page.checkWrongValidityErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with month's zero value")
    void shouldNotAcceptZeroMonth() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithZeroMonth);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with month's wrong format")
    void shouldNotAcceptWrongFormatMonth() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithWrongFormatMonth);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with previous month's value")
    void shouldNotAcceptPastMonth() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithPastMonth);
        page.checkWrongValidityErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with old year's value")
    void shouldNotAcceptOldYear() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithOldYear);
        page.checkExpiredCardErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with year's wrong format")
    void shouldNotAcceptWrongFormatYear() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithWrongFormatYear);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with CVV's wrong format")
    void shouldNotAcceptWrongFormatCVV() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithWrongFormatCVV);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with name consisting of russian letters")
    void shouldNotAcceptRussianName() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithRussianName);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after sending data with name consisting of only one word")
    void shouldNotAcceptOnlyFirstName() {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithFirstNameOnly);
        page.checkWrongFormatErrorMessage();
    }

    @Test
    @DisplayName("Getting error message after trying to send empty fields")
    void shouldNotSendEmptyFields() {
        page.openSUT();
        page.sendEmptyFields();
        page.checkRequiredFieldErrorMessage();
    }

}