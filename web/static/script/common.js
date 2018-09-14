/*
    分页方法
 */
function paging(options) {
    loading($("#" + options["id"]));
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
    var param = $.extend({}, {page: opts.curr || 1, pageSize: opts.pageSize}, opts.param || {});

    $.post(opts.url, param, function (res) {
        //清空上一页数据
        $("#" + opts["table_id"]).find("tr:gt(0)").remove();
        //分页内容组装
        if (("content" in res) && res.content.length > 0) {
            $.each(res.content, function (i, data) {
                var $tr = $("<tr></tr>");
                $.each(opts.columns, function (j, item) {

                    var $td = $("<td></td>");

                    if ("class" in item) {//td class
                        $td.addClass(item["class"])
                    }
                    if ("customize" in item) {//自定义td内容
                        var index = ((opts["curr"] - 1) * opts.pageSize) + i;
                        $td.html(item.customize(index, data));
                    } else {
                        if ("field" in item) {
                            $td.text(data[item.field]);
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
            pages: res.totalPages, //通过后台拿到的总页数
            curr: opts.curr || 1, //当前页
            skip: true,
            jump: function (obj, first) { //触发分页后的回调
                if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                    opts["curr"] = obj.curr;
                    asynchronous_page(opts);
                }
            }
        });
        loaded($("#" + opts.id));
    }, 'json');
}

//操作成功弹出框
function sucessMsg(fun) {
    openMsg('操作成功',fun);
}

//操作失败弹出框
function errMsg(fun) {
    openMsg('操作失败',fun);
}

function openMsg(title,fun) {
    title = title || '';
    fun = fun || function () {
        return false;
    };
    layer.confirm(title, {
        btn: ['确认']
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
    加载多级树
 */
function initTree(opt, rootId, lv) {

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
                $('#' + opt.id).html("");
                $div = $('<div class="ntt_title"><span></span><a>' + opt.title + '</a></div>' +
                    '<div class="three_tree" id="' + rootId + '" lv = "' + rootLv + '"></div>')
                $div.children('a').click(function () {
                    opt.clickFun(rootId, rootLv);
                })
                $('#' + opt.id).html($div);
                //初始化列表方法
                if(!opt.curNodeId){
                    opt.clickFun(rootId, rootLv);
                }
                opt['initContainer'] = true;
            }

            if (list) {
                var $ul = $('<ul></ul>');
                //不是第一层，则折叠
                if (!$('#' + rootId).hasClass('three_tree')) {
                    $ul.css('display', 'none');
                }
                $('#' + rootId).append($ul);
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
            $pnode = $('#' + node.pid);
            var lv = parseInt($pnode.attr('lv') || 0) + 1;
            var $li = $('<li id="' + node.id + '" lv = "' + lv + '"><span></span><a>' + node.name + '</a>');

            if (lv == opt.maxLv) {//如果达到最大级别 转换样式
                $li.children('span:first').addClass('last');
                $li.children('a:first').css('cursor', 'default');
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
            $('#' + nodeId).remove();
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

            if($('#' + nodeId).parents('a:first').length > 0) {
                $('#' + nodeId).parents('a:first').trigger('click');
            }
        },
        extendPNode: function($node) {
            if($node.parents('ul:first').length > 0) {
                $node.parents('ul:first').show();
                this.extendPNode($node.parents('ul:first'));
            }
        }
    };


    $.post(opt.url, {}, function (list) {
        tree.createTree(list, opt, rootId, lv);
        tree.initEvent();
        if(opt.curNodeId){
            tree.selectedNode(opt.curNodeId);
        }
    }, 'json');

    return tree;
}

function openDialog(obj) {

    if(!obj.url){
        console.log(' url 不能为空 ');
        return;
    }

    obj.params = obj.params || {};

    $.get(obj.url,obj.params,function (data) {
        obj = obj || {};
        var conf = {
            type: 1,
            title:" ",
            area:['60%','70%'],
            btn:['关闭'],
            move:false,
            maxmin:true,
            scrollbar:false,
            content: data
        };
        $.extend(conf, obj);
        top.layer.open(conf);
    })
}








