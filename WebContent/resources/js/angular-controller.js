(function(){
	
	var app = angular.module('bookApp',[]);
	
	var bookController = function($scope, $http , $window){
		/**
		 * Scope variables
		 */
		$scope.addnewBookForm = false;
		$scope.overdue = false;
		$scope.issueBookCheck = false;
		$scope.newBook = {}; // to add a new book
		var loadAllBooks = function(){
			$http({
				method:'GET',
				url: '/Bookshelf1/getBooks'
			}).success(function(data){
				console.log(data);
				$scope.bookData = angular.copy(data);
			}).error(function(){});
		}
		loadAllBooks();
		
		/**
		 * Add a book
		 */
		$scope.AddBook = function(){
			console.log($scope.newBook);
			var book = {
					"isbn" : $scope.newBook.isbn,
					"title": $scope.newBook.title,
					"author": $scope.newBook.author
			}
			$http.post('/Bookshelf1/addBook',book).success(function(data, status, headers, config){
				alert("Book Added Successfully");
			}).error(function(data){
				alert("No space available in shelf to Add book");
			});
		}
		/**
		 * Reserve a book
		 */		
		$scope.ReserveBook = function(book){
			if(!book.reservedby)
				alert("Please enter username to Reserve");
			else{
				var postUrl = '/Bookshelf1/reserveBook?userName=' +  book.reservedby + '&bookId=' + book.bookId;
				$http({
					method: 'POST',
					url: postUrl
				}).success(function(){
					var returnDate = new Date(Date.now() + (7 * 24 * 60 * 60 * 1000));
					alert("Return Date is: " +  returnDate.toString());
					loadAllBooks();
				}).error(function(){});
			}
		}
		/**
		 * Get overdue books
		 */
		$scope.GetOverdueBooks = function(){
			$http({
				method: 'GET',
				url: '/Bookshelf1/getOverdueBooks'
			}).success(function(data){
				$scope.overdueBooks = angular.copy(data);
				$scope.overdueBooks.forEach(function(d){
					d.returndate = (new Date(d.returndate)).toString();
				});
				console.log(data);
			}).error(function(){});
		}
		
		/**
		 * Get All issued books
		 */
		$scope.GetIssuedBooks = function(){
			$http({
				method: 'GET',
				url: '/Bookshelf1/getIssuedBooks'
			}).success(function(data){
				$scope.issuedBooks = angular.copy(data);
				$scope.issuedBooks.forEach(function(d){
					d.issuedate = (new Date(d.issuedate)).toString();
				});
			}).error(function(){});
		}
		
		
	}
		
	app.controller("bookController", bookController);	
}())