package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );

    public static void main(String[] args) {
        HashMap<String, List> customerHashmap = new HashMap<String, List>();
        List<Customer> listofCustomers = new ArrayList<Customer>();

        for (int i = 0; i < customerData.size(); i++) {
            String[] eachCustomer = customerData.get(i);
            if (customerHashmap.containsKey(eachCustomer[0])) {

                List<String> customerFeatures = new ArrayList<>();
                customerFeatures.add(eachCustomer[1]);
                customerFeatures.add(eachCustomer[2]);
                customerFeatures.add(eachCustomer[3]);

                customerHashmap.get(eachCustomer[0]).add(customerFeatures);
            } else {
                customerHashmap.put(eachCustomer[0], new ArrayList<>());
                List<String> customerDetails = new ArrayList<>();
                customerDetails.add(eachCustomer[1]);
                customerDetails.add(eachCustomer[2]);
                customerDetails.add(eachCustomer[3]);

                customerHashmap.get(eachCustomer[0]).add(customerDetails);

            }
        }

        for (Map.Entry<String, List> entry : customerHashmap.entrySet()) {

            Customer latestCustomer = new Customer();
            latestCustomer.setName(entry.getKey());
            latestCustomer.setId(Integer.parseInt(entry.getKey()));

            ArrayList<String> newArrayList = (ArrayList<String>) entry.getValue().get(0);

            String name = newArrayList.get(0);

            latestCustomer.setName(name);
            ArrayList<ArrayList<String>> customerSpecifics = (ArrayList<ArrayList<String>>) entry.getValue();

            for (int i = 0; i < customerSpecifics.size(); i++) {

                List<String> item = customerSpecifics.get(i);
                AccountRecord newAcctRecord = new AccountRecord();
                newAcctRecord.setCharge(Integer.parseInt(item.get(1)));
                newAcctRecord.setChargeDate(item.get(2));
                latestCustomer.getCharges().add(newAcctRecord);
            }
            listofCustomers.add(latestCustomer);
        }
        //Update this
        System.out.println("Positive accounts:");
        for (int i = 0; i < listofCustomers.size(); i++) {
            Customer customer = listofCustomers.get(i);
            if (customer.getBalance() > 0) {
                System.out.println(customer.toString());
            }
        }
        System.out.println("Negative accounts:");
        for (int i = 0; i < listofCustomers.size(); i++) {
            Customer customer = listofCustomers.get(i);
            if (customer.getBalance() < 0) {
                System.out.println(customer.toString());
            }
        }
    }
}
