package be.abstraction.core;

import be.abstraction.core.models.Bank;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CoreUnitTest {
    @Test
    public void bankNameIsCorrect() {
        String bankName = "testBankName";
        Bank bank = new Bank(bankName);

        assertEquals(bankName, bank.getName());
    }
}