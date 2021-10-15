import java.util.ArrayList;

public class Rectangles
{

	public static void main(String[] args)
	{
	   Rectangle<Integer> rect1 = new Rectangle<Integer>(5,8);
	   Rectangle<Integer> rect2 = new Rectangle<>(6,9);
	   Rectangle rect3 = new Rectangle(1,2);
	   
	   ArrayList<Rectangle<Integer>> arrList = new ArrayList<Rectangle<Integer>>();

		arrList.add(rect1);
	   
	   System.out.println(rect1.getLength() + " " + rect1.getWidth());
	   System.out.println(rect2.getLength() + " " + rect2.getWidth());
	   System.out.println(rect3.getLength() + " " + rect3.getWidth());
	   
	   System.out.println(arrList.get(0).getLength() + " " + arrList.get(0).getWidth());
	}
}