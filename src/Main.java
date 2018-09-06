import java.util.Scanner;

    public class Main
    {
        public static void main(String[] args) {
            Main object = new Main();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Вв-те кол-во строк(стл-ов)матриц которые хотите сложить");
            int FirstSize = scanner.nextInt();
            int SecondSize = FirstSize * FirstSize;
            int ThirdSize = FirstSize + 3;
//массив для хранения значений первой двухмерной матрицы
            int[] A1 = new int[SecondSize];
//массив для хранения значений первой двухмерной матрицы
            int[] LI1 = new int[SecondSize];
//массив для хранения значений первой двухмерной матрицы
            int[] LJ1 = new int[ThirdSize];
//массив для хранения значений второй двухмерной матрицы
            int[] A2 = new int[SecondSize];
            //массив для хранения значений второй двухмерной матрицы
            int[] LI2 = new int[SecondSize];
//массив для хранения значений второй двухмерной матрицы
            int[] LJ2 = new int[ThirdSize];
//массив для хранения значений результирующей  двухмерной матрицы
            int[] A3 = new int[SecondSize];
//массив для хранения значений результирующей двухмерной матрицы
            int[] LI3 = new int[SecondSize];
//массив для хранения значений результирующей двухмерной матрицы
            int[] LJ3 = new int[ThirdSize];
            object.CreateAndPackaging(FirstSize, A1, LI1, LJ1);
            object.CreateAndPackaging(FirstSize, A2, LI2, LJ2);
            object.Summ(FirstSize, A3, LI3, LJ3, A1, LI1, LJ1, A2, LI2, LJ2);
            object.PrintResult(FirstSize, A3, LI3, LJ3);
        }
        // производим ввод чисел и сразу их упаковываем
        public void CreateAndPackaging(int size,int[] A, int[] LI, int[] LJ)
        {
            Scanner scanner = new Scanner(System.in);
            int Count = 0;
            int a;
            boolean Flag = false;
            for (int i = 0; i < size; i++)
            {
                Flag = true;
                for (int j = 0; j < size; j++)
                {
                    System.out.println("Введите знач массива " +j+" строки "+i+" столбца");
                    a = scanner.nextInt();
                    if ( a!=0) //если значение которое ввели не 0 производим упаковку
                    {
                        LI[Count]= j;
                        A[Count]= a;
                        Count++;
                        if (Flag)
                        {
                            LJ[i]= Count;
                        }
                        Flag = false;
                    }
                    if (i == size-1 && j == size-1)
                    {
                        LJ[i+1] = Count+1;
                    }
                }
            }
        }
        // используем метод доступа к элменту
        public int  Find(int i, int j, int[] A, int[] LI, int[] LJ)
        {
            int FindNumber = 0;
            int N1 = LJ[j];
            int N2 = LJ[j+1];
            N1--;
            N2--;
            for (int k = N1; k < N2; k++)
            {
                if (LI[k] == i)
                {
                    FindNumber = A[k];
                    break;
                }else
                {
                    FindNumber = 0;
                }
            }
            return FindNumber;
        }
        //через метод доступа к эдементу складываем 2 упокованные матрицы
        public void Summ(int size,int[] A3, int[] LI3, int[] LJ3, int[] A1, int[] LI1, int[] LJ1,int[] A2, int[] LI2, int[] LJ2)
        {
            int count = 0;
            boolean Flag;
            for (int j = 0; j < size; j++)
            {
                Flag = true;
                for (int i = 0; i < size; i++)
                {
                    int X = Find(i,j,A1,LI1,LJ1) + Find(i,j,A2,LI2,LJ2); //скл-ем знач 1 и 2 матрицы
                    if (X != 0)
                    {
                        A3[count] = X;
                        LI3[count] = i;
                        count++;
                        if (Flag)
                        {
                            LJ3[j]= count;
                        }
                        Flag = false;
                    }
                    if (i == size-1 && j == size-1)
                    {
                        LJ3[j+1] = count;
                    }
                }
            }
        }
        //выводим получившеюся матрицу в виде двухмерной
        public void PrintResult(int size, int A[], int LI[], int LJ[])
        {
            System.out.println("Result Array:");
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    System.out.print(Find(i,j,A,LI,LJ)+"\t");
                }
                System.out.println();
            }
        }
    }

