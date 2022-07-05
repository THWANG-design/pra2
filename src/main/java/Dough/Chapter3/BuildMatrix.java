package Dough.Chapter3;

import java.util.concurrent.CyclicBarrier;

public class BuildMatrix {

    class MatrixSolver{
        public float[][]matrix;
        public int num;

        public MatrixSolver(float[][]matrix) {
            this.matrix = matrix;
            this.num = matrix.length;

            CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
                @Override
                public void run() {
                    System.out.println("所有任务都已经完成了， 可以使用数组了");
                }
            });

            for (int i = 0; i < num; i++) {
                Thread t = new Thread();
            }

        }
    }

    class Worker implements Runnable{
        public float[][]matrix;
        int row;
        public Worker(float[][]matrix, int row){
            this.matrix = matrix;
            this.row = row;
        }
        @Override
        public void run() {
            int sum = 0;
            for(int i = 0; i < matrix[0].length; i++){
                sum += matrix[row][i];
            }
            System.out.println("第" + row + "行的和为" + sum);


        }
    }
}
