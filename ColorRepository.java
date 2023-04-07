package com.maersk.springboot.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maersk.springboot.api.model.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color, String> {

	 @Query("select c from Color c where c.colorName = :colorName")
	  public Optional<Color> findByColorName(@Param("colorName") String colorName);
	 
	 @Query("select c from Color c where c.r = :redAmount and c.g = :greenAmount and c.b = :blueAmount")
	 public Optional<Color> findByColorCodes(@Param("redAmount") Integer redAmount, @Param("greenAmount") Integer greenAmount, @Param("blueAmount") Integer blueAmount );
	 
}
