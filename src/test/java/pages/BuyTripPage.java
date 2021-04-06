package pages;

import com.codeborne.selenide.SelenideElement;
import data.FieldsData;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BuyTripPage {
    private static SelenideElement payWithCardButton = $$("button").find(exactText("Купить"));
    private static SelenideElement payWithCreditButton = $$("button").find(exactText("Купить в кредит"));
    private static SelenideElement continueButton = $$("button").find(exactText("Продолжить"));
    private static SelenideElement cardNumberField = $(byText("Номер карты")).parent().$("input");
    private static SelenideElement monthField = $(byText("Месяц")).parent().$("input");
    private static SelenideElement yearField = $(byText("Год")).parent().$("input");
    private static SelenideElement cardHolderField = $(byText("Владелец")).parent().$("input");
    private static SelenideElement CVVField = $(byText("CVC/CVV")).parent().$("input");

    public void fillTheFields(FieldsData data) {
        cardNumberField.setValue(data.getCardNumber());
        monthField.setValue(data.getMonth());
        yearField.setValue(data.getYear());
        cardHolderField.setValue(data.getCardHolder());
        CVVField.setValue(data.getCVV());
        continueButton.click();
    }

    public void sendEmptyFields() {
        payWithCardButton.click();
        continueButton.click();
    }

    public void buyByCache() {
        payWithCardButton.click();
    }

    public void buyByCreditCard() {
        payWithCreditButton.click();
    }

    public void openSUT() {
        open(System.getProperty("sut.url"));
    }

    public void checkErrorMessage() {
        $(withText("Ошибка")).waitUntil(visible, 10000);
    }

    public void checkWrongValidityErrorMessage() {
        $(withText("Неверно указан срок действия карты")).waitUntil(visible, 5000);
    }

    public void checkWrongFormatErrorMessage() {
        $(withText("Неверный формат")).waitUntil(visible, 5000);
    }

    public void checkExpiredCardErrorMessage() {
        $(withText("Истёк срок действия карты")).waitUntil(visible, 5000);
    }

    public void checkRequiredFieldErrorMessage() {
        $(withText("Поле обязательно для заполнения")).waitUntil(visible, 5000);
    }

    public void checkSuccessMessage() {
        $(withText("Успешно")).waitUntil(visible, 10000);
    }


}