package com.example.vass.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.vass.objects.Prices;
import com.example.vass.repository.PricesRepository;
import com.example.vass.utils.VassConstants;

@Service
public class VassServiceImpl implements VassService {

	@Autowired
	public PricesRepository pricesRepository;
	
	@Override
	public Prices getPrice (String brand, String date, String productId) {
		
		// NOTA: ante mas entradas, lo ideal seria una tabla de traduccion, pero
		// en este caso ilustro el ejemplo con un switch (podria usar la tabla
		// Brands, pero para meter algo de variedad)
		int brandId = 0;
		switch(StringUtils.capitalize(brand)) {
		case VassConstants.ZARA:
			brandId = VassConstants.ZARA_ID;
			break;
		case VassConstants.HM:
			brandId = VassConstants.HM_ID;
			break;
		default:
			break;
		}

		Prices price = pricesRepository.getPrice(brandId, date, productId);
		
		// NOTA: esto es para que devuelva un json sin campos, al menos, en vez de un null
		price = Objects.isNull(price) ? new Prices() : price;

		return price;
	}

}
