package statistics.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleStatistics {

	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out
					.println("Usage: java -jar SimpleStatistics inputfile outputfile");
			System.exit(0);
		}

		FileWriter fwstream = new FileWriter(args[1]);
		BufferedWriter out = new BufferedWriter(fwstream);

		FileInputStream word2vecFileStream = new FileInputStream(args[0]);
		// Get the object of DataInputStream
		DataInputStream inStream = new DataInputStream(word2vecFileStream);
		BufferedReader brStream = new BufferedReader(new InputStreamReader(
				inStream));
		String strLine;
		String[] components;

		String line;
		String sentiment;

		int countLines = 0;

		int countTotal = 0;
		int countNot = 0;
		int countBad = 0;
		int countWorst = 0;
		int countTerrible = 0;
		int countWorse = 0;
		int countWeak = 0;
		int countUnable = 0;
		int countNever = 0;
		int countNo = 0;
		int countSad = 0;

		int countTotalFirst = 0;
		int countNotFirst = 0;
		int countBadFirst = 0;
		int countWorstFirst = 0;
		int countTerribleFirst = 0;
		int countWorseFirst = 0;
		int countWeakFirst = 0;
		int countUnableFirst = 0;
		int countNeverFirst = 0;
		int countNoFirst = 0;
		int countSadFirst = 0;

		int countTotalFirstIncorrect = 0;
		int countNotFirstIncorrect = 0;
		int countBadFirstIncorrect = 0;
		int countWorstFirstIncorrect = 0;
		int countTerribleFirstIncorrect = 0;
		int countWorseFirstIncorrect = 0;
		int countWeakFirstIncorrect = 0;
		int countUnableFirstIncorrect = 0;
		int countNeverFirstIncorrect = 0;
		int countNoFirstIncorrect = 0;
		int countSadFirstIncorrect = 0;

		int countTotalFirstIncorrectNeutral = 0;
		int countNotFirstIncorrectNeutral = 0;
		int countBadFirstIncorrectNeutral = 0;
		int countWorstFirstIncorrectNeutral = 0;
		int countTerribleFirstIncorrectNeutral = 0;
		int countWorseFirstIncorrectNeutral = 0;
		int countWeakFirstIncorrectNeutral = 0;
		int countUnableFirstIncorrectNeutral = 0;
		int countNeverFirstIncorrectNeutral = 0;
		int countNoFirstIncorrectNeutral = 0;
		int countSadFirstIncorrectNeutral = 0;

		int firstWordCount = 0;
		int shortSentenceCount = 0;
		int shortSentenceMarkedNeutral = 0;

		while ((strLine = brStream.readLine()) != null) {

			components = strLine.split("	");

			// TEST DATA
			line = components[0];
			sentiment = components[1];

			// TRAIN DATA
			// line = components[2];
			// sentiment = components[3];

			String[] componentsLine;
			componentsLine = line.split(" ");
			for (int i = 0; i < componentsLine.length; i++) {
				if (componentsLine[i].trim().equalsIgnoreCase("not")
						|| componentsLine[i].trim().equalsIgnoreCase("bad")
						|| componentsLine[i].trim()
								.equalsIgnoreCase("terrible")
						|| componentsLine[i].trim().equalsIgnoreCase("worst")
						|| componentsLine[i].trim().equalsIgnoreCase("worse")
						|| componentsLine[i].trim().equalsIgnoreCase("weak")
						|| componentsLine[i].trim().equalsIgnoreCase("no")
						|| componentsLine[i].trim().equalsIgnoreCase("sad")
						|| componentsLine[i].trim().equalsIgnoreCase("unable")
						|| componentsLine[i].trim().equalsIgnoreCase("never")) {
					countTotal++;
				}

				if (componentsLine[i].trim().equalsIgnoreCase("not")) {
					countNot++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("no")) {
					countNo++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("sad")) {
					countSad++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("bad")) {
					countBad++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("terrible")) {
					countTerrible++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("worst")) {
					countWorst++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("worse")) {
					countWorse++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("weak")) {
					countWeak++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("unable")) {
					countUnable++;
				}
				if (componentsLine[i].trim().equalsIgnoreCase("never")) {
					countNever++;
				}
			}

			String inputWordToAnalyze;

			// Tune this parameter to change the word under consideration.
			int positionOfWordInSentence = 0;

			if (componentsLine.length == 1) {
				firstWordCount++;
			}

			if (componentsLine.length < 6) {
				shortSentenceCount++;
				if (Integer.parseInt(sentiment) == 2) {
					shortSentenceMarkedNeutral++;
				}
			}
			if (!(componentsLine.length == 0)) {
				inputWordToAnalyze = componentsLine[positionOfWordInSentence];
			} else {
				inputWordToAnalyze = line.trim();
			}
			// Counts for sentiment Words in first position in sentence
			if (!inputWordToAnalyze.isEmpty()) {

				if (inputWordToAnalyze.trim().equalsIgnoreCase("not")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("bad")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("no")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("sad")
						|| inputWordToAnalyze.trim().equalsIgnoreCase(
								"terrible")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("worst")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("worse")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("weak")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("unable")
						|| inputWordToAnalyze.trim().equalsIgnoreCase("never")) {
					countTotalFirst++;
				}

				if (inputWordToAnalyze.trim().equalsIgnoreCase("not")) {
					countNotFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countNotFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countNotFirstIncorrectNeutral++;
					}
				}

				if (inputWordToAnalyze.trim().equalsIgnoreCase("no")) {
					countNoFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countNoFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countNoFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("bad")) {
					countBadFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countBadFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countBadFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("terrible")) {
					countTerribleFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countTerribleFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countTerribleFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("worst")) {
					countWorstFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countWorstFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countWorstFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("worse")) {
					countWorseFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countWorseFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countWorseFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("weak")) {
					countWeakFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countWeakFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countWeakFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("unable")) {
					countUnableFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countUnableFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countUnableFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("sad")) {
					countSadFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countSadFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countSadFirstIncorrectNeutral++;
					}
				}
				if (inputWordToAnalyze.trim().equalsIgnoreCase("never")) {
					countNeverFirst++;
					if (Integer.parseInt(sentiment) > 1) {
						countNeverFirstIncorrect++;
					}
					if (Integer.parseInt(sentiment) == 2) {
						countNeverFirstIncorrectNeutral++;
					}
				}

			}
			countLines++;
		}
		// System.out.println("Total Lines: " + countLines);
		out.write("\nTotal Phrases: " + countLines);
		out.write("\nPhrases having only one word count: " + firstWordCount);
		out.write("\nTotal Short Phrases (Less than 6 words): "
				+ shortSentenceCount);
		out.write("\nTotal Short Sentence (Less than 6 words) Marked Neutral: "
				+ shortSentenceMarkedNeutral);

		out.write("\n\n### Counts when sentiment word is in Anywhere in the Sentence ###\n");

		// System.out.println("Total Count: " + countTotal);
		out.write("\nTotal Count: " + countTotal);
		out.write("\nTotal Count Not: " + countNot);
		out.write("\nTotal Count No: " + countNo);
		out.write("\nTotal Count Sad: " + countSad);
		out.write("\nTotal Count Bad: " + countBad);
		out.write("\nTotal Count Terrible: " + countTerrible);
		out.write("\nTotal Count Worst: " + countWorst);
		out.write("\nTotal Count Worse: " + countWorse);
		out.write("\nTotal Count Weak: " + countWeak);
		out.write("\nTotal Count Unable: " + countUnable);
		out.write("\nTotal Count Never: " + countNever);

		// System.out.println("Total Count: " + countTotal);
		out.write("\n\n### Counts when sentiment word is in the first position ###\n");

		out.write("\nTotal Count: " + countTotalFirst);
		out.write("\nTotal Count Not: " + countNotFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countNotFirst - countNotFirstIncorrect));
		out.write("\nTotal Count No: " + countNoFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countNoFirst - countNoFirstIncorrect));
		out.write("\nTotal Count Bad: " + countBadFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countBadFirst - countBadFirstIncorrect));
		out.write("\nTotal Count Terrible: " + countTerribleFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countTerribleFirst - countTerribleFirstIncorrect));
		out.write("\nTotal Count Worst: " + countWorstFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countWorstFirst - countWorstFirstIncorrect));
		out.write("\nTotal Count Worse: " + countWorseFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countWorseFirst - countWorseFirstIncorrect));
		out.write("\nTotal Count Weak: " + countWeakFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countWeakFirst - countWeakFirstIncorrect));
		out.write("\nTotal Count Unable: " + countUnableFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countUnableFirst - countUnableFirstIncorrect));
		out.write("\nTotal Count Never: " + countNeverFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countNeverFirst - countNeverFirstIncorrect));
		out.write("\nTotal Count Sad: " + countSadFirst
				+ "; Marked Correctly (Negative / Slightly negative): "
				+ (countSadFirst - countSadFirstIncorrect));

		out.write("\n\n### Wrong Marked Sentiment for common negative words, when they occur in first position ###\n");

		out.write("\nTotal Count Not: " + countNotFirstIncorrect
				+ "; Marked Neutral: " + countNotFirstIncorrectNeutral);
		out.write("\nTotal Count No: " + countNoFirstIncorrect
				+ "; Marked Neutral: " + countNoFirstIncorrectNeutral);
		out.write("\nTotal Count Bad: " + countBadFirstIncorrect
				+ "; Marked Neutral: " + countBadFirstIncorrectNeutral);
		out.write("\nTotal Count Terrible: " + countTerribleFirstIncorrect
				+ "; Marked Neutral: " + countTerribleFirstIncorrectNeutral);
		out.write("\nTotal Count Worst: " + countWorstFirstIncorrect
				+ "; Marked Neutral: " + countWorstFirstIncorrectNeutral);
		out.write("\nTotal Count Worse: " + countWorseFirstIncorrect
				+ "; Marked Neutral: " + countWorseFirstIncorrectNeutral);
		out.write("\nTotal Count Weak: " + countWeakFirstIncorrect
				+ "; Marked Neutral: " + countWeakFirstIncorrectNeutral);
		out.write("\nTotal Count Unable: " + countUnableFirstIncorrect
				+ "; Marked Neutral: " + countUnableFirstIncorrectNeutral);
		out.write("\nTotal Count Never: " + countNeverFirstIncorrect
				+ "; Marked Neutral: " + countNeverFirstIncorrectNeutral);
		out.write("\nTotal Count Sad: " + countSadFirstIncorrect
				+ "; Marked Neutral: " + countSadFirstIncorrectNeutral);

		System.out.println("Done!");
		brStream.close();
		out.close();

	}
}
