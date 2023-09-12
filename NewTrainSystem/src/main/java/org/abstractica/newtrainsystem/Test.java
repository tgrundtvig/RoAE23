package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();
		Geometry3D clicker = new ClickerTest().getClicker(csg);
		Geometry3D hole1 = new ClickerHoleTest().getHole(csg);
		Geometry3D hole2 = csg.translate3DY(5).transform(hole1);
		Geometry3D hole = csg.union3D(hole1, hole2);
		Geometry3D box = csg.box3D(10, 10, 3, false);
		box = csg.translate3DY(5).transform(box);
		Geometry3D result = csg.difference3D(box, hole);
		clicker = csg.translate3DZ(4).transform(clicker);
		result = csg.union3D(result, clicker);
		csg.view(result);

	}
}
