package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
