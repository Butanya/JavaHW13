package ru.netology.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product first = new Book(111, "Чапаев и Пустота", 700, "Пелевин");
    Product second = new Smartphone(222, "Mi Mix2", 22000, "Xiaomi");
    Product third = new Book(333, "Fight Club", 600, "Palahnuik");
    Product fourth = new Smartphone(444, "Iphone 10", 56660, "Apple");


    @Test
    void shouldThrowException() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(22);
        });

    }

    @Test
    void shouldRemoveById1() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        repository.removeById(222);

        Product[] actual = repository.findAll();
        Product[] expected = {first, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById2() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        repository.removeById(222);
        repository.removeById(333);

        Product[] actual = repository.findAll();
        Product[] expected = {first, fourth};

        assertArrayEquals(expected, actual);
    }
}

