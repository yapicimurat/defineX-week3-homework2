package org.example;

import org.example.model.*;
import org.example.repository.*;
import org.example.service.impl.*;

import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //CREATE COMPANIES VIA SERVICE
        CompanyServiceImpl companyService = new CompanyServiceImpl(new CompanyRepository());
        Company migros = companyService.create(Sector.FOOD, "Migros");
        Company kahveDunyasi = companyService.create(Sector.FOOD,"Kahve Dünyası");
        Company koraySpor = companyService.create(Sector.CLOTHING, "Koray Spor");

        //CREATE BRANDS VIA SERVICE
        BrandServiceImpl brandService = new BrandServiceImpl(new BrandRepository());
        Brand nike = brandService.create("Nike", koraySpor);
        Brand adidas = brandService.create("Adidas", koraySpor);
        Brand puma = brandService.create("Puma", koraySpor);
        Brand polaris = brandService.create("Polaris", koraySpor);
        Brand macroCenter = brandService.create("Macro center", migros);
        Brand kahveDunyasiBrand = brandService.create("Kahve Dünyası", kahveDunyasi);

        //CREATE CUSTOMERS VIA SERVICE
        CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepository());

        Customer customer1 = customerService.create("Murat", "YAPICI", "550 000 00 01");
        Customer customer2 = customerService.create("Ali", "Veli", "550 000 00 02");
        Customer customer3 = customerService.create("Ayşe", "Yılmaz", "550 000 00 03");
        Customer customer4 = customerService.create("Cem", "yıldırım", "550 000 00 04");

        //CREATE PRODUCTS VIA SERVICE
        ProductServiceImpl productService = new ProductServiceImpl(new ProductRepository());
        Product kinderCard = productService.create("Kinder cards", 70.0, macroCenter);
        Product kinderPingui = productService.create("Kinder pinqui", 5.0, macroCenter);
        Product swab = productService.create("Temizlik bezi", 30.0, macroCenter);
        Product garbageBag = productService.create("Çöp torbası Büyük Boy 10'lu", 25.0, macroCenter);
        Product nikeShoeProduct = productService.create("Nike shoe model x", 2300.0, nike);
        Product pumaShoeProduct = productService.create("Puma shoe model y", 1800.0, puma);

        //CREATE ORDER VIA SERVICE
        OrderServiceImpl orderService = new OrderServiceImpl(new OrderRepository());
        Order macroCenterOrder = orderService.create("MacroCenter order",
                List.of(kinderCard, kinderPingui, garbageBag, swab), customer1);

        Order koraySporOrder = orderService.create("Koray spor order", List.of(nikeShoeProduct, pumaShoeProduct),
                customer2);

        //CREATE BULL VIA SERVICE
        BillServiceImpl billService = new BillServiceImpl(new BillRepository());
        billService.create("Bill 1", macroCenterOrder);
        billService.create("Koray spor bill", koraySporOrder);

        System.out.println("ALL OF CUSTOMERS");
        customerService.getAll().forEach(System.out::println);

        System.out.println("------------------------------------------------------");

        System.out.println("Customers that are containing 'C' letter in their name.");
        customerService.getAllContainsStr("C")
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");

        //Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin
        System.out.println("The total price of bills for customers who registered in June.");
        System.out.println(customerService.getAllByCreatedAtWithMonth(Month.JUNE.getValue())
                        .stream().mapToDouble(billService::getTotalPriceByCustomer)
                        .sum());

        System.out.println("ALL OF BILLS");
        billService.getAll().forEach(System.out::println);

        System.out.println("Bills of Bigger than 1500 TL");
        billService.getAllByBiggerThanValue(1500)
                .forEach(System.out::println);

        System.out.println("Total average of bill which is bigger than 1500 TL");
        System.out.println(billService.getAverageByBiggerThanValue(1500));

        System.out.println("Total average bills of Bigger than 1500 TL = " + billService.getAverageByBiggerThanValue(1500));

        System.out.println("Customer names of that have bill which is smaller than 500 TL");
        billService.getAllBySmallerThanValue(500)
                .stream().map(bill -> bill.getOrder().getCustomer().getFirstName())
                .forEach(System.out::println);

        System.out.println("Company sectors that have average price smaller than 750 TL in June");
        companyService.getAll().stream()
                .filter(company ->
                        billService.checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(company, 750, Month.JUNE.getValue()))
                .map(company -> company.getSector())
                .distinct()
                .forEach(System.out::println);



    }
}