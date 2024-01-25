package com.data.app.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.data.app.entity.Data;

@Component
public class Helper {

	/*
	 * This methods checks if excel file hasve been passed as param or not
	 * 
	 * @param: MultipartFile -> File passed as param
	 * @return: Boolean -> If it is excel file then true otherwise false
	 */
	public static boolean checkExcelFormat(MultipartFile multipartFile) {
		
		String contentType = multipartFile.getContentType();
//		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
		if (contentType.equals("text/csv")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * This method convert excel data into list of TimeCard objects product
	 * and returns the list
	 * 
	 * @param: InputStream -> input stream
	 * @return: List<TimeCard> -> List of all TimeCard objects
	 */
	public List<Data> convertExcelToListOfProduct(InputStream inputStream){
		
		List<Data> list = new ArrayList<>();
		
		try {
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader, 
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			List<CSVRecord> records = csvParser.getRecords();
			
			for (CSVRecord record: records) {
				Data data = new Data();
				data.setId(UUID.randomUUID().toString());
				data.setCity(record.get("city"));
				data.setCitylat(record.get("citylat"));
				data.setCitylng(record.get("citylng"));
				data.setCountry(record.get("country"));
				data.setEndYear(record.get("end_year"));
				data.setAdded(record.get("added"));
				data.setImpact(record.get("impact"));
				data.setInsight(record.get("insight"));
				data.setIntensity(record.get("intensity"));
				data.setLikelihood(record.get("likelihood"));
				data.setPestle(record.get("pestle"));
				data.setPublished(record.get("published"));
				data.setRegion(record.get("region"));
				data.setRelevance(record.get("relevance"));
				data.setSector(record.get("sector"));
				data.setSource(record.get("source"));
				data.setStartYear(record.get("start_year"));
				data.setSwot(record.get("swot"));
				data.setTitle(record.get("title"));
				data.setTopic(record.get("topic"));
				data.setUrl(record.get("url"));
				list.add(data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
