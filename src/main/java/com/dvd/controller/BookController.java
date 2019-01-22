package com.dvd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dvd.entity.Book;
import com.dvd.service.AuthorService;
import com.dvd.service.BookService;
import com.dvd.service.CategoryService;
import com.dvd.service.PublishingHouseService;

/**
 * This class is controller where process request begin url="book".
 * @author Admin
 *
 */
@Controller
@RequestMapping("book")
public class BookController {
	
	//Autowrite Service 
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublishingHouseService publishingHouseService;
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	/**
	 * This method is process request with url="book/books".
	 * @param model
	 * @param req
	 * @param numberPage : number of page
	 * @param command 
	 * @return
	 */
	@GetMapping("books")
	public String getAllBook(Model model,HttpServletRequest req
							,@RequestParam("numberPage")int numberPage
							,@RequestParam("command")String command) {
		model.addAttribute("category", categoryService.getCategories(5));
		model.addAttribute("publishingHouse",publishingHouseService.getPublishingHouse(5));
		String[] catelogy = new String[] {"Sách bán chạy","Sách mới nhất","Sách nhiều view","Sách nổi bật"};
		double []cost = new double[]{200000,500000,1000000,2000000};
		model.addAttribute("cost", cost);
		model.addAttribute("catelogy", catelogy);
		int total = 15;
		int nPage = (numberPage-1)*15;
		int pageNumber =  0;
		switch(command) {
			case "book" : 
				model.addAttribute("books", bookService.getAllBook(nPage, total));
				model.addAttribute("command", "book");
				pageNumber = bookService.getAllBooks().size()/total;
				break;
			case "category":
				int id = Integer.parseInt(req.getParameter("categoryId").trim());
				model.addAttribute("books", bookService.getAllBookByCategoryId(nPage, total, id));
				pageNumber = bookService.getAllBookByCategory(id).size()/total;
				model.addAttribute("command", "category");
				model.addAttribute("id", id);
				break;
			case "publishingHouse":
				int id1 = Integer.parseInt(req.getParameter("publishingHouseId").trim());
				model.addAttribute("books", bookService.getAllBookByPublishingHouseId(nPage, total, id1));
				pageNumber = bookService.getAllByPublishingHouseId(id1).size()/total;
				model.addAttribute("command", "publishingHouse");
				model.addAttribute("id", id1);
				break;
			case "cost" : 
				double min = Double.parseDouble(req.getParameter("min").trim());
				String maxParam = req.getParameter("max");
				if(maxParam==null)
					maxParam = "-1";
				double max = Double.parseDouble(maxParam);
				model.addAttribute("books", bookService.getAllBookByCost(nPage,total,min,max,0));
				pageNumber = bookService.getAllBookByCost(nPage, total, min, max, -1).size()/total	;
				model.addAttribute("command", "cost");
				break;
			case "search" :
				String name = req.getParameter("search");
				model.addAttribute("books", bookService.getAllBookSearch(nPage, total, name,0));
				pageNumber = bookService.getAllBookSearch(nPage, total, name, -1).size()/total;
				model.addAttribute("search", name);
				model.addAttribute("command","search");
				break;
			case "price" : 
				String kind = req.getParameter("kind");
				switch(kind) {	
					case "min" :
						model.addAttribute("books", bookService.getAllBookPriceAsc(nPage, total,0));
						numberPage = bookService.getAllBookPriceAsc(nPage, total, -1).size()/total;
						break;
					case "max" :
						model.addAttribute("books", bookService.getAllBookPriceDesc(nPage, total,0));
						numberPage = bookService.getAllBookPriceDesc(nPage, total, -1).size()/total;
						break;
				}
				model.addAttribute("command", "price");
				break;
			case "catelog" :
				String catelog = req.getParameter("catelog");
				switch(catelog) {
					case "Sách bán chạy":
						model.addAttribute("books", bookService.getAllBookBySoldNumber(nPage,total));
						break;
					case "Sách mới nhất":
						model.addAttribute("books", bookService.getAllBookByDate(nPage, total));
						break;
					case "Sách nhiều view":
						model.addAttribute("books", bookService.getAllBookViewDese(nPage, total));
						break;
					case "Sách nổi bật":
						model.addAttribute("books", bookService.getAllBookByTrend(nPage, total));
						break;
				}
				model.addAttribute("command","catelog");
				model.addAttribute("catelog", catelog);
				pageNumber = bookService.getAllBooks().size()/total;
		}
		if(pageNumber%1!=0) {
			pageNumber++;
		}
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("pageNumber", pageNumber);
		return "book/book";
	}
	
	@GetMapping("updateBook")
	public String updateBook(@RequestParam int idBook,HttpServletRequest req,Model model) {
		int idCategory = Integer.parseInt(req.getParameter("category"));
		int idPublishingHouse = Integer.parseInt(req.getParameter("publishingHouse"));
		String[] id = req.getParameterValues("author");
		int[] idAuthor = new int[id.length];
		for(int i=0;i<id.length;i++)
			idAuthor[i]=Integer.parseInt(id[i]);
		Book book = new Book();
		book.setName( req.getParameter("name"));
		book.setPrice(Double.parseDouble(req.getParameter("price")));
		book.setDiscount(Integer.parseInt(req.getParameter("discount")));
		book.setCategory(categoryService.getCategoryById(idCategory));
		book.setPublishingHouse(publishingHouseService.getPublishingHouseById(idPublishingHouse));
		book.setId(idBook);
		book.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		book.setAuthors(authorService.getListAuthorById(idAuthor));
		bookService.updateBook(book);
		model.addAttribute("updatesucess","success");
		return "admin/admin";
	}
}
