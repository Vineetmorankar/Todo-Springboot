<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Add Todo Details</h1>
	<br>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" name="description" required="required" path="description"/>
		<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
		<form:label path="targetdate">Target-Date</form:label>
		<form:input type="text" name="targetdate" required="required" path="targetdate"/>
		<form:errors path="targetdate" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
	
		<input type="submit" class="btn btn-success">
	</form:form>
</div>
	
	<%@ include file="common/footer.jspf" %>
	
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetdate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>