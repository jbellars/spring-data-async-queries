package com.infiniteskills.springdata.async.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infiniteskills.springdata.async.data.entity.Book;

/*
 * In Spring Data we use repositories to persist our domain objects
   NOTE: To limit the repository's usage, you can make it extend the ReadOnlyRepository instead of the typical JpaRepository
 */
@Repository
public interface BookRepository extends BaseRepository<Book, Long>
{
    public Book findByTitle(String title);

    // <editor-fold desc="Queries with Paging">

    public List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);

    public List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);

    // </editor-fold>

    // <editor-fold desc="Named [JPQL] Queries">

    // Note: instead of @Query annotations, add @NamedQuery annotations in corresponding class definition (i.e. Book.java)
    public List<Book> queryOne();
    public List<Book> queryTwo(int pageCount);
    public List<Book> queryThree(@Param("title") String title);

    // </editor-fold>

    // <editor-fold desc="JPQL Queries">

    // </editor-fold>

    // <editor-fold desc="Transversing Nested Properties">

    public List<Book> findByAuthorFirstName(String firstName);

    public List<Book> findByAuthor_Country(String country);

    // </editor-fold>

    // <editor-fold desc="Ordering Results">

    public List<Book> findByTitleContainingOrderByTitleAsc(String title);

    public List<Book> findByTitleContainingOrderByTitleDesc(String title);

    public List<Book> findFirstByOrderByPageCountAsc();

    public List<Book> findFirstByOrderByPageCountDesc();

    public List<Book> findTop5ByOrderByPriceDesc();

    public List<Book> findTop5ByTitleContainingOrderByPriceDesc(String title);

    // </editor-fold>

    // <editor-fold desc="Date Comparisons">

    public List<Book> findByPublishDateAfter(Date date);

    public List<Book> findByPublishDateBefore(Date date);

    public List<Book> findByPublishDateBetween(Date date1, Date date2);

    // </editor-fold>

    // <editor-fold desc="Logical Operators">

    public List<Book> findByTitleContainingOrTitleContaining(String title1, String title2);

    public List<Book> findByTitleContainingOrPageCountEquals(String title, int pageCount);

    public List<Book> findByTitleContainingOrPageCountGreaterThan(String title, int pageCount);

    public List<Book> findByTitleNot(String title);

    public List<Book> findByTitleNotContaining(String title);

    // </editor-fold>

    // <editor-fold desc="Relational Operators">

    // method signature using Like keyword
    // Can use wildcards "%" in these query strings
    public List<Book> findByTitleLike(String title);

    // using Containing keyword
    // This provides the wildcards for us
    public List<Book> findByTitleContaining(String title);

    // using StartingWith keyword
    // This is a case-sensitive search
    public List<Book> findByTitleStartingWith(String title);

    // using EndingWith keyword
    // This is a case-sensitive search
    public List<Book> findByTitleEndingWith(String title);

    // using IgnoreCase keyword
    public List<Book> findByTitleIgnoreCase(String title);

    // using CountEquals keyword
    public List<Book> findByPageCountEquals(int pageCount);

    // using CountGreaterThan keyword
    public List<Book> findByPageCountGreaterThan(int pageCount);

    // using CountLessThan keyword
    public List<Book> findByPageCountLessThan(int pageCount);

    // using CountGreaterThanEqual keyword
    public List<Book> findByPageCountGreaterThanEqual(int pageCount);

    // using CountLessThanEqual keyword
    public List<Book> findByPageCountLessThanEqual(int pageCount);

    //using CountBetween keyword
    public List<Book> findByPageCountBetween(int min, int max);

    // </editor-fold>

}

