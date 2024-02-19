package com.example.vass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vass.objects.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

	@Query(value = "SELECT p from Prices p"
    		+ " where p.brandId = ?1 and p.startDate <= ?2 and p.endDate >= ?2"
    		+ " and p.productId = ?3 order by p.priority DESC")	
	// Prioridad descendente para que devuelva solo el de mayor prioridad
    Prices getPrice(int brandId, String date, String productId);	


}