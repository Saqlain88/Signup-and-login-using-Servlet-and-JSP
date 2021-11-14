<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style type="text/css">
#success_message {
	display: none;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script>
$(document)
.ready(
		function() {
			$('#contact_form')
					.bootstrapValidator(
							{
								// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									password : {
										validators : {
											stringLength : {
												min : 8,
											},
											notEmpty : {
												message : 'Please enter your Password'
											}
										}
									},
									email : {
										validators : {
											notEmpty : {
												message : 'Please enter your Email Address'
											},
											emailAddress : {
												message : 'Please enter a valid Email Address'
											}
										}
									},
									}
								
								}
							}).on(
							'success.form.bv',
							function(e) {
								$('#success_message').slideDown({
									opacity : "show"
								}, "slow") // Do something ...
								$('#contact_form').data(
										'bootstrapValidator')
										.resetForm();

								// Prevent form submission
								e.preventDefault();

								// Get the form instance
								var $form = $(e.target);

								// Get the BootstrapValidator instance
								var bv = $form
										.data('bootstrapValidator');

								// Use Ajax to submit form data
								$.post($form.attr('action'), $form
										.serialize(), function(
										result) {
									console.log(result);
								}, 'json');
							});
		});
</script>
</head>
<body>
	<div class="container">

		<form class="well form-horizontal"
			action="<%=request.getContextPath()%>/login" method="post"
			id="contact_form">
			<fieldset>
				<legend>
					<center>
						<h2>
							<b>Login</b>
						</h2>
					</center>
				</legend>
				<br>

				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								placeholder="E-Mail Address" class="form-control" type="text">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="password"
								placeholder="Password" class="form-control" type="password">
						</div>
					</div>
				</div>


				<!-- Select Basic -->

				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<br>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<button type="submit" class="btn btn-warning">
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
								class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</div>
</body>
</html>
