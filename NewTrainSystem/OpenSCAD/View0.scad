union()
{
    difference()
    {
        translate([0.0, 5.0, 0.0])
        {
            linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
            {
                scale([10.0, 10.0])
                {
                    M196();
                }
            }
        }
        union()
        {
            linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
            {
                union()
                {
                    M209();
                    mirror([1.0, 0.0])
                    {
                        M209();
                    }
                }
            }
            translate([0.0, 5.0, 0.0])
            {
                linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                {
                    union()
                    {
                        M209();
                        mirror([1.0, 0.0])
                        {
                            M209();
                        }
                    }
                }
            }
        }
    }
    translate([0.0, 0.0, 4.0])
    {
        linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
        {
            union()
            {
                M204();
                mirror([1.0, 0.0])
                {
                    M204();
                }
            }
        }
    }
}

module M209()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [4.0, 0.0], 
            [4.0, 1.0], 
            [3.0, 2.0], 
            [3.0, 3.0], 
            [4.0, 4.0], 
            [4.0, 5.0], 
            [0.0, 5.0]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7]
        ]
    );
}

module M196()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}

module M204()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [4.0, 0.0], 
            [4.0, 1.0], 
            [3.0, 2.0], 
            [3.0, 8.0], 
            [4.0, 9.0], 
            [3.0, 10.0], 
            [1.0, 10.0], 
            [1.0, 2.0], 
            [0.0, 2.0]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        ]
    );
}
