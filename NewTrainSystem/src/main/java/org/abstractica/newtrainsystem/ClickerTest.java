package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class ClickerTest
{
	public Geometry3D getClicker(JavaCSG csg)
	{
		List<Vector2D> vertices = new ArrayList<>();
		vertices.add(csg.vector2D(0, 0));
		vertices.add(csg.vector2D(4, 0));
		vertices.add(csg.vector2D(4, 1));
		vertices.add(csg.vector2D(3, 2));
		vertices.add(csg.vector2D(3, 8));
		vertices.add(csg.vector2D(4, 9));
		vertices.add(csg.vector2D(3, 10));
		vertices.add(csg.vector2D(1, 10));
		vertices.add(csg.vector2D(1, 2));
		vertices.add(csg.vector2D(0, 2));
		Geometry2D half = csg.polygon2D(vertices);
		Geometry2D full = csg.union2D(half, csg.mirror2D(1,0).transform(half));
		Geometry3D full3D = csg.linearExtrude(3, false, full);
		return full3D;
	}
}
