package algorithm.leetcode;

/**
 * Created by hy on 2015/9/16.
 */
public class Hanruota {


        public static void moveDish(int level, char from, char inter, char to)
        {
            if(level ==1)
            {
                System.out.println("从 "+from+"移动盘子1号到 "+to);
            }else
            {
                moveDish(level-1,from,to,inter);
                System.out.println("从 "+from+" 移动盘子 "+level+" 号到 "+to);
                moveDish(level-1,inter,from,to);
            }

        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int nDisks = 3;
            moveDish(nDisks,'A','B','C');

        }


}
