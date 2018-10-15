        //If the rectangles do not overlap, then rec1 must either be higher, lower, to the left, or to the right of rec2.
        //either left or over or right or under
        //[x1, y1, x2, y2] 
        //[0,  1,   2 , 3]
        //          rec1[]
        //  rec1[]  rec2[]       rec1[]
        //          rec1[] 
        //  situation not intersected

        
        return !(rec1[2] <= rec2[0] ||   // left rec1[x2] <= rec2[x1]
                 rec1[3] <= rec2[1] ||   // bottom rec1[y2] <= rec2[y1]
                 rec1[0] >= rec2[2]||   // right rec1[x1] >= rec2[x2]
                 rec1[1] >= rec2[3]);    // top rec1[y1] >= rec2[y2]
