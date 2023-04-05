package matrix;

import java.util.ArrayList;
import java.util.List;

public interface IMatrix {
    /**
     *
     * @return zwraca dane macierzy prostokątnej
     */
    double[][] getData();

    /**
     *
     * @param data dane macierzy prostokątnej
     */
    void setData(double[][] data);

    /**
     *
     * @return zwraca liczbę wierszy
     */
    int rowCount();

    /**
     *
     * @return zwraca liczbę kolumn
     */
    int columnCount();

    /**
     *
     * @return zwraca reprezentację tekstową
     */
    String toString();

    /**
     *
     * @param a macierz A
     * @param b macierz B
     * @return AxB
     */



    static IMatrix multiply(IMatrix a, IMatrix b){
        int resultRows=a.rowCount();
        int resultColumns=b.columnCount();
        IMatrix result = new Matrix(resultRows,resultColumns);
        int colCount = b.columnCount(),i=0,j=0,k=0;
            for(i=0;i<resultRows;i++){
                for(j=0;j<colCount;j++){
                    result.getData()[i][j]=0;
                    for(k=0;k<resultColumns;k++)
                        result.getData()[i][j]+=a.getData()[i][k]*b.getData()[k][j];
                }
            }

        return result;
    }
    static void checkMatrix(IMatrix firstMatrix, IMatrix secondMatrix) throws Exception{
        if(firstMatrix.columnCount() != secondMatrix.rowCount())
            throw new Exception("Macierze mają niepoprawne wymiary.\n");
    };
    static IMatrix multiplyWithThreads(IMatrix a, IMatrix b) {
        List<Thread> threads = new ArrayList<>();
        int aRows = a.rowCount();
        IMatrix result = new Matrix(a.rowCount(),b.columnCount());
        int freeThreads = Runtime.getRuntime().availableProcessors();
        for(int i=0;i<aRows;i++){
            Threads task = new Threads(a.getData(), b.getData(), result.getData(), i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if(threads.size() == freeThreads)
                for(Thread j : threads){
                    try{
                        j.join();
                    }catch(InterruptedException e) {
                        e.getMessage();
                    }
                }
            threads.clear();
        }
        return result;
    }
}
