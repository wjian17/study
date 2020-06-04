package org.company.forward.study.quartz.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjian
 * @ClassName: TaskInfo
 * @Description: 管理定时任务
 * @date 2018年2月26日
 */
@Data
public class TaskInfo implements Serializable {
	private static final long serialVersionUID = -8054692082716173379L;

	/**
	 * 增加或修改标识
	 */
	private int id;

	/**
	 * 任务名称
	 */
	private String jobName;

	/**
	 * 任务分组
	 */
	private String jobGroup;

	/**
	 * 任务描述
	 */
	private String jobDescription;

	/**
	 * 任务状态
	 */
	private String jobStatus;

	/**
	 * 任务表达式
	 */
	private String cronExpression;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 间隔时间（毫秒）
	 */
	private String milliSeconds;

	/**
	 * 重复次数
	 */
	private String repeatCount;

	/**
	 * 起始时间
	 */
	private String startDate;

	/**
	 * 终止时间
	 */
	private String endDate;

}