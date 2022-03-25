package com.company;

import java.util.ArrayList;
import java.util.Random;


public class Obje {
    public static class Altin{
        public Konum[] konums=new Konum[5];

        void Rastgele(ArrayList<Edge> edges,Karakter[] kar){
            int lenght=edges.size();
            int index=0;
            
            Random random=new Random();
            if (lenght != 0) {
                for (int i = 0; i <5 ; i++) {
                    boolean isInclude=false;
                    Konum k=new Konum();
                    index=random.nextInt(lenght-1);
                    for (var j:konums) {
                        if(j==null){
                            break;
                        }
                        if ((j.getX()==edges.get(index).c&&j.getY()==edges.get(index).r)||
                                (kar[0].konum.getX() == j.getX()&&kar[0].konum.getY() == j.getY())||
                                (kar[1].konum.getX() == j.getX()&&kar[1].konum.getY() == j.getY())||
                                (kar[2].konum.getX() == j.getX()&&kar[2].konum.getY() == j.getY())||
                                (kar[3].konum.getX() == j.getX()&&kar[3].konum.getY() == j.getY())) {
                                isInclude=true;
                        }

                    }
                    if (isInclude == true) {
                        i--;
                        continue;
                    }
                    k.setX(edges.get(index).c);
                    k.setY(edges.get(index).r);
                    konums[i]=k;
                }
            }




        }
    }
    public static class Mantar{
        public Konum[] konums=new Konum[1];
        void Rastgele(ArrayList<Edge> edges,Karakter[] kar){
            int lenght=edges.size();
            int index=0;

            Random random=new Random();
            if (lenght != 0) {
                for (int i = 0; i <1 ; i++) {
                    boolean isInclude=false;
                    Konum k=new Konum();
                    index=random.nextInt(lenght-1);
                    for (var j:konums) {
                        if(j==null){
                            break;
                        }
                        if ((j.getX()==edges.get(index).c&&j.getY()==edges.get(index).r)||
                                (kar[0].konum.getX() == j.getX()&&kar[0].konum.getY() == j.getY())||
                                (kar[1].konum.getX() == j.getX()&&kar[1].konum.getY() == j.getY())||
                                (kar[2].konum.getX() == j.getX()&&kar[2].konum.getY() == j.getY())||
                                (kar[3].konum.getX() == j.getX()&&kar[3].konum.getY() == j.getY())) {
                            isInclude=true;
                        }
                    }
                    if (isInclude == true) {
                        i--;
                        continue;
                    }
                    k.setX(edges.get(index).c);
                    k.setY(edges.get(index).r);
                    konums[i]=k;
                }
            }




        }
    }
}