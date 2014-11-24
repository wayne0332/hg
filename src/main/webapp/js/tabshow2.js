
	//本页选项卡效果
		$(document).ready(function() {
			$('.tablist').children('ul').first().show().siblings().hide()
			$('.tabbox li').addClass('active1')
			$('.tabbox li').first().addClass('active2')
			$('.tabbox li').click(function(){
				$(this).removeClass('active1').addClass('active2')
				.siblings().removeClass('active2').addClass('active1')
				
				var index=$('.tabbox li').index(this)
				
				$('.tablist').children('ul').eq(index).show().siblings().hide()
			})
		});
		
		
		//本页弹出层效果
		$(document).ready(function() {

			var list = $('.tablist');
			list.children('ul').children('li').each(function(index){
				var _this = $(this);
				var _bloor = true;
				_this.click(function(e){
					e.preventDefault();
					e.stopPropagation();
					$('.musk',list).eq(index).show();
					$('.muskbg',list).show();

					if(_bloor){
						vSide();
					}

				});


				function vSide(){
					var musk = $('.musk',list).eq(index).children('.tFocus');
					var ul = $('.tFocus-btn ul',musk);
					var li = ul.children('li').length;
					var _width = ul.children('li:first').outerWidth(true);
					var _just = true;
					ul.children('li').hover(function(){
						_just = false;
					});
					ul.on('mouseleave',function(){
						_just = true;
					})
					musk.slide({
						titCell:'.tFocus-btn ul li',
						effect:'fade',
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
			$('.close').click(function(e){
					e.preventDefault();
					e.stopPropagation();
					list.find('.musk').hide();
					$('.muskbg',list).hide()
				})
		})
