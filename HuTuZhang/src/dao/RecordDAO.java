package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Record;
import util.DBUtil;
import util.DateUtil;

public class RecordDAO {

	private static final String SQL_GET_TOTAL = "SELECT COUNT(*) FROM record";
	private static final String SQL_ADD = "INSERT INTO record VALUES(DEFAULT,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE record SET spend=?,cid=?,comment=?,date=? WHERE id=?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM record WHERE id = ?s";
	private static final String SQL_GET_BY_ID = "SELECT * FROM record WHERE id=?";
	private static final String SQL_GET_RECORD_LIMIT = "SELECT * FROM record ORDER BY id DESC LIMIT ?,?";
	private static final String SQL_GET_BY_CID = "SELECT * FROM record WHERE cid=?";
	private static final String SQL_GET_BY_DATE = "SELECT * FROM record WHERE date=?";
	private static final String SQL_START_END = "SELECT * FROM record WHERE date >= ? AND date <= ?";

	/**
	 * ���������ܴ���
	 * 
	 * @return
	 */
	public int getTotal() {
		int total = 0;

		try (Connection conn = DBUtil.getConnection(); Statement state = conn.createStatement()) {
			ResultSet rs = state.executeQuery(SQL_GET_TOTAL);
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	/**
	 * ����һ�����Ѽ�¼
	 * 
	 * @param record
	 * @return
	 */
	public boolean add(Record record) {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement prep = conn.prepareStatement(SQL_ADD, new String[] { "id" })) {
			prep.setInt(1, record.getSpend());
			prep.setInt(2, record.getCid());
			prep.setString(3, record.getComment());
			prep.setDate(4, DateUtil.util2sql(record.getDate()));
			prep.executeUpdate();
			ResultSet rs = prep.getGeneratedKeys();
			if (rs.next()) {
				record.setId(rs.getInt(1));
			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����һ�����Ѽ�¼
	 * 
	 * @param record
	 * @return
	 */
	public boolean update(Record record) {
		try (Connection conn = DBUtil.getConnection(); PreparedStatement prep = conn.prepareStatement(SQL_UPDATE)) {
			prep.setInt(1, record.getSpend());
			prep.setInt(2, record.getCid());
			prep.setString(3, record.getComment());
			prep.setDate(3, DateUtil.util2sql(record.getDate()));
			prep.setInt(5, record.getId());

			prep.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����idɾ��һ�����Ѽ�¼
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id) {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement prep = conn.prepareStatement(SQL_DELETE_BY_ID);) {
			prep.setInt(1, id);
			prep.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����id���һ�����Ѽ�¼
	 * 
	 * @param id
	 * @return
	 */
	public Record getById(int id) {
		Record record = null;
		try (Connection conn = DBUtil.getConnection(); PreparedStatement prep = conn.prepareStatement(SQL_GET_BY_ID)) {
			prep.setInt(1, id);

			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				record = new Record();
				record.setId(id);
				record.setSpend(rs.getInt("spend"));
				record.setCid(rs.getInt("cid"));
				record.setComment(rs.getString("Comment"));
				record.setDate(rs.getDate("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return record;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Record> getRecord(int start, int count) {
		List<Record> recordList = new ArrayList<Record>();
		/**
		 * ��ҳ��ѯ��ȡ���Ѽ�¼��Ϣ
		 */
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement prep = conn.prepareStatement(SQL_GET_RECORD_LIMIT)) {
			prep.setInt(1, start);
			prep.setInt(2, count);

			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Record record = new Record();
				record.setId(rs.getInt("id"));
				record.setSpend(rs.getInt("spend"));
				record.setCid(rs.getInt("cid"));
				record.setComment(rs.getString("comment"));
				record.setDate(rs.getDate("date"));
				recordList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recordList;

	}

	/**
	 * ��ȡȫ�������Ѽ�¼
	 * 
	 * @return
	 */
	public List<Record> getRecord() {
		return getRecord(0, Short.MAX_VALUE);
	}

	/**
	 * ����cid��ѯ���Ѽ�¼
	 * 
	 * @param cid
	 * @return
	 */
	public List<Record> getRecord(int cid) {
		List<Record> recordList = new ArrayList<Record>();
		/**
		 * ����cid��ѯ���Ѽ�¼
		 */

		try (Connection conn = DBUtil.getConnection(); PreparedStatement prep = conn.prepareStatement(SQL_GET_BY_CID)) {
			prep.setInt(1, cid);

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				Record record = new Record();
				record.setId(rs.getInt("id"));
				record.setSpend(rs.getInt("spend"));
				record.setCid(cid);
				record.setComment(rs.getString("comment"));
				record.setDate(rs.getDate("date"));
				recordList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * ��ȡĳһ������Ѽ�¼
	 * 
	 * @param day
	 * @return
	 */
	public List<Record> getRecord(Date day) {
		List<Record> recordList = new ArrayList<Record>();
		/**
		 * ����ʱ���ѯĳ������Ѽ�¼
		 */

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement prep = conn.prepareStatement(SQL_GET_BY_DATE)) {
			prep.setDate(1, DateUtil.util2sql(day));

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				Record record = new Record();
				record.setId(rs.getInt("id"));
				record.setSpend(rs.getInt("spend"));
				record.setCid(rs.getInt("cid"));
				record.setComment(rs.getString("comment"));
				record.setDate(day);
				recordList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recordList;
	}

	/**
	 * ��ȡĳһ��ʱ���ڵ����Ѽ�¼
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Record> getRecord(Date start, Date end) {
		List<Record> recordList = new ArrayList<Record>();
		/**
		 * ����ʱ���ѯĳ��ʱ������Ѽ�¼
		 */
		try (Connection conn = DBUtil.getConnection(); PreparedStatement prep = conn.prepareStatement(SQL_START_END)) {
			prep.setDate(1, DateUtil.util2sql(start));
			prep.setDate(2, DateUtil.util2sql(end));

			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Record record = new Record();
				record.setId(rs.getInt("id"));
				record.setSpend(rs.getInt("spend"));
				record.setCid(rs.getInt("cid"));
				record.setComment(rs.getString("comment"));
				record.setDate(rs.getDate("date"));
				recordList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * ��ȡ��������Ѽ�¼
	 * 
	 * @return
	 */
	public List<Record> getToDayRecord() {
		return getRecord(DateUtil.today());
	}

	public List<Record> getThisMonthRecord() {
		return getRecord(DateUtil.monthBegin(), DateUtil.monthEnd());
	}

}
