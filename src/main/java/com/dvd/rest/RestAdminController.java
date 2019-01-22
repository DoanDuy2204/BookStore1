package com.dvd.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.entity.Author;
import com.dvd.entity.Book;
import com.dvd.entity.Category;
import com.dvd.entity.PublishingHouse;
import com.dvd.entity.Transaction;
import com.dvd.entity.User;
import com.dvd.service.AuthorService;
import com.dvd.service.BookService;
import com.dvd.service.CategoryService;
import com.dvd.service.PublishingHouseService;
import com.dvd.service.TransactionService;
import com.dvd.service.UserService;

/**
 * This class is controller where process request from client send server.
 * Process request with Url start is 'api/admin'.
 * @author Admin
 *
 */
@RestController
@RequestMapping("api/admin")
public class RestAdminController {

	//Autowrite TransactionService, BookService
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublishingHouseService publishingHouseService;
	@Autowired
	private AuthorService authorService;
	
	/**
	 * This method is used to process request with url='api/admin/admins/dashBoard' from client.
	 * Get data of dashBoard.
	 * @return
	 * Arraylist<long>
	 */
	@RequestMapping("dashBoard")
	public ArrayList<Long> getDataForDashBoard(){
		ArrayList<Long> data = new ArrayList<Long>();
		//Get number Transaction in database
		long count = transactionService.countTransaction();
		long countView = bookService.getSumViewOfAllBook(); 
		long countUser = userService.countUserInDB();
		data.add(count);
		data.add(countView);
		data.add(countUser);
		for(int i=0;i<12;i++) 
			data.add((long) transactionService.getRevenueOfEarchMounth(i));
		return data;
	}
	
	/**
	 * This method is used to getAll Book in DB start = start and size = 15.
	 * @param numberPage
	 * @return
	 * List<Book>
	 */
	@RequestMapping("product")
	public List<Book> getAllProduct(@RequestParam("numberPage")int numberPage,HttpServletRequest req){
		int start = (numberPage-1)*15;
		String name = req.getParameter("name");
		if(name==null) 
			return bookService.getAllBook(start, 15);
		else return bookService.getAllBookSearch(start, 15, name, 0);
	}
	
	/**
	 * Process request "api/admin/getNumPage" from client. 
	 * This method is used to get counter page of all book in 
	 * @return
	 */
	@GetMapping("product/getNumPage")
	public int getNumPage(HttpServletRequest req) {
		String name = req.getParameter("name");
		int numBook = 0;
		if(name==null) 
			numBook = bookService.getAllBook().size();
		else {numBook = bookService.getAllBookSearch(0, 0, name, -1).size();}
		int num = numBook/15;
		return (num%15!=0) ? ++num : num;
	}
	
	/**
	 * This method is used to delete Book by Id.
	 * @param bookId : Id of Book
	 * @return
	 */
	@DeleteMapping("/product/delete/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
	}
	
	/**
	 * This method is used to get Book by Id.
	 * @param : bookId : Id of Book
	 * @return
	 *  Book
	 */
	@GetMapping("/product/{bookId}")
	public Book getBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}
	
	/**
	 * Process api/admin/transaction from clinet.
	 * This is method used to get Transaction in DB from start to total.
	 * @param numberPage
	 * @return List<Transaction>
	 */
	@GetMapping("transaction")
	public List<Transaction> getTransaction(@RequestParam("numberPage")int numberPage,HttpServletRequest req) {
		String name = req.getParameter("id");
		int start = (numberPage-1)*10;
		if(name==null) {
			return transactionService.getTransaction(start,10,-1);
		}
		int id = Integer.parseInt(name.trim());
		return transactionService.getTransaction(start, 10,id);
	}
	
	/**
	 * This method is used to get Number Page of Transaction
	 * @return
	 */
	@GetMapping("transaction/getNumPage")
	public int getNumPageOfTransaction(HttpServletRequest req) {
		String name = req.getParameter("id");
		int num = 0;
		if(name==null) 
			num = transactionService.getAllTransaction(-1).size();
		else {
			int id = Integer.parseInt(name.trim());
			num = transactionService.getAllTransaction(id).size();
		}
		int numPage = num/10;
		return (num%10!=0) ? ++numPage  : numPage;
	}
	
	/**
	 * This method is used to delete Transaction pass transactionId.
	 * @param transactionId
	 */
	@DeleteMapping("/transaction/delete/{transactionId}")
	public void deleteTransaction(@PathVariable int transactionId) {
		transactionService.deleteTransaction(transactionId);
	}
	
	/**
	 * This method is used to get Transaction pass transactionId.
	 * @param transactionId
	 * @return
	 */
	@GetMapping("/transaction/{transactionId}")
	public Transaction updateTransaction(@PathVariable int transactionId) {
		return transactionService.getAllTransaction(transactionId).get(0);
	}
	
	/**
	 * This method is used to Get All User and infomation of User in DataBase.
	 * @param numberPage : number Page 
	 * @param req : a Api in servlet
	 * @return
	 * List<User>
	 */
	@GetMapping("account")
	public List<User> getAllAccount(@RequestParam("numberPage")int numberPage,HttpServletRequest req){
		int start = (numberPage-1)*10;
		String name = req.getParameter("name");
		return userService.getAllUser(start,10,name);
	}
	
	/**
	 * This method is used to count user in DB.Get Number of Page.
	 * @param req : api in servlet
	 * @return
	 * number of Page
	 */
	@GetMapping("account/getNumPage")
	public int getAllAccount(HttpServletRequest req){
		String name = req.getParameter("name");
		int numPage =  userService.getAllUser(name).size();
		if(numPage%10!=0)
			return ++numPage;
		return numPage;
	}
	
	/**
	 * This method disable User pass userName of User.
	 * @param userName
	 */
	@DeleteMapping("account/delete/{userName}")
	public void getDeleteAccount(@PathVariable String userName) {
		userService.disableUser(userName);
	}
	
	/**
	 * This method get User pass userName of User.
	 * @param userName
	 */
	@GetMapping("account/{userName}")
	public User getAccount(@PathVariable String userName) {
		return userService.getAllUser(userName).get(0);
	}
	
	/**
	 * This method is used to get All Category in DB.
	 * @return
	 * 		List<Category>
	 */
	@GetMapping("getAllCategory")
	public List<Category> getAllCategory(){
		return categoryService.getCategories(-1);
	}
	/**
	 * This method is used to get PublishingHouse in DB.
	 * @return
	 * 		List<PublishingHouse>
	 */
	@GetMapping("getAllPublishingHouse")
	public List<PublishingHouse> getAllPublishingHouse(){
		return publishingHouseService.getPublishingHouse(-1);
	}
	/**
	 * This method is used to get Author in DB.
	 * @return
	 */
	@GetMapping("getAllAuthor")
	public List<Author> getAllAuthor(){
		return authorService.getAllAuthor(null);
	}
	
	@PutMapping("updateBook")
	public void updateBook(@RequestBody Book theBook){
		return;
	}
}
