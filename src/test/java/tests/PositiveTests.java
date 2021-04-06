package tests;

import data.DBUtils;
import data.DataHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BuyTripPage;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveTests {
    DBUtils dbUtils = new DBUtils();
    BuyTripPage page = new BuyTripPage();

    @Test
    @DisplayName("Getting success message and approved status in DB after payment with valid card")
    void shouldApprovePaymentWithValidCard() throws SQLException {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithValidCard);
        page.checkSuccessMessage();
        assertEquals(dbUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }

    @Test
    @DisplayName("Getting error message and declined status in DB after payment with invalid card")
    void shouldDeclinePaymentWithInvalidCard() throws SQLException {
        page.openSUT();
        page.buyByCache();
        page.fillTheFields(DataHelper.dataWithInvalidCard);
        page.checkErrorMessage();
        assertNotEquals(dbUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }

    @Test
    @DisplayName("Getting success message and approved status with right payment info in DB after taking credit with valid card")
    void shouldApproveCreditWithValidCard() throws SQLException {
        page.openSUT();
        page.buyByCreditCard();
        page.fillTheFields(DataHelper.dataWithValidCard);
        page.checkSuccessMessage();
        assertEquals(dbUtils.getCreditStatus(), DataHelper.APPROVED_STATUS);
        assertNotEquals(dbUtils.getOrderInformation(), null);
    }

    @Test
    @DisplayName("Getting error message and declined status in DB after taking credit with invalid card")
    void shouldDeclineCreditWithInvalidCard() throws SQLException {
        page.openSUT();
        page.buyByCreditCard();
        page.fillTheFields(DataHelper.dataWithInvalidCard);
        page.checkErrorMessage();
        assertNotEquals(dbUtils.getPaymentStatus(), DataHelper.APPROVED_STATUS);
    }
}