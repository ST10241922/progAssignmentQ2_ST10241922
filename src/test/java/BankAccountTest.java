/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account("123456", "John Doe", 1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001); // Delta is used for double comparison
    }

    @Test
    void testWithdraw() {
        Account account = new Account("123456", "John Doe", 1000.0);
        account.withdraw(500.0);
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    void testInvalidWithdraw() {
        Account account = new Account("123456", "John Doe", 1000.0);
        account.withdraw(1500.0);
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    void testInvalidDeposit() {
        Account account = new Account("123456", "John Doe", 1000.0);
        account.deposit(-500.0);
        assertEquals(1000.0, account.getBalance(), 0.001);
    }
}

