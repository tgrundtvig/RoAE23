package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class RoundClickerHoleTest
{
	public Geometry3D getHole(JavaCSG csg, double unit)
	{
		double delta = 0.1;
		List<Vector2D> vertices = new ArrayList<>();
		vertices.add(csg.vector2D(0, 0));
		vertices.add(csg.vector2D(4*unit+delta, 0));
		vertices.add(csg.vector2D(4*unit+delta, 1*unit));
		vertices.add(csg.vector2D(3*unit+delta, 2*unit));
		vertices.add(csg.vector2D(3*unit+delta, 3*unit));
		vertices.add(csg.vector2D(4*unit+delta, 4*unit));
		vertices.add(csg.vector2D(4*unit+delta, 5*unit));
		vertices.add(csg.vector2D(0, 5*unit));
		Geometry2D half = csg.polygon2D(vertices);
		Geometry3D full3D = csg.rotateExtrude(csg.degrees(360), 128, half);
		return full3D;
	}

	public static void main(String[] args)
	{
		double unit = 1.0;
		JavaCSG csg = JavaCSGFactory.createDefault();
		Geometry3D plate = csg.box3D(10*unit, 10*unit, 5*unit, false);
		Geometry3D hole = new RoundClickerHoleTest().getHole(csg, unit);
		Geometry3D result = csg.difference3D(plate, hole);
		csg.view(result);
	}

}
