  import java.text.DecimalFormat; 
  import numal.*;

   em = new double[8];
   a = new double[9][6];

    a[1][1]=22; a[1][2]=a[2][3]=10.0; a[1][3]=a[7][1]=a[8][5]=2.0;
    a[1][4]=a[3][5]=3.0; a[1][5]=a[2][2]=7.0; a[2][1]=14.0; a[2][5]=8.0;
    a[2][4]=a[8][3]=0.0; a[3][1]=a[3][3]=a[6][5] = -1.0; a[3][2]=13.0;
    a[3][4] = -11.0; a[4][1] = -3.0;
    a[4][2]=a[4][4]=a[5][4]=a[8][4] = -2.0;
    a[4][3]=13.0; a[4][5]=a[5][5]=a[8][1]=4.0; a[5][1]=a[6][1]=9.0;
    a[5][2]=8.0; a[5][3]=a[6][2]=a[7][5]=1.0; a[6][3] = -7.0;
    a[6][4]=a[7][4]=a[8][2]=5.0; a[7][2] = -6.0; a[7][3]=6.0;
    em[0]=1.0e-14; em[2]=1.0e-12; em[4]=80.0; em[6]=1.0e-10;
    i= Linear_algebra.psdinv(a,8,5,em);
    DecimalFormat fiveDigit = new DecimalFormat("0.00000E0");
    
 println("Number of singular values not found : " +
      i + "\nNorm :  " + fiveDigit.format(em[1]) +
      "\nMaximal neglected subdiagonal element :  " +
      fiveDigit.format(em[3]) +
      "\nNumber of iterations :  " + (int)em[5] +
      "\nRank :  " + (int)em[7]);
  
 println("\nTranspose of pseudo-inverse," +
      "first three columns:");
    for (i in 1..8)
       System.out.println("\t" + fiveDigit.format(a[i][1]) +
        "\t" + fiveDigit.format(a[i][2]) + "\t" + 
        fiveDigit.format(a[i][3]));
    
   System.out.println("\nLast two columns:");
   for (i in 1..8)
      System.out.println("\t\t" + 
        fiveDigit.format(a[i][4]) + "\t" +  
        fiveDigit.format(a[i][5]));
	

