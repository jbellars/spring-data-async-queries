package com.infiniteskills.springdata.async.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.infiniteskills.springdata.async.data.entity.Book;

public class BookUtil {

    private static String[] titles = { "Don Quixote", "1984", "Adventures of Huckleberry Finn", "Ulysses",
            "The Great Gatsby", "On The Road", "Catch 22", "To Kill A Mockingbird", "Brave New World",
            "The Scarlet Letter", "The Genesis Record", "Darwin's Black Box", "The Book of Common Prayer",
            "Amazing Grace", "Spring Data", "Effective Java", "Moo, Baa, La-la-la"};

    public static List<Book> create() {
        int numBooks = getRandomNumberInRange(1,100);
        return create(numBooks);
    }

    public static List<Book> create(int size) {
        List<Book> books = new LinkedList<Book>();
        for (int x = 0; x < size; x++) {
            books.add(BookUtil.createBook());
        }
        return books;
    }

    public static Book createBook() {
        Book book = new Book();
        book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length)]);
        book.setPageCount(ThreadLocalRandom.current().nextInt(100, 851));
        book.setPublishDate(new Date());
        book.setPrice(new BigDecimal(getRandomPrice()));
        return book;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Generate a decimal string representation of a random number within the
     * supplied bounds.
     *
     * @param random
     *            the random object (if null, a new one will be created)
     * @param lowerBound
     *            the lower bound, inclusive
     * @param upperBound
     *            the upper bound, inclusive
     * @param decimalPlaces
     *            the decimal places of the result
     * @return the formatted string
     */
    public static String getRandomPrice(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces){

        if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }

    public static String getRandomPrice()
    {
        int dollars = getRandomNumberInRange(1,100);
        int cents = getRandomNumberInRange(0,99);
        String amount = dollars + ((cents < 10) ? ".0" : ".") + cents;
        Float flAmount = Float.parseFloat(amount);
        return formatFloatAsString(flAmount);
    }

    private static String formatFloatAsString(Float flAmount)
    {
        return String.format("%.2f", flAmount);
    }
}
