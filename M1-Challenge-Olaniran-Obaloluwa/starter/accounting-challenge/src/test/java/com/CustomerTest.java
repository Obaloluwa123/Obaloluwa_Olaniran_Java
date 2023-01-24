package com;

import com.company.AccountRecord;
import com.company.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void shouldCalculateBalance() {
        Customer customer = new Customer();
        List<Customer> customerAccounts = new ArrayList<>();
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord1 = new AccountRecord();

        customer.setId(1);
        customer.setName("Wayne Enterprises");
        customerAccounts.add(customer);
        accountRecord.setCharge(10000);
        accountRecord.setChargeDate("12-01-2021");

        accountRecord1.setCharge(-7500);
        accountRecord1.setChargeDate("01-10-2022");

        customer.getCharges().add(accountRecord);
        customer.getCharges().add(accountRecord1);
        assertEquals(2500, customer.getBalance());

        Customer customer1 = new Customer();
        List<Customer> customerAccounts1 = new ArrayList<>();
        AccountRecord accountRecord2 = new AccountRecord();
        AccountRecord accountRecord3 = new AccountRecord();

        customer1.setId(3);
        customer1.setName("Ace Chemical");
        customerAccounts1.add(customer1);
        accountRecord2.setCharge(-48000);
        accountRecord2.setChargeDate("01-10-2022");

        accountRecord3.setCharge(-95000);
        accountRecord3.setChargeDate("12-15-2021");

        customer1.getCharges().add(accountRecord2);
        customer1.getCharges().add(accountRecord3);
        assertEquals(-143000, customer1.getBalance());

    }
}