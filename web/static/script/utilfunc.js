// JavaScript Document

//判断是否为ie6
var ie6=!-[1,]&&!window.XMLHttpRequest;

/*________________________________________(start)public js________________________________________*/
function iconSelect(btn, txt, con){//自定义下拉列表
    var tw = parseInt(txt.width()),
        cw = parseInt(con.width()) - 20;
    if(tw <= cw){
        txt.width(cw);
    }else{
        txt.width(tw);
    };
    con.width(parseInt(btn.width()) - 2);
    btn.unbind('click');
    btn.click(function(){
        $(this).toggleClass('focus');
        con.toggle();
    });
    btn.hover(function(){
        btn.css('z-index', '100001');
    }, function(){
        $(this).removeClass('focus');
        con.hide();
        btn.css('z-index', '0');
    });
    con.unbind('click');
    con.children('a').click(function(event){
        txt.text($(this).text());
        txt.attr("t",$(this).attr("t"));
        con.hide();
        event.stopPropagation();
    });
}
/*________________________________________(start)public js________________________________________*/


/*________________________________________(start)ComboTree________________________________________*/
function ComboTree(ele){
    this.element = ele;
}
ComboTree.prototype = {
    create : function(){
        var $this = $('#' + this.element),
            dw = parseInt($this.width()) + parseInt($this.css('padding-left')) + parseInt($this.css('padding-right')) + parseInt($this.css('border-left-width')) + parseInt($this.css('border-right-width')),
            dh = parseInt($this.height()) + parseInt($this.css('padding-bottom')) + parseInt($this.css('padding-top')) + parseInt($this.css('border-bottom-width')) + parseInt($this.css('border-top-width'));
        $('<div class="larks_combo_tree"><div class="combo_tree_dropdown"></div></div>').insertAfter($this);
        $this.insertBefore($this.next('div.larks_combo_tree').children('div.combo_tree_dropdown'));
        var ct = $this.parent('div.larks_combo_tree'),
            ctd = $this.next('div.combo_tree_dropdown');
        ct.css({'width' : dw, 'height' : dh});
        ctd.css({'top' : (dh - parseInt($this.css('border-bottom-width'))), 'width' : (dw - parseInt(ctd.css('border-left-width')) - parseInt(ctd.css('border-right-width'))) - 10});
        $this.focus(function(){
            ctd.show();
            ct.css('z-index', '99');
        });
        return this;
    },
    treeCon : function(){
        return $('#' + this.element).next('div.combo_tree_dropdown');
    }
}
function combotree(ele){
    return new ComboTree(ele);
}
/*________________________________________(start)ComboTree________________________________________*/


/*________________________________________(start)niceform________________________________________*/
function Niceform(ele){
    this.originalElements = ele;
};
Niceform.prototype = {
    create : function(style, omax){
        var _this = this;
        $(_this.originalElements).each(function(i){
            var tp = $(this).parent('div');
            if(tp.hasClass('nfradio') == false &&  tp.hasClass('nfcheckbox') == false && tp.hasClass('nfselect') == false){
                var eName = $(this).get(0).tagName;
                switch(eName){
                    case 'INPUT':
                        var eType = $(this).attr('type');
                        switch(eType){
                            case 'radio':
                                _this.radio($(this), style);
                                break;
                            case 'checkbox':
                                _this.checkbox($(this), style);
                                break;
                        };
                        break;
                    case 'SELECT':
                        _this.dropDown($(this), style, omax);
                        break;
                };
            }
        });
        return this;
    },
    radio : function(ele, style){
        ele.css('display', 'none');
        $('<div class="nfradio"></div>').insertAfter(ele);
        ele.appendTo(ele.next('div.nfradio'));
        var ep = ele.parent('div.nfradio');
        ep.attr('name' , ele.attr('name')).addClass(ele.attr('class'));
        if(ele.attr('checked') == true){
            ep.addClass('nfinput_checked');
        };
        ep.click(function(){
            var $this = $(this),
                en = $this.attr('name');
            if(en != ''){
                $('div.nfradio[name='+en+']').removeClass('nfinput_checked');
            }
            $this.addClass('nfinput_checked');
            $this.children('input').attr('checked', true);
        });
        if(typeof(style) == 'object'){
            ep.css(style);
        }
    },
    checkbox : function(ele, style){
        ele.css('display', 'none');
        $('<div class="nfcheckbox"></div>').insertAfter(ele);
        ele.appendTo(ele.next('div.nfcheckbox'));
        var ep = ele.parent('div.nfcheckbox');
        ep.prop('name' , ele.prop('name')).addClass(ele.prop('class'));
        if(ele.prop('checked') == true){
            ep.addClass('nfinput_checked');
        };
        ep.click(function(){
            var $this = $(this),
                cr = $this.children('input'),
                cd = cr.prop('checked');
            if(cd == true){
                $this.removeClass('nfinput_checked');
                cr.prop('checked', false);
            }else{
                $this.addClass('nfinput_checked');
                cr.prop('checked', true);
            }
        });
        if(typeof(style) == 'object'){
            ep.css(style);
        }
    },
    dropDown : function(ele, style, omax){
        //ele.css('display', 'none');
        $('<div class="nfselect"><span><em></em></span><div class="nfselect_dropdown"></div></div>').insertAfter(ele);
        ele.appendTo(ele.next('div.nfselect'));
        var ep = ele.parent('div.nfselect'),
            es = ep.children('span'),
            esm = es.children('em'),
            ed = ep.children('div.nfselect_dropdown'),
            ot = '';
        ep.addClass(ele.attr('class'));
        ele.children('option').each(function(i){
            ot += '<a number='+i+'>'+$(this).text()+'</a>'
        });
        ed.append(ot);
        var eqnum = ele.children('option').index(ele.children('option:selected'));
        esm.text(ele.find('option:selected').text());//jquery获取原生select被选中项文字内容
        ed.children('a').eq(eqnum).addClass('nfSelectFocus');
        esm.attr('number', eqnum);
        var edw = parseInt(ed.width());
        esm.css('background-position', ''+edw-15+'px center');
        ep.css('width', edw);
        es.click(function(){
            ed.toggle();
            ep.css('z-index', '9999');
            return false;
        });
        ep.hover(function(){}, function(){
            ed.hide();
            ep.css('z-index', '0');
        });
        ed.children('a').click(function(){
            esm.text($(this).text());
            ed.children('a').removeClass('nfSelectFocus');
            $(this).addClass('nfSelectFocus');
            ed.hide();
            ep.css('z-index', '0');
            ele.find('option:eq('+ed.children('a').index(this)+')').attr("selected", 'selected');
            ele.focus();
            return false;
        });
        var al = ed.children('a').length;
        if(al > 6){ omaxfunc(6, ed) };
        if(!isNaN(style)){
            omaxfunc(style, ed);
        }else if(typeof(style) == 'object'){
            if(omax != undefined){
                omaxfunc(omax, ed);
            }
            ele.css(style);
            var tw = style.width;
            if(tw){
                selectWidth(tw, esm, ep, ed)
            };
        }
    },
    niceformArr : function(){//获取niceform元素，返回数组
        var oe = $(this.originalElements);
        arr = [];
        for(var i=0; i<oe.length; i++){
            arr.push(oe.eq(i).parent('div'));
        }
        return arr;
    },
    op : function(n){//获取form原始jquery对象指定元素的父级（指定niceform元素）
        return $(this.originalElements).eq(n).parent('div');
    },
    eq : function(n){//获取niceform指定元素
        if(!isNaN(n)){
            return new Niceform(this.originalElements + ':eq('+n+')');
        }
    },
    omax : function(n){//设置select最大显示项
        var oe = $(this.originalElements);
        if(!isNaN(n)){
            for(var i=0; i<oe.length; i++){
                var od = this.op(i).children('div.nfselect_dropdown'),
                    al = od.children('a').length;
                if(al > n){ omaxfunc(n, od) };
            };
        }
        return this;
    },
    getSelectedTxt : function(){//获取选中项文字
        var oe = $(this.originalElements);
        for(var i=0; i<oe.length; i++){
            if(type(oe.eq(i)) == 'select'){
                return oe.eq(i).children('option:selected').text();
            }
        };
        return this;
    },
    getSelectedVal : function(){//获取选中项value
        var oe = $(this.originalElements);
        for(var i=0; i<oe.length; i++){
            if(type(oe.eq(i)) == 'select'){
                return oe.eq(i).children('option:selected').attr('value');
            }
        };
        return this;
    },
    getSelectedIndex : function(){//返回选中项索引
        var oe = $(this.originalElements);
        for(var i=0; i<oe.length; i++){
            if(type(oe.eq(i)) == 'select'){
                return oe.eq(i).children('option').index(oe.eq(i).children('option:selected'));
            }
        };
        return this;
    },
    setSelected : function(n){//设置选中项
        if(!isNaN(n)){
            var oe = $(this.originalElements);
            for(var i=0; i<oe.length; i++){
                if(type(oe.eq(i)) == 'select'){
                    var oi = this.op(i),
                        oia = oi.children('div.nfselect_dropdown').children('a');
                    oia.removeClass('nfSelectFocus');
                    oia.eq(n).addClass('nfSelectFocus');
                    oi.find('em').text(oia.eq(n).text());
                    oe.eq(i).find('option:eq('+n+')').attr("selected", 'selected');
                }
            };
        }
        return this;
    },
    clear : function(){//清空selected
        var oe = $(this.originalElements);
        for(var i=0; i<oe.length; i++){
            oe.eq(i).html('');
            this.op(i).find('em').text('');
            this.op(i).children('div.nfselect_dropdown').html('');
        }
        return this;
    },
    remove : function(n){//移除指定option
        if(!isNaN(n)){
            var oe = $(this.originalElements);
            for(var i=0; i<oe.length; i++){
                var oeo = oe.eq(i).children('option'),
                    op = this.op(i),
                    txt = oeo.eq(n).text();
                oeo.eq(n).remove();
                op.children('div.nfselect_dropdown').children('a').eq(n).remove();
                if(txt == op.find('em').text()){
                    op.find('em').text('').attr('number', '');
                }
            }
        };
        return this;
    },
    add : function(){//增加option
        var arg = arguments;
        if(typeof(arg[0]) == 'object'){
            var _this = this,
                oe = $(this.originalElements);
            oe.each(function(i){
                var oei = oe.eq(i),
                    oi = _this.op(i),
                    oism = oi.children('span').children('em'),
                    oid = oi.children('div.nfselect_dropdown'),
                    oidal = parseInt(oid.children('a:last').attr('number')),
                    stro = '',
                    stra = '',
                    oismn = '',
                    oismtxt = '',
                    selected = '',
                    className = '',
                    aValue = '',
                    aText = '';
                switch(arg.length){
                    case 1:
                        aValue = 'value';
                        aText = 'text';
                        break;
                    case 2:
                        aValue = arg[1];
                        aText = 'text';
                        break;
                    case 3:
                        aValue = arg[1];
                        aText = arg[2];
                        break;
                };
                for(var n in arg[0]){
                    var val = arg[0][n][aValue] ? arg[0][n][aValue] : n,
                        txt = arg[0][n][aText] ? arg[0][n][aText] : n,
                        sd = arg[0][n].selected,
                        index = oidal ? (oidal + parseInt(n)) : n;
                    if(sd){
                        oismn = sd == true ? index : '';
                        oismtxt = sd == true ? txt : '';
                        selected = sd == true ? 'selected="selected"' : '';
                        className = sd == true ? 'class="nfSelectFocus"' : '';
                    }else{
                        selected = '';
                        className = '';
                    }
                    stro += '<option value="'+val+'" '+selected+'>'+txt+'</option>';
                    stra += '<a '+className+' number="'+index+'">'+txt+'</a>';
                };
                if(oismn != ''){
                    oism.text(oismtxt).attr('number', oismn);
                    oid.children('a').removeClass('nfSelectFocus');
                };
                oei.append(stro);
                oid.append(stra);
                var newoida = oid.children('a');
                newoida.unbind('click');
                newoida.click(function(){
                    newoida.removeClass('nfSelectFocus');
                    $(this).addClass('nfSelectFocus');
                    oism.text($(this).text());
                    oid.hide();
                    oi.css('z-index', '0');
                    oei.find('option:eq('+newoida.index(this)+')').attr("selected", 'selected');
                    oei.focus();
                    return false;
                });
            });
        }
        return this;
    },
    prop : function(){//设置获取niceform属性
        var oe = $(this.originalElements);
        if(typeof(arguments[0]) == 'string' && arguments[0] == 'checked'){
            if(arguments.length == 1){
                var oc = oe.attr('checked');
                if(oc == true){return true}else if(oc == false){return false;}
            }else if(arguments.length == 2){
                for(var i=0; i<oe.length; i++){
                    var oq = oe.eq(i);
                    if(arguments[1] == true){
                        oq.attr('checked', true);
                        oq.parent('div').addClass('nfinput_checked');
                    }else if(arguments[1] == false){
                        oq.attr('checked', false);
                        oq.parent('div').removeClass('nfinput_checked');
                    }
                };
            };
        }
        return this;
    },
    css : function(){//获取与设置niceform的css样式
        var oe = $(this.originalElements);
        switch(typeof(arguments[0])){
            case 'string':
                switch(arguments.length){
                    case 2:
                        for(var i=0; i<oe.length; i++){
                            var oi = this.op(i);
                            oi.css(arguments[0] , arguments[1]);
                            if(type(oe.eq(i)) == 'select' && arguments[0] == 'width'){
                                selectWidth(arguments[1], oi.find('em'), oi, oi.children('div.nfselect_dropdown'));
                            }
                        }
                        break;
                    default:
                        for(var i=0; i<oe.length; i++){
                            return this.op(i).css(arguments[0]);
                        };
                };
                break;
            case 'object':
                for(var i=0; i<oe.length; i++){
                    var oi = this.op(i),
                        aw = arguments[0].width;
                    oi.css(arguments[0]);
                    if(type(oe.eq(i)) == 'select' && aw){
                        selectWidth(aw, oi.find('em'), oi, oi.children('div.nfselect_dropdown'));
                    };
                };
                break;
        };
        return this;
    },
    change : function(fn){//niceform的select值改变时的事件
        var _this = this,
            oe = $(this.originalElements);
        oe.each(function(i){
            var oq = $(this),
                to = _this.op(i);
            if(type(oq) == 'select' && typeof(fn) == 'function'){
                var ts = to.find('em'),
                    td = to.children('div.nfselect_dropdown');
                td.children('a').click(function(){
                    var tv = $(this).attr('number');
                    if(tv != ts.attr('number')){
                        fn.call($(this).parent('div.nfselect_dropdown').next('select'));
                        ts.attr('number', tv);
                    }
                });
            }
        });
        return this;
    },
    on : function(en, fn){//为niceform添加事件
        var oe = $(this.originalElements);
        if(typeof(en) == 'string' && typeof(fn) == 'function'){
            for(var i=0; i<oe.length; i++){
                addEvent(this.op(i).get(0), oe.eq(i).get(0), en, fn);
            }
        }
        return this;
    },
    live : function(en, fn){//为niceform以事件委托方式添加事件
        var oe = this.originalElements;
        if(typeof(en) == 'string' && typeof(fn) == 'function'){
            if(document.attachEvent){
                document.attachEvent('on'+en, function (){
                    var type = event.type.toLowerCase(),
                        target = event.srcElement,
                        eTat = $(target).children('input');
                    if(type == en && (classTag(target, eTat) || idTag(eTat) || nameTag(target))){
                        if(fn.call() == false){
                            event.cancelBubble = true;
                            return false;
                        }
                    }
                });
            }else{
                document.addEventListener(en, function (ev){
                    var type = ev.type.toLowerCase(),
                        target = ev.target,
                        eTat = $(target).children('input');
                    if(type == en && (classTag(target, eTat) || idTag(eTat) || nameTag(target))){
                        if(fn.call() == false){
                            ev.cancelBubble = true;
                            ev.preventDefault();
                        }
                    }
                }, false);
            }
        };
        function classTag(target, eTat){//判断class
            if(oe.split('.')[0] != ''){
                var eTatSelf = $(target).children(oe.split('.')[0]);
                return eTatSelf.length > 0 && eTatSelf.hasClass(oe.split('.')[1]);
            }else{
                return eTat.length > 0 && eTat.hasClass(oe.split('.')[1]);
            }
        };
        function idTag(eTat){//判断id
            if(eTat.attr('id') != undefined && eTat.length > 0){
                return eTat.attr('id') == oe.split('#')[1];
            }
        };
        function nameTag(target){//判断tagName
            var eTatSelf = $(target).children(oe);
            return eTatSelf.get(0).tagName.toLowerCase() == oe && (eTatSelf.attr('type') == 'radio' || 'checkbox');
        };
        return this;
    },
    extend : function(name, fn){//为niceform添加自定义方法
        if(typeof(name) == 'string' && typeof(fn) == 'function'){
            this.prototype[name] = fn;
        }
        return this;
    }
};
//以简易方式niceform创建新对象Niceform
function niceform(ele){
    return new Niceform(ele);
};
//默认应用页面所有radio,checkbox,select

//niceform调用方法
function omaxfunc(n, ele){//设置select下拉的高
    ele.css('height', n*parseInt(ele.children('a').eq(0).height()));
}
function selectWidth(val, em, nfs, dp){//设置select的宽
    em.css('background-position', ''+parseInt(val)-15+'px center');
    nfs.css('width', val);
    dp.css('width', val);
};
function type(ele){//获取form类型
    var formstyle;
    switch(ele.get(0).tagName){
        case 'INPUT':
            formstyle = ele.attr('type');
            break;
        case 'SELECT':
            formstyle = 'select';
            break;
    };
    return formstyle;
}
function addEvent(obj, objt, sEv, fn){//事件绑定
    if(obj.attachEvent){
        obj.attachEvent('on'+sEv, function (){
            if(false == fn.call(objt)){
                event.cancelBubble=true;
                return false;
            }
        });
    }else{
        obj.addEventListener(sEv, function (ev){
            if(false == fn.call(objt)){
                ev.cancelBubble=true;
                ev.preventDefault();
            }
        }, false);
    }
}
/*________________________________________(start)niceform________________________________________*/


/*________________________________________(start)dialog_popup________________________________________*/
function Dialog(){
    this.width = 60;
    this.height = 60;
    this.mode = 'percentage'; //pixel
    this.opacity = 0.6;
    this.speed = 500;
    this.zIndex = 9000;
    this.config = {};
}
Dialog.prototype = {
    openDialog:function(dialogId, title, config, url){
        this.config = config || {};
        var $window = $(window),
            wWidth = parseInt($window.width()),
            wHeight = parseInt($window.height()),
            dHeight = parseInt($(document).height()),
            width = parseInt(this.width),
            height = parseInt(this.height),
            speed = parseInt(this.speed),
            opacity = parseFloat(this.opacity),
            mode = this.mode,
            config = config || {},
            cds = config.dialogStyle,
            zIndex = $('div.dialog_overlay').length == 0 ? this.zIndex : parseInt($('div.dialog_overlay:last').css('z-index')) + 2;
        //如果存在自定义样式dialogStyle，获取自定义中参数
        if(cds){
            var widthSelf = parseInt(cds.width),
                heightSelf = parseInt(cds.height),
                opacitySelf = parseFloat(cds.opacity),
                modeSelf = cds.mode,
                nobtnSelf = cds.nobtn,
                nocloseSelf = cds.noclose;
            width = isNaN(widthSelf) == false ? widthSelf : width;
            height = isNaN(heightSelf) == false ? heightSelf : height;
            opacity = isNaN(opacitySelf) == false ? opacitySelf : opacity;
            mode = isNaN(modeSelf) == true ? modeSelf : mode;
            nobtn = nobtnSelf != undefined ? nobtnSelf : false;
            noclose = nocloseSelf != undefined ? nocloseSelf : false;
        }
        //组织dialog的HTML结构
        var overlayStr = '<div class="dialog_overlay" id="dialogOverlay'+dialogId+'"></div>',
            dialogStr = '<div class="dialog_popup" id="dialogPopup'+dialogId+'"><div class="dp_top"><h3>'+title+'</h3><a class="dialogclose" id="dialogClose'+dialogId+'">×</a></div><div class="dp_con"><iframe name="dialogIframe'+dialogId+'" id="dialogIframe'+dialogId+'" class="dialog_iframe" src="'+url+'" scrolling="auto" allowTransparency="true" frameborder="0"></iframe></div><div class="dp_bottom"><div class="btn_wrap clearfix"><a class="dpbtn" id="dialogCancel'+dialogId+'"> <span>关闭</span></a>',
            cbs = config.buttons;
        if(cbs && cbs.length > 0){
            for(var i=0; i<cbs.length; i++){
                var btnId = cbs[i].btnId,
                    btnStyle = cbs[i].btnStyle,
                    btnName = cbs[i].btnName;
                dialogStr += '<a onclick="return _OnCustomerBtnClick(\''+btnId+'\',\''+dialogId+'\')" class="dpbtn '+btnStyle+'" id="'+btnId+'"><span>'+btnName+'</span></a>';
            }
        }
        dialogStr += '</div></div></div>';
        //把dialog插入HTML
        $(overlayStr).appendTo($('body'));
        $(dialogStr).appendTo($('body'));
        //设置按钮栏与标题栏关闭按钮是否存在
        if(nobtn == true){
            $('#dialogClose'+dialogId).remove();
            $('#dialogPopup'+dialogId).children('div.dp_bottom').remove();
        };
        //没有关闭按钮
        if(noclose == true){
            $('#dialogClose'+dialogId).remove();
            $('#dialogCancel'+dialogId).remove();
        }
        //设置dialog样式
        $('body').css('overflow', 'hidden');
        var oly = $('#dialogOverlay' + dialogId),
            dlg = $('#dialogPopup' + dialogId),
            dcl = $('#dialogCancel' + dialogId),
            dce = $('#dialogClose' + dialogId),
            dch = dlg.children('div.dp_bottom').height();
        dlgwidth = 0,
            dlgheight = 0;
        if(mode == 'pixel'){
            dlgwidth = width,
                dlgheight = height;
        }else{
            dlgwidth = wWidth * width / 100,
                dlgheight = wHeight * height / 100;
        };
        oly.css({
            display : 'none',
            width : wWidth,
            height :dHeight,
            opacity : opacity,
            filter : 'progid:DXImageTransform.Microsoft.Alpha(opacity='+opacity*100+')',
            zIndex : zIndex
        });
        if(ie6 == true){
            dlg.css('position', 'absolute');
        };
        dlg.css({
            left : (wWidth -  dlgwidth) / 2,
            top : (wHeight - dlgheight) / 2,
            display : 'none',
            width : dlgwidth,
            height : dlgheight,
            zIndex : zIndex + 1
        });
        dlg.children('div.dp_con').css('height', dlgheight - parseInt(dlg.children('div.dp_top').height()) - parseInt(dch == null ? 0 : dch) - 2);
        //dialog淡入页面
        oly.fadeIn(speed);
        dlg.fadeIn(speed > 100 ? speed - 100 : speed);
        //dialog默认关闭按钮添加关闭对话框事件
        dcl.click(function(){
            closeDialogFunc(oly, dlg, speed);
        });
        dce.click(function(){
            closeDialogFunc(oly, dlg, speed);
        });
        //返回iframe的ID
        return 'dialogIframe' + dialogId;
    },
    closeDialog:function(dialogId){
        var speed = this.speed,
            oly = $('#dialogOverlay' + dialogId),
            dlg = $('#dialogPopup' + dialogId);
        closeDialogFunc(oly, dlg, speed);
    }
}
//调用子页函数
function _OnCustomerBtnClick(btnID, dialogId){
    $('#dialogIframe' + dialogId).get(0).contentWindow.onDialogBtnClick(btnID, dialogId, popupDialog.config);
}
//关闭弹出层
function closeDialogFunc(oly, dlg, speed){
    if(ie6 == true){
        oly.hide(speed);
        dlg.hide(speed);
    }else{
        oly.fadeOut(speed);
        dlg.fadeOut(speed);
    };
    setTimeout(function(){
        dlg.find("iframe").contents().find("body").empty();
        oly.remove();
        dlg.remove();
    }, speed);
    $('body').css('overflow', 'auto');
}

var popupDialog = new Dialog();

//弹出对话框带url
function popDialog(dialogId, title, config, url){
    return popupDialog.openDialog(dialogId, title, config, url);
}
//弹出对话框不带url
function popDialogUrl(dialogId, title, config){
    return popupDialog.openDialog(dialogId, title, config);
}
//关闭对话框
function hideDialog(dialogId){
    popupDialog.closeDialog(dialogId);
}
/*________________________________________(end)dialog_popup________________________________________*/


/*________________________________________(start)confirmInfo________________________________________*/
function Confirm(){
    this.opacity = 0;
    this.speed = 300;
    this.title = '确认信息';
    this.msg = '确认要进行此操作吗？';
    this.success;
    this.surefn;
    this.cancelfn;
};
Confirm.prototype.creatConfirm = function(){
    var zIndex = $('div.dialog_overlay').length == 0 ? 9100 : parseInt($('div.dialog_overlay:last').css('z-index')) + 2,
        opacity = this.opacity,
        speed = this.speed,
        title = this.title,
        msg = this.msg,
        success = this.success,
        surefn = this.surefn,
        cancelfn = this.cancelfn;
    //组织confirm的HTML结构
    var overlayStr = '<div class="confirm_overlay" id="confirmOverlay"></div>',
        confirmStr = '<div class="comfirm_popup" id="confirmPopup"><div class="dp_top"><h3>'+title+'</h3><a class="dialogclose" id="confirmPopupClose">×</a></div><div class="cp_content"><p class="cp_message">'+msg+'</p></div><div class="dp_bottom"><div class="btn_wrap clearfix"><a class="dpbtn" id="cancelConfirm"><span>取消</span></a><a class="dpbtn bluebtn" id="sureConfirm"><span>确认</span></a></div></div></div>';
    //插入到HTML中
    if($('div.comfirm_popup').length >= 1){
        $('div.confirm_overlay').remove();
        $('div.comfirm_popup').remove();
        insertBody();
    }else{
        insertBody();
    };
    function insertBody(){
        $(overlayStr).appendTo($('body'));
        $(confirmStr).appendTo($('body'));
    }
    //获取confirm元素
    var coy = $('#confirmOverlay'),
        cpp = $('#confirmPopup'),
        scf = $('#sureConfirm');
    //没有确定按钮
    var cpm = cpp.find('p.cp_message');
    if(typeof(success) == 'boolean'){
        scf.remove();
        cpp.width('500px');
        if(success == true){
            cpm.addClass('success_info');
        }else if(success == false){
            cpm.addClass('success_failure');
        }
    };
    //设置confirm样式
    var wWidth = parseInt($(window).width()),
        wHeight = parseInt($(window).height()),
        dHeight = parseInt($(document).height());
    coy.css({
        width : wWidth,
        height :dHeight,
        opacity : opacity,
        filter : 'progid:DXImageTransform.Microsoft.Alpha(opacity='+opacity*100+')',
        zIndex : zIndex
    });
    cpp.css({
        left : (wWidth - parseInt(cpp.width())) / 2,
        top : (wHeight - parseInt(cpp.height())) / 2,
        zIndex : zIndex + 1
    });
    //confirm显示
    if(ie6 == true){
        cpp.css('position', 'absolute').show();
        coy.show();
    }else{
        coy.fadeIn(speed);
        cpp.fadeIn(speed > 100 ? speed - 100 : speed);
    };
    //关闭与确定点击事件
    $('#confirmPopupClose').click(function(){
        confirmClose(coy, cpp, speed);
    });
    $('#cancelConfirm').click(function(){
        confirmClose(coy, cpp, speed);
        if(typeof(cancelfn) == 'function'){
            cancelfn.call(window);
        }
    });
    scf.click(function(){
        confirmClose(coy, cpp, speed);
        if(typeof(surefn) == 'function'){
            surefn.call(window);
        }
    });
};
//关闭
function confirmClose(coy, cpp, speed){
    if(ie6 == true){
        coy.hide(speed);
        cpp.hide(speed);
    }else{
        coy.fadeOut(speed);
        cpp.fadeOut(speed);
    };
    setTimeout(function(){
        coy.remove();
        cpp.remove();
    }, speed);
}
//confirm确认信息及提示信息
function confirmInfo(){
    var newConfirm = new Confirm(),
        arg = arguments;
    switch(arg.length){
        case 1:
            newConfirm.msg = arg[0];
            break;
        case 2:
            switch(typeof(arg[1])){
                case 'function':
                    newConfirm.msg = arg[0];
                    newConfirm.surefn = arg[1];
                    break;
                case 'boolean':
                    newConfirm.msg = arg[0];
                    newConfirm.success = arg[1];
                    break;
                case 'string':
                    newConfirm.title = arg[0];
                    newConfirm.msg = arg[1];
                    break;
            };
            break;
        case 3:
            switch(typeof(arg[1])){
                case 'string':
                    var arg3 = typeof(arg[2]);
                    if(arg3 == 'boolean'){
                        newConfirm.title = arg[0];
                        newConfirm.msg = arg[1];
                        newConfirm.success = arg[2];
                    }else if(arg3 == 'function'){
                        newConfirm.title = arg[0];
                        newConfirm.msg = arg[1];
                        newConfirm.surefn = arg[2];
                    };
                    break;
                case 'function':
                    newConfirm.msg = arg[0];
                    newConfirm.surefn = arg[1];
                    newConfirm.cancelfn = arg[2];
                    break;
            }
            break;
        default:
            newConfirm.title = arg[0];
            newConfirm.msg = arg[1];
            newConfirm.surefn = arg[2];
            newConfirm.cancelfn = arg[3];
    };
    newConfirm.creatConfirm();
}
/*________________________________________(end)confirmInfo________________________________________*/


/*________________________________________(start)tipsPopup________________________________________*/
function popupTips(){
    var arg = arguments,
        txt = '',
        speed = 300,
        zIndex = 9200,
        time = 2000;
    if(arg.length == 1 && typeof(arg[0]) == 'string'){
        txt = arg[0];
    }else if(arg.length == 2 && typeof(arg[0]) == 'string' && !isNaN(arg[1])){
        txt = arg[0];
        time = arg[1] * 1000;
    };
    if($('div.tips_popup').length >= 1){
        clearTimeout(timer);
//        clearTimeout(removeTimer);
        $('#tipsPopup').text(txt);
        var timer = setTimeout(tipRemove, time);
    }else{
        var tipsStr = '<div class="tips_popup" id="tipsPopup">'+txt+'</div>';
        $(tipsStr).appendTo($('body'));
        var tpp = $('#tipsPopup');
        if(ie6 == true){
            tpp.css('position', 'absolute');
        };
        tpp.css({
            left : (parseInt($(window).width()) - parseInt(tpp.width()) - 60) / 2,
            top : (parseInt($(window).height()) - parseInt(tpp.height()) - 20) / 2,
            zIndex : zIndex
        });
        tpp.fadeIn(speed);
        var timer = setTimeout(tipRemove, time);
    };
    function tipRemove(){
        var tsp = $('#tipsPopup');
        tsp.fadeOut(speed);
        var removeTimer = setTimeout(function(){tsp.remove()}, speed);
    }
}
/*________________________________________(end)tipsPopup________________________________________*/

/*________________________________________(start)popinfo________________________________________*/
function popinfo( title, receiveId, content , basePath , url){
    if(typeof(title) == 'string' && typeof(content) == 'string'){
        var pi = $('div.popinfo'), pil, arr = [];
        if(pi[0]){
            pi.each(function(i){
                arr.push(parseInt(pi.eq(i).attr('id').substring(7)));
            });
            arr.sort(function(a,b){return a>b?1:-1});
            for(var i=0; i<arr.length ; i++){
                pil = i + 1;
                if(arr[i] != i){
                    pil = i;
                    break;
                };
            }
        }else{
            pil = 0;
        };
        //console.log(arr);
        var str = '<div class="popinfo" id="popinfo' + pil + '"><table><tr><td class="icon"><span></span></td><td class="content"><h3><a href="'+ basePath + url +'" onclick="changeState(\''+receiveId+'\')" target="_blank">' + title + '</a></h3><p>' + content + '</p></td></tr></table><a class="popinfo_close" id="popinfoClose'+pil+'">×</a></div>';
        $(str).appendTo($('body'));
        var pid = $('#popinfo' + pil), picd = $('#popinfoClose' + pil);
        pid.css({
            'bottom' : parseInt(pid.prev('div.popinfo').height()) + parseInt(pid.prev('div.popinfo').css('bottom')) + 2 + 15,
            'right' : -(parseInt(pid.width()) + 2 + 20),
            'display' : 'block'
        });
        pid.animate({'right' : 15}, 500, 'easeInCubic');
        picd.click(function(){
            pid.animate({'right' : -(parseInt(pid.width()) + 2 + 20)}, 500, 'easeOutCubic');
            pid.nextAll('div.popinfo').each(function(i){
                $(this).animate({'bottom' : parseInt($(this).css('bottom')) - parseInt(pid.css('height')) - 2 - 15}, 500, 'easeOutCubic');
            });
            setTimeout(function(){pid.remove()}, 500);
        });
    }
}
/*________________________________________(end)popinfo________________________________________*/


//浏览器窗口改变时，更改iframe弹出框、confirm确认弹出框、tips提示信息弹出框等位置为居中，及他们的遮罩大小适应窗口
$(window).resize(function(){
    var wWidth = parseInt($(window).width()),
        wHeight = parseInt($(window).height()),
        dHeight = parseInt($(document).height());
    //iframe弹出样式更改
    $('div.dialog_overlay').each(function(i){
        $('div.dialog_overlay').eq(i).css({
            width : wWidth,
            height :dHeight
        });
        var dlg = $('div.dialog_popup').eq(i);
        dlg.css({
            left : (wWidth -  parseInt(dlg.width())) / 2,
            top : (wHeight - parseInt(dlg.height())) / 2
        });
    });
    //confirm弹出样式更改
    $('#confirmOverlay').css({
        width : wWidth,
        height : dHeight
    });
    var cmp = $('#confirmPopup');
    cmp.css({
        left : (wWidth -  parseInt(cmp.width())) / 2,
        top : (wHeight - parseInt(cmp.height())) / 2
    });
    //tips弹出框样式更改
    var tpp = $('#tipsPopup');
    tpp.css({
        left : (wWidth - parseInt(tpp.width()) - 60) / 2,
        top : (wHeight - parseInt(tpp.height()) - 20) / 2
    });
});


/*________________________________________(start)scroll________________________________________*/
function scrollTop(){//滚动到顶部
    $('body,html').animate({scrollTop:0},1000);
}
function scrollBottom(){//滚动到底部
    $('body,html').animate({scrollTop:$(document).height()},1000);
}
function scrollPos(eleId){//滚动到指定位置
    $("html,body").stop(true);
    $("html,body").animate({scrollTop: $("#" + eleId).offset().top}, 600);
}
function clickToTop(eleId){//点击滚动到顶部
    var backtop = $('#' + eleId);
    backtop.hide();
    $(window).scroll(function(){
        if(parseInt($(window).scrollTop()) < 100){
            backtop.fadeOut(1000);
        }else{
            backtop.fadeIn(1000);
        };
    });
    backtop.click(function(){
        scrollTop();
    });
}
/*________________________________________(end)scroll________________________________________*/


/*________________________________________(start)jquery.easing.1.3.js________________________________________*/
jQuery.easing['jswing'] = jQuery.easing['swing'];
jQuery.extend( jQuery.easing,
    {
        def: 'easeOutQuad',
        swing: function (x, t, b, c, d) {
            //alert(jQuery.easing.default);
            return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
        },
        easeInQuad: function (x, t, b, c, d) {
            return c*(t/=d)*t + b;
        },
        easeOutQuad: function (x, t, b, c, d) {
            return -c *(t/=d)*(t-2) + b;
        },
        easeInOutQuad: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t + b;
            return -c/2 * ((--t)*(t-2) - 1) + b;
        },
        easeInCubic: function (x, t, b, c, d) {
            return c*(t/=d)*t*t + b;
        },
        easeOutCubic: function (x, t, b, c, d) {
            return c*((t=t/d-1)*t*t + 1) + b;
        },
        easeInOutCubic: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t + b;
            return c/2*((t-=2)*t*t + 2) + b;
        },
        easeInQuart: function (x, t, b, c, d) {
            return c*(t/=d)*t*t*t + b;
        },
        easeOutQuart: function (x, t, b, c, d) {
            return -c * ((t=t/d-1)*t*t*t - 1) + b;
        },
        easeInOutQuart: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
            return -c/2 * ((t-=2)*t*t*t - 2) + b;
        },
        easeInQuint: function (x, t, b, c, d) {
            return c*(t/=d)*t*t*t*t + b;
        },
        easeOutQuint: function (x, t, b, c, d) {
            return c*((t=t/d-1)*t*t*t*t + 1) + b;
        },
        easeInOutQuint: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
            return c/2*((t-=2)*t*t*t*t + 2) + b;
        },
        easeInSine: function (x, t, b, c, d) {
            return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
        },
        easeOutSine: function (x, t, b, c, d) {
            return c * Math.sin(t/d * (Math.PI/2)) + b;
        },
        easeInOutSine: function (x, t, b, c, d) {
            return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
        },
        easeInExpo: function (x, t, b, c, d) {
            return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
        },
        easeOutExpo: function (x, t, b, c, d) {
            return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
        },
        easeInOutExpo: function (x, t, b, c, d) {
            if (t==0) return b;
            if (t==d) return b+c;
            if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
            return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
        },
        easeInCirc: function (x, t, b, c, d) {
            return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
        },
        easeOutCirc: function (x, t, b, c, d) {
            return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
        },
        easeInOutCirc: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
            return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
        },
        easeInElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
        },
        easeOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
        },
        easeInOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
            return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
        },
        easeInBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c*(t/=d)*t*((s+1)*t - s) + b;
        },
        easeOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
        },
        easeInOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
            return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
        },
        easeInBounce: function (x, t, b, c, d) {
            return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
        },
        easeOutBounce: function (x, t, b, c, d) {
            if ((t/=d) < (1/2.75)) {
                return c*(7.5625*t*t) + b;
            } else if (t < (2/2.75)) {
                return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
            } else if (t < (2.5/2.75)) {
                return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
            } else {
                return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
            }
        },
        easeInOutBounce: function (x, t, b, c, d) {
            if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
            return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
        }
    });
/*________________________________________(end)jquery.easing.1.3.js________________________________________*/

function openConfirm(msg) {
    return confirm(msg);
}