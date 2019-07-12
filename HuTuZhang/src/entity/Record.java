package entity;

import java.util.Date;

/**
 * ���Ѽ�¼��
 * 
 * @author Administrator
 *
 */

public class Record {
	// ����
	private int id;
	// ���ѽ��
	private int spend;
	// ������Ϣid
	private int cid;
	// ���ѱ�ע
	private String comment;
	// ����
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
