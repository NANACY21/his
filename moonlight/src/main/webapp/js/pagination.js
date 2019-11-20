	var pageSize = 10;//设置每页显示条数
    var total;//数据总条数
    function PageCallback(index, jq) { //前一个表示您当前点击的那个分页的页数索引值，后一个参数表示装载容器。 
  
    	LoadData(index);
    }
    function pagination() {
    	
        $("#pagination").pagination({
            callback:function(index,jq){
            	LoadData(index.getCurrent()-1);
            },
            pageCount:Math.ceil(total/10),
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
        //两侧显示的首尾分页的条目数
        });
    }
    
    function LoadData(pageIndex) {
        $.ajax({
            type : "get",
            url : "department/listpages.action?page="+pageIndex+"&pageSize=" + pageSize,
            async : false,
            dataType : "json",
            success : function(resp) {
            	total = resp.count;
                var lst  = resp.contents;
                var html="<tr><th><input type='button' name='shy' value='全选' style='background-color:#A9A9A9; border-radius: 10px;' onclick='every()' /></th><th>科室编号</th><th>科室名称</th><th>科室分类</th><th>科室类别</th><th>操作1</th><th>操作2</th></tr>";
                $.each(lst,function(k,v){
                	html+="<tr><td><input type='checkbox' value='"+v.id+"' name='cks'/></td><td>"+v.deptcode+"</td><td>"+v.deptname+"</td><td>"+v.constantitem.constantname+"</td><td>"+pan(v.depttype)+"</td><td><a href='javascript:void(0)' onclick=del(this,"+v.id+")>删除</a></td><td><a href='javascript:void(0)' onclick=update("+v.id+")>编辑</a></td></tr>";
                });
                $('.gridtable').html(html);
            }
        });
    }
    function pan(num){
		if(num==1){
			return "临床";  
		}else if(num==2){
			return "医技";
		}else if(num==3){
			return "财务";
		}else if(num==4){
			return "行政";
		}else if(num==5){
			return "其它";
		}
	}
	
	$(function(){
		LoadData(0);
		pagination();
	});
	
	