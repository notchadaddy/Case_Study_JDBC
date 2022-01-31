package library;

import java.io.*;
import java.sql.*;

public class operations {

	public static void addBook() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Add book");

		Connection con = jdbc.getConnection();
		String query = "insert into library_118(bookNAME, author, publisher, borrowed) values (?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(query);

		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter book name:");
			String bookName = br.readLine();

			System.out.println("Enter book author");
			String author = br.readLine();

			System.out.println("Enter book publisher");
			String pub = br.readLine();

			System.out.println("Is the book borrowed?");
			String borrowed = br.readLine();

			pstmt.setString(1, bookName);
			pstmt.setString(2, author);
			pstmt.setString(3, pub);
			pstmt.setString(4, borrowed);

			pstmt.executeUpdate();

			System.out.println("Success.");
		}
	}

	public static void deleteBook() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Delete book");

		Connection con = jdbc.getConnection();
		String query = "delete from library_118 where bookNAME=? && author=?";
		PreparedStatement pstmt = con.prepareStatement(query);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter book name:");
		String name = br.readLine();

		System.out.println("Enter book author:");
		String author = br.readLine();

		pstmt.setString(1, name);
		pstmt.setString(2, author);
		pstmt.executeUpdate();

		System.out.println("Book deleted successfully.");
	}

	public static void issueBook() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Issue book");

		Connection con = jdbc.getConnection();
		String que = "update library_118 set borrowed=? where bookNAME=? && author=?";

		PreparedStatement pst = con.prepareStatement(que);

		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter book name:");
		String name = br.readLine();

		System.out.println("Enter book author:");
		String author = br.readLine();

		pst.setString(1, "yes");
		pst.setString(2, name);
		pst.setString(3, author);

		pst.executeUpdate();

		System.out.println("Book issued successfully.");
	}

	public static void returnBook() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Return book");

		Connection con = jdbc.getConnection();
		String que = "update library_118 set borrowed=? where bookNAME=? && author=?";

		PreparedStatement pst = con.prepareStatement(que);

		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter book name:");
		String name = br.readLine();

		System.out.println("Enter book author:");
		String author = br.readLine();

		pst.setString(1, "no");
		pst.setString(2, name);
		pst.setString(3, author);

		pst.executeUpdate();

		System.out.println("Book returned successfully.");
	}

	public static void booksList() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Books list");

		Connection con = jdbc.getConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select * from library_118");

		ResultSetMetaData rsmd = res.getMetaData();
		int colNum = rsmd.getColumnCount();

		while (res.next()) {
			for (int i = 1; i < colNum; i++)
				System.out.print(res.getString(i) + "  ");
			System.out.println();
		}

	}

	public static void searchBook() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("Search book");

		Connection con = jdbc.getConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter book name");
		String bname = br.readLine();

		String query = "select  * from library_118 where bookNAME like  ? ";
		PreparedStatement pstmt1=con.prepareStatement(query);
		pstmt1.setString(1,"%"+bname+"%");

		ResultSet res =pstmt1.executeQuery();

		ResultSetMetaData rsmd = res.getMetaData();
		int colNum = rsmd.getColumnCount();

		while (res.next()) {
			for (int i = 1; i < colNum; i++)
				System.out.print(res.getString(i) + "  ");
			System.out.println();
		}

	}

}
