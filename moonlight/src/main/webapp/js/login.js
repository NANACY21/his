$(function(){
	$('input[name="log"]').click(function(){
		var name = $('input[name="username"]').val();
		var password = $('input[name="psw"]').val();
		var type = $('#xiala').val();
		$.ajax({
			type:"post",
			url:"user/login.action",
			data:"username="+name+"&password="+password+"&usetype="+type,
			success:function(resp){
				//alert(resp.id);
				if(""==resp){
					alert("用户名或密码错误");
				}else if(type==3){
					alert("登陆成功");
					sessionStorage.setItem("did",resp.deptid);
					sessionStorage.setItem("uid",resp.id);
					sessionStorage.setItem("username",resp.username);
					location.href="blsy.html";
				}else if(type==2){
					alert("登陆成功");
					sessionStorage.setItem("username",resp.username);
					location.href="xcgh.html";
				}else if(type==1){
					alert("登陆成功");
					sessionStorage.setItem("username",resp.username);
					location.href="department2.html";
				}
			},
			error:function(){
				alert("加载数据失败");
			}
		});
	});
});