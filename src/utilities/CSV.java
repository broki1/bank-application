package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

	// function will read data from a CSV file and return it as a list

	public static List<String[]> read(String file) throws IOException {
		List<String[]> data = new LinkedList<String[]>();

		BufferedReader br = new BufferedReader(new FileReader(file));
		String dataRow;

		while ((dataRow = br.readLine()) != null) {

			String[] dataRecords = dataRow.split(",");

			data.add(dataRecords);
		}

		return data;
	}

}
