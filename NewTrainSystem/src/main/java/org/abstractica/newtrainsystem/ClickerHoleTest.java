package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;

public class ClickerHoleTest
{
	public Geometry3D getHole(JavaCSG csg)
	{
		List<Vector2D> vertices = new ArrayList<>();
		vertices.add(csg.vector2D(0, 0));
		vertices.add(csg.vector2D(4, 0));
		vertices.add(csg.vector2D(4, 1));
		vertices.add(csg.vector2D(3, 2));
		vertices.add(csg.vector2D(3, 3));
		vertices.add(csg.vector2D(4, 4));
		vertices.add(csg.vector2D(4, 5));
		vertices.add(csg.vector2D(0, 5));
		Geometry2D half = csg.polygon2D(vertices);
		Geometry2D full = csg.union2D(half, csg.mirror2D(1,0).transform(half));
		Geometry3D full3D = csg.linearExtrude(3, false, full);
		return full3D;
	}

}
