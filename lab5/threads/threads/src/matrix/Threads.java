package matrix;

public class Threads implements Runnable {

    private double firstMatrix[][];
    private double secondMatrix [][];
    private double resultsMatrix[][];
    private int rows;

    public Threads(double[][]fMatrix,double[][]sMatrix, double [][]rMatrix,int rowsInMatrix){
        this.firstMatrix=fMatrix;
        this.secondMatrix=sMatrix;
        this.resultsMatrix =rMatrix;
        this.rows=rowsInMatrix;
    }
    @Override
    public void run() {
        for(int i=0;i< secondMatrix[0].length;i++){
            resultsMatrix[rows][i]=0;
            for (int j=0; j< firstMatrix[rows].length;j++)
                resultsMatrix[rows][i]+=firstMatrix[rows][j]* secondMatrix[j][i];
        }
    }


}
