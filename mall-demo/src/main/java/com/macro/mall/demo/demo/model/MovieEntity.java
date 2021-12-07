package com.macro.mall.demo.demo.model;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;


/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-06 15:43:58
 */
@Data
@TableName("movie")
public class MovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 电影信息唯一id
	 */
	@TableId(type = IdType.AUTO)
	private String id;
	/**
	 * 电影标题
	 */
	private String title;
	/**
	 * 封面
	 */
	private String cover;
	/**
	 * 评分
	 */
	private String rate;
	/**
	 * 该电影的演员名称
	 */
	private String casts;
	/**
	 * 该电影的导演
	 */
	private String directors;

}
