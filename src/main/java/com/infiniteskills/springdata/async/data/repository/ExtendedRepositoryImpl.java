package com.infiniteskills.springdata.async.data.repository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class ExtendedRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>
{
    private JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager entityManager;

    public ExtendedRepositoryImpl(
            JpaEntityInformation<T, ?> entityInformation,
            EntityManager entityManager)
    {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    /**
     * Method implementation to be made asynchronous.
     * Method changed to void per suggestion by <a href="https://stackoverflow.com/a/45206063/2543739">Jens Schauder on Stack Overflow response</a>, since the compiler baulks at casting query results to Future&lt;List&lt;String&gt;&gt;' ... and it seems unnecessary to return anything in this instance.
     * @param ids One or more Book Ids
     */
    @SuppressWarnings("unchecked")
    public List<T> findByIds(ID... ids)
    {
        Query query = this.entityManager.createQuery("select e from " + this.entityInformation.getEntityName()
                                                             + " e where e." + this.entityInformation.getIdAttribute().getName() + " in :ids");
        query.setParameter("ids", Arrays.asList(ids));

        // <editor-fold desc="Async Query">

        long wait = new Random().nextInt(10000-1) +1; //1L;
        System.out.println("Waiting " + wait +"ms");

        try {
            Thread.sleep(wait);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Executing query for ID: " + Arrays.toString(ids));

        return query.getResultList();

        // </editor-fold>

    }
}
