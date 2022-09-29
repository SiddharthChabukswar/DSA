package MISC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class generateFilesFromString {

	public static String filterString(String fileName) {
		StringBuilder filteredStringBuilder = new StringBuilder();
		for(Character c: fileName.toCharArray()) {
			if(c >= 'a' && c <= 'z') filteredStringBuilder.append(c);
			else if(c >= 'A' && c <= 'Z') filteredStringBuilder.append(c);
			else if(c >= '0' && c <= '9') filteredStringBuilder.append(c);
			else if(c == ' ') filteredStringBuilder.append(c);
			else continue;
		}
		return filteredStringBuilder.toString().replaceAll(" ", "_");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = sc.nextLine();
		fileName = filterString(fileName);
		System.out.println(fileName+".java");
		String toWrite = "\npublic class " + fileName + " {\n\n\n}";
		try{
			FileWriter myWriter = new FileWriter(fileName+".java");
			myWriter.write(toWrite);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		sc.close();
	}
	
}
