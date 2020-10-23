package com.example.gibgym_demo11;

import android.content.Context;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Document;
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Primitive;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.ArrayList;
import java.util.List;
public class DatabaseAccess {
    private static final String COGNITO_POOL_ID = "us-east-1:7953558d-3732-4a59-a802-b760cbd65f20";
    private static final Regions MY_REGION = Regions.US_EAST_1;
    private AmazonDynamoDBClient dbClient;
    private Table dbTable;
    private Context context;
    private final String DYNAMODB_TABLE = "user_information";
    CognitoCachingCredentialsProvider credentialsProvider;


    private static volatile DatabaseAccess instance;
    private DatabaseAccess (Context context) {
        this.context =context;
        credentialsProvider = new CognitoCachingCredentialsProvider (context, COGNITO_POOL_ID, MY_REGION);
        dbClient = new AmazonDynamoDBClient(credentialsProvider);
        dbClient.setRegion(Region.getRegion(Regions.US_EAST_1));
        dbTable = Table.loadTable(dbClient, DYNAMODB_TABLE);
    }
    public static synchronized DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public Document getItem (String user_id){
        Document result = dbTable.getItem(new Primitive(credentialsProvider.getCachedIdentityId()), new Primitive(user_id));
        return result;
    }

    public List<Document> getAllItems(String usname) {
        return dbTable.query(new Primitive(usname)).getAllResults();
    }

    public Document addAllItems(String usname, String mon, String tue, String wed, String thu, String fri, String sat,
                                String sun, String fift, String twtfive, String thtyfive, String frtyfive,
                                String muscle, String slm, String fit, String restor, String intensity, String waist, String arm,
                                String legs, String hip, String shoulder, String chest, String back,
                                String neck, String whole, String abdomen){
        Document item = new Document();

        item.put("username",usname);
        item.put("monday",mon);
        item.put("tuesday",tue);
        item.put("wednesday",wed);
        item.put("thursday",thu);
        item.put("friday",fri);
        item.put("saturday",sat);
        item.put("sunday",sun);
        item.put("fifteen",fift);
        item.put("twentyfive",twtfive);
        item.put("thirtifive",thtyfive);
        item.put("fortyfive",frtyfive);
        item.put("muscle",muscle);
        item.put("slim",slm);
        item.put("fit",fit);
        item.put("restoration",restor);
        item.put("intensity",intensity);
        item.put("waist",waist);
        item.put("arm",arm);
        item.put("legs",legs);
        item.put("hip",hip);
        item.put("shoulder",shoulder);
        item.put("chest",chest);
        item.put("back",back);
        item.put("neck",neck);
        item.put("whole",whole);
        item.put("abdomen",abdomen);

        dbTable.putItem(item);

        return item;
    }

}