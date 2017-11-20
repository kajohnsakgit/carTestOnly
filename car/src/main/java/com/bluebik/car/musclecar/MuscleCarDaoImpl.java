package com.bluebik.car.musclecar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */

public class MuscleCarDaoImpl implements MuscleCarDao {
	
    public MuscleCarDaoImpl() {
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MuscleCar getCarFromList(int id) {
        return new MuscleCar(id, "1", "2", "3", "4");
    }

    @Override
    public void removeCarFromList(int id) {
    	jdbcTemplate.update(" DELETE FROM CAR WHERE ID = ? ", id);

    }

    @Override
    public void addCarToList(MuscleCar muscleCar) {
    	jdbcTemplate.update(" INSERT INTO CAR(ID , CAR_BRAND, CAR_MODEL, HORSEPOWER , CAR_ENGINE) VALUES ( ? , ? , ? , ? , ? ) ", muscleCar.getId(), muscleCar.getCarBrand(), muscleCar.getCarModel() , muscleCar.getHorsepower(), muscleCar.getCarEngine());
    }

    @Override
    public void updateCarFromList(int id , MuscleCar muscleCar) {
    	jdbcTemplate.update(" UPDATE CAR SET CAR_BRAND = ? , CAR_MODEL = ? , HORSEPOWER = ? , CAR_ENGINE = ? ) VALUES ( ? , ? , ? , ? )  WHERE ID = ? ",  muscleCar.getCarBrand(), muscleCar.getCarModel() , muscleCar.getHorsepower(), muscleCar.getCarEngine() , id);
    }

    @Override
    public List<MuscleCar> listAllCars() {
    	List<MuscleCar> result = jdbcTemplate.query(
                "SELECT id, CAR_BRAND, CAR_MODEL, HORSEPOWER , CAR_ENGINE FROM CAR  ",
                (rs, rowNum) -> new MuscleCar(rs.getInt("id"), rs.getString("CAR_BRAND"), rs.getString("CAR_MODEL"), rs.getString("HORSEPOWER") , rs.getString("CAR_ENGINE")));

    	return result;

    }

}
