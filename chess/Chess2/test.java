package Chess2;

import java.util.Arrays;

public class test {
    public int data;
    private boolean color;
    protected  int[] coord;

    test(boolean color,int [] coord,int data){
        this.data=data;
        this.coord= new int [coord.length];
        this.color=color;
        this.coord=coord;
    }
    public boolean getColor(){
        return color;
    }
    public void setColor(boolean color){
        this.color=color;
    }
    public class tes extends test{
        String s;
        tes(boolean color , int[] coord,String s,int data) {
            super(color,coord,data);
            this.s=s;
        }

        @Override
        public String toString() {
            return "tes{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "test{" +
                "data=" + data +
                ", color=" + color +
                ", coord=" + Arrays.toString(coord) +
                '}';
    }
    public static void main(String[] args){
        int []temp={2,5,7};
        test t1=new test(true,temp,10);
        System.out.println(t1);
        t1.setColor(false);
        t1.data=11;
        t1.coord=new int[5];
        System.out.println(t1);
    }
}
