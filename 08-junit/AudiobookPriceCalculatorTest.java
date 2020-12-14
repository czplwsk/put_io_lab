package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.DefaultEditorKit;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    Audiobook audiobook;
    Customer customer;

    @BeforeEach
    void setUp() {
        audiobook = new Audiobook("Anne",100);
    }

    @Test
    void isNotSubscriberTest(){
        customer = new Customer("Jan", Customer.LoyaltyLevel.STANDARD, false);
        AudiobookPriceCalculator audiobookPriceCalculator = new AudiobookPriceCalculator();
        assertEquals(100,audiobookPriceCalculator.calculate(customer,audiobook));
    }

    @Test
    void isSubscriberTest(){
        customer = new Customer("Jan", Customer.LoyaltyLevel.GOLD, true);
        AudiobookPriceCalculator audiobookPriceCalculator = new AudiobookPriceCalculator();
        assertEquals(0,audiobookPriceCalculator.calculate(customer,audiobook));
    }

    @Test
    void silverLoyaltyTest(){
        customer = new Customer("Jan", Customer.LoyaltyLevel.SILVER, false);
        AudiobookPriceCalculator audiobookPriceCalculator = new AudiobookPriceCalculator();
        assertEquals(90,audiobookPriceCalculator.calculate(customer,audiobook));
    }

    @Test
    void goldenLoyaltyTest(){
        customer = new Customer("Jan", Customer.LoyaltyLevel.GOLD, false);
        AudiobookPriceCalculator audiobookPriceCalculator = new AudiobookPriceCalculator();
        assertEquals(80,audiobookPriceCalculator.calculate(customer,audiobook));
    }




}