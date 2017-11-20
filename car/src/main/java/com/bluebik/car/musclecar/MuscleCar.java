package com.bluebik.car.musclecar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@Entity
public class MuscleCar implements Serializable {

	private static final long serialVersionUID = -763723651536610343L;
	@Id
    @GeneratedValue
	private int id;
	@Column(nullable = false)
    private String carBrand;
	@Column(nullable = false)
    private String carModel;
	@Column(nullable = false)
    private String horsepower;
	@Column(nullable = false)
    private String carEngine;

    public MuscleCar(int id , String carBrand, String carModel, String horsepower, String carEngine) {
        this.id = id;
    	this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsepower = horsepower;
        this.carEngine = carEngine;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }
}
