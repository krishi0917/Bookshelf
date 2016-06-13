<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title> title </title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  </head>
  <body ng-app='bookApp' ng-controller="bookController">
    <div class="container">
    <h1 id="" class="page-header text-center">List Books</h1>
    <form>
	 <fieldset class="form-group">
		 <div class="col-sm-4">
		    <input type="text" name="search" class="form-control" ng-model="search" placeholder="Search by any field">
		  </div>
	  </fieldset>
	</form>
            <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>ISBN</th>  
                    <th>Author</th>
                    <th>Available</th>  
                    <th>Action</th>  
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="data in bookData | filter: search">
                    <td>{{data.bookId}}</td>
                    <td>{{data.title}}</td>
                    <td>{{data.isbn}}</td>
                    <td>{{data.author}}</td>
                    <td>{{data.available}}</td>
                    <td> 
                    	<input type="text" ng-model="data.reservedby" ng-disabled="!data.available" placeholder="Enter user name" >
                        <button id="edit" class="btn btn-sm btn-warning" ng-click="ReserveBook(data)" ng-disabled="!data.available">Reserve</button>
                    </td>
                  </tr>
                </tbody>
              </table>
               <button id="edit" class="btn btn-success btn-sm pull-right" ng-click="addnewBookForm=true">Add Book</button>
               <button id="showoverDue" class="btn btn-danger btn-sm pull-left" ng-click="GetOverdueBooks(); overdue=true" ng-show="!overdue">Show Overdue</button>
               <button id="hideoverDue" class="btn btn-danger btn-sm pull-left" ng-click="overdue=false" ng-show="overdue">Hide Overdue</button>
               &nbsp;&nbsp;
               <button id="showissue" class="btn btn-primary btn-sm" ng-click="GetIssuedBooks(); issueBookCheck=true" ng-show="!issueBookCheck">Show Issued Books</button>
               <button id="hideissue" class="btn btn-primary btn-sm" ng-click="issueBookCheck=false" ng-show="issueBookCheck">Hide Issued Books</button>
            </div>
         <div ng-show="addnewBookForm"> 
          <h1 id="" class="page-header text-center">Add a Book</h1>
	         <form>
				 <fieldset class="form-group">
				    <label for="bookTitle" > Book Title </label>
				    <input type="text" class="form-control" ng-model="newBook.title" placeholder="Book Title">
				  </fieldset>
				
				 <fieldset class="form-group">
				    <label for="ISBN"> ISBN </label>
				    <input type="text" ng-model="newBook.isbn" class="form-control" id="ISBN" name="ISBN" placeholder="ISBN">
				  </fieldset>
				
				<fieldset class="form-group">
				    <label for="author"> Author </label>
				    <input type="text" ng-model="newBook.author" class="form-control" id="author" name="author" placeholder="Author">
				  </fieldset>
				  
				 <!--  <fieldset class="form-group">
				    <label for="bookshelfid"> Bookshelf you like to place the book </label>
		
		  	    <select name = "bookshelfid"  ng-model = "newBook.bookshelfid">
				   
  						<option value="1">1</option>
  						<option value="2">2</option>
  						<option value="3">3</option>
  						<option value="4">4</option>
					</select>
				  </fieldset> -->
				  
			  <button type="submit" class="btn btn-sm btn-primary pull-right" ng-click="AddBook(); addnewBookForm=false">Submit</button>
			</form>
         </div>
         
         <!-- Get the over due book details -->
         <div class="table-responsive" ng-show="overdue">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>ISBN</th>  
                    <th>Author</th>
                    <th>Issued By</th>
                    <th>Return Date</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="data in overdueBooks">
                    <td>{{data.bookId}}</td>
                    <td>{{data.title}}</td>
                    <td>{{data.isbn}}</td>
                    <td>{{data.author}}</td>
                    <td>{{data.reservedby}}</td>
                    <td>{{data.returndate}}</td>
                  </tr>
                </tbody>
              </table>
               
            </div>
            
            <!-- Get the Issued book details -->
         <div class="table-responsive" ng-show="issueBookCheck">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>ISBN</th>  
                    <th>Author</th>
                    <th>Issued By</th>
                    <th>Issue Date</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="data in issuedBooks">
                    <td>{{data.bookId}}</td>
                    <td>{{data.title}}</td>
                    <td>{{data.isbn}}</td>
                    <td>{{data.author}}</td>
                    <td>{{data.reservedby}}</td>
                    <td>{{data.issuedate}}</td>
                  </tr>
                </tbody>
              </table>
               
            </div>
            
         
         
         <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
         <script src="<c:url value="/resources/js/angular-controller.js" />"></script>
  	</div>
  </body>
</html>