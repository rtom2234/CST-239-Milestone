package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	private static final user User = new user();
	private static final List<product> productList = new ArrayList<>();
	
	public static void main(String[] args)
	{
		// log in user
		System.out.println("please enter username");
		User.setUserName(new Scanner(System.in).nextLine());
		System.out.println("enter your gold");
		User.setGold(new Scanner(System.in).nextDouble());
		
		//init product
		productList.add(new product("	Big Knife", "n/a", "common", type.Weapon, 200.0, 99));
		productList.add(new product("	Toy Gun	", "n/a", "common", type.Weapon, 200.0, 99));
		productList.add(new product("	Dinner Plate", "n/a", "common", type.Armor, 200.0, 99));
		productList.add(new product("	Fleece Hat", "n/a", "common", type.Armor, 200.0, 99));
		productList.add(new product("	Lucky Charm", "n/a", "common", type.Special, 200.0, 99));
		productList.add(new product("	Bronze Necklace", "n/a", "common", type.Special, 200.0, 99));
		productList.add(new product("	Health Potion", "n/a", "common", type.Consumable, 200.0, 99));
		productList.add(new product("	Grenade", "n/a", "common", type.Consumable, 200.0, 99));
		productList.add(new product("	Tent", "n/a", "common", type.Consumable, 200.0, 99));
		System.out.println("Add products to store? (y/n)");
		String add = new Scanner(System.in).nextLine();
		while (!add.equals("y") && !add.equals("n"))
		{
			add = new Scanner(System.in).nextLine();
		}
		
		if (add.equals("y"))
		{
			//Add product
			System.out.println("Please enter product in store: ");
			boolean a = true;
					while (a) {
						System.out.println("------New Product!------");
						//add product to list
						System.out.println("Enter in order: Name, Description, Rarity, Type, Price and Quantity");
						product Product = new product().enterproduct();
						productList.add(Product);
						System.out.println("-------------------------");
						System.out.println("Do you want more products? (y/n)");
						String check = new Scanner(System.in).nextLine();
						while (!check.equals("y") && !check.equals("n"))
						{
							check = new Scanner(System.in).nextLine();
						}
						if (check.equals("n"))
						{
							a = false;
						}
					}
		}
		
		boolean b = true;
		while (b)
		{
			//main menu
			clrscr();
			System.out.println("Hello " + User.getUserName() + "welcome!");
			System.out.println("1. Shop");
			System.out.println("2. Check profile");
			System.out.println("3. Exit");
			System.out.println("-----------");
			System.out.println("Please choose menu");
			int chooseMenu = new Scanner(System.in).nextInt();
			switch (chooseMenu)
			{
			case 1:
				shopping();
				break;
			case 2:
				checkMyProfile();
				break;
			default:
				b = false;
				System.out.println("Goodbye!");
				break;
			}
		}
	}
	//clear screen
	public static void clrscr()
	{
		for (int i = 0; i < 20; i ++)
		{
			System.out.println();
		}
	}
	
	public static void shopping()
	{
		boolean c = true;
		while (c)
		{
			clrscr();
			System.out.println("Welcome to shop");
			System.out.println("Gold: " + User.getGold());
			System.out.println("List of products");
			System.out.println("\t No. \t Name \t Description \t Rarity \t Type \t Price \t Quantity \t");
			for (int i = 0; i < productList.size(); i ++)
			{
				System.out.println("\t" + (i + 1) + productList.get(i).getName() + "\t" + productList.get(i).getDescription() + "\t" + productList.get(i).getRarity()
						+ "\t" + productList.get(i).getType() + "\t" + productList.get(i).getPrice() + "\t" + productList.get(i).getQuantity());
			}
			System.out.println("----------");
			System.out.println("Please enter No. to purchase, 0 to exit");
			int choose = new Scanner(System.in).nextInt();
			//check product
			while (choose > productList.size())
			{
				System.out.println("error does not exist");
				System.out.println("re enter product to purchase, 0 to exit");
				choose = new Scanner(System.in).nextInt();
			}
			//exits to main
			if (choose == 0)
			{
				c = false;
			}
			else
			{
				product Product = productList.get(choose - 1);
				if (Product.getQuantity() == 0)
				{
					System.out.println(" out of stock");
					
				}
				else
				{
					//check gold and product price
					if (User.getGold() > Product.getPrice())
					{
						//add product to user inventory
						//minus gold from user
						User.setGold(User.getGold() - Product.getPrice());
						//minus quantity of product
						Product.setQuantity(Product.getQuantity() - 1);
						System.out.println("Success!");
						System.out.println("Continue shopping? (y/n)");
						String check = new Scanner(System.in).nextLine();
						while(!check.equals("y") && !check.equals("n"))
						{
							check = new Scanner(System.in).nextLine();
						}
						if (check.equals("n"))
						{
							c = false;
						}
						else
						{	//not enough
							System.out.println("Not enough gold!");
							System.out.println("Do you want to keep shopping? (y/n)");
							check = new Scanner(System.in).nextLine();
							while(!check.equals("y") && !check.equals("n"))
							{
								check = new Scanner(System.in).nextLine();
							}
							if (check.equals("n"))
							{
								c = false;
							}
						}
					}
				}
			}
		}
	}
	
	public static void checkMyProfile()
	{
		clrscr();
		System.out.println("Hello " + User.getUserName() + ",");
		System.out.println("Gold:" + User.getGold());
		System.out.println();
	if (User.getItems() == 0)
	{
	//no items
	System.out.println("You have no items!");
	}
	else
		System.out.println("You currently have " + User.getItems() + "items!");
	} 
	{
	}
	
	
	
	
	

}
