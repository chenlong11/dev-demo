// JavaScript Document

$(function(){
    jQuery.browser={};(function(){jQuery.browser.msie=false; jQuery.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();
	//判断是否为ie6
	var ie6=!-[1,]&&!window.XMLHttpRequest;
	
	//ie6提醒
	ie6Tips();
	
	//点击返回顶部
    clickBackTop();
	
	//桌面导航desktopNav
    desktopNav();
	
	//首页按钮
    indexBtn();
	
	//左部三级菜单
    leftTree();
	
	//客户左侧菜单
	culeftNav();
	
	//事件管理按钮
    eventPageBtn();
	
	//事件管理列表
	eventList();
	
	//宽度列表计算
	eventListWith();
	
	//设备新增编辑容左右宽度计算
    equipWidth();
	
	//全屏宽度计算
	mainWidth();
	
	//全屏主题内容左右宽度计算
    mainWidth();
	
	//专家库列表每项宽度计算
    expertDataWidth();
	
	//iframe框架高度与宽度计算
    //iframePage();
	
	//通知公告iframe高度计算
    noticeIframe();
	
	//满意度调查highcharts_con宽度计算
    highchartsWidth($('#hcConWrap div.highcharts_con'), 3);
	highchartsWidth($('#hcConWrapFour div.highcharts_con'), 4);
	
	//窗口重置时再次计算
	$(window).resize(function(){
		eventListWith();
		mainWidth();
		equipWidth();
		expertDataWidth();
		highchartsWidth($('#hcConWrap div.highcharts_con'), 3);
		highchartsWidth($('#hcConWrapFour div.highcharts_con'), 4);
	});
    var ph=$(".searchArea").height();
    var h=$(".searchArea").children("table").height();
    if(h<=ph){
        $(".filter-item1").hide();
    }else{
        $(".filter-item1").click(function(){
            $(".searchArea").animate({height:h});
            $(this).next(".put-away").show();
        });
        $(".put-away").click(function(){
            $(".searchArea").animate({height:'78px'});
            $(this).hide();
        });
    }
	
	//事件处理tab切换
	/*var btn = $('#dlsBtn').children('a'),
	    dsw = $('div.deal_switch_wrap').children('div.deal_switch_con');
	btn.click(function(){
	    var n = btn.index(this);
		btn.removeClass('focus');
		$(this).addClass('focus');
		dsw.hide();
		dsw.eq(n).show();
	});*/
	
	//事件处理iframe高度计算
    //eventIframe();
	
	//三级树
	threeTreeFunc();
	
	//全屏导航
    fsNav();
   	
	//全屏搜索
    fsSearch();
	
	//全屏按钮漂浮
/*	fsFloat($('#fsNavtitle'));
	fsFloat($('#equipAddLeft'), $('#fsNavtitle'));
	*/
	//专家库ie6,hover效果
	if(ie6 == true){
	    expertDataHover();
	}
	
	//列表通用样式更多按钮list_btnmore
    commonListBtn();
	
	//带图标下来列表
	$('div.icon_select').each(function(i){
        var $this = $(this),
		    dtkTxt = $this.find('a.mainbtn').find('em');
			dtkCon = $this.find('div.ins_con');
		iconSelect($this, dtkTxt, dtkCon);
    });
	
	//全屏客户选择
    iconSelect($('#tnCustomer'), $('#tncText').children('span'), $('#tncCon'));
});

//列表通用样式更多按钮list_btnmore
function commonListBtn(){

    $(document).on('mouseover', 'div.list_btnmore', function() {
        $(this).css('z-index', '9999');
        $(this).children('a.list_btnmore_btn').addClass('focus');
        $(this).children('div.list_btnmore_con').show();
    });
    $(document).on('mouseout', 'div.list_btnmore', function() {
        $(this).css('z-index', '0');
        $(this).children('a.list_btnmore_btn').removeClass('focus');
        $(this).children('div.list_btnmore_con').hide();
    });

}

//IE6提醒
function ie6Tips(){
	if(ie6 == true){
	    var str = '<div class="ie6tips" id="ie6Tips">您好，你的浏览器已过时，已不在我们的支持范围内，请点击<a href="http://se.360.cn">360浏览器</a>、<a href="http://www.firefox.com.cn">火狐</a>更新，谢谢！</div>';
		$(str).appendTo($('body'));
		$(window).scroll(function(){
			$('#ie6Tips').css('top' , $(window).scrollTop())
		});
	}
}

//点击返回顶部
function clickBackTop(){
    $('<div class="click_back_top" id="clickBackTop"></div>').appendTo($('body'));
	clickToTop('clickBackTop');
}

//事件管理翻页按钮
function eventPageBtn(){
    var eb = $('#eventBtn'),
	    ebp = eb.children('a.prev'),
		ebn = eb.children('a.next');
	ebp.hover(function(){animationBtn(ebp, ebn, 55, 5)}, function(){animationBtn(ebp, ebn, 5, 55)});
	ebn.hover(function(){animationBtn(ebn, ebp, 55, 5)}, function(){animationBtn(ebn, ebp, 5, 55)});
	eb.hover(function(){}, function(){animationBtn(ebp, ebn, 5, 5)});
	function animationBtn(one, two, wone, wtwo){
	    one.animate({'width' : wone}, 100, 'swing');
		two.animate({'width' : wtwo}, 100, 'swing');
	}
}

//首页按钮
function indexBtn(){
    var ep = $('#dpButton'),
	    epi = ep.children('div.dpb_item');
	epi.each(function(i){
	    var episa = $(this).find('div');
		$(this).hover(function(){
		    episa.eq(1).css({'top' : '100px', 'opacity' : 0}).animate({'top' : 0, 'opacity' : 1}, 200, 'easeInSine');
			episa.eq(0).animate({'top' : '-100px', 'opacity' : 0}, 200, 'easeOutSine');
		},function(){
		    episa.eq(0).css({'top' : '100px', 'opacity' : 0}).animate({'top' : 0, 'opacity' : 1}, 300, 'easeInSine');
			episa.eq(1).animate({'top' : '-100px', 'opacity' : 0}, 300, 'easeOutSine');
		});
	});
}

//事件管理列表图标展示
function eventList(){
    var ep = $('#eventProcess'),
	    epi = ep.children('div.ep_item');
	epi.each(function(i){
	    var episa = $(this).find('div.epi_show').children('a');
		$(this).hover(function(){
		    episa.eq(1).css('top' , '54px').animate({'top' : 0}, 200, 'easeInSine');
			episa.eq(0).animate({'top' : '-54px'}, 200, 'easeOutSine');
		},function(){
		    episa.eq(0).css('top' , '54px').animate({'top' : 0}, 300, 'easeInSine');
			episa.eq(1).animate({'top' : '-54px'}, 300, 'easeOutSine');
		});
	});
}

//桌面导航desktopNav
function desktopNav(){
    var dn = $('#dpnCon'),
	    dnp = $('div.dpn_nav_con'),
	    dnc = $('div.dpn_con_wrap'),
		dncone = dn.find('tr.dp_first_level'),
		dnconetd = dncone.children('td'),
		dnctwo = dn.find('tr.dp_second_level'),
		dnctwotd = dnctwo.children('td'),
		dnconeL = dncone.find('span').length,
		timer;
	dn.hover(function(){
		if(dnconeL > 0){
		    dncone.find('span').hide();
		}
		clearTimeout(timer);
		dnp.css('z-index', '9999');
	    dnp.stop().animate({'height' : dnc.height()}, 300, 'swing');
	}, function(){
		if(dnconeL > 0){
		    dncone.find('span').show();
		}
		timer = setTimeout(function(){dnp.css('z-index', '0');}, 300);
	    dnp.stop().animate({'height' : '43px'}, 300, 'swing');
		dnconetd.removeClass('focus');
		dnctwotd.removeClass('focus');
	});
	dnconetd.mouseover(function(){
		var num = dnconetd.index(this);
		dnctwotd.removeClass('focus');
	    dnctwotd.eq(num).addClass('focus');
		dnconetd.removeClass('focus');
	    $(this).addClass('focus');
	});
	dnctwotd.mouseover(function(){
		var num = dnctwotd.index(this);
		dnconetd.removeClass('focus');
	    dnconetd.eq(num).addClass('focus');
		dnctwotd.removeClass('focus');
	    $(this).addClass('focus');
	});
}

//客户左侧菜单
function culeftNav(){
	$('h3.navone').each(function(i) {
		$(this).click(function(){
			var $this = $(this),
				idStr = $this.attr('id').substring(6),
				con = $('#navtwo' + idStr),
				dis = con.css('display');
			if(dis == 'block'){
				$this.removeClass('focus');
			    con.slideUp(200);
			}else{
				$('h3.navone').removeClass('focus');
			    $('div.navtwo').slideUp(200);
				$this.addClass('focus');
				con.slideDown(200);
			}
		});
    });
}

//左部三级菜单
function leftTree(){
    var navone = $('div.navone'),
		navtwo = $('ul.navtwo'),
		navthree = $('li.navthree');
	navtwo.hide();
	navtwo.eq(0).show();
	navthree.children('ul').hide();
	navone.click(function(){
		$this = $(this);
		var isStr = $this.attr('id').substring('6');
		navone.children('a').removeClass('focus');
		$this.children('a').addClass('focus');
		var uldis = $('#navtwo' + isStr).css('display');
		if(uldis == 'block'){
			$('#navtwo' + isStr).slideUp();
		}else{
			navtwo.slideUp();
			$('#navtwo' + isStr).slideDown();
		}
	});
	navthree.children('ul').click(function(event){
	    event.stopPropagation();
	});
	navthree.click(function(){
		var $this = $(this),
			ulLg = $this.children('ul').length,
			uldis = $this.children('ul').css('display');
		if(ulLg != 0){
		   if(uldis == 'block'){
				$this.removeClass('focus');
				$this.children('ul').slideUp();
			}else{
				navthree.removeClass('focus');
				$this.addClass('focus');
				navthree.children('ul').slideUp();
				$this.children('ul').slideDown();
			} 
		}
		
	});
}

//三级树
function threeTreeFunc(){
    var st = $('div.select_tree');
	st.each(function(i){
		//一级下拉
        var fl = $(this).children('div.first_level'),
		    flb = fl.find('a.fl_morebtn');
		fl.eq(0).height('auto');
		flb.eq(0).addClass('focus');
		flb.click(function(){
			var $this = $(this),
			    n = flb.index(this),
			    fln = fl.eq(n);
			if($this.hasClass('focus') == false){
				st.find('div.thrid_level').height('22px');
				st.find('a.tl_morebtn').removeClass('focus').text('更多');
				flb.removeClass('focus')
				$this.addClass('focus');
				fl.height('38px');
			    fln.height('auto');
			}else{
				$this.removeClass('focus');
			    fl.height('38px');
			};
		});
		//三级下拉
		fl.each(function(n){
            var sln = $(this),
			    tl = sln.find('div.thrid_level'),
				tlc = sln.find('div.thrid_level_con'),
				tlb = sln.find('a.tl_morebtn');
			tlb.click(function(){
				var $this = $(this),
				    m = tlb.index(this),
					tln = tl.eq(m);
				    tlch = parseInt(tlc.eq(m).height());
				if(tlch > 27){
				    if($this.hasClass('focus') == false){
						tlb.removeClass('focus').text('更多');
						$this.addClass('focus').text('收起');
						tl.height('22px');
						tln.height('auto');
					}else{
						$this.removeClass('focus').text('更多');
						tl.height('22px');
					}
				}
			});
			tlb.each(function(m){
                if(parseInt(tlc.eq(m).height()) <= 27){
				    $(this).remove();
				}
            });
        });
    });
}

//全屏按钮漂浮
function fsFloat(ele, topele){
	var fsNavtitle = ele,
	    fnt = fsNavtitle.children('div.fs_navtitle_con'),
		fntClass = fnt.hasClass('common_list');
	if(fsNavtitle[0]){
		var fsnTop = fsNavtitle.offset().top,
			fsnPos = 'fixed',
			fsnPosTop = topele ? parseInt(topele.height()) + 40 : 0;
		if(ie6 == true){fsnPos = 'absolute'}
		if(fsNavtitle.attr('noscroll') != 'true'){
			$(window).scroll(function(){
				var st = parseInt($(this).scrollTop());
				if(ie6 == true){fsnPosTop = topele ? (st + 40) : st}
				if(st > fsnTop){
					if(fntClass == true){
						fnt.removeClass('common_list');
					}
					fsNavtitle.css({
						'position' : fsnPos,
						'top' : fsnPosTop
					}).addClass('focus');
				}else{
					if(fntClass == true){
						fnt.addClass('common_list');
					}
					fsNavtitle.css({
						'position' : 'static',
						'top' : 'static'
					}).removeClass('focus');
				}
			});
		}
	}
}

//全屏搜索
function fsSearch(){
	var tnSearchWrap = $('#tnSearchWrap'),
	    tnSearch = $('#tnSearch'),
	    tnsWord = $('#tnsWord'),
		tnsCon = $('#tnsCon'),
		tnsaBtn = tnsCon.children('a'),
		tnsInput = $('#tnsInput'),
		tnsBtn = $('#tnsBtn');
	iconSelect(tnSearch, tnsWord, tnsCon);
	var tncW = parseInt(tnsCon.width()) + 1;
	tnSearchWrap.width(tncW + 131).hover(function(){
	    $(this).addClass('focus');
	}, function(){
		tnsInput.blur();
		tnsConHide();
	});
	var tsw = parseInt(tnSearchWrap.width());
	tnsInput.blur(function(){
	    if(tnsInput.val() == ''){
		    tnSearchWrap.removeClass('focus');
		}
	});
	function tnsConHide(){
	    tnsCon.hide();
		tnsWord.removeClass('focus');
	}
}

//全屏导航
function fsNav(){
	var totalnav = $('#totalnav'),
		tnbtn = totalnav.children('a.tn_btn'),
		tncon = totalnav.children('div.tn_con');
	totalnav.hover(function(){
		tnbtn.addClass('focus');
		tncon.show();
	}, function(){
	    tnbtn.removeClass('focus');
		tncon.hide();
	});
}

//专家库ie6,hover效果
function expertDataHover(){
    var earItem = $('#equipAddRight').children('div.eb_width');
	earItem.hover(function(){
	    $(this).addClass('focus');
	}, function(){
	    $(this).removeClass('focus');
	});
}

//iframe框架高度与宽度计算
function iframePage(){
    var im = $('div.iframe_main');
	if(im.length > 0){
		var nowHeight = parseInt($(window).height()) - parseInt($('header.fs_header').height()) - parseInt($('nav.fs_nav').height()) - parseInt($('footer').height()) - 130;
		im.find('iframe').height(nowHeight);
	}
}

//通知公告iframe高度计算
function noticeIframe(){
    var nm = $('div.notice_main_con');
	if(nm.length > 0){
	    var nowHeight = parseInt($(window).height()) - parseInt($('header.fs_header').height()) - parseInt($('nav.fs_nav').height()) - parseInt($('footer').height()) - parseInt($('div.fs_navtitle').height()) - 160;
		
		nm.find('iframe').height(nowHeight);
		nm.find('div.notice_item_wrap').height(nowHeight);
	}
}

//专家库列表每项宽度计算
function expertDataWidth(){
    var ear = $('#equipAddRight');
	    earItem = ear.children('div.eb_width');
	earItem.width((parseInt(ear.width()) - 60) / 2);
}

//事件处理iframe高度计算
function eventIframe(){
	var iec = $('div.iframecon');
	iec.css({'display' : 'block', 'visibility' : 'hidden'});
    iec.each(function(i){
		var $this = $(this),
		    ime = $this.children('iframe');
		ime.load(function(){
			$(this).height(iframeHeight(this));
			iec.eq(i).css({'display' : 'none', 'visibility' : 'visible'});
		});
    });
}
function iframeHeight(ele){
    return parseInt($(ele).contents().find('body').height());
}

//highcharts宽度计算
function highchartsWidth(ele, num){
    var ww = parseInt($(window).width());
	if(ww >= 1000){
	    hgwidth(ww);
	}else{
	    hgwidth(1000);
	}
	function hgwidth(n){
	    ele.each(function(i){$(this).width((n - (2 + 15)*num - 15) / num)});
	};
}

//宽度列表计算

function eventListWith(){
    var ww = parseInt($(window).width()),
	    rw = (ww - 30 - (2 + 10)*6 - 30) / 6 - 10  ,
		minw = (1200 - 30 - (2 + 10)*6 - 30) / 6 - 10;
	var ele = $('#eventProcess').children('div.ep_item');
	if(ww >= 1200){
		thisw(rw, rw + 29);
	}else{
	    thisw(minw, minw + 29);
	}
	function thisw(num, nummore){
	    ele.each(function(i){
			$(this).width(num);
		});
		//ele.eq(0).width(nummore);
		//ele.eq(5).width(nummore);
	}
	
}

//全屏主题内容左右宽度计算
function mainWidth(){
	var fl = $('#fsmLeft'),
	    fr = $('#fsmRight'),
		num = 79;
	num = parseInt(fl.css('padding-left')) > 0 ? num : 49
	var allW = parseInt($(window).width()) - num;
	if(allW >= 1200){
	    fl.width(allW * 0.7);
	    fr.width(allW * 0.3);
	}else{
	    fl.width((1200-num)*0.7);
	    fr.width((1200-num)*0.3);
	}
}

//设备新增编辑容左右宽度计算
function equipWidth(){
    var fl = $('#equipAddLeft'),
        fr = $('#equipAddRight'),
        page = fl.attr('page');
   var num = 79;
    num = parseInt(fr.css('padding-left')) > 0 ? num : 49
    var allW = parseInt($(window).width()) - num;
    if(page == 'detail_info'){
        if(allW >= 1200 ){
            fl.width(allW * 0.3);
            fr.width(allW * 0.7);
        }else{
            fl.width((1200-num)*0.3);
            fr.width((1200-num)*0.7);
        }
    }else{
        if(allW >= 1200 ){
            fl.width(allW * 0.2);
            fr.width(allW * 0.8);
            $("#addclose").click(function(){
                fl.width(allW * 0.02).children("").hide();
                fl.children(".addopen").show();
                fr.width(allW * 0.98);
            });
            $("#addopen").click(function(){
                fl.width(allW * 0.2);
                fr.width(allW * 0.8);
                fl.children("").show();
                $(this).hide();
            });
            if($("#addopen").css("display") == "block" ){
                fl.width(allW * 0.02);
                fr.width(allW * 0.98);
            }else{
                fl.width(allW * 0.2);
                fr.width(allW * 0.8);
            }
            $("#popclose").click(function(){
                fl.width(allW * 0.02).children("").hide();
                fl.children(".leftPopRight").show();
                $("#popopen").show();
                fr.width(allW * 0.98);
            });
            $("#popopen").click(function(){
                fl.width(allW * 0.2);
                fr.width(allW * 0.8);
                fl.children("").show();
                $(this).hide();
            });
            if($("#popopen").css("display") == "block" ){
                fl.width(allW * 0.02);
                fr.width(allW * 0.98);
            }else{
                fl.width(allW * 0.2);
                fr.width(allW * 0.8);
            }
        }else{
            fl.width((1200-num)*0.2);
            fr.width((1200-num)*0.8);
            $("#addclose").click(function(){
                fl.width((1200-num) * 0.02).children("").hide();
                fl.children(".addopen").show();
                fr.width((1200-num) * 0.98);
            });
            $("#addopen").click(function(){
                fl.width((1200-num) * 0.2);
                fr.width((1200-num) * 0.8);
                fl.children("").show();
                $(this).hide();
            });
            if($("#addopen").css("display") == "block" ){
                fl.width((1200-num) * 0.02);
                fr.width((1200-num) * 0.98);
            }else{
                fl.width((1200-num) * 0.2);
                fr.width((1200-num) * 0.8);
            }
            $("#popclose").click(function(){
                fl.width((1200-num) * 0.02).children("").hide();
                fl.children(".leftPopRight").show();
                $("#popopen").show();
                fr.width((1200-num) * 0.98);
            });
            $("#popopen").click(function(){
                fl.width((1200-num) * 0.2);
                fr.width((1200-num) * 0.8);
                fl.children("").show();
                $(this).hide();
            });
            if($("#popopen").css("display") == "block" ){
                fl.width((1200-num) * 0.02);
                fr.width((1200-num) * 0.98);
            }else{
                fl.width((1200-num) * 0.2);
                fr.width((1200-num) * 0.8);
            }
        }
    }

}

$(document).ready(function(){
  resizeWindow();
 });
 
function resizeWindow(){
var winH = parseInt($(window).height()) - parseInt($('header.fs_header').height()) - parseInt($('nav.fs_nav').height()) - parseInt($('footer').height()) - 148;
$(".leftPopRight").css('height',winH+'px');//这里的div，选择你的那个div
}

//里程碑表格展开
$(function(){
    $(".triangle-tit").click(function(){
        $(".secondary").animate({height: 'toggle'});
        $(this).toggleClass("focus");
    });
});


//QCT考核
qct();

//QCT考核
function qct(){
    var fouse = $(".color_b");
    fouse.hover(function(){
            var i = fouse.index(this);
            $(".indrop_down").eq(i).show();
        },function(){
            $(".indrop_down").hide();
        }
    )}

//左侧折叠
$(document).ready(function(){
    resizeWindow();
    var leftP = $('.item-leftPop');
    $("#popclose2").click(function(){
        leftP.width(15).children("").hide();
        leftP.children(".leftPopRight").show();
        $("#popopen2").show();
    });
    $("#popopen2").click(function(){
        leftP.width(280);
        leftP.children("").show();
        $(this).hide();
    });
    $(".newest-record").click(function(){
        $(this).addClass("orange").siblings().removeClass("orange");
        $(".newest-record").children("h2").children("span").removeClass("orange");
        $(this).children("h2").children("span").addClass("orange");
    });
    $(".process_table tr").click(function(){
        $(".process_table tr").removeClass("cur");
        $(this).addClass("cur");
        $(".process_table tr").children("td").children(".nfradio").removeClass("nfinput_checked");
        $(this).children("td").children(".nfradio").addClass("nfinput_checked");
    });
});


//pc端 客户分析


$(document).ready(function(){

//筛选展开
    $(function(){
        $(".filter-title em").click(function(){
            $(".item-box").animate({height: 'toggle'});
        });
    });

    $(function(){
        $(".filter-item em.Put-away").click(function(){
        	$(this).hide();
            $(this).prev().show();
            $(".item-box2").animate({height: '245px'}).addClass("cur");
        });
    });
    $(function(){
        $(".filter-item em.more").click(function(){
            $(this).hide();
            $(this).next().show();
            $(".item-box2").scrollTop(0,0).animate({height: '164px'}).removeClass("cur");
        });
    });


	/*筛选鼠标点击变换样式*/
	/*筛选-更多*/
    $(function(){
        var winW = parseInt($(window).width())-300;
        for(var i = 0;i<$(".sort-item").length;i++){
            var sum = 0;
            $(".sort-item").eq(i).children("a").each(function(){
                sum = sum + parseInt($(this).width()+30);
            });
            if(winW > sum){
                $("span.more").eq(i).hide();
            }else{
                $("span.more").eq(i).show();
            }
        };
        $(".filter-item span.more").click(function(){
            $(this).hide();
            $(this).next(".filter-item span.Put-away").show();
            $(this).prev(".sort-item").addClass("high");
        });
        $(".filter-item span.Put-away").click(function(){
            $(this).hide();
            $(this).prev(".filter-item span.more").show();
            $(this).parents(".filter-item").children(".sort-item.high").removeClass("high");
        });
    })
    $(function() {
        $(".filter-title em.more").click(function() {
            $(this).hide();
            $(".filter-title em.Put-away").show();
        });
        $(".filter-title em.Put-away").click(function() {
            $(this).hide();
            $(".filter-title em.more").show();
        });
    })


    $(function(){
        $(".Customer-classification").click(function(){
            $(this).addClass("cur");
            $(this).parents("td").siblings("td").children(".Customer-classification").removeClass("cur");
            $(this).children("em").hide();
            $(this).parents("td").siblings("td").children(".Customer-classification").children("em").show();
            $(this).children(".arrow_cur").show();
            $(this).parents("td").siblings("td").children(".Customer-classification").children(".arrow_cur").hide();
            $(this).children("label").addClass("no_lf");
            $(this).parents("td").siblings("td").children(".Customer-classification").children("label").removeClass("no_lf");
            $(this).children("label").children("p").addClass("cur");
            $(this).parents("td").siblings("td").children(".Customer-classification").children("label").children("p").removeClass("cur");

        });
    });

    $(function() {
        $(".time em").click(function() {
            $(this).toggleClass("cur"); //Remove any "active" class
        });
    })

	/*时间筛选点击显示*/
    $(".time em").click(function(){
        $(this).next(".select-box").toggle();
    });


	/*滑过显示*/
    $(".btnR").hover(function(){
        var i = $(".btnR").index(this);
        $(".btnCon").eq(i).toggle();
    });


    $(".head").hover(function(){
        var i = $(".head").index(this);
        $(".popM").eq(i).toggle();
    });

});

// JavaScript Document
//点击选中
$(function(){
    $("#ztbox #conter li").click(function(){
        $(this).addClass("cur").siblings().removeClass("cur");
        $(this).children("span").show();
        $(this).siblings().children("span").hide();
    });
});


function myEvent(obj, ev, fu){
    obj.attachEvent ? obj.attachEvent('on' + ev, fu) : obj.addEventListener(ev, fu, false);
}
window.onload = function(){
    var oBox = document.getElementById('ztbox');
    var oLeft = document.getElementById('left');
    var oRight = document.getElementById('right');
    var oConter = document.getElementById('conter');
	if(oConter && oConter.getElementsByTagName('ul').length>0){
        var oUl = oConter.getElementsByTagName('ul')[0];
        var oLi = oConter.getElementsByTagName('li');
        var oScroll = document.getElementById('scroll');
        var oSpan = oScroll.getElementsByTagName('span')[0];
        var i = 0;
        var num = oLi.length;
        oUl.style.width = 146 * num +'px';
        var iWidth = oScroll.offsetWidth/(oUl.offsetWidth / oConter.offsetWidth - 1)
        //var iWidth=416;
        oLeft.onmouseover = oRight.onmouseover = function(){
            this.className = 'hover';
            //点击左侧按钮
            oLeft.onclick = function(){
                var butscroll = oSpan.offsetLeft - iWidth;
                oRight.className = 'hover';
                oscroll(butscroll);
            };
            //点击右侧按钮
            oRight.onclick = function(){
                var butscroll = oSpan.offsetLeft + iWidth;
                oLeft.className = 'hover';
                oscroll(butscroll);
            };
        };
	}

    //滚动事件
    function oscroll(l){
        if(l < 0){
            l = 0;
            oLeft.className = 'a';
            oLeft.onmouseover = function(){
                this.className = 'a';
            };
        }else if(l > oScroll.offsetWidth - oSpan.offsetWidth){
            l = oScroll.offsetWidth - oSpan.offsetWidth;
            oRight.className = 'b';
            oRight.onmouseover = function(){
                this.className = 'b';

            };
        }

        var scrol = l / (oScroll.offsetWidth - oSpan.offsetWidth);
        sMove(oSpan, 'left', Math.ceil(l));
        sMove(oUl, 'left', '-'+Math.ceil((oUl.offsetWidth - (oConter.offsetWidth + 15)) * scrol));
    }

};
//运动框架
function getStyle(obj, attr){
    return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj, false)[attr];
}
function sMove(obj, attr, iT, onEnd){
    clearInterval(obj.timer);
    obj.timer = setInterval(function(){
        dMove(obj, attr, iT, onEnd);
    },30);
}
function dMove(obj, attr, iT, onEnd){
    var iCur = 0;
    attr == 'opacity' ? iCur = parseInt(parseFloat(getStyle(obj, attr)*100)) : iCur = parseInt(getStyle(obj, attr));
    var iS = (iT - iCur) / 5;
    iS = iS > 0 ? Math.ceil(iS) : Math.floor(iS);
    if(iCur == iT){
        clearInterval(obj.timer);
        if(onEnd){
            onEnd();
        }
    }else{
        if(attr == 'opacity'){
            obj.style.ficter = 'alpha(opacity:'+(iCur + iS)+')';
            obj.style.opacity = (iCur + iS) / 100;
        }else{
            obj.style[attr] = iCur + iS +'px';
        }
    }
}



