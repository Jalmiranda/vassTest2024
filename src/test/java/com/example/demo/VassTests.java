package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.vass.VassApplication;
import com.example.vass.objects.Prices;
import com.example.vass.repository.PricesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes=VassApplication.class)
class VassTests {

    @Autowired
    PricesRepository pricesRepository;
	
	@Test
    public void test1(){
		
		// Peticion a las 10:00 del dia 14 del producto 35455 para la brand 1 (ZARA)
		String date = "2020-06-14-10.00.00";
		int brand = 1;
		String product = "35455";
		
		Prices price = pricesRepository.getPrice(brand, date, product);
		// Debiera devolver la entrada 1 (priceList) de la tabla (prioridad 0 y precio 35.50)
		Assertions.assertEquals(price.getPriceList(), 1);
		Assertions.assertEquals(price.getPriority(), 0);
		Assertions.assertEquals(price.getPrice(), 35.50);
    }
	
	@Test
    public void test2(){
		// Peticion a las 16:00 del dia 14 del producto 35455 para la brand 1 (ZARA)
		String date = "2020-06-14-16.00.00";
		int brand = 1;
		String product = "35455";
		
		Prices price = pricesRepository.getPrice(brand, date, product);
		// Debiera devolver la entrada 2 (priceList) de la tabla (prioridad 1 y precio 25.45)
		Assertions.assertEquals(price.getPriceList(), 2);
		Assertions.assertEquals(price.getPriority(), 1);
		Assertions.assertEquals(price.getPrice(), 25.45);
    }
	
	@Test
    public void test3(){
		// Peticion a las 21:00 del dia 14 del producto 35455 para la brand 1 (ZARA)
		String date = "2020-06-14-21.00.00";
		int brand = 1;
		String product = "35455";
		
		Prices price = pricesRepository.getPrice(brand, date, product);
		// Debiera devolver la entrada 1 (priceList) de la tabla (prioridad 0 y precio 35.50)
		Assertions.assertEquals(price.getPriceList(), 1);
		Assertions.assertEquals(price.getPriority(), 0);
		Assertions.assertEquals(price.getPrice(), 35.50);
    }

	
	@Test
    public void test4(){
		// Peticion a las 10:00 del dia 15 del producto 35455 para la brand 1 (ZARA)
		String date = "2020-06-15-10.00.00";
		int brand = 1;
		String product = "35455";
		
		Prices price = pricesRepository.getPrice(brand, date, product);
		// Debiera devolver la entrada 3 (priceList) de la tabla (prioridad 1 y precio 30.50)
		Assertions.assertEquals(price.getPriceList(), 3);
		Assertions.assertEquals(price.getPriority(), 1);
		Assertions.assertEquals(price.getPrice(), 30.50);
    }

	@Test
    public void test5(){
		// Peticion a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
		String date = "2020-06-16-21.00.00";
		int brand = 1;
		String product = "35455";
		
		Prices price = pricesRepository.getPrice(brand, date, product);
		// Debiera devolver la entrada 4 (priceList) de la tabla (prioridad 1 y precio 38.95)
		Assertions.assertEquals(price.getPriceList(), 4);
		Assertions.assertEquals(price.getPriority(), 1);
		Assertions.assertEquals(price.getPrice(), 38.95);
    }


}
