            int area = (C-A) * (D-B) + (G -E) * (H -F);
            int XLeft = Math.max(A,E);
            int YDown = Math.max(B,F);
            int XRight = Math.min(C,G);
            int YUp = Math.min(D,H);
            if(C <= E || B >=H || A >= G || D <= F) {
                // not overlap
                //if(xLeft >= Xright || YDown>= YUp)
                return area;
            }else{
                return area - Math.abs(XRight - XLeft) * Math.abs(YUp -YDown );  
            }
