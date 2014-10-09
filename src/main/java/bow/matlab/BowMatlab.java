package bow.matlab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BowMatlab {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fileInputStream = new FileInputStream(args[0]);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(dataInputStream));
		FileWriter fstream = new FileWriter(args[1]);
		BufferedWriter out = new BufferedWriter(fstream);

		// Close the output stream

		createMatlabString(bufferedReader, out);
		// System.out.println(myLine);

		System.out.println("Finished!");
		dataInputStream.close();
		out.close();
	}

	private static String createMatlabString(BufferedReader bufferedReader,
			BufferedWriter out) throws IOException {
		String fileLine = "";
		String line = "";
		String tempLine = "";
		int count = 1;
		while (((line = bufferedReader.readLine()) != null)) {
			System.out.println("Line number: " + count);
			line = line.replace("[", "");
			line = line.replace("]", "");
			line = line.replace(".0,", "");
			if (line.endsWith(".0")) {
				line = line.replace(".0", "");
			}
			tempLine = line + "\n";
			out.write(tempLine);
			count++;
		}
		fileLine = tempLine;
		return fileLine;

	}
}
