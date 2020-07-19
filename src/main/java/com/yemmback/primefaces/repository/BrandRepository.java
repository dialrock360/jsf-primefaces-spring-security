package com.codenotfound.primefaces.repository;


import com.primestap.primefaces.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
     @Query("SELECT u FROM Brand u WHERE u.name = ?1")
     Brand findByName(String name);

     @Transactional @Modifying @Query("UPDATE Brand c SET  c.displayName =:name ,  c.model =:model,  c.name =:name  where c.id =:id ")
     int update(@Param("name") String name,@Param("model") String model,@Param("id") long id);


}