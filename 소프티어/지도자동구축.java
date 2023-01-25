package 소프티어;

import java.util.*;
import java.io.*;

public class 지도자동구축 {

    static int N;
    public static void main(String args[]) throws Exception // error: unreported exception IOException; must be caught or declared to be thrown -> 익셉션 던져
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 라인 당 칸 개수 : 2의 1승, 2의 2승, 2의 3승...
        // 라인 당 점 개수 : 칸 개수 + 1
        System.out.println((int)Math.pow((Math.pow(2, N)+1), 2));
    }


}
