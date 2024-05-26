package Question2;

public class TV {
	String name;
	int year;
	int size;

	public TV(String name, int year, int size) {
		this.name = name;
		this.year = year;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void show() {
		System.out.println(getName() + "에서 만든 " + getYear() + "년형 " + getSize() + "인치 TV");
	}
}
