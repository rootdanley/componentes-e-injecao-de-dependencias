package com.devsuperior.aula;


import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.devsuperior.services"})
public class AulaApplication implements CommandLineRunner {


	private OrderService orderService;

	public AulaApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o código do pedido: ");
		int codigo = sc.nextInt();

		System.out.print("Digite o valor básico do pedido: ");
		double valorBasico = sc.nextDouble();

		System.out.print("Digite a porcentagem de desconto: ");
		double desconto = sc.nextDouble();

		Order order = new Order(codigo, valorBasico, desconto);
		sc.close();

		double valorTotal = orderService.total(order);

		System.out.println("Pedido codigo " + order.getCode());
		System.out.printf("Valor total: R$ %.2f", valorTotal);
	}
}
