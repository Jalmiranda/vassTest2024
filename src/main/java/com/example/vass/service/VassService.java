package com.example.vass.service;

import org.springframework.stereotype.Service;
import com.example.vass.objects.Prices;

@Service
public interface VassService {

	public Prices getPrice (String brand, String date, String productId);

}
