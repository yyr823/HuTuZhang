package entity;

/**
 * ���������
 * 
 * @author Administrator
 *
 */
public class Category {
	// ����
	private int id;
	// �����������
	private String name;
	// �������Ѵ���
	private int recordNumber;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

}
