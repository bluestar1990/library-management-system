package com.group7.library_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;

import com.github.javafaker.Faker;

public class SimulatorData {
	public static void main(String[] args) {
		Faker faker = new Faker();
		Random random = new Random();

//		for (int i = 0; i < 200; i++) {
//
//			List<String> authorIds = new ArrayList<>();
//			authorIds.add("66b393c20fedba3fab70a14b");
//			authorIds.add("66b393c20fedba3fab70a14c");
//			authorIds.add("66b393c20fedba3fab70a14d");
//			authorIds.add("66b393c20fedba3fab70a14e");
//			authorIds.add("66b393c20fedba3fab70a14f");
//			authorIds.add("66b393c20fedba3fab70a150");
//			authorIds.add("66b393c20fedba3fab70a151");
//			authorIds.add("66b393c20fedba3fab70a152");
//			authorIds.add("66b393c20fedba3fab70a153");
//			String bookAuthorIds = "";
//			for (int j = 0; j < 2; j++) {
//				String ewD = "ObjectId(\"" + authorIds.get(random.nextInt(authorIds.size())) + "\")";
//				if (!bookAuthorIds.contains(ewD)) {
//					bookAuthorIds += ewD;
//				}
//				if (j == 0) {
//					bookAuthorIds += ",";
//				}
//			}
//
//			List<String> publishers = new ArrayList<>();
//			publishers.add("64b3e4a1c6789f2d4f323456");
//			publishers.add("66b393c20fedba3fab70a154");
//			publishers.add("66b393c20fedba3fab70a155");
//			publishers.add("66b393c20fedba3fab70a156");
//			String publishersIds = "";
//			for (int j = 0; j < 1; j++) {
//				String ewD1 = "ObjectId(\"" + publishers.get(random.nextInt(publishers.size())) + "\")";
//				if (!publishersIds.contains(ewD1)) {
//					publishersIds += ewD1;
//				}
//			}
//
//			List<String> categorisIds = new ArrayList<>();
//			categorisIds.add("64b3e4a1c6789f2d4f423456");
//			categorisIds.add("66b393c20fedba3fab70a157");
//			categorisIds.add("66b393c20fedba3fab70a158");
//			categorisIds.add("66b393c20fedba3fab70a159");
//			categorisIds.add("66b393c20fedba3fab70a15a");
//			categorisIds.add("66b393c20fedba3fab70a15b");
//			categorisIds.add("66b393c20fedba3fab70a15c");
//			categorisIds.add("66b393c20fedba3fab70a15d");
//			String catIds = "";
//			for (int j = 0; j < 2; j++) {
//				String ewD2 = "ObjectId(\"" + categorisIds.get(random.nextInt(categorisIds.size())) + "\")";
//				if (!catIds.contains(ewD2)) {
//					catIds += ewD2;
//				}
//				if (j == 0) {
//					catIds += ",";
//				}
//			}
//
//			System.out.println("{ \"_id\": ObjectId(\"" + new ObjectId() + "\"), \"title\": \"" + faker.book().title()
//					+ "\", \"author_ids\": [" + bookAuthorIds + "], \"publisher_id\": " + publishersIds
//					+ ", \"category_ids\": [" + catIds + "], \"isbn\": \"" + faker.code().isbn13()
//					+ "\", \"published_date\": ISODate(\"2024-" + random.nextInt(10, 12) + "-" + random.nextInt(10, 31)
//					+ "T00:00:00Z\"), \"copies\": " + random.nextInt(10) + 1 + " },");
//		}

		String[] bookIds = {"66b3a20122ead978a95639e1","66b3a20122ead978a95639e2","66b3a20122ead978a95639e3","66b3a20122ead978a95639e4","66b3a20122ead978a95639e5","66b3a20222ead978a95639e6","66b3a20222ead978a95639e7","66b3a20222ead978a95639e8","66b3a20222ead978a95639e9","66b3a20222ead978a95639ea","66b3a20222ead978a95639eb","66b3a20222ead978a95639ec","66b3a20222ead978a95639ed","66b3a20222ead978a95639ee","66b3a20222ead978a95639ef","66b3a20222ead978a95639f0","66b3a20222ead978a95639f1","66b3a20222ead978a95639f2","66b3a20222ead978a95639f3","66b3a20222ead978a95639f4","66b3a20222ead978a95639f5","66b3a20222ead978a95639f6","66b3a20222ead978a95639f7","66b3a20222ead978a95639f8","66b3a20222ead978a95639f9","66b3a20222ead978a95639fa","66b3a20222ead978a95639fb","66b3a20222ead978a95639fc","66b3a20222ead978a95639fd","66b3a20222ead978a95639fe","66b3a20222ead978a95639ff","66b3a20222ead978a9563a00","66b3a20222ead978a9563a01","66b3a20222ead978a9563a02","66b3a20222ead978a9563a03","66b3a20222ead978a9563a04","66b3a20222ead978a9563a05","66b3a20222ead978a9563a06","66b3a20222ead978a9563a07","66b3a20222ead978a9563a08","66b3a20222ead978a9563a09","66b3a20222ead978a9563a0a","66b3a20222ead978a9563a0b","66b3a20222ead978a9563a0c","66b3a20222ead978a9563a0d","66b3a20222ead978a9563a0e","66b3a20222ead978a9563a0f","66b3a20222ead978a9563a10","66b3a20222ead978a9563a11","66b3a20222ead978a9563a12","66b3a20222ead978a9563a13","66b3a20222ead978a9563a14","66b3a20222ead978a9563a15","66b3a20222ead978a9563a16","66b3a20222ead978a9563a17","66b3a20222ead978a9563a18","66b3a20222ead978a9563a19","66b3a20222ead978a9563a1a","66b3a20222ead978a9563a1b","66b3a20222ead978a9563a1c","66b3a20222ead978a9563a1d","66b3a20222ead978a9563a1e","66b3a20222ead978a9563a1f","66b3a20222ead978a9563a20","66b3a20222ead978a9563a21","66b3a20222ead978a9563a22","66b3a20222ead978a9563a23","66b3a20222ead978a9563a24","66b3a20222ead978a9563a25","66b3a20222ead978a9563a26","66b3a20222ead978a9563a27","66b3a20222ead978a9563a28","66b3a20222ead978a9563a29","66b3a20222ead978a9563a2a","66b3a20222ead978a9563a2b","66b3a20222ead978a9563a2c","66b3a20222ead978a9563a2d","66b3a20222ead978a9563a2e","66b3a20222ead978a9563a2f","66b3a20222ead978a9563a30","66b3a20222ead978a9563a31","66b3a20222ead978a9563a32","66b3a20222ead978a9563a33","66b3a20222ead978a9563a34"};
		//System.out.println(borrowed_books);
		int k = 0;
		for (int i = 0; i < 40; i++) {
			String borrowed_books = "[";
			for (int j = 0; j < 2; j++) {
				String b = bookIds[k];
				int mm = random.nextInt(1, 5);
				int dd = random.nextInt(10, 20);
				String ewD2 = "{\"book_id\": ObjectId(\"" + b + "\"),";
				ewD2 = ewD2 + "\"borrow_date\": ISODate(\"2024-0" + mm + "-" + dd + "T00:00:00Z\"),";
				ewD2 = ewD2 + "\"due_date\": ISODate(\"2024-0" + (mm + 2) + "-" + (dd+2) + "T00:00:00Z\")},";
				borrowed_books += ewD2;
				k++;
			}
			borrowed_books +="]";			
			System.out.println("{ \"_id\": ObjectId(\"" + new ObjectId() + "\"), \"name\": \"" + faker.name().fullName()
			+ "\", \"membership_number\": \"MEM" + i + "\", \"email\": \"" + faker.name().fullName().toLowerCase().replaceAll("\\s", "") + "@email.com\""
			+ ", \"phone\": \"" + faker.phoneNumber().cellPhone() + "\", \"address\": \"" + faker.address().fullAddress()			+ "\", \"borrowed_books\": " + borrowed_books + "" + " },");
		}
	}
}
