package com.app.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoClientTest {
	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB database = mongoClient.getDB("myTestDb");

		// print existing databases
		mongoClient.getDatabaseNames().forEach(System.out::println);
		
		System.out.println("*********************");

		database.createCollection("customers", null);

		// print all collections in customers database
		database.getCollectionNames().forEach(System.out::println);

		// create data
		DBCollection collection = database.getCollection("customers");
		BasicDBObject document = new BasicDBObject();
		document.put("name", "sudeep");
		document.put("company", "company1");
		collection.insert(document);
		
		BasicDBObject document1 = new BasicDBObject();
		document1.put("name", "ram");
		document1.put("company", "company2");
		collection.insert(document1);

		// update data
		BasicDBObject query = new BasicDBObject();
		query.put("name", "sudeep");
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "John");
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);
		collection.update(query, updateObject);

		// read data
		BasicDBObject searchQuery = new BasicDBObject();
		//searchQuery.put("name", "john");
		DBCursor cursor = collection.find(searchQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		// delete data
		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("name", "John");
		collection.remove(deleteQuery);
	}
}
