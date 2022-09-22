package app;

import java.util.Scanner;
public class product {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public type getType() {
		return Type;
	}

	public void setType(type type) {
		Type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private String name;
	private String description;
	private String rarity;
	private type Type;
	private double price;
	private int quantity;


public product() 
{
	
}

public product(String name, String description, String rarity, type Type, double price, int quantity)
{
	this.name = name;
	this.description = description;
	this.rarity = rarity;
	this.price = price;
	this.quantity = quantity;
}
public product enterproduct() 
{
	System.out.println();
	String _name = new Scanner(System.in).nextLine();
	System.out.println();
	String _des = new Scanner(System.in).nextLine();
	
	System.out.println();
	String _rar = new Scanner(System.in).nextLine();
	System.out.println();
	int _type = new Scanner(System.in).nextInt();
	while(_type > 4 || _type < 1)
	{
		System.out.println();
		_type = new Scanner(System.in).nextInt();
	}
	System.out.println();
	double _price = new Scanner(System.in).nextInt();
	System.out.println();
	int _quantity = new Scanner(System.in).nextInt();
	return new product (_name, _des, _rar, Type.values()[_type - 1], _price, _quantity);
}
}
