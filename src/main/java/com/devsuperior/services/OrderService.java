package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;

	public double total(Order order){

		Double ValorComDesconto = order.getBasic() * (1 - order.getDiscount() / 100);
		order.setBasic(ValorComDesconto);
		return order.getBasic() + shippingService.shipment(order);
	}

}
