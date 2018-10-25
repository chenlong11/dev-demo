/*
    分页方法
 */
function paging(options) {
    //loading($("#" + options["id"]));
    //默认参数
    var defaults = {"curr": 1, "class": "display_form common_list_table", "style": ""};
    //获取调用控件ID
    var opts = $.extend({}, defaults, options);
    opts["table_id"] = opts["id"] + "_layer_table";
    opts["page_id"] = opts["id"] + "_layer_page";
    //删除页面已存在的容器
    $("#" + opts["table_id"]).remove();
    $("#" + opts["page_id"]).remove();
    //追加table容器
    $("#" + opts["id"]).append('<table class="' + opts["class"] + '" style="' + opts["style"] + '" id="' + opts["table_id"] + '"></table>');
    //追加分页容器
    $("#" + opts["table_id"]).after('<div id="' + opts["page_id"] + '"></div>');
    //追加th
    if (("columns" in options) && options.columns.length > 0) {
        var $tr = $("<tr class='title'></tr>");
        $.each(options.columns, function (i, item) {
            var $th = $("<td></td>");
            //标题
            if ("title" in item) {
                $th.html(item["title"]);
            }

            //样式
            if ("class" in item) {
                $th.addClass(item["class"]);
            }

            //宽度
            if ("width" in item) {
                $th.attr("width", item["width"]);
            }

            $tr.append($th);
        });
        $("#" + opts["table_id"]).append($tr);
    }
    //调用异步分页
    asynchronous_page(opts);
}

function asynchronous_page(opts) {
    var param = $.extend({}, {curPage: opts.curr || 1, pageSize: opts.pageSize}, opts.param || {});
    $.post(opts.url, param, function (res) {
        //清空上一页数据
        $("#" + opts["table_id"]).find("tr:gt(0)").remove();
        //分页内容组装
        if (("data" in res) && res.data.list.length > 0) {
            //console.log('res.data.list ', res.data.list);
            $.each(res.data.list, function (i, data) {
                var $tr = $("<tr></tr>");
                $.each(opts.columns, function (j, item) {
                    var $td = $("<td></td>");
                    if ("class" in item) {//td class
                        $td.addClass(item["class"])
                    }
                    if ("customize" in item) {//自定义td内容
                        var index = ((opts["curr"] - 1) * opts.pageSize) + i + 1;
                        $td.html(item.customize(index, data));
                    } else {
                        if ("field" in item) {
                            if (item.field == '_index') {
                                var index = ((opts["curr"] - 1) * opts.pageSize) + i + 1;
                                $td.text(index);
                            } else {
                                $td.text(data[item.field]);
                            }
                        }
                    }
                    $tr.append($td);
                });
                $("#" + opts["table_id"]).append($tr);
            });
        } else {
            var $tr = $('<tr><td style="text-align: center;" colspan="' + opts.columns.length + '"><div class="serzw">暂无数据</div></td></tr>');
            $("#" + opts["table_id"]).append($tr);
        }

        $("#" + opts["table_id"]).append($tr);

        //显示分页
        laypage({
            cont: opts["page_id"], //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
            pages: res.data.lastPage, //通过后台拿到的总页数
            curr: opts.curr || 1, //当前页
            skip: true,
            jump: function (obj, first) { //触发分页后的回调
                if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                    opts["curr"] = obj.curr;
                    asynchronous_page(opts);
                }
            }
        });
        //loaded($("#" + opts.id));
    }, 'json');
}

//操作成功弹出框
function sucessMsg(fun) {
    fun = fun || function () {
        return false;
    };
    top.layer.confirm('操作成功', {
        icon: 1 ,
        btn: ['确认']
    }, function () {
        layer.close(layer.index);
        fun();
    });
}

//操作失败弹出框
function errMsg(title, fun) {
    title = title || '操作失败';
    fun = fun || function () {
        return false;
    };
    top.layer.confirm(title, {
        icon: 2 ,
        btn: ['确认']
    }, function () {
        layer.close(layer.index);
        fun();
    });
}

function openMsg(title, fun) {
    title = title || '';
    fun = fun || function () {
        return false;
    };
    top.layer.confirm(title, {
        icon: 0 ,
        btn: ['确认', '取消']
    }, function () {
        layer.close(layer.index);
        fun();
    });
}

//关闭所有弹出层
function closeAllDialog() {
    top.layer.closeAll();
}


/*
    表单序列化
 */
$.fn.serializeObject = function () {
    var obj = {};
    var ary = this.serializeArray();
    $.each(ary, function () {
        if (obj[this.name]) {
            if (!obj[this.name].push) {
                obj[this.name] = [obj[this.name]];
            }
            obj[this.name].push(this.value || '');
        } else {
            obj[this.name] = this.value || '';
        }
    });
    return obj;
};

/*
    加载基础多级树
 */
function initTree(opt, rootId, lv) {

    var conf = {
        leafClick: false,//叶子节点是否可点击
        params: {}
    };
    $.extend(conf, opt);

    var tree = {
        createTree: function (list, opt, rootId, lv) {

            rootId = rootId || '-1';
            lv = lv || '0';
            var rootLv = parseInt(lv) - 1;
            if (rootLv < 0) {
                rootLv = 0;
            }

            //初始化树容器
            if (!opt['initContainer']) {
                $('#' + opt.id + ' #' + opt.id).html("");
                $div = $('<div class="ntt_title"><span></span><a>' + opt.title + '</a></div>' +
                    '<div class="three_tree" id="' + rootId + '" lv = "' + rootLv + '"></div>')
                $div.children('a').click(function () {
                    opt.clickFun(rootId, rootLv);
                })
                $('#' + opt.id).html($div);
                //初始化列表方法
                if (!opt.curNodeId) {
                    opt.clickFun(rootId, rootLv);
                }
                opt['initContainer'] = true;
            }

            if (list) {
                var $ul = $('<ul></ul>');
                //不是第一层，则折叠
                if (!$('#' + opt.id + ' #' + rootId).hasClass('three_tree')) {
                    $ul.css('display', 'none');
                }
                $('#' + opt.id + ' #' + rootId).append($ul);
                list.forEach(function (item) {
                    var node = {id: item['id'], name: item[opt.nodeName], pid: rootId};
                    tree.addNode(node);
                    if (item.children) {
                        tree.createTree(item.children, opt, item.id, lv);
                    }
                })
            }
        },
        addNode: function (node) {
            tree.removeNode(node.id);
            $pnode = $('#' + opt.id + ' #' + node.pid);

            var lv = parseInt($pnode.attr('lv') || 0) + 1;
            var $li = $('<li id="' + node.id + '" lv = "' + lv + '"><span></span><a>' + node.name + '</a>');

            if (lv == opt.maxLv) {//如果达到最大级别 转换样式
                $li.children('span:first').addClass('last');
                if (opt.leafClick) {
                    $li.children('a').click(function () {
                        opt.clickFun(node.id, lv);
                    })
                    $li.children('a:first').css('cursor', 'pointer');
                } else {
                    $li.children('a:first').css('cursor', 'default');
                }
            } else {//非最大级别，添加点击事件
                $li.children('a').click(function () {
                    opt.clickFun(node.id, lv);
                })
            }
            //如果没有ul 则追加
            if ($pnode.find('ul').length == 0) {
                $pnode.append('<ul></ul>');
            }
            $pnode.children('ul:first').append($li);
        },
        removeNode: function (nodeId) {
            $('#' + opt.id + ' #' + nodeId).remove();
        },
        initEvent: function () {
            //防止重复绑定
            $(document).off('click', 'div .three_tree li');
            $(document).off('click', 'div .three_tree a ');
            $(document).off('click', 'div .ntt_title a');

            //树加载
            $(document).on('click', 'div .three_tree li', function (event) {
                //添加样式
                $(this).toggleClass('cur');
                $(this).children('ul:first').toggle();
                //阻止冒泡
                event.stopPropagation();

            });

            $(document).on('click', 'div .three_tree a ', function (event) {
                if (!$(this).parent().children('span').hasClass('last')) {
                    //移除cur样式
                    $('div .three_tree a.focus').removeClass('focus');
                    //添加样式
                    $(this).addClass('focus');
                    //阻止冒泡
                    event.stopPropagation();
                }
            });

            $(document).on('click', 'div .ntt_title a', function (event) {
                //移除cur样式
                $('div .three_tree a.focus').removeClass('focus');
                //阻止冒泡
                event.stopPropagation();
            });
        },
        selectedNode: function (nodeId) {
            nodeId = nodeId || '';
            this.extendPNode($('#' + nodeId));

            if ($('#' + nodeId + ' a').length > 0) {
                $('#' + nodeId + ' a:first').trigger('click');
            }
        },
        extendPNode: function ($node) {
            if ($node.parents('ul:first').length > 0) {
                $node.parents('ul:first').show();
                this.extendPNode($node.parents('ul:first'));
            }
        }
    };

    $.post(opt.url, opt.params, function (res) {

        if (res.status != 10000) {
            return;
        }

        tree.createTree(res.data, opt, rootId, lv);
        tree.initEvent();
        if (opt.curNodeId) {
            tree.selectedNode(opt.curNodeId);
        }
    }, 'json');

    return tree;
}

/**
 * 加载checkBox树
 * @param opt
 * @param rootId
 * @param lv
 */
function initCheckBoxTree(opt, rootId, lv) {
    var tree = {
        createTree: function (list) {

        }
    }
}

/**
 * 打开弹出框
 * @param obj
 */
function openDialog(obj) {
    var dialogIndex;
    var random = Math.random();

    if (!obj.url) {
        console.log(' url 不能为空 ');
        return;
    }

    console.info('open dialog url is :', obj.url);

    obj.params = obj.params || {};
    obj.params['random'] = random;
    $.ajax({
        type: 'get',
        url: obj.url,
        data: obj.params,
        async: false,
        success: function (data) {
            layerOpen(data, obj);
        }
    });

    return dialogIndex;

}

function layerOpen(data, conf) {
    conf = conf || {};
    var default_conf = {
        type: 1,
        title: " ",
        area: ['60%', '70%'],
        btn: ['关闭'],
        move: false,
        maxmin: true,
        scrollbar: false,
        content: data
    };
    $.extend(default_conf, conf);
    dialogIndex = top.layer.open(default_conf);
}

/**
 * 密码加密
 */
function crypPwd(pwd) {
    var key = CryptoJS.enc.Utf8.parse('6543210987654321');
    var iv = CryptoJS.enc.Utf8.parse('1234567890123456');
    return CryptoJS.AES.encrypt(pwd, key, {iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7});
}

function createEditor(id, val, conf) {
    var editor;
    conf = conf || {};
    var default_conf = {
        width: '95%',
        height: '300px',
        allowFileUpload: true,
        uploadJson: ctx + "/admin/attachment/uploadEditorImg",
        afterBlur: function () {
            this.sync();
        },
        filterMode: false,
        items: [
            'fontname', 'fontsize', 'lineheight', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'emoticons', 'image', 'link'
        ]
    };
    $.extend(default_conf, conf);

    editor = KindEditor.create('textarea[id=' + id + ']', default_conf);
    if (val) {
        editor.html(val);
    }
    return editor;
}

function createUploader(id, businessId, conf) {
    showAtts(id, businessId);
    $('#' + id).append('<div id="file' + id + '">附件上传</div>');
    //多个上传控件公用一个uploadParam
    if ($('#uploadParam').length <= 0) {
        $('#' + id).append('<input type="hidden" name="uploadParam" id="uploadParam" value=""/>');
    }

    conf = conf || {};
    //是否可上传多个附件
    var multiple = false;
    if (conf.multiple) {
        multiple = true;
    }

    var extensions = 'xls,xlsx,ppt,pptx,doc,docx,txt,pdf,7z,rar,zip,gif,jpg,jpeg,png,vsd,mpp';
    var defalt_conf = {
        attType: '',
        swf: ctx + '/static/plugins/webupload/Uploader.swf',
        server: ctx + '/admin/attachment/uploadFile',
        pick: {
            id: "#file" + id,
            multiple: multiple
        },
        accept: {
            extensions: extensions
        },
        fileSizeLimit: 52428800, //总文件大小限制
        auto: true,//是否自动上传
        resize: false, // 不压缩image
        chunked: true,	// 开启分片上传
        duplicate: true //是否可以重复上传
    };
    $.extend(defalt_conf, conf);

    var uploader = WebUploader.create(defalt_conf)

    uploader.on('fileQueued', function (file) {
        //是否上传多个文件
        if (!defalt_conf.multiple) {
            $('#fileList' + id + ' li').remove();
        }
        var $li = $('<li id="' + file.id + '">' +
            '<span><a target="_blank">' + file.name + '</a></span>' +
            '<div class="slide" style="width:100px;" ><div class="progress slidecon"></div></div>' +
            '&nbsp;&nbsp;<a class="file_del blue_txt">删除</a>' +
            '</li>');
        $('#fileList' + id).append($li);
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        $("#" + file.id).find(".progress").width(percentage * 100);
    });

    //上传成功，回显地址和文件名
    uploader.on('uploadSuccess', function (file, res) {
        if (res.status != 10000) {
            $("#" + file.id).find("a:last").after('&nbsp;&nbsp;<span>上传出错</span>');
        } else {
            $input = $('<input type="hidden" name="attName" value="' + res.data.attName + '" />' +
                '<input type="hidden" name="attPath" value="' + res.data.attPath + '" />' +
                '<input type="hidden" name="attExt" value="' + res.data.attExt + '" />' +
                '<input type="hidden" name="attSize" value="' + res.data.attSize + '" />' +
                '<input type="hidden" name="attType" value="' + defalt_conf.attType + '" />');
            $("#" + file.id).append($input);
            $("#" + file.id + " a").prop('href', ctx + res.data.attPath);
        }
    });

    //上传错误
    uploader.on('uploadError', function (file, reason) {
        $("#" + file.id).find("a:last").after('&nbsp;&nbsp;<span>上传出错</span>');
    });

    //无论上传是否成功 ，取消进度条显示
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').parent().fadeOut();
    });

    //通用错误
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').parent().fadeOut();
    });

    //删除文件
    $('.file_list').on('click', '.file_del', function () {
        var $parent = $(this).parent();
        //如果文件上传中，从上传队列中移除
        if ($parent.find("input[name=filePath]").lenght <= 0) {
            uploader.removeFile($parent.attr("id"), true);
        }
        $parent.remove();
    });
}

/**
 * 显示附件列表
 */
function showAtts(id, businessId) {
    $('#' + id).append('<ul id="fileList' + id + '" class="file_list">');
    if (businessId) {
        var url = '/admin/attachment/list';
        $.post(ctx + url, {businessId: businessId}, function (res) {
            if (!res.data) {
                return;
            }
            res.data.forEach(function (t) {
                addLi(t);
            })
        }, 'json');
    }

    function addLi(data) {
        var $li = $('<li>' +
            '<span><a target="_blank" href="' + ctx + data.attPath + '">' + data.attName + '</a></span>' +
            '&nbsp;&nbsp;<a class="file_del blue_txt">删除</a>' +
            '<input type="hidden" name="attName" value="' + data.attName + '" />' +
            '<input type="hidden" name="attPath" value="' + data.attPath + '" />' +
            '<input type="hidden" name="attExt" value="' + data.attExt + '" />' +
            '<input type="hidden" name="attSize" value="' + data.attSize + '" />' +
            '<input type="hidden" name="attType" value="' + data.attType + '" />' +
            '</li>');
        $('#fileList' + id).append($li);
    }

}

function freshUploadParam() {
    var att_ary = [];
    $(".file_list li").each(function (i) {
        var att_obj = {};
        att_obj["attName"] = $(this).find("input[name=attName]").val();
        att_obj["attPath"] = $(this).find("input[name=attPath]").val();
        att_obj["attExt"] = $(this).find("input[name=attExt]").val();
        att_obj["attSize"] = $(this).find("input[name=attSize]").val();
        att_obj["attType"] = $(this).find("input[name=attType]").val();
        att_ary.push(att_obj);
    })
    $('#uploadParam').val(JSON.stringify(att_ary));
}

function createDatePicker(id, formar, callBackFun) {
    $('#' + id).on('click', function () {
        var conf = {el: this};
        var format = formar || 'yyyy-MM-dd';
        if (format) {
            conf['dateFmt'] = format;
        }
        if (callBackFun) {
            conf['onpicked'] = function (dp) {
                callBackFun($(this).val());
            }
        }
        WdatePicker(conf);
    })
}

/**
 * 树形选择器
 */
function getTreeSelector(conf) {
    var treeSelector = {
        conf: {
            _this:this,
            url: '',
            params: {},
            nodeName: 'name',
            btn: ['确定','关闭'],
            yes: function (index, layero) {
                var ary = _this.getSelectData();
                _this.callBackFun(ary);
                //关闭弹出框
                layer.close(index);
            }
        },
        callBackFun: function (ary) {
        } ,
        setConf: function (conf) {
            conf = conf || {};
            if(conf.url){
                this.conf.url = conf.url;
            }
            if(conf.params){
                this.conf.params = conf.params;
            }
            if(conf.nodeName){
                this.conf.nodeName = conf.nodeName;
            }
            if(conf.callbackFun){
                this.callBackFun = conf.callbackFun;
            }
        },
        createTree: function (conf) {
            if (!this.conf.url) {
                console.log('url can not be empty');
                return;
            }
            _this = this;
            $.post(this.conf.url,this.conf.params,function (res) {
                if(res.status == 10000) {
                    var $div = _this.createContainer();
                    var $root = $div.find('.tree_selector:first');
                    if (res.data) {
                        for (var i = 0; i < res.data.length; i++) {
                            res.data[i]['lv'] = 1;
                            _this.addNode($root, res.data[i]);
                        }
                    }
                    _this.initEvent();
                    layerOpen($div.html(),_this.conf);
                }
            },'json');
        },
        createContainer: function () {
            var $div =
                $('<div class="choose">' +
                    '<div class="chooseLeft">' +
                        '<div class="choose-ser">' +
                            '<input type="text" class="choose-serInput" /><input type="button" value="" class="choose-serBtn" />' +
                        '</div>' +
                        '<div class="chooseTree">' +
                            '<div class="tree_selector" id="-1" pid="">' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                    '<div class="chooseRight" id="right">' +
                        '<h2>已选列表</h2>' +
                        '<div class="zw">请从左侧选择人员</div>' +
                    '</div>' +
                '</div>');
            return $div;
        },
        addNode: function ($pnode, node) {
            node['isParent'] = node.isParent || false;
            if ($pnode.find('ul').length <= 0) {
                $pnode.append('<ul></ul>');
            }
            //默认隐藏第一层以外的所有节点
            if(node.lv > 1){
                $pnode.find('ul').hide()
            }

            $pnode = $pnode.find('ul:first');

            var $node;
            if (node.isParent) {
                $node = $('<li id = "' + node.id + '" pid = "' + node.pid + '" class="folder"><em></em><span></span>' + node[this.conf.nodeName] + '</li>')
                $pnode.append($node);

                if(!node.children){
                    return;
                }

                for (var i = 0; i < node.children.length; i++) {
                    node.children[i]['lv'] = parseInt(node.lv) + 1;
                    this.addNode($node, node.children[i]);
                }
            } else {
                $node = $('<li id = "' + node.id + '" pid = "' + node.pid + '" class="leaf"><em class="last"></em><span class="last"></span><a>' + node[this.conf.nodeName] + '</a></li>');
                $pnode.append($node);
            }
        },
        appendToRight: function(id,name) {
            $('.chooseRight .zw').hide();
            // for(var i =0;i<30;i++){
                var $p = $('<p id="selected'+id+'"><span><a class="del">删除</a></span><a></a>' + name + '</p>');
                $(".chooseRight#right").append($p);
            // }

        },
        removeFromRight: function(id,name) {
            $('#selected' + id).closest('p').remove();
        },
        initEvent: function(){
            var _this = this;
            $(document).off('click', '.tree_selector .folder');
            $(document).off('click', '.tree_selector .leaf');
            $(document).off('mouseover', '.chooseRight p');
            $(document).off('mouseout', '.chooseRight p');
            $(document).off('click', '.chooseRight p .del');
            $(document).off('click', '.choose-serBtn');

            $(document).on('click','.tree_selector .folder',function(event) {
                if($(this).find('ul:first').is(':hidden')){
                    $(this).find('ul:first').show();
                    $(this).addClass('cur');
                }else{
                    $(this).find('ul:first').hide();
                    $(this).removeClass('cur');
                }
                event.stopPropagation();
            });

            $(document).on('click','.tree_selector .leaf',function(event) {
                if($(this).find('a').hasClass('already')){
                    $(this).find('span').removeClass("last2");
                    $(this).find('a').removeClass("already");
                    _this.removeFromRight($(this).prop('id'));
                } else {
                    $(this).find('span').addClass("last2");
                    $(this).find('a').addClass("already");
                    _this.appendToRight($(this).prop('id'), $(this).find('a').text());
                }
                event.stopPropagation();
            });

            $(document).on('mouseover','.chooseRight p',function(event) {
                $(this).addClass("cur");
            });

            $(document).on('mouseout','.chooseRight p',function(event) {
                $(this).removeClass("cur");
            });

            $(document).on('click','.chooseRight p .del',function(event) {
                var id = $(this).closest('p').prop('id');
                id = id.substring(8);
                $('.tree_selector #' + id +' span').removeClass("last2");
                $('.tree_selector #' + id +' a').removeClass("already");
                $(this).closest('p').remove();
            });

            $(document).on('click','.choose-serBtn',function(event) {
                var text = $.trim($('.choose-serInput').val());
                if(text){
                    _this.search(text);
                }else{
                    _this.refreshTree(text);
                }

            });
        },
        expendPNode: function(id) {
            var pid = $('.tree_selector #' + id).attr('pid');
            if($('.tree_selector #' + pid).length > 0 ) {
                $('.tree_selector #' + pid).show();
                $('.tree_selector #' + pid + ' ul').show();
                $('.tree_selector #' + pid).addClass('cur');
                var fpid = $('.tree_selector #' + pid).attr('pid');
                if($('.tree_selector #' + fpid).length > 0 ){
                    this.expendPNode(pid);
                }
            }
        },
        search: function(text) {
            var _this = this;
            $('.tree_selector li').hide();
            $('.leaf').each(function () {
                if($(this).text().indexOf(text)>=0) {
                    $(this).show();
                    _this.expendPNode($(this).prop('id'));
                }
            })
        },
        refreshTree: function () {
            $('.tree_selector ul').hide();
            $('.tree_selector li').show();
            $('.tree_selector ul:first').show();
        },
        getSelectData: function(){
            var ary = [];
            $('.chooseRight p').each(function () {
                var id = $(this).closest('p').prop('id');
                id = id.substring(8);
                var name = $(this).text().substring(2);
                ary.push({'id':id,'name':name});
            });
            return ary;
        }
    }
    treeSelector.setConf(conf);
    treeSelector.createTree(conf);
}


