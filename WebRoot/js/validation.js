$(function(){
	$('#username').blur(function(){
		var username = $('#username').val();
		if (username==null || username==""){
			$('#username').addClass('bred');
			$('#username_hint').html("<span class='formtips onSuccess'>" + "username invalid "+  "</span>");
		} else {
			checkUsername();
		}
	});
	

	$('#pass1').blur(function(){
		var pass1 = $('#pass1').val();
		if (pass1==null || pass1==""){
			$('#pass1').addClass('bred');
			$('#p1_hint').html("<span class='formtips onSuccess'>" + "password invalid "+  "</span>");
		} else {
			$('#pass1').addClass('bgreen');
			$('#p1_hint').html("");
		}
	});
	$('#pass2').blur(function(){
		var pass1 = $('#pass1').val();
		var pass2 = $('#pass2').val();
		if (pass2==null || pass2==""){
			$('#pass2').addClass('bred');
			$('#p2_hint').html("<span class='formtips onSuccess'>" + "password invalid "+  "</span>");
		} else {
			if (pass1!=pass2){
				$('#pass2').addClass('bred');
				$('#p2_hint').html("<span class='formtips onSuccess'>password not equals</span>");
			} else {
				$('#pass2').addClass('bgreen');
				$('#p2_hint').html("");
			}
		}
	});
	$('#name').blur(function(){
		var name = $('#name').val();
		if (name==null || name==""){
			$('#name').addClass('bred');
			$('#name_hint').html("<span class='formtips onSuccess'>" + "name invalid "+  "</span>");
		} else {
			$('#name').addClass('bgreen');
			$('#name_hint').html("");
		}
	});
	
	$('#title').blur(function(){
		var title = $('#title').val();
		if (title==null || tile==""){
			$('#title').addClass('bred');
			$('#title_hint').html("<span class='formtips onSuccess'>" + "title invalid "+  "</span>");
		} else {
			$('#title').addClass('bgreen');
			$('#title_hint').html("");
		}
	});
	
	$('#author').blur(function(){
		var author = $('#author').val();
		if (author==null || author==""){
			$('#author').addClass('bred');
			$('#author_hint').html("<span class='formtips onSuccess'>" + "author invalid "+  "</span>");
		} else {
			$('#author').addClass('bgreen');
			$('#author_hint').html("");
		}
	});
	
	$('#price').blur(function(){
		var price = $('#price').val();
		if (price==null || price==""){
			$('#price').addClass('bred');
			$('#price_hint').html("<span class='formtips onSuccess'>" + "price invalid "+  "</span>");
		} else {
			$('#price').addClass('bgreen');
			$('#price_hint').html("");
		}
	});
	
	$('#quantity').blur(function(){
		var quantity = $('#quantity').val();
		if (quantity==null || quantity==""){
			$('#quantity').addClass('bred');
			$('#quantity_hint').html("<span class='formtips onSuccess'>" + "quantity invalid "+  "</span>");
		} else {
			$('#quantity').addClass('bgreen');
			$('#quantity_hint').html("");
		}
	});
});

function checkUsername() {
	var username = $('#username').val();
	var url = "checkUserName.action?customer.username=" + username;
	$.ajax({
		type : 'POST',
		url : url,
		success : function(data) {
			if ('true' == data) {
				$('#submit').attr('disabled', true);
				$('#username').addClass('bred');
				$('#username_hint').html("<span class='formtips onSuccess'>username is exist!</span>").css('color', 'red');
			} else {
				$('#submit').attr('disabled', false);
				$('#username').addClass('bgreen');
				$('#username_hint').html("<span class='formtips onSuccess'>username is valid!</span>").css('color', 'green');
			}
		}
	});
}



function validateForm() {
	$('input[need="true"]').each(function(i, dom){
		var val = $(dom).val();
		if (null == val || '' == val) {
			$(dom).addClass('bred');
			$('#submit').attr('disabled', false);
		} else {
			$(dom).addClass('bgreen');
		}
	});
	return checkUsername();
}

function book_validateForm() {
	$('input[need="true"]').each(function(i, dom){
		var val = $(dom).val();
		if (null == val || '' == val) {
			$(dom).addClass('bred');
			$('#submit').attr('disabled', false);
		} else {
			$(dom).addClass('bgreen');
		}
	});
}
