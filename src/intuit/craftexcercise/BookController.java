package intuit.craftexcercise;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	/**
	 * 
	 * Get the book from DB and display it 
	 * @return
	 */
	@RequestMapping(value="/getBooks", method = RequestMethod.GET)
	public @ResponseBody List<Books> getbooks(HttpServletRequest request){
		long uid;
		List<Books> list;
		Crud c = new Crud();
		Session session = (Session) c.crudOpen();	
		Query query = session.createQuery("from Books");
		list = query.list();
		return list;
	}

	/**
	 * Get overdue books
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getOverdueBooks", method = RequestMethod.GET)
	public @ResponseBody List<Books> getOverdueBooks(HttpServletRequest request){
		
		List<Books> list;
		Crud c = new Crud();
		Session session = (Session) c.crudOpen();
			Query query = session.createQuery("from Books where returndate < :dd");
			Date date = new Date();
			query.setDate("dd", date);
			System.out.println(query);
			list = query.list();
		return list;
	}
	
	/**
	 * Get overdue books
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getIssuedBooks", method = RequestMethod.GET)
	public @ResponseBody List<Books> getIssuedBooks(HttpServletRequest request){
		
		List<Books> list;
		Crud c = new Crud();
		Session session = (Session) c.crudOpen();
		Query query = session.createQuery("from Books where available = 0");
		list = query.list();
		return list;
	}
	
	/**
	 * 
	 * Add a new book 
	 * @return
	 */
	
	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addNewBook(HttpServletRequest request,
			@RequestBody Books book){
//		System.out.println("Books " + book.toString());
		Crud c = new Crud();
		Session session = (Session) c.crudOpen();
		
		//Get the available shelf count
		Shelves shelf = new Shelves();
		shelf = (Shelves)c.get(shelf, (long)1);
		if(shelf.getAvailable() > 0){
			shelf.setAvailable(shelf.getAvailable() -1);
			book.setAvailable(true);
			c.save(book);
			c.update(shelf);
			return new ResponseEntity<String>(HttpStatus.OK);	
		}
		else{
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="/reserveBook", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity<String> reserveBook(@RequestParam("userName") String userName, @RequestParam("bookId") long bookId){
		Crud c = new Crud();
		Books book =  new Books();
		book = (Books) c.get(book, bookId);
		book.setReservedby(userName);
		book.setAvailable(false);
		Date issuedate = new Date();
		Date returndate = new Date(issuedate.getTime() + (1000 * 60 * 60 * 24)*7);
		book.setIssuedate(issuedate);
		book.setReturndate(returndate);
		
		//Increment the shelf availabily to 1
		Shelves shelf = new Shelves();
		shelf = (Shelves)c.get(shelf, (long)1);
		shelf.setAvailable(shelf.getAvailable() +1);
		
		c.update(book);
		c.update(shelf);
		return new ResponseEntity<String>(HttpStatus.OK);
	}	
}
