package com.codenotfound.primefaces.repository;


import com.primestap.primefaces.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
//public interface CarRepository extends JpaRepository<Car, Long> {
public interface CarRepository extends JpaRepository<Car, Long> {

   /* @Modifying
    @Query("UPDATE Car c SET c.year = :year, c.price = :price , c.soldState = :soldState , c.color = :color , c.brand.id = :brand_id  WHERE c.id = :id")
    int update(@Param("id") long id, @Param("year") int year, @Param("price") long price, @Param("soldState") boolean soldState, @Param("color") String color, @Param("brand_id") long brand_id);
*/
    /*
    @Modifying
    @Query("UPDATE Car c SET  c.brand.id = ?1  where c.id= ?2")
    void updatebradId(long brand,long id);*/

   /* @Transactional
    @Modifying
    @Query(value = "UPDATE Car c SET  c.brand.id = ?1  where c.id= ?2",
            nativeQuery = true)
    void updatebradId(long brand_id,long id);*/
    //@Query("UPDATE u FROM ConfirmationToken u WHERE u.token = ?1")
   /* @Query("update Car c set c.color =:color, c.year =:year, c.price =:price, c.color =:color , c.soldState =:soldState , c.brand.id =:color where feedEntry.id =:id")
    int update(long id, int year, long price, boolean soldState, String color, Car brand);*/
  //  int update(String token);
     // `cars` SET `id`=[value-1],`created_at`=[value-2],`updated_at`=[value-3],
    // `color`=[value-4],``=[value-5],`sold_state`=[value-6],`year`=[value-7],`brand_id`=[value-8] WHERE 1
    //List<Car> findByCar(Car car, Sort sort);

    @Transactional @Modifying @Query("UPDATE Car c SET  c.color =:color ,  c.price =:price,  c.soldState =:soldState, c.year =:year , c.brand.id =:brandid  where c.id =:id ")
    int update(@Param("id") long id, @Param("year") int year, @Param("price") long price, @Param("soldState") boolean soldState, @Param("color") String color, @Param("brandid") long brandid);

}