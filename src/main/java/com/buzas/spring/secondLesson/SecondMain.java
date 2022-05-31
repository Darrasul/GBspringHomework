package com.buzas.spring.secondLesson;

import com.buzas.spring.secondLesson.items.CartService;
import com.buzas.spring.secondLesson.items.Product;
import com.buzas.spring.secondLesson.items.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecondConfig.class);

        CartService cartService = context.getBean(CartService.class);
        ProductRepository repoService = context.getBean(ProductRepository.class);

        Scanner scanner = new Scanner(System.in);

        List<Product> products = repoService.showContent();

        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("List - показывает список доступных продуктов\n" +
                                "Add_id - позволяет добавить продукт в корзину по id\n" +
                                "Add_name - позволяет добавить продукт в корзину по имени\n" +
                                "Find_id - позволяет найти продукт в списке продуктов по id\n" +
                                "Find_name - позволяет найти продукт в списке продуктов по имени\n" +
                                "Remove_id - позволяет убрать продукт из корзины по id\n" +
                                "Remove_name - позволяет убрать продукт из корзины по имени\n" +
                                "Cart - показывает список корзины\n" +
                                "Refresh - очищает корзину\n" +
                                "Exit - закрывает программу");
            System.out.println("Напишите команду: ");
            String command = scanner.nextLine().toLowerCase().trim();
            if (command.equals("list")){
                System.out.println("Список продуктов:");
                for (Product product : products) {
                    System.out.println(product);
                }
            } else if (command.equals("add_id")){
                System.out.println("Напишите id продукта");
                int request = scanner.nextInt();
                try {
                    Product requestedItem = repoService.findProduct(request);
                    cartService.addProduct(requestedItem);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    System.err.println("Товара с таким id нет");
                }
            } else if (command.equals("add_name")) {
                System.out.println("Напишите имя продукта");
                String request = scanner.nextLine();
                if (request.isEmpty()){
                    System.out.println("Вы не ввели имя продукта");
                }
                try {
                    Product requestedItem = repoService.findProduct(request);
                    cartService.addProduct(requestedItem);
                } catch (NullPointerException e){
                    e.printStackTrace();
                    System.err.println("Товара с таким именем нет");
                }
            } else if (command.equals("find_id")) {
                System.out.println("Напишите id продукта");
                int request = scanner.nextInt();
                try {
                    Product requestedItem = repoService.findProduct(request);
                    System.out.println(requestedItem);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    System.err.println("Товара с таким id нет");
                }
            } else if (command.equals("find_name")) {
                System.out.println("Напишите имя продукта");
                String request = scanner.nextLine();
                if (request.isEmpty()){
                    System.out.println("Вы не ввели имя продукта");
                }
                try {
                    Product requestedItem = repoService.findProduct(request);
                    System.out.println(requestedItem);
                } catch (NullPointerException e){
                    e.printStackTrace();
                    System.err.println("Товара с таким именем нет");
                }
            } else if (command.equals("remove_id")) {
                System.out.println("Напишите id продукта");
                int request = scanner.nextInt();
                try {
                    Product requestedItem = cartService.findProduct(request);
                    cartService.removeProduct(requestedItem);
                } catch (NullPointerException e){
                    e.printStackTrace();
                    System.err.println("В вашей корзине не было такого файла");
                } catch (ConcurrentModificationException e){
                    e.printStackTrace();
                    System.err.println("Пытается изменить читаемый поток");
                }
            } else if (command.equals("remove_name")) {
                System.out.println("Напишите имя продукта");
                String request = scanner.nextLine();
                try {
                    Product requestedItem = cartService.findProduct(request);
                    cartService.removeProduct(requestedItem);
                } catch (NullPointerException e){
                    e.printStackTrace();
                    System.err.println("В вашей корзине не было такого файла");
                } catch (ConcurrentModificationException e){
                    e.printStackTrace();
                    System.err.println("Пытается изменить читаемый поток");
                }
            } else if (command.equals("refresh")) {
                cartService.removeAll();
            } else if (command.equals("cart")) {
                System.out.println(cartService.getRepo().toString());
            } else if (command.isEmpty()){
                System.out.println("Вы не ввели команду");
            } else if (command.equals("exit")){
                break;
            }
        }

        scanner.close();
        context.close();
    }
}
