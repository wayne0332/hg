// JavaScript Document

//整站轮播图效果
/*$(document).ready(function() {
	$('.scroll2').tinycarousel({axis:'x',interval:'true',intervaltime:4000});
	
	$('.scroll1 li').first().show().siblings().hide()
	$('.scroll2 li').click(function(){
		var index=$('.scroll2 li').index(this)
		$('.scroll1 li').eq(index).show().siblings().hide();
	})
});*/
            

$(function(){


	$('#weixin').click(function(){
		$('.weixinshare').fadeIn();	
		$('.weixinmask').fadeIn();
		
	});
	$('#weixinclose').click(function(){
		$('.weixinshare').fadeOut();
		$('.weixinmask').fadeOut();	
	});	

	//首页banner图片轮播		
	$('#banner,.slide-abox').slide({ mainCell:'.bd ul', autoPlay:true, effect:"fold", delayTime:1200 });
	//首页永达案例图片轮播
	$('.slide-box').slide({ effect:'leftLoop' });
	$('.slide-box').find('ul li:nth-child(4n)').css('margin-right','0')
	$('.tour-box').slide({ mainCell:'.bd ul', vis:4, effect:'leftLoop' });
	$('.mask-box').slide({ mainCell:'.con dl', effect:'leftLoop',prevCell:'.prev1',nextCell:'.next1' });
	$('.us-box').slide({ mainCell:'.bd ul', vis:3, effect:'leftLoop' });


	//登录框
	var loginbox=$('.login-box')
	var loginmask=$('.login-mask')
	var login=$('.login')
	login.click(function(){
		loginbox.fadeIn()
		loginmask.fadeIn()
	})
	loginbox.find('.close').click(function(){
		loginbox.fadeOut()
		loginmask.fadeOut()
	})

	var ulist=$('.u-list');

	ulist.find('dd').first().next().show()

	ulist.find('dd').click(function(){
		$(this).next('.us-box').slideDown().siblings('.us-box').slideUp();
	})


$('.slide-box,.travel-box').find('li').each(function(index){
	var _bloor = true;
	var _this = $(this);
	_this.click(function(){
		$(this).parents('.slide-box').addClass('zindex2').siblings('.slide-box').removeClass('zindex2');
		$(this).find('.mask-box').fadeIn();
		$(this).find('.mask-box').next().fadeIn();
		if(_bloor){
			vSide();
		}
		function vSide(){
			var mask = $('.mask-box',_this).children('.tFocus');
			var ul = $('.tFocus-btn ul',mask);
			var li = ul.children('li').length;
			var _width = ul.children('li:first').outerWidth(true);
			var _just = true;
			ul.children('li').hover(function(){
				_just = false;
			});
			ul.on('mouseleave',function(){
				_just = true;
			})
			mask.slide({
				titCell:'.tFocus-btn ul li',
				effect:'fade',
				prevCell:'.prev_',
				nextCell:'.next_',
				mainCell:'.tFocus-pic',
				titOnClassName:'active',
				startFun:function(i){
					if(_just){
						var t = i>2?li-i:0;
						ul.stop(true,true).animate({left:'-'+_width*t+'px'},400)
					}
				}
			})


			_bloor = false;
		} 
	})
})
	$('.slide-box,.tour-box').find('li').click(function(){
		$(this).find('.mask-box').fadeIn()
		$(this).find('.mask-box').next().fadeIn()
	})

	$('.slide-box,.tour-box').find('.close').click(function(event){
		$(this).parent().fadeOut()
		$(this).parent().next().fadeOut()
		event.stopPropagation();
	}) ;


	//开始登陆
	$('input[name="loginButton"]').click(function(){
		var loginUserName = $.trim($('input[name="u"]').val());
		var loginUserPass = $.trim($('input[name="p"]').val());

		if(loginUserName == "" || loginUserPass=="")
		{
			alert('请输入登陆信息!');
		}else{
			$.ajax({
				url : '/reg.php/login' ,
				type: "POST" ,
				data:{'user' : loginUserName , 'pass' : loginUserPass},
				rsync : false ,
				dataType : 'json',
				error: function(){alert('发生了未知错误，请稍后重试!')} ,
				success : function(data){
					if(data.error == 200)
					{
						alert('欢迎您 尊享会员 : ' + data.username);
						window.location.href="/home.php";
					}else if(data.error == 404){
						alert('登陆失败!');
					}else{
						alert('未知的返回值!');
					}
				}
			});
		}
	});


	//注册新用户
	$('button.goReg').click(function(){
		window.location.href="/reg.php";
	});


	//退出系统
	$('a.loginout').click(function(){
	
		if(confirm('确定要退出系统吗?'))
		{
			$.ajax({
				url : '/home.php/loginout' ,
				success: function(data){
					if(data == 'ok')
					{
						alert('退出成功!');
						window.location.reload();
					}else{
						alert('退出失败!');
					}
				}
			});
		}else{
			return false;
		}
	});

$(".submit").click(function(){
		//alert($("form").html());
		//$("form").submit();
	});

	
	init();

	slideHide();

	navList();
})


// 导航下拉
function navList(){
	var wrap_ = $('#nav_list');
	if(wrap_.length > 0){
		navL();
	}
	function navL(){
		var action_ = $('.n-list');
		var liTop = action_.children();
		var begin_ = $('.inner',$('.f-list'));
		liTop.each(function(i){
			$(this).mouseenter(function(){
				begin_.eq(i).addClass('show_li');
			})
			$(this).mouseleave(function(e){
				var rel = $(e.relatedTarget);
				if (rel.attr('class') == 'inner show_li'){
					begin_.mouseleave(function(m){
						var rel_ = $(m.relatedTarget);
						if (rel_.attr('class') == 'f-list'){

						}else{
							begin_.eq(i).removeClass('show_li');
						}
					})
				}else{
					begin_.eq(i).removeClass('show_li');
				}
			})
		})
	}
}


function slideHide(){
	var wrap = $('.slide-mystyle');
	var hd = $('.hd',wrap);
	var bd = $('.bd',wrap);
	wrap.mouseenter(function() {
		hd.stop(true,true).fadeIn();
	}).mouseleave(function() {
		hd.stop(true,true).fadeOut();
	});

}

/*搜索框焦点*/
function init(){

	$('.data-focus').each(function(){
		var _text = $(this).val();
		$(this).on({
			'focus':function(){
				if( $(this).val() == _text ){ $(this).val('') }
			},
			'blur':function(){
				if( $(this).val() == '' ){ $(this).val(_text) }		
			}
		})
	})
}

$(document).ready(function() {
				
	$('.scroll2').slide({
			mainCell:'.viewport ul',
			prevCell:'a.prev',
			nextCell:'a.next',
			effect:'left',
			vis: 4,
			autoPage:true,
			pnLoop:true
		});
	
	$('.scroll1 li').first().show().siblings().hide();
		$('.scroll2 li').click(function(){
		var index=$('.scroll2 li').index(this)
		$('.scroll1 li').eq(index).show().siblings().hide();
	})
});

    



		