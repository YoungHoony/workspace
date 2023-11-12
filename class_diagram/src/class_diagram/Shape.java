package class_diagram;

public abstract class Shape {
	public void draw() {}
	public void erase() {}
	public int getLength() {
		return 0;
	}
	protected abstract double getArea();
	

}
