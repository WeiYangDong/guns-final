/**
 * 物品归置管理初始化
 */
var Goods = {
    id: "GoodsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Goods.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '物品名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '位置标识', field: 'position', visible: true, align: 'center', valign: 'middle'},
            {title: '图片标识', field: 'img', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(1：启用  2：删除）', field: 'suatus', visible: true, align: 'center', valign: 'middle'},
            {title: '创建者', field: 'createBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '修改者', field: 'modifyBy', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifyDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Goods.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Goods.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加物品归置
 */
Goods.openAddGoods = function () {
    var index = layer.open({
        type: 2,
        title: '添加物品归置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/goods/goods_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看物品归置详情
 */
Goods.openGoodsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '物品归置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/goods/goods_update/' + Goods.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除物品归置
 */
Goods.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/goods/delete", function (data) {
            Feng.success("删除成功!");
            Goods.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("goodsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询物品归置列表
 */
Goods.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Goods.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Goods.initColumn();
    var table = new BSTable(Goods.id, "/goods/list", defaultColunms);
    table.setPaginationType("client");
    Goods.table = table.init();
});
