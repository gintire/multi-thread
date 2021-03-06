package code_efficiency.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SplitStringTokenizer {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 1000; i++)
		    sb.append(i).append(' ');
		String sample = sb.toString();

		int runs = 100000;
		for (int i = 0; i < 5; i++) {
		    {
		        long start = System.nanoTime();
		        for (int r = 0; r < runs; r++) {
		            StringTokenizer st = new StringTokenizer(sample);
		            List<String> list = new ArrayList<String>();
		            while (st.hasMoreTokens())
		                list.add(st.nextToken());
		        }
		        long time = System.nanoTime() - start;
		        System.out.printf("StringTokenizer took an average of %.1f us%n", time / runs / 1000.0);
		    }
		    {
		        long start = System.nanoTime();
		        for (int r = 0; r < runs; r++) {
		            List<String> list = Arrays.asList(sample.split(" "));
		        }
		        long time = System.nanoTime() - start;
		        System.out.printf("split took an average of %.1f us%n", time / runs / 1000.0);
		    }
		    {
		        long start = System.nanoTime();
		        for (int r = 0; r < runs; r++) {
		            List<String> list = new ArrayList<String>();
		            int pos = 0, end;
		            while ((end = sample.indexOf(' ', pos)) >= 0) {
		                list.add(sample.substring(pos, end));
		                pos = end + 1;
		            }
		        }
		        long time = System.nanoTime() - start;
		        System.out.printf("indexOf loop took an average of %.1f us%n", time / runs / 1000.0);
		    }
		 }
	}

}
