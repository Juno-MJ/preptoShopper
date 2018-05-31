<div class="container">
	<div class="row">
		<!-- to diplay side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<!-- to display products -->
		<div class="col-md-9">
			
			<div class="row">
			
				<!-- Adding breadcrumb model -->
				
				<div class="col-lg-12">
					
					<c:if test="${userClicksViewProducts==true}">
						
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/">Index</a><span>-></span></li>
							<li class="active" >All Products</li>
						</ol>
					
					</c:if>
					
					<c:if test="${userClicksSpecificCategory==true}">
						
						<ol class="breadcrumb">
						
							<li><a href="${contextRoot}/">Index</a><span>-></span></li>
							<li class="active">Category</li><span>-></span>
							<li class="active">${chosenCategory.categoryName}</li>
						</ol>
						
					</c:if>
					
				</div>
				
			</div>
			
		</div>
	</div>
</div>