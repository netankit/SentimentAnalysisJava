package bow.matlab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentimentValue {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fileInputStream = new FileInputStream(args[0]);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(dataInputStream));
		FileWriter fstream = new FileWriter(args[1]);
		BufferedWriter out = new BufferedWriter(fstream);

		// Close the output stream
		System.out.println("Starting.....");
		String myLine = createFileString(bufferedReader);
		// System.out.println(myLine);
		out.write(myLine);
		System.out.println("Finished Sentiment Value!");
		dataInputStream.close();
		out.close();
	}

	private static String createFileString(BufferedReader bufferedReader)
			throws IOException {
		String fileLine = "";
		String line = "";
		String tempLine = "";
		int count = 1;
		while (((line = bufferedReader.readLine()) != null)) {
			String[] components;
			System.out.println("Line number: " + count);

			components = line.split("\t");
			String Value = "";
			if (components[3].equalsIgnoreCase("Sentiment")) {
				Value = "1";
			} else if (components[3].equalsIgnoreCase("0")
					|| components[3].equalsIgnoreCase("1")) {
				Value = "-1";
			} else if (components[3].equalsIgnoreCase("2")
					|| components[3].equalsIgnoreCase("3")
					|| components[3].equalsIgnoreCase("4")) {
				Value = "1";
			}
			tempLine = tempLine + Value + "\n";
			count++;
		}
		// int ind = tempLine.lastIndexOf(";");
		// String finalLine;
		// finalLine = new StringBuilder(tempLine).replace(ind, ind + 1, "")
		// .toString();

		// fileLine = "[" + finalLine + "]";
		fileLine = tempLine;
		return fileLine;

	}
}
