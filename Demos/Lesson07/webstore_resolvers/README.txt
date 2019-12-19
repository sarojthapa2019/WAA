This demo is for lesson: Resolvers & Upload & Exceptions & Internationalization & Tiles

It demos:
1. ContentNegotiatingViewResolver  
http://localhost:8080/webstore_resolvers/market/product.json?id=P1234
http://localhost:8080/webstore_resolvers/market/product.xml?id=P1234
http://localhost:8080/webstore_resolvers/market/products.json
http://localhost:8080/webstore_resolvers/market/products.xml - doesn't work, didn't add parser to process List<Product>

2. Upload images
3. Exception
3.1 Test URL: localhost:8080/webstore_resolvers/market/products/Smartphone - GOOD
		      localhost:8080/webstore_resolvers/market/products/chargers   - Fail
3.2 Add message to NoProductsFoundUnderCategoryException.java which is different from textbook
3.3 Test ControllerAdvice: http://localhost:8080/webstore_resolvers/market/product?id=P123999

4. Internationalization - only addProduct page
http://localhost:8080/webstore_resolvers/market?language=en
http://localhost:8080/webstore_resolvers/market?language=nl


5. Exception Handling
http://localhost:8080/webstore_resolvers/market/products/Smartphoned - The message displayed on the error page isn't the reason we set in @ResponseStatus in NoProductsFoundUnderCategoryException class
Because the exception is caught by ProductController class handleError(), which shows the error page with 200 OK.
Comment handleError(), will see the actual 404 page display the reason we set in @ResponseStatus.

http://localhost:8080/webstore_resolvers/market/products/SmartPhone222 - ExceptionHandler
http://localhost:8080/webstore_resolvers/market/product?id=P12342 - ControllerAdvice 
