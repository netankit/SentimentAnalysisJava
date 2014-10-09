package wordtovec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * WordtoVecWeights
 * 
 * This class is used to average the word2vec vectors and also perfroms a
 * weighted normalization based on the number of token and number of vectors
 * passed as arguments.
 * 
 * @author Ankit Bahuguna
 *
 */
public class WordtoVecWeights {

	public static void main(String[] args) throws IOException {
		if (args.length != 4) {
			System.out
					.println("Usage: java -jar WordtoVecWeights inputfile outputfile numberofTokens numberofVectors");
			System.exit(0);
		}

		final String numberofTokens = args[2];
		final String numberofVectors = args[3];

		// TODO Auto-generated method stub

		FileWriter fwstream = new FileWriter(args[1]);
		BufferedWriter out = new BufferedWriter(fwstream);

		FileInputStream word2vecFileStream = new FileInputStream(args[0]);
		// Get the object of DataInputStream
		DataInputStream inStream = new DataInputStream(word2vecFileStream);
		BufferedReader brStream = new BufferedReader(new InputStreamReader(
				inStream));
		String strLine;
		String[] components;
		String removeLine = numberofTokens + " " + numberofVectors;
		while ((strLine = brStream.readLine()) != null) {
			double weighted_sum = 0;
			double weight_norm = 0;

			if (!strLine.equalsIgnoreCase(removeLine)) {
				components = strLine.split(" ");
				for (int i = 1; i < components.length; i++) {
					weighted_sum = weighted_sum
							+ (Double.parseDouble(components[i]) * Double
									.parseDouble(components[i]));
				}
				weight_norm = (Math.sqrt(weighted_sum))
						/ Double.parseDouble(numberofVectors);
				DecimalFormat f = new DecimalFormat("0.0000000");

				String output_string = components[0] + "	"
						+ f.format(weight_norm) + "\n";
				out.write(output_string);
				System.out.print(output_string);
			}
		}
		System.out.println("Done");

		brStream.close();
		out.close();
	}
}
