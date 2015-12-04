<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="java.lang.*,java.io.*,java.util.*,java.math.*,java.text.*"%>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Sorteio de 1 a 10</title>
	
	<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"></link>
</head>
<body>

	<br>
	<div class="container">
		
		<div class="row">
		
			<div class="col-md-3">
				<!-- div invisivel pra centralizar o panel do sorteio -->
			</div>
			
			<div class="col-md-6 wrapper text-center pagination-centered">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<h4>Sorteio de 1 a 10</h4>
					</div>
				
					<div class="panel-body" id='toolbar'>
						
						<div>
							<br>
							
							<h1 class="fa fa-5x"><%= request.getAttribute("daVez") %></h1>
						</div>
						
						<br>
						
						<div class='wrapper text-center'>
							<div class="btn-group pagination-centered" role="group">
								<button type="submit" class="btn btn-success btn-lg" value="">
									<span class="fa-stack fa-lg" aria-hidden="true"/>
										<i class="fa fa-refresh  fa-stack-1x fa-spin"  aria-hidden="true"></i>
									
									</span>
									<a href="javascript:history.go(0)" role="button" style="color:white">Sortear</a>
								</button>

								<button type="submit" class="btn btn-warning btn-lg" value="">
									<span class="fa-stack fa-lg" aria-hidden="true">
 										<i class="fa fa-stop-circle fa-stack-1x fa-inverse"></i>	
									</span>
									<a href="logout" role="button" style="color:white">Reinicicar</a>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-3">
				<!-- div invisivel pra centralizar o panel do sorteio -->
			</div>
		</div>
	</div>
</body>
</html>