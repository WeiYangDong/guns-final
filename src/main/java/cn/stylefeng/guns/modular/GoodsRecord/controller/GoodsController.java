package cn.stylefeng.guns.modular.GoodsRecord.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Goods;
import cn.stylefeng.guns.modular.GoodsRecord.service.IGoodsService;

/**
 * 物品归置控制器
 *
 * @author fengshuonan
 * @Date 2019-03-18 16:30:20
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    private String PREFIX = "/GoodsRecord/goods/";

    @Autowired
    private IGoodsService goodsService;

    /**
     * 跳转到物品归置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "goods.html";
    }

    /**
     * 跳转到添加物品归置
     */
    @RequestMapping("/goods_add")
    public String goodsAdd() {
        return PREFIX + "goods_add.html";
    }

    /**
     * 跳转到修改物品归置
     */
    @RequestMapping("/goods_update/{goodsId}")
    public String goodsUpdate(@PathVariable Integer goodsId, Model model) {
        Goods goods = goodsService.selectById(goodsId);
        model.addAttribute("item",goods);
        LogObjectHolder.me().set(goods);
        return PREFIX + "goods_edit.html";
    }

    /**
     * 获取物品归置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return goodsService.selectList(null);
    }

    /**
     * 新增物品归置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Goods goods) {
        goodsService.insert(goods);
        return SUCCESS_TIP;
    }

    /**
     * 删除物品归置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer goodsId) {
        goodsService.deleteById(goodsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改物品归置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Goods goods) {
        goodsService.updateById(goods);
        return SUCCESS_TIP;
    }

    /**
     * 物品归置详情
     */
    @RequestMapping(value = "/detail/{goodsId}")
    @ResponseBody
    public Object detail(@PathVariable("goodsId") Integer goodsId) {
        return goodsService.selectById(goodsId);
    }
}
