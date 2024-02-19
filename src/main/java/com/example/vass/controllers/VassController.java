package com.example.vass.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vass.objects.Prices;
import com.example.vass.service.VassService;

@RestController
@RequestMapping
public class VassController {

	
		@Autowired
		private VassService vassService;

		@GetMapping(value="/consultprices")
		public Prices getPrice(@RequestParam(name = "marca") String marca, 
				@RequestParam(name = "fecha") String date, 
				@RequestParam(name = "idProducto") String productId) {
			return vassService.getPrice(marca, date, productId);
		}

}
