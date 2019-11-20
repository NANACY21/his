$(function(){
			if(sessionStorage.getItem("username")!=null){
				$('#uname').html(sessionStorage.getItem("username"));
			}else{
				alert("请先登录");
				location.href="login.html";
			}
			
			ownquery();
			allquery();
			
			$('#self').click(function(){
				$('#bn').show();
				$('#cn').hide();
			});
			
			$('#others').click(function(){
				$('#cn').show();
				$('#bn').hide();
			});
			
			$('#kong').click(function(){
				$('input[name="zs"]').val("");
				$('input[name="xbs"]').val("");
				$('input[name="zlqk"]').val("");
				$('input[name="jws"]').val("");
				$('input[name="gms"]').val("");
				$('input[name="tgjc"]').val("");
				$('input[name="jcjy"]').val("");
				$('input[name="zysx"]').val("");
			});
			
			$('#refresh').click(function(){
				window.location.reload();
			});
			
			
});
		
		function logout(){
			$.ajax({
				type:"get",
				url:"user/logout.action",
				success:function(resp){
					sessionStorage.clear();
					alert("退出登录");
					location.href="login.html";
				},
				error:function(){
					alert("加载数据失败");
				}
			});
		}
		
		function getImfo(casenumber,id){
			$.ajax({
				type:"get",
				url:"register/getRegister.action?casenumber="+casenumber,
				success:function(resp){
					var html="";
					html+="患者姓名："+resp.realname+"&nbsp;&nbsp;病历号："+resp.casenumber+"&nbsp;&nbsp;年龄："+resp.age+"&nbsp;&nbsp;性别："+resp.constantitem.constantname;
					$('#ty').html(html);
				},
				error:function(){
					alert("加载数据失败");
				}
			});
			$('#jiao').click(function(){
				var zs = $('input[name="zs"]').val();
				var xbs = $('input[name="xbs"]').val();
				var zlqk = $('input[name="zlqk"]').val();
				var jws = $('input[name="jws"]').val();
				var gms = $('input[name="gms"]').val();
				var tgjc = $('input[name="tgjc"]').val();
				var jcjy = $('input[name="jcjy"]').val();
				var zysx = $('input[name="zysx"]').val();
				$.ajax({
					type:"post",
					url:"medicalrecord/addMedicalrecords.action",
					data:"casenumber="+casenumber+"&registid="+id+"&readme="+zs+"&present="+xbs+"&presenttreat="+zlqk+"&history="+jws+"&allergy="+gms+"&physique="+tgjc+"&proposal="+jcjy+"&careful="+zysx,
					success:function(resp){
						if(1==resp){
							alert("提交成功");
							window.location.reload();
						}else
						alert("提交失败");
					},
					error:function(){
						alert("加载数据失败");
					}
				});
			});
			
			$('#finish').click(function(){
				$.ajax({
					type:"post",
					url:"register/saveVisitstate.action?regid="+id,
					success:function(resp){
						if(resp==1){
							alert("诊疗完成!");
						}else
							alert("提交数据失败!");
					},
					error:function(){
						alert("加载数据失败");
					}
				});
			});
			
		}
		
		function ownquery(){
			
			var id = sessionStorage.getItem("uid");
			$.ajax({
				type:"get",
				url:"register/getRegisterRealnames.action?uid="+id,
				success:function(resp){
					var html="";
					$.each(resp,function(k,v){
						html+="<tr><td><a href='javascript:void(0)' onclick='getImfo("+v.casenumber+","+v.id+")'>"+v.casenumber+"</a></td><td>"+v.realname+"</td><td>"+v.age+"</td></tr>";
					});
					$('#wei1').append(html);
				},
				error:function(){
					alert("加载数据失败");
				}
			});
				$.ajax({
					type:"get",
					url:"register/getRegisterRealnameds.action?uid="+id,
					success:function(resp){
						var html="";
						$.each(resp,function(k,v){
							html+="<tr><td><a href='javascript:void(0)' onclick='getImfo("+v.casenumber+")'>"+v.casenumber+"</a></td><td>"+v.realname+"</td><td>"+v.age+"</td></tr>";
						});
						$('#yi1').append(html);
					},
					error:function(){
						alert("加载数据失败");
					}
				});
		}
		
		function allquery(){

			var deptid = sessionStorage.getItem("did");
			$.ajax({
				type:"get",
				url:"register/getDeptRegisters.action?deptid="+deptid,
				success:function(resp){
					var html="";
					$.each(resp,function(k,v){
						html+="<tr><td><a href='javascript:void(0)' onclick='getImfo("+v.casenumber+")'>"+v.casenumber+"</a></td><td>"+v.realname+"</td><td>"+v.age+"</td></tr>";
					});
					$('#wei2').append(html);
				},
				error:function(){
					alert("加载数据失败");
				}
			});
			$.ajax({
				type:"get",
				url:"register/getDeptRegisterds.action?deptid="+deptid,
				success:function(resp){
					var html="";
					$.each(resp,function(k,v){
						html+="<tr><td><a href='javascript:void(0)' onclick='getImfo("+v.casenumber+")'>"+v.casenumber+"</a></td><td>"+v.realname+"</td><td>"+v.age+"</td></tr>";
					});
					$('#yi2').append(html);
				},
				error:function(){
					alert("加载数据失败");
				}
			});
		}
		
		
		
		
		
		
		
		