<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="my-4">Shop Name</h1>
<div class="list-group">
	  <c:forEach items="${electronicCategories}" var="parsedCategoryFromItems">
	  	<a href="${contextRoot}/show/category/${parsedCategoryFromItems.categoryId}/products" class="list-group-item" >${parsedCategoryFromItems.categoryName}</a>
	  </c:forEach>
</div>