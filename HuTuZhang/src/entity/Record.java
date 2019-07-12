package entity;

import java.util.Date;

/**
 * 消费记录类
 * 
 * @author Administrator
 *
 */

public class Record {
	// 主键
	private int id;
	// 消费金额
	private int spend;
	// 分类信息id
	private int cid;
	// 消费备注
	private String comment;
	// 日期
	private Date date;

	public Record() {
	}

	public Record(int id, int spend, int cid, String comment, Date date) {
		this.id = id;
		this.spend = spend;
		this.cid = cid;
		this.comment = comment;
		this.date = date;
	}

	public Record(int spend, int cid, String comment, Date date) {
		this.spend = spend;
		this.cid = cid;
		this.comment = comment;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", spend=" + spend + ", cid=" + cid + ", comment=" + comment + ", date=" + date
				+ "]";
	}
}
