package library;

import java.io.*;
import java.sql.*;

public class lib_mgmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost/shantanu_118";
		String username="root";
		String userpassword="tiger";

		Connection con=DriverManager.getConnection(url,username,userpassword);

		if(con.isClosed())
		{
			System.out.println("connection is closed");
		}else
		{
			System.out.println("connection created");
		}

		while(true){

			System.out.println("==========================================");
			System.out.println("Enter 1 to add books.");
			System.out.println("Enter 2 to delete books.");
			System.out.println("Enter 3 to issue books.");
			System.out.println("Enter 4 to return books.");
			System.out.println("Enter 5 for books list.");
			System.out.println("Enter 6 for search book.");
			System.out.println("Enter 7 to exit.");


			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int input = Integer.parseInt(br.readLine());

			if(input==1){
				operations.addBook();
			}

			else if(input==2){
				operations.deleteBook();
			}

			else if(input==3){
				operations.issueBook();
			}

			else if(input==4){
				operations.returnBook();
			}

			else if(input==5){
				operations.booksList();
			}

			else if(input==6){
				operations.searchBook();
			}

			else if(input==7){
				System.out.println("Thanks for your visit! See you soon!");
				break;
			}

			else{
				System.out.println("Invalid Entry, Please try again.");
			}
		}
	}
}


