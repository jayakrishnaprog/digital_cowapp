package com.bezkoder.spring.datajpa.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Cow;
import com.bezkoder.spring.datajpa.repository.Cowrepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.val;

//@CrossOrigin(origins = "http://localhost:8081")

@RequestMapping("/api")
@RestController
public class CowController {
	private static final Logger logger = LoggerFactory.getLogger(CowController.class);
	@Autowired
	Cowrepository cowrepository;

	 @GetMapping("/health")
	public String health() {
		return "good";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Cow>> findAll() {
		{
			try {
				//String str = new String(datas.peek(), StandardCharsets.UTF_8);
				List<Cow> abc = cowrepository.findAll();
				//System.out.println(abc);
				//logger.info("findAll" +abc.toString());
				//logger.debug("findAll" +abc.toString());
				return new ResponseEntity<>(abc, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			// }

		}
	}
	@PostMapping("/findById/{id}")
	public ResponseEntity<Cow> findById(@RequestBody String id) {
		{
			try {
				ObjectMapper objectMapper = new ObjectMapper();
	            JsonNode jsonNode = objectMapper.readTree(id);

	            // Extract value associated with key "id"
	            String idValue = jsonNode.get("id").asText();
				
				//Cow abc = cowrepository.findbyId(idValue);
				//logger.info(abc.toString());
				Cow c=new Cow();
				
				return new ResponseEntity<Cow>(c, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			// }

		}
	}

	@PostMapping("/save")
	public ResponseEntity<Cow> postAPI(@RequestBody String replacedStr) {
		{
			String  input= replacedStr.replace("\\/", "/");
			//String input = new String(byteArrayDeque);
		//	logger.info("postAPI calling :: input "+input);
			
			try {
				/*List<Cow> list = listData(input);
				List<CompletableFuture<Void>> futures = list.stream()
					    .map(record -> CompletableFuture.runAsync(() -> {
					        try {
					          //  logger.info("Record going for save : " + record);
					            cowrepository.save(record);
					        } catch (Exception e) {
					            logger.error("Exception occurred while saving record: " + e.getMessage());
					        }
					    }))
					    .collect(Collectors.toList());
				CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();*/
				/*list.parallelStream().forEach(record -> {
					
					try {
						logger.info("Record going for save : " + record);
						cowrepository.save(record);
					} catch (Exception e) {
						logger.info("Exception block  : " + e);
					}
				});*/
				// cowrepository.saveAll(list);
				
				Executor executor = Executors.newFixedThreadPool(30);

				List<Cow> list1 = listData(input);
				List<CompletableFuture<Void>> futures1 = list1.parallelStream()
				    .map(record -> CompletableFuture.runAsync(() -> {
				        try {
				            // Task code here
				            cowrepository.save(record);
				        } catch (Exception e) {
				            logger.error("Exception occurred while saving record: " + e.getMessage());
				        }
				    }, executor))
				    .collect(Collectors.toList());

				// Wait for all CompletableFuture instances to complete
				CompletableFuture<Void> allOf = CompletableFuture.allOf(futures1.toArray(new CompletableFuture[0]));
				allOf.join();

				return new ResponseEntity<>(null, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	int number = 0; 
	private List<Cow> listData(String in) {
		//logger.info("input is  ::"+in);
		String abc=in.replace(";EOD","");;
		/*
		 * if(in.contains("EOD")){ abc=in.replace(";EOD",""); }else { abc=in; }
		 */	
		//logger.info("inside listData () ::"+abc);	
		
		String ini = abc.replace("\"data\": ", "");
		String input = ini.replace("\"data\":", "");

		List<Cow> list = new ArrayList();
		String[] records = input.split(";");
	
		for (String record1 : records) {
			String record2=record1.replace("{", "");
			String record3=record2.replace("}", "");
			String record=record3.replace("\"", "");
			//System.out.println(record);
			Cow pojo = new Cow();
			 int add = 1; 
			number=number+add;
			pojo.setSno(number);
			String[] keyValuePairs = record.split(",");
			String timeStamp = null;
			String id = null;
			int spo2 = 0;
			int bpm = 0;
			double temperature = 0;
			int i=0;
			BigDecimal X;
			BigDecimal Y;
			BigDecimal Z;
			BigDecimal MX;
			BigDecimal MY;
			BigDecimal MZ;
			BigDecimal GX;
			BigDecimal GY;
			BigDecimal GZ;
			int VIB;
			
	        
	       
			for (String pair : keyValuePairs) {
				String[] keyValue = pair.split(":");
				String key1 = keyValue[0];
				String value = keyValue[1];
				
				//System.out.println(key1+ ":"+value);
				String key=key1.trim();
				//System.out.println(key);
				
				switch (key) {
				case "TimeStamp":
					timeStamp = value.trim();
					//String standardString = timeStamp.replace("-","‑");
					String standardString = timeStamp.replaceAll("[^\\p{ASCII}]", "-");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH-mm-ss");
					LocalDateTime timestamp = LocalDateTime.parse(standardString, formatter);
					pojo.setTimeStamp(timestamp);
					break;
				case "ID":
					 id = value.replaceAll("[^\\p{ASCII}]", "-");
					pojo.setId(id);
					break;
				case "Spo2":
					spo2 = Integer.parseInt(value.trim());
					pojo.setSpo2(spo2);
					break;
				case "BPM":
					bpm = Integer.parseInt(value.trim());
					pojo.setBpm(bpm);
					break;
				case "Temperature":
					temperature = Double.parseDouble(value.trim());
					pojo.setTemperature(temperature);
					break;
				case "X":
					String standardString1 = value.replaceAll("[^\\p{ASCII}]", "-");
					X=new BigDecimal(standardString1.trim());
					pojo.setX(X);
					break;
				case "Y":
					String standardString2=value.replaceAll("[^\\p{ASCII}]", "-");
					Y=new BigDecimal(standardString2.trim());
					pojo.setY(Y);
					break;
				case "Z":
					String standardString3=value.replaceAll("[^\\p{ASCII}]", "-");
					Z=new BigDecimal(standardString3.trim());
					pojo.setZ(Z);
					break;
				case "GX":
					String standardString4 = value.replaceAll("[^\\p{ASCII}]", "-");
					GX=new BigDecimal(standardString4.trim());
					pojo.setGX(GX);
					break;
				case "GY":
					String standardString5=value.replaceAll("[^\\p{ASCII}]", "-");
					GY=new BigDecimal(standardString5.trim());
					pojo.setGY(GY);
					break;
				case "GZ":
					String standardString6=value.replaceAll("[^\\p{ASCII}]", "-");
					GZ=new BigDecimal(standardString6.trim());
					pojo.setGZ(GZ);
					break;
				case "MX":
					String standardString7 = value.replaceAll("[^\\p{ASCII}]", "-");
					MX=new BigDecimal(standardString7.trim());
					pojo.setMX(MX);
					break;
				case "MY":
					String standardString8=value.replaceAll("[^\\p{ASCII}]", "-");
					MY=new BigDecimal(standardString8.trim());
					pojo.setMY(MY);
					break;
				case "MZ":
					String standardString9=value.replaceAll("[^\\p{ASCII}]", "-");
					MZ=new BigDecimal(standardString9.trim());
					pojo.setMZ(MZ);
					break;
				case "VIB":
					VIB = Integer.parseInt(value.trim());
					pojo.setVib(VIB);
					break;
				default:
					break;
				}
				
			}
			//System.out.println(pojo);
			list.add(pojo);
			//System.out.println(list.size());
		}
		//System.out.println(list.size());
		//logger.info("Final list for saving  :: "+ list.toString());
		return list;

	}

}
