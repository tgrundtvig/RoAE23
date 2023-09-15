package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class RoundClickerTest
{
	public Geometry3D getClicker(JavaCSG csg, double unit)
	{
		double delta = 0.1;
		double tightness = 0.3;
		List<Vector2D> vertices = new ArrayList<>();
		vertices.add(csg.vector2D(0, 0));
		vertices.add(csg.vector2D(4*unit-delta, 0));
		vertices.add(csg.vector2D(4*unit-delta, 1*unit));
		vertices.add(csg.vector2D(3*unit-delta, 2*unit));
		vertices.add(csg.vector2D(3*unit-delta, (8-tightness)*unit)); //Tighten the grip
		vertices.add(csg.vector2D(4*unit-delta, (9-tightness)*unit)); //Tighten the grip
		vertices.add(csg.vector2D(3*unit-delta, 10*unit));
		vertices.add(csg.vector2D(0, 10*unit));
		vertices.add(csg.vector2D(0, 2*unit));
		Geometry2D half = csg.polygon2D(vertices);
		Geometry3D full3D = csg.rotateExtrude(csg.degrees(360), 128, half);
		Geometry3D slit = csg.box3D(10, 1.6, 10, false);
		slit = csg.translate3DZ(2).transform(slit);
		full3D = csg.difference3D(full3D, slit);
		Geometry3D sides = csg.box3D(5, 10, 10, false);
		full3D = csg.intersection3D(full3D, sides);
		full3D = csg.rotate3DY(csg.degrees(90)).transform(full3D);
		return full3D;
	}

	public static void main(String[] args)
	{
		double unit = 1.0;
		JavaCSG csg = JavaCSGFactory.createDefault();
		Geometry3D result = new RoundClickerTest().getClicker(csg, unit);
		csg.view(result);
	}
}
