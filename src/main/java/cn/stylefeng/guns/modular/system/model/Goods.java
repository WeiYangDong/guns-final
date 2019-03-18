package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 物品归置表
 * </p>
 *
 * @author WeiYangDong
 * @since 2019-03-18
 */
@TableName("hw_goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 位置标识
     */
    private String position;
    /**
     * 图片标识
     */
    private String img;
    /**
     * 状态(1：启用  2：删除）
     */
    private Integer suatus;
    /**
     * 创建者
     */
    @TableField("create_by")
    private Integer createBy;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 修改者
     */
    @TableField("modify_by")
    private Integer modifyBy;
    /**
     * 修改时间
     */
    @TableField("modify_date")
    private Date modifyDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSuatus() {
        return suatus;
    }

    public void setSuatus(Integer suatus) {
        this.suatus = suatus;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Goods{" +
        ", id=" + id +
        ", name=" + name +
        ", position=" + position +
        ", img=" + img +
        ", suatus=" + suatus +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", modifyBy=" + modifyBy +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
